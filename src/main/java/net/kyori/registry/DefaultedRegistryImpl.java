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
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * A simple implementation of a registry with a default key and value.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class DefaultedRegistryImpl<K, V> extends RegistryImpl<K, V> implements DefaultedRegistry<K, V> {
  private final K defaultKey;
  private @MonotonicNonNull V defaultValue;

  public DefaultedRegistryImpl(final @NonNull K defaultKey) {
    this.defaultKey = defaultKey;
  }

  public DefaultedRegistryImpl(final @NonNegative int expectedSize, final @NonNull K defaultKey) {
    super(expectedSize);
    this.defaultKey = defaultKey;
  }

  @Override
  public @NonNull K defaultKey() {
    return this.defaultKey;
  }

  @Override
  public @NonNull V getOrDefault(final @NonNull K key) {
    final @Nullable V value = this.get(key);
    return value != null ? value : this.defaultValue;
  }

  @Override
  public void register0(@NonNull final K key, @NonNull final V value) {
    super.register0(key, value);

    if(this.defaultKey.equals(key)) {
      this.defaultValue = value;
    }
  }
}
