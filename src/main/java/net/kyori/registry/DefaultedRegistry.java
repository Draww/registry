/*
 * This file is part of registry, licensed under the MIT License.
 *
 * Copyright (c) 2018 KyoriPowered
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.kyori.registry;

import org.checkerframework.checker.index.qual.NonNegative;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * A registry with a default key and value.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public interface DefaultedRegistry<K, V> extends DefaultedRegistryGetter<K, V>, Registry<K, V> {
  /**
   * Creates a new bidirectional registry with a default key.
   *
   * @param defaultKey the default key
   * @param <K> the key type
   * @param <V> the value type
   * @return a new bidirectional registry
   */
  static <K, V> @NonNull DefaultedRegistry<K, V> create(final @NonNull K defaultKey) {
    return new DefaultedRegistryImpl<>(defaultKey);
  }

  /**
   * Creates a new bidirectional registry with a default key.
   *
   * @param expectedSize the expected size
   * @param defaultKey the default key
   * @param <K> the key type
   * @param <V> the value type
   * @return a new registry
   */
  static <K, V> @NonNull DefaultedRegistry<K, V> create(final @NonNegative int expectedSize, final @NonNull K defaultKey) {
    return new DefaultedRegistryImpl<>(expectedSize, defaultKey);
  }
}
