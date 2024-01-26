package seed.python.generated;

import seed.python.core.PythonGrammar;
import seed.python.core.PythonScript;

public final class Numpy extends PythonScript {

    /**
     * Add documentation to an existing object, typically one defined in C
     * 
     * The purpose is to allow easier editing of the docstrings without requiring
     * a re-compile. This exists primarily for internal use within numpy itself.
     * <p>
     * <em>Notes:</em><br>
     * This routine never raises an error if the docstring can't be written, but
     * will raise an error if the object being documented does not exist.
     * 
     * This routine cannot modify read-only docstrings, as appear
     * in new-style classes or built-in functions. Because this
     * routine never raises an error the caller must check manually
     * that the docstrings were changed.
     * 
     * Since this function grabs the ``char *`` from a c-level str object and puts
     * it into the ``tp_doc`` slot of the type of `obj`, it violates a number of
     * C-API best-practices, by:
     * 
     * - modifying a `PyTypeObject` after calling `PyType_Ready`
     * - calling `Py_INCREF` on the str and losing the reference, so the str
     * will never be released
     * 
     * If possible it should be avoided.
     * 
     * @param place str<br>
     *              The absolute name of the module to import from
     * @param obj str<br>
     *            The name of the object to add documentation to, typically a class or
     *            function name
     * @param doc &#123;str, Tuple[str, str], List[Tuple[str, str]]&#125;<br>
     *            If a string, the documentation to apply to `obj`
     *            
     *            If a tuple, then the first element is interpreted as an attribute of
     *            `obj` and the second as the docstring to apply - ``(method, docstring)``
     *            
     *            If a list, then each element of the list should be a tuple of length
     *            two - ``[(method1, docstring1), (method2, docstring2), ...]``
     * @param warn_on_python bool<br>
     *                       If True, the default, emit `UserWarning` if this is used to attach
     *                       documentation to a pure-python object.
     */
    public final Object add_newdoc(Object place, Object obj, Object doc, Object... args) {
        write("np.add_newdoc("+PythonGrammar.toPythonArgs(place),PythonGrammar.toPythonArgs(obj),PythonGrammar.toPythonArgs(doc)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the length of the first dimension of the input array.
     * 
     * .. deprecated:: 1.18
     * `numpy.alen` is deprecated, use `len` instead.
     * 
     * @param a array_like<br>
     *          Input array.
     * 
     * @return alen int<br>
     *              Length of the first dimension of `a`.
     */
    public final Object alen(Object a) {
        write("np.alen("+PythonGrammar.toPythonArgs(a)+")");
        return null;
    }

    /**
     * Test whether all array elements along a given axis evaluate to True.
     * <p>
     * <em>Notes:</em><br>
     * Not a Number (NaN), positive infinity and negative infinity
     * evaluate to `True` because these are not equal to zero.
     * 
     * @param a array_like<br>
     *          Input array or object that can be converted to an array.
     * @param axis None or int or tuple of ints, optional<br>
     *             Axis or axes along which a logical AND reduction is performed.
     *             The default (``axis=None``) is to perform a logical AND over all
     *             the dimensions of the input array. `axis` may be negative, in
     *             which case it counts from the last to the first axis.
     *             
     *             .. versionadded:: 1.7.0
     *             
     *             If this is a tuple of ints, a reduction is performed on multiple
     *             axes, instead of a single axis or all the axes as before.
     * @param out ndarray, optional<br>
     *            Alternate output array in which to place the result.
     *            It must have the same shape as the expected output and its
     *            type is preserved (e.g., if ``dtype(out)`` is float, the result
     *            will consist of 0.0's and 1.0's). See :ref:`ufuncs-output-type` for more
     *            details.
     *            
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left
     *                 in the result as dimensions with size one. With this option,
     *                 the result will broadcast correctly against the input array.
     *                 
     *                 If the default value is passed, then `keepdims` will not be
     *                 passed through to the `all` method of sub-classes of
     *                 `ndarray`, however any non-default value will be.  If the
     *                 sub-class' method does not implement `keepdims` any
     *                 exceptions will be raised.
     *                 
     * @param where array_like of bool, optional<br>
     *              Elements to include in checking for all `True` values.
     *              See `~numpy.ufunc.reduce` for details.
     *              
     *              .. versionadded:: 1.20.0
     * 
     * @return all ndarray, bool<br>
     *             A new boolean or array is returned unless `out` is specified,
     *             in which case a reference to `out` is returned.
     */
    public final Object all(Object a, Object... args) {
        write("np.all("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Returns True if two arrays are element-wise equal within a tolerance.
     * 
     * The tolerance values are positive, typically very small numbers.  The
     * relative difference (`rtol` * abs(`b`)) and the absolute difference
     * `atol` are added together to compare against the absolute difference
     * between `a` and `b`.
     * 
     * NaNs are treated as equal if they are in the same place and if
     * ``equal_nan=True``.  Infs are treated as equal if they are in the same
     * place and of the same sign in both arrays.
     * <p>
     * <em>Notes:</em><br>
     * If the following equation is element-wise True, then allclose returns
     * True.
     * 
     * absolute(`a` - `b`) <= (`atol` + `rtol` * absolute(`b`))
     * 
     * The above equation is not symmetric in `a` and `b`, so that
     * ``allclose(a, b)`` might be different from ``allclose(b, a)`` in
     * some rare cases.
     * 
     * The comparison of `a` and `b` uses standard broadcasting, which
     * means that `a` and `b` need not have the same shape in order for
     * ``allclose(a, b)`` to evaluate to True.  The same is true for
     * `equal` but not `array_equal`.
     * 
     * `allclose` is not defined for non-numeric data types.
     * 
     * @param a array_like<br>
     *          Input arrays to compare.
     * @param b array_like<br>
     *          Input arrays to compare.
     * @param rtol float<br>
     *             The relative tolerance parameter (see Notes).
     * @param atol float<br>
     *             The absolute tolerance parameter (see Notes).
     * @param equal_nan bool<br>
     *                  Whether to compare NaN's as equal.  If True, NaN's in `a` will be
     *                  considered equal to NaN's in `b` in the output array.
     *                  
     *                  .. versionadded:: 1.10.0
     * 
     * @return allclose bool<br>
     *                  Returns True if the two arrays are equal within the given
     *                  tolerance; False otherwise.
     */
    public final Object allclose(Object a, Object b, Object... args) {
        write("np.allclose("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(b)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Check if all elements of input array are true.
     * 
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     */
    public final Object alltrue(Object... args) {
        write("np.alltrue("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the maximum of an array or maximum along an axis.
     * <p>
     * <em>Notes:</em><br>
     * NaN values are propagated, that is if at least one item is NaN, the
     * corresponding max value will be NaN as well. To ignore NaN values
     * (MATLAB behavior), please use nanmax.
     * 
     * Don't use `amax` for element-wise comparison of 2 arrays; when
     * ``a.shape[0]`` is 2, ``maximum(a[0], a[1])`` is faster than
     * ``amax(a, axis=0)``.
     * 
     * @param a array_like<br>
     *          Input data.
     * @param axis None or int or tuple of ints, optional<br>
     *             Axis or axes along which to operate.  By default, flattened input is
     *             used.
     *             
     *             .. versionadded:: 1.7.0
     *             
     *             If this is a tuple of ints, the maximum is selected over multiple axes,
     *             instead of a single axis or all the axes as before.
     * @param out ndarray, optional<br>
     *            Alternative output array in which to place the result.  Must
     *            be of the same shape and buffer length as the expected output.
     *            See :ref:`ufuncs-output-type` for more details.
     *            
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left
     *                 in the result as dimensions with size one. With this option,
     *                 the result will broadcast correctly against the input array.
     *                 
     *                 If the default value is passed, then `keepdims` will not be
     *                 passed through to the `amax` method of sub-classes of
     *                 `ndarray`, however any non-default value will be.  If the
     *                 sub-class' method does not implement `keepdims` any
     *                 exceptions will be raised.
     *                 
     * @param initial scalar, optional<br>
     *                The minimum value of an output element. Must be present to allow
     *                computation on empty slice. See `~numpy.ufunc.reduce` for details.
     *                
     *                .. versionadded:: 1.15.0
     *                
     * @param where array_like of bool, optional<br>
     *              Elements to compare for the maximum. See `~numpy.ufunc.reduce`
     *              for details.
     *              
     *              .. versionadded:: 1.17.0
     * 
     * @return amax ndarray or scalar<br>
     *              Maximum of `a`. If `axis` is None, the result is a scalar value.
     *              If `axis` is given, the result is an array of dimension
     *              ``a.ndim - 1``.
     */
    public final Object amax(Object a, Object... args) {
        write("np.amax("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the minimum of an array or minimum along an axis.
     * <p>
     * <em>Notes:</em><br>
     * NaN values are propagated, that is if at least one item is NaN, the
     * corresponding min value will be NaN as well. To ignore NaN values
     * (MATLAB behavior), please use nanmin.
     * 
     * Don't use `amin` for element-wise comparison of 2 arrays; when
     * ``a.shape[0]`` is 2, ``minimum(a[0], a[1])`` is faster than
     * ``amin(a, axis=0)``.
     * 
     * @param a array_like<br>
     *          Input data.
     * @param axis None or int or tuple of ints, optional<br>
     *             Axis or axes along which to operate.  By default, flattened input is
     *             used.
     *             
     *             .. versionadded:: 1.7.0
     *             
     *             If this is a tuple of ints, the minimum is selected over multiple axes,
     *             instead of a single axis or all the axes as before.
     * @param out ndarray, optional<br>
     *            Alternative output array in which to place the result.  Must
     *            be of the same shape and buffer length as the expected output.
     *            See :ref:`ufuncs-output-type` for more details.
     *            
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left
     *                 in the result as dimensions with size one. With this option,
     *                 the result will broadcast correctly against the input array.
     *                 
     *                 If the default value is passed, then `keepdims` will not be
     *                 passed through to the `amin` method of sub-classes of
     *                 `ndarray`, however any non-default value will be.  If the
     *                 sub-class' method does not implement `keepdims` any
     *                 exceptions will be raised.
     *                 
     * @param initial scalar, optional<br>
     *                The maximum value of an output element. Must be present to allow
     *                computation on empty slice. See `~numpy.ufunc.reduce` for details.
     *                
     *                .. versionadded:: 1.15.0
     *                
     * @param where array_like of bool, optional<br>
     *              Elements to compare for the minimum. See `~numpy.ufunc.reduce`
     *              for details.
     *              
     *              .. versionadded:: 1.17.0
     * 
     * @return amin ndarray or scalar<br>
     *              Minimum of `a`. If `axis` is None, the result is a scalar value.
     *              If `axis` is given, the result is an array of dimension
     *              ``a.ndim - 1``.
     */
    public final Object amin(Object a, Object... args) {
        write("np.amin("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the angle of the complex argument.
     * <p>
     * <em>Notes:</em><br>
     * Although the angle of the complex number 0 is undefined, ``numpy.angle(0)``
     * returns the value 0.
     * 
     * @param z array_like<br>
     *          A complex number or sequence of complex numbers.
     * @param deg bool, optional<br>
     *            Return angle in degrees if True, radians if False (default).
     * 
     * @return angle ndarray or scalar<br>
     *               The counterclockwise angle from the positive real axis on the complex
     *               plane in the range ``(-pi, pi]``, with dtype as numpy.float64.
     *               
     *               .. versionchanged:: 1.16.0
     *               This function works on subclasses of ndarray like `ma.array`.
     */
    public final Object angle(Object z, Object... args) {
        write("np.angle("+PythonGrammar.toPythonArgs(z)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Test whether any array element along a given axis evaluates to True.
     * 
     * Returns single boolean unless `axis` is not ``None``
     * <p>
     * <em>Notes:</em><br>
     * Not a Number (NaN), positive infinity and negative infinity evaluate
     * to `True` because these are not equal to zero.
     * 
     * @param a array_like<br>
     *          Input array or object that can be converted to an array.
     * @param axis None or int or tuple of ints, optional<br>
     *             Axis or axes along which a logical OR reduction is performed.
     *             The default (``axis=None``) is to perform a logical OR over all
     *             the dimensions of the input array. `axis` may be negative, in
     *             which case it counts from the last to the first axis.
     *             
     *             .. versionadded:: 1.7.0
     *             
     *             If this is a tuple of ints, a reduction is performed on multiple
     *             axes, instead of a single axis or all the axes as before.
     * @param out ndarray, optional<br>
     *            Alternate output array in which to place the result.  It must have
     *            the same shape as the expected output and its type is preserved
     *            (e.g., if it is of type float, then it will remain so, returning
     *            1.0 for True and 0.0 for False, regardless of the type of `a`).
     *            See :ref:`ufuncs-output-type` for more details.
     *            
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left
     *                 in the result as dimensions with size one. With this option,
     *                 the result will broadcast correctly against the input array.
     *                 
     *                 If the default value is passed, then `keepdims` will not be
     *                 passed through to the `any` method of sub-classes of
     *                 `ndarray`, however any non-default value will be.  If the
     *                 sub-class' method does not implement `keepdims` any
     *                 exceptions will be raised.
     *                 
     * @param where array_like of bool, optional<br>
     *              Elements to include in checking for any `True` values.
     *              See `~numpy.ufunc.reduce` for details.
     *              
     *              .. versionadded:: 1.20.0
     * 
     * @return any bool or ndarray<br>
     *             A new boolean or `ndarray` is returned unless `out` is specified,
     *             in which case a reference to `out` is returned.
     */
    public final Object any(Object a, Object... args) {
        write("np.any("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Append values to the end of an array.
     * 
     * @param arr array_like<br>
     *            Values are appended to a copy of this array.
     * @param values array_like<br>
     *               These values are appended to a copy of `arr`.  It must be of the
     *               correct shape (the same shape as `arr`, excluding `axis`).  If
     *               `axis` is not specified, `values` can be any shape and will be
     *               flattened before use.
     * @param axis int, optional<br>
     *             The axis along which `values` are appended.  If `axis` is not
     *             given, both `arr` and `values` are flattened before use.
     * 
     * @return append ndarray<br>
     *                A copy of `arr` with `values` appended to `axis`.  Note that
     *                `append` does not occur in-place: a new array is allocated and
     *                filled.  If `axis` is None, `out` is a flattened array.
     */
    public final Object append(Object arr, Object values, Object... args) {
        write("np.append("+PythonGrammar.toPythonArgs(arr),PythonGrammar.toPythonArgs(values)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Apply a function to 1-D slices along the given axis.
     * 
     * Execute `func1d(a, *args, **kwargs)` where `func1d` operates on 1-D arrays
     * and `a` is a 1-D slice of `arr` along `axis`.
     * 
     * This is equivalent to (but faster than) the following use of `ndindex` and
     * `s_`, which sets each of ``ii``, ``jj``, and ``kk`` to a tuple of indices::
     * 
     * Ni, Nk = a.shape[:axis], a.shape[axis+1:]
     * for ii in ndindex(Ni):
     * for kk in ndindex(Nk):
     * f = func1d(arr[ii + s_[:,] + kk])
     * Nj = f.shape
     * for jj in ndindex(Nj):
     * out[ii + jj + kk] = f[jj]
     * 
     * Equivalently, eliminating the inner loop, this can be expressed as::
     * 
     * Ni, Nk = a.shape[:axis], a.shape[axis+1:]
     * for ii in ndindex(Ni):
     * for kk in ndindex(Nk):
     * out[ii + s_[...,] + kk] = func1d(arr[ii + s_[:,] + kk])
     * 
     * @param func1d function (M,) -&gt; (Nj...)<br>
     *               This function should accept 1-D arrays. It is applied to 1-D
     *               slices of `arr` along the specified axis.
     * @param axis integer<br>
     *             Axis along which `arr` is sliced.
     * @param arr ndarray (Ni..., M, Nk...)<br>
     *            Input array.
     * @param args any<br>
     *             Additional arguments to `func1d`.
     * @param kwargs any<br>
     *               Additional named arguments to `func1d`.
     *               
     *               .. versionadded:: 1.9.0
     * 
     * @return out ndarray  (Ni..., Nj..., Nk...)<br>
     *             The output array. The shape of `out` is identical to the shape of
     *             `arr`, except along the `axis` dimension. This axis is removed, and
     *             replaced with new dimensions equal to the shape of the return value
     *             of `func1d`. So if `func1d` returns a scalar `out` will have one
     *             fewer dimensions than `arr`.
     */
    public final Object apply_along_axis(Object func1d, Object axis, Object arr, Object args, Object... args) {
        write("np.apply_along_axis("+PythonGrammar.toPythonArgs(func1d),PythonGrammar.toPythonArgs(axis),PythonGrammar.toPythonArgs(arr),PythonGrammar.toPythonArgs(args)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Apply a function repeatedly over multiple axes.
     * 
     * `func` is called as `res = func(a, axis)`, where `axis` is the first
     * element of `axes`.  The result `res` of the function call must have
     * either the same dimensions as `a` or one less dimension.  If `res`
     * has one less dimension than `a`, a dimension is inserted before
     * `axis`.  The call to `func` is then repeated for each axis in `axes`,
     * with `res` as the first argument.
     * <p>
     * <em>Notes:</em><br>
     * This function is equivalent to tuple axis arguments to reorderable ufuncs
     * with keepdims=True. Tuple axis arguments to ufuncs have been available since
     * version 1.7.0.
     * 
     * @param func function<br>
     *             This function must take two arguments, `func(a, axis)`.
     * @param a array_like<br>
     *          Input array.
     * @param axes array_like<br>
     *             Axes over which `func` is applied; the elements must be integers.
     * 
     * @return apply_over_axis ndarray<br>
     *                         The output array.  The number of dimensions is the same as `a`,
     *                         but the shape can be different.  This depends on whether `func`
     *                         changes the shape of its output with respect to its input.
     */
    public final Object apply_over_axes(Object func, Object a, Object axes) {
        write("np.apply_over_axes("+PythonGrammar.toPythonArgs(func),PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(axes)+")");
        return null;
    }

    /**
     * Returns the indices of the maximum values along an axis.
     * <p>
     * <em>Notes:</em><br>
     * In case of multiple occurrences of the maximum values, the indices
     * corresponding to the first occurrence are returned.
     * 
     * @param a array_like<br>
     *          Input array.
     * @param axis int, optional<br>
     *             By default, the index is into the flattened array, otherwise
     *             along the specified axis.
     * @param out array, optional<br>
     *            If provided, the result will be inserted into this array. It should
     *            be of the appropriate shape and dtype.
     * 
     * @return index_array ndarray of ints<br>
     *                     Array of indices into the array. It has the same shape as `a.shape`
     *                     with the dimension along `axis` removed.
     */
    public final Object argmax(Object a, Object... args) {
        write("np.argmax("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Returns the indices of the minimum values along an axis.
     * <p>
     * <em>Notes:</em><br>
     * In case of multiple occurrences of the minimum values, the indices
     * corresponding to the first occurrence are returned.
     * 
     * @param a array_like<br>
     *          Input array.
     * @param axis int, optional<br>
     *             By default, the index is into the flattened array, otherwise
     *             along the specified axis.
     * @param out array, optional<br>
     *            If provided, the result will be inserted into this array. It should
     *            be of the appropriate shape and dtype.
     * 
     * @return index_array ndarray of ints<br>
     *                     Array of indices into the array. It has the same shape as `a.shape`
     *                     with the dimension along `axis` removed.
     */
    public final Object argmin(Object a, Object... args) {
        write("np.argmin("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Perform an indirect partition along the given axis using the
     * algorithm specified by the `kind` keyword. It returns an array of
     * indices of the same shape as `a` that index data along the given
     * axis in partitioned order.
     * 
     * .. versionadded:: 1.8.0
     * <p>
     * <em>Notes:</em><br>
     * See `partition` for notes on the different selection algorithms.
     * 
     * @param a array_like<br>
     *          Array to sort.
     * @param kth int or sequence of ints<br>
     *            Element index to partition by. The k-th element will be in its
     *            final sorted position and all smaller elements will be moved
     *            before it and all larger elements behind it. The order all
     *            elements in the partitions is undefined. If provided with a
     *            sequence of k-th it will partition all of them into their sorted
     *            position at once.
     * @param axis int or None, optional<br>
     *             Axis along which to sort. The default is -1 (the last axis). If
     *             None, the flattened array is used.
     * @param kind &#123;'introselect'&#125;, optional<br>
     *             Selection algorithm. Default is 'introselect'
     * @param order str or list of str, optional<br>
     *              When `a` is an array with fields defined, this argument
     *              specifies which fields to compare first, second, etc. A single
     *              field can be specified as a string, and not all fields need be
     *              specified, but unspecified fields will still be used, in the
     *              order in which they come up in the dtype, to break ties.
     * 
     * @return index_array ndarray, int<br>
     *                     Array of indices that partition `a` along the specified axis.
     *                     If `a` is one-dimensional, ``a[index_array]`` yields a partitioned `a`.
     *                     More generally, ``np.take_along_axis(a, index_array, axis=a)`` always
     *                     yields the partitioned `a`, irrespective of dimensionality.
     */
    public final Object argpartition(Object a, Object kth, Object... args) {
        write("np.argpartition("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(kth)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Returns the indices that would sort an array.
     * 
     * Perform an indirect sort along the given axis using the algorithm specified
     * by the `kind` keyword. It returns an array of indices of the same shape as
     * `a` that index data along the given axis in sorted order.
     * <p>
     * <em>Notes:</em><br>
     * See `sort` for notes on the different sorting algorithms.
     * 
     * As of NumPy 1.4.0 `argsort` works with real/complex arrays containing
     * nan values. The enhanced sort order is documented in `sort`.
     * 
     * @param a array_like<br>
     *          Array to sort.
     * @param axis int or None, optional<br>
     *             Axis along which to sort.  The default is -1 (the last axis). If None,
     *             the flattened array is used.
     * @param kind &#123;'quicksort', 'mergesort', 'heapsort', 'stable'&#125;, optional<br>
     *             Sorting algorithm. The default is 'quicksort'. Note that both 'stable'
     *             and 'mergesort' use timsort under the covers and, in general, the
     *             actual implementation will vary with data type. The 'mergesort' option
     *             is retained for backwards compatibility.
     *             
     *             .. versionchanged:: 1.15.0.
     *             The 'stable' option was added.
     * @param order str or list of str, optional<br>
     *              When `a` is an array with fields defined, this argument specifies
     *              which fields to compare first, second, etc.  A single field can
     *              be specified as a string, and not all fields need be specified,
     *              but unspecified fields will still be used, in the order in which
     *              they come up in the dtype, to break ties.
     * 
     * @return index_array ndarray, int<br>
     *                     Array of indices that sort `a` along the specified `axis`.
     *                     If `a` is one-dimensional, ``a[index_array]`` yields a sorted `a`.
     *                     More generally, ``np.take_along_axis(a, index_array, axis=axis)``
     *                     always yields the sorted `a`, irrespective of dimensionality.
     */
    public final Object argsort(Object a, Object... args) {
        write("np.argsort("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find the indices of array elements that are non-zero, grouped by element.
     * <p>
     * <em>Notes:</em><br>
     * ``np.argwhere(a)`` is almost the same as ``np.transpose(np.nonzero(a))``,
     * but produces a result of the correct shape for a 0D array.
     * 
     * The output of ``argwhere`` is not suitable for indexing arrays.
     * For this purpose use ``nonzero(a)`` instead.
     * 
     * @param a array_like<br>
     *          Input data.
     * 
     * @return index_array (N, a.ndim) ndarray<br>
     *                     Indices of elements that are non-zero. Indices are grouped by element.
     *                     This array will have shape ``(N, a.ndim)`` where ``N`` is the number of
     *                     non-zero items.
     */
    public final Object argwhere(Object a) {
        write("np.argwhere("+PythonGrammar.toPythonArgs(a)+")");
        return null;
    }

    /**
     * Evenly round to the given number of decimals.
     * <p>
     * <em>Notes:</em><br>
     * For values exactly halfway between rounded decimal values, NumPy
     * rounds to the nearest even value. Thus 1.5 and 2.5 round to 2.0,
     * -0.5 and 0.5 round to 0.0, etc.
     * 
     * ``np.around`` uses a fast but sometimes inexact algorithm to round
     * floating-point datatypes. For positive `decimals` it is equivalent to
     * ``np.true_divide(np.rint(a * 10**decimals), 10**decimals)``, which has
     * error due to the inexact representation of decimal fractions in the IEEE
     * floating point standard [1]_ and errors introduced when scaling by powers
     * of ten. For instance, note the extra "1" in the following:
     * 
     * >>> np.round(56294995342131.5, 3)
     * 56294995342131.51
     * 
     * If your goal is to print such values with a fixed number of decimals, it is
     * preferable to use numpy's float printing routines to limit the number of
     * printed decimals:
     * 
     * >>> np.format_float_positional(56294995342131.5, precision=3)
     * '56294995342131.5'
     * 
     * The float printing routines use an accurate but much more computationally
     * demanding algorithm to compute the number of digits after the decimal
     * point.
     * 
     * Alternatively, Python's builtin `round` function uses a more accurate
     * but slower algorithm for 64-bit floating point values:
     * 
     * >>> round(56294995342131.5, 3)
     * 56294995342131.5
     * >>> np.round(16.055, 2), round(16.055, 2)  # equals 16.0549999999999997
     * (16.06, 16.05)
     * 
     * @param a array_like<br>
     *          Input data.
     * @param decimals int, optional<br>
     *                 Number of decimal places to round to (default: 0).  If
     *                 decimals is negative, it specifies the number of positions to
     *                 the left of the decimal point.
     * @param out ndarray, optional<br>
     *            Alternative output array in which to place the result. It must have
     *            the same shape as the expected output, but the type of the output
     *            values will be cast if necessary. See :ref:`ufuncs-output-type` for more
     *            details.
     * 
     * @return rounded_array ndarray<br>
     *                       An array of the same type as `a`, containing the rounded values.
     *                       Unless `out` was specified, a new array is created.  A reference to
     *                       the result is returned.
     *                       
     *                       The real and imaginary parts of complex numbers are rounded
     *                       separately.  The result of rounding a float is a float.
     */
    public final Object around(Object a, Object... args) {
        write("np.around("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return a string representation of an array.
     * <p>
     * <em>Notes:</em><br>
     * If a formatter is specified for a certain type, the `precision` keyword is
     * ignored for that type.
     * 
     * This is a very flexible function; `array_repr` and `array_str` are using
     * `array2string` internally so keywords with the same name should work
     * identically in all three functions.
     * 
     * @param a ndarray<br>
     *          Input array.
     * @param max_line_width int, optional<br>
     *                       Inserts newlines if text is longer than `max_line_width`.
     *                       Defaults to ``numpy.get_printoptions()['linewidth']``.
     * @param precision int or None, optional<br>
     *                  Floating point precision.
     *                  Defaults to ``numpy.get_printoptions()['precision']``.
     * @param suppress_small bool, optional<br>
     *                       Represent numbers "very close" to zero as zero; default is False.
     *                       Very close is defined by precision: if the precision is 8, e.g.,
     *                       numbers smaller (in absolute value) than 5e-9 are represented as
     *                       zero.
     *                       Defaults to ``numpy.get_printoptions()['suppress']``.
     * @param separator str, optional<br>
     *                  Inserted between elements.
     * @param prefix str, optional<br>
     * @param suffix str, optional<br>
     *               The length of the prefix and suffix strings are used to respectively
     *               align and wrap the output. An array is typically printed as::
     *               
     *               prefix + array2string(a) + suffix
     *               
     *               The output is left-padded by the length of the prefix string, and
     *               wrapping is forced at the column ``max_line_width - len(suffix)``.
     *               It should be noted that the content of prefix and suffix strings are
     *               not included in the output.
     * @param style _NoValue, optional<br>
     *              Has no effect, do not use.
     *              
     *              .. deprecated:: 1.14.0
     * @param formatter dict of callables, optional<br>
     *                  If not None, the keys should indicate the type(s) that the respective
     *                  formatting function applies to.  Callables should return a string.
     *                  Types that are not specified (by their corresponding keys) are handled
     *                  by the default formatters.  Individual types for which a formatter
     *                  can be set are:
     *                  
     *                  - 'bool'
     *                  - 'int'
     *                  - 'timedelta' : a `numpy.timedelta64`
     *                  - 'datetime' : a `numpy.datetime64`
     *                  - 'float'
     *                  - 'longfloat' : 128-bit floats
     *                  - 'complexfloat'
     *                  - 'longcomplexfloat' : composed of two 128-bit floats
     *                  - 'void' : type `numpy.void`
     *                  - 'numpystr' : types `numpy.string_` and `numpy.unicode_`
     *                  
     *                  Other keys that can be used to set a group of types at once are:
     *                  
     *                  - 'all' : sets all types
     *                  - 'int_kind' : sets 'int'
     *                  - 'float_kind' : sets 'float' and 'longfloat'
     *                  - 'complex_kind' : sets 'complexfloat' and 'longcomplexfloat'
     *                  - 'str_kind' : sets 'numpystr'
     * @param threshold int, optional<br>
     *                  Total number of array elements which trigger summarization
     *                  rather than full repr.
     *                  Defaults to ``numpy.get_printoptions()['threshold']``.
     * @param edgeitems int, optional<br>
     *                  Number of array items in summary at beginning and end of
     *                  each dimension.
     *                  Defaults to ``numpy.get_printoptions()['edgeitems']``.
     * @param sign string, either '-', '+', or ' ', optional<br>
     *             Controls printing of the sign of floating-point types. If '+', always
     *             print the sign of positive values. If ' ', always prints a space
     *             (whitespace character) in the sign position of positive values.  If
     *             '-', omit the sign character of positive values.
     *             Defaults to ``numpy.get_printoptions()['sign']``.
     * @param floatmode str, optional<br>
     *                  Controls the interpretation of the `precision` option for
     *                  floating-point types.
     *                  Defaults to ``numpy.get_printoptions()['floatmode']``.
     *                  Can take the following values:
     *                  
     *                  - 'fixed': Always print exactly `precision` fractional digits,
     *                  even if this would print more or fewer digits than
     *                  necessary to specify the value uniquely.
     *                  - 'unique': Print the minimum number of fractional digits necessary
     *                  to represent each value uniquely. Different elements may
     *                  have a different number of digits.  The value of the
     *                  `precision` option is ignored.
     *                  - 'maxprec': Print at most `precision` fractional digits, but if
     *                  an element can be uniquely represented with fewer digits
     *                  only print it with that many.
     *                  - 'maxprec_equal': Print at most `precision` fractional digits,
     *                  but if every element in the array can be uniquely
     *                  represented with an equal number of fewer digits, use that
     *                  many digits for all elements.
     * @param legacy string or `False`, optional<br>
     *               If set to the string `'1.13'` enables 1.13 legacy printing mode. This
     *               approximates numpy 1.13 print output by including a space in the sign
     *               position of floats and different behavior for 0d arrays. If set to
     *               `False`, disables legacy mode. Unrecognized strings will be ignored
     *               with a warning for forward compatibility.
     *               
     *               .. versionadded:: 1.14.0
     * 
     * @return array_str str<br>
     *                   String representation of the array.
     */
    public final Object array2string(Object a, Object... args) {
        write("np.array2string("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * True if two arrays have the same shape and elements, False otherwise.
     * 
     * @param a1 array_like<br>
     *           Input arrays.
     * @param a2 array_like<br>
     *           Input arrays.
     * @param equal_nan bool<br>
     *                  Whether to compare NaN's as equal. If the dtype of a1 and a2 is
     *                  complex, values will be considered equal if either the real or the
     *                  imaginary component of a given value is ``nan``.
     *                  
     *                  .. versionadded:: 1.19.0
     * 
     * @return b bool<br>
     *           Returns True if the arrays are equal.
     */
    public final Object array_equal(Object a1, Object a2, Object... args) {
        write("np.array_equal("+PythonGrammar.toPythonArgs(a1),PythonGrammar.toPythonArgs(a2)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Returns True if input arrays are shape consistent and all elements equal.
     * 
     * Shape consistent means they are either the same shape, or one input array
     * can be broadcasted to create the same shape as the other one.
     * 
     * @param a1 array_like<br>
     *           Input arrays.
     * @param a2 array_like<br>
     *           Input arrays.
     * 
     * @return out bool<br>
     *             True if equivalent, False otherwise.
     */
    public final Object array_equiv(Object a1, Object a2) {
        write("np.array_equiv("+PythonGrammar.toPythonArgs(a1),PythonGrammar.toPythonArgs(a2)+")");
        return null;
    }

    /**
     * Return the string representation of an array.
     * 
     * @param arr ndarray<br>
     *            Input array.
     * @param max_line_width int, optional<br>
     *                       Inserts newlines if text is longer than `max_line_width`.
     *                       Defaults to ``numpy.get_printoptions()['linewidth']``.
     * @param precision int, optional<br>
     *                  Floating point precision.
     *                  Defaults to ``numpy.get_printoptions()['precision']``.
     * @param suppress_small bool, optional<br>
     *                       Represent numbers "very close" to zero as zero; default is False.
     *                       Very close is defined by precision: if the precision is 8, e.g.,
     *                       numbers smaller (in absolute value) than 5e-9 are represented as
     *                       zero.
     *                       Defaults to ``numpy.get_printoptions()['suppress']``.
     * 
     * @return string str<br>
     *                The string representation of an array.
     */
    public final Object array_repr(Object arr, Object... args) {
        write("np.array_repr("+PythonGrammar.toPythonArgs(arr)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Split an array into multiple sub-arrays.
     * 
     * Please refer to the ``split`` documentation.  The only difference
     * between these functions is that ``array_split`` allows
     * `indices_or_sections` to be an integer that does *not* equally
     * divide the axis. For an array of length l that should be split
     * into n sections, it returns l % n sub-arrays of size l//n + 1
     * and the rest of size l//n.
     * 
     * @param ary n/a<br>undocumented
     * @param indices_or_sections n/a<br>undocumented
     * @param axis n/a<br>undocumented
     */
    public final Object array_split(Object... args) {
        write("np.array_split("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return a string representation of the data in an array.
     * 
     * The data in the array is returned as a single string.  This function is
     * similar to `array_repr`, the difference being that `array_repr` also
     * returns information on the kind of array and its data type.
     * 
     * @param a ndarray<br>
     *          Input array.
     * @param max_line_width int, optional<br>
     *                       Inserts newlines if text is longer than `max_line_width`.
     *                       Defaults to ``numpy.get_printoptions()['linewidth']``.
     * @param precision int, optional<br>
     *                  Floating point precision.
     *                  Defaults to ``numpy.get_printoptions()['precision']``.
     * @param suppress_small bool, optional<br>
     *                       Represent numbers "very close" to zero as zero; default is False.
     *                       Very close is defined by precision: if the precision is 8, e.g.,
     *                       numbers smaller (in absolute value) than 5e-9 are represented as
     *                       zero.
     *                       Defaults to ``numpy.get_printoptions()['suppress']``.
     */
    public final Object array_str(Object a, Object... args) {
        write("np.array_str("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Convert the input to an array, checking for NaNs or Infs.
     * 
     * @param a array_like<br>
     *          Input data, in any form that can be converted to an array.  This
     *          includes lists, lists of tuples, tuples, tuples of tuples, tuples
     *          of lists and ndarrays.  Success requires no NaNs or Infs.
     * @param dtype data-type, optional<br>
     *              By default, the data-type is inferred from the input data.
     * @param order &#123;'C', 'F', 'A', 'K'&#125;, optional<br>
     *              Memory layout.  'A' and 'K' depend on the order of input array a.
     *              'C' row-major (C-style),
     *              'F' column-major (Fortran-style) memory representation.
     *              'A' (any) means 'F' if `a` is Fortran contiguous, 'C' otherwise
     *              'K' (keep) preserve input order
     *              Defaults to 'C'.
     * 
     * @return out ndarray<br>
     *             Array interpretation of `a`.  No copy is performed if the input
     *             is already an ndarray.  If `a` is a subclass of ndarray, a base
     *             class ndarray is returned.
     */
    public final Object asarray_chkfinite(Object a, Object... args) {
        write("np.asarray_chkfinite("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return an array converted to a float type.
     * 
     * @param a array_like<br>
     *          The input array.
     * @param dtype str or dtype object, optional<br>
     *              Float type code to coerce input array `a`.  If `dtype` is one of the
     *              'int' dtypes, it is replaced with float64.
     * 
     * @return out ndarray<br>
     *             The input `a` as a float ndarray.
     */
    public final Object asfarray(Object a, Object... args) {
        write("np.asfarray("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Interpret the input as a matrix.
     * 
     * Unlike `matrix`, `asmatrix` does not make a copy if the input is already
     * a matrix or an ndarray.  Equivalent to ``matrix(data, copy=False)``.
     * 
     * @param data array_like<br>
     *             Input data.
     * @param dtype data-type<br>
     *              Data-type of the output matrix.
     * 
     * @return mat matrix<br>
     *             `data` interpreted as a matrix.
     */
    public final Object asmatrix(Object data, Object... args) {
        write("np.asmatrix("+PythonGrammar.toPythonArgs(data)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Convert an array of size 1 to its scalar equivalent.
     * 
     * .. deprecated:: 1.16
     * 
     * Deprecated, use `numpy.ndarray.item()` instead.
     * 
     * @param a ndarray<br>
     *          Input array of size 1.
     * 
     * @return out scalar<br>
     *             Scalar representation of `a`. The output data type is the same type
     *             returned by the input's `item` method.
     */
    public final Object asscalar(Object a) {
        write("np.asscalar("+PythonGrammar.toPythonArgs(a)+")");
        return null;
    }

    /**
     * Convert inputs to arrays with at least one dimension.
     * 
     * Scalar inputs are converted to 1-dimensional arrays, whilst
     * higher-dimensional inputs are preserved.
     * 
     * @param arys1 array_like<br>
     *              One or more input arrays.
     * @param arys2 array_like<br>
     *              One or more input arrays.
     * @param ... array_like<br>
     *            One or more input arrays.
     * @param *arys n/a<br>undocumented
     * 
     * @return ret ndarray<br>
     *             An array, or list of arrays, each with ``a.ndim &gt;= 1``.
     *             Copies are made only if necessary.
     */
    public final Object atleast_1d(Object... args) {
        write("np.atleast_1d("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * View inputs as arrays with at least two dimensions.
     * 
     * @param arys1 array_like<br>
     *              One or more array-like sequences.  Non-array inputs are converted
     *              to arrays.  Arrays that already have two or more dimensions are
     *              preserved.
     * @param arys2 array_like<br>
     *              One or more array-like sequences.  Non-array inputs are converted
     *              to arrays.  Arrays that already have two or more dimensions are
     *              preserved.
     * @param ... array_like<br>
     *            One or more array-like sequences.  Non-array inputs are converted
     *            to arrays.  Arrays that already have two or more dimensions are
     *            preserved.
     * @param *arys n/a<br>undocumented
     * 
     * @return (res,res2,...) (ndarray,ndarray,ndarray)<br>
     *          An array, or list of arrays, each with ``a.ndim &gt;= 2``.
     *          Copies are avoided where possible, and views with two or more
     *          dimensions are returned.
     *          
     *          An array, or list of arrays, each with ``a.ndim &gt;= 2``.
     *          Copies are avoided where possible, and views with two or more
     *          dimensions are returned.
     *          
     *          An array, or list of arrays, each with ``a.ndim &gt;= 2``.
     *          Copies are avoided where possible, and views with two or more
     *          dimensions are returned.
     */
    public final Object atleast_2d(Object... args) {
        write("np.atleast_2d("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * View inputs as arrays with at least three dimensions.
     * 
     * @param arys1 array_like<br>
     *              One or more array-like sequences.  Non-array inputs are converted to
     *              arrays.  Arrays that already have three or more dimensions are
     *              preserved.
     * @param arys2 array_like<br>
     *              One or more array-like sequences.  Non-array inputs are converted to
     *              arrays.  Arrays that already have three or more dimensions are
     *              preserved.
     * @param ... array_like<br>
     *            One or more array-like sequences.  Non-array inputs are converted to
     *            arrays.  Arrays that already have three or more dimensions are
     *            preserved.
     * @param *arys n/a<br>undocumented
     * 
     * @return (res1,res2,...) (ndarray,ndarray,ndarray)<br>
     *          An array, or list of arrays, each with ``a.ndim &gt;= 3``.  Copies are
     *          avoided where possible, and views with three or more dimensions are
     *          returned.  For example, a 1-D array of shape ``(N,)`` becomes a view
     *          of shape ``(1, N, 1)``, and a 2-D array of shape ``(M, N)`` becomes a
     *          view of shape ``(M, N, 1)``.
     *          
     *          An array, or list of arrays, each with ``a.ndim &gt;= 3``.  Copies are
     *          avoided where possible, and views with three or more dimensions are
     *          returned.  For example, a 1-D array of shape ``(N,)`` becomes a view
     *          of shape ``(1, N, 1)``, and a 2-D array of shape ``(M, N)`` becomes a
     *          view of shape ``(M, N, 1)``.
     *          
     *          An array, or list of arrays, each with ``a.ndim &gt;= 3``.  Copies are
     *          avoided where possible, and views with three or more dimensions are
     *          returned.  For example, a 1-D array of shape ``(N,)`` becomes a view
     *          of shape ``(1, N, 1)``, and a 2-D array of shape ``(M, N)`` becomes a
     *          view of shape ``(M, N, 1)``.
     */
    public final Object atleast_3d(Object... args) {
        write("np.atleast_3d("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Compute the weighted average along the specified axis.
     * 
     * @param a array_like<br>
     *          Array containing data to be averaged. If `a` is not an array, a
     *          conversion is attempted.
     * @param axis None or int or tuple of ints, optional<br>
     *             Axis or axes along which to average `a`.  The default,
     *             axis=None, will average over all of the elements of the input array.
     *             If axis is negative it counts from the last to the first axis.
     *             
     *             .. versionadded:: 1.7.0
     *             
     *             If axis is a tuple of ints, averaging is performed on all of the axes
     *             specified in the tuple instead of a single axis or all the axes as
     *             before.
     * @param weights array_like, optional<br>
     *                An array of weights associated with the values in `a`. Each value in
     *                `a` contributes to the average according to its associated weight.
     *                The weights array can either be 1-D (in which case its length must be
     *                the size of `a` along the given axis) or of the same shape as `a`.
     *                If `weights=None`, then all data in `a` are assumed to have a
     *                weight equal to one.  The 1-D calculation is::
     *                
     *                avg = sum(a * weights) / sum(weights)
     *                
     *                The only constraint on `weights` is that `sum(weights)` must not be 0.
     * @param returned bool, optional<br>
     *                 Default is `False`. If `True`, the tuple (`average`, `sum_of_weights`)
     *                 is returned, otherwise only the average is returned.
     *                 If `weights=None`, `sum_of_weights` is equivalent to the number of
     *                 elements over which the average is taken.
     * 
     * @return (retval,[sum_of_weights]) (array_type or double,array_type or double)<br>
     *          Return the average along the specified axis. When `returned` is `True`,
     *          return a tuple with the average as the first element and the sum
     *          of the weights as the second element. `sum_of_weights` is of the
     *          same type as `retval`. The result dtype follows a genereal pattern.
     *          If `weights` is None, the result dtype will be that of `a` , or ``float64``
     *          if `a` is integral. Otherwise, if `weights` is not None and `a` is non-
     *          integral, the result type will be the type of lowest precision capable of
     *          representing values of both `a` and `weights`. If `a` happens to be
     *          integral, the previous rules still applies but the result dtype will
     *          at least be ``float64``.
     *          
     *          Return the average along the specified axis. When `returned` is `True`,
     *          return a tuple with the average as the first element and the sum
     *          of the weights as the second element. `sum_of_weights` is of the
     *          same type as `retval`. The result dtype follows a genereal pattern.
     *          If `weights` is None, the result dtype will be that of `a` , or ``float64``
     *          if `a` is integral. Otherwise, if `weights` is not None and `a` is non-
     *          integral, the result type will be the type of lowest precision capable of
     *          representing values of both `a` and `weights`. If `a` happens to be
     *          integral, the previous rules still applies but the result dtype will
     *          at least be ``float64``.
     */
    public final Object average(Object a, Object... args) {
        write("np.average("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the Bartlett window.
     * 
     * The Bartlett window is very similar to a triangular window, except
     * that the end points are at zero.  It is often used in signal
     * processing for tapering a signal, without generating too much
     * ripple in the frequency domain.
     * <p>
     * <em>Notes:</em><br>
     * The Bartlett window is defined as
     * 
     * .. math:: w(n) = \frac{2}{M-1} \left(
     * \frac{M-1}{2} - \left|n - \frac{M-1}{2}\right|
     * \right)
     * 
     * Most references to the Bartlett window come from the signal
     * processing literature, where it is used as one of many windowing
     * functions for smoothing values.  Note that convolution with this
     * window produces linear interpolation.  It is also known as an
     * apodization (which means"removing the foot", i.e. smoothing
     * discontinuities at the beginning and end of the sampled signal) or
     * tapering function. The fourier transform of the Bartlett is the product
     * of two sinc functions.
     * Note the excellent discussion in Kanasewich.
     * 
     * @param M int<br>
     *          Number of points in the output window. If zero or less, an
     *          empty array is returned.
     * 
     * @return out array<br>
     *             The triangular window, with the maximum value normalized to one
     *             (the value one appears only if the number of samples is odd), with
     *             the first and last samples equal to zero.
     */
    public final Object bartlett(Object M) {
        write("np.bartlett("+PythonGrammar.toPythonArgs(M)+")");
        return null;
    }

    /**
     * Return a string representation of a number in the given base system.
     * 
     * @param number int<br>
     *               The value to convert. Positive and negative values are handled.
     * @param base int, optional<br>
     *             Convert `number` to the `base` number system. The valid range is 2-36,
     *             the default value is 2.
     * @param padding int, optional<br>
     *                Number of zeros padded on the left. Default is 0 (no padding).
     * 
     * @return out str<br>
     *             String representation of `number` in `base` system.
     */
    public final Object base_repr(Object number, Object... args) {
        write("np.base_repr("+PythonGrammar.toPythonArgs(number)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the binary representation of the input number as a string.
     * 
     * For negative numbers, if width is not given, a minus sign is added to the
     * front. If width is given, the two's complement of the number is
     * returned, with respect to that width.
     * 
     * In a two's-complement system negative numbers are represented by the two's
     * complement of the absolute value. This is the most common method of
     * representing signed integers on computers [1]_. A N-bit two's-complement
     * system can represent every integer in the range
     * :math:`-2^{N-1}` to :math:`+2^{N-1}-1`.
     * <p>
     * <em>Notes:</em><br>
     * `binary_repr` is equivalent to using `base_repr` with base 2, but about 25x
     * faster.
     * 
     * @param num int<br>
     *            Only an integer decimal number can be used.
     * @param width int, optional<br>
     *              The length of the returned string if `num` is positive, or the length
     *              of the two's complement if `num` is negative, provided that `width` is
     *              at least a sufficient number of bits for `num` to be represented in the
     *              designated form.
     *              
     *              If the `width` value is insufficient, it will be ignored, and `num` will
     *              be returned in binary (`num` &gt; 0) or two's complement (`num` &lt; 0) form
     *              with its width equal to the minimum number of bits needed to represent
     *              the number in the designated form. This behavior is deprecated and will
     *              later raise an error.
     *              
     *              .. deprecated:: 1.12.0
     * 
     * @return bin str<br>
     *             Binary representation of `num` or two's complement of `num`.
     */
    public final Object binary_repr(Object num, Object... args) {
        write("np.binary_repr("+PythonGrammar.toPythonArgs(num)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * bincount(x, weights=None, minlength=0)
     * 
     * Count number of occurrences of each value in array of non-negative ints.
     * 
     * The number of bins (of size 1) is one larger than the largest value in
     * `x`. If `minlength` is specified, there will be at least this number
     * of bins in the output array (though it will be longer if necessary,
     * depending on the contents of `x`).
     * Each bin gives the number of occurrences of its index value in `x`.
     * If `weights` is specified the input array is weighted by it, i.e. if a
     * value ``n`` is found at position ``i``, ``out[n] += weight[i]`` instead
     * of ``out[n] += 1``.
     * 
     * @param x array_like, 1 dimension, nonnegative ints<br>
     *          Input array.
     * @param weights array_like, optional<br>
     *                Weights, array of the same shape as `x`.
     * @param minlength int, optional<br>
     *                  A minimum number of bins for the output array.
     *                  
     *                  .. versionadded:: 1.6.0
     * @param ... n/a<br>undocumented
     * 
     * @return out ndarray of ints<br>
     *             The result of binning the input array.
     *             The length of `out` is equal to ``np.amax(x)+1``.
     */
    public final Object bincount(Object... args) {
        write("np.bincount("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the Blackman window.
     * 
     * The Blackman window is a taper formed by using the first three
     * terms of a summation of cosines. It was designed to have close to the
     * minimal leakage possible.  It is close to optimal, only slightly worse
     * than a Kaiser window.
     * <p>
     * <em>Notes:</em><br>
     * The Blackman window is defined as
     * 
     * .. math::  w(n) = 0.42 - 0.5 \cos(2\pi n/M) + 0.08 \cos(4\pi n/M)
     * 
     * Most references to the Blackman window come from the signal processing
     * literature, where it is used as one of many windowing functions for
     * smoothing values.  It is also known as an apodization (which means
     * "removing the foot", i.e. smoothing discontinuities at the beginning
     * and end of the sampled signal) or tapering function. It is known as a
     * "near optimal" tapering function, almost as good (by some measures)
     * as the kaiser window.
     * 
     * @param M int<br>
     *          Number of points in the output window. If zero or less, an empty
     *          array is returned.
     * 
     * @return out ndarray<br>
     *             The window, with the maximum value normalized to one (the value one
     *             appears only if the number of samples is odd).
     */
    public final Object blackman(Object M) {
        write("np.blackman("+PythonGrammar.toPythonArgs(M)+")");
        return null;
    }

    /**
     * Assemble an nd-array from nested lists of blocks.
     * 
     * Blocks in the innermost lists are concatenated (see `concatenate`) along
     * the last dimension (-1), then these are concatenated along the
     * second-last dimension (-2), and so on until the outermost list is reached.
     * 
     * Blocks can be of any dimension, but will not be broadcasted using the normal
     * rules. Instead, leading axes of size 1 are inserted, to make ``block.ndim``
     * the same for all blocks. This is primarily useful for working with scalars,
     * and means that code like ``np.block([v, 1])`` is valid, where
     * ``v.ndim == 1``.
     * 
     * When the nested list is two levels deep, this allows block matrices to be
     * constructed from their components.
     * 
     * .. versionadded:: 1.13.0
     * <p>
     * <em>Notes:</em><br>
     * When called with only scalars, ``np.block`` is equivalent to an ndarray
     * call. So ``np.block([[1, 2], [3, 4]])`` is equivalent to
     * ``np.array([[1, 2], [3, 4]])``.
     * 
     * This function does not enforce that the blocks lie on a fixed grid.
     * ``np.block([[a, b], [c, d]])`` is not restricted to arrays of the form::
     * 
     * AAAbb
     * AAAbb
     * cccDD
     * 
     * But is also allowed to produce, for some ``a, b, c, d``::
     * 
     * AAAbb
     * AAAbb
     * cDDDD
     * 
     * Since concatenation happens along the last axis first, `block` is _not_
     * capable of producing the following directly::
     * 
     * AAAbb
     * cccbb
     * cccDD
     * 
     * Matlab's "square bracket stacking", ``[A, B, ...; p, q, ...]``, is
     * equivalent to ``np.block([[A, B, ...], [p, q, ...]])``.
     * 
     * @param arrays nested list of array_like or scalars (but not tuples)<br>
     *               If passed a single ndarray or scalar (a nested list of depth 0), this
     *               is returned unmodified (and not copied).
     *               
     *               Elements shapes must match along the appropriate axes (without
     *               broadcasting), but leading 1s will be prepended to the shape as
     *               necessary to make the dimensions match.
     * 
     * @return block_array ndarray<br>
     *                     The array assembled from the given blocks.
     *                     
     *                     The dimensionality of the output is equal to the greatest of:
     *                     * the dimensionality of all the inputs
     *                     * the depth to which the input list is nested
     */
    public final Object block(Object arrays) {
        write("np.block("+PythonGrammar.toPythonArgs(arrays)+")");
        return null;
    }

    /**
     * Build a matrix object from a string, nested sequence, or array.
     * 
     * @param obj str or array_like<br>
     *            Input data. If a string, variables in the current scope may be
     *            referenced by name.
     * @param ldict dict, optional<br>
     *              A dictionary that replaces local operands in current frame.
     *              Ignored if `obj` is not a string or `gdict` is None.
     * @param gdict dict, optional<br>
     *              A dictionary that replaces global operands in current frame.
     *              Ignored if `obj` is not a string.
     * 
     * @return out matrix<br>
     *             Returns a matrix object, which is a specialized 2-D array.
     */
    public final Object bmat(Object obj, Object... args) {
        write("np.bmat("+PythonGrammar.toPythonArgs(obj)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Broadcast any number of arrays against each other.
     * 
     * @param `*args` array_likes<br>
     *                The arrays to broadcast.
     *                
     * @param subok bool, optional<br>
     *              If True, then sub-classes will be passed-through, otherwise
     *              the returned arrays will be forced to be a base-class array (default).
     * @param *args n/a<br>undocumented
     * 
     * @return broadcasted list of arrays<br>
     *                     These arrays are views on the original arrays.  They are typically
     *                     not contiguous.  Furthermore, more than one element of a
     *                     broadcasted array may refer to a single memory location. If you need
     *                     to write to the arrays, make copies first. While you can set the
     *                     ``writable`` flag True, writing to a single output value may end up
     *                     changing more than one location in the output array.
     *                     
     *                     .. deprecated:: 1.17
     *                     The output is currently marked so that if written to, a deprecation
     *                     warning will be emitted. A future version will set the
     *                     ``writable`` flag False so writing to it will raise an error.
     */
    public final Object broadcast_arrays(Object... args) {
        write("np.broadcast_arrays("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Broadcast the input shapes into a single shape.
     * 
     * :ref:`Learn more about broadcasting here <basics.broadcasting>`.
     * 
     * .. versionadded:: 1.20.0
     * 
     * @param `*args` tuples of ints, or ints<br>
     *                The shapes to be broadcast against each other.
     * @param *args n/a<br>undocumented
     * 
     * @return tuple <br>
     *               Broadcasted shape.
     */
    public final Object broadcast_shapes(Object... args) {
        write("np.broadcast_shapes("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Broadcast an array to a new shape.
     * <p>
     * <em>Notes:</em><br>
     * .. versionadded:: 1.10.0
     * 
     * @param array array_like<br>
     *              The array to broadcast.
     * @param shape tuple<br>
     *              The shape of the desired array.
     * @param subok bool, optional<br>
     *              If True, then sub-classes will be passed-through, otherwise
     *              the returned array will be forced to be a base-class array (default).
     * 
     * @return broadcast array<br>
     *                   A readonly view on the original array with the given shape. It is
     *                   typically not contiguous. Furthermore, more than one element of a
     *                   broadcasted array may refer to a single memory location.
     */
    public final Object broadcast_to(Object array, Object shape, Object... args) {
        write("np.broadcast_to("+PythonGrammar.toPythonArgs(array),PythonGrammar.toPythonArgs(shape)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * busday_count(begindates, enddates, weekmask='1111100', holidays=[], busdaycal=None, out=None)
     * 
     * Counts the number of valid days between `begindates` and
     * `enddates`, not including the day of `enddates`.
     * 
     * If ``enddates`` specifies a date value that is earlier than the
     * corresponding ``begindates`` date value, the count will be negative.
     * 
     * .. versionadded:: 1.7.0
     * 
     * @param begindates array_like of datetime64[D]<br>
     *                   The array of the first dates for counting.
     * @param enddates array_like of datetime64[D]<br>
     *                 The array of the end dates for counting, which are excluded
     *                 from the count themselves.
     * @param weekmask str or array_like of bool, optional<br>
     *                 A seven-element array indicating which of Monday through Sunday are
     *                 valid days. May be specified as a length-seven list or array, like
     *                 [1,1,1,1,1,0,0]; a length-seven string, like '1111100'; or a string
     *                 like "Mon Tue Wed Thu Fri", made up of 3-character abbreviations for
     *                 weekdays, optionally separated by white space. Valid abbreviations
     *                 are: Mon Tue Wed Thu Fri Sat Sun
     * @param holidays array_like of datetime64[D], optional<br>
     *                 An array of dates to consider as invalid dates.  They may be
     *                 specified in any order, and NaT (not-a-time) dates are ignored.
     *                 This list is saved in a normalized form that is suited for
     *                 fast calculations of valid days.
     * @param busdaycal busdaycalendar, optional<br>
     *                  A `busdaycalendar` object which specifies the valid days. If this
     *                  parameter is provided, neither weekmask nor holidays may be
     *                  provided.
     * @param out array of int, optional<br>
     *            If provided, this array is filled with the result.
     * 
     * @return out array of int<br>
     *             An array with a shape from broadcasting ``begindates`` and ``enddates``
     *             together, containing the number of valid days between
     *             the begin and end dates.
     */
    public final Object busday_count(Object... args) {
        write("np.busday_count("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * busday_offset(dates, offsets, roll='raise', weekmask='1111100', holidays=None, busdaycal=None, out=None)
     * 
     * First adjusts the date to fall on a valid day according to
     * the ``roll`` rule, then applies offsets to the given dates
     * counted in valid days.
     * 
     * .. versionadded:: 1.7.0
     * 
     * @param dates array_like of datetime64[D]<br>
     *              The array of dates to process.
     * @param offsets array_like of int<br>
     *                The array of offsets, which is broadcast with ``dates``.
     * @param roll &#123;'raise', 'nat', 'forward', 'following', 'backward', 'preceding', 'modifiedfollowing', 'modifiedpreceding'&#125;, optional<br>
     *             How to treat dates that do not fall on a valid day. The default
     *             is 'raise'.
     *             
     *             * 'raise' means to raise an exception for an invalid day.
     *             * 'nat' means to return a NaT (not-a-time) for an invalid day.
     *             * 'forward' and 'following' mean to take the first valid day
     *             later in time.
     *             * 'backward' and 'preceding' mean to take the first valid day
     *             earlier in time.
     *             * 'modifiedfollowing' means to take the first valid day
     *             later in time unless it is across a Month boundary, in which
     *             case to take the first valid day earlier in time.
     *             * 'modifiedpreceding' means to take the first valid day
     *             earlier in time unless it is across a Month boundary, in which
     *             case to take the first valid day later in time.
     * @param weekmask str or array_like of bool, optional<br>
     *                 A seven-element array indicating which of Monday through Sunday are
     *                 valid days. May be specified as a length-seven list or array, like
     *                 [1,1,1,1,1,0,0]; a length-seven string, like '1111100'; or a string
     *                 like "Mon Tue Wed Thu Fri", made up of 3-character abbreviations for
     *                 weekdays, optionally separated by white space. Valid abbreviations
     *                 are: Mon Tue Wed Thu Fri Sat Sun
     * @param holidays array_like of datetime64[D], optional<br>
     *                 An array of dates to consider as invalid dates.  They may be
     *                 specified in any order, and NaT (not-a-time) dates are ignored.
     *                 This list is saved in a normalized form that is suited for
     *                 fast calculations of valid days.
     * @param busdaycal busdaycalendar, optional<br>
     *                  A `busdaycalendar` object which specifies the valid days. If this
     *                  parameter is provided, neither weekmask nor holidays may be
     *                  provided.
     * @param out array of datetime64[D], optional<br>
     *            If provided, this array is filled with the result.
     * 
     * @return out array of datetime64[D]<br>
     *             An array with a shape from broadcasting ``dates`` and ``offsets``
     *             together, containing the dates with offsets applied.
     */
    public final Object busday_offset(Object... args) {
        write("np.busday_offset("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Returns pointers to the end-points of an array.
     * 
     * @param a ndarray<br>
     *          Input array. It must conform to the Python-side of the array
     *          interface.
     * 
     * @return (low, high) tuple of 2 integers<br>
     *                     The first integer is the first byte of the array, the second
     *                     integer is just past the last byte of the array.  If `a` is not
     *                     contiguous it will not use every byte between the (`low`, `high`)
     *                     values.
     */
    public final Object byte_bounds(Object a) {
        write("np.byte_bounds("+PythonGrammar.toPythonArgs(a)+")");
        return null;
    }

    /**
     * can_cast(from_, to, casting='safe')
     * 
     * Returns True if cast between data types can occur according to the
     * casting rule.  If from is a scalar or array scalar, also returns
     * True if the scalar value can be cast without overflow or truncation
     * to an integer.
     * <p>
     * <em>Notes:</em><br>
     * .. versionchanged:: 1.17.0
     * Casting between a simple data type and a structured one is possible only
     * for "unsafe" casting.  Casting to multiple fields is allowed, but
     * casting from multiple fields is not.
     * 
     * .. versionchanged:: 1.9.0
     * Casting from numeric to string types in 'safe' casting mode requires
     * that the string dtype length is long enough to store the maximum
     * integer/float value converted.
     * 
     * @param from_ dtype, dtype specifier, scalar, or array<br>
     *              Data type, scalar, or array to cast from.
     * @param to dtype or dtype specifier<br>
     *           Data type to cast to.
     * @param casting &#123;'no', 'equiv', 'safe', 'same_kind', 'unsafe'&#125;, optional<br>
     *                Controls what kind of data casting may occur.
     *                
     *                * 'no' means the data types should not be cast at all.
     *                * 'equiv' means only byte-order changes are allowed.
     *                * 'safe' means only casts which can preserve values are allowed.
     *                * 'same_kind' means only safe casts or casts within a kind,
     *                like float64 to float32, are allowed.
     *                * 'unsafe' means any data conversions may be done.
     * @param ... n/a<br>undocumented
     * 
     * @return out bool<br>
     *             True if cast can occur according to the casting rule.
     */
    public final Object can_cast(Object... args) {
        write("np.can_cast("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Construct an array from an index array and a list of arrays to choose from.
     * 
     * First of all, if confused or uncertain, definitely look at the Examples -
     * in its full generality, this function is less simple than it might
     * seem from the following code description (below ndi =
     * `numpy.lib.index_tricks`):
     * 
     * ``np.choose(a,c) == np.array([c[a[I]][I] for I in ndi.ndindex(a.shape)])``.
     * 
     * But this omits some subtleties.  Here is a fully general summary:
     * 
     * Given an "index" array (`a`) of integers and a sequence of ``n`` arrays
     * (`choices`), `a` and each choice array are first broadcast, as necessary,
     * to arrays of a common shape; calling these *Ba* and *Bchoices[i], i =
     * 0,...,n-1* we have that, necessarily, ``Ba.shape == Bchoices[i].shape``
     * for each ``i``.  Then, a new array with shape ``Ba.shape`` is created as
     * follows:
     * 
     * * if ``mode='raise'`` (the default), then, first of all, each element of
     * ``a`` (and thus ``Ba``) must be in the range ``[0, n-1]``; now, suppose
     * that ``i`` (in that range) is the value at the ``(j0, j1, ..., jm)``
     * position in ``Ba`` - then the value at the same position in the new array
     * is the value in ``Bchoices[i]`` at that same position;
     * 
     * * if ``mode='wrap'``, values in `a` (and thus `Ba`) may be any (signed)
     * integer; modular arithmetic is used to map integers outside the range
     * `[0, n-1]` back into that range; and then the new array is constructed
     * as above;
     * 
     * * if ``mode='clip'``, values in `a` (and thus ``Ba``) may be any (signed)
     * integer; negative integers are mapped to 0; values greater than ``n-1``
     * are mapped to ``n-1``; and then the new array is constructed as above.
     * <p>
     * <em>Notes:</em><br>
     * To reduce the chance of misinterpretation, even though the following
     * "abuse" is nominally supported, `choices` should neither be, nor be
     * thought of as, a single array, i.e., the outermost sequence-like container
     * should be either a list or a tuple.
     * 
     * @param a int array<br>
     *          This array must contain integers in ``[0, n-1]``, where ``n`` is the
     *          number of choices, unless ``mode=wrap`` or ``mode=clip``, in which
     *          cases any integers are permissible.
     * @param choices sequence of arrays<br>
     *                Choice arrays. `a` and all of the choices must be broadcastable to the
     *                same shape.  If `choices` is itself an array (not recommended), then
     *                its outermost dimension (i.e., the one corresponding to
     *                ``choices.shape[0]``) is taken as defining the "sequence".
     * @param out array, optional<br>
     *            If provided, the result will be inserted into this array. It should
     *            be of the appropriate shape and dtype. Note that `out` is always
     *            buffered if ``mode='raise'``; use other modes for better performance.
     * @param mode &#123;'raise' (default), 'wrap', 'clip'&#125;, optional<br>
     *             Specifies how indices outside ``[0, n-1]`` will be treated:
     *             
     *             * 'raise' : an exception is raised
     *             * 'wrap' : value becomes value mod ``n``
     *             * 'clip' : values &lt; 0 are mapped to 0, values &gt; n-1 are mapped to n-1
     * 
     * @return merged_array array<br>
     *                      The merged result.
     */
    public final Object choose(Object a, Object choices, Object... args) {
        write("np.choose("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(choices)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Clip (limit) the values in an array.
     * 
     * Given an interval, values outside the interval are clipped to
     * the interval edges.  For example, if an interval of ``[0, 1]``
     * is specified, values smaller than 0 become 0, and values larger
     * than 1 become 1.
     * 
     * Equivalent to but faster than ``np.minimum(a_max, np.maximum(a, a_min))``.
     * 
     * No check is performed to ensure ``a_min < a_max``.
     * <p>
     * <em>Notes:</em><br>
     * When `a_min` is greater than `a_max`, `clip` returns an
     * array in which all values are equal to `a_max`,
     * as shown in the second example.
     * 
     * @param a array_like<br>
     *          Array containing elements to clip.
     * @param a_min array_like or None<br>
     *              Minimum and maximum value. If ``None``, clipping is not performed on
     *              the corresponding edge. Only one of `a_min` and `a_max` may be
     *              ``None``. Both are broadcast against `a`.
     * @param a_max array_like or None<br>
     *              Minimum and maximum value. If ``None``, clipping is not performed on
     *              the corresponding edge. Only one of `a_min` and `a_max` may be
     *              ``None``. Both are broadcast against `a`.
     * @param out ndarray, optional<br>
     *            The results will be placed in this array. It may be the input
     *            array for in-place clipping.  `out` must be of the right shape
     *            to hold the output.  Its type is preserved.
     * @param **kwargs <br>
     *                 For other keyword-only arguments, see the
     *                 :ref:`ufunc docs &lt;ufuncs.kwargs&gt;`.
     *                 
     *                 .. versionadded:: 1.17.0
     * 
     * @return clipped_array ndarray<br>
     *                       An array with the elements of `a`, but where values
     *                       &lt; `a_min` are replaced with `a_min`, and those &gt; `a_max`
     *                       with `a_max`.
     */
    public final Object clip(Object a, Object a_min, Object a_max, Object... args) {
        write("np.clip("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(a_min),PythonGrammar.toPythonArgs(a_max)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Stack 1-D arrays as columns into a 2-D array.
     * 
     * Take a sequence of 1-D arrays and stack them as columns
     * to make a single 2-D array. 2-D arrays are stacked as-is,
     * just like with `hstack`.  1-D arrays are turned into 2-D columns
     * first.
     * 
     * @param tup sequence of 1-D or 2-D arrays.<br>
     *            Arrays to stack. All of them must have the same first dimension.
     * 
     * @return stacked 2-D array<br>
     *                 The array formed by stacking the given arrays.
     */
    public final Object column_stack(Object tup) {
        write("np.column_stack("+PythonGrammar.toPythonArgs(tup)+")");
        return null;
    }

    /**
     * Return a scalar type which is common to the input arrays.
     * 
     * The return type will always be an inexact (i.e. floating point) scalar
     * type, even if all the arrays are integer arrays. If one of the inputs is
     * an integer array, the minimum precision type that is returned is a
     * 64-bit floating point dtype.
     * 
     * All input arrays except int64 and uint64 can be safely cast to the
     * returned dtype without loss of information.
     * 
     * @param array1 ndarrays<br>
     *               Input arrays.
     * @param array2 ndarrays<br>
     *               Input arrays.
     * @param ... ndarrays<br>
     *            Input arrays.
     * @param *arrays n/a<br>undocumented
     * 
     * @return out data type code<br>
     *             Data type code.
     */
    public final Object common_type(Object... args) {
        write("np.common_type("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return selected slices of an array along given axis.
     * 
     * When working along a given axis, a slice along that axis is returned in
     * `output` for each index where `condition` evaluates to True. When
     * working on a 1-D array, `compress` is equivalent to `extract`.
     * 
     * @param condition 1-D array of bools<br>
     *                  Array that selects which entries to return. If len(condition)
     *                  is less than the size of `a` along the given axis, then output is
     *                  truncated to the length of the condition array.
     * @param a array_like<br>
     *          Array from which to extract a part.
     * @param axis int, optional<br>
     *             Axis along which to take slices. If None (default), work on the
     *             flattened array.
     * @param out ndarray, optional<br>
     *            Output array.  Its type is preserved and it must be of the right
     *            shape to hold the output.
     * 
     * @return compressed_array ndarray<br>
     *                          A copy of `a` without the slices along axis for which `condition`
     *                          is false.
     */
    public final Object compress(Object condition, Object a, Object... args) {
        write("np.compress("+PythonGrammar.toPythonArgs(condition),PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * concatenate((a1, a2, ...), axis=0, out=None, dtype=None, casting="same_kind")
     * 
     * Join a sequence of arrays along an existing axis.
     * <p>
     * <em>Notes:</em><br>
     * When one or more of the arrays to be concatenated is a MaskedArray,
     * this function will return a MaskedArray object instead of an ndarray,
     * but the input masks are *not* preserved. In cases where a MaskedArray
     * is expected as input, use the ma.concatenate function from the masked
     * array module instead.
     * 
     * @param a1 sequence of array_like<br>
     *           The arrays must have the same shape, except in the dimension
     *           corresponding to `axis` (the first, by default).
     * @param a2 sequence of array_like<br>
     *           The arrays must have the same shape, except in the dimension
     *           corresponding to `axis` (the first, by default).
     * @param ... sequence of array_like<br>
     *            The arrays must have the same shape, except in the dimension
     *            corresponding to `axis` (the first, by default).
     * @param axis int, optional<br>
     *             The axis along which the arrays will be joined.  If axis is None,
     *             arrays are flattened before use.  Default is 0.
     * @param out ndarray, optional<br>
     *            If provided, the destination to place the result. The shape must be
     *            correct, matching that of what concatenate would have returned if no
     *            out argument were specified.
     * @param dtype str or dtype<br>
     *              If provided, the destination array will have this dtype. Cannot be
     *              provided together with `out`.
     *              
     *              .. versionadded:: 1.20.0
     *              
     * @param casting &#123;'no', 'equiv', 'safe', 'same_kind', 'unsafe'&#125;, optional<br>
     *                Controls what kind of data casting may occur. Defaults to 'same_kind'.
     *                
     *                .. versionadded:: 1.20.0
     * 
     * @return res ndarray<br>
     *             The concatenated array.
     */
    public final Object concatenate(Object ..., Object... args) {
        write("np.concatenate("+PythonGrammar.toPythonArgs(...)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Returns the discrete, linear convolution of two one-dimensional sequences.
     * 
     * The convolution operator is often seen in signal processing, where it
     * models the effect of a linear time-invariant system on a signal [1]_.  In
     * probability theory, the sum of two independent random variables is
     * distributed according to the convolution of their individual
     * distributions.
     * 
     * If `v` is longer than `a`, the arrays are swapped before computation.
     * <p>
     * <em>Notes:</em><br>
     * The discrete convolution operation is defined as
     * 
     * .. math:: (a * v)[n] = \sum_{m = -\infty}^{\infty} a[m] v[n - m]
     * 
     * It can be shown that a convolution :math:`x(t) * y(t)` in time/space
     * is equivalent to the multiplication :math:`X(f) Y(f)` in the Fourier
     * domain, after appropriate padding (padding is necessary to prevent
     * circular convolution).  Since multiplication is more efficient (faster)
     * than convolution, the function `scipy.signal.fftconvolve` exploits the
     * FFT to calculate the convolution of large data-sets.
     * 
     * @param a (N,) array_like<br>
     *          First one-dimensional input array.
     * @param v (M,) array_like<br>
     *          Second one-dimensional input array.
     * @param mode &#123;'full', 'valid', 'same'&#125;, optional<br>
     *             'full':
     *             By default, mode is 'full'.  This returns the convolution
     *             at each point of overlap, with an output shape of (N+M-1,). At
     *             the end-points of the convolution, the signals do not overlap
     *             completely, and boundary effects may be seen.
     *             
     *             'same':
     *             Mode 'same' returns output of length ``max(M, N)``.  Boundary
     *             effects are still visible.
     *             
     *             'valid':
     *             Mode 'valid' returns output of length
     *             ``max(M, N) - min(M, N) + 1``.  The convolution product is only given
     *             for points where the signals overlap completely.  Values outside
     *             the signal boundary have no effect.
     * 
     * @return out ndarray<br>
     *             Discrete, linear convolution of `a` and `v`.
     */
    public final Object convolve(Object a, Object v, Object... args) {
        write("np.convolve("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(v)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return an array copy of the given object.
     * <p>
     * <em>Notes:</em><br>
     * This is equivalent to:
     * 
     * >>> np.array(a, copy=True)  #doctest: +SKIP
     * 
     * @param a array_like<br>
     *          Input data.
     * @param order &#123;'C', 'F', 'A', 'K'&#125;, optional<br>
     *              Controls the memory layout of the copy. 'C' means C-order,
     *              'F' means F-order, 'A' means 'F' if `a` is Fortran contiguous,
     *              'C' otherwise. 'K' means match the layout of `a` as closely
     *              as possible. (Note that this function and :meth:`ndarray.copy` are very
     *              similar, but have different default values for their order=
     *              arguments.)
     * @param subok bool, optional<br>
     *              If True, then sub-classes will be passed-through, otherwise the
     *              returned array will be forced to be a base-class array (defaults to False).
     *              
     *              .. versionadded:: 1.19.0
     * 
     * @return arr ndarray<br>
     *             Array interpretation of `a`.
     */
    public final Object copy(Object a, Object... args) {
        write("np.copy("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * copyto(dst, src, casting='same_kind', where=True)
     * 
     * Copies values from one array to another, broadcasting as necessary.
     * 
     * Raises a TypeError if the `casting` rule is violated, and if
     * `where` is provided, it selects which elements to copy.
     * 
     * .. versionadded:: 1.7.0
     * 
     * @param dst ndarray<br>
     *            The array into which values are copied.
     * @param src array_like<br>
     *            The array from which values are copied.
     * @param casting &#123;'no', 'equiv', 'safe', 'same_kind', 'unsafe'&#125;, optional<br>
     *                Controls what kind of data casting may occur when copying.
     *                
     *                * 'no' means the data types should not be cast at all.
     *                * 'equiv' means only byte-order changes are allowed.
     *                * 'safe' means only casts which can preserve values are allowed.
     *                * 'same_kind' means only safe casts or casts within a kind,
     *                like float64 to float32, are allowed.
     *                * 'unsafe' means any data conversions may be done.
     * @param where array_like of bool, optional<br>
     *              A boolean array which is broadcasted to match the dimensions
     *              of `dst`, and selects elements to copy from `src` to `dst`
     *              wherever it contains the value True.
     */
    public final Object copyto(Object... args) {
        write("np.copyto("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return Pearson product-moment correlation coefficients.
     * 
     * Please refer to the documentation for `cov` for more detail.  The
     * relationship between the correlation coefficient matrix, `R`, and the
     * covariance matrix, `C`, is
     * 
     * .. math:: R_{ij} = \frac{ C_{ij} } { \sqrt{ C_{ii} * C_{jj} } }
     * 
     * The values of `R` are between -1 and 1, inclusive.
     * <p>
     * <em>Notes:</em><br>
     * Due to floating point rounding the resulting array may not be Hermitian,
     * the diagonal elements may not be 1, and the elements may not satisfy the
     * inequality abs(a) <= 1. The real and imaginary parts are clipped to the
     * interval [-1,  1] in an attempt to improve on that situation but is not
     * much help in the complex case.
     * 
     * This function accepts but discards arguments `bias` and `ddof`.  This is
     * for backwards compatibility with previous versions of this function.  These
     * arguments had no effect on the return values of the function and can be
     * safely ignored in this and previous versions of numpy.
     * 
     * @param x array_like<br>
     *          A 1-D or 2-D array containing multiple variables and observations.
     *          Each row of `x` represents a variable, and each column a single
     *          observation of all those variables. Also see `rowvar` below.
     * @param y array_like, optional<br>
     *          An additional set of variables and observations. `y` has the same
     *          shape as `x`.
     * @param rowvar bool, optional<br>
     *               If `rowvar` is True (default), then each row represents a
     *               variable, with observations in the columns. Otherwise, the relationship
     *               is transposed: each column represents a variable, while the rows
     *               contain observations.
     * @param bias _NoValue, optional<br>
     *             Has no effect, do not use.
     *             
     *             .. deprecated:: 1.10.0
     * @param ddof _NoValue, optional<br>
     *             Has no effect, do not use.
     *             
     *             .. deprecated:: 1.10.0
     * @param dtype data-type, optional<br>
     *              Data-type of the result. By default, the return data-type will have
     *              at least `numpy.float64` precision.
     *              
     *              .. versionadded:: 1.20
     * 
     * @return R ndarray<br>
     *           The correlation coefficient matrix of the variables.
     */
    public final Object corrcoef(Object x, Object... args) {
        write("np.corrcoef("+PythonGrammar.toPythonArgs(x)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Cross-correlation of two 1-dimensional sequences.
     * 
     * This function computes the correlation as generally defined in signal
     * processing texts::
     * 
     * c_{av}[k] = sum_n a[n+k] * conj(v[n])
     * 
     * with a and v sequences being zero-padded where necessary and conj being
     * the conjugate.
     * <p>
     * <em>Notes:</em><br>
     * The definition of correlation above is not unique and sometimes correlation
     * may be defined differently. Another common definition is::
     * 
     * c'_{av}[k] = sum_n a[n] conj(v[n+k])
     * 
     * which is related to ``c_{av}[k]`` by ``c'_{av}[k] = c_{av}[-k]``.
     * 
     * `numpy.correlate` may perform slowly in large arrays (i.e. n = 1e5) because it does
     * not use the FFT to compute the convolution; in that case, `scipy.signal.correlate` might
     * be preferable.
     * 
     * @param a array_like<br>
     *          Input sequences.
     * @param v array_like<br>
     *          Input sequences.
     * @param mode &#123;'valid', 'same', 'full'&#125;, optional<br>
     *             Refer to the `convolve` docstring.  Note that the default
     *             is 'valid', unlike `convolve`, which uses 'full'.
     * @param old_behavior bool<br>
     *                     `old_behavior` was removed in NumPy 1.10. If you need the old
     *                     behavior, use `multiarray.correlate`.
     * 
     * @return out ndarray<br>
     *             Discrete cross-correlation of `a` and `v`.
     */
    public final Object correlate(Object a, Object v, Object... args) {
        write("np.correlate("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(v)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Counts the number of non-zero values in the array ``a``.
     * 
     * The word "non-zero" is in reference to the Python 2.x
     * built-in method ``__nonzero__()`` (renamed ``__bool__()``
     * in Python 3.x) of Python objects that tests an object's
     * "truthfulness". For example, any number is considered
     * truthful if it is nonzero, whereas any string is considered
     * truthful if it is not the empty string. Thus, this function
     * (recursively) counts how many elements in ``a`` (and in
     * sub-arrays thereof) have their ``__nonzero__()`` or ``__bool__()``
     * method evaluated to ``True``.
     * 
     * @param a array_like<br>
     *          The array for which to count non-zeros.
     * @param axis int or tuple, optional<br>
     *             Axis or tuple of axes along which to count non-zeros.
     *             Default is None, meaning that non-zeros will be counted
     *             along a flattened version of ``a``.
     *             
     *             .. versionadded:: 1.12.0
     *             
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes that are counted are left
     *                 in the result as dimensions with size one. With this option,
     *                 the result will broadcast correctly against the input array.
     *                 
     *                 .. versionadded:: 1.19.0
     * 
     * @return count int or array of int<br>
     *               Number of non-zero values in the array along a given axis.
     *               Otherwise, the total number of non-zero values in the array
     *               is returned.
     */
    public final Object count_nonzero(Object a, Object... args) {
        write("np.count_nonzero("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Estimate a covariance matrix, given data and weights.
     * 
     * Covariance indicates the level to which two variables vary together.
     * If we examine N-dimensional samples, :math:`X = [x_1, x_2, ... x_N]^T`,
     * then the covariance matrix element :math:`C_{ij}` is the covariance of
     * :math:`x_i` and :math:`x_j`. The element :math:`C_{ii}` is the variance
     * of :math:`x_i`.
     * 
     * See the notes for an outline of the algorithm.
     * <p>
     * <em>Notes:</em><br>
     * Assume that the observations are in the columns of the observation
     * array `m` and let ``f = fweights`` and ``a = aweights`` for brevity. The
     * steps to compute the weighted covariance are as follows::
     * 
     * >>> m = np.arange(10, dtype=np.float64)
     * >>> f = np.arange(10) * 2
     * >>> a = np.arange(10) ** 2.
     * >>> ddof = 1
     * >>> w = f * a
     * >>> v1 = np.sum(w)
     * >>> v2 = np.sum(w * a)
     * >>> m -= np.sum(m * w, axis=None, keepdims=True) / v1
     * >>> cov = np.dot(m * w, m.T) * v1 / (v1**2 - ddof * v2)
     * 
     * Note that when ``a == 1``, the normalization factor
     * ``v1 / (v1**2 - ddof * v2)`` goes over to ``1 / (np.sum(f) - ddof)``
     * as it should.
     * 
     * @param m array_like<br>
     *          A 1-D or 2-D array containing multiple variables and observations.
     *          Each row of `m` represents a variable, and each column a single
     *          observation of all those variables. Also see `rowvar` below.
     * @param y array_like, optional<br>
     *          An additional set of variables and observations. `y` has the same form
     *          as that of `m`.
     * @param rowvar bool, optional<br>
     *               If `rowvar` is True (default), then each row represents a
     *               variable, with observations in the columns. Otherwise, the relationship
     *               is transposed: each column represents a variable, while the rows
     *               contain observations.
     * @param bias bool, optional<br>
     *             Default normalization (False) is by ``(N - 1)``, where ``N`` is the
     *             number of observations given (unbiased estimate). If `bias` is True,
     *             then normalization is by ``N``. These values can be overridden by using
     *             the keyword ``ddof`` in numpy versions &gt;= 1.5.
     * @param ddof int, optional<br>
     *             If not ``None`` the default value implied by `bias` is overridden.
     *             Note that ``ddof=1`` will return the unbiased estimate, even if both
     *             `fweights` and `aweights` are specified, and ``ddof=0`` will return
     *             the simple average. See the notes for the details. The default value
     *             is ``None``.
     *             
     *             .. versionadded:: 1.5
     * @param fweights array_like, int, optional<br>
     *                 1-D array of integer frequency weights; the number of times each
     *                 observation vector should be repeated.
     *                 
     *                 .. versionadded:: 1.10
     * @param aweights array_like, optional<br>
     *                 1-D array of observation vector weights. These relative weights are
     *                 typically large for observations considered "important" and smaller for
     *                 observations considered less "important". If ``ddof=0`` the array of
     *                 weights can be used to assign probabilities to observation vectors.
     *                 
     *                 .. versionadded:: 1.10
     * @param dtype data-type, optional<br>
     *              Data-type of the result. By default, the return data-type will have
     *              at least `numpy.float64` precision.
     *              
     *              .. versionadded:: 1.20
     * 
     * @return out ndarray<br>
     *             The covariance matrix of the variables.
     */
    public final Object cov(Object m, Object... args) {
        write("np.cov("+PythonGrammar.toPythonArgs(m)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the cross product of two (arrays of) vectors.
     * 
     * The cross product of `a` and `b` in :math:`R^3` is a vector perpendicular
     * to both `a` and `b`.  If `a` and `b` are arrays of vectors, the vectors
     * are defined by the last axis of `a` and `b` by default, and these axes
     * can have dimensions 2 or 3.  Where the dimension of either `a` or `b` is
     * 2, the third component of the input vector is assumed to be zero and the
     * cross product calculated accordingly.  In cases where both input vectors
     * have dimension 2, the z-component of the cross product is returned.
     * <p>
     * <em>Notes:</em><br>
     * .. versionadded:: 1.9.0
     * 
     * Supports full broadcasting of the inputs.
     * 
     * @param a array_like<br>
     *          Components of the first vector(s).
     * @param b array_like<br>
     *          Components of the second vector(s).
     * @param axisa int, optional<br>
     *              Axis of `a` that defines the vector(s).  By default, the last axis.
     * @param axisb int, optional<br>
     *              Axis of `b` that defines the vector(s).  By default, the last axis.
     * @param axisc int, optional<br>
     *              Axis of `c` containing the cross product vector(s).  Ignored if
     *              both input vectors have dimension 2, as the return is scalar.
     *              By default, the last axis.
     * @param axis int, optional<br>
     *             If defined, the axis of `a`, `b` and `c` that defines the vector(s)
     *             and cross product(s).  Overrides `axisa`, `axisb` and `axisc`.
     * 
     * @return c ndarray<br>
     *           Vector cross product(s).
     */
    public final Object cross(Object a, Object b, Object... args) {
        write("np.cross("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(b)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the cumulative product of elements along a given axis.
     * <p>
     * <em>Notes:</em><br>
     * Arithmetic is modular when using integer types, and no error is
     * raised on overflow.
     * 
     * @param a array_like<br>
     *          Input array.
     * @param axis int, optional<br>
     *             Axis along which the cumulative product is computed.  By default
     *             the input is flattened.
     * @param dtype dtype, optional<br>
     *              Type of the returned array, as well as of the accumulator in which
     *              the elements are multiplied.  If *dtype* is not specified, it
     *              defaults to the dtype of `a`, unless `a` has an integer dtype with
     *              a precision less than that of the default platform integer.  In
     *              that case, the default platform integer is used instead.
     * @param out ndarray, optional<br>
     *            Alternative output array in which to place the result. It must
     *            have the same shape and buffer length as the expected output
     *            but the type of the resulting values will be cast if necessary.
     * 
     * @return cumprod ndarray<br>
     *                 A new array holding the result is returned unless `out` is
     *                 specified, in which case a reference to out is returned.
     */
    public final Object cumprod(Object a, Object... args) {
        write("np.cumprod("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the cumulative product over the given axis.
     * 
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     */
    public final Object cumproduct(Object... args) {
        write("np.cumproduct("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the cumulative sum of the elements along a given axis.
     * <p>
     * <em>Notes:</em><br>
     * Arithmetic is modular when using integer types, and no error is
     * raised on overflow.
     * 
     * ``cumsum(a)[-1]`` may not be equal to ``sum(a)`` for floating-point
     * values since ``sum`` may use a pairwise summation routine, reducing
     * the roundoff-error. See `sum` for more information.
     * 
     * @param a array_like<br>
     *          Input array.
     * @param axis int, optional<br>
     *             Axis along which the cumulative sum is computed. The default
     *             (None) is to compute the cumsum over the flattened array.
     * @param dtype dtype, optional<br>
     *              Type of the returned array and of the accumulator in which the
     *              elements are summed.  If `dtype` is not specified, it defaults
     *              to the dtype of `a`, unless `a` has an integer dtype with a
     *              precision less than that of the default platform integer.  In
     *              that case, the default platform integer is used.
     * @param out ndarray, optional<br>
     *            Alternative output array in which to place the result. It must
     *            have the same shape and buffer length as the expected output
     *            but the type will be cast if necessary. See :ref:`ufuncs-output-type` for
     *            more details.
     * 
     * @return cumsum_along_axis ndarray.<br>
     *                           A new array holding the result is returned unless `out` is
     *                           specified, in which case a reference to `out` is returned. The
     *                           result has the same size as `a`, and the same shape as `a` if
     *                           `axis` is not None or `a` is a 1-d array.
     */
    public final Object cumsum(Object a, Object... args) {
        write("np.cumsum("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * datetime_as_string(arr, unit=None, timezone='naive', casting='same_kind')
     * 
     * Convert an array of datetimes into an array of strings.
     * 
     * @param arr array_like of datetime64<br>
     *            The array of UTC timestamps to format.
     * @param unit str<br>
     *             One of None, 'auto', or a :ref:`datetime unit &lt;arrays.dtypes.dateunits&gt;`.
     * @param timezone &#123;'naive', 'UTC', 'local'&#125; or tzinfo<br>
     *                 Timezone information to use when displaying the datetime. If 'UTC', end
     *                 with a Z to indicate UTC time. If 'local', convert to the local timezone
     *                 first, and suffix with a +-#### timezone offset. If a tzinfo object,
     *                 then do as with 'local', but use the specified timezone.
     * @param casting &#123;'no', 'equiv', 'safe', 'same_kind', 'unsafe'&#125;<br>
     *                Casting to allow when changing between datetime units.
     * 
     * @return str_arr ndarray<br>
     *                 An array of strings the same shape as `arr`.
     */
    public final Object datetime_as_string(Object... args) {
        write("np.datetime_as_string("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return a new array with sub-arrays along an axis deleted. For a one
     * dimensional array, this returns those entries not returned by
     * `arr[obj]`.
     * <p>
     * <em>Notes:</em><br>
     * Often it is preferable to use a boolean mask. For example:
     * 
     * >>> arr = np.arange(12) + 1
     * >>> mask = np.ones(len(arr), dtype=bool)
     * >>> mask[[0,2,4]] = False
     * >>> result = arr[mask,...]
     * 
     * Is equivalent to `np.delete(arr, [0,2,4], axis=0)`, but allows further
     * use of `mask`.
     * 
     * @param arr array_like<br>
     *            Input array.
     * @param obj slice, int or array of ints<br>
     *            Indicate indices of sub-arrays to remove along the specified axis.
     *            
     *            .. versionchanged:: 1.19.0
     *            Boolean indices are now treated as a mask of elements to remove,
     *            rather than being cast to the integers 0 and 1.
     *            
     * @param axis int, optional<br>
     *             The axis along which to delete the subarray defined by `obj`.
     *             If `axis` is None, `obj` is applied to the flattened array.
     * 
     * @return out ndarray<br>
     *             A copy of `arr` with the elements specified by `obj` removed. Note
     *             that `delete` does not occur in-place. If `axis` is None, `out` is
     *             a flattened array.
     */
    public final Object delete(Object arr, Object obj, Object... args) {
        write("np.delete("+PythonGrammar.toPythonArgs(arr),PythonGrammar.toPythonArgs(obj)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Issues a DeprecationWarning, adds warning to `old_name`'s
     * docstring, rebinds ``old_name.__name__`` and returns the new
     * function object.
     * 
     * This function may also be used as a decorator.
     * 
     * @param func function<br>
     *             The function to be deprecated.
     * @param old_name str, optional<br>
     *                 The name of the function to be deprecated. Default is None, in
     *                 which case the name of `func` is used.
     * @param new_name str, optional<br>
     *                 The new name for the function. Default is None, in which case the
     *                 deprecation message is that `old_name` is deprecated. If given, the
     *                 deprecation message is that `old_name` is deprecated and `new_name`
     *                 should be used instead.
     * @param message str, optional<br>
     *                Additional explanation of the deprecation.  Displayed in the
     *                docstring after the warning.
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     * 
     * @return old_func function<br>
     *                  The deprecated function.
     */
    public final Object deprecate(Object... args) {
        write("np.deprecate("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Deprecates a function and includes the deprecation in its docstring.
     * 
     * This function is used as a decorator. It returns an object that can be
     * used to issue a DeprecationWarning, by passing the to-be decorated
     * function as argument, this adds warning to the to-be decorated function's
     * docstring and returns the new function object.
     * 
     * @param msg str<br>
     *            Additional explanation of the deprecation. Displayed in the
     *            docstring after the warning.
     * 
     * @return obj object<br>
     */
    public final Object deprecate_with_doc(Object msg) {
        write("np.deprecate_with_doc("+PythonGrammar.toPythonArgs(msg)+")");
        return null;
    }

    /**
     * Extract a diagonal or construct a diagonal array.
     * 
     * See the more detailed documentation for ``numpy.diagonal`` if you use this
     * function to extract a diagonal and wish to write to the resulting array;
     * whether it returns a copy or a view depends on what version of numpy you
     * are using.
     * 
     * @param v array_like<br>
     *          If `v` is a 2-D array, return a copy of its `k`-th diagonal.
     *          If `v` is a 1-D array, return a 2-D array with `v` on the `k`-th
     *          diagonal.
     * @param k int, optional<br>
     *          Diagonal in question. The default is 0. Use `k&gt;0` for diagonals
     *          above the main diagonal, and `k&lt;0` for diagonals below the main
     *          diagonal.
     * 
     * @return out ndarray<br>
     *             The extracted diagonal or constructed diagonal array.
     */
    public final Object diag(Object v, Object... args) {
        write("np.diag("+PythonGrammar.toPythonArgs(v)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the indices to access the main diagonal of an array.
     * 
     * This returns a tuple of indices that can be used to access the main
     * diagonal of an array `a` with ``a.ndim >= 2`` dimensions and shape
     * (n, n, ..., n). For ``a.ndim = 2`` this is the usual diagonal, for
     * ``a.ndim > 2`` this is the set of indices to access ``a[i, i, ..., i]``
     * for ``i = [0..n-1]``.
     * <p>
     * <em>Notes:</em><br>
     * .. versionadded:: 1.4.0
     * 
     * @param n int<br>
     *          The size, along each dimension, of the arrays for which the returned
     *          indices can be used.
     *          
     * @param ndim int, optional<br>
     *             The number of dimensions.
     */
    public final Object diag_indices(Object n, Object... args) {
        write("np.diag_indices("+PythonGrammar.toPythonArgs(n)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the indices to access the main diagonal of an n-dimensional array.
     * 
     * See `diag_indices` for full details.
     * <p>
     * <em>Notes:</em><br>
     * .. versionadded:: 1.4.0
     * 
     * @param arr array, at least 2-D<br>
     */
    public final Object diag_indices_from(Object arr) {
        write("np.diag_indices_from("+PythonGrammar.toPythonArgs(arr)+")");
        return null;
    }

    /**
     * Create a two-dimensional array with the flattened input as a diagonal.
     * 
     * @param v array_like<br>
     *          Input data, which is flattened and set as the `k`-th
     *          diagonal of the output.
     * @param k int, optional<br>
     *          Diagonal to set; 0, the default, corresponds to the "main" diagonal,
     *          a positive (negative) `k` giving the number of the diagonal above
     *          (below) the main.
     * 
     * @return out ndarray<br>
     *             The 2-D output array.
     */
    public final Object diagflat(Object v, Object... args) {
        write("np.diagflat("+PythonGrammar.toPythonArgs(v)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return specified diagonals.
     * 
     * If `a` is 2-D, returns the diagonal of `a` with the given offset,
     * i.e., the collection of elements of the form ``a[i, i+offset]``.  If
     * `a` has more than two dimensions, then the axes specified by `axis1`
     * and `axis2` are used to determine the 2-D sub-array whose diagonal is
     * returned.  The shape of the resulting array can be determined by
     * removing `axis1` and `axis2` and appending an index to the right equal
     * to the size of the resulting diagonals.
     * 
     * In versions of NumPy prior to 1.7, this function always returned a new,
     * independent array containing a copy of the values in the diagonal.
     * 
     * In NumPy 1.7 and 1.8, it continues to return a copy of the diagonal,
     * but depending on this fact is deprecated. Writing to the resulting
     * array continues to work as it used to, but a FutureWarning is issued.
     * 
     * Starting in NumPy 1.9 it returns a read-only view on the original array.
     * Attempting to write to the resulting array will produce an error.
     * 
     * In some future release, it will return a read/write view and writing to
     * the returned array will alter your original array.  The returned array
     * will have the same type as the input array.
     * 
     * If you don't write to the array returned by this function, then you can
     * just ignore all of the above.
     * 
     * If you depend on the current behavior, then we suggest copying the
     * returned array explicitly, i.e., use ``np.diagonal(a).copy()`` instead
     * of just ``np.diagonal(a)``. This will work with both past and future
     * versions of NumPy.
     * 
     * @param a array_like<br>
     *          Array from which the diagonals are taken.
     * @param offset int, optional<br>
     *               Offset of the diagonal from the main diagonal.  Can be positive or
     *               negative.  Defaults to main diagonal (0).
     * @param axis1 int, optional<br>
     *              Axis to be used as the first axis of the 2-D sub-arrays from which
     *              the diagonals should be taken.  Defaults to first axis (0).
     * @param axis2 int, optional<br>
     *              Axis to be used as the second axis of the 2-D sub-arrays from
     *              which the diagonals should be taken. Defaults to second axis (1).
     * 
     * @return array_of_diagonals ndarray<br>
     *                            If `a` is 2-D, then a 1-D array containing the diagonal and of the
     *                            same type as `a` is returned unless `a` is a `matrix`, in which case
     *                            a 1-D array rather than a (2-D) `matrix` is returned in order to
     *                            maintain backward compatibility.
     *                            
     *                            If ``a.ndim &gt; 2``, then the dimensions specified by `axis1` and `axis2`
     *                            are removed, and a new axis inserted at the end corresponding to the
     *                            diagonal.
     */
    public final Object diagonal(Object a, Object... args) {
        write("np.diagonal("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Calculate the n-th discrete difference along the given axis.
     * 
     * The first difference is given by ``out[i] = a[i+1] - a[i]`` along
     * the given axis, higher differences are calculated by using `diff`
     * recursively.
     * <p>
     * <em>Notes:</em><br>
     * Type is preserved for boolean arrays, so the result will contain
     * `False` when consecutive elements are the same and `True` when they
     * differ.
     * 
     * For unsigned integer arrays, the results will also be unsigned. This
     * should not be surprising, as the result is consistent with
     * calculating the difference directly:
     * 
     * >>> u8_arr = np.array([1, 0], dtype=np.uint8)
     * >>> np.diff(u8_arr)
     * array([255], dtype=uint8)
     * >>> u8_arr[1,...] - u8_arr[0,...]
     * 255
     * 
     * If this is not desirable, then the array should be cast to a larger
     * integer type first:
     * 
     * >>> i16_arr = u8_arr.astype(np.int16)
     * >>> np.diff(i16_arr)
     * array([-1], dtype=int16)
     * 
     * @param a array_like<br>
     *          Input array
     * @param n int, optional<br>
     *          The number of times values are differenced. If zero, the input
     *          is returned as-is.
     * @param axis int, optional<br>
     *             The axis along which the difference is taken, default is the
     *             last axis.
     * @param prepend array_like, optional<br>
     *                Values to prepend or append to `a` along axis prior to
     *                performing the difference.  Scalar values are expanded to
     *                arrays with length 1 in the direction of axis and the shape
     *                of the input array in along all other axes.  Otherwise the
     *                dimension and shape must match `a` except along axis.
     *                
     *                .. versionadded:: 1.16.0
     * @param append array_like, optional<br>
     *               Values to prepend or append to `a` along axis prior to
     *               performing the difference.  Scalar values are expanded to
     *               arrays with length 1 in the direction of axis and the shape
     *               of the input array in along all other axes.  Otherwise the
     *               dimension and shape must match `a` except along axis.
     *               
     *               .. versionadded:: 1.16.0
     * 
     * @return diff ndarray<br>
     *              The n-th differences. The shape of the output is the same as `a`
     *              except along `axis` where the dimension is smaller by `n`. The
     *              type of the output is the same as the type of the difference
     *              between any two elements of `a`. This is the same as the type of
     *              `a` in most cases. A notable exception is `datetime64`, which
     *              results in a `timedelta64` output array.
     */
    public final Object diff(Object a, Object... args) {
        write("np.diff("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the indices of the bins to which each value in input array belongs.
     * 
     * =========  =============  ============================
     * `right`    order of bins  returned index `i` satisfies
     * =========  =============  ============================
     * ``False``  increasing     ``bins[i-1] <= x < bins[i]``
     * ``True``   increasing     ``bins[i-1] < x <= bins[i]``
     * ``False``  decreasing     ``bins[i-1] > x >= bins[i]``
     * ``True``   decreasing     ``bins[i-1] >= x > bins[i]``
     * =========  =============  ============================
     * 
     * If values in `x` are beyond the bounds of `bins`, 0 or ``len(bins)`` is
     * returned as appropriate.
     * <p>
     * <em>Notes:</em><br>
     * If values in `x` are such that they fall outside the bin range,
     * attempting to index `bins` with the indices that `digitize` returns
     * will result in an IndexError.
     * 
     * .. versionadded:: 1.10.0
     * 
     * `np.digitize` is  implemented in terms of `np.searchsorted`. This means
     * that a binary search is used to bin the values, which scales much better
     * for larger number of bins than the previous linear search. It also removes
     * the requirement for the input array to be 1-dimensional.
     * 
     * For monotonically _increasing_ `bins`, the following are equivalent::
     * 
     * np.digitize(x, bins, right=True)
     * np.searchsorted(bins, x, side='left')
     * 
     * Note that as the order of the arguments are reversed, the side must be too.
     * The `searchsorted` call is marginally faster, as it does not do any
     * monotonicity checks. Perhaps more importantly, it supports all dtypes.
     * 
     * @param x array_like<br>
     *          Input array to be binned. Prior to NumPy 1.10.0, this array had to
     *          be 1-dimensional, but can now have any shape.
     * @param bins array_like<br>
     *             Array of bins. It has to be 1-dimensional and monotonic.
     * @param right bool, optional<br>
     *              Indicating whether the intervals include the right or the left bin
     *              edge. Default behavior is (right==False) indicating that the interval
     *              does not include the right edge. The left bin end is open in this
     *              case, i.e., bins[i-1] &lt;= x &lt; bins[i] is the default behavior for
     *              monotonically increasing bins.
     * 
     * @return indices ndarray of ints<br>
     *                 Output array of indices, of same shape as `x`.
     */
    public final Object digitize(Object x, Object bins, Object... args) {
        write("np.digitize("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(bins)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Display a message on a device.
     * 
     * @param mesg str<br>
     *             Message to display.
     * @param device object<br>
     *               Device to write message. If None, defaults to ``sys.stdout`` which is
     *               very similar to ``print``. `device` needs to have ``write()`` and
     *               ``flush()`` methods.
     * @param linefeed bool, optional<br>
     *                 Option whether to print a line feed or not. Defaults to True.
     */
    public final Object disp(Object mesg, Object... args) {
        write("np.disp("+PythonGrammar.toPythonArgs(mesg)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * dot(a, b, out=None)
     * 
     * Dot product of two arrays. Specifically,
     * 
     * - If both `a` and `b` are 1-D arrays, it is inner product of vectors
     * (without complex conjugation).
     * 
     * - If both `a` and `b` are 2-D arrays, it is matrix multiplication,
     * but using :func:`matmul` or ``a @ b`` is preferred.
     * 
     * - If either `a` or `b` is 0-D (scalar), it is equivalent to :func:`multiply`
     * and using ``numpy.multiply(a, b)`` or ``a * b`` is preferred.
     * 
     * - If `a` is an N-D array and `b` is a 1-D array, it is a sum product over
     * the last axis of `a` and `b`.
     * 
     * - If `a` is an N-D array and `b` is an M-D array (where ``M>=2``), it is a
     * sum product over the last axis of `a` and the second-to-last axis of `b`::
     * 
     * dot(a, b)[i,j,k,m] = sum(a[i,j,:] * b[k,:,m])
     * 
     * @param a array_like<br>
     *          First argument.
     * @param b array_like<br>
     *          Second argument.
     * @param out ndarray, optional<br>
     *            Output argument. This must have the exact kind that would be returned
     *            if it was not used. In particular, it must have the right type, must be
     *            C-contiguous, and its dtype must be the dtype that would be returned
     *            for `dot(a,b)`. This is a performance feature. Therefore, if these
     *            conditions are not met, an exception is raised, instead of attempting
     *            to be flexible.
     * 
     * @return output ndarray<br>
     *                Returns the dot product of `a` and `b`.  If `a` and `b` are both
     *                scalars or both 1-D arrays then a scalar is returned; otherwise
     *                an array is returned.
     *                If `out` is given, then it is returned.
     */
    public final Object dot(Object... args) {
        write("np.dot("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Split array into multiple sub-arrays along the 3rd axis (depth).
     * 
     * Please refer to the `split` documentation.  `dsplit` is equivalent
     * to `split` with ``axis=2``, the array is always split along the third
     * axis provided the array dimension is greater than or equal to 3.
     * 
     * @param ary n/a<br>undocumented
     * @param indices_or_sections n/a<br>undocumented
     */
    public final Object dsplit(Object... args) {
        write("np.dsplit("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Stack arrays in sequence depth wise (along third axis).
     * 
     * This is equivalent to concatenation along the third axis after 2-D arrays
     * of shape `(M,N)` have been reshaped to `(M,N,1)` and 1-D arrays of shape
     * `(N,)` have been reshaped to `(1,N,1)`. Rebuilds arrays divided by
     * `dsplit`.
     * 
     * This function makes most sense for arrays with up to 3 dimensions. For
     * instance, for pixel-data with a height (first axis), width (second axis),
     * and r/g/b channels (third axis). The functions `concatenate`, `stack` and
     * `block` provide more general stacking and concatenation operations.
     * 
     * @param tup sequence of arrays<br>
     *            The arrays must have the same shape along all but the third axis.
     *            1-D or 2-D arrays must have the same shape.
     * 
     * @return stacked ndarray<br>
     *                 The array formed by stacking the given arrays, will be at least 3-D.
     */
    public final Object dstack(Object tup) {
        write("np.dstack("+PythonGrammar.toPythonArgs(tup)+")");
        return null;
    }

    /**
     * The differences between consecutive elements of an array.
     * <p>
     * <em>Notes:</em><br>
     * When applied to masked arrays, this function drops the mask information
     * if the `to_begin` and/or `to_end` parameters are used.
     * 
     * @param ary array_like<br>
     *            If necessary, will be flattened before the differences are taken.
     * @param to_end array_like, optional<br>
     *               Number(s) to append at the end of the returned differences.
     * @param to_begin array_like, optional<br>
     *                 Number(s) to prepend at the beginning of the returned differences.
     * 
     * @return ediff1d ndarray<br>
     *                 The differences. Loosely, this is ``ary.flat[1:] - ary.flat[:-1]``.
     */
    public final Object ediff1d(Object ary, Object... args) {
        write("np.ediff1d("+PythonGrammar.toPythonArgs(ary)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * einsum(subscripts, *operands, out=None, dtype=None, order='K',
     * casting='safe', optimize=False)
     * 
     * Evaluates the Einstein summation convention on the operands.
     * 
     * Using the Einstein summation convention, many common multi-dimensional,
     * linear algebraic array operations can be represented in a simple fashion.
     * In *implicit* mode `einsum` computes these values.
     * 
     * In *explicit* mode, `einsum` provides further flexibility to compute
     * other array operations that might not be considered classical Einstein
     * summation operations, by disabling, or forcing summation over specified
     * subscript labels.
     * 
     * See the notes and examples for clarification.
     * <p>
     * <em>Notes:</em><br>
     * .. versionadded:: 1.6.0
     * 
     * The Einstein summation convention can be used to compute
     * many multi-dimensional, linear algebraic array operations. `einsum`
     * provides a succinct way of representing these.
     * 
     * A non-exhaustive list of these operations,
     * which can be computed by `einsum`, is shown below along with examples:
     * 
     * * Trace of an array, :py:func:`numpy.trace`.
     * * Return a diagonal, :py:func:`numpy.diag`.
     * * Array axis summations, :py:func:`numpy.sum`.
     * * Transpositions and permutations, :py:func:`numpy.transpose`.
     * * Matrix multiplication and dot product, :py:func:`numpy.matmul` :py:func:`numpy.dot`.
     * * Vector inner and outer products, :py:func:`numpy.inner` :py:func:`numpy.outer`.
     * * Broadcasting, element-wise and scalar multiplication, :py:func:`numpy.multiply`.
     * * Tensor contractions, :py:func:`numpy.tensordot`.
     * * Chained array operations, in efficient calculation order, :py:func:`numpy.einsum_path`.
     * 
     * The subscripts string is a comma-separated list of subscript labels,
     * where each label refers to a dimension of the corresponding operand.
     * Whenever a label is repeated it is summed, so ``np.einsum('i,i', a, b)``
     * is equivalent to :py:func:`np.inner(a,b) <numpy.inner>`. If a label
     * appears only once, it is not summed, so ``np.einsum('i', a)`` produces a
     * view of ``a`` with no changes. A further example ``np.einsum('ij,jk', a, b)``
     * describes traditional matrix multiplication and is equivalent to
     * :py:func:`np.matmul(a,b) <numpy.matmul>`. Repeated subscript labels in one
     * operand take the diagonal. For example, ``np.einsum('ii', a)`` is equivalent
     * to :py:func:`np.trace(a) <numpy.trace>`.
     * 
     * In *implicit mode*, the chosen subscripts are important
     * since the axes of the output are reordered alphabetically.  This
     * means that ``np.einsum('ij', a)`` doesn't affect a 2D array, while
     * ``np.einsum('ji', a)`` takes its transpose. Additionally,
     * ``np.einsum('ij,jk', a, b)`` returns a matrix multiplication, while,
     * ``np.einsum('ij,jh', a, b)`` returns the transpose of the
     * multiplication since subscript 'h' precedes subscript 'i'.
     * 
     * In *explicit mode* the output can be directly controlled by
     * specifying output subscript labels.  This requires the
     * identifier '->' as well as the list of output subscript labels.
     * This feature increases the flexibility of the function since
     * summing can be disabled or forced when required. The call
     * ``np.einsum('i->', a)`` is like :py:func:`np.sum(a, axis=-1) <numpy.sum>`,
     * and ``np.einsum('ii->i', a)`` is like :py:func:`np.diag(a) <numpy.diag>`.
     * The difference is that `einsum` does not allow broadcasting by default.
     * Additionally ``np.einsum('ij,jh->ih', a, b)`` directly specifies the
     * order of the output subscript labels and therefore returns matrix
     * multiplication, unlike the example above in implicit mode.
     * 
     * To enable and control broadcasting, use an ellipsis.  Default
     * NumPy-style broadcasting is done by adding an ellipsis
     * to the left of each term, like ``np.einsum('...ii->...i', a)``.
     * To take the trace along the first and last axes,
     * you can do ``np.einsum('i...i', a)``, or to do a matrix-matrix
     * product with the left-most indices instead of rightmost, one can do
     * ``np.einsum('ij...,jk...->ik...', a, b)``.
     * 
     * When there is only one operand, no axes are summed, and no output
     * parameter is provided, a view into the operand is returned instead
     * of a new array.  Thus, taking the diagonal as ``np.einsum('ii->i', a)``
     * produces a view (changed in version 1.10.0).
     * 
     * `einsum` also provides an alternative way to provide the subscripts
     * and operands as ``einsum(op0, sublist0, op1, sublist1, ..., [sublistout])``.
     * If the output shape is not provided in this format `einsum` will be
     * calculated in implicit mode, otherwise it will be performed explicitly.
     * The examples below have corresponding `einsum` calls with the two
     * parameter methods.
     * 
     * .. versionadded:: 1.10.0
     * 
     * Views returned from einsum are now writeable whenever the input array
     * is writeable. For example, ``np.einsum('ijk...->kji...', a)`` will now
     * have the same effect as :py:func:`np.swapaxes(a, 0, 2) <numpy.swapaxes>`
     * and ``np.einsum('ii->i', a)`` will return a writeable view of the diagonal
     * of a 2D array.
     * 
     * .. versionadded:: 1.12.0
     * 
     * Added the ``optimize`` argument which will optimize the contraction order
     * of an einsum expression. For a contraction with three or more operands this
     * can greatly increase the computational efficiency at the cost of a larger
     * memory footprint during computation.
     * 
     * Typically a 'greedy' algorithm is applied which empirical tests have shown
     * returns the optimal path in the majority of cases. In some cases 'optimal'
     * will return the superlative path through a more expensive, exhaustive search.
     * For iterative calculations it may be advisable to calculate the optimal path
     * once and reuse that path by supplying it as an argument. An example is given
     * below.
     * 
     * See :py:func:`numpy.einsum_path` for more details.
     * 
     * @param subscripts str<br>
     *                   Specifies the subscripts for summation as comma separated list of
     *                   subscript labels. An implicit (classical Einstein summation)
     *                   calculation is performed unless the explicit indicator '-&gt;' is
     *                   included as well as subscript labels of the precise output form.
     * @param operands list of array_like<br>
     *                 These are the arrays for the operation.
     * @param out ndarray, optional<br>
     *            If provided, the calculation is done into this array.
     * @param dtype &#123;data-type, None&#125;, optional<br>
     *              If provided, forces the calculation to use the data type specified.
     *              Note that you may have to also give a more liberal `casting`
     *              parameter to allow the conversions. Default is None.
     * @param order &#123;'C', 'F', 'A', 'K'&#125;, optional<br>
     *              Controls the memory layout of the output. 'C' means it should
     *              be C contiguous. 'F' means it should be Fortran contiguous,
     *              'A' means it should be 'F' if the inputs are all 'F', 'C' otherwise.
     *              'K' means it should be as close to the layout as the inputs as
     *              is possible, including arbitrarily permuted axes.
     *              Default is 'K'.
     * @param casting &#123;'no', 'equiv', 'safe', 'same_kind', 'unsafe'&#125;, optional<br>
     *                Controls what kind of data casting may occur.  Setting this to
     *                'unsafe' is not recommended, as it can adversely affect accumulations.
     *                
     *                * 'no' means the data types should not be cast at all.
     *                * 'equiv' means only byte-order changes are allowed.
     *                * 'safe' means only casts which can preserve values are allowed.
     *                * 'same_kind' means only safe casts or casts within a kind,
     *                like float64 to float32, are allowed.
     *                * 'unsafe' means any data conversions may be done.
     *                
     *                Default is 'safe'.
     * @param optimize &#123;False, True, 'greedy', 'optimal'&#125;, optional<br>
     *                 Controls if intermediate optimization should occur. No optimization
     *                 will occur if False and True will default to the 'greedy' algorithm.
     *                 Also accepts an explicit contraction list from the ``np.einsum_path``
     *                 function. See ``np.einsum_path`` for more details. Defaults to False.
     * @param **kwargs n/a<br>undocumented
     * 
     * @return output ndarray<br>
     *                The calculation based on the Einstein summation convention.
     */
    public final Object einsum(Object operands, Object... args) {
        write("np.einsum("+PythonGrammar.toPythonArgs(operands)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * einsum_path(subscripts, *operands, optimize='greedy')
     * 
     * Evaluates the lowest cost contraction order for an einsum expression by
     * considering the creation of intermediate arrays.
     * <p>
     * <em>Notes:</em><br>
     * The resulting path indicates which terms of the input contraction should be
     * contracted first, the result of this contraction is then appended to the
     * end of the contraction list. This list can then be iterated over until all
     * intermediate contractions are complete.
     * 
     * @param subscripts str<br>
     *                   Specifies the subscripts for summation.
     * @param *operands list of array_like<br>
     *                  These are the arrays for the operation.
     * @param optimize &#123;bool, list, tuple, 'greedy', 'optimal'&#125;<br>
     *                 Choose the type of path. If a tuple is provided, the second argument is
     *                 assumed to be the maximum intermediate size created. If only a single
     *                 argument is provided the largest input or output array size is used
     *                 as a maximum intermediate size.
     *                 
     *                 * if a list is given that starts with ``einsum_path``, uses this as the
     *                 contraction path
     *                 * if False no optimization is taken
     *                 * if True defaults to the 'greedy' algorithm
     *                 * 'optimal' An algorithm that combinatorially explores all possible
     *                 ways of contracting the listed tensors and choosest the least costly
     *                 path. Scales exponentially with the number of terms in the
     *                 contraction.
     *                 * 'greedy' An algorithm that chooses the best pair contraction
     *                 at each step. Effectively, this algorithm searches the largest inner,
     *                 Hadamard, and then outer products at each step. Scales cubically with
     *                 the number of terms in the contraction. Equivalent to the 'optimal'
     *                 path for most contractions.
     *                 
     *                 Default is 'greedy'.
     * @param einsum_call n/a<br>undocumented
     * 
     * @return (path,string_repr) (list of tuples,str)<br>
     *          A list representation of the einsum path.
     *          
     *          A printable representation of the einsum path.
     */
    public final Object einsum_path(Object operands, Object... args) {
        write("np.einsum_path("+PythonGrammar.toPythonArgs(operands)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * empty_like(prototype, dtype=None, order='K', subok=True, shape=None)
     * 
     * Return a new array with the same shape and type as a given array.
     * <p>
     * <em>Notes:</em><br>
     * This function does *not* initialize the returned array; to do that use
     * `zeros_like` or `ones_like` instead.  It may be marginally faster than
     * the functions that do set the array values.
     * 
     * @param prototype array_like<br>
     *                  The shape and data-type of `prototype` define these same attributes
     *                  of the returned array.
     * @param dtype data-type, optional<br>
     *              Overrides the data type of the result.
     *              
     *              .. versionadded:: 1.6.0
     * @param order &#123;'C', 'F', 'A', or 'K'&#125;, optional<br>
     *              Overrides the memory layout of the result. 'C' means C-order,
     *              'F' means F-order, 'A' means 'F' if `prototype` is Fortran
     *              contiguous, 'C' otherwise. 'K' means match the layout of `prototype`
     *              as closely as possible.
     *              
     *              .. versionadded:: 1.6.0
     * @param subok bool, optional.<br>
     *              If True, then the newly created array will use the sub-class
     *              type of `prototype`, otherwise it will be a base-class array. Defaults
     *              to True.
     * @param shape int or sequence of ints, optional.<br>
     *              Overrides the shape of the result. If order='K' and the number of
     *              dimensions is unchanged, will try to keep order, otherwise,
     *              order='C' is implied.
     *              
     *              .. versionadded:: 1.17.0
     * @param ... n/a<br>undocumented
     * 
     * @return out ndarray<br>
     *             Array of uninitialized (arbitrary) data with the same
     *             shape and type as `prototype`.
     */
    public final Object empty_like(Object... args) {
        write("np.empty_like("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Expand the shape of an array.
     * 
     * Insert a new axis that will appear at the `axis` position in the expanded
     * array shape.
     * 
     * @param a array_like<br>
     *          Input array.
     * @param axis int or tuple of ints<br>
     *             Position in the expanded axes where the new axis (or axes) is placed.
     *             
     *             .. deprecated:: 1.13.0
     *             Passing an axis where ``axis &gt; a.ndim`` will be treated as
     *             ``axis == a.ndim``, and passing ``axis &lt; -a.ndim - 1`` will
     *             be treated as ``axis == 0``. This behavior is deprecated.
     *             
     *             .. versionchanged:: 1.18.0
     *             A tuple of axes is now supported.  Out of range axes as
     *             described above are now forbidden and raise an `AxisError`.
     * 
     * @return result ndarray<br>
     *                View of `a` with the number of dimensions increased.
     */
    public final Object expand_dims(Object a, Object axis) {
        write("np.expand_dims("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(axis)+")");
        return null;
    }

    /**
     * Return the elements of an array that satisfy some condition.
     * 
     * This is equivalent to ``np.compress(ravel(condition), ravel(arr))``.  If
     * `condition` is boolean ``np.extract`` is equivalent to ``arr[condition]``.
     * 
     * Note that `place` does the exact opposite of `extract`.
     * 
     * @param condition array_like<br>
     *                  An array whose nonzero or True entries indicate the elements of `arr`
     *                  to extract.
     * @param arr array_like<br>
     *            Input array of the same size as `condition`.
     * 
     * @return extract ndarray<br>
     *                 Rank 1 array of values from `arr` where `condition` is True.
     */
    public final Object extract(Object condition, Object arr) {
        write("np.extract("+PythonGrammar.toPythonArgs(condition),PythonGrammar.toPythonArgs(arr)+")");
        return null;
    }

    /**
     * Return a 2-D array with ones on the diagonal and zeros elsewhere.
     * 
     * @param N int<br>
     *          Number of rows in the output.
     * @param M int, optional<br>
     *          Number of columns in the output. If None, defaults to `N`.
     * @param k int, optional<br>
     *          Index of the diagonal: 0 (the default) refers to the main diagonal,
     *          a positive value refers to an upper diagonal, and a negative value
     *          to a lower diagonal.
     * @param dtype data-type, optional<br>
     *              Data-type of the returned array.
     * @param order &#123;'C', 'F'&#125;, optional<br>
     *              Whether the output should be stored in row-major (C-style) or
     *              column-major (Fortran-style) order in memory.
     *              
     *              .. versionadded:: 1.14.0
     * @param like array_like<br>
     *             Reference object to allow the creation of arrays which are not
     *             NumPy arrays. If an array-like passed in as ``like`` supports
     *             the ``__array_function__`` protocol, the result will be defined
     *             by it. In this case, it ensures the creation of an array object
     *             compatible with that passed in via this argument.
     *             
     *             .. versionadded:: 1.20.0
     * 
     * @return I ndarray of shape (N,M)<br>
     *           An array where all elements are equal to zero, except for the `k`-th
     *           diagonal, whose values are equal to one.
     */
    public final Object eye(Object N, Object... args) {
        write("np.eye("+PythonGrammar.toPythonArgs(N)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Fill the main diagonal of the given array of any dimensionality.
     * 
     * For an array `a` with ``a.ndim >= 2``, the diagonal is the list of
     * locations with indices ``a[i, ..., i]`` all identical. This function
     * modifies the input array in-place, it does not return a value.
     * <p>
     * <em>Notes:</em><br>
     * .. versionadded:: 1.4.0
     * 
     * This functionality can be obtained via `diag_indices`, but internally
     * this version uses a much faster implementation that never constructs the
     * indices and uses simple slicing.
     * 
     * @param a array, at least 2-D.<br>
     *          Array whose diagonal is to be filled, it gets modified in-place.
     *          
     * @param val scalar or array_like<br>
     *            Value(s) to write on the diagonal. If `val` is scalar, the value is
     *            written along the diagonal. If array-like, the flattened `val` is
     *            written along the diagonal, repeating if necessary to fill all
     *            diagonal entries.
     *            
     * @param wrap bool<br>
     *             For tall matrices in NumPy version up to 1.6.2, the
     *             diagonal "wrapped" after N columns. You can have this behavior
     *             with this option. This affects only tall matrices.
     */
    public final Object fill_diagonal(Object a, Object val, Object... args) {
        write("np.fill_diagonal("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(val)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Determine common type following standard coercion rules.
     * 
     * @param array_types sequence<br>
     *                    A list of dtypes or dtype convertible objects representing arrays.
     * @param scalar_types sequence<br>
     *                     A list of dtypes or dtype convertible objects representing scalars.
     * 
     * @return datatype dtype<br>
     *                  The common data type, which is the maximum of `array_types` ignoring
     *                  `scalar_types`, unless the maximum of `scalar_types` is of a
     *                  different kind (`dtype.kind`). If the kind is not understood, then
     *                  None is returned.
     */
    public final Object find_common_type(Object array_types, Object scalar_types) {
        write("np.find_common_type("+PythonGrammar.toPythonArgs(array_types),PythonGrammar.toPythonArgs(scalar_types)+")");
        return null;
    }

    /**
     * Round to nearest integer towards zero.
     * 
     * Round an array of floats element-wise to nearest integer towards zero.
     * The rounded values are returned as floats.
     * 
     * @param x array_like<br>
     *          An array of floats to be rounded
     * @param out ndarray, optional<br>
     *            A location into which the result is stored. If provided, it must have
     *            a shape that the input broadcasts to. If not provided or None, a
     *            freshly-allocated array is returned.
     * 
     * @return out ndarray of floats<br>
     *             A float array with the same dimensions as the input.
     *             If second argument is not supplied then a float array is returned
     *             with the rounded values.
     *             
     *             If a second argument is supplied the result is stored there.
     *             The return value `out` is then a reference to that array.
     */
    public final Object fix(Object x, Object... args) {
        write("np.fix("+PythonGrammar.toPythonArgs(x)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return indices that are non-zero in the flattened version of a.
     * 
     * This is equivalent to np.nonzero(np.ravel(a))[0].
     * 
     * @param a array_like<br>
     *          Input data.
     * 
     * @return res ndarray<br>
     *             Output array, containing the indices of the elements of `a.ravel()`
     *             that are non-zero.
     */
    public final Object flatnonzero(Object a) {
        write("np.flatnonzero("+PythonGrammar.toPythonArgs(a)+")");
        return null;
    }

    /**
     * Reverse the order of elements in an array along the given axis.
     * 
     * The shape of the array is preserved, but the elements are reordered.
     * 
     * .. versionadded:: 1.12.0
     * <p>
     * <em>Notes:</em><br>
     * flip(m, 0) is equivalent to flipud(m).
     * 
     * flip(m, 1) is equivalent to fliplr(m).
     * 
     * flip(m, n) corresponds to ``m[...,::-1,...]`` with ``::-1`` at position n.
     * 
     * flip(m) corresponds to ``m[::-1,::-1,...,::-1]`` with ``::-1`` at all
     * positions.
     * 
     * flip(m, (0, 1)) corresponds to ``m[::-1,::-1,...]`` with ``::-1`` at
     * position 0 and position 1.
     * 
     * @param m array_like<br>
     *          Input array.
     * @param axis None or int or tuple of ints, optional<br>
     *             Axis or axes along which to flip over. The default,
     *             axis=None, will flip over all of the axes of the input array.
     *             If axis is negative it counts from the last to the first axis.
     *             
     *             If axis is a tuple of ints, flipping is performed on all of the axes
     *             specified in the tuple.
     *             
     *             .. versionchanged:: 1.15.0
     *             None and tuples of axes are supported
     * 
     * @return out array_like<br>
     *             A view of `m` with the entries of axis reversed.  Since a view is
     *             returned, this operation is done in constant time.
     */
    public final Object flip(Object m, Object... args) {
        write("np.flip("+PythonGrammar.toPythonArgs(m)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Reverse the order of elements along axis 1 (left/right).
     * 
     * For a 2-D array, this flips the entries in each row in the left/right
     * direction. Columns are preserved, but appear in a different order than
     * before.
     * <p>
     * <em>Notes:</em><br>
     * Equivalent to ``m[:,::-1]`` or ``np.flip(m, axis=1)``.
     * Requires the array to be at least 2-D.
     * 
     * @param m array_like<br>
     *          Input array, must be at least 2-D.
     * 
     * @return f ndarray<br>
     *           A view of `m` with the columns reversed.  Since a view
     *           is returned, this operation is :math:`\mathcal O(1)`.
     */
    public final Object fliplr(Object m) {
        write("np.fliplr("+PythonGrammar.toPythonArgs(m)+")");
        return null;
    }

    /**
     * Reverse the order of elements along axis 0 (up/down).
     * 
     * For a 2-D array, this flips the entries in each column in the up/down
     * direction. Rows are preserved, but appear in a different order than before.
     * <p>
     * <em>Notes:</em><br>
     * Equivalent to ``m[::-1, ...]`` or ``np.flip(m, axis=0)``.
     * Requires the array to be at least 1-D.
     * 
     * @param m array_like<br>
     *          Input array.
     * 
     * @return out array_like<br>
     *             A view of `m` with the rows reversed.  Since a view is
     *             returned, this operation is :math:`\mathcal O(1)`.
     */
    public final Object flipud(Object m) {
        write("np.flipud("+PythonGrammar.toPythonArgs(m)+")");
        return null;
    }

    /**
     * Format a floating-point scalar as a decimal string in positional notation.
     * 
     * Provides control over rounding, trimming and padding. Uses and assumes
     * IEEE unbiased rounding. Uses the "Dragon4" algorithm.
     * 
     * @param x python float or numpy floating scalar<br>
     *          Value to format.
     * @param precision non-negative integer or None, optional<br>
     *                  Maximum number of digits to print. May be None if `unique` is
     *                  `True`, but must be an integer if unique is `False`.
     * @param unique boolean, optional<br>
     *               If `True`, use a digit-generation strategy which gives the shortest
     *               representation which uniquely identifies the floating-point number from
     *               other values of the same type, by judicious rounding. If `precision`
     *               is given fewer digits than necessary can be printed, or if `min_digits`
     *               is given more can be printed, in which cases the last digit is rounded
     *               with unbiased rounding.
     *               If `False`, digits are generated as if printing an infinite-precision
     *               value and stopping after `precision` digits, rounding the remaining
     *               value with unbiased rounding
     * @param fractional boolean, optional<br>
     *                   If `True`, the cutoffs of `precision` and `min_digits` refer to the
     *                   total number of digits after the decimal point, including leading
     *                   zeros.
     *                   If `False`, `precision` and `min_digits` refer to the total number of
     *                   significant digits, before or after the decimal point, ignoring leading
     *                   zeros.
     * @param trim one of 'k', '.', '0', '-', optional<br>
     *             Controls post-processing trimming of trailing digits, as follows:
     *             
     *             * 'k' : keep trailing zeros, keep decimal point (no trimming)
     *             * '.' : trim all trailing zeros, leave decimal point
     *             * '0' : trim all but the zero before the decimal point. Insert the
     *             zero if it is missing.
     *             * '-' : trim trailing zeros and any trailing decimal point
     * @param sign boolean, optional<br>
     *             Whether to show the sign for positive values.
     * @param pad_left non-negative integer, optional<br>
     *                 Pad the left side of the string with whitespace until at least that
     *                 many characters are to the left of the decimal point.
     * @param pad_right non-negative integer, optional<br>
     *                  Pad the right side of the string with whitespace until at least that
     *                  many characters are to the right of the decimal point.
     * @param min_digits non-negative integer or None, optional<br>
     *                   Minimum number of digits to print. Only has an effect if `unique=True`
     *                   in which case additional digits past those necessary to uniquely
     *                   identify the value may be printed, rounding the last additional digit.
     *                   
     *                   -- versionadded:: 1.21.0
     * 
     * @return rep string<br>
     *             The string representation of the floating point value
     */
    public final Object format_float_positional(Object x, Object... args) {
        write("np.format_float_positional("+PythonGrammar.toPythonArgs(x)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Format a floating-point scalar as a decimal string in scientific notation.
     * 
     * Provides control over rounding, trimming and padding. Uses and assumes
     * IEEE unbiased rounding. Uses the "Dragon4" algorithm.
     * 
     * @param x python float or numpy floating scalar<br>
     *          Value to format.
     * @param precision non-negative integer or None, optional<br>
     *                  Maximum number of digits to print. May be None if `unique` is
     *                  `True`, but must be an integer if unique is `False`.
     * @param unique boolean, optional<br>
     *               If `True`, use a digit-generation strategy which gives the shortest
     *               representation which uniquely identifies the floating-point number from
     *               other values of the same type, by judicious rounding. If `precision`
     *               is given fewer digits than necessary can be printed. If `min_digits`
     *               is given more can be printed, in which cases the last digit is rounded
     *               with unbiased rounding.
     *               If `False`, digits are generated as if printing an infinite-precision
     *               value and stopping after `precision` digits, rounding the remaining
     *               value with unbiased rounding
     * @param trim one of 'k', '.', '0', '-', optional<br>
     *             Controls post-processing trimming of trailing digits, as follows:
     *             
     *             * 'k' : keep trailing zeros, keep decimal point (no trimming)
     *             * '.' : trim all trailing zeros, leave decimal point
     *             * '0' : trim all but the zero before the decimal point. Insert the
     *             zero if it is missing.
     *             * '-' : trim trailing zeros and any trailing decimal point
     * @param sign boolean, optional<br>
     *             Whether to show the sign for positive values.
     * @param pad_left non-negative integer, optional<br>
     *                 Pad the left side of the string with whitespace until at least that
     *                 many characters are to the left of the decimal point.
     * @param exp_digits non-negative integer, optional<br>
     *                   Pad the exponent with zeros until it contains at least this many digits.
     *                   If omitted, the exponent will be at least 2 digits.
     * @param min_digits non-negative integer or None, optional<br>
     *                   Minimum number of digits to print. This only has an effect for
     *                   `unique=True`. In that case more digits than necessary to uniquely
     *                   identify the value may be printed and rounded unbiased.
     *                   
     *                   -- versionadded:: 1.21.0
     * 
     * @return rep string<br>
     *             The string representation of the floating point value
     */
    public final Object format_float_scientific(Object x, Object... args) {
        write("np.format_float_scientific("+PythonGrammar.toPythonArgs(x)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Construct an array by executing a function over each coordinate.
     * 
     * The resulting array therefore has a value ``fn(x, y, z)`` at
     * coordinate ``(x, y, z)``.
     * <p>
     * <em>Notes:</em><br>
     * Keywords other than `dtype` are passed to `function`.
     * 
     * @param function callable<br>
     *                 The function is called with N parameters, where N is the rank of
     *                 `shape`.  Each parameter represents the coordinates of the array
     *                 varying along a specific axis.  For example, if `shape`
     *                 were ``(2, 2)``, then the parameters would be
     *                 ``array([[0, 0], [1, 1]])`` and ``array([[0, 1], [0, 1]])``
     * @param shape (N,) tuple of ints<br>
     *              Shape of the output array, which also determines the shape of
     *              the coordinate arrays passed to `function`.
     * @param dtype data-type, optional<br>
     *              Data-type of the coordinate arrays passed to `function`.
     *              By default, `dtype` is float.
     * @param like array_like<br>
     *             Reference object to allow the creation of arrays which are not
     *             NumPy arrays. If an array-like passed in as ``like`` supports
     *             the ``__array_function__`` protocol, the result will be defined
     *             by it. In this case, it ensures the creation of an array object
     *             compatible with that passed in via this argument.
     *             
     *             .. versionadded:: 1.20.0
     * @param **kwargs n/a<br>undocumented
     * 
     * @return fromfunction any<br>
     *                      The result of the call to `function` is passed back directly.
     *                      Therefore the shape of `fromfunction` is completely determined by
     *                      `function`.  If `function` returns a scalar value, the shape of
     *                      `fromfunction` would not match the `shape` parameter.
     */
    public final Object fromfunction(Object function, Object shape, Object... args) {
        write("np.fromfunction("+PythonGrammar.toPythonArgs(function),PythonGrammar.toPythonArgs(shape)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Construct an array from a text file, using regular expression parsing.
     * 
     * The returned array is always a structured array, and is constructed from
     * all matches of the regular expression in the file. Groups in the regular
     * expression are converted to fields of the structured array.
     * <p>
     * <em>Notes:</em><br>
     * Dtypes for structured arrays can be specified in several forms, but all
     * forms specify at least the data type and field name. For details see
     * `basics.rec`.
     * 
     * @param file str or file<br>
     *             Filename or file object to read.
     * @param regexp str or regexp<br>
     *               Regular expression used to parse the file.
     *               Groups in the regular expression correspond to fields in the dtype.
     * @param dtype dtype or list of dtypes<br>
     *              Dtype for the structured array.
     * @param encoding str, optional<br>
     *                 Encoding used to decode the inputfile. Does not apply to input streams.
     *                 
     *                 .. versionadded:: 1.14.0
     * 
     * @return output ndarray<br>
     *                The output array, containing the part of the content of `file` that
     *                was matched by `regexp`. `output` is always a structured array.
     */
    public final Object fromregex(Object file, Object regexp, Object dtype, Object... args) {
        write("np.fromregex("+PythonGrammar.toPythonArgs(file),PythonGrammar.toPythonArgs(regexp),PythonGrammar.toPythonArgs(dtype)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return a new array of given shape and type, filled with `fill_value`.
     * 
     * @param shape int or sequence of ints<br>
     *              Shape of the new array, e.g., ``(2, 3)`` or ``2``.
     * @param fill_value scalar or array_like<br>
     *                   Fill value.
     * @param dtype data-type, optional<br>
     *              The desired data-type for the array  The default, None, means
     *              ``np.array(fill_value).dtype``.
     * @param order &#123;'C', 'F'&#125;, optional<br>
     *              Whether to store multidimensional data in C- or Fortran-contiguous
     *              (row- or column-wise) order in memory.
     * @param like array_like<br>
     *             Reference object to allow the creation of arrays which are not
     *             NumPy arrays. If an array-like passed in as ``like`` supports
     *             the ``__array_function__`` protocol, the result will be defined
     *             by it. In this case, it ensures the creation of an array object
     *             compatible with that passed in via this argument.
     *             
     *             .. versionadded:: 1.20.0
     * 
     * @return out ndarray<br>
     *             Array of `fill_value` with the given shape, dtype, and order.
     */
    public final Object full(Object shape, Object fill_value, Object... args) {
        write("np.full("+PythonGrammar.toPythonArgs(shape),PythonGrammar.toPythonArgs(fill_value)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return a full array with the same shape and type as a given array.
     * 
     * @param a array_like<br>
     *          The shape and data-type of `a` define these same attributes of
     *          the returned array.
     * @param fill_value scalar<br>
     *                   Fill value.
     * @param dtype data-type, optional<br>
     *              Overrides the data type of the result.
     * @param order &#123;'C', 'F', 'A', or 'K'&#125;, optional<br>
     *              Overrides the memory layout of the result. 'C' means C-order,
     *              'F' means F-order, 'A' means 'F' if `a` is Fortran contiguous,
     *              'C' otherwise. 'K' means match the layout of `a` as closely
     *              as possible.
     * @param subok bool, optional.<br>
     *              If True, then the newly created array will use the sub-class
     *              type of `a`, otherwise it will be a base-class array. Defaults
     *              to True.
     * @param shape int or sequence of ints, optional.<br>
     *              Overrides the shape of the result. If order='K' and the number of
     *              dimensions is unchanged, will try to keep order, otherwise,
     *              order='C' is implied.
     *              
     *              .. versionadded:: 1.17.0
     * 
     * @return out ndarray<br>
     *             Array of `fill_value` with the same shape and type as `a`.
     */
    public final Object full_like(Object a, Object fill_value, Object... args) {
        write("np.full_like("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(fill_value)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Load data from a text file, with missing values handled as specified.
     * 
     * Each line past the first `skip_header` lines is split at the `delimiter`
     * character, and characters following the `comments` character are discarded.
     * <p>
     * <em>Notes:</em><br>
     * * When spaces are used as delimiters, or when no delimiter has been given
     * as input, there should not be any missing data between two fields.
     * * When the variables are named (either by a flexible dtype or with `names`),
     * there must not be any header in the file (else a ValueError
     * exception is raised).
     * * Individual values are not stripped of spaces by default.
     * When using a custom converter, make sure the function does remove spaces.
     * 
     * @param fname file, str, pathlib.Path, list of str, generator<br>
     *              File, filename, list, or generator to read.  If the filename
     *              extension is `.gz` or `.bz2`, the file is first decompressed. Note
     *              that generators must return byte strings. The strings
     *              in a list or produced by a generator are treated as lines.
     * @param dtype dtype, optional<br>
     *              Data type of the resulting array.
     *              If None, the dtypes will be determined by the contents of each
     *              column, individually.
     * @param comments str, optional<br>
     *                 The character used to indicate the start of a comment.
     *                 All the characters occurring on a line after a comment are discarded.
     * @param delimiter str, int, or sequence, optional<br>
     *                  The string used to separate values.  By default, any consecutive
     *                  whitespaces act as delimiter.  An integer or sequence of integers
     *                  can also be provided as width(s) of each field.
     * @param skiprows int, optional<br>
     *                 `skiprows` was removed in numpy 1.10. Please use `skip_header` instead.
     * @param skip_header int, optional<br>
     *                    The number of lines to skip at the beginning of the file.
     * @param skip_footer int, optional<br>
     *                    The number of lines to skip at the end of the file.
     * @param converters variable, optional<br>
     *                   The set of functions that convert the data of a column to a value.
     *                   The converters can also be used to provide a default value
     *                   for missing data: ``converters = &#123;3: lambda s: float(s or 0)&#125;``.
     * @param missing variable, optional<br>
     *                `missing` was removed in numpy 1.10. Please use `missing_values`
     *                instead.
     * @param missing_values variable, optional<br>
     *                       The set of strings corresponding to missing data.
     * @param filling_values variable, optional<br>
     *                       The set of values to be used as default when the data are missing.
     * @param usecols sequence, optional<br>
     *                Which columns to read, with 0 being the first.  For example,
     *                ``usecols = (1, 4, 5)`` will extract the 2nd, 5th and 6th columns.
     * @param names &#123;None, True, str, sequence&#125;, optional<br>
     *              If `names` is True, the field names are read from the first line after
     *              the first `skip_header` lines. This line can optionally be preceeded
     *              by a comment delimiter. If `names` is a sequence or a single-string of
     *              comma-separated names, the names will be used to define the field names
     *              in a structured dtype. If `names` is None, the names of the dtype
     *              fields will be used, if any.
     * @param excludelist sequence, optional<br>
     *                    A list of names to exclude. This list is appended to the default list
     *                    ['return','file','print']. Excluded names are appended with an
     *                    underscore: for example, `file` would become `file_`.
     * @param deletechars str, optional<br>
     *                    A string combining invalid characters that must be deleted from the
     *                    names.
     * @param defaultfmt str, optional<br>
     *                   A format used to define default field names, such as "f%i" or "f_%02i".
     * @param autostrip bool, optional<br>
     *                  Whether to automatically strip white spaces from the variables.
     * @param replace_space char, optional<br>
     *                      Character(s) used in replacement of white spaces in the variable
     *                      names. By default, use a '_'.
     * @param case_sensitive &#123;True, False, 'upper', 'lower'&#125;, optional<br>
     *                       If True, field names are case sensitive.
     *                       If False or 'upper', field names are converted to upper case.
     *                       If 'lower', field names are converted to lower case.
     * @param unpack bool, optional<br>
     *               If True, the returned array is transposed, so that arguments may be
     *               unpacked using ``x, y, z = genfromtxt(...)``.  When used with a
     *               structured data-type, arrays are returned for each field.
     *               Default is False.
     * @param usemask bool, optional<br>
     *                If True, return a masked array.
     *                If False, return a regular array.
     * @param loose bool, optional<br>
     *              If True, do not raise errors for invalid values.
     * @param invalid_raise bool, optional<br>
     *                      If True, an exception is raised if an inconsistency is detected in the
     *                      number of columns.
     *                      If False, a warning is emitted and the offending lines are skipped.
     * @param max_rows int,  optional<br>
     *                 The maximum number of rows to read. Must not be used with skip_footer
     *                 at the same time.  If given, the value must be at least 1. Default is
     *                 to read the entire file.
     *                 
     *                 .. versionadded:: 1.10.0
     * @param encoding str, optional<br>
     *                 Encoding used to decode the inputfile. Does not apply when `fname` is
     *                 a file object.  The special value 'bytes' enables backward compatibility
     *                 workarounds that ensure that you receive byte arrays when possible
     *                 and passes latin1 encoded strings to converters. Override this value to
     *                 receive unicode arrays and pass strings as input to converters.  If set
     *                 to None the system default is used. The default value is 'bytes'.
     *                 
     *                 .. versionadded:: 1.14.0
     * @param like array_like<br>
     *             Reference object to allow the creation of arrays which are not
     *             NumPy arrays. If an array-like passed in as ``like`` supports
     *             the ``__array_function__`` protocol, the result will be defined
     *             by it. In this case, it ensures the creation of an array object
     *             compatible with that passed in via this argument.
     *             
     *             .. versionadded:: 1.20.0
     * 
     * @return out ndarray<br>
     *             Data read from the text file. If `usemask` is True, this is a
     *             masked array.
     */
    public final Object genfromtxt(Object fname, Object... args) {
        write("np.genfromtxt("+PythonGrammar.toPythonArgs(fname)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return numbers spaced evenly on a log scale (a geometric progression).
     * 
     * This is similar to `logspace`, but with endpoints specified directly.
     * Each output sample is a constant multiple of the previous.
     * 
     * .. versionchanged:: 1.16.0
     * Non-scalar `start` and `stop` are now supported.
     * <p>
     * <em>Notes:</em><br>
     * If the inputs or dtype are complex, the output will follow a logarithmic
     * spiral in the complex plane.  (There are an infinite number of spirals
     * passing through two points; the output will follow the shortest such path.)
     * 
     * @param start array_like<br>
     *              The starting value of the sequence.
     * @param stop array_like<br>
     *             The final value of the sequence, unless `endpoint` is False.
     *             In that case, ``num + 1`` values are spaced over the
     *             interval in log-space, of which all but the last (a sequence of
     *             length `num`) are returned.
     * @param num integer, optional<br>
     *            Number of samples to generate.  Default is 50.
     * @param endpoint boolean, optional<br>
     *                 If true, `stop` is the last sample. Otherwise, it is not included.
     *                 Default is True.
     * @param dtype dtype<br>
     *              The type of the output array.  If `dtype` is not given, the data type
     *              is inferred from `start` and `stop`. The inferred dtype will never be
     *              an integer; `float` is chosen even if the arguments would produce an
     *              array of integers.
     * @param axis int, optional<br>
     *             The axis in the result to store the samples.  Relevant only if start
     *             or stop are array-like.  By default (0), the samples will be along a
     *             new axis inserted at the beginning. Use -1 to get an axis at the end.
     *             
     *             .. versionadded:: 1.16.0
     * 
     * @return samples ndarray<br>
     *                 `num` samples, equally spaced on a log scale.
     */
    public final Object geomspace(Object start, Object stop, Object... args) {
        write("np.geomspace("+PythonGrammar.toPythonArgs(start),PythonGrammar.toPythonArgs(stop)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find the wrapper for the array with the highest priority.
     * 
     * In case of ties, leftmost wins. If no wrapper is found, return None
     * 
     * @param *args n/a<br>undocumented
     */
    public final Object get_array_wrap(Object... args) {
        write("np.get_array_wrap("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the directory that contains the NumPy \*.h header files.
     * 
     * Extension modules that need to compile against NumPy should use this
     * function to locate the appropriate include directory.
     * <p>
     * <em>Notes:</em><br>
     * When using ``distutils``, for example in ``setup.py``.
     * ::
     * 
     * import numpy as np
     * ...
     * Extension('extension_name', ...
     * include_dirs=[np.get_include()])
     * ...
     */
    public final Object get_include() {
        write("np.get_include()");
        return null;
    }

    /**
     * Return the current print options.
     * 
     * @return print_opts dict<br>
     *                    Dictionary of current print options with keys
     *                    
     *                    - precision : int
     *                    - threshold : int
     *                    - edgeitems : int
     *                    - linewidth : int
     *                    - suppress : bool
     *                    - nanstr : str
     *                    - infstr : str
     *                    - formatter : dict of callables
     *                    - sign : str
     *                    
     *                    For a full description of these options, see `set_printoptions`.
     */
    public final Object get_printoptions() {
        write("np.get_printoptions()");
        return null;
    }

    /**
     * Return the size of the buffer used in ufuncs.
     * 
     * @return getbufsize int<br>
     *                    Size of ufunc buffer in bytes.
     */
    public final Object getbufsize() {
        write("np.getbufsize()");
        return null;
    }

    /**
     * Get the current way of handling floating-point errors.
     * <p>
     * <em>Notes:</em><br>
     * For complete documentation of the types of floating-point exceptions and
     * treatment options, see `seterr`.
     * 
     * @return res dict<br>
     *             A dictionary with keys "divide", "over", "under", and "invalid",
     *             whose values are from the strings "ignore", "print", "log", "warn",
     *             "raise", and "call". The keys represent possible floating-point
     *             exceptions, and the values define how these exceptions are handled.
     */
    public final Object geterr() {
        write("np.geterr()");
        return null;
    }

    /**
     * Return the current callback function used on floating-point errors.
     * 
     * When the error handling for a floating-point error (one of "divide",
     * "over", "under", or "invalid") is set to 'call' or 'log', the function
     * that is called or the log instance that is written to is returned by
     * `geterrcall`. This function or log instance has been set with
     * `seterrcall`.
     * <p>
     * <em>Notes:</em><br>
     * For complete documentation of the types of floating-point exceptions and
     * treatment options, see `seterr`.
     * 
     * @return errobj callable, log instance or None<br>
     *                The current error handler. If no handler was set through `seterrcall`,
     *                ``None`` is returned.
     */
    public final Object geterrcall() {
        write("np.geterrcall()");
        return null;
    }

    /**
     * Return the gradient of an N-dimensional array.
     * 
     * The gradient is computed using second order accurate central differences
     * in the interior points and either first or second order accurate one-sides
     * (forward or backwards) differences at the boundaries.
     * The returned gradient hence has the same shape as the input array.
     * <p>
     * <em>Notes:</em><br>
     * Assuming that :math:`f\in C^{3}` (i.e., :math:`f` has at least 3 continuous
     * derivatives) and let :math:`h_{*}` be a non-homogeneous stepsize, we
     * minimize the "consistency error" :math:`\eta_{i}` between the true gradient
     * and its estimate from a linear combination of the neighboring grid-points:
     * 
     * .. math::
     * 
     * \eta_{i} = f_{i}^{\left(1\right)} -
     * \left[ \alpha f\left(x_{i}\right) +
     * \beta f\left(x_{i} + h_{d}\right) +
     * \gamma f\left(x_{i}-h_{s}\right)
     * \right]
     * 
     * By substituting :math:`f(x_{i} + h_{d})` and :math:`f(x_{i} - h_{s})`
     * with their Taylor series expansion, this translates into solving
     * the following the linear system:
     * 
     * .. math::
     * 
     * \left\{
     * \begin{array}{r}
     * \alpha+\beta+\gamma=0 \\
     * \beta h_{d}-\gamma h_{s}=1 \\
     * \beta h_{d}^{2}+\gamma h_{s}^{2}=0
     * \end{array}
     * \right.
     * 
     * The resulting approximation of :math:`f_{i}^{(1)}` is the following:
     * 
     * .. math::
     * 
     * \hat f_{i}^{(1)} =
     * \frac{
     * h_{s}^{2}f\left(x_{i} + h_{d}\right)
     * + \left(h_{d}^{2} - h_{s}^{2}\right)f\left(x_{i}\right)
     * - h_{d}^{2}f\left(x_{i}-h_{s}\right)}
     * { h_{s}h_{d}\left(h_{d} + h_{s}\right)}
     * + \mathcal{O}\left(\frac{h_{d}h_{s}^{2}
     * + h_{s}h_{d}^{2}}{h_{d}
     * + h_{s}}\right)
     * 
     * It is worth noting that if :math:`h_{s}=h_{d}`
     * (i.e., data are evenly spaced)
     * we find the standard second order approximation:
     * 
     * .. math::
     * 
     * \hat f_{i}^{(1)}=
     * \frac{f\left(x_{i+1}\right) - f\left(x_{i-1}\right)}{2h}
     * + \mathcal{O}\left(h^{2}\right)
     * 
     * With a similar procedure the forward/backward approximations used for
     * boundaries can be derived.
     * 
     * @param f array_like<br>
     *          An N-dimensional array containing samples of a scalar function.
     * @param varargs list of scalar or array, optional<br>
     *                Spacing between f values. Default unitary spacing for all dimensions.
     *                Spacing can be specified using:
     *                
     *                1. single scalar to specify a sample distance for all dimensions.
     *                2. N scalars to specify a constant sample distance for each dimension.
     *                i.e. `dx`, `dy`, `dz`, ...
     *                3. N arrays to specify the coordinates of the values along each
     *                dimension of F. The length of the array must match the size of
     *                the corresponding dimension
     *                4. Any combination of N scalars/arrays with the meaning of 2. and 3.
     *                
     *                If `axis` is given, the number of varargs must equal the number of axes.
     *                Default: 1.
     *                
     * @param edge_order &#123;1, 2&#125;, optional<br>
     *                   Gradient is calculated using N-th order accurate differences
     *                   at the boundaries. Default: 1.
     *                   
     *                   .. versionadded:: 1.9.1
     *                   
     * @param axis None or int or tuple of ints, optional<br>
     *             Gradient is calculated only along the given axis or axes
     *             The default (axis = None) is to calculate the gradient for all the axes
     *             of the input array. axis may be negative, in which case it counts from
     *             the last to the first axis.
     *             
     *             .. versionadded:: 1.11.0
     * 
     * @return gradient ndarray or list of ndarray<br>
     *                  A list of ndarrays (or a single ndarray if there is only one dimension)
     *                  corresponding to the derivatives of f with respect to each dimension.
     *                  Each derivative has the same shape as f.
     */
    public final Object gradient(Object f, Object... args) {
        write("np.gradient("+PythonGrammar.toPythonArgs(f)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the Hamming window.
     * 
     * The Hamming window is a taper formed by using a weighted cosine.
     * <p>
     * <em>Notes:</em><br>
     * The Hamming window is defined as
     * 
     * .. math::  w(n) = 0.54 - 0.46cos\left(\frac{2\pi{n}}{M-1}\right)
     * \qquad 0 \leq n \leq M-1
     * 
     * The Hamming was named for R. W. Hamming, an associate of J. W. Tukey
     * and is described in Blackman and Tukey. It was recommended for
     * smoothing the truncated autocovariance function in the time domain.
     * Most references to the Hamming window come from the signal processing
     * literature, where it is used as one of many windowing functions for
     * smoothing values.  It is also known as an apodization (which means
     * "removing the foot", i.e. smoothing discontinuities at the beginning
     * and end of the sampled signal) or tapering function.
     * 
     * @param M int<br>
     *          Number of points in the output window. If zero or less, an
     *          empty array is returned.
     * 
     * @return out ndarray<br>
     *             The window, with the maximum value normalized to one (the value
     *             one appears only if the number of samples is odd).
     */
    public final Object hamming(Object M) {
        write("np.hamming("+PythonGrammar.toPythonArgs(M)+")");
        return null;
    }

    /**
     * Return the Hanning window.
     * 
     * The Hanning window is a taper formed by using a weighted cosine.
     * <p>
     * <em>Notes:</em><br>
     * The Hanning window is defined as
     * 
     * .. math::  w(n) = 0.5 - 0.5cos\left(\frac{2\pi{n}}{M-1}\right)
     * \qquad 0 \leq n \leq M-1
     * 
     * The Hanning was named for Julius von Hann, an Austrian meteorologist.
     * It is also known as the Cosine Bell. Some authors prefer that it be
     * called a Hann window, to help avoid confusion with the very similar
     * Hamming window.
     * 
     * Most references to the Hanning window come from the signal processing
     * literature, where it is used as one of many windowing functions for
     * smoothing values.  It is also known as an apodization (which means
     * "removing the foot", i.e. smoothing discontinuities at the beginning
     * and end of the sampled signal) or tapering function.
     * 
     * @param M int<br>
     *          Number of points in the output window. If zero or less, an
     *          empty array is returned.
     * 
     * @return out ndarray, shape(M,)<br>
     *             The window, with the maximum value normalized to one (the value
     *             one appears only if `M` is odd).
     */
    public final Object hanning(Object M) {
        write("np.hanning("+PythonGrammar.toPythonArgs(M)+")");
        return null;
    }

    /**
     * Compute the histogram of a dataset.
     * <p>
     * <em>Notes:</em><br>
     * All but the last (righthand-most) bin is half-open.  In other words,
     * if `bins` is::
     * 
     * [1, 2, 3, 4]
     * 
     * then the first bin is ``[1, 2)`` (including 1, but excluding 2) and
     * the second ``[2, 3)``.  The last bin, however, is ``[3, 4]``, which
     * *includes* 4.
     * 
     * @param a array_like<br>
     *          Input data. The histogram is computed over the flattened array.
     * @param bins int or sequence of scalars or str, optional<br>
     *             If `bins` is an int, it defines the number of equal-width
     *             bins in the given range (10, by default). If `bins` is a
     *             sequence, it defines a monotonically increasing array of bin edges,
     *             including the rightmost edge, allowing for non-uniform bin widths.
     *             
     *             .. versionadded:: 1.11.0
     *             
     *             If `bins` is a string, it defines the method used to calculate the
     *             optimal bin width, as defined by `histogram_bin_edges`.
     *             
     * @param range (float, float), optional<br>
     *              The lower and upper range of the bins.  If not provided, range
     *              is simply ``(a.min(), a.max())``.  Values outside the range are
     *              ignored. The first element of the range must be less than or
     *              equal to the second. `range` affects the automatic bin
     *              computation as well. While bin width is computed to be optimal
     *              based on the actual data within `range`, the bin count will fill
     *              the entire range including portions containing no data.
     * @param normed bool, optional<br>
     *               
     *               .. deprecated:: 1.6.0
     *               
     *               This is equivalent to the `density` argument, but produces incorrect
     *               results for unequal bin widths. It should not be used.
     *               
     *               .. versionchanged:: 1.15.0
     *               DeprecationWarnings are actually emitted.
     *               
     * @param weights array_like, optional<br>
     *                An array of weights, of the same shape as `a`.  Each value in
     *                `a` only contributes its associated weight towards the bin count
     *                (instead of 1). If `density` is True, the weights are
     *                normalized, so that the integral of the density over the range
     *                remains 1.
     * @param density bool, optional<br>
     *                If ``False``, the result will contain the number of samples in
     *                each bin. If ``True``, the result is the value of the
     *                probability *density* function at the bin, normalized such that
     *                the *integral* over the range is 1. Note that the sum of the
     *                histogram values will not be equal to 1 unless bins of unity
     *                width are chosen; it is not a probability *mass* function.
     *                
     *                Overrides the ``normed`` keyword if given.
     * 
     * @return (hist,bin_edges) (array,array of dtype float)<br>
     *          The values of the histogram. See `density` and `weights` for a
     *          description of the possible semantics.
     *          
     *          Return the bin edges ``(length(hist)+1)``.
     */
    public final Object histogram(Object a, Object... args) {
        write("np.histogram("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Compute the bi-dimensional histogram of two data samples.
     * <p>
     * <em>Notes:</em><br>
     * When `normed` is True, then the returned histogram is the sample
     * density, defined such that the sum over bins of the product
     * ``bin_value * bin_area`` is 1.
     * 
     * Please note that the histogram does not follow the Cartesian convention
     * where `x` values are on the abscissa and `y` values on the ordinate
     * axis.  Rather, `x` is histogrammed along the first dimension of the
     * array (vertical), and `y` along the second dimension of the array
     * (horizontal).  This ensures compatibility with `histogramdd`.
     * 
     * @param x array_like, shape (N,)<br>
     *          An array containing the x coordinates of the points to be
     *          histogrammed.
     * @param y array_like, shape (N,)<br>
     *          An array containing the y coordinates of the points to be
     *          histogrammed.
     * @param bins int or array_like or [int, int] or [array, array], optional<br>
     *             The bin specification:
     *             
     *             * If int, the number of bins for the two dimensions (nx=ny=bins).
     *             * If array_like, the bin edges for the two dimensions
     *             (x_edges=y_edges=bins).
     *             * If [int, int], the number of bins in each dimension
     *             (nx, ny = bins).
     *             * If [array, array], the bin edges in each dimension
     *             (x_edges, y_edges = bins).
     *             * A combination [int, array] or [array, int], where int
     *             is the number of bins and array is the bin edges.
     *             
     * @param range array_like, shape(2,2), optional<br>
     *              The leftmost and rightmost edges of the bins along each dimension
     *              (if not specified explicitly in the `bins` parameters):
     *              ``[[xmin, xmax], [ymin, ymax]]``. All values outside of this range
     *              will be considered outliers and not tallied in the histogram.
     * @param density bool, optional<br>
     *                If False, the default, returns the number of samples in each bin.
     *                If True, returns the probability *density* function at the bin,
     *                ``bin_count / sample_count / bin_area``.
     * @param normed bool, optional<br>
     *               An alias for the density argument that behaves identically. To avoid
     *               confusion with the broken normed argument to `histogram`, `density`
     *               should be preferred.
     * @param weights array_like, shape(N,), optional<br>
     *                An array of values ``w_i`` weighing each sample ``(x_i, y_i)``.
     *                Weights are normalized to 1 if `normed` is True. If `normed` is
     *                False, the values of the returned histogram are equal to the sum of
     *                the weights belonging to the samples falling into each bin.
     * 
     * @return (H,xedges,yedges) (ndarray, shape(nx, ny),ndarray, shape(nx+1,),ndarray, shape(ny+1,))<br>
     *          The bi-dimensional histogram of samples `x` and `y`. Values in `x`
     *          are histogrammed along the first dimension and values in `y` are
     *          histogrammed along the second dimension.
     *          
     *          The bin edges along the first dimension.
     *          
     *          The bin edges along the second dimension.
     */
    public final Object histogram2d(Object x, Object y, Object... args) {
        write("np.histogram2d("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(y)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Function to calculate only the edges of the bins used by the `histogram`
     * function.
     * <p>
     * <em>Notes:</em><br>
     * The methods to estimate the optimal number of bins are well founded
     * in literature, and are inspired by the choices R provides for
     * histogram visualisation. Note that having the number of bins
     * proportional to :math:`n^{1/3}` is asymptotically optimal, which is
     * why it appears in most estimators. These are simply plug-in methods
     * that give good starting points for number of bins. In the equations
     * below, :math:`h` is the binwidth and :math:`n_h` is the number of
     * bins. All estimators that compute bin counts are recast to bin width
     * using the `ptp` of the data. The final bin count is obtained from
     * ``np.round(np.ceil(range / h))``. The final bin width is often less
     * than what is returned by the estimators below.
     * 
     * 'auto' (maximum of the 'sturges' and 'fd' estimators)
     * A compromise to get a good value. For small datasets the Sturges
     * value will usually be chosen, while larger datasets will usually
     * default to FD.  Avoids the overly conservative behaviour of FD
     * and Sturges for small and large datasets respectively.
     * Switchover point is usually :math:`a.size \approx 1000`.
     * 
     * 'fd' (Freedman Diaconis Estimator)
     * .. math:: h = 2 \frac{IQR}{n^{1/3}}
     * 
     * The binwidth is proportional to the interquartile range (IQR)
     * and inversely proportional to cube root of a.size. Can be too
     * conservative for small datasets, but is quite good for large
     * datasets. The IQR is very robust to outliers.
     * 
     * 'scott'
     * .. math:: h = \sigma \sqrt[3]{\frac{24 * \sqrt{\pi}}{n}}
     * 
     * The binwidth is proportional to the standard deviation of the
     * data and inversely proportional to cube root of ``x.size``. Can
     * be too conservative for small datasets, but is quite good for
     * large datasets. The standard deviation is not very robust to
     * outliers. Values are very similar to the Freedman-Diaconis
     * estimator in the absence of outliers.
     * 
     * 'rice'
     * .. math:: n_h = 2n^{1/3}
     * 
     * The number of bins is only proportional to cube root of
     * ``a.size``. It tends to overestimate the number of bins and it
     * does not take into account data variability.
     * 
     * 'sturges'
     * .. math:: n_h = \log _{2}n+1
     * 
     * The number of bins is the base 2 log of ``a.size``.  This
     * estimator assumes normality of data and is too conservative for
     * larger, non-normal datasets. This is the default method in R's
     * ``hist`` method.
     * 
     * 'doane'
     * .. math:: n_h = 1 + \log_{2}(n) +
     * \log_{2}(1 + \frac{|g_1|}{\sigma_{g_1}})
     * 
     * g_1 = mean[(\frac{x - \mu}{\sigma})^3]
     * 
     * \sigma_{g_1} = \sqrt{\frac{6(n - 2)}{(n + 1)(n + 3)}}
     * 
     * An improved version of Sturges' formula that produces better
     * estimates for non-normal datasets. This estimator attempts to
     * account for the skew of the data.
     * 
     * 'sqrt'
     * .. math:: n_h = \sqrt n
     * 
     * The simplest and fastest estimator. Only takes into account the
     * data size.
     * 
     * @param a array_like<br>
     *          Input data. The histogram is computed over the flattened array.
     * @param bins int or sequence of scalars or str, optional<br>
     *             If `bins` is an int, it defines the number of equal-width
     *             bins in the given range (10, by default). If `bins` is a
     *             sequence, it defines the bin edges, including the rightmost
     *             edge, allowing for non-uniform bin widths.
     *             
     *             If `bins` is a string from the list below, `histogram_bin_edges` will use
     *             the method chosen to calculate the optimal bin width and
     *             consequently the number of bins (see `Notes` for more detail on
     *             the estimators) from the data that falls within the requested
     *             range. While the bin width will be optimal for the actual data
     *             in the range, the number of bins will be computed to fill the
     *             entire range, including the empty portions. For visualisation,
     *             using the 'auto' option is suggested. Weighted data is not
     *             supported for automated bin size selection.
     *             
     *             'auto'
     *             Maximum of the 'sturges' and 'fd' estimators. Provides good
     *             all around performance.
     *             
     *             'fd' (Freedman Diaconis Estimator)
     *             Robust (resilient to outliers) estimator that takes into
     *             account data variability and data size.
     *             
     *             'doane'
     *             An improved version of Sturges' estimator that works better
     *             with non-normal datasets.
     *             
     *             'scott'
     *             Less robust estimator that that takes into account data
     *             variability and data size.
     *             
     *             'stone'
     *             Estimator based on leave-one-out cross-validation estimate of
     *             the integrated squared error. Can be regarded as a generalization
     *             of Scott's rule.
     *             
     *             'rice'
     *             Estimator does not take variability into account, only data
     *             size. Commonly overestimates number of bins required.
     *             
     *             'sturges'
     *             R's default method, only accounts for data size. Only
     *             optimal for gaussian data and underestimates number of bins
     *             for large non-gaussian datasets.
     *             
     *             'sqrt'
     *             Square root (of data size) estimator, used by Excel and
     *             other programs for its speed and simplicity.
     *             
     * @param range (float, float), optional<br>
     *              The lower and upper range of the bins.  If not provided, range
     *              is simply ``(a.min(), a.max())``.  Values outside the range are
     *              ignored. The first element of the range must be less than or
     *              equal to the second. `range` affects the automatic bin
     *              computation as well. While bin width is computed to be optimal
     *              based on the actual data within `range`, the bin count will fill
     *              the entire range including portions containing no data.
     *              
     * @param weights array_like, optional<br>
     *                An array of weights, of the same shape as `a`.  Each value in
     *                `a` only contributes its associated weight towards the bin count
     *                (instead of 1). This is currently not used by any of the bin estimators,
     *                but may be in the future.
     * 
     * @return bin_edges array of dtype float<br>
     *                   The edges to pass into `histogram`
     */
    public final Object histogram_bin_edges(Object a, Object... args) {
        write("np.histogram_bin_edges("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Compute the multidimensional histogram of some data.
     * 
     * @param sample (N, D) array, or (D, N) array_like<br>
     *               The data to be histogrammed.
     *               
     *               Note the unusual interpretation of sample when an array_like:
     *               
     *               * When an array, each row is a coordinate in a D-dimensional space -
     *               such as ``histogramdd(np.array([p1, p2, p3]))``.
     *               * When an array_like, each element is the list of values for single
     *               coordinate - such as ``histogramdd((X, Y, Z))``.
     *               
     *               The first form should be preferred.
     *               
     * @param bins sequence or int, optional<br>
     *             The bin specification:
     *             
     *             * A sequence of arrays describing the monotonically increasing bin
     *             edges along each dimension.
     *             * The number of bins for each dimension (nx, ny, ... =bins)
     *             * The number of bins for all dimensions (nx=ny=...=bins).
     *             
     * @param range sequence, optional<br>
     *              A sequence of length D, each an optional (lower, upper) tuple giving
     *              the outer bin edges to be used if the edges are not given explicitly in
     *              `bins`.
     *              An entry of None in the sequence results in the minimum and maximum
     *              values being used for the corresponding dimension.
     *              The default, None, is equivalent to passing a tuple of D None values.
     * @param density bool, optional<br>
     *                If False, the default, returns the number of samples in each bin.
     *                If True, returns the probability *density* function at the bin,
     *                ``bin_count / sample_count / bin_volume``.
     * @param normed bool, optional<br>
     *               An alias for the density argument that behaves identically. To avoid
     *               confusion with the broken normed argument to `histogram`, `density`
     *               should be preferred.
     * @param weights (N,) array_like, optional<br>
     *                An array of values `w_i` weighing each sample `(x_i, y_i, z_i, ...)`.
     *                Weights are normalized to 1 if normed is True. If normed is False,
     *                the values of the returned histogram are equal to the sum of the
     *                weights belonging to the samples falling into each bin.
     * 
     * @return (H,edges) (ndarray,list)<br>
     *          The multidimensional histogram of sample x. See normed and weights
     *          for the different possible semantics.
     *          
     *          A list of D arrays describing the bin edges for each dimension.
     */
    public final Object histogramdd(Object sample, Object... args) {
        write("np.histogramdd("+PythonGrammar.toPythonArgs(sample)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Split an array into multiple sub-arrays horizontally (column-wise).
     * 
     * Please refer to the `split` documentation.  `hsplit` is equivalent
     * to `split` with ``axis=1``, the array is always split along the second
     * axis regardless of the array dimension.
     * 
     * @param ary n/a<br>undocumented
     * @param indices_or_sections n/a<br>undocumented
     */
    public final Object hsplit(Object... args) {
        write("np.hsplit("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Stack arrays in sequence horizontally (column wise).
     * 
     * This is equivalent to concatenation along the second axis, except for 1-D
     * arrays where it concatenates along the first axis. Rebuilds arrays divided
     * by `hsplit`.
     * 
     * This function makes most sense for arrays with up to 3 dimensions. For
     * instance, for pixel-data with a height (first axis), width (second axis),
     * and r/g/b channels (third axis). The functions `concatenate`, `stack` and
     * `block` provide more general stacking and concatenation operations.
     * 
     * @param tup sequence of ndarrays<br>
     *            The arrays must have the same shape along all but the second axis,
     *            except 1-D arrays which can be any length.
     * 
     * @return stacked ndarray<br>
     *                 The array formed by stacking the given arrays.
     */
    public final Object hstack(Object tup) {
        write("np.hstack("+PythonGrammar.toPythonArgs(tup)+")");
        return null;
    }

    /**
     * Modified Bessel function of the first kind, order 0.
     * 
     * Usually denoted :math:`I_0`.
     * <p>
     * <em>Notes:</em><br>
     * The scipy implementation is recommended over this function: it is a
     * proper ufunc written in C, and more than an order of magnitude faster.
     * 
     * We use the algorithm published by Clenshaw [1]_ and referenced by
     * Abramowitz and Stegun [2]_, for which the function domain is
     * partitioned into the two intervals [0,8] and (8,inf), and Chebyshev
     * polynomial expansions are employed in each interval. Relative error on
     * the domain [0,30] using IEEE arithmetic is documented [3]_ as having a
     * peak of 5.8e-16 with an rms of 1.4e-16 (n = 30000).
     * 
     * @param x array_like of float<br>
     *          Argument of the Bessel function.
     * 
     * @return out ndarray, shape = x.shape, dtype = float<br>
     *             The modified Bessel function evaluated at each of the elements of `x`.
     */
    public final Object i0(Object x) {
        write("np.i0("+PythonGrammar.toPythonArgs(x)+")");
        return null;
    }

    /**
     * Return the identity array.
     * 
     * The identity array is a square array with ones on
     * the main diagonal.
     * 
     * @param n int<br>
     *          Number of rows (and columns) in `n` x `n` output.
     * @param dtype data-type, optional<br>
     *              Data-type of the output.  Defaults to ``float``.
     * @param like array_like<br>
     *             Reference object to allow the creation of arrays which are not
     *             NumPy arrays. If an array-like passed in as ``like`` supports
     *             the ``__array_function__`` protocol, the result will be defined
     *             by it. In this case, it ensures the creation of an array object
     *             compatible with that passed in via this argument.
     *             
     *             .. versionadded:: 1.20.0
     * 
     * @return out ndarray<br>
     *             `n` x `n` array with its main diagonal set to one,
     *             and all other elements 0.
     */
    public final Object identity(Object n, Object... args) {
        write("np.identity("+PythonGrammar.toPythonArgs(n)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the imaginary part of the complex argument.
     * 
     * @param val array_like<br>
     *            Input array.
     * 
     * @return out ndarray or scalar<br>
     *             The imaginary component of the complex argument. If `val` is real,
     *             the type of `val` is used for the output.  If `val` has complex
     *             elements, the returned type is float.
     */
    public final Object imag(Object val) {
        write("np.imag("+PythonGrammar.toPythonArgs(val)+")");
        return null;
    }

    /**
     * Test whether each element of a 1-D array is also present in a second array.
     * 
     * Returns a boolean array the same length as `ar1` that is True
     * where an element of `ar1` is in `ar2` and False otherwise.
     * 
     * We recommend using :func:`isin` instead of `in1d` for new code.
     * <p>
     * <em>Notes:</em><br>
     * `in1d` can be considered as an element-wise function version of the
     * python keyword `in`, for 1-D sequences. ``in1d(a, b)`` is roughly
     * equivalent to ``np.array([item in b for item in a])``.
     * However, this idea fails if `ar2` is a set, or similar (non-sequence)
     * container:  As ``ar2`` is converted to an array, in those cases
     * ``asarray(ar2)`` is an object array rather than the expected array of
     * contained values.
     * 
     * .. versionadded:: 1.4.0
     * 
     * @param ar1 (M,) array_like<br>
     *            Input array.
     * @param ar2 array_like<br>
     *            The values against which to test each value of `ar1`.
     * @param assume_unique bool, optional<br>
     *                      If True, the input arrays are both assumed to be unique, which
     *                      can speed up the calculation.  Default is False.
     * @param invert bool, optional<br>
     *               If True, the values in the returned array are inverted (that is,
     *               False where an element of `ar1` is in `ar2` and True otherwise).
     *               Default is False. ``np.in1d(a, b, invert=True)`` is equivalent
     *               to (but is faster than) ``np.invert(in1d(a, b))``.
     *               
     *               .. versionadded:: 1.8.0
     * 
     * @return in1d (M,) ndarray, bool<br>
     *              The values `ar1[in1d]` are in `ar2`.
     */
    public final Object in1d(Object ar1, Object ar2, Object... args) {
        write("np.in1d("+PythonGrammar.toPythonArgs(ar1),PythonGrammar.toPythonArgs(ar2)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return an array representing the indices of a grid.
     * 
     * Compute an array where the subarrays contain index values 0, 1, ...
     * varying only along the corresponding axis.
     * <p>
     * <em>Notes:</em><br>
     * The output shape in the dense case is obtained by prepending the number
     * of dimensions in front of the tuple of dimensions, i.e. if `dimensions`
     * is a tuple ``(r0, ..., rN-1)`` of length ``N``, the output shape is
     * ``(N, r0, ..., rN-1)``.
     * 
     * The subarrays ``grid[k]`` contains the N-D array of indices along the
     * ``k-th`` axis. Explicitly::
     * 
     * grid[k, i0, i1, ..., iN-1] = ik
     * 
     * @param dimensions sequence of ints<br>
     *                   The shape of the grid.
     * @param dtype dtype, optional<br>
     *              Data type of the result.
     * @param sparse boolean, optional<br>
     *               Return a sparse representation of the grid instead of a dense
     *               representation. Default is False.
     *               
     *               .. versionadded:: 1.17
     * 
     * @return grid one ndarray or tuple of ndarrays<br>
     *              If sparse is False:
     *              Returns one array of grid indices,
     *              ``grid.shape = (len(dimensions),) + tuple(dimensions)``.
     *              If sparse is True:
     *              Returns a tuple of arrays, with
     *              ``grid[i].shape = (1, ..., 1, dimensions[i], 1, ..., 1)`` with
     *              dimensions[i] in the ith place
     */
    public final Object indices(Object dimensions, Object... args) {
        write("np.indices("+PythonGrammar.toPythonArgs(dimensions)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Get help information for a function, class, or module.
     * <p>
     * <em>Notes:</em><br>
     * When used interactively with an object, ``np.info(obj)`` is equivalent
     * to ``help(obj)`` on the Python prompt or ``obj?`` on the IPython
     * prompt.
     * 
     * @param object object or str, optional<br>
     *               Input object or name to get information about. If `object` is a
     *               numpy object, its docstring is given. If it is a string, available
     *               modules are searched for matching objects.  If None, information
     *               about `info` itself is returned.
     * @param maxwidth int, optional<br>
     *                 Printing width.
     * @param output file like object, optional<br>
     *               File like object that the output is written to, default is
     *               ``stdout``.  The object has to be opened in 'w' or 'a' mode.
     * @param toplevel str, optional<br>
     *                 Start search at this level.
     */
    public final Object info(Object... args) {
        write("np.info("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * inner(a, b)
     * 
     * Inner product of two arrays.
     * 
     * Ordinary inner product of vectors for 1-D arrays (without complex
     * conjugation), in higher dimensions a sum product over the last axes.
     * <p>
     * <em>Notes:</em><br>
     * For vectors (1-D arrays) it computes the ordinary inner-product::
     * 
     * np.inner(a, b) = sum(a[:]*b[:])
     * 
     * More generally, if `ndim(a) = r > 0` and `ndim(b) = s > 0`::
     * 
     * np.inner(a, b) = np.tensordot(a, b, axes=(-1,-1))
     * 
     * or explicitly::
     * 
     * np.inner(a, b)[i0,...,ir-2,j0,...,js-2]
     * = sum(a[i0,...,ir-2,:]*b[j0,...,js-2,:])
     * 
     * In addition `a` or `b` may be scalars, in which case::
     * 
     * np.inner(a,b) = a*b
     * 
     * @param a array_like<br>
     *          If `a` and `b` are nonscalar, their last dimensions must match.
     * @param b array_like<br>
     *          If `a` and `b` are nonscalar, their last dimensions must match.
     * @param ... n/a<br>undocumented
     * 
     * @return out ndarray<br>
     *             If `a` and `b` are both
     *             scalars or both 1-D arrays then a scalar is returned; otherwise
     *             an array is returned.
     *             ``out.shape = (*a.shape[:-1], *b.shape[:-1])``
     */
    public final Object inner(Object... args) {
        write("np.inner("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Insert values along the given axis before the given indices.
     * <p>
     * <em>Notes:</em><br>
     * Note that for higher dimensional inserts `obj=0` behaves very different
     * from `obj=[0]` just like `arr[:,0,:] = values` is different from
     * `arr[:,[0],:] = values`.
     * 
     * @param arr array_like<br>
     *            Input array.
     * @param obj int, slice or sequence of ints<br>
     *            Object that defines the index or indices before which `values` is
     *            inserted.
     *            
     *            .. versionadded:: 1.8.0
     *            
     *            Support for multiple insertions when `obj` is a single scalar or a
     *            sequence with one element (similar to calling insert multiple
     *            times).
     * @param values array_like<br>
     *               Values to insert into `arr`. If the type of `values` is different
     *               from that of `arr`, `values` is converted to the type of `arr`.
     *               `values` should be shaped so that ``arr[...,obj,...] = values``
     *               is legal.
     * @param axis int, optional<br>
     *             Axis along which to insert `values`.  If `axis` is None then `arr`
     *             is flattened first.
     * 
     * @return out ndarray<br>
     *             A copy of `arr` with `values` inserted.  Note that `insert`
     *             does not occur in-place: a new array is returned. If
     *             `axis` is None, `out` is a flattened array.
     */
    public final Object insert(Object arr, Object obj, Object values, Object... args) {
        write("np.insert("+PythonGrammar.toPythonArgs(arr),PythonGrammar.toPythonArgs(obj),PythonGrammar.toPythonArgs(values)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * One-dimensional linear interpolation for monotonically increasing sample points.
     * 
     * Returns the one-dimensional piecewise linear interpolant to a function
     * with given discrete data points (`xp`, `fp`), evaluated at `x`.
     * 
     * @param x array_like<br>
     *          The x-coordinates at which to evaluate the interpolated values.
     *          
     * @param xp 1-D sequence of floats<br>
     *           The x-coordinates of the data points, must be increasing if argument
     *           `period` is not specified. Otherwise, `xp` is internally sorted after
     *           normalizing the periodic boundaries with ``xp = xp % period``.
     *           
     * @param fp 1-D sequence of float or complex<br>
     *           The y-coordinates of the data points, same length as `xp`.
     *           
     * @param left optional float or complex corresponding to fp<br>
     *             Value to return for `x &lt; xp[0]`, default is `fp[0]`.
     *             
     * @param right optional float or complex corresponding to fp<br>
     *              Value to return for `x &gt; xp[-1]`, default is `fp[-1]`.
     *              
     * @param period None or float, optional<br>
     *               A period for the x-coordinates. This parameter allows the proper
     *               interpolation of angular x-coordinates. Parameters `left` and `right`
     *               are ignored if `period` is specified.
     *               
     *               .. versionadded:: 1.10.0
     * 
     * @return y float or complex (corresponding to fp) or ndarray<br>
     *           The interpolated values, same shape as `x`.
     */
    public final Object interp(Object x, Object xp, Object fp, Object... args) {
        write("np.interp("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(xp),PythonGrammar.toPythonArgs(fp)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find the intersection of two arrays.
     * 
     * Return the sorted, unique values that are in both of the input arrays.
     * 
     * @param ar1 array_like<br>
     *            Input arrays. Will be flattened if not already 1D.
     * @param ar2 array_like<br>
     *            Input arrays. Will be flattened if not already 1D.
     * @param assume_unique bool<br>
     *                      If True, the input arrays are both assumed to be unique, which
     *                      can speed up the calculation.  If True but ``ar1`` or ``ar2`` are not
     *                      unique, incorrect results and out-of-bounds indices could result.
     *                      Default is False.
     * @param return_indices bool<br>
     *                       If True, the indices which correspond to the intersection of the two
     *                       arrays are returned. The first instance of a value is used if there are
     *                       multiple. Default is False.
     *                       
     *                       .. versionadded:: 1.15.0
     * 
     * @return (intersect1d,comm1,comm2) (ndarray,ndarray,ndarray)<br>
     *          Sorted 1D array of common and unique elements.
     *          
     *          The indices of the first occurrences of the common values in `ar1`.
     *          Only provided if `return_indices` is True.
     *          
     *          The indices of the first occurrences of the common values in `ar2`.
     *          Only provided if `return_indices` is True.
     */
    public final Object intersect1d(Object ar1, Object ar2, Object... args) {
        write("np.intersect1d("+PythonGrammar.toPythonArgs(ar1),PythonGrammar.toPythonArgs(ar2)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * is_busday(dates, weekmask='1111100', holidays=None, busdaycal=None, out=None)
     * 
     * Calculates which of the given dates are valid days, and which are not.
     * 
     * .. versionadded:: 1.7.0
     * 
     * @param dates array_like of datetime64[D]<br>
     *              The array of dates to process.
     * @param weekmask str or array_like of bool, optional<br>
     *                 A seven-element array indicating which of Monday through Sunday are
     *                 valid days. May be specified as a length-seven list or array, like
     *                 [1,1,1,1,1,0,0]; a length-seven string, like '1111100'; or a string
     *                 like "Mon Tue Wed Thu Fri", made up of 3-character abbreviations for
     *                 weekdays, optionally separated by white space. Valid abbreviations
     *                 are: Mon Tue Wed Thu Fri Sat Sun
     * @param holidays array_like of datetime64[D], optional<br>
     *                 An array of dates to consider as invalid dates.  They may be
     *                 specified in any order, and NaT (not-a-time) dates are ignored.
     *                 This list is saved in a normalized form that is suited for
     *                 fast calculations of valid days.
     * @param busdaycal busdaycalendar, optional<br>
     *                  A `busdaycalendar` object which specifies the valid days. If this
     *                  parameter is provided, neither weekmask nor holidays may be
     *                  provided.
     * @param out array of bool, optional<br>
     *            If provided, this array is filled with the result.
     * 
     * @return out array of bool<br>
     *             An array with the same shape as ``dates``, containing True for
     *             each valid day, and False for each invalid day.
     */
    public final Object is_busday(Object... args) {
        write("np.is_busday("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Returns a boolean array where two arrays are element-wise equal within a
     * tolerance.
     * 
     * The tolerance values are positive, typically very small numbers.  The
     * relative difference (`rtol` * abs(`b`)) and the absolute difference
     * `atol` are added together to compare against the absolute difference
     * between `a` and `b`.
     * 
     * .. warning:: The default `atol` is not appropriate for comparing numbers
     * that are much smaller than one (see Notes).
     * <p>
     * <em>Notes:</em><br>
     * .. versionadded:: 1.7.0
     * 
     * For finite values, isclose uses the following equation to test whether
     * two floating point values are equivalent.
     * 
     * absolute(`a` - `b`) <= (`atol` + `rtol` * absolute(`b`))
     * 
     * Unlike the built-in `math.isclose`, the above equation is not symmetric
     * in `a` and `b` -- it assumes `b` is the reference value -- so that
     * `isclose(a, b)` might be different from `isclose(b, a)`. Furthermore,
     * the default value of atol is not zero, and is used to determine what
     * small values should be considered close to zero. The default value is
     * appropriate for expected values of order unity: if the expected values
     * are significantly smaller than one, it can result in false positives.
     * `atol` should be carefully selected for the use case at hand. A zero value
     * for `atol` will result in `False` if either `a` or `b` is zero.
     * 
     * `isclose` is not defined for non-numeric data types.
     * 
     * @param a array_like<br>
     *          Input arrays to compare.
     * @param b array_like<br>
     *          Input arrays to compare.
     * @param rtol float<br>
     *             The relative tolerance parameter (see Notes).
     * @param atol float<br>
     *             The absolute tolerance parameter (see Notes).
     * @param equal_nan bool<br>
     *                  Whether to compare NaN's as equal.  If True, NaN's in `a` will be
     *                  considered equal to NaN's in `b` in the output array.
     * 
     * @return y array_like<br>
     *           Returns a boolean array of where `a` and `b` are equal within the
     *           given tolerance. If both `a` and `b` are scalars, returns a single
     *           boolean value.
     */
    public final Object isclose(Object a, Object b, Object... args) {
        write("np.isclose("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(b)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Returns a bool array, where True if input element is complex.
     * 
     * What is tested is whether the input has a non-zero imaginary part, not if
     * the input type is complex.
     * 
     * @param x array_like<br>
     *          Input array.
     * 
     * @return out ndarray of bools<br>
     *             Output array.
     */
    public final Object iscomplex(Object x) {
        write("np.iscomplex("+PythonGrammar.toPythonArgs(x)+")");
        return null;
    }

    /**
     * Check for a complex type or an array of complex numbers.
     * 
     * The type of the input is checked, not the value. Even if the input
     * has an imaginary part equal to zero, `iscomplexobj` evaluates to True.
     * 
     * @param x any<br>
     *          The input can be of any type and shape.
     * 
     * @return iscomplexobj bool<br>
     *                      The return value, True if `x` is of a complex type or has at least
     *                      one complex element.
     */
    public final Object iscomplexobj(Object x) {
        write("np.iscomplexobj("+PythonGrammar.toPythonArgs(x)+")");
        return null;
    }

    /**
     * Check if the array is Fortran contiguous but *not* C contiguous.
     * 
     * This function is obsolete and, because of changes due to relaxed stride
     * checking, its return value for the same array may differ for versions
     * of NumPy >= 1.10.0 and previous versions. If you only want to check if an
     * array is Fortran contiguous use ``a.flags.f_contiguous`` instead.
     * 
     * @param a ndarray<br>
     *          Input array.
     * 
     * @return isfortran bool<br>
     *                   Returns True if the array is Fortran contiguous but *not* C contiguous.
     */
    public final Object isfortran(Object a) {
        write("np.isfortran("+PythonGrammar.toPythonArgs(a)+")");
        return null;
    }

    /**
     * Calculates `element in test_elements`, broadcasting over `element` only.
     * Returns a boolean array of the same shape as `element` that is True
     * where an element of `element` is in `test_elements` and False otherwise.
     * <p>
     * <em>Notes:</em><br>
     * `isin` is an element-wise function version of the python keyword `in`.
     * ``isin(a, b)`` is roughly equivalent to
     * ``np.array([item in b for item in a])`` if `a` and `b` are 1-D sequences.
     * 
     * `element` and `test_elements` are converted to arrays if they are not
     * already. If `test_elements` is a set (or other non-sequence collection)
     * it will be converted to an object array with one element, rather than an
     * array of the values contained in `test_elements`. This is a consequence
     * of the `array` constructor's way of handling non-sequence collections.
     * Converting the set to a list usually gives the desired behavior.
     * 
     * .. versionadded:: 1.13.0
     * 
     * @param element array_like<br>
     *                Input array.
     * @param test_elements array_like<br>
     *                      The values against which to test each value of `element`.
     *                      This argument is flattened if it is an array or array_like.
     *                      See notes for behavior with non-array-like parameters.
     * @param assume_unique bool, optional<br>
     *                      If True, the input arrays are both assumed to be unique, which
     *                      can speed up the calculation.  Default is False.
     * @param invert bool, optional<br>
     *               If True, the values in the returned array are inverted, as if
     *               calculating `element not in test_elements`. Default is False.
     *               ``np.isin(a, b, invert=True)`` is equivalent to (but faster
     *               than) ``np.invert(np.isin(a, b))``.
     * 
     * @return isin ndarray, bool<br>
     *              Has the same shape as `element`. The values `element[isin]`
     *              are in `test_elements`.
     */
    public final Object isin(Object element, Object test_elements, Object... args) {
        write("np.isin("+PythonGrammar.toPythonArgs(element),PythonGrammar.toPythonArgs(test_elements)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Test element-wise for negative infinity, return result as bool array.
     * <p>
     * <em>Notes:</em><br>
     * NumPy uses the IEEE Standard for Binary Floating-Point for Arithmetic
     * (IEEE 754).
     * 
     * Errors result if the second argument is also supplied when x is a scalar
     * input, if first and second arguments have different shapes, or if the
     * first argument has complex values.
     * 
     * @param x array_like<br>
     *          The input array.
     * @param out array_like, optional<br>
     *            A location into which the result is stored. If provided, it must have a
     *            shape that the input broadcasts to. If not provided or None, a
     *            freshly-allocated boolean array is returned.
     * 
     * @return out ndarray<br>
     *             A boolean array with the same dimensions as the input.
     *             If second argument is not supplied then a numpy boolean array is
     *             returned with values True where the corresponding element of the
     *             input is negative infinity and values False where the element of
     *             the input is not negative infinity.
     *             
     *             If a second argument is supplied the result is stored there. If the
     *             type of that array is a numeric type the result is represented as
     *             zeros and ones, if the type is boolean then as False and True. The
     *             return value `out` is then a reference to that array.
     */
    public final Object isneginf(Object x, Object... args) {
        write("np.isneginf("+PythonGrammar.toPythonArgs(x)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Test element-wise for positive infinity, return result as bool array.
     * <p>
     * <em>Notes:</em><br>
     * NumPy uses the IEEE Standard for Binary Floating-Point for Arithmetic
     * (IEEE 754).
     * 
     * Errors result if the second argument is also supplied when x is a scalar
     * input, if first and second arguments have different shapes, or if the
     * first argument has complex values
     * 
     * @param x array_like<br>
     *          The input array.
     * @param out array_like, optional<br>
     *            A location into which the result is stored. If provided, it must have a
     *            shape that the input broadcasts to. If not provided or None, a
     *            freshly-allocated boolean array is returned.
     * 
     * @return out ndarray<br>
     *             A boolean array with the same dimensions as the input.
     *             If second argument is not supplied then a boolean array is returned
     *             with values True where the corresponding element of the input is
     *             positive infinity and values False where the element of the input is
     *             not positive infinity.
     *             
     *             If a second argument is supplied the result is stored there. If the
     *             type of that array is a numeric type the result is represented as zeros
     *             and ones, if the type is boolean then as False and True.
     *             The return value `out` is then a reference to that array.
     */
    public final Object isposinf(Object x, Object... args) {
        write("np.isposinf("+PythonGrammar.toPythonArgs(x)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Returns a bool array, where True if input element is real.
     * 
     * If element has complex type with zero complex part, the return value
     * for that element is True.
     * <p>
     * <em>Notes:</em><br>
     * `isreal` may behave unexpectedly for string or object arrays (see examples)
     * 
     * @param x array_like<br>
     *          Input array.
     * 
     * @return out ndarray, bool<br>
     *             Boolean array of same shape as `x`.
     */
    public final Object isreal(Object x) {
        write("np.isreal("+PythonGrammar.toPythonArgs(x)+")");
        return null;
    }

    /**
     * Return True if x is a not complex type or an array of complex numbers.
     * 
     * The type of the input is checked, not the value. So even if the input
     * has an imaginary part equal to zero, `isrealobj` evaluates to False
     * if the data type is complex.
     * <p>
     * <em>Notes:</em><br>
     * The function is only meant for arrays with numerical values but it
     * accepts all other objects. Since it assumes array input, the return
     * value of other objects may be True.
     * 
     * >>> np.isrealobj('A string')
     * True
     * >>> np.isrealobj(False)
     * True
     * >>> np.isrealobj(None)
     * True
     * 
     * @param x any<br>
     *          The input can be of any type and shape.
     * 
     * @return y bool<br>
     *           The return value, False if `x` is of a complex type.
     */
    public final Object isrealobj(Object x) {
        write("np.isrealobj("+PythonGrammar.toPythonArgs(x)+")");
        return null;
    }

    /**
     * Returns True if the type of `element` is a scalar type.
     * <p>
     * <em>Notes:</em><br>
     * If you need a stricter way to identify a *numerical* scalar, use
     * ``isinstance(x, numbers.Number)``, as that returns ``False`` for most
     * non-numerical elements such as strings.
     * 
     * In most cases ``np.ndim(x) == 0`` should be used instead of this function,
     * as that will also return true for 0d arrays. This is how numpy overloads
     * functions in the style of the ``dx`` arguments to `gradient` and the ``bins``
     * argument to `histogram`. Some key differences:
     * 
     * +--------------------------------------+---------------+-------------------+
     * | x                                    |``isscalar(x)``|``np.ndim(x) == 0``|
     * +======================================+===============+===================+
     * | PEP 3141 numeric objects (including  | ``True``      | ``True``          |
     * | builtins)                            |               |                   |
     * +--------------------------------------+---------------+-------------------+
     * | builtin string and buffer objects    | ``True``      | ``True``          |
     * +--------------------------------------+---------------+-------------------+
     * | other builtin objects, like          | ``False``     | ``True``          |
     * | `pathlib.Path`, `Exception`,         |               |                   |
     * | the result of `re.compile`           |               |                   |
     * +--------------------------------------+---------------+-------------------+
     * | third-party objects like             | ``False``     | ``True``          |
     * | `matplotlib.figure.Figure`           |               |                   |
     * +--------------------------------------+---------------+-------------------+
     * | zero-dimensional numpy arrays        | ``False``     | ``True``          |
     * +--------------------------------------+---------------+-------------------+
     * | other numpy arrays                   | ``False``     | ``False``         |
     * +--------------------------------------+---------------+-------------------+
     * | `list`, `tuple`, and other sequence  | ``False``     | ``False``         |
     * | objects                              |               |                   |
     * +--------------------------------------+---------------+-------------------+
     * 
     * @param element any<br>
     *                Input argument, can be of any type and shape.
     * 
     * @return val bool<br>
     *             True if `element` is a scalar type, False if it is not.
     */
    public final Object isscalar(Object element) {
        write("np.isscalar("+PythonGrammar.toPythonArgs(element)+")");
        return null;
    }

    /**
     * Determines whether the given object represents a scalar data-type.
     * 
     * @param rep any<br>
     *            If `rep` is an instance of a scalar dtype, True is returned. If not,
     *            False is returned.
     * 
     * @return out bool<br>
     *             Boolean result of check whether `rep` is a scalar dtype.
     */
    public final Object issctype(Object rep) {
        write("np.issctype("+PythonGrammar.toPythonArgs(rep)+")");
        return null;
    }

    /**
     * Determine if a class is a subclass of a second class.
     * 
     * `issubclass_` is equivalent to the Python built-in ``issubclass``,
     * except that it returns False instead of raising a TypeError if one
     * of the arguments is not a class.
     * 
     * @param arg1 class<br>
     *             Input class. True is returned if `arg1` is a subclass of `arg2`.
     * @param arg2 class or tuple of classes.<br>
     *             Input class. If a tuple of classes, True is returned if `arg1` is a
     *             subclass of any of the tuple elements.
     * 
     * @return out bool<br>
     *             Whether `arg1` is a subclass of `arg2` or not.
     */
    public final Object issubclass_(Object arg1, Object arg2) {
        write("np.issubclass_("+PythonGrammar.toPythonArgs(arg1),PythonGrammar.toPythonArgs(arg2)+")");
        return null;
    }

    /**
     * Returns True if first argument is a typecode lower/equal in type hierarchy.
     * 
     * This is like the builtin :func:`issubclass`, but for `dtype`\ s.
     * 
     * @param arg1 dtype_like<br>
     *             `dtype` or object coercible to one
     * @param arg2 dtype_like<br>
     *             `dtype` or object coercible to one
     * 
     * @return out bool<br>
     */
    public final Object issubdtype(Object arg1, Object arg2) {
        write("np.issubdtype("+PythonGrammar.toPythonArgs(arg1),PythonGrammar.toPythonArgs(arg2)+")");
        return null;
    }

    /**
     * Determine if the first argument is a subclass of the second argument.
     * 
     * @param arg1 dtype or dtype specifier<br>
     *             Data-types.
     * @param arg2 dtype or dtype specifier<br>
     *             Data-types.
     * 
     * @return out bool<br>
     *             The result.
     */
    public final Object issubsctype(Object arg1, Object arg2) {
        write("np.issubsctype("+PythonGrammar.toPythonArgs(arg1),PythonGrammar.toPythonArgs(arg2)+")");
        return null;
    }

    /**
     * Check whether or not an object can be iterated over.
     * 
     * @param y object<br>
     *          Input object.
     * 
     * @return b bool<br>
     *           Return ``True`` if the object has an iterator method or is a
     *           sequence and ``False`` otherwise.
     */
    public final Object iterable(Object y) {
        write("np.iterable("+PythonGrammar.toPythonArgs(y)+")");
        return null;
    }

    /**
     * Construct an open mesh from multiple sequences.
     * 
     * This function takes N 1-D sequences and returns N outputs with N
     * dimensions each, such that the shape is 1 in all but one dimension
     * and the dimension with the non-unit shape value cycles through all
     * N dimensions.
     * 
     * Using `ix_` one can quickly construct index arrays that will index
     * the cross product. ``a[np.ix_([1,3],[2,5])]`` returns the array
     * ``[[a[1,2] a[1,5]], [a[3,2] a[3,5]]]``.
     * 
     * @param args 1-D sequences<br>
     *             Each sequence should be of integer or boolean type.
     *             Boolean sequences will be interpreted as boolean masks for the
     *             corresponding dimension (equivalent to passing in
     *             ``np.nonzero(boolean_sequence)``).
     * 
     * @return out tuple of ndarrays<br>
     *             N arrays with N dimensions each, with N the number of input
     *             sequences. Together these arrays form an open mesh.
     */
    public final Object ix_(Object args) {
        write("np.ix_("+PythonGrammar.toPythonArgs(args)+")");
        return null;
    }

    /**
     * Return the Kaiser window.
     * 
     * The Kaiser window is a taper formed by using a Bessel function.
     * <p>
     * <em>Notes:</em><br>
     * The Kaiser window is defined as
     * 
     * .. math::  w(n) = I_0\left( \beta \sqrt{1-\frac{4n^2}{(M-1)^2}}
     * \right)/I_0(\beta)
     * 
     * with
     * 
     * .. math:: \quad -\frac{M-1}{2} \leq n \leq \frac{M-1}{2},
     * 
     * where :math:`I_0` is the modified zeroth-order Bessel function.
     * 
     * The Kaiser was named for Jim Kaiser, who discovered a simple
     * approximation to the DPSS window based on Bessel functions.  The Kaiser
     * window is a very good approximation to the Digital Prolate Spheroidal
     * Sequence, or Slepian window, which is the transform which maximizes the
     * energy in the main lobe of the window relative to total energy.
     * 
     * The Kaiser can approximate many other windows by varying the beta
     * parameter.
     * 
     * ====  =======================
     * beta  Window shape
     * ====  =======================
     * 0     Rectangular
     * 5     Similar to a Hamming
     * 6     Similar to a Hanning
     * 8.6   Similar to a Blackman
     * ====  =======================
     * 
     * A beta value of 14 is probably a good starting point. Note that as beta
     * gets large, the window narrows, and so the number of samples needs to be
     * large enough to sample the increasingly narrow spike, otherwise NaNs will
     * get returned.
     * 
     * Most references to the Kaiser window come from the signal processing
     * literature, where it is used as one of many windowing functions for
     * smoothing values.  It is also known as an apodization (which means
     * "removing the foot", i.e. smoothing discontinuities at the beginning
     * and end of the sampled signal) or tapering function.
     * 
     * @param M int<br>
     *          Number of points in the output window. If zero or less, an
     *          empty array is returned.
     * @param beta float<br>
     *             Shape parameter for window.
     * 
     * @return out array<br>
     *             The window, with the maximum value normalized to one (the value
     *             one appears only if the number of samples is odd).
     */
    public final Object kaiser(Object M, Object beta) {
        write("np.kaiser("+PythonGrammar.toPythonArgs(M),PythonGrammar.toPythonArgs(beta)+")");
        return null;
    }

    /**
     * Kronecker product of two arrays.
     * 
     * Computes the Kronecker product, a composite array made of blocks of the
     * second array scaled by the first.
     * <p>
     * <em>Notes:</em><br>
     * The function assumes that the number of dimensions of `a` and `b`
     * are the same, if necessary prepending the smallest with ones.
     * If ``a.shape = (r0,r1,..,rN)`` and ``b.shape = (s0,s1,...,sN)``,
     * the Kronecker product has shape ``(r0*s0, r1*s1, ..., rN*SN)``.
     * The elements are products of elements from `a` and `b`, organized
     * explicitly by::
     * 
     * kron(a,b)[k0,k1,...,kN] = a[i0,i1,...,iN] * b[j0,j1,...,jN]
     * 
     * where::
     * 
     * kt = it * st + jt,  t = 0,...,N
     * 
     * In the common 2-D case (N=1), the block structure can be visualized::
     * 
     * [[ a[0,0]*b,   a[0,1]*b,  ... , a[0,-1]*b  ],
     * [  ...                              ...   ],
     * [ a[-1,0]*b,  a[-1,1]*b, ... , a[-1,-1]*b ]]
     * 
     * @param a array_like<br>
     * @param b array_like<br>
     * 
     * @return out ndarray<br>
     */
    public final Object kron(Object a, Object b) {
        write("np.kron("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(b)+")");
        return null;
    }

    /**
     * lexsort(keys, axis=-1)
     * 
     * Perform an indirect stable sort using a sequence of keys.
     * 
     * Given multiple sorting keys, which can be interpreted as columns in a
     * spreadsheet, lexsort returns an array of integer indices that describes
     * the sort order by multiple columns. The last key in the sequence is used
     * for the primary sort order, the second-to-last key for the secondary sort
     * order, and so on. The keys argument must be a sequence of objects that
     * can be converted to arrays of the same shape. If a 2D array is provided
     * for the keys argument, its rows are interpreted as the sorting keys and
     * sorting is according to the last row, second last row etc.
     * 
     * @param keys (k, N) array or tuple containing k (N,)-shaped sequences<br>
     *             The `k` different "columns" to be sorted.  The last column (or row if
     *             `keys` is a 2D array) is the primary sort key.
     * @param axis int, optional<br>
     *             Axis to be indirectly sorted.  By default, sort over the last axis.
     * @param ... n/a<br>undocumented
     * 
     * @return indices (N,) ndarray of ints<br>
     *                 Array of indices that sort the keys along the specified axis.
     */
    public final Object lexsort(Object... args) {
        write("np.lexsort("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return evenly spaced numbers over a specified interval.
     * 
     * Returns `num` evenly spaced samples, calculated over the
     * interval [`start`, `stop`].
     * 
     * The endpoint of the interval can optionally be excluded.
     * 
     * .. versionchanged:: 1.16.0
     * Non-scalar `start` and `stop` are now supported.
     * 
     * .. versionchanged:: 1.20.0
     * Values are rounded towards ``-inf`` instead of ``0`` when an
     * integer ``dtype`` is specified. The old behavior can
     * still be obtained with ``np.linspace(start, stop, num).astype(int)``
     * 
     * @param start array_like<br>
     *              The starting value of the sequence.
     * @param stop array_like<br>
     *             The end value of the sequence, unless `endpoint` is set to False.
     *             In that case, the sequence consists of all but the last of ``num + 1``
     *             evenly spaced samples, so that `stop` is excluded.  Note that the step
     *             size changes when `endpoint` is False.
     * @param num int, optional<br>
     *            Number of samples to generate. Default is 50. Must be non-negative.
     * @param endpoint bool, optional<br>
     *                 If True, `stop` is the last sample. Otherwise, it is not included.
     *                 Default is True.
     * @param retstep bool, optional<br>
     *                If True, return (`samples`, `step`), where `step` is the spacing
     *                between samples.
     * @param dtype dtype, optional<br>
     *              The type of the output array.  If `dtype` is not given, the data type
     *              is inferred from `start` and `stop`. The inferred dtype will never be
     *              an integer; `float` is chosen even if the arguments would produce an
     *              array of integers.
     *              
     *              .. versionadded:: 1.9.0
     *              
     * @param axis int, optional<br>
     *             The axis in the result to store the samples.  Relevant only if start
     *             or stop are array-like.  By default (0), the samples will be along a
     *             new axis inserted at the beginning. Use -1 to get an axis at the end.
     *             
     *             .. versionadded:: 1.16.0
     * 
     * @return (samples,step) (ndarray,float, optional)<br>
     *          There are `num` equally spaced samples in the closed interval
     *          ``[start, stop]`` or the half-open interval ``[start, stop)``
     *          (depending on whether `endpoint` is True or False).
     *          
     *          Only returned if `retstep` is True
     *          
     *          Size of spacing between samples.
     */
    public final Object linspace(Object start, Object stop, Object... args) {
        write("np.linspace("+PythonGrammar.toPythonArgs(start),PythonGrammar.toPythonArgs(stop)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Load arrays or pickled objects from ``.npy``, ``.npz`` or pickled files.
     * 
     * .. warning:: Loading files that contain object arrays uses the ``pickle``
     * module, which is not secure against erroneous or maliciously
     * constructed data. Consider passing ``allow_pickle=False`` to
     * load data that is known not to contain object arrays for the
     * safer handling of untrusted sources.
     * <p>
     * <em>Notes:</em><br>
     * - If the file contains pickle data, then whatever object is stored
     * in the pickle is returned.
     * - If the file is a ``.npy`` file, then a single array is returned.
     * - If the file is a ``.npz`` file, then a dictionary-like object is
     * returned, containing ``{filename: array}`` key-value pairs, one for
     * each file in the archive.
     * - If the file is a ``.npz`` file, the returned value supports the
     * context manager protocol in a similar fashion to the open function::
     * 
     * with load('foo.npz') as data:
     * a = data['a']
     * 
     * The underlying file descriptor is closed when exiting the 'with'
     * block.
     * 
     * @param file file-like object, string, or pathlib.Path<br>
     *             The file to read. File-like objects must support the
     *             ``seek()`` and ``read()`` methods. Pickled files require that the
     *             file-like object support the ``readline()`` method as well.
     * @param mmap_mode &#123;None, 'r+', 'r', 'w+', 'c'&#125;, optional<br>
     *                  If not None, then memory-map the file, using the given mode (see
     *                  `numpy.memmap` for a detailed description of the modes).  A
     *                  memory-mapped array is kept on disk. However, it can be accessed
     *                  and sliced like any ndarray.  Memory mapping is especially useful
     *                  for accessing small fragments of large files without reading the
     *                  entire file into memory.
     * @param allow_pickle bool, optional<br>
     *                     Allow loading pickled object arrays stored in npy files. Reasons for
     *                     disallowing pickles include security, as loading pickled data can
     *                     execute arbitrary code. If pickles are disallowed, loading object
     *                     arrays will fail. Default: False
     *                     
     *                     .. versionchanged:: 1.16.3
     *                     Made default False in response to CVE-2019-6446.
     *                     
     * @param fix_imports bool, optional<br>
     *                    Only useful when loading Python 2 generated pickled files on Python 3,
     *                    which includes npy/npz files containing object arrays. If `fix_imports`
     *                    is True, pickle will try to map the old Python 2 names to the new names
     *                    used in Python 3.
     * @param encoding str, optional<br>
     *                 What encoding to use when reading Python 2 strings. Only useful when
     *                 loading Python 2 generated pickled files in Python 3, which includes
     *                 npy/npz files containing object arrays. Values other than 'latin1',
     *                 'ASCII', and 'bytes' are not allowed, as they can corrupt numerical
     *                 data. Default: 'ASCII'
     * 
     * @return result array, tuple, dict, etc.<br>
     *                Data stored in the file. For ``.npz`` files, the returned instance
     *                of NpzFile class must be closed to avoid leaking file descriptors.
     */
    public final Object load(Object file, Object... args) {
        write("np.load("+PythonGrammar.toPythonArgs(file)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**

     * 
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     */
    public final Object loads(Object... args) {
        write("np.loads("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Load data from a text file.
     * 
     * Each row in the text file must have the same number of values.
     * <p>
     * <em>Notes:</em><br>
     * This function aims to be a fast reader for simply formatted files.  The
     * `genfromtxt` function provides more sophisticated handling of, e.g.,
     * lines with missing values.
     * 
     * .. versionadded:: 1.10.0
     * 
     * The strings produced by the Python float.hex method can be used as
     * input for floats.
     * 
     * @param fname file, str, or pathlib.Path<br>
     *              File, filename, or generator to read.  If the filename extension is
     *              ``.gz`` or ``.bz2``, the file is first decompressed. Note that
     *              generators should return byte strings.
     * @param dtype data-type, optional<br>
     *              Data-type of the resulting array; default: float.  If this is a
     *              structured data-type, the resulting array will be 1-dimensional, and
     *              each row will be interpreted as an element of the array.  In this
     *              case, the number of columns used must match the number of fields in
     *              the data-type.
     * @param comments str or sequence of str, optional<br>
     *                 The characters or list of characters used to indicate the start of a
     *                 comment. None implies no comments. For backwards compatibility, byte
     *                 strings will be decoded as 'latin1'. The default is '#'.
     * @param delimiter str, optional<br>
     *                  The string used to separate values. For backwards compatibility, byte
     *                  strings will be decoded as 'latin1'. The default is whitespace.
     * @param converters dict, optional<br>
     *                   A dictionary mapping column number to a function that will parse the
     *                   column string into the desired value.  E.g., if column 0 is a date
     *                   string: ``converters = &#123;0: datestr2num&#125;``.  Converters can also be
     *                   used to provide a default value for missing data (but see also
     *                   `genfromtxt`): ``converters = &#123;3: lambda s: float(s.strip() or 0)&#125;``.
     *                   Default: None.
     * @param skiprows int, optional<br>
     *                 Skip the first `skiprows` lines, including comments; default: 0.
     * @param usecols int or sequence, optional<br>
     *                Which columns to read, with 0 being the first. For example,
     *                ``usecols = (1,4,5)`` will extract the 2nd, 5th and 6th columns.
     *                The default, None, results in all columns being read.
     *                
     *                .. versionchanged:: 1.11.0
     *                When a single column has to be read it is possible to use
     *                an integer instead of a tuple. E.g ``usecols = 3`` reads the
     *                fourth column the same way as ``usecols = (3,)`` would.
     * @param unpack bool, optional<br>
     *               If True, the returned array is transposed, so that arguments may be
     *               unpacked using ``x, y, z = loadtxt(...)``.  When used with a
     *               structured data-type, arrays are returned for each field.
     *               Default is False.
     * @param ndmin int, optional<br>
     *              The returned array will have at least `ndmin` dimensions.
     *              Otherwise mono-dimensional axes will be squeezed.
     *              Legal values: 0 (default), 1 or 2.
     *              
     *              .. versionadded:: 1.6.0
     * @param encoding str, optional<br>
     *                 Encoding used to decode the inputfile. Does not apply to input streams.
     *                 The special value 'bytes' enables backward compatibility workarounds
     *                 that ensures you receive byte arrays as results if possible and passes
     *                 'latin1' encoded strings to converters. Override this value to receive
     *                 unicode arrays and pass strings as input to converters.  If set to None
     *                 the system default is used. The default value is 'bytes'.
     *                 
     *                 .. versionadded:: 1.14.0
     * @param max_rows int, optional<br>
     *                 Read `max_rows` lines of content after `skiprows` lines. The default
     *                 is to read all the lines.
     *                 
     *                 .. versionadded:: 1.16.0
     * @param like array_like<br>
     *             Reference object to allow the creation of arrays which are not
     *             NumPy arrays. If an array-like passed in as ``like`` supports
     *             the ``__array_function__`` protocol, the result will be defined
     *             by it. In this case, it ensures the creation of an array object
     *             compatible with that passed in via this argument.
     *             
     *             .. versionadded:: 1.20.0
     * 
     * @return out ndarray<br>
     *             Data read from the text file.
     */
    public final Object loadtxt(Object fname, Object... args) {
        write("np.loadtxt("+PythonGrammar.toPythonArgs(fname)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return numbers spaced evenly on a log scale.
     * 
     * In linear space, the sequence starts at ``base ** start``
     * (`base` to the power of `start`) and ends with ``base ** stop``
     * (see `endpoint` below).
     * 
     * .. versionchanged:: 1.16.0
     * Non-scalar `start` and `stop` are now supported.
     * <p>
     * <em>Notes:</em><br>
     * Logspace is equivalent to the code
     * 
     * >>> y = np.linspace(start, stop, num=num, endpoint=endpoint)
     * ... # doctest: +SKIP
     * >>> power(base, y).astype(dtype)
     * ... # doctest: +SKIP
     * 
     * @param start array_like<br>
     *              ``base ** start`` is the starting value of the sequence.
     * @param stop array_like<br>
     *             ``base ** stop`` is the final value of the sequence, unless `endpoint`
     *             is False.  In that case, ``num + 1`` values are spaced over the
     *             interval in log-space, of which all but the last (a sequence of
     *             length `num`) are returned.
     * @param num integer, optional<br>
     *            Number of samples to generate.  Default is 50.
     * @param endpoint boolean, optional<br>
     *                 If true, `stop` is the last sample. Otherwise, it is not included.
     *                 Default is True.
     * @param base array_like, optional<br>
     *             The base of the log space. The step size between the elements in
     *             ``ln(samples) / ln(base)`` (or ``log_base(samples)``) is uniform.
     *             Default is 10.0.
     * @param dtype dtype<br>
     *              The type of the output array.  If `dtype` is not given, the data type
     *              is inferred from `start` and `stop`. The inferred type will never be
     *              an integer; `float` is chosen even if the arguments would produce an
     *              array of integers.
     * @param axis int, optional<br>
     *             The axis in the result to store the samples.  Relevant only if start
     *             or stop are array-like.  By default (0), the samples will be along a
     *             new axis inserted at the beginning. Use -1 to get an axis at the end.
     *             
     *             .. versionadded:: 1.16.0
     * 
     * @return samples ndarray<br>
     *                 `num` samples, equally spaced on a log scale.
     */
    public final Object logspace(Object start, Object stop, Object... args) {
        write("np.logspace("+PythonGrammar.toPythonArgs(start),PythonGrammar.toPythonArgs(stop)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Do a keyword search on docstrings.
     * 
     * A list of objects that matched the search is displayed,
     * sorted by relevance. All given keywords need to be found in the
     * docstring for it to be returned as a result, but the order does
     * not matter.
     * <p>
     * <em>Notes:</em><br>
     * Relevance is determined only roughly, by checking if the keywords occur
     * in the function name, at the start of a docstring, etc.
     * 
     * @param what str<br>
     *             String containing words to look for.
     * @param module str or list, optional<br>
     *               Name of module(s) whose docstrings to go through.
     * @param import_modules bool, optional<br>
     *                       Whether to import sub-modules in packages. Default is True.
     * @param regenerate bool, optional<br>
     *                   Whether to re-generate the docstring cache. Default is False.
     * @param output file-like, optional<br>
     *               File-like object to write the output to. If omitted, use a pager.
     */
    public final Object lookfor(Object what, Object... args) {
        write("np.lookfor("+PythonGrammar.toPythonArgs(what)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Load ASCII data stored in a text file and return a masked array.
     * 
     * .. deprecated:: 1.17
     * np.mafromtxt is a deprecated alias of `genfromtxt` which
     * overwrites the ``usemask`` argument with `True` even when
     * explicitly called as ``mafromtxt(..., usemask=False)``.
     * Use `genfromtxt` instead.
     * 
     * @param fname For a description of input parameters, see `genfromtxt`.<br>
     * @param kwargs For a description of input parameters, see `genfromtxt`.<br>
     */
    public final Object mafromtxt(Object fname, Object... args) {
        write("np.mafromtxt("+PythonGrammar.toPythonArgs(fname)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the indices to access (n, n) arrays, given a masking function.
     * 
     * Assume `mask_func` is a function that, for a square array a of size
     * ``(n, n)`` with a possible offset argument `k`, when called as
     * ``mask_func(a, k)`` returns a new array with zeros in certain locations
     * (functions like `triu` or `tril` do precisely this). Then this function
     * returns the indices where the non-zero values would be located.
     * <p>
     * <em>Notes:</em><br>
     * .. versionadded:: 1.4.0
     * 
     * @param n int<br>
     *          The returned indices will be valid to access arrays of shape (n, n).
     * @param mask_func callable<br>
     *                  A function whose call signature is similar to that of `triu`, `tril`.
     *                  That is, ``mask_func(x, k)`` returns a boolean array, shaped like `x`.
     *                  `k` is an optional argument to the function.
     * @param k scalar<br>
     *          An optional argument which is passed through to `mask_func`. Functions
     *          like `triu`, `tril` take a second argument that is interpreted as an
     *          offset.
     * 
     * @return indices tuple of arrays.<br>
     *                 The `n` arrays of indices corresponding to the locations where
     *                 ``mask_func(np.ones((n, n)), k)`` is True.
     */
    public final Object mask_indices(Object n, Object mask_func, Object... args) {
        write("np.mask_indices("+PythonGrammar.toPythonArgs(n),PythonGrammar.toPythonArgs(mask_func)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Interpret the input as a matrix.
     * 
     * Unlike `matrix`, `asmatrix` does not make a copy if the input is already
     * a matrix or an ndarray.  Equivalent to ``matrix(data, copy=False)``.
     * <p>
     * <em>Notes:</em><br>
     * 
     * 
     * Note that the method name deviates from the description (which is for {@link #asmatrix}). This is most likely due to mat being an alias for asmatrix.
     * 
     * @param data array_like<br>
     *             Input data.
     * @param dtype data-type<br>
     *              Data-type of the output matrix.
     * 
     * @return mat matrix<br>
     *             `data` interpreted as a matrix.
     */
    public final Object mat(Object data, Object... args) {
        write("np.mat("+PythonGrammar.toPythonArgs(data)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the maximum of an array or maximum along an axis.
     * <p>
     * <em>Notes:</em><br>
     * NaN values are propagated, that is if at least one item is NaN, the
     * corresponding max value will be NaN as well. To ignore NaN values
     * (MATLAB behavior), please use nanmax.
     * 
     * Don't use `amax` for element-wise comparison of 2 arrays; when
     * ``a.shape[0]`` is 2, ``maximum(a[0], a[1])`` is faster than
     * ``amax(a, axis=0)``.
     * 
     * 
     * Note that the method name deviates from the description (which is for {@link #amax}). This is most likely due to max being an alias for amax.
     * 
     * @param a array_like<br>
     *          Input data.
     * @param axis None or int or tuple of ints, optional<br>
     *             Axis or axes along which to operate.  By default, flattened input is
     *             used.
     *             
     *             .. versionadded:: 1.7.0
     *             
     *             If this is a tuple of ints, the maximum is selected over multiple axes,
     *             instead of a single axis or all the axes as before.
     * @param out ndarray, optional<br>
     *            Alternative output array in which to place the result.  Must
     *            be of the same shape and buffer length as the expected output.
     *            See :ref:`ufuncs-output-type` for more details.
     *            
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left
     *                 in the result as dimensions with size one. With this option,
     *                 the result will broadcast correctly against the input array.
     *                 
     *                 If the default value is passed, then `keepdims` will not be
     *                 passed through to the `amax` method of sub-classes of
     *                 `ndarray`, however any non-default value will be.  If the
     *                 sub-class' method does not implement `keepdims` any
     *                 exceptions will be raised.
     *                 
     * @param initial scalar, optional<br>
     *                The minimum value of an output element. Must be present to allow
     *                computation on empty slice. See `~numpy.ufunc.reduce` for details.
     *                
     *                .. versionadded:: 1.15.0
     *                
     * @param where array_like of bool, optional<br>
     *              Elements to compare for the maximum. See `~numpy.ufunc.reduce`
     *              for details.
     *              
     *              .. versionadded:: 1.17.0
     * 
     * @return amax ndarray or scalar<br>
     *              Maximum of `a`. If `axis` is None, the result is a scalar value.
     *              If `axis` is given, the result is an array of dimension
     *              ``a.ndim - 1``.
     */
    public final Object max(Object a, Object... args) {
        write("np.max("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the scalar type of highest precision of the same kind as the input.
     * 
     * @param t dtype or dtype specifier<br>
     *          The input data type. This can be a `dtype` object or an object that
     *          is convertible to a `dtype`.
     * 
     * @return out dtype<br>
     *             The highest precision data type of the same kind (`dtype.kind`) as `t`.
     */
    public final Object maximum_sctype(Object t) {
        write("np.maximum_sctype("+PythonGrammar.toPythonArgs(t)+")");
        return null;
    }

    /**
     * may_share_memory(a, b, max_work=None)
     * 
     * Determine if two arrays might share memory
     * 
     * A return of True does not necessarily mean that the two arrays
     * share any element.  It just means that they *might*.
     * 
     * Only the memory bounds of a and b are checked by default.
     * 
     * @param a ndarray<br>
     *          Input arrays
     * @param b ndarray<br>
     *          Input arrays
     * @param max_work int, optional<br>
     *                 Effort to spend on solving the overlap problem.  See
     *                 `shares_memory` for details.  Default for ``may_share_memory``
     *                 is to do a bounds check.
     * @param ... n/a<br>undocumented
     * 
     * @return out bool<br>
     */
    public final Object may_share_memory(Object... args) {
        write("np.may_share_memory("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Compute the arithmetic mean along the specified axis.
     * 
     * Returns the average of the array elements.  The average is taken over
     * the flattened array by default, otherwise over the specified axis.
     * `float64` intermediate and return values are used for integer inputs.
     * <p>
     * <em>Notes:</em><br>
     * The arithmetic mean is the sum of the elements along the axis divided
     * by the number of elements.
     * 
     * Note that for floating-point input, the mean is computed using the
     * same precision the input has.  Depending on the input data, this can
     * cause the results to be inaccurate, especially for `float32` (see
     * example below).  Specifying a higher-precision accumulator using the
     * `dtype` keyword can alleviate this issue.
     * 
     * By default, `float16` results are computed using `float32` intermediates
     * for extra precision.
     * 
     * @param a array_like<br>
     *          Array containing numbers whose mean is desired. If `a` is not an
     *          array, a conversion is attempted.
     * @param axis None or int or tuple of ints, optional<br>
     *             Axis or axes along which the means are computed. The default is to
     *             compute the mean of the flattened array.
     *             
     *             .. versionadded:: 1.7.0
     *             
     *             If this is a tuple of ints, a mean is performed over multiple axes,
     *             instead of a single axis or all the axes as before.
     * @param dtype data-type, optional<br>
     *              Type to use in computing the mean.  For integer inputs, the default
     *              is `float64`; for floating point inputs, it is the same as the
     *              input dtype.
     * @param out ndarray, optional<br>
     *            Alternate output array in which to place the result.  The default
     *            is ``None``; if provided, it must have the same shape as the
     *            expected output, but the type will be cast if necessary.
     *            See :ref:`ufuncs-output-type` for more details.
     *            
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left
     *                 in the result as dimensions with size one. With this option,
     *                 the result will broadcast correctly against the input array.
     *                 
     *                 If the default value is passed, then `keepdims` will not be
     *                 passed through to the `mean` method of sub-classes of
     *                 `ndarray`, however any non-default value will be.  If the
     *                 sub-class' method does not implement `keepdims` any
     *                 exceptions will be raised.
     *                 
     * @param where array_like of bool, optional<br>
     *              Elements to include in the mean. See `~numpy.ufunc.reduce` for details.
     *              
     *              .. versionadded:: 1.20.0
     * 
     * @return m ndarray, see dtype parameter above<br>
     *           If `out=None`, returns a new array containing the mean values,
     *           otherwise a reference to the output array is returned.
     */
    public final Object mean(Object a, Object... args) {
        write("np.mean("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Compute the median along the specified axis.
     * 
     * Returns the median of the array elements.
     * <p>
     * <em>Notes:</em><br>
     * Given a vector ``V`` of length ``N``, the median of ``V`` is the
     * middle value of a sorted copy of ``V``, ``V_sorted`` - i
     * e., ``V_sorted[(N-1)/2]``, when ``N`` is odd, and the average of the
     * two middle values of ``V_sorted`` when ``N`` is even.
     * 
     * @param a array_like<br>
     *          Input array or object that can be converted to an array.
     * @param axis &#123;int, sequence of int, None&#125;, optional<br>
     *             Axis or axes along which the medians are computed. The default
     *             is to compute the median along a flattened version of the array.
     *             A sequence of axes is supported since version 1.9.0.
     * @param out ndarray, optional<br>
     *            Alternative output array in which to place the result. It must
     *            have the same shape and buffer length as the expected output,
     *            but the type (of the output) will be cast if necessary.
     * @param overwrite_input bool, optional<br>
     *                        If True, then allow use of memory of input array `a` for
     *                        calculations. The input array will be modified by the call to
     *                        `median`. This will save memory when you do not need to preserve
     *                        the contents of the input array. Treat the input as undefined,
     *                        but it will probably be fully or partially sorted. Default is
     *                        False. If `overwrite_input` is ``True`` and `a` is not already an
     *                        `ndarray`, an error will be raised.
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left
     *                 in the result as dimensions with size one. With this option,
     *                 the result will broadcast correctly against the original `arr`.
     *                 
     *                 .. versionadded:: 1.9.0
     * 
     * @return median ndarray<br>
     *                A new array holding the result. If the input contains integers
     *                or floats smaller than ``float64``, then the output data-type is
     *                ``np.float64``.  Otherwise, the data-type of the output is the
     *                same as that of the input. If `out` is specified, that array is
     *                returned instead.
     */
    public final Object median(Object a, Object... args) {
        write("np.median("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return coordinate matrices from coordinate vectors.
     * 
     * Make N-D coordinate arrays for vectorized evaluations of
     * N-D scalar/vector fields over N-D grids, given
     * one-dimensional coordinate arrays x1, x2,..., xn.
     * 
     * .. versionchanged:: 1.9
     * 1-D and 0-D cases are allowed.
     * <p>
     * <em>Notes:</em><br>
     * This function supports both indexing conventions through the indexing
     * keyword argument.  Giving the string 'ij' returns a meshgrid with
     * matrix indexing, while 'xy' returns a meshgrid with Cartesian indexing.
     * In the 2-D case with inputs of length M and N, the outputs are of shape
     * (N, M) for 'xy' indexing and (M, N) for 'ij' indexing.  In the 3-D case
     * with inputs of length M, N and P, outputs are of shape (N, M, P) for
     * 'xy' indexing and (M, N, P) for 'ij' indexing.  The difference is
     * illustrated by the following code snippet::
     * 
     * xv, yv = np.meshgrid(x, y, sparse=False, indexing='ij')
     * for i in range(nx):
     * for j in range(ny):
     * # treat xv[i,j], yv[i,j]
     * 
     * xv, yv = np.meshgrid(x, y, sparse=False, indexing='xy')
     * for i in range(nx):
     * for j in range(ny):
     * # treat xv[j,i], yv[j,i]
     * 
     * In the 1-D and 0-D case, the indexing and sparse keywords have no effect.
     * 
     * @param x1 array_like<br>
     *           1-D arrays representing the coordinates of a grid.
     * @param x2 array_like<br>
     *           1-D arrays representing the coordinates of a grid.
     * @param ... array_like<br>
     *            1-D arrays representing the coordinates of a grid.
     * @param xn array_like<br>
     *           1-D arrays representing the coordinates of a grid.
     * @param indexing &#123;'xy', 'ij'&#125;, optional<br>
     *                 Cartesian ('xy', default) or matrix ('ij') indexing of output.
     *                 See Notes for more details.
     *                 
     *                 .. versionadded:: 1.7.0
     * @param sparse bool, optional<br>
     *               If True a sparse grid is returned in order to conserve memory.
     *               Default is False.
     *               
     *               .. versionadded:: 1.7.0
     * @param copy bool, optional<br>
     *             If False, a view into the original arrays are returned in order to
     *             conserve memory.  Default is True.  Please note that
     *             ``sparse=False, copy=False`` will likely return non-contiguous
     *             arrays.  Furthermore, more than one element of a broadcast array
     *             may refer to a single memory location.  If you need to write to the
     *             arrays, make copies first.
     *             
     *             .. versionadded:: 1.7.0
     * @param *xi n/a<br>undocumented
     * 
     * @return (X1,X2,...,XN) (ndarray,ndarray,ndarray,ndarray)<br>
     *          For vectors `x1`, `x2`,..., 'xn' with lengths ``Ni=len(xi)`` ,
     *          return ``(N1, N2, N3,...Nn)`` shaped arrays if indexing='ij'
     *          or ``(N2, N1, N3,...Nn)`` shaped arrays if indexing='xy'
     *          with the elements of `xi` repeated to fill the matrix along
     *          the first dimension for `x1`, the second for `x2` and so on.
     *          
     *          For vectors `x1`, `x2`,..., 'xn' with lengths ``Ni=len(xi)`` ,
     *          return ``(N1, N2, N3,...Nn)`` shaped arrays if indexing='ij'
     *          or ``(N2, N1, N3,...Nn)`` shaped arrays if indexing='xy'
     *          with the elements of `xi` repeated to fill the matrix along
     *          the first dimension for `x1`, the second for `x2` and so on.
     *          
     *          For vectors `x1`, `x2`,..., 'xn' with lengths ``Ni=len(xi)`` ,
     *          return ``(N1, N2, N3,...Nn)`` shaped arrays if indexing='ij'
     *          or ``(N2, N1, N3,...Nn)`` shaped arrays if indexing='xy'
     *          with the elements of `xi` repeated to fill the matrix along
     *          the first dimension for `x1`, the second for `x2` and so on.
     *          
     *          For vectors `x1`, `x2`,..., 'xn' with lengths ``Ni=len(xi)`` ,
     *          return ``(N1, N2, N3,...Nn)`` shaped arrays if indexing='ij'
     *          or ``(N2, N1, N3,...Nn)`` shaped arrays if indexing='xy'
     *          with the elements of `xi` repeated to fill the matrix along
     *          the first dimension for `x1`, the second for `x2` and so on.
     */
    public final Object meshgrid(Object... args) {
        write("np.meshgrid("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the minimum of an array or minimum along an axis.
     * <p>
     * <em>Notes:</em><br>
     * NaN values are propagated, that is if at least one item is NaN, the
     * corresponding min value will be NaN as well. To ignore NaN values
     * (MATLAB behavior), please use nanmin.
     * 
     * Don't use `amin` for element-wise comparison of 2 arrays; when
     * ``a.shape[0]`` is 2, ``minimum(a[0], a[1])`` is faster than
     * ``amin(a, axis=0)``.
     * 
     * 
     * Note that the method name deviates from the description (which is for {@link #amin}). This is most likely due to min being an alias for amin.
     * 
     * @param a array_like<br>
     *          Input data.
     * @param axis None or int or tuple of ints, optional<br>
     *             Axis or axes along which to operate.  By default, flattened input is
     *             used.
     *             
     *             .. versionadded:: 1.7.0
     *             
     *             If this is a tuple of ints, the minimum is selected over multiple axes,
     *             instead of a single axis or all the axes as before.
     * @param out ndarray, optional<br>
     *            Alternative output array in which to place the result.  Must
     *            be of the same shape and buffer length as the expected output.
     *            See :ref:`ufuncs-output-type` for more details.
     *            
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left
     *                 in the result as dimensions with size one. With this option,
     *                 the result will broadcast correctly against the input array.
     *                 
     *                 If the default value is passed, then `keepdims` will not be
     *                 passed through to the `amin` method of sub-classes of
     *                 `ndarray`, however any non-default value will be.  If the
     *                 sub-class' method does not implement `keepdims` any
     *                 exceptions will be raised.
     *                 
     * @param initial scalar, optional<br>
     *                The maximum value of an output element. Must be present to allow
     *                computation on empty slice. See `~numpy.ufunc.reduce` for details.
     *                
     *                .. versionadded:: 1.15.0
     *                
     * @param where array_like of bool, optional<br>
     *              Elements to compare for the minimum. See `~numpy.ufunc.reduce`
     *              for details.
     *              
     *              .. versionadded:: 1.17.0
     * 
     * @return amin ndarray or scalar<br>
     *              Minimum of `a`. If `axis` is None, the result is a scalar value.
     *              If `axis` is given, the result is an array of dimension
     *              ``a.ndim - 1``.
     */
    public final Object min(Object a, Object... args) {
        write("np.min("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * min_scalar_type(a)
     * 
     * For scalar ``a``, returns the data type with the smallest size
     * and smallest scalar kind which can hold its value.  For non-scalar
     * array ``a``, returns the vector's dtype unmodified.
     * 
     * Floating point values are not demoted to integers,
     * and complex values are not demoted to floats.
     * <p>
     * <em>Notes:</em><br>
     * .. versionadded:: 1.6.0
     * 
     * @param a scalar or array_like<br>
     *          The value whose minimal data type is to be found.
     * @param ... n/a<br>undocumented
     * 
     * @return out dtype<br>
     *             The minimal data type.
     */
    public final Object min_scalar_type(Object... args) {
        write("np.min_scalar_type("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the character for the minimum-size type to which given types can
     * be safely cast.
     * 
     * The returned type character must represent the smallest size dtype such
     * that an array of the returned type can handle the data from an array of
     * all types in `typechars` (or if `typechars` is an array, then its
     * dtype.char).
     * 
     * @param typechars list of str or array_like<br>
     *                  If a list of strings, each string should represent a dtype.
     *                  If array_like, the character representation of the array dtype is used.
     * @param typeset str or list of str, optional<br>
     *                The set of characters that the returned character is chosen from.
     *                The default set is 'GDFgdf'.
     * @param default str, optional<br>
     *                The default character, this is returned if none of the characters in
     *                `typechars` matches a character in `typeset`.
     * 
     * @return typechar str<br>
     *                  The character representing the minimum-size type that was found.
     */
    public final Object mintypecode(Object typechars, Object... args) {
        write("np.mintypecode("+PythonGrammar.toPythonArgs(typechars)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Move axes of an array to new positions.
     * 
     * Other axes remain in their original order.
     * 
     * .. versionadded:: 1.11.0
     * 
     * @param a np.ndarray<br>
     *          The array whose axes should be reordered.
     * @param source int or sequence of int<br>
     *               Original positions of the axes to move. These must be unique.
     * @param destination int or sequence of int<br>
     *                    Destination positions for each of the original axes. These must also be
     *                    unique.
     * 
     * @return result np.ndarray<br>
     *                Array with moved axes. This array is a view of the input array.
     */
    public final Object moveaxis(Object a, Object source, Object destination) {
        write("np.moveaxis("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(source),PythonGrammar.toPythonArgs(destination)+")");
        return null;
    }

    /**
     * Return a copy of an array sorted along the first axis.
     * <p>
     * <em>Notes:</em><br>
     * ``np.msort(a)`` is equivalent to  ``np.sort(a, axis=0)``.
     * 
     * @param a array_like<br>
     *          Array to be sorted.
     * 
     * @return sorted_array ndarray<br>
     *                      Array of the same type and shape as `a`.
     */
    public final Object msort(Object a) {
        write("np.msort("+PythonGrammar.toPythonArgs(a)+")");
        return null;
    }

    /**
     * Replace NaN with zero and infinity with large finite numbers (default
     * behaviour) or with the numbers defined by the user using the `nan`,
     * `posinf` and/or `neginf` keywords.
     * 
     * If `x` is inexact, NaN is replaced by zero or by the user defined value in
     * `nan` keyword, infinity is replaced by the largest finite floating point
     * values representable by ``x.dtype`` or by the user defined value in
     * `posinf` keyword and -infinity is replaced by the most negative finite
     * floating point values representable by ``x.dtype`` or by the user defined
     * value in `neginf` keyword.
     * 
     * For complex dtypes, the above is applied to each of the real and
     * imaginary components of `x` separately.
     * 
     * If `x` is not inexact, then no replacements are made.
     * <p>
     * <em>Notes:</em><br>
     * NumPy uses the IEEE Standard for Binary Floating-Point for Arithmetic
     * (IEEE 754). This means that Not a Number is not equivalent to infinity.
     * 
     * @param x scalar or array_like<br>
     *          Input data.
     * @param copy bool, optional<br>
     *             Whether to create a copy of `x` (True) or to replace values
     *             in-place (False). The in-place operation only occurs if
     *             casting to an array does not require a copy.
     *             Default is True.
     *             
     *             .. versionadded:: 1.13
     * @param nan int, float, optional<br>
     *            Value to be used to fill NaN values. If no value is passed
     *            then NaN values will be replaced with 0.0.
     *            
     *            .. versionadded:: 1.17
     * @param posinf int, float, optional<br>
     *               Value to be used to fill positive infinity values. If no value is
     *               passed then positive infinity values will be replaced with a very
     *               large number.
     *               
     *               .. versionadded:: 1.17
     * @param neginf int, float, optional<br>
     *               Value to be used to fill negative infinity values. If no value is
     *               passed then negative infinity values will be replaced with a very
     *               small (or negative) number.
     *               
     *               .. versionadded:: 1.17
     * 
     * @return out ndarray<br>
     *             `x`, with the non-finite values replaced. If `copy` is False, this may
     *             be `x` itself.
     */
    public final Object nan_to_num(Object x, Object... args) {
        write("np.nan_to_num("+PythonGrammar.toPythonArgs(x)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the indices of the maximum values in the specified axis ignoring
     * NaNs. For all-NaN slices ``ValueError`` is raised. Warning: the
     * results cannot be trusted if a slice contains only NaNs and -Infs.
     * 
     * @param a array_like<br>
     *          Input data.
     * @param axis int, optional<br>
     *             Axis along which to operate.  By default flattened input is used.
     * 
     * @return index_array ndarray<br>
     *                     An array of indices or a single index value.
     */
    public final Object nanargmax(Object a, Object... args) {
        write("np.nanargmax("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the indices of the minimum values in the specified axis ignoring
     * NaNs. For all-NaN slices ``ValueError`` is raised. Warning: the results
     * cannot be trusted if a slice contains only NaNs and Infs.
     * 
     * @param a array_like<br>
     *          Input data.
     * @param axis int, optional<br>
     *             Axis along which to operate.  By default flattened input is used.
     * 
     * @return index_array ndarray<br>
     *                     An array of indices or a single index value.
     */
    public final Object nanargmin(Object a, Object... args) {
        write("np.nanargmin("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the cumulative product of array elements over a given axis treating Not a
     * Numbers (NaNs) as one.  The cumulative product does not change when NaNs are
     * encountered and leading NaNs are replaced by ones.
     * 
     * Ones are returned for slices that are all-NaN or empty.
     * 
     * .. versionadded:: 1.12.0
     * 
     * @param a array_like<br>
     *          Input array.
     * @param axis int, optional<br>
     *             Axis along which the cumulative product is computed.  By default
     *             the input is flattened.
     * @param dtype dtype, optional<br>
     *              Type of the returned array, as well as of the accumulator in which
     *              the elements are multiplied.  If *dtype* is not specified, it
     *              defaults to the dtype of `a`, unless `a` has an integer dtype with
     *              a precision less than that of the default platform integer.  In
     *              that case, the default platform integer is used instead.
     * @param out ndarray, optional<br>
     *            Alternative output array in which to place the result. It must
     *            have the same shape and buffer length as the expected output
     *            but the type of the resulting values will be cast if necessary.
     * 
     * @return nancumprod ndarray<br>
     *                    A new array holding the result is returned unless `out` is
     *                    specified, in which case it is returned.
     */
    public final Object nancumprod(Object a, Object... args) {
        write("np.nancumprod("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the cumulative sum of array elements over a given axis treating Not a
     * Numbers (NaNs) as zero.  The cumulative sum does not change when NaNs are
     * encountered and leading NaNs are replaced by zeros.
     * 
     * Zeros are returned for slices that are all-NaN or empty.
     * 
     * .. versionadded:: 1.12.0
     * 
     * @param a array_like<br>
     *          Input array.
     * @param axis int, optional<br>
     *             Axis along which the cumulative sum is computed. The default
     *             (None) is to compute the cumsum over the flattened array.
     * @param dtype dtype, optional<br>
     *              Type of the returned array and of the accumulator in which the
     *              elements are summed.  If `dtype` is not specified, it defaults
     *              to the dtype of `a`, unless `a` has an integer dtype with a
     *              precision less than that of the default platform integer.  In
     *              that case, the default platform integer is used.
     * @param out ndarray, optional<br>
     *            Alternative output array in which to place the result. It must
     *            have the same shape and buffer length as the expected output
     *            but the type will be cast if necessary. See :ref:`ufuncs-output-type` for
     *            more details.
     * 
     * @return nancumsum ndarray.<br>
     *                   A new array holding the result is returned unless `out` is
     *                   specified, in which it is returned. The result has the same
     *                   size as `a`, and the same shape as `a` if `axis` is not None
     *                   or `a` is a 1-d array.
     */
    public final Object nancumsum(Object a, Object... args) {
        write("np.nancumsum("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the maximum of an array or maximum along an axis, ignoring any
     * NaNs.  When all-NaN slices are encountered a ``RuntimeWarning`` is
     * raised and NaN is returned for that slice.
     * <p>
     * <em>Notes:</em><br>
     * NumPy uses the IEEE Standard for Binary Floating-Point for Arithmetic
     * (IEEE 754). This means that Not a Number is not equivalent to infinity.
     * Positive infinity is treated as a very large number and negative
     * infinity is treated as a very small (i.e. negative) number.
     * 
     * If the input has a integer type the function is equivalent to np.max.
     * 
     * @param a array_like<br>
     *          Array containing numbers whose maximum is desired. If `a` is not an
     *          array, a conversion is attempted.
     * @param axis &#123;int, tuple of int, None&#125;, optional<br>
     *             Axis or axes along which the maximum is computed. The default is to compute
     *             the maximum of the flattened array.
     * @param out ndarray, optional<br>
     *            Alternate output array in which to place the result.  The default
     *            is ``None``; if provided, it must have the same shape as the
     *            expected output, but the type will be cast if necessary. See
     *            :ref:`ufuncs-output-type` for more details.
     *            
     *            .. versionadded:: 1.8.0
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left
     *                 in the result as dimensions with size one. With this option,
     *                 the result will broadcast correctly against the original `a`.
     *                 
     *                 If the value is anything but the default, then
     *                 `keepdims` will be passed through to the `max` method
     *                 of sub-classes of `ndarray`.  If the sub-classes methods
     *                 does not implement `keepdims` any exceptions will be raised.
     *                 
     *                 .. versionadded:: 1.8.0
     * 
     * @return nanmax ndarray<br>
     *                An array with the same shape as `a`, with the specified axis removed.
     *                If `a` is a 0-d array, or if axis is None, an ndarray scalar is
     *                returned.  The same dtype as `a` is returned.
     */
    public final Object nanmax(Object a, Object... args) {
        write("np.nanmax("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Compute the arithmetic mean along the specified axis, ignoring NaNs.
     * 
     * Returns the average of the array elements.  The average is taken over
     * the flattened array by default, otherwise over the specified axis.
     * `float64` intermediate and return values are used for integer inputs.
     * 
     * For all-NaN slices, NaN is returned and a `RuntimeWarning` is raised.
     * 
     * .. versionadded:: 1.8.0
     * <p>
     * <em>Notes:</em><br>
     * The arithmetic mean is the sum of the non-NaN elements along the axis
     * divided by the number of non-NaN elements.
     * 
     * Note that for floating-point input, the mean is computed using the same
     * precision the input has.  Depending on the input data, this can cause
     * the results to be inaccurate, especially for `float32`.  Specifying a
     * higher-precision accumulator using the `dtype` keyword can alleviate
     * this issue.
     * 
     * @param a array_like<br>
     *          Array containing numbers whose mean is desired. If `a` is not an
     *          array, a conversion is attempted.
     * @param axis &#123;int, tuple of int, None&#125;, optional<br>
     *             Axis or axes along which the means are computed. The default is to compute
     *             the mean of the flattened array.
     * @param dtype data-type, optional<br>
     *              Type to use in computing the mean.  For integer inputs, the default
     *              is `float64`; for inexact inputs, it is the same as the input
     *              dtype.
     * @param out ndarray, optional<br>
     *            Alternate output array in which to place the result.  The default
     *            is ``None``; if provided, it must have the same shape as the
     *            expected output, but the type will be cast if necessary. See
     *            :ref:`ufuncs-output-type` for more details.
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left
     *                 in the result as dimensions with size one. With this option,
     *                 the result will broadcast correctly against the original `a`.
     *                 
     *                 If the value is anything but the default, then
     *                 `keepdims` will be passed through to the `mean` or `sum` methods
     *                 of sub-classes of `ndarray`.  If the sub-classes methods
     *                 does not implement `keepdims` any exceptions will be raised.
     * 
     * @return m ndarray, see dtype parameter above<br>
     *           If `out=None`, returns a new array containing the mean values,
     *           otherwise a reference to the output array is returned. Nan is
     *           returned for slices that contain only NaNs.
     */
    public final Object nanmean(Object a, Object... args) {
        write("np.nanmean("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Compute the median along the specified axis, while ignoring NaNs.
     * 
     * Returns the median of the array elements.
     * 
     * .. versionadded:: 1.9.0
     * <p>
     * <em>Notes:</em><br>
     * Given a vector ``V`` of length ``N``, the median of ``V`` is the
     * middle value of a sorted copy of ``V``, ``V_sorted`` - i.e.,
     * ``V_sorted[(N-1)/2]``, when ``N`` is odd and the average of the two
     * middle values of ``V_sorted`` when ``N`` is even.
     * 
     * @param a array_like<br>
     *          Input array or object that can be converted to an array.
     * @param axis &#123;int, sequence of int, None&#125;, optional<br>
     *             Axis or axes along which the medians are computed. The default
     *             is to compute the median along a flattened version of the array.
     *             A sequence of axes is supported since version 1.9.0.
     * @param out ndarray, optional<br>
     *            Alternative output array in which to place the result. It must
     *            have the same shape and buffer length as the expected output,
     *            but the type (of the output) will be cast if necessary.
     * @param overwrite_input bool, optional<br>
     *                        If True, then allow use of memory of input array `a` for
     *                        calculations. The input array will be modified by the call to
     *                        `median`. This will save memory when you do not need to preserve
     *                        the contents of the input array. Treat the input as undefined,
     *                        but it will probably be fully or partially sorted. Default is
     *                        False. If `overwrite_input` is ``True`` and `a` is not already an
     *                        `ndarray`, an error will be raised.
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left
     *                 in the result as dimensions with size one. With this option,
     *                 the result will broadcast correctly against the original `a`.
     *                 
     *                 If this is anything but the default value it will be passed
     *                 through (in the special case of an empty array) to the
     *                 `mean` function of the underlying array.  If the array is
     *                 a sub-class and `mean` does not have the kwarg `keepdims` this
     *                 will raise a RuntimeError.
     * 
     * @return median ndarray<br>
     *                A new array holding the result. If the input contains integers
     *                or floats smaller than ``float64``, then the output data-type is
     *                ``np.float64``.  Otherwise, the data-type of the output is the
     *                same as that of the input. If `out` is specified, that array is
     *                returned instead.
     */
    public final Object nanmedian(Object a, Object... args) {
        write("np.nanmedian("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return minimum of an array or minimum along an axis, ignoring any NaNs.
     * When all-NaN slices are encountered a ``RuntimeWarning`` is raised and
     * Nan is returned for that slice.
     * <p>
     * <em>Notes:</em><br>
     * NumPy uses the IEEE Standard for Binary Floating-Point for Arithmetic
     * (IEEE 754). This means that Not a Number is not equivalent to infinity.
     * Positive infinity is treated as a very large number and negative
     * infinity is treated as a very small (i.e. negative) number.
     * 
     * If the input has a integer type the function is equivalent to np.min.
     * 
     * @param a array_like<br>
     *          Array containing numbers whose minimum is desired. If `a` is not an
     *          array, a conversion is attempted.
     * @param axis &#123;int, tuple of int, None&#125;, optional<br>
     *             Axis or axes along which the minimum is computed. The default is to compute
     *             the minimum of the flattened array.
     * @param out ndarray, optional<br>
     *            Alternate output array in which to place the result.  The default
     *            is ``None``; if provided, it must have the same shape as the
     *            expected output, but the type will be cast if necessary. See
     *            :ref:`ufuncs-output-type` for more details.
     *            
     *            .. versionadded:: 1.8.0
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left
     *                 in the result as dimensions with size one. With this option,
     *                 the result will broadcast correctly against the original `a`.
     *                 
     *                 If the value is anything but the default, then
     *                 `keepdims` will be passed through to the `min` method
     *                 of sub-classes of `ndarray`.  If the sub-classes methods
     *                 does not implement `keepdims` any exceptions will be raised.
     *                 
     *                 .. versionadded:: 1.8.0
     * 
     * @return nanmin ndarray<br>
     *                An array with the same shape as `a`, with the specified axis
     *                removed.  If `a` is a 0-d array, or if axis is None, an ndarray
     *                scalar is returned.  The same dtype as `a` is returned.
     */
    public final Object nanmin(Object a, Object... args) {
        write("np.nanmin("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Compute the qth percentile of the data along the specified axis,
     * while ignoring nan values.
     * 
     * Returns the qth percentile(s) of the array elements.
     * 
     * .. versionadded:: 1.9.0
     * <p>
     * <em>Notes:</em><br>
     * Given a vector ``V`` of length ``N``, the ``q``-th percentile of
     * ``V`` is the value ``q/100`` of the way from the minimum to the
     * maximum in a sorted copy of ``V``. The values and distances of
     * the two nearest neighbors as well as the `interpolation` parameter
     * will determine the percentile if the normalized ranking does not
     * match the location of ``q`` exactly. This function is the same as
     * the median if ``q=50``, the same as the minimum if ``q=0`` and the
     * same as the maximum if ``q=100``.
     * 
     * @param a array_like<br>
     *          Input array or object that can be converted to an array, containing
     *          nan values to be ignored.
     * @param q array_like of float<br>
     *          Percentile or sequence of percentiles to compute, which must be between
     *          0 and 100 inclusive.
     * @param axis &#123;int, tuple of int, None&#125;, optional<br>
     *             Axis or axes along which the percentiles are computed. The
     *             default is to compute the percentile(s) along a flattened
     *             version of the array.
     * @param out ndarray, optional<br>
     *            Alternative output array in which to place the result. It must
     *            have the same shape and buffer length as the expected output,
     *            but the type (of the output) will be cast if necessary.
     * @param overwrite_input bool, optional<br>
     *                        If True, then allow the input array `a` to be modified by intermediate
     *                        calculations, to save memory. In this case, the contents of the input
     *                        `a` after this function completes is undefined.
     * @param interpolation &#123;'linear', 'lower', 'higher', 'midpoint', 'nearest'&#125;<br>
     *                      This optional parameter specifies the interpolation method to
     *                      use when the desired percentile lies between two data points
     *                      ``i &lt; j``:
     *                      
     *                      * 'linear': ``i + (j - i) * fraction``, where ``fraction``
     *                      is the fractional part of the index surrounded by ``i``
     *                      and ``j``.
     *                      * 'lower': ``i``.
     *                      * 'higher': ``j``.
     *                      * 'nearest': ``i`` or ``j``, whichever is nearest.
     *                      * 'midpoint': ``(i + j) / 2``.
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left in
     *                 the result as dimensions with size one. With this option, the
     *                 result will broadcast correctly against the original array `a`.
     *                 
     *                 If this is anything but the default value it will be passed
     *                 through (in the special case of an empty array) to the
     *                 `mean` function of the underlying array.  If the array is
     *                 a sub-class and `mean` does not have the kwarg `keepdims` this
     *                 will raise a RuntimeError.
     * 
     * @return percentile scalar or ndarray<br>
     *                    If `q` is a single percentile and `axis=None`, then the result
     *                    is a scalar. If multiple percentiles are given, first axis of
     *                    the result corresponds to the percentiles. The other axes are
     *                    the axes that remain after the reduction of `a`. If the input
     *                    contains integers or floats smaller than ``float64``, the output
     *                    data-type is ``float64``. Otherwise, the output data-type is the
     *                    same as that of the input. If `out` is specified, that array is
     *                    returned instead.
     */
    public final Object nanpercentile(Object a, Object q, Object... args) {
        write("np.nanpercentile("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(q)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the product of array elements over a given axis treating Not a
     * Numbers (NaNs) as ones.
     * 
     * One is returned for slices that are all-NaN or empty.
     * 
     * .. versionadded:: 1.10.0
     * 
     * @param a array_like<br>
     *          Array containing numbers whose product is desired. If `a` is not an
     *          array, a conversion is attempted.
     * @param axis &#123;int, tuple of int, None&#125;, optional<br>
     *             Axis or axes along which the product is computed. The default is to compute
     *             the product of the flattened array.
     * @param dtype data-type, optional<br>
     *              The type of the returned array and of the accumulator in which the
     *              elements are summed.  By default, the dtype of `a` is used.  An
     *              exception is when `a` has an integer type with less precision than
     *              the platform (u)intp. In that case, the default will be either
     *              (u)int32 or (u)int64 depending on whether the platform is 32 or 64
     *              bits. For inexact inputs, dtype must be inexact.
     * @param out ndarray, optional<br>
     *            Alternate output array in which to place the result.  The default
     *            is ``None``. If provided, it must have the same shape as the
     *            expected output, but the type will be cast if necessary. See
     *            :ref:`ufuncs-output-type` for more details. The casting of NaN to integer
     *            can yield unexpected results.
     * @param keepdims bool, optional<br>
     *                 If True, the axes which are reduced are left in the result as
     *                 dimensions with size one. With this option, the result will
     *                 broadcast correctly against the original `arr`.
     * 
     * @return nanprod ndarray<br>
     *                 A new array holding the result is returned unless `out` is
     *                 specified, in which case it is returned.
     */
    public final Object nanprod(Object a, Object... args) {
        write("np.nanprod("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Compute the qth quantile of the data along the specified axis,
     * while ignoring nan values.
     * Returns the qth quantile(s) of the array elements.
     * 
     * .. versionadded:: 1.15.0
     * 
     * @param a array_like<br>
     *          Input array or object that can be converted to an array, containing
     *          nan values to be ignored
     * @param q array_like of float<br>
     *          Quantile or sequence of quantiles to compute, which must be between
     *          0 and 1 inclusive.
     * @param axis &#123;int, tuple of int, None&#125;, optional<br>
     *             Axis or axes along which the quantiles are computed. The
     *             default is to compute the quantile(s) along a flattened
     *             version of the array.
     * @param out ndarray, optional<br>
     *            Alternative output array in which to place the result. It must
     *            have the same shape and buffer length as the expected output,
     *            but the type (of the output) will be cast if necessary.
     * @param overwrite_input bool, optional<br>
     *                        If True, then allow the input array `a` to be modified by intermediate
     *                        calculations, to save memory. In this case, the contents of the input
     *                        `a` after this function completes is undefined.
     * @param interpolation &#123;'linear', 'lower', 'higher', 'midpoint', 'nearest'&#125;<br>
     *                      This optional parameter specifies the interpolation method to
     *                      use when the desired quantile lies between two data points
     *                      ``i &lt; j``:
     *                      
     *                      * linear: ``i + (j - i) * fraction``, where ``fraction``
     *                      is the fractional part of the index surrounded by ``i``
     *                      and ``j``.
     *                      * lower: ``i``.
     *                      * higher: ``j``.
     *                      * nearest: ``i`` or ``j``, whichever is nearest.
     *                      * midpoint: ``(i + j) / 2``.
     *                      
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left in
     *                 the result as dimensions with size one. With this option, the
     *                 result will broadcast correctly against the original array `a`.
     *                 
     *                 If this is anything but the default value it will be passed
     *                 through (in the special case of an empty array) to the
     *                 `mean` function of the underlying array.  If the array is
     *                 a sub-class and `mean` does not have the kwarg `keepdims` this
     *                 will raise a RuntimeError.
     * 
     * @return quantile scalar or ndarray<br>
     *                  If `q` is a single percentile and `axis=None`, then the result
     *                  is a scalar. If multiple quantiles are given, first axis of
     *                  the result corresponds to the quantiles. The other axes are
     *                  the axes that remain after the reduction of `a`. If the input
     *                  contains integers or floats smaller than ``float64``, the output
     *                  data-type is ``float64``. Otherwise, the output data-type is the
     *                  same as that of the input. If `out` is specified, that array is
     *                  returned instead.
     */
    public final Object nanquantile(Object a, Object q, Object... args) {
        write("np.nanquantile("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(q)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Compute the standard deviation along the specified axis, while
     * ignoring NaNs.
     * 
     * Returns the standard deviation, a measure of the spread of a
     * distribution, of the non-NaN array elements. The standard deviation is
     * computed for the flattened array by default, otherwise over the
     * specified axis.
     * 
     * For all-NaN slices or slices with zero degrees of freedom, NaN is
     * returned and a `RuntimeWarning` is raised.
     * 
     * .. versionadded:: 1.8.0
     * <p>
     * <em>Notes:</em><br>
     * The standard deviation is the square root of the average of the squared
     * deviations from the mean: ``std = sqrt(mean(abs(x - x.mean())**2))``.
     * 
     * The average squared deviation is normally calculated as
     * ``x.sum() / N``, where ``N = len(x)``.  If, however, `ddof` is
     * specified, the divisor ``N - ddof`` is used instead. In standard
     * statistical practice, ``ddof=1`` provides an unbiased estimator of the
     * variance of the infinite population. ``ddof=0`` provides a maximum
     * likelihood estimate of the variance for normally distributed variables.
     * The standard deviation computed in this function is the square root of
     * the estimated variance, so even with ``ddof=1``, it will not be an
     * unbiased estimate of the standard deviation per se.
     * 
     * Note that, for complex numbers, `std` takes the absolute value before
     * squaring, so that the result is always real and nonnegative.
     * 
     * For floating-point input, the *std* is computed using the same
     * precision the input has. Depending on the input data, this can cause
     * the results to be inaccurate, especially for float32 (see example
     * below).  Specifying a higher-accuracy accumulator using the `dtype`
     * keyword can alleviate this issue.
     * 
     * @param a array_like<br>
     *          Calculate the standard deviation of the non-NaN values.
     * @param axis &#123;int, tuple of int, None&#125;, optional<br>
     *             Axis or axes along which the standard deviation is computed. The default is
     *             to compute the standard deviation of the flattened array.
     * @param dtype dtype, optional<br>
     *              Type to use in computing the standard deviation. For arrays of
     *              integer type the default is float64, for arrays of float types it
     *              is the same as the array type.
     * @param out ndarray, optional<br>
     *            Alternative output array in which to place the result. It must have
     *            the same shape as the expected output but the type (of the
     *            calculated values) will be cast if necessary.
     * @param ddof int, optional<br>
     *             Means Delta Degrees of Freedom.  The divisor used in calculations
     *             is ``N - ddof``, where ``N`` represents the number of non-NaN
     *             elements.  By default `ddof` is zero.
     *             
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left
     *                 in the result as dimensions with size one. With this option,
     *                 the result will broadcast correctly against the original `a`.
     *                 
     *                 If this value is anything but the default it is passed through
     *                 as-is to the relevant functions of the sub-classes.  If these
     *                 functions do not have a `keepdims` kwarg, a RuntimeError will
     *                 be raised.
     * 
     * @return standard_deviation ndarray, see dtype parameter above.<br>
     *                            If `out` is None, return a new array containing the standard
     *                            deviation, otherwise return a reference to the output array. If
     *                            ddof is &gt;= the number of non-NaN elements in a slice or the slice
     *                            contains only NaNs, then the result for that slice is NaN.
     */
    public final Object nanstd(Object a, Object... args) {
        write("np.nanstd("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the sum of array elements over a given axis treating Not a
     * Numbers (NaNs) as zero.
     * 
     * In NumPy versions <= 1.9.0 Nan is returned for slices that are all-NaN or
     * empty. In later versions zero is returned.
     * <p>
     * <em>Notes:</em><br>
     * If both positive and negative infinity are present, the sum will be Not
     * A Number (NaN).
     * 
     * @param a array_like<br>
     *          Array containing numbers whose sum is desired. If `a` is not an
     *          array, a conversion is attempted.
     * @param axis &#123;int, tuple of int, None&#125;, optional<br>
     *             Axis or axes along which the sum is computed. The default is to compute the
     *             sum of the flattened array.
     * @param dtype data-type, optional<br>
     *              The type of the returned array and of the accumulator in which the
     *              elements are summed.  By default, the dtype of `a` is used.  An
     *              exception is when `a` has an integer type with less precision than
     *              the platform (u)intp. In that case, the default will be either
     *              (u)int32 or (u)int64 depending on whether the platform is 32 or 64
     *              bits. For inexact inputs, dtype must be inexact.
     *              
     *              .. versionadded:: 1.8.0
     * @param out ndarray, optional<br>
     *            Alternate output array in which to place the result.  The default
     *            is ``None``. If provided, it must have the same shape as the
     *            expected output, but the type will be cast if necessary.  See
     *            :ref:`ufuncs-output-type` for more details. The casting of NaN to integer
     *            can yield unexpected results.
     *            
     *            .. versionadded:: 1.8.0
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left
     *                 in the result as dimensions with size one. With this option,
     *                 the result will broadcast correctly against the original `a`.
     *                 
     *                 
     *                 If the value is anything but the default, then
     *                 `keepdims` will be passed through to the `mean` or `sum` methods
     *                 of sub-classes of `ndarray`.  If the sub-classes methods
     *                 does not implement `keepdims` any exceptions will be raised.
     *                 
     *                 .. versionadded:: 1.8.0
     * 
     * @return nansum ndarray.<br>
     *                A new array holding the result is returned unless `out` is
     *                specified, in which it is returned. The result has the same
     *                size as `a`, and the same shape as `a` if `axis` is not None
     *                or `a` is a 1-d array.
     */
    public final Object nansum(Object a, Object... args) {
        write("np.nansum("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Compute the variance along the specified axis, while ignoring NaNs.
     * 
     * Returns the variance of the array elements, a measure of the spread of
     * a distribution.  The variance is computed for the flattened array by
     * default, otherwise over the specified axis.
     * 
     * For all-NaN slices or slices with zero degrees of freedom, NaN is
     * returned and a `RuntimeWarning` is raised.
     * 
     * .. versionadded:: 1.8.0
     * <p>
     * <em>Notes:</em><br>
     * The variance is the average of the squared deviations from the mean,
     * i.e.,  ``var = mean(abs(x - x.mean())**2)``.
     * 
     * The mean is normally calculated as ``x.sum() / N``, where ``N = len(x)``.
     * If, however, `ddof` is specified, the divisor ``N - ddof`` is used
     * instead.  In standard statistical practice, ``ddof=1`` provides an
     * unbiased estimator of the variance of a hypothetical infinite
     * population.  ``ddof=0`` provides a maximum likelihood estimate of the
     * variance for normally distributed variables.
     * 
     * Note that for complex numbers, the absolute value is taken before
     * squaring, so that the result is always real and nonnegative.
     * 
     * For floating-point input, the variance is computed using the same
     * precision the input has.  Depending on the input data, this can cause
     * the results to be inaccurate, especially for `float32` (see example
     * below).  Specifying a higher-accuracy accumulator using the ``dtype``
     * keyword can alleviate this issue.
     * 
     * For this function to work on sub-classes of ndarray, they must define
     * `sum` with the kwarg `keepdims`
     * 
     * @param a array_like<br>
     *          Array containing numbers whose variance is desired.  If `a` is not an
     *          array, a conversion is attempted.
     * @param axis &#123;int, tuple of int, None&#125;, optional<br>
     *             Axis or axes along which the variance is computed.  The default is to compute
     *             the variance of the flattened array.
     * @param dtype data-type, optional<br>
     *              Type to use in computing the variance.  For arrays of integer type
     *              the default is `float64`; for arrays of float types it is the same as
     *              the array type.
     * @param out ndarray, optional<br>
     *            Alternate output array in which to place the result.  It must have
     *            the same shape as the expected output, but the type is cast if
     *            necessary.
     * @param ddof int, optional<br>
     *             "Delta Degrees of Freedom": the divisor used in the calculation is
     *             ``N - ddof``, where ``N`` represents the number of non-NaN
     *             elements. By default `ddof` is zero.
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left
     *                 in the result as dimensions with size one. With this option,
     *                 the result will broadcast correctly against the original `a`.
     * 
     * @return variance ndarray, see dtype parameter above<br>
     *                  If `out` is None, return a new array containing the variance,
     *                  otherwise return a reference to the output array. If ddof is &gt;= the
     *                  number of non-NaN elements in a slice or the slice contains only
     *                  NaNs, then the result for that slice is NaN.
     */
    public final Object nanvar(Object a, Object... args) {
        write("np.nanvar("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Load ASCII data stored in a file and return it as a single array.
     * 
     * .. deprecated:: 1.17
     * ndfromtxt` is a deprecated alias of `genfromtxt` which
     * overwrites the ``usemask`` argument with `False` even when
     * explicitly called as ``ndfromtxt(..., usemask=True)``.
     * Use `genfromtxt` instead.
     * 
     * @param fname For a description of input parameters, see `genfromtxt`.<br>
     * @param kwargs For a description of input parameters, see `genfromtxt`.<br>
     */
    public final Object ndfromtxt(Object fname, Object... args) {
        write("np.ndfromtxt("+PythonGrammar.toPythonArgs(fname)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the number of dimensions of an array.
     * 
     * @param a array_like<br>
     *          Input array.  If it is not already an ndarray, a conversion is
     *          attempted.
     * 
     * @return number_of_dimensions int<br>
     *                              The number of dimensions in `a`.  Scalars are zero-dimensional.
     */
    public final Object ndim(Object a) {
        write("np.ndim("+PythonGrammar.toPythonArgs(a)+")");
        return null;
    }

    /**
     * Return the indices of the elements that are non-zero.
     * 
     * Returns a tuple of arrays, one for each dimension of `a`,
     * containing the indices of the non-zero elements in that
     * dimension. The values in `a` are always tested and returned in
     * row-major, C-style order.
     * 
     * To group the indices by element, rather than dimension, use `argwhere`,
     * which returns a row for each non-zero element.
     * 
     * .. note::
     * 
     * When called on a zero-d array or scalar, ``nonzero(a)`` is treated
     * as ``nonzero(atleast_1d(a))``.
     * 
     * .. deprecated:: 1.17.0
     * 
     * Use `atleast_1d` explicitly if this behavior is deliberate.
     * <p>
     * <em>Notes:</em><br>
     * While the nonzero values can be obtained with ``a[nonzero(a)]``, it is
     * recommended to use ``x[x.astype(bool)]`` or ``x[x != 0]`` instead, which
     * will correctly handle 0-d arrays.
     * 
     * @param a array_like<br>
     *          Input array.
     * 
     * @return tuple_of_arrays tuple<br>
     *                         Indices of elements that are non-zero.
     */
    public final Object nonzero(Object a) {
        write("np.nonzero("+PythonGrammar.toPythonArgs(a)+")");
        return null;
    }

    /**
     * Return the scalar dtype or NumPy equivalent of Python type of an object.
     * 
     * @param rep any<br>
     *            The object of which the type is returned.
     * @param default any, optional<br>
     *                If given, this is returned for objects whose types can not be
     *                determined. If not given, None is returned for those objects.
     * 
     * @return dtype dtype or Python type<br>
     *               The data type of `rep`.
     */
    public final Object obj2sctype(Object rep, Object... args) {
        write("np.obj2sctype("+PythonGrammar.toPythonArgs(rep)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return a new array of given shape and type, filled with ones.
     * 
     * @param shape int or sequence of ints<br>
     *              Shape of the new array, e.g., ``(2, 3)`` or ``2``.
     * @param dtype data-type, optional<br>
     *              The desired data-type for the array, e.g., `numpy.int8`.  Default is
     *              `numpy.float64`.
     * @param order &#123;'C', 'F'&#125;, optional, default: C<br>
     *              Whether to store multi-dimensional data in row-major
     *              (C-style) or column-major (Fortran-style) order in
     *              memory.
     * @param like array_like<br>
     *             Reference object to allow the creation of arrays which are not
     *             NumPy arrays. If an array-like passed in as ``like`` supports
     *             the ``__array_function__`` protocol, the result will be defined
     *             by it. In this case, it ensures the creation of an array object
     *             compatible with that passed in via this argument.
     *             
     *             .. versionadded:: 1.20.0
     * 
     * @return out ndarray<br>
     *             Array of ones with the given shape, dtype, and order.
     */
    public final Object ones(Object shape, Object... args) {
        write("np.ones("+PythonGrammar.toPythonArgs(shape)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return an array of ones with the same shape and type as a given array.
     * 
     * @param a array_like<br>
     *          The shape and data-type of `a` define these same attributes of
     *          the returned array.
     * @param dtype data-type, optional<br>
     *              Overrides the data type of the result.
     *              
     *              .. versionadded:: 1.6.0
     * @param order &#123;'C', 'F', 'A', or 'K'&#125;, optional<br>
     *              Overrides the memory layout of the result. 'C' means C-order,
     *              'F' means F-order, 'A' means 'F' if `a` is Fortran contiguous,
     *              'C' otherwise. 'K' means match the layout of `a` as closely
     *              as possible.
     *              
     *              .. versionadded:: 1.6.0
     * @param subok bool, optional.<br>
     *              If True, then the newly created array will use the sub-class
     *              type of `a`, otherwise it will be a base-class array. Defaults
     *              to True.
     * @param shape int or sequence of ints, optional.<br>
     *              Overrides the shape of the result. If order='K' and the number of
     *              dimensions is unchanged, will try to keep order, otherwise,
     *              order='C' is implied.
     *              
     *              .. versionadded:: 1.17.0
     * 
     * @return out ndarray<br>
     *             Array of ones with the same shape and type as `a`.
     */
    public final Object ones_like(Object a, Object... args) {
        write("np.ones_like("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Compute the outer product of two vectors.
     * 
     * Given two vectors, ``a = [a0, a1, ..., aM]`` and
     * ``b = [b0, b1, ..., bN]``,
     * the outer product [1]_ is::
     * 
     * [[a0*b0  a0*b1 ... a0*bN ]
     * [a1*b0    .
     * [ ...          .
     * [aM*b0            aM*bN ]]
     * 
     * @param a (M,) array_like<br>
     *          First input vector.  Input is flattened if
     *          not already 1-dimensional.
     * @param b (N,) array_like<br>
     *          Second input vector.  Input is flattened if
     *          not already 1-dimensional.
     * @param out (M, N) ndarray, optional<br>
     *            A location where the result is stored
     *            
     *            .. versionadded:: 1.9.0
     * 
     * @return out (M, N) ndarray<br>
     *             ``out[i, j] = a[i] * b[j]``
     */
    public final Object outer(Object a, Object b, Object... args) {
        write("np.outer("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(b)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * packbits(a, axis=None, bitorder='big')
     * 
     * Packs the elements of a binary-valued array into bits in a uint8 array.
     * 
     * The result is padded to full bytes by inserting zero bits at the end.
     * 
     * @param a array_like<br>
     *          An array of integers or booleans whose elements should be packed to
     *          bits.
     * @param axis int, optional<br>
     *             The dimension over which bit-packing is done.
     *             ``None`` implies packing the flattened array.
     * @param bitorder &#123;'big', 'little'&#125;, optional<br>
     *                 The order of the input bits. 'big' will mimic bin(val),
     *                 ``[0, 0, 0, 0, 0, 0, 1, 1] =&gt; 3 = 0b00000011``, 'little' will
     *                 reverse the order so ``[1, 1, 0, 0, 0, 0, 0, 0] =&gt; 3``.
     *                 Defaults to 'big'.
     *                 
     *                 .. versionadded:: 1.17.0
     * @param ... n/a<br>undocumented
     * 
     * @return packed ndarray<br>
     *                Array of type uint8 whose elements represent bits corresponding to the
     *                logical (0 or nonzero) value of the input elements. The shape of
     *                `packed` has the same number of dimensions as the input (unless `axis`
     *                is None, in which case the output is 1-D).
     */
    public final Object packbits(Object... args) {
        write("np.packbits("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Pad an array.
     * <p>
     * <em>Notes:</em><br>
     * .. versionadded:: 1.7.0
     * 
     * For an array with rank greater than 1, some of the padding of later
     * axes is calculated from padding of previous axes.  This is easiest to
     * think about with a rank 2 array where the corners of the padded array
     * are calculated by using padded values from the first axis.
     * 
     * The padding function, if used, should modify a rank 1 array in-place. It
     * has the following signature::
     * 
     * padding_func(vector, iaxis_pad_width, iaxis, kwargs)
     * 
     * where
     * 
     * vector : ndarray
     * A rank 1 array already padded with zeros.  Padded values are
     * vector[:iaxis_pad_width[0]] and vector[-iaxis_pad_width[1]:].
     * iaxis_pad_width : tuple
     * A 2-tuple of ints, iaxis_pad_width[0] represents the number of
     * values padded at the beginning of vector where
     * iaxis_pad_width[1] represents the number of values padded at
     * the end of vector.
     * iaxis : int
     * The axis currently being calculated.
     * kwargs : dict
     * Any keyword arguments the function requires.
     * 
     * @param array array_like of rank N<br>
     *              The array to pad.
     * @param pad_width &#123;sequence, array_like, int&#125;<br>
     *                  Number of values padded to the edges of each axis.
     *                  ((before_1, after_1), ... (before_N, after_N)) unique pad widths
     *                  for each axis.
     *                  ((before, after),) yields same before and after pad for each axis.
     *                  (pad,) or int is a shortcut for before = after = pad width for all
     *                  axes.
     * @param mode str or function, optional<br>
     *             One of the following string values or a user supplied function.
     *             
     *             'constant' (default)
     *             Pads with a constant value.
     *             'edge'
     *             Pads with the edge values of array.
     *             'linear_ramp'
     *             Pads with the linear ramp between end_value and the
     *             array edge value.
     *             'maximum'
     *             Pads with the maximum value of all or part of the
     *             vector along each axis.
     *             'mean'
     *             Pads with the mean value of all or part of the
     *             vector along each axis.
     *             'median'
     *             Pads with the median value of all or part of the
     *             vector along each axis.
     *             'minimum'
     *             Pads with the minimum value of all or part of the
     *             vector along each axis.
     *             'reflect'
     *             Pads with the reflection of the vector mirrored on
     *             the first and last values of the vector along each
     *             axis.
     *             'symmetric'
     *             Pads with the reflection of the vector mirrored
     *             along the edge of the array.
     *             'wrap'
     *             Pads with the wrap of the vector along the axis.
     *             The first values are used to pad the end and the
     *             end values are used to pad the beginning.
     *             'empty'
     *             Pads with undefined values.
     *             
     *             .. versionadded:: 1.17
     *             
     *             &lt;function&gt;
     *             Padding function, see Notes.
     * @param stat_length sequence or int, optional<br>
     *                    Used in 'maximum', 'mean', 'median', and 'minimum'.  Number of
     *                    values at edge of each axis used to calculate the statistic value.
     *                    
     *                    ((before_1, after_1), ... (before_N, after_N)) unique statistic
     *                    lengths for each axis.
     *                    
     *                    ((before, after),) yields same before and after statistic lengths
     *                    for each axis.
     *                    
     *                    (stat_length,) or int is a shortcut for before = after = statistic
     *                    length for all axes.
     *                    
     *                    Default is ``None``, to use the entire axis.
     * @param constant_values sequence or scalar, optional<br>
     *                        Used in 'constant'.  The values to set the padded values for each
     *                        axis.
     *                        
     *                        ``((before_1, after_1), ... (before_N, after_N))`` unique pad constants
     *                        for each axis.
     *                        
     *                        ``((before, after),)`` yields same before and after constants for each
     *                        axis.
     *                        
     *                        ``(constant,)`` or ``constant`` is a shortcut for ``before = after = constant`` for
     *                        all axes.
     *                        
     *                        Default is 0.
     * @param end_values sequence or scalar, optional<br>
     *                   Used in 'linear_ramp'.  The values used for the ending value of the
     *                   linear_ramp and that will form the edge of the padded array.
     *                   
     *                   ``((before_1, after_1), ... (before_N, after_N))`` unique end values
     *                   for each axis.
     *                   
     *                   ``((before, after),)`` yields same before and after end values for each
     *                   axis.
     *                   
     *                   ``(constant,)`` or ``constant`` is a shortcut for ``before = after = constant`` for
     *                   all axes.
     *                   
     *                   Default is 0.
     * @param reflect_type &#123;'even', 'odd'&#125;, optional<br>
     *                     Used in 'reflect', and 'symmetric'.  The 'even' style is the
     *                     default with an unaltered reflection around the edge value.  For
     *                     the 'odd' style, the extended part of the array is created by
     *                     subtracting the reflected values from two times the edge value.
     * @param **kwargs n/a<br>undocumented
     * 
     * @return pad ndarray<br>
     *             Padded array of rank equal to `array` with shape increased
     *             according to `pad_width`.
     */
    public final Object pad(Object array, Object pad_width, Object... args) {
        write("np.pad("+PythonGrammar.toPythonArgs(array),PythonGrammar.toPythonArgs(pad_width)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return a partitioned copy of an array.
     * 
     * Creates a copy of the array with its elements rearranged in such a
     * way that the value of the element in k-th position is in the
     * position it would be in a sorted array. All elements smaller than
     * the k-th element are moved before this element and all equal or
     * greater are moved behind it. The ordering of the elements in the two
     * partitions is undefined.
     * 
     * .. versionadded:: 1.8.0
     * <p>
     * <em>Notes:</em><br>
     * The various selection algorithms are characterized by their average
     * speed, worst case performance, work space size, and whether they are
     * stable. A stable sort keeps items with the same key in the same
     * relative order. The available algorithms have the following
     * properties:
     * 
     * ================= ======= ============= ============ =======
     * kind            speed   worst case    work space  stable
     * ================= ======= ============= ============ =======
     * 'introselect'        1        O(n)           0         no
     * ================= ======= ============= ============ =======
     * 
     * All the partition algorithms make temporary copies of the data when
     * partitioning along any but the last axis.  Consequently,
     * partitioning along the last axis is faster and uses less space than
     * partitioning along any other axis.
     * 
     * The sort order for complex numbers is lexicographic. If both the
     * real and imaginary parts are non-nan then the order is determined by
     * the real parts except when they are equal, in which case the order
     * is determined by the imaginary parts.
     * 
     * @param a array_like<br>
     *          Array to be sorted.
     * @param kth int or sequence of ints<br>
     *            Element index to partition by. The k-th value of the element
     *            will be in its final sorted position and all smaller elements
     *            will be moved before it and all equal or greater elements behind
     *            it. The order of all elements in the partitions is undefined. If
     *            provided with a sequence of k-th it will partition all elements
     *            indexed by k-th  of them into their sorted position at once.
     * @param axis int or None, optional<br>
     *             Axis along which to sort. If None, the array is flattened before
     *             sorting. The default is -1, which sorts along the last axis.
     * @param kind &#123;'introselect'&#125;, optional<br>
     *             Selection algorithm. Default is 'introselect'.
     * @param order str or list of str, optional<br>
     *              When `a` is an array with fields defined, this argument
     *              specifies which fields to compare first, second, etc.  A single
     *              field can be specified as a string.  Not all fields need be
     *              specified, but unspecified fields will still be used, in the
     *              order in which they come up in the dtype, to break ties.
     * 
     * @return partitioned_array ndarray<br>
     *                           Array of the same type and shape as `a`.
     */
    public final Object partition(Object a, Object kth, Object... args) {
        write("np.partition("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(kth)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Compute the q-th percentile of the data along the specified axis.
     * 
     * Returns the q-th percentile(s) of the array elements.
     * <p>
     * <em>Notes:</em><br>
     * Given a vector ``V`` of length ``N``, the q-th percentile of
     * ``V`` is the value ``q/100`` of the way from the minimum to the
     * maximum in a sorted copy of ``V``. The values and distances of
     * the two nearest neighbors as well as the `interpolation` parameter
     * will determine the percentile if the normalized ranking does not
     * match the location of ``q`` exactly. This function is the same as
     * the median if ``q=50``, the same as the minimum if ``q=0`` and the
     * same as the maximum if ``q=100``.
     * 
     * @param a array_like<br>
     *          Input array or object that can be converted to an array.
     * @param q array_like of float<br>
     *          Percentile or sequence of percentiles to compute, which must be between
     *          0 and 100 inclusive.
     * @param axis &#123;int, tuple of int, None&#125;, optional<br>
     *             Axis or axes along which the percentiles are computed. The
     *             default is to compute the percentile(s) along a flattened
     *             version of the array.
     *             
     *             .. versionchanged:: 1.9.0
     *             A tuple of axes is supported
     * @param out ndarray, optional<br>
     *            Alternative output array in which to place the result. It must
     *            have the same shape and buffer length as the expected output,
     *            but the type (of the output) will be cast if necessary.
     * @param overwrite_input bool, optional<br>
     *                        If True, then allow the input array `a` to be modified by intermediate
     *                        calculations, to save memory. In this case, the contents of the input
     *                        `a` after this function completes is undefined.
     *                        
     * @param interpolation &#123;'linear', 'lower', 'higher', 'midpoint', 'nearest'&#125;<br>
     *                      This optional parameter specifies the interpolation method to
     *                      use when the desired percentile lies between two data points
     *                      ``i &lt; j``:
     *                      
     *                      * 'linear': ``i + (j - i) * fraction``, where ``fraction``
     *                      is the fractional part of the index surrounded by ``i``
     *                      and ``j``.
     *                      * 'lower': ``i``.
     *                      * 'higher': ``j``.
     *                      * 'nearest': ``i`` or ``j``, whichever is nearest.
     *                      * 'midpoint': ``(i + j) / 2``.
     *                      
     *                      .. versionadded:: 1.9.0
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left in
     *                 the result as dimensions with size one. With this option, the
     *                 result will broadcast correctly against the original array `a`.
     *                 
     *                 .. versionadded:: 1.9.0
     * 
     * @return percentile scalar or ndarray<br>
     *                    If `q` is a single percentile and `axis=None`, then the result
     *                    is a scalar. If multiple percentiles are given, first axis of
     *                    the result corresponds to the percentiles. The other axes are
     *                    the axes that remain after the reduction of `a`. If the input
     *                    contains integers or floats smaller than ``float64``, the output
     *                    data-type is ``float64``. Otherwise, the output data-type is the
     *                    same as that of the input. If `out` is specified, that array is
     *                    returned instead.
     */
    public final Object percentile(Object a, Object q, Object... args) {
        write("np.percentile("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(q)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Evaluate a piecewise-defined function.
     * 
     * Given a set of conditions and corresponding functions, evaluate each
     * function on the input data wherever its condition is true.
     * <p>
     * <em>Notes:</em><br>
     * This is similar to choose or select, except that functions are
     * evaluated on elements of `x` that satisfy the corresponding condition from
     * `condlist`.
     * 
     * The result is::
     * 
     * |--
     * |funclist[0](x[condlist[0]])
     * out = |funclist[1](x[condlist[1]])
     * |...
     * |funclist[n2](x[condlist[n2]])
     * |--
     * 
     * @param x ndarray or scalar<br>
     *          The input domain.
     * @param condlist list of bool arrays or bool scalars<br>
     *                 Each boolean array corresponds to a function in `funclist`.  Wherever
     *                 `condlist[i]` is True, `funclist[i](x)` is used as the output value.
     *                 
     *                 Each boolean array in `condlist` selects a piece of `x`,
     *                 and should therefore be of the same shape as `x`.
     *                 
     *                 The length of `condlist` must correspond to that of `funclist`.
     *                 If one extra function is given, i.e. if
     *                 ``len(funclist) == len(condlist) + 1``, then that extra function
     *                 is the default value, used wherever all conditions are false.
     * @param funclist list of callables, f(x,*args,**kw), or scalars<br>
     *                 Each function is evaluated over `x` wherever its corresponding
     *                 condition is True.  It should take a 1d array as input and give an 1d
     *                 array or a scalar value as output.  If, instead of a callable,
     *                 a scalar is provided then a constant function (``lambda x: scalar``) is
     *                 assumed.
     * @param args tuple, optional<br>
     *             Any further arguments given to `piecewise` are passed to the functions
     *             upon execution, i.e., if called ``piecewise(..., ..., 1, 'a')``, then
     *             each function is called as ``f(x, 1, 'a')``.
     * @param kw dict, optional<br>
     *           Keyword arguments used in calling `piecewise` are passed to the
     *           functions upon execution, i.e., if called
     *           ``piecewise(..., ..., alpha=1)``, then each function is called as
     *           ``f(x, alpha=1)``.
     * 
     * @return out ndarray<br>
     *             The output is the same shape and type as x and is found by
     *             calling the functions in `funclist` on the appropriate portions of `x`,
     *             as defined by the boolean arrays in `condlist`.  Portions not covered
     *             by any condition have a default value of 0.
     */
    public final Object piecewise(Object x, Object condlist, Object funclist, Object... args) {
        write("np.piecewise("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(condlist),PythonGrammar.toPythonArgs(funclist)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Change elements of an array based on conditional and input values.
     * 
     * Similar to ``np.copyto(arr, vals, where=mask)``, the difference is that
     * `place` uses the first N elements of `vals`, where N is the number of
     * True values in `mask`, while `copyto` uses the elements where `mask`
     * is True.
     * 
     * Note that `extract` does the exact opposite of `place`.
     * 
     * @param arr ndarray<br>
     *            Array to put data into.
     * @param mask array_like<br>
     *             Boolean mask array. Must have the same size as `a`.
     * @param vals 1-D sequence<br>
     *             Values to put into `a`. Only the first N elements are used, where
     *             N is the number of True values in `mask`. If `vals` is smaller
     *             than N, it will be repeated, and if elements of `a` are to be masked,
     *             this sequence must be non-empty.
     */
    public final Object place(Object arr, Object mask, Object vals) {
        write("np.place("+PythonGrammar.toPythonArgs(arr),PythonGrammar.toPythonArgs(mask),PythonGrammar.toPythonArgs(vals)+")");
        return null;
    }

    /**
     * Find the coefficients of a polynomial with the given sequence of roots.
     * 
     * .. note::
     * This forms part of the old polynomial API. Since version 1.4, the
     * new polynomial API defined in `numpy.polynomial` is preferred.
     * A summary of the differences can be found in the
     * :doc:`transition guide </reference/routines.polynomials>`.
     * 
     * Returns the coefficients of the polynomial whose leading coefficient
     * is one for the given sequence of zeros (multiple roots must be included
     * in the sequence as many times as their multiplicity; see Examples).
     * A square matrix (or array, which will be treated as a matrix) can also
     * be given, in which case the coefficients of the characteristic polynomial
     * of the matrix are returned.
     * <p>
     * <em>Notes:</em><br>
     * Specifying the roots of a polynomial still leaves one degree of
     * freedom, typically represented by an undetermined leading
     * coefficient. [1]_ In the case of this function, that coefficient -
     * the first one in the returned array - is always taken as one. (If
     * for some reason you have one other point, the only automatic way
     * presently to leverage that information is to use ``polyfit``.)
     * 
     * The characteristic polynomial, :math:`p_a(t)`, of an `n`-by-`n`
     * matrix **A** is given by
     * 
     * :math:`p_a(t) = \mathrm{det}(t\, \mathbf{I} - \mathbf{A})`,
     * 
     * where **I** is the `n`-by-`n` identity matrix. [2]_
     * 
     * @param seq_of_zeros array_like, shape (N,) or (N, N)<br>
     *                     A sequence of polynomial roots, or a square array or matrix object.
     * 
     * @return c ndarray<br>
     *           1D array of polynomial coefficients from highest to lowest degree:
     *           
     *           ``c[0] * x**(N) + c[1] * x**(N-1) + ... + c[N-1] * x + c[N]``
     *           where c[0] always equals 1.
     */
    public final Object poly(Object seq_of_zeros) {
        write("np.poly("+PythonGrammar.toPythonArgs(seq_of_zeros)+")");
        return null;
    }

    /**
     * Find the sum of two polynomials.
     * 
     * .. note::
     * This forms part of the old polynomial API. Since version 1.4, the
     * new polynomial API defined in `numpy.polynomial` is preferred.
     * A summary of the differences can be found in the
     * :doc:`transition guide </reference/routines.polynomials>`.
     * 
     * Returns the polynomial resulting from the sum of two input polynomials.
     * Each input must be either a poly1d object or a 1D sequence of polynomial
     * coefficients, from highest to lowest degree.
     * 
     * @param a1 array_like or poly1d object<br>
     *           Input polynomials.
     * @param a2 array_like or poly1d object<br>
     *           Input polynomials.
     * 
     * @return out ndarray or poly1d object<br>
     *             The sum of the inputs. If either input is a poly1d object, then the
     *             output is also a poly1d object. Otherwise, it is a 1D array of
     *             polynomial coefficients from highest to lowest degree.
     */
    public final Object polyadd(Object a1, Object a2) {
        write("np.polyadd("+PythonGrammar.toPythonArgs(a1),PythonGrammar.toPythonArgs(a2)+")");
        return null;
    }

    /**
     * Return the derivative of the specified order of a polynomial.
     * 
     * .. note::
     * This forms part of the old polynomial API. Since version 1.4, the
     * new polynomial API defined in `numpy.polynomial` is preferred.
     * A summary of the differences can be found in the
     * :doc:`transition guide </reference/routines.polynomials>`.
     * 
     * @param p poly1d or sequence<br>
     *          Polynomial to differentiate.
     *          A sequence is interpreted as polynomial coefficients, see `poly1d`.
     * @param m int, optional<br>
     *          Order of differentiation (default: 1)
     * 
     * @return der poly1d<br>
     *             A new polynomial representing the derivative.
     */
    public final Object polyder(Object p, Object... args) {
        write("np.polyder("+PythonGrammar.toPythonArgs(p)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Returns the quotient and remainder of polynomial division.
     * 
     * .. note::
     * This forms part of the old polynomial API. Since version 1.4, the
     * new polynomial API defined in `numpy.polynomial` is preferred.
     * A summary of the differences can be found in the
     * :doc:`transition guide </reference/routines.polynomials>`.
     * 
     * The input arrays are the coefficients (including any coefficients
     * equal to zero) of the "numerator" (dividend) and "denominator"
     * (divisor) polynomials, respectively.
     * <p>
     * <em>Notes:</em><br>
     * Both `u` and `v` must be 0-d or 1-d (ndim = 0 or 1), but `u.ndim` need
     * not equal `v.ndim`. In other words, all four possible combinations -
     * ``u.ndim = v.ndim = 0``, ``u.ndim = v.ndim = 1``,
     * ``u.ndim = 1, v.ndim = 0``, and ``u.ndim = 0, v.ndim = 1`` - work.
     * 
     * @param u array_like or poly1d<br>
     *          Dividend polynomial's coefficients.
     *          
     * @param v array_like or poly1d<br>
     *          Divisor polynomial's coefficients.
     * 
     * @return (q,r) (ndarray,ndarray)<br>
     *          Coefficients, including those equal to zero, of the quotient.
     *          
     *          Coefficients, including those equal to zero, of the remainder.
     */
    public final Object polydiv(Object u, Object v) {
        write("np.polydiv("+PythonGrammar.toPythonArgs(u),PythonGrammar.toPythonArgs(v)+")");
        return null;
    }

    /**
     * Least squares polynomial fit.
     * 
     * .. note::
     * This forms part of the old polynomial API. Since version 1.4, the
     * new polynomial API defined in `numpy.polynomial` is preferred.
     * A summary of the differences can be found in the
     * :doc:`transition guide </reference/routines.polynomials>`.
     * 
     * Fit a polynomial ``p(x) = p[0] * x**deg + ... + p[deg]`` of degree `deg`
     * to points `(x, y)`. Returns a vector of coefficients `p` that minimises
     * the squared error in the order `deg`, `deg-1`, ... `0`.
     * 
     * The `Polynomial.fit <numpy.polynomial.polynomial.Polynomial.fit>` class
     * method is recommended for new code as it is more stable numerically. See
     * the documentation of the method for more information.
     * <p>
     * <em>Notes:</em><br>
     * The solution minimizes the squared error
     * 
     * .. math ::
     * E = \sum_{j=0}^k |p(x_j) - y_j|^2
     * 
     * in the equations::
     * 
     * x[0]**n * p[0] + ... + x[0] * p[n-1] + p[n] = y[0]
     * x[1]**n * p[0] + ... + x[1] * p[n-1] + p[n] = y[1]
     * ...
     * x[k]**n * p[0] + ... + x[k] * p[n-1] + p[n] = y[k]
     * 
     * The coefficient matrix of the coefficients `p` is a Vandermonde matrix.
     * 
     * `polyfit` issues a `RankWarning` when the least-squares fit is badly
     * conditioned. This implies that the best fit is not well-defined due
     * to numerical error. The results may be improved by lowering the polynomial
     * degree or by replacing `x` by `x` - `x`.mean(). The `rcond` parameter
     * can also be set to a value smaller than its default, but the resulting
     * fit may be spurious: including contributions from the small singular
     * values can add numerical noise to the result.
     * 
     * Note that fitting polynomial coefficients is inherently badly conditioned
     * when the degree of the polynomial is large or the interval of sample points
     * is badly centered. The quality of the fit should always be checked in these
     * cases. When polynomial fits are not satisfactory, splines may be a good
     * alternative.
     * 
     * @param x array_like, shape (M,)<br>
     *          x-coordinates of the M sample points ``(x[i], y[i])``.
     * @param y array_like, shape (M,) or (M, K)<br>
     *          y-coordinates of the sample points. Several data sets of sample
     *          points sharing the same x-coordinates can be fitted at once by
     *          passing in a 2D-array that contains one dataset per column.
     * @param deg int<br>
     *            Degree of the fitting polynomial
     * @param rcond float, optional<br>
     *              Relative condition number of the fit. Singular values smaller than
     *              this relative to the largest singular value will be ignored. The
     *              default value is len(x)*eps, where eps is the relative precision of
     *              the float type, about 2e-16 in most cases.
     * @param full bool, optional<br>
     *             Switch determining nature of return value. When it is False (the
     *             default) just the coefficients are returned, when True diagnostic
     *             information from the singular value decomposition is also returned.
     * @param w array_like, shape (M,), optional<br>
     *          Weights to apply to the y-coordinates of the sample points. For
     *          gaussian uncertainties, use 1/sigma (not 1/sigma**2).
     * @param cov bool or str, optional<br>
     *            If given and not `False`, return not just the estimate but also its
     *            covariance matrix. By default, the covariance are scaled by
     *            chi2/dof, where dof = M - (deg + 1), i.e., the weights are presumed
     *            to be unreliable except in a relative sense and everything is scaled
     *            such that the reduced chi2 is unity. This scaling is omitted if
     *            ``cov='unscaled'``, as is relevant for the case that the weights are
     *            1/sigma**2, with sigma known to be a reliable estimate of the
     *            uncertainty.
     * 
     * @return (p,residuals,rank,singular_values,rcond,V,Warns,-----,RankWarning) (ndarray, shape (deg + 1,) or (deg + 1, K),,,,,ndarray, shape (M,M) or (M,M,K),,,)<br>
     *          Polynomial coefficients, highest power first.  If `y` was 2-D, the
     *          coefficients for `k`-th data set are in ``p[:,k]``.
     *          
     *          
     *          Present only if `full` = True.  Residuals is sum of squared residuals
     *          of the least-squares fit, the effective rank of the scaled Vandermonde
     *          coefficient matrix, its singular values, and the specified value of
     *          `rcond`. For more details, see `linalg.lstsq`.
     *          
     *          
     *          Present only if `full` = True.  Residuals is sum of squared residuals
     *          of the least-squares fit, the effective rank of the scaled Vandermonde
     *          coefficient matrix, its singular values, and the specified value of
     *          `rcond`. For more details, see `linalg.lstsq`.
     *          
     *          
     *          Present only if `full` = True.  Residuals is sum of squared residuals
     *          of the least-squares fit, the effective rank of the scaled Vandermonde
     *          coefficient matrix, its singular values, and the specified value of
     *          `rcond`. For more details, see `linalg.lstsq`.
     *          
     *          
     *          Present only if `full` = True.  Residuals is sum of squared residuals
     *          of the least-squares fit, the effective rank of the scaled Vandermonde
     *          coefficient matrix, its singular values, and the specified value of
     *          `rcond`. For more details, see `linalg.lstsq`.
     *          
     *          
     *          Present only if `full` = False and `cov`=True.  The covariance
     *          matrix of the polynomial coefficient estimates.  The diagonal of
     *          this matrix are the variance estimates for each coefficient.  If y
     *          is a 2-D array, then the covariance matrix for the `k`-th data set
     *          are in ``V[:,:,k]``
     *          
     *          
     *          
     *          
     *          
     *          The rank of the coefficient matrix in the least-squares fit is
     *          deficient. The warning is only raised if `full` = False.
     *          
     *          The warnings can be turned off by
     *          
     *          &gt;&gt;&gt; import warnings
     *          &gt;&gt;&gt; warnings.simplefilter('ignore', np.RankWarning)
     */
    public final Object polyfit(Object x, Object y, Object deg, Object... args) {
        write("np.polyfit("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(y),PythonGrammar.toPythonArgs(deg)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return an antiderivative (indefinite integral) of a polynomial.
     * 
     * .. note::
     * This forms part of the old polynomial API. Since version 1.4, the
     * new polynomial API defined in `numpy.polynomial` is preferred.
     * A summary of the differences can be found in the
     * :doc:`transition guide </reference/routines.polynomials>`.
     * 
     * The returned order `m` antiderivative `P` of polynomial `p` satisfies
     * :math:`\frac{d^m}{dx^m}P(x) = p(x)` and is defined up to `m - 1`
     * integration constants `k`. The constants determine the low-order
     * polynomial part
     * 
     * .. math:: \frac{k_{m-1}}{0!} x^0 + \ldots + \frac{k_0}{(m-1)!}x^{m-1}
     * 
     * of `P` so that :math:`P^{(j)}(0) = k_{m-j-1}`.
     * 
     * @param p array_like or poly1d<br>
     *          Polynomial to integrate.
     *          A sequence is interpreted as polynomial coefficients, see `poly1d`.
     * @param m int, optional<br>
     *          Order of the antiderivative. (Default: 1)
     * @param k list of `m` scalars or scalar, optional<br>
     *          Integration constants. They are given in the order of integration:
     *          those corresponding to highest-order terms come first.
     *          
     *          If ``None`` (default), all constants are assumed to be zero.
     *          If `m = 1`, a single scalar can be given instead of a list.
     */
    public final Object polyint(Object p, Object... args) {
        write("np.polyint("+PythonGrammar.toPythonArgs(p)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find the product of two polynomials.
     * 
     * .. note::
     * This forms part of the old polynomial API. Since version 1.4, the
     * new polynomial API defined in `numpy.polynomial` is preferred.
     * A summary of the differences can be found in the
     * :doc:`transition guide </reference/routines.polynomials>`.
     * 
     * Finds the polynomial resulting from the multiplication of the two input
     * polynomials. Each input must be either a poly1d object or a 1D sequence
     * of polynomial coefficients, from highest to lowest degree.
     * 
     * @param a1 array_like or poly1d object<br>
     *           Input polynomials.
     * @param a2 array_like or poly1d object<br>
     *           Input polynomials.
     * 
     * @return out ndarray or poly1d object<br>
     *             The polynomial resulting from the multiplication of the inputs. If
     *             either inputs is a poly1d object, then the output is also a poly1d
     *             object. Otherwise, it is a 1D array of polynomial coefficients from
     *             highest to lowest degree.
     */
    public final Object polymul(Object a1, Object a2) {
        write("np.polymul("+PythonGrammar.toPythonArgs(a1),PythonGrammar.toPythonArgs(a2)+")");
        return null;
    }

    /**
     * Difference (subtraction) of two polynomials.
     * 
     * .. note::
     * This forms part of the old polynomial API. Since version 1.4, the
     * new polynomial API defined in `numpy.polynomial` is preferred.
     * A summary of the differences can be found in the
     * :doc:`transition guide </reference/routines.polynomials>`.
     * 
     * Given two polynomials `a1` and `a2`, returns ``a1 - a2``.
     * `a1` and `a2` can be either array_like sequences of the polynomials'
     * coefficients (including coefficients equal to zero), or `poly1d` objects.
     * 
     * @param a1 array_like or poly1d<br>
     *           Minuend and subtrahend polynomials, respectively.
     * @param a2 array_like or poly1d<br>
     *           Minuend and subtrahend polynomials, respectively.
     * 
     * @return out ndarray or poly1d<br>
     *             Array or `poly1d` object of the difference polynomial's coefficients.
     */
    public final Object polysub(Object a1, Object a2) {
        write("np.polysub("+PythonGrammar.toPythonArgs(a1),PythonGrammar.toPythonArgs(a2)+")");
        return null;
    }

    /**
     * Evaluate a polynomial at specific values.
     * 
     * .. note::
     * This forms part of the old polynomial API. Since version 1.4, the
     * new polynomial API defined in `numpy.polynomial` is preferred.
     * A summary of the differences can be found in the
     * :doc:`transition guide </reference/routines.polynomials>`.
     * 
     * If `p` is of length N, this function returns the value:
     * 
     * ``p[0]*x**(N-1) + p[1]*x**(N-2) + ... + p[N-2]*x + p[N-1]``
     * 
     * If `x` is a sequence, then ``p(x)`` is returned for each element of ``x``.
     * If `x` is another polynomial then the composite polynomial ``p(x(t))``
     * is returned.
     * <p>
     * <em>Notes:</em><br>
     * Horner's scheme [1]_ is used to evaluate the polynomial. Even so,
     * for polynomials of high degree the values may be inaccurate due to
     * rounding errors. Use carefully.
     * 
     * If `x` is a subtype of `ndarray` the return value will be of the same type.
     * 
     * @param p array_like or poly1d object<br>
     *          1D array of polynomial coefficients (including coefficients equal
     *          to zero) from highest degree to the constant term, or an
     *          instance of poly1d.
     * @param x array_like or poly1d object<br>
     *          A number, an array of numbers, or an instance of poly1d, at
     *          which to evaluate `p`.
     * 
     * @return values ndarray or poly1d<br>
     *                If `x` is a poly1d instance, the result is the composition of the two
     *                polynomials, i.e., `x` is "substituted" in `p` and the simplified
     *                result is returned. In addition, the type of `x` - array_like or
     *                poly1d - governs the type of the output: `x` array_like =&gt; `values`
     *                array_like, `x` a poly1d object =&gt; `values` is also.
     */
    public final Object polyval(Object p, Object x) {
        write("np.polyval("+PythonGrammar.toPythonArgs(p),PythonGrammar.toPythonArgs(x)+")");
        return null;
    }

    /**
     * Context manager for setting print options.
     * 
     * Set print options for the scope of the `with` block, and restore the old
     * options at the end. See `set_printoptions` for the full description of
     * available options.
     * 
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     */
    public final Object printoptions(Object... args) {
        write("np.printoptions("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the product of array elements over a given axis.
     * <p>
     * <em>Notes:</em><br>
     * Arithmetic is modular when using integer types, and no error is
     * raised on overflow.  That means that, on a 32-bit platform:
     * 
     * >>> x = np.array([536870910, 536870910, 536870910, 536870910])
     * >>> np.prod(x)
     * 16 # may vary
     * 
     * The product of an empty array is the neutral element 1:
     * 
     * >>> np.prod([])
     * 1.0
     * 
     * @param a array_like<br>
     *          Input data.
     * @param axis None or int or tuple of ints, optional<br>
     *             Axis or axes along which a product is performed.  The default,
     *             axis=None, will calculate the product of all the elements in the
     *             input array. If axis is negative it counts from the last to the
     *             first axis.
     *             
     *             .. versionadded:: 1.7.0
     *             
     *             If axis is a tuple of ints, a product is performed on all of the
     *             axes specified in the tuple instead of a single axis or all the
     *             axes as before.
     * @param dtype dtype, optional<br>
     *              The type of the returned array, as well as of the accumulator in
     *              which the elements are multiplied.  The dtype of `a` is used by
     *              default unless `a` has an integer dtype of less precision than the
     *              default platform integer.  In that case, if `a` is signed then the
     *              platform integer is used while if `a` is unsigned then an unsigned
     *              integer of the same precision as the platform integer is used.
     * @param out ndarray, optional<br>
     *            Alternative output array in which to place the result. It must have
     *            the same shape as the expected output, but the type of the output
     *            values will be cast if necessary.
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left in the
     *                 result as dimensions with size one. With this option, the result
     *                 will broadcast correctly against the input array.
     *                 
     *                 If the default value is passed, then `keepdims` will not be
     *                 passed through to the `prod` method of sub-classes of
     *                 `ndarray`, however any non-default value will be.  If the
     *                 sub-class' method does not implement `keepdims` any
     *                 exceptions will be raised.
     * @param initial scalar, optional<br>
     *                The starting value for this product. See `~numpy.ufunc.reduce` for details.
     *                
     *                .. versionadded:: 1.15.0
     *                
     * @param where array_like of bool, optional<br>
     *              Elements to include in the product. See `~numpy.ufunc.reduce` for details.
     *              
     *              .. versionadded:: 1.17.0
     * 
     * @return product_along_axis ndarray, see `dtype` parameter above.<br>
     *                            An array shaped as `a` but with the specified axis removed.
     *                            Returns a reference to `out` if specified.
     */
    public final Object prod(Object a, Object... args) {
        write("np.prod("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the product of array elements over a given axis.
     * 
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     */
    public final Object product(Object... args) {
        write("np.product("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Range of values (maximum - minimum) along an axis.
     * 
     * The name of the function comes from the acronym for 'peak to peak'.
     * 
     * .. warning::
     * `ptp` preserves the data type of the array. This means the
     * return value for an input of signed integers with n bits
     * (e.g. `np.int8`, `np.int16`, etc) is also a signed integer
     * with n bits.  In that case, peak-to-peak values greater than
     * ``2**(n-1)-1`` will be returned as negative values. An example
     * with a work-around is shown below.
     * 
     * @param a array_like<br>
     *          Input values.
     * @param axis None or int or tuple of ints, optional<br>
     *             Axis along which to find the peaks.  By default, flatten the
     *             array.  `axis` may be negative, in
     *             which case it counts from the last to the first axis.
     *             
     *             .. versionadded:: 1.15.0
     *             
     *             If this is a tuple of ints, a reduction is performed on multiple
     *             axes, instead of a single axis or all the axes as before.
     * @param out array_like<br>
     *            Alternative output array in which to place the result. It must
     *            have the same shape and buffer length as the expected output,
     *            but the type of the output values will be cast if necessary.
     *            
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left
     *                 in the result as dimensions with size one. With this option,
     *                 the result will broadcast correctly against the input array.
     *                 
     *                 If the default value is passed, then `keepdims` will not be
     *                 passed through to the `ptp` method of sub-classes of
     *                 `ndarray`, however any non-default value will be.  If the
     *                 sub-class' method does not implement `keepdims` any
     *                 exceptions will be raised.
     * 
     * @return ptp ndarray<br>
     *             A new array holding the result, unless `out` was
     *             specified, in which case a reference to `out` is returned.
     */
    public final Object ptp(Object a, Object... args) {
        write("np.ptp("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Replaces specified elements of an array with given values.
     * 
     * The indexing works on the flattened target array. `put` is roughly
     * equivalent to:
     * 
     * ::
     * 
     * a.flat[ind] = v
     * 
     * @param a ndarray<br>
     *          Target array.
     * @param ind array_like<br>
     *            Target indices, interpreted as integers.
     * @param v array_like<br>
     *          Values to place in `a` at target indices. If `v` is shorter than
     *          `ind` it will be repeated as necessary.
     * @param mode &#123;'raise', 'wrap', 'clip'&#125;, optional<br>
     *             Specifies how out-of-bounds indices will behave.
     *             
     *             * 'raise' -- raise an error (default)
     *             * 'wrap' -- wrap around
     *             * 'clip' -- clip to the range
     *             
     *             'clip' mode means that all indices that are too large are replaced
     *             by the index that addresses the last element along that axis. Note
     *             that this disables indexing with negative numbers. In 'raise' mode,
     *             if an exception occurs the target array may still be modified.
     */
    public final Object put(Object a, Object ind, Object v, Object... args) {
        write("np.put("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(ind),PythonGrammar.toPythonArgs(v)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Put values into the destination array by matching 1d index and data slices.
     * 
     * This iterates over matching 1d slices oriented along the specified axis in
     * the index and data arrays, and uses the former to place values into the
     * latter. These slices can be different lengths.
     * 
     * Functions returning an index along an axis, like `argsort` and
     * `argpartition`, produce suitable indices for this function.
     * 
     * .. versionadded:: 1.15.0
     * <p>
     * <em>Notes:</em><br>
     * This is equivalent to (but faster than) the following use of `ndindex` and
     * `s_`, which sets each of ``ii`` and ``kk`` to a tuple of indices::
     * 
     * Ni, M, Nk = a.shape[:axis], a.shape[axis], a.shape[axis+1:]
     * J = indices.shape[axis]  # Need not equal M
     * 
     * for ii in ndindex(Ni):
     * for kk in ndindex(Nk):
     * a_1d       = a      [ii + s_[:,] + kk]
     * indices_1d = indices[ii + s_[:,] + kk]
     * values_1d  = values [ii + s_[:,] + kk]
     * for j in range(J):
     * a_1d[indices_1d[j]] = values_1d[j]
     * 
     * Equivalently, eliminating the inner loop, the last two lines would be::
     * 
     * a_1d[indices_1d] = values_1d
     * 
     * @param arr ndarray (Ni..., M, Nk...)<br>
     *            Destination array.
     * @param indices ndarray (Ni..., J, Nk...)<br>
     *                Indices to change along each 1d slice of `arr`. This must match the
     *                dimension of arr, but dimensions in Ni and Nj may be 1 to broadcast
     *                against `arr`.
     * @param values array_like (Ni..., J, Nk...)<br>
     *               values to insert at those indices. Its shape and dimension are
     *               broadcast to match that of `indices`.
     * @param axis int<br>
     *             The axis to take 1d slices along. If axis is None, the destination
     *             array is treated as if a flattened 1d view had been created of it.
     */
    public final Object put_along_axis(Object arr, Object indices, Object values, Object axis) {
        write("np.put_along_axis("+PythonGrammar.toPythonArgs(arr),PythonGrammar.toPythonArgs(indices),PythonGrammar.toPythonArgs(values),PythonGrammar.toPythonArgs(axis)+")");
        return null;
    }

    /**
     * putmask(a, mask, values)
     * 
     * Changes elements of an array based on conditional and input values.
     * 
     * Sets ``a.flat[n] = values[n]`` for each n where ``mask.flat[n]==True``.
     * 
     * If `values` is not the same size as `a` and `mask` then it will repeat.
     * This gives behavior different from ``a[mask] = values``.
     * 
     * @param a ndarray<br>
     *          Target array.
     * @param mask array_like<br>
     *             Boolean mask array. It has to be the same shape as `a`.
     * @param values array_like<br>
     *               Values to put into `a` where `mask` is True. If `values` is smaller
     *               than `a` it will be repeated.
     * @param ... n/a<br>undocumented
     */
    public final Object putmask(Object... args) {
        write("np.putmask("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Compute the q-th quantile of the data along the specified axis.
     * 
     * .. versionadded:: 1.15.0
     * <p>
     * <em>Notes:</em><br>
     * Given a vector ``V`` of length ``N``, the q-th quantile of
     * ``V`` is the value ``q`` of the way from the minimum to the
     * maximum in a sorted copy of ``V``. The values and distances of
     * the two nearest neighbors as well as the `interpolation` parameter
     * will determine the quantile if the normalized ranking does not
     * match the location of ``q`` exactly. This function is the same as
     * the median if ``q=0.5``, the same as the minimum if ``q=0.0`` and the
     * same as the maximum if ``q=1.0``.
     * 
     * @param a array_like<br>
     *          Input array or object that can be converted to an array.
     * @param q array_like of float<br>
     *          Quantile or sequence of quantiles to compute, which must be between
     *          0 and 1 inclusive.
     * @param axis &#123;int, tuple of int, None&#125;, optional<br>
     *             Axis or axes along which the quantiles are computed. The
     *             default is to compute the quantile(s) along a flattened
     *             version of the array.
     * @param out ndarray, optional<br>
     *            Alternative output array in which to place the result. It must
     *            have the same shape and buffer length as the expected output,
     *            but the type (of the output) will be cast if necessary.
     * @param overwrite_input bool, optional<br>
     *                        If True, then allow the input array `a` to be modified by intermediate
     *                        calculations, to save memory. In this case, the contents of the input
     *                        `a` after this function completes is undefined.
     * @param interpolation &#123;'linear', 'lower', 'higher', 'midpoint', 'nearest'&#125;<br>
     *                      This optional parameter specifies the interpolation method to
     *                      use when the desired quantile lies between two data points
     *                      ``i &lt; j``:
     *                      
     *                      * linear: ``i + (j - i) * fraction``, where ``fraction``
     *                      is the fractional part of the index surrounded by ``i``
     *                      and ``j``.
     *                      * lower: ``i``.
     *                      * higher: ``j``.
     *                      * nearest: ``i`` or ``j``, whichever is nearest.
     *                      * midpoint: ``(i + j) / 2``.
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left in
     *                 the result as dimensions with size one. With this option, the
     *                 result will broadcast correctly against the original array `a`.
     * 
     * @return quantile scalar or ndarray<br>
     *                  If `q` is a single quantile and `axis=None`, then the result
     *                  is a scalar. If multiple quantiles are given, first axis of
     *                  the result corresponds to the quantiles. The other axes are
     *                  the axes that remain after the reduction of `a`. If the input
     *                  contains integers or floats smaller than ``float64``, the output
     *                  data-type is ``float64``. Otherwise, the output data-type is the
     *                  same as that of the input. If `out` is specified, that array is
     *                  returned instead.
     */
    public final Object quantile(Object a, Object q, Object... args) {
        write("np.quantile("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(q)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return a contiguous flattened array.
     * 
     * A 1-D array, containing the elements of the input, is returned.  A copy is
     * made only if needed.
     * 
     * As of NumPy 1.10, the returned array will have the same type as the input
     * array. (for example, a masked array will be returned for a masked array
     * input)
     * <p>
     * <em>Notes:</em><br>
     * In row-major, C-style order, in two dimensions, the row index
     * varies the slowest, and the column index the quickest.  This can
     * be generalized to multiple dimensions, where row-major order
     * implies that the index along the first axis varies slowest, and
     * the index along the last quickest.  The opposite holds for
     * column-major, Fortran-style index ordering.
     * 
     * When a view is desired in as many cases as possible, ``arr.reshape(-1)``
     * may be preferable.
     * 
     * @param a array_like<br>
     *          Input array.  The elements in `a` are read in the order specified by
     *          `order`, and packed as a 1-D array.
     * @param order &#123;'C','F', 'A', 'K'&#125;, optional<br>
     *              
     *              The elements of `a` are read using this index order. 'C' means
     *              to index the elements in row-major, C-style order,
     *              with the last axis index changing fastest, back to the first
     *              axis index changing slowest.  'F' means to index the elements
     *              in column-major, Fortran-style order, with the
     *              first index changing fastest, and the last index changing
     *              slowest. Note that the 'C' and 'F' options take no account of
     *              the memory layout of the underlying array, and only refer to
     *              the order of axis indexing.  'A' means to read the elements in
     *              Fortran-like index order if `a` is Fortran *contiguous* in
     *              memory, C-like order otherwise.  'K' means to read the
     *              elements in the order they occur in memory, except for
     *              reversing the data when strides are negative.  By default, 'C'
     *              index order is used.
     * 
     * @return y array_like<br>
     *           y is an array of the same subtype as `a`, with shape ``(a.size,)``.
     *           Note that matrices are special cased for backward compatibility, if `a`
     *           is a matrix, then y is a 1-D ndarray.
     */
    public final Object ravel(Object a, Object... args) {
        write("np.ravel("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * ravel_multi_index(multi_index, dims, mode='raise', order='C')
     * 
     * Converts a tuple of index arrays into an array of flat
     * indices, applying boundary modes to the multi-index.
     * <p>
     * <em>Notes:</em><br>
     * .. versionadded:: 1.6.0
     * 
     * @param multi_index tuple of array_like<br>
     *                    A tuple of integer arrays, one array for each dimension.
     * @param dims tuple of ints<br>
     *             The shape of array into which the indices from ``multi_index`` apply.
     * @param mode &#123;'raise', 'wrap', 'clip'&#125;, optional<br>
     *             Specifies how out-of-bounds indices are handled.  Can specify
     *             either one mode or a tuple of modes, one mode per index.
     *             
     *             * 'raise' -- raise an error (default)
     *             * 'wrap' -- wrap around
     *             * 'clip' -- clip to the range
     *             
     *             In 'clip' mode, a negative index which would normally
     *             wrap will clip to 0 instead.
     * @param order &#123;'C', 'F'&#125;, optional<br>
     *              Determines whether the multi-index should be viewed as
     *              indexing in row-major (C-style) or column-major
     *              (Fortran-style) order.
     * @param ... n/a<br>undocumented
     * 
     * @return raveled_indices ndarray<br>
     *                         An array of indices into the flattened version of an array
     *                         of dimensions ``dims``.
     */
    public final Object ravel_multi_index(Object... args) {
        write("np.ravel_multi_index("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the real part of the complex argument.
     * 
     * @param val array_like<br>
     *            Input array.
     * 
     * @return out ndarray or scalar<br>
     *             The real component of the complex argument. If `val` is real, the type
     *             of `val` is used for the output.  If `val` has complex elements, the
     *             returned type is float.
     */
    public final Object real(Object val) {
        write("np.real("+PythonGrammar.toPythonArgs(val)+")");
        return null;
    }

    /**
     * If input is complex with all imaginary parts close to zero, return
     * real parts.
     * 
     * "Close to zero" is defined as `tol` * (machine epsilon of the type for
     * `a`).
     * <p>
     * <em>Notes:</em><br>
     * Machine epsilon varies from machine to machine and between data types
     * but Python floats on most platforms have a machine epsilon equal to
     * 2.2204460492503131e-16.  You can use 'np.finfo(float).eps' to print
     * out the machine epsilon for floats.
     * 
     * @param a array_like<br>
     *          Input array.
     * @param tol float<br>
     *            Tolerance in machine epsilons for the complex part of the elements
     *            in the array.
     * 
     * @return out ndarray<br>
     *             If `a` is real, the type of `a` is used for the output.  If `a`
     *             has complex elements, the returned type is float.
     */
    public final Object real_if_close(Object a, Object... args) {
        write("np.real_if_close("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Load ASCII data stored in a comma-separated file.
     * 
     * The returned array is a record array (if ``usemask=False``, see
     * `recarray`) or a masked record array (if ``usemask=True``,
     * see `ma.mrecords.MaskedRecords`).
     * <p>
     * <em>Notes:</em><br>
     * By default, `dtype` is None, which means that the data-type of the output
     * array will be determined from the data.
     * 
     * @param fname For a description of input parameters, see `genfromtxt`.<br>
     * @param kwargs For a description of input parameters, see `genfromtxt`.<br>
     */
    public final Object recfromcsv(Object fname, Object... args) {
        write("np.recfromcsv("+PythonGrammar.toPythonArgs(fname)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Load ASCII data from a file and return it in a record array.
     * 
     * If ``usemask=False`` a standard `recarray` is returned,
     * if ``usemask=True`` a MaskedRecords array is returned.
     * <p>
     * <em>Notes:</em><br>
     * By default, `dtype` is None, which means that the data-type of the output
     * array will be determined from the data.
     * 
     * @param fname For a description of input parameters, see `genfromtxt`.<br>
     * @param kwargs For a description of input parameters, see `genfromtxt`.<br>
     */
    public final Object recfromtxt(Object fname, Object... args) {
        write("np.recfromtxt("+PythonGrammar.toPythonArgs(fname)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Repeat elements of an array.
     * 
     * @param a array_like<br>
     *          Input array.
     * @param repeats int or array of ints<br>
     *                The number of repetitions for each element.  `repeats` is broadcasted
     *                to fit the shape of the given axis.
     * @param axis int, optional<br>
     *             The axis along which to repeat values.  By default, use the
     *             flattened input array, and return a flat output array.
     * 
     * @return repeated_array ndarray<br>
     *                        Output array which has the same shape as `a`, except along
     *                        the given axis.
     */
    public final Object repeat(Object a, Object repeats, Object... args) {
        write("np.repeat("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(repeats)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return an ndarray of the provided type that satisfies requirements.
     * 
     * This function is useful to be sure that an array with the correct flags
     * is returned for passing to compiled code (perhaps through ctypes).
     * <p>
     * <em>Notes:</em><br>
     * The returned array will be guaranteed to have the listed requirements
     * by making a copy if needed.
     * 
     * @param a array_like<br>
     *          The object to be converted to a type-and-requirement-satisfying array.
     * @param dtype data-type<br>
     *              The required data-type. If None preserve the current dtype. If your
     *              application requires the data to be in native byteorder, include
     *              a byteorder specification as a part of the dtype specification.
     * @param requirements str or list of str<br>
     *                     The requirements list can be any of the following
     *                     
     *                     * 'F_CONTIGUOUS' ('F') - ensure a Fortran-contiguous array
     *                     * 'C_CONTIGUOUS' ('C') - ensure a C-contiguous array
     *                     * 'ALIGNED' ('A')      - ensure a data-type aligned array
     *                     * 'WRITEABLE' ('W')    - ensure a writable array
     *                     * 'OWNDATA' ('O')      - ensure an array that owns its own data
     *                     * 'ENSUREARRAY', ('E') - ensure a base array, instead of a subclass
     * @param like array_like<br>
     *             Reference object to allow the creation of arrays which are not
     *             NumPy arrays. If an array-like passed in as ``like`` supports
     *             the ``__array_function__`` protocol, the result will be defined
     *             by it. In this case, it ensures the creation of an array object
     *             compatible with that passed in via this argument.
     *             
     *             .. versionadded:: 1.20.0
     * 
     * @return out ndarray<br>
     *             Array with specified requirements and type if given.
     */
    public final Object require(Object a, Object... args) {
        write("np.require("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Gives a new shape to an array without changing its data.
     * <p>
     * <em>Notes:</em><br>
     * It is not always possible to change the shape of an array without
     * copying the data. If you want an error to be raised when the data is copied,
     * you should assign the new shape to the shape attribute of the array::
     * 
     * >>> a = np.zeros((10, 2))
     * 
     * # A transpose makes the array non-contiguous
     * >>> b = a.T
     * 
     * # Taking a view makes it possible to modify the shape without modifying
     * # the initial object.
     * >>> c = b.view()
     * >>> c.shape = (20)
     * Traceback (most recent call last):
     * ...
     * AttributeError: Incompatible shape for in-place modification. Use
     * `.reshape()` to make a copy with the desired shape.
     * 
     * The `order` keyword gives the index ordering both for *fetching* the values
     * from `a`, and then *placing* the values into the output array.
     * For example, let's say you have an array:
     * 
     * >>> a = np.arange(6).reshape((3, 2))
     * >>> a
     * array([[0, 1],
     * [2, 3],
     * [4, 5]])
     * 
     * You can think of reshaping as first raveling the array (using the given
     * index order), then inserting the elements from the raveled array into the
     * new array using the same kind of index ordering as was used for the
     * raveling.
     * 
     * >>> np.reshape(a, (2, 3)) # C-like index ordering
     * array([[0, 1, 2],
     * [3, 4, 5]])
     * >>> np.reshape(np.ravel(a), (2, 3)) # equivalent to C ravel then C reshape
     * array([[0, 1, 2],
     * [3, 4, 5]])
     * >>> np.reshape(a, (2, 3), order='F') # Fortran-like index ordering
     * array([[0, 4, 3],
     * [2, 1, 5]])
     * >>> np.reshape(np.ravel(a, order='F'), (2, 3), order='F')
     * array([[0, 4, 3],
     * [2, 1, 5]])
     * 
     * @param a array_like<br>
     *          Array to be reshaped.
     * @param newshape int or tuple of ints<br>
     *                 The new shape should be compatible with the original shape. If
     *                 an integer, then the result will be a 1-D array of that length.
     *                 One shape dimension can be -1. In this case, the value is
     *                 inferred from the length of the array and remaining dimensions.
     * @param order &#123;'C', 'F', 'A'&#125;, optional<br>
     *              Read the elements of `a` using this index order, and place the
     *              elements into the reshaped array using this index order.  'C'
     *              means to read / write the elements using C-like index order,
     *              with the last axis index changing fastest, back to the first
     *              axis index changing slowest. 'F' means to read / write the
     *              elements using Fortran-like index order, with the first index
     *              changing fastest, and the last index changing slowest. Note that
     *              the 'C' and 'F' options take no account of the memory layout of
     *              the underlying array, and only refer to the order of indexing.
     *              'A' means to read / write the elements in Fortran-like index
     *              order if `a` is Fortran *contiguous* in memory, C-like order
     *              otherwise.
     * 
     * @return reshaped_array ndarray<br>
     *                        This will be a new view object if possible; otherwise, it will
     *                        be a copy.  Note there is no guarantee of the *memory layout* (C- or
     *                        Fortran- contiguous) of the returned array.
     */
    public final Object reshape(Object a, Object newshape, Object... args) {
        write("np.reshape("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(newshape)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return a new array with the specified shape.
     * 
     * If the new array is larger than the original array, then the new
     * array is filled with repeated copies of `a`.  Note that this behavior
     * is different from a.resize(new_shape) which fills with zeros instead
     * of repeated copies of `a`.
     * <p>
     * <em>Notes:</em><br>
     * When the total size of the array does not change `~numpy.reshape` should
     * be used.  In most other cases either indexing (to reduce the size)
     * or padding (to increase the size) may be a more appropriate solution.
     * 
     * Warning: This functionality does **not** consider axes separately,
     * i.e. it does not apply interpolation/extrapolation.
     * It fills the return array with the required number of elements, iterating
     * over `a` in C-order, disregarding axes (and cycling back from the start if
     * the new shape is larger).  This functionality is therefore not suitable to
     * resize images, or data where each axis represents a separate and distinct
     * entity.
     * 
     * @param a array_like<br>
     *          Array to be resized.
     *          
     * @param new_shape int or tuple of int<br>
     *                  Shape of resized array.
     * 
     * @return reshaped_array ndarray<br>
     *                        The new array is formed from the data in the old array, repeated
     *                        if necessary to fill out the required number of elements.  The
     *                        data are repeated iterating over the array in C-order.
     */
    public final Object resize(Object a, Object new_shape) {
        write("np.resize("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(new_shape)+")");
        return null;
    }

    /**
     * result_type(*arrays_and_dtypes)
     * 
     * Returns the type that results from applying the NumPy
     * type promotion rules to the arguments.
     * 
     * Type promotion in NumPy works similarly to the rules in languages
     * like C++, with some slight differences.  When both scalars and
     * arrays are used, the array's type takes precedence and the actual value
     * of the scalar is taken into account.
     * 
     * For example, calculating 3*a, where a is an array of 32-bit floats,
     * intuitively should result in a 32-bit float output.  If the 3 is a
     * 32-bit integer, the NumPy rules indicate it can't convert losslessly
     * into a 32-bit float, so a 64-bit float should be the result type.
     * By examining the value of the constant, '3', we see that it fits in
     * an 8-bit integer, which can be cast losslessly into the 32-bit float.
     * <p>
     * <em>Notes:</em><br>
     * .. versionadded:: 1.6.0
     * 
     * The specific algorithm used is as follows.
     * 
     * Categories are determined by first checking which of boolean,
     * integer (int/uint), or floating point (float/complex) the maximum
     * kind of all the arrays and the scalars are.
     * 
     * If there are only scalars or the maximum category of the scalars
     * is higher than the maximum category of the arrays,
     * the data types are combined with :func:`promote_types`
     * to produce the return value.
     * 
     * Otherwise, `min_scalar_type` is called on each array, and
     * the resulting data types are all combined with :func:`promote_types`
     * to produce the return value.
     * 
     * The set of int values is not a subset of the uint values for types
     * with the same number of bits, something not reflected in
     * :func:`min_scalar_type`, but handled as a special case in `result_type`.
     * 
     * @param arrays_and_dtypes list of arrays and dtypes<br>
     *                          The operands of some operation whose result type is needed.
     * @param ... n/a<br>undocumented
     * 
     * @return out dtype<br>
     *             The result type.
     */
    public final Object result_type(Object... args) {
        write("np.result_type("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Roll array elements along a given axis.
     * 
     * Elements that roll beyond the last position are re-introduced at
     * the first.
     * <p>
     * <em>Notes:</em><br>
     * .. versionadded:: 1.12.0
     * 
     * Supports rolling over multiple dimensions simultaneously.
     * 
     * @param a array_like<br>
     *          Input array.
     * @param shift int or tuple of ints<br>
     *              The number of places by which elements are shifted.  If a tuple,
     *              then `axis` must be a tuple of the same size, and each of the
     *              given axes is shifted by the corresponding number.  If an int
     *              while `axis` is a tuple of ints, then the same value is used for
     *              all given axes.
     * @param axis int or tuple of ints, optional<br>
     *             Axis or axes along which elements are shifted.  By default, the
     *             array is flattened before shifting, after which the original
     *             shape is restored.
     * 
     * @return res ndarray<br>
     *             Output array, with the same shape as `a`.
     */
    public final Object roll(Object a, Object shift, Object... args) {
        write("np.roll("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(shift)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Roll the specified axis backwards, until it lies in a given position.
     * 
     * This function continues to be supported for backward compatibility, but you
     * should prefer `moveaxis`. The `moveaxis` function was added in NumPy
     * 1.11.
     * 
     * @param a ndarray<br>
     *          Input array.
     * @param axis int<br>
     *             The axis to be rolled. The positions of the other axes do not
     *             change relative to one another.
     * @param start int, optional<br>
     *              When ``start &lt;= axis``, the axis is rolled back until it lies in
     *              this position. When ``start &gt; axis``, the axis is rolled until it
     *              lies before this position. The default, 0, results in a "complete"
     *              roll. The following table describes how negative values of ``start``
     *              are interpreted:
     *              
     *              .. table::
     *              :align: left
     *              
     *              +-------------------+----------------------+
     *              |     ``start``     | Normalized ``start`` |
     *              +===================+======================+
     *              | ``-(arr.ndim+1)`` | raise ``AxisError``  |
     *              +-------------------+----------------------+
     *              | ``-arr.ndim``     | 0                    |
     *              +-------------------+----------------------+
     *              | |vdots|           | |vdots|              |
     *              +-------------------+----------------------+
     *              | ``-1``            | ``arr.ndim-1``       |
     *              +-------------------+----------------------+
     *              | ``0``             | ``0``                |
     *              +-------------------+----------------------+
     *              | |vdots|           | |vdots|              |
     *              +-------------------+----------------------+
     *              | ``arr.ndim``      | ``arr.ndim``         |
     *              +-------------------+----------------------+
     *              | ``arr.ndim + 1``  | raise ``AxisError``  |
     *              +-------------------+----------------------+
     *              
     *              .. |vdots|   unicode:: U+22EE .. Vertical Ellipsis
     * 
     * @return res ndarray<br>
     *             For NumPy &gt;= 1.10.0 a view of `a` is always returned. For earlier
     *             NumPy versions a view of `a` is returned only if the order of the
     *             axes is changed, otherwise the input array is returned.
     */
    public final Object rollaxis(Object a, Object axis, Object... args) {
        write("np.rollaxis("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(axis)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the roots of a polynomial with coefficients given in p.
     * 
     * .. note::
     * This forms part of the old polynomial API. Since version 1.4, the
     * new polynomial API defined in `numpy.polynomial` is preferred.
     * A summary of the differences can be found in the
     * :doc:`transition guide </reference/routines.polynomials>`.
     * 
     * The values in the rank-1 array `p` are coefficients of a polynomial.
     * If the length of `p` is n+1 then the polynomial is described by::
     * 
     * p[0] * x**n + p[1] * x**(n-1) + ... + p[n-1]*x + p[n]
     * <p>
     * <em>Notes:</em><br>
     * The algorithm relies on computing the eigenvalues of the
     * companion matrix [1]_.
     * 
     * @param p array_like<br>
     *          Rank-1 array of polynomial coefficients.
     * 
     * @return out ndarray<br>
     *             An array containing the roots of the polynomial.
     */
    public final Object roots(Object p) {
        write("np.roots("+PythonGrammar.toPythonArgs(p)+")");
        return null;
    }

    /**
     * Rotate an array by 90 degrees in the plane specified by axes.
     * 
     * Rotation direction is from the first towards the second axis.
     * <p>
     * <em>Notes:</em><br>
     * rot90(m, k=1, axes=(1,0)) is the reverse of rot90(m, k=1, axes=(0,1))
     * rot90(m, k=1, axes=(1,0)) is equivalent to rot90(m, k=-1, axes=(0,1))
     * 
     * @param m array_like<br>
     *          Array of two or more dimensions.
     * @param k integer<br>
     *          Number of times the array is rotated by 90 degrees.
     * @param axes (2,) array_like<br>
     *             The array is rotated in the plane defined by the axes.
     *             Axes must be different.
     *             
     *             .. versionadded:: 1.12.0
     * 
     * @return y ndarray<br>
     *           A rotated view of `m`.
     */
    public final Object rot90(Object m, Object... args) {
        write("np.rot90("+PythonGrammar.toPythonArgs(m)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Round an array to the given number of decimals.
     * <p>
     * <em>Notes:</em><br>
     * 
     * 
     * Note that the method name deviates from the description (which is for {@link #round_}). This is most likely due to round being an alias for round_.
     * 
     * @param a n/a<br>undocumented
     * @param decimals n/a<br>undocumented
     * @param out n/a<br>undocumented
     */
    public final Object round(Object... args) {
        write("np.round("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Round an array to the given number of decimals.
     * 
     * @param a n/a<br>undocumented
     * @param decimals n/a<br>undocumented
     * @param out n/a<br>undocumented
     */
    public final Object round_(Object... args) {
        write("np.round_("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Stack arrays in sequence vertically (row wise).
     * 
     * This is equivalent to concatenation along the first axis after 1-D arrays
     * of shape `(N,)` have been reshaped to `(1,N)`. Rebuilds arrays divided by
     * `vsplit`.
     * 
     * This function makes most sense for arrays with up to 3 dimensions. For
     * instance, for pixel-data with a height (first axis), width (second axis),
     * and r/g/b channels (third axis). The functions `concatenate`, `stack` and
     * `block` provide more general stacking and concatenation operations.
     * <p>
     * <em>Notes:</em><br>
     * 
     * 
     * Note that the method name deviates from the description (which is for {@link #vstack}). This is most likely due to row_stack being an alias for vstack.
     * 
     * @param tup sequence of ndarrays<br>
     *            The arrays must have the same shape along all but the first axis.
     *            1-D arrays must have the same length.
     * 
     * @return stacked ndarray<br>
     *                 The array formed by stacking the given arrays, will be at least 2-D.
     */
    public final Object row_stack(Object tup) {
        write("np.row_stack("+PythonGrammar.toPythonArgs(tup)+")");
        return null;
    }

    /**
     * Protected string evaluation.
     * 
     * Evaluate a string containing a Python literal expression without
     * allowing the execution of arbitrary non-literal code.
     * 
     * @param source str<br>
     *               The string to evaluate.
     * 
     * @return obj object<br>
     *             The result of evaluating `source`.
     */
    public final Object safe_eval(Object source) {
        write("np.safe_eval("+PythonGrammar.toPythonArgs(source)+")");
        return null;
    }

    /**
     * Save an array to a binary file in NumPy ``.npy`` format.
     * <p>
     * <em>Notes:</em><br>
     * For a description of the ``.npy`` format, see :py:mod:`numpy.lib.format`.
     * 
     * Any data saved to the file is appended to the end of the file.
     * 
     * @param file file, str, or pathlib.Path<br>
     *             File or filename to which the data is saved.  If file is a file-object,
     *             then the filename is unchanged.  If file is a string or Path, a ``.npy``
     *             extension will be appended to the filename if it does not already
     *             have one.
     * @param arr array_like<br>
     *            Array data to be saved.
     * @param allow_pickle bool, optional<br>
     *                     Allow saving object arrays using Python pickles. Reasons for disallowing
     *                     pickles include security (loading pickled data can execute arbitrary
     *                     code) and portability (pickled objects may not be loadable on different
     *                     Python installations, for example if the stored objects require libraries
     *                     that are not available, and not all pickled data is compatible between
     *                     Python 2 and Python 3).
     *                     Default: True
     * @param fix_imports bool, optional<br>
     *                    Only useful in forcing objects in object arrays on Python 3 to be
     *                    pickled in a Python 2 compatible way. If `fix_imports` is True, pickle
     *                    will try to map the new Python 3 names to the old module names used in
     *                    Python 2, so that the pickle data stream is readable with Python 2.
     */
    public final Object save(Object file, Object arr, Object... args) {
        write("np.save("+PythonGrammar.toPythonArgs(file),PythonGrammar.toPythonArgs(arr)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Save an array to a text file.
     * <p>
     * <em>Notes:</em><br>
     * Further explanation of the `fmt` parameter
     * (``%[flag]width[.precision]specifier``):
     * 
     * flags:
     * ``-`` : left justify
     * 
     * ``+`` : Forces to precede result with + or -.
     * 
     * ``0`` : Left pad the number with zeros instead of space (see width).
     * 
     * width:
     * Minimum number of characters to be printed. The value is not truncated
     * if it has more characters.
     * 
     * precision:
     * - For integer specifiers (eg. ``d,i,o,x``), the minimum number of
     * digits.
     * - For ``e, E`` and ``f`` specifiers, the number of digits to print
     * after the decimal point.
     * - For ``g`` and ``G``, the maximum number of significant digits.
     * - For ``s``, the maximum number of characters.
     * 
     * specifiers:
     * ``c`` : character
     * 
     * ``d`` or ``i`` : signed decimal integer
     * 
     * ``e`` or ``E`` : scientific notation with ``e`` or ``E``.
     * 
     * ``f`` : decimal floating point
     * 
     * ``g,G`` : use the shorter of ``e,E`` or ``f``
     * 
     * ``o`` : signed octal
     * 
     * ``s`` : string of characters
     * 
     * ``u`` : unsigned decimal integer
     * 
     * ``x,X`` : unsigned hexadecimal integer
     * 
     * This explanation of ``fmt`` is not complete, for an exhaustive
     * specification see [1]_.
     * 
     * @param fname filename or file handle<br>
     *              If the filename ends in ``.gz``, the file is automatically saved in
     *              compressed gzip format.  `loadtxt` understands gzipped files
     *              transparently.
     * @param X 1D or 2D array_like<br>
     *          Data to be saved to a text file.
     * @param fmt str or sequence of strs, optional<br>
     *            A single format (%10.5f), a sequence of formats, or a
     *            multi-format string, e.g. 'Iteration %d -- %10.5f', in which
     *            case `delimiter` is ignored. For complex `X`, the legal options
     *            for `fmt` are:
     *            
     *            * a single specifier, `fmt='%.4e'`, resulting in numbers formatted
     *            like `' (%s+%sj)' % (fmt, fmt)`
     *            * a full string specifying every real and imaginary part, e.g.
     *            `' %.4e %+.4ej %.4e %+.4ej %.4e %+.4ej'` for 3 columns
     *            * a list of specifiers, one per column - in this case, the real
     *            and imaginary part must have separate specifiers,
     *            e.g. `['%.3e + %.3ej', '(%.15e%+.15ej)']` for 2 columns
     * @param delimiter str, optional<br>
     *                  String or character separating columns.
     * @param newline str, optional<br>
     *                String or character separating lines.
     *                
     *                .. versionadded:: 1.5.0
     * @param header str, optional<br>
     *               String that will be written at the beginning of the file.
     *               
     *               .. versionadded:: 1.7.0
     * @param footer str, optional<br>
     *               String that will be written at the end of the file.
     *               
     *               .. versionadded:: 1.7.0
     * @param comments str, optional<br>
     *                 String that will be prepended to the ``header`` and ``footer`` strings,
     *                 to mark them as comments. Default: '# ',  as expected by e.g.
     *                 ``numpy.loadtxt``.
     *                 
     *                 .. versionadded:: 1.7.0
     * @param encoding &#123;None, str&#125;, optional<br>
     *                 Encoding used to encode the outputfile. Does not apply to output
     *                 streams. If the encoding is something other than 'bytes' or 'latin1'
     *                 you will not be able to load the file in NumPy versions &lt; 1.14. Default
     *                 is 'latin1'.
     *                 
     *                 .. versionadded:: 1.14.0
     */
    public final Object savetxt(Object fname, Object X, Object... args) {
        write("np.savetxt("+PythonGrammar.toPythonArgs(fname),PythonGrammar.toPythonArgs(X)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Save several arrays into a single file in uncompressed ``.npz`` format.
     * 
     * Provide arrays as keyword arguments to store them under the
     * corresponding name in the output file: ``savez(fn, x=x, y=y)``.
     * 
     * If arrays are specified as positional arguments, i.e., ``savez(fn,
     * x, y)``, their names will be `arr_0`, `arr_1`, etc.
     * <p>
     * <em>Notes:</em><br>
     * The ``.npz`` file format is a zipped archive of files named after the
     * variables they contain.  The archive is not compressed and each file
     * in the archive contains one variable in ``.npy`` format. For a
     * description of the ``.npy`` format, see :py:mod:`numpy.lib.format`.
     * 
     * When opening the saved ``.npz`` file with `load` a `NpzFile` object is
     * returned. This is a dictionary-like object which can be queried for
     * its list of arrays (with the ``.files`` attribute), and for the arrays
     * themselves.
     * 
     * When saving dictionaries, the dictionary keys become filenames
     * inside the ZIP archive. Therefore, keys should be valid filenames.
     * E.g., avoid keys that begin with ``/`` or contain ``.``.
     * 
     * @param file str or file<br>
     *             Either the filename (string) or an open file (file-like object)
     *             where the data will be saved. If file is a string or a Path, the
     *             ``.npz`` extension will be appended to the filename if it is not
     *             already there.
     * @param args Arguments, optional<br>
     *             Arrays to save to the file. Please use keyword arguments (see
     *             `kwds` below) to assign names to arrays.  Arrays specified as
     *             args will be named "arr_0", "arr_1", and so on.
     * @param kwds Keyword arguments, optional<br>
     *             Arrays to save to the file. Each array will be saved to the
     *             output file with its corresponding keyword name.
     * 
     * @return None <br>
     */
    public final Object savez(Object file, Object... args) {
        write("np.savez("+PythonGrammar.toPythonArgs(file)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Save several arrays into a single file in compressed ``.npz`` format.
     * 
     * Provide arrays as keyword arguments to store them under the
     * corresponding name in the output file: ``savez(fn, x=x, y=y)``.
     * 
     * If arrays are specified as positional arguments, i.e., ``savez(fn,
     * x, y)``, their names will be `arr_0`, `arr_1`, etc.
     * <p>
     * <em>Notes:</em><br>
     * The ``.npz`` file format is a zipped archive of files named after the
     * variables they contain.  The archive is compressed with
     * ``zipfile.ZIP_DEFLATED`` and each file in the archive contains one variable
     * in ``.npy`` format. For a description of the ``.npy`` format, see
     * :py:mod:`numpy.lib.format`.
     * 
     * 
     * When opening the saved ``.npz`` file with `load` a `NpzFile` object is
     * returned. This is a dictionary-like object which can be queried for
     * its list of arrays (with the ``.files`` attribute), and for the arrays
     * themselves.
     * 
     * @param file str or file<br>
     *             Either the filename (string) or an open file (file-like object)
     *             where the data will be saved. If file is a string or a Path, the
     *             ``.npz`` extension will be appended to the filename if it is not
     *             already there.
     * @param args Arguments, optional<br>
     *             Arrays to save to the file. Please use keyword arguments (see
     *             `kwds` below) to assign names to arrays.  Arrays specified as
     *             args will be named "arr_0", "arr_1", and so on.
     * @param kwds Keyword arguments, optional<br>
     *             Arrays to save to the file. Each array will be saved to the
     *             output file with its corresponding keyword name.
     * 
     * @return None <br>
     */
    public final Object savez_compressed(Object file, Object... args) {
        write("np.savez_compressed("+PythonGrammar.toPythonArgs(file)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the string representation of a scalar dtype.
     * 
     * @param sctype scalar dtype or object<br>
     *               If a scalar dtype, the corresponding string character is
     *               returned. If an object, `sctype2char` tries to infer its scalar type
     *               and then return the corresponding string character.
     * 
     * @return typechar str<br>
     *                  The string character corresponding to the scalar type.
     */
    public final Object sctype2char(Object sctype) {
        write("np.sctype2char("+PythonGrammar.toPythonArgs(sctype)+")");
        return null;
    }

    /**
     * Find indices where elements should be inserted to maintain order.
     * 
     * Find the indices into a sorted array `a` such that, if the
     * corresponding elements in `v` were inserted before the indices, the
     * order of `a` would be preserved.
     * 
     * Assuming that `a` is sorted:
     * 
     * ======  ============================
     * `side`  returned index `i` satisfies
     * ======  ============================
     * left    ``a[i-1] < v <= a[i]``
     * right   ``a[i-1] <= v < a[i]``
     * ======  ============================
     * <p>
     * <em>Notes:</em><br>
     * Binary search is used to find the required insertion points.
     * 
     * As of NumPy 1.4.0 `searchsorted` works with real/complex arrays containing
     * `nan` values. The enhanced sort order is documented in `sort`.
     * 
     * This function uses the same algorithm as the builtin python `bisect.bisect_left`
     * (``side='left'``) and `bisect.bisect_right` (``side='right'``) functions,
     * which is also vectorized in the `v` argument.
     * 
     * @param a 1-D array_like<br>
     *          Input array. If `sorter` is None, then it must be sorted in
     *          ascending order, otherwise `sorter` must be an array of indices
     *          that sort it.
     * @param v array_like<br>
     *          Values to insert into `a`.
     * @param side &#123;'left', 'right'&#125;, optional<br>
     *             If 'left', the index of the first suitable location found is given.
     *             If 'right', return the last such index.  If there is no suitable
     *             index, return either 0 or N (where N is the length of `a`).
     * @param sorter 1-D array_like, optional<br>
     *               Optional array of integer indices that sort array a into ascending
     *               order. They are typically the result of argsort.
     *               
     *               .. versionadded:: 1.7.0
     * 
     * @return indices array of ints<br>
     *                 Array of insertion points with the same shape as `v`.
     */
    public final Object searchsorted(Object a, Object v, Object... args) {
        write("np.searchsorted("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(v)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return an array drawn from elements in choicelist, depending on conditions.
     * 
     * @param condlist list of bool ndarrays<br>
     *                 The list of conditions which determine from which array in `choicelist`
     *                 the output elements are taken. When multiple conditions are satisfied,
     *                 the first one encountered in `condlist` is used.
     * @param choicelist list of ndarrays<br>
     *                   The list of arrays from which the output elements are taken. It has
     *                   to be of the same length as `condlist`.
     * @param default scalar, optional<br>
     *                The element inserted in `output` when all conditions evaluate to False.
     * 
     * @return output ndarray<br>
     *                The output at position m is the m-th element of the array in
     *                `choicelist` where the m-th element of the corresponding array in
     *                `condlist` is True.
     */
    public final Object select(Object condlist, Object choicelist, Object... args) {
        write("np.select("+PythonGrammar.toPythonArgs(condlist),PythonGrammar.toPythonArgs(choicelist)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set printing options.
     * 
     * These options determine the way floating point numbers, arrays and
     * other NumPy objects are displayed.
     * <p>
     * <em>Notes:</em><br>
     * `formatter` is always reset with a call to `set_printoptions`.
     * 
     * Use `printoptions` as a context manager to set the values temporarily.
     * 
     * @param precision int or None, optional<br>
     *                  Number of digits of precision for floating point output (default 8).
     *                  May be None if `floatmode` is not `fixed`, to print as many digits as
     *                  necessary to uniquely specify the value.
     * @param threshold int, optional<br>
     *                  Total number of array elements which trigger summarization
     *                  rather than full repr (default 1000).
     *                  To always use the full repr without summarization, pass `sys.maxsize`.
     * @param edgeitems int, optional<br>
     *                  Number of array items in summary at beginning and end of
     *                  each dimension (default 3).
     * @param linewidth int, optional<br>
     *                  The number of characters per line for the purpose of inserting
     *                  line breaks (default 75).
     * @param suppress bool, optional<br>
     *                 If True, always print floating point numbers using fixed point
     *                 notation, in which case numbers equal to zero in the current precision
     *                 will print as zero.  If False, then scientific notation is used when
     *                 absolute value of the smallest number is &lt; 1e-4 or the ratio of the
     *                 maximum absolute value to the minimum is &gt; 1e3. The default is False.
     * @param nanstr str, optional<br>
     *               String representation of floating point not-a-number (default nan).
     * @param infstr str, optional<br>
     *               String representation of floating point infinity (default inf).
     * @param sign string, either '-', '+', or ' ', optional<br>
     *             Controls printing of the sign of floating-point types. If '+', always
     *             print the sign of positive values. If ' ', always prints a space
     *             (whitespace character) in the sign position of positive values.  If
     *             '-', omit the sign character of positive values. (default '-')
     * @param formatter dict of callables, optional<br>
     *                  If not None, the keys should indicate the type(s) that the respective
     *                  formatting function applies to.  Callables should return a string.
     *                  Types that are not specified (by their corresponding keys) are handled
     *                  by the default formatters.  Individual types for which a formatter
     *                  can be set are:
     *                  
     *                  - 'bool'
     *                  - 'int'
     *                  - 'timedelta' : a `numpy.timedelta64`
     *                  - 'datetime' : a `numpy.datetime64`
     *                  - 'float'
     *                  - 'longfloat' : 128-bit floats
     *                  - 'complexfloat'
     *                  - 'longcomplexfloat' : composed of two 128-bit floats
     *                  - 'numpystr' : types `numpy.string_` and `numpy.unicode_`
     *                  - 'object' : `np.object_` arrays
     *                  
     *                  Other keys that can be used to set a group of types at once are:
     *                  
     *                  - 'all' : sets all types
     *                  - 'int_kind' : sets 'int'
     *                  - 'float_kind' : sets 'float' and 'longfloat'
     *                  - 'complex_kind' : sets 'complexfloat' and 'longcomplexfloat'
     *                  - 'str_kind' : sets 'numpystr'
     * @param floatmode str, optional<br>
     *                  Controls the interpretation of the `precision` option for
     *                  floating-point types. Can take the following values
     *                  (default maxprec_equal):
     *                  
     *                  * 'fixed': Always print exactly `precision` fractional digits,
     *                  even if this would print more or fewer digits than
     *                  necessary to specify the value uniquely.
     *                  * 'unique': Print the minimum number of fractional digits necessary
     *                  to represent each value uniquely. Different elements may
     *                  have a different number of digits. The value of the
     *                  `precision` option is ignored.
     *                  * 'maxprec': Print at most `precision` fractional digits, but if
     *                  an element can be uniquely represented with fewer digits
     *                  only print it with that many.
     *                  * 'maxprec_equal': Print at most `precision` fractional digits,
     *                  but if every element in the array can be uniquely
     *                  represented with an equal number of fewer digits, use that
     *                  many digits for all elements.
     * @param legacy string or `False`, optional<br>
     *               If set to the string `'1.13'` enables 1.13 legacy printing mode. This
     *               approximates numpy 1.13 print output by including a space in the sign
     *               position of floats and different behavior for 0d arrays. If set to
     *               `False`, disables legacy mode. Unrecognized strings will be ignored
     *               with a warning for forward compatibility.
     *               
     *               .. versionadded:: 1.14.0
     */
    public final Object set_printoptions(Object... args) {
        write("np.set_printoptions("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set a Python function to be used when pretty printing arrays.
     * 
     * @param f function or None<br>
     *          Function to be used to pretty print arrays. The function should expect
     *          a single array argument and return a string of the representation of
     *          the array. If None, the function is reset to the default NumPy function
     *          to print arrays.
     * @param repr bool, optional<br>
     *             If True (default), the function for pretty printing (``__repr__``)
     *             is set, if False the function that returns the default string
     *             representation (``__str__``) is set.
     */
    public final Object set_string_function(Object f, Object... args) {
        write("np.set_string_function("+PythonGrammar.toPythonArgs(f)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the size of the buffer used in ufuncs.
     * 
     * @param size int<br>
     *             Size of buffer.
     */
    public final Object setbufsize(Object size) {
        write("np.setbufsize("+PythonGrammar.toPythonArgs(size)+")");
        return null;
    }

    /**
     * Find the set difference of two arrays.
     * 
     * Return the unique values in `ar1` that are not in `ar2`.
     * 
     * @param ar1 array_like<br>
     *            Input array.
     * @param ar2 array_like<br>
     *            Input comparison array.
     * @param assume_unique bool<br>
     *                      If True, the input arrays are both assumed to be unique, which
     *                      can speed up the calculation.  Default is False.
     * 
     * @return setdiff1d ndarray<br>
     *                   1D array of values in `ar1` that are not in `ar2`. The result
     *                   is sorted when `assume_unique=False`, but otherwise only sorted
     *                   if the input is sorted.
     */
    public final Object setdiff1d(Object ar1, Object ar2, Object... args) {
        write("np.setdiff1d("+PythonGrammar.toPythonArgs(ar1),PythonGrammar.toPythonArgs(ar2)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set how floating-point errors are handled.
     * 
     * Note that operations on integer scalar types (such as `int16`) are
     * handled like floating point, and are affected by these settings.
     * <p>
     * <em>Notes:</em><br>
     * The floating-point exceptions are defined in the IEEE 754 standard [1]_:
     * 
     * - Division by zero: infinite result obtained from finite numbers.
     * - Overflow: result too large to be expressed.
     * - Underflow: result so close to zero that some precision
     * was lost.
     * - Invalid operation: result is not an expressible number, typically
     * indicates that a NaN was produced.
     * 
     * .. [1] https://en.wikipedia.org/wiki/IEEE_754
     * 
     * @param all &#123;'ignore', 'warn', 'raise', 'call', 'print', 'log'&#125;, optional<br>
     *            Set treatment for all types of floating-point errors at once:
     *            
     *            - ignore: Take no action when the exception occurs.
     *            - warn: Print a `RuntimeWarning` (via the Python `warnings` module).
     *            - raise: Raise a `FloatingPointError`.
     *            - call: Call a function specified using the `seterrcall` function.
     *            - print: Print a warning directly to ``stdout``.
     *            - log: Record error in a Log object specified by `seterrcall`.
     *            
     *            The default is not to change the current behavior.
     * @param divide &#123;'ignore', 'warn', 'raise', 'call', 'print', 'log'&#125;, optional<br>
     *               Treatment for division by zero.
     * @param over &#123;'ignore', 'warn', 'raise', 'call', 'print', 'log'&#125;, optional<br>
     *             Treatment for floating-point overflow.
     * @param under &#123;'ignore', 'warn', 'raise', 'call', 'print', 'log'&#125;, optional<br>
     *              Treatment for floating-point underflow.
     * @param invalid &#123;'ignore', 'warn', 'raise', 'call', 'print', 'log'&#125;, optional<br>
     *                Treatment for invalid floating-point operation.
     * 
     * @return old_settings dict<br>
     *                      Dictionary containing the old settings.
     */
    public final Object seterr(Object... args) {
        write("np.seterr("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the floating-point error callback function or log object.
     * 
     * There are two ways to capture floating-point error messages.  The first
     * is to set the error-handler to 'call', using `seterr`.  Then, set
     * the function to call using this function.
     * 
     * The second is to set the error-handler to 'log', using `seterr`.
     * Floating-point errors then trigger a call to the 'write' method of
     * the provided object.
     * 
     * @param func callable f(err, flag) or object with write method<br>
     *             Function to call upon floating-point errors ('call'-mode) or
     *             object whose 'write' method is used to log such message ('log'-mode).
     *             
     *             The call function takes two arguments. The first is a string describing
     *             the type of error (such as "divide by zero", "overflow", "underflow",
     *             or "invalid value"), and the second is the status flag.  The flag is a
     *             byte, whose four least-significant bits indicate the type of error, one
     *             of "divide", "over", "under", "invalid"::
     *             
     *             [0 0 0 0 divide over under invalid]
     *             
     *             In other words, ``flags = divide + 2*over + 4*under + 8*invalid``.
     *             
     *             If an object is provided, its write method should take one argument,
     *             a string.
     * 
     * @return h callable, log instance or None<br>
     *           The old error handler.
     */
    public final Object seterrcall(Object func) {
        write("np.seterrcall("+PythonGrammar.toPythonArgs(func)+")");
        return null;
    }

    /**
     * Find the set exclusive-or of two arrays.
     * 
     * Return the sorted, unique values that are in only one (not both) of the
     * input arrays.
     * 
     * @param ar1 array_like<br>
     *            Input arrays.
     * @param ar2 array_like<br>
     *            Input arrays.
     * @param assume_unique bool<br>
     *                      If True, the input arrays are both assumed to be unique, which
     *                      can speed up the calculation.  Default is False.
     * 
     * @return setxor1d ndarray<br>
     *                  Sorted 1D array of unique values that are in only one of the input
     *                  arrays.
     */
    public final Object setxor1d(Object ar1, Object ar2, Object... args) {
        write("np.setxor1d("+PythonGrammar.toPythonArgs(ar1),PythonGrammar.toPythonArgs(ar2)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the shape of an array.
     * 
     * @param a array_like<br>
     *          Input array.
     * 
     * @return shape tuple of ints<br>
     *               The elements of the shape tuple give the lengths of the
     *               corresponding array dimensions.
     */
    public final Object shape(Object a) {
        write("np.shape("+PythonGrammar.toPythonArgs(a)+")");
        return null;
    }

    /**
     * shares_memory(a, b, max_work=None)
     * 
     * Determine if two arrays share memory.
     * 
     * .. warning::
     * 
     * This function can be exponentially slow for some inputs, unless
     * `max_work` is set to a finite number or ``MAY_SHARE_BOUNDS``.
     * If in doubt, use `numpy.may_share_memory` instead.
     * 
     * @param a ndarray<br>
     *          Input arrays
     * @param b ndarray<br>
     *          Input arrays
     * @param max_work int, optional<br>
     *                 Effort to spend on solving the overlap problem (maximum number
     *                 of candidate solutions to consider). The following special
     *                 values are recognized:
     *                 
     *                 max_work=MAY_SHARE_EXACT  (default)
     *                 The problem is solved exactly. In this case, the function returns
     *                 True only if there is an element shared between the arrays. Finding
     *                 the exact solution may take extremely long in some cases.
     *                 max_work=MAY_SHARE_BOUNDS
     *                 Only the memory bounds of a and b are checked.
     * @param ... n/a<br>undocumented
     * 
     * @return out bool<br>
     */
    public final Object shares_memory(Object... args) {
        write("np.shares_memory("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Show libraries in the system on which NumPy was built.
     * 
     * Print information about various resources (libraries, library
     * directories, include directories, etc.) in the system on which
     * NumPy was built.
     * <p>
     * <em>Notes:</em><br>
     * Classes specifying the information to be printed are defined
     * in the `numpy.distutils.system_info` module.
     * 
     * Information may include:
     * 
     * * ``language``: language used to write the libraries (mostly
     * C or f77)
     * * ``libraries``: names of libraries found in the system
     * * ``library_dirs``: directories containing the libraries
     * * ``include_dirs``: directories containing library header files
     * * ``src_dirs``: directories containing library source files
     * * ``define_macros``: preprocessor macros used by
     * ``distutils.setup``
     * 
     * 
     * Note that the method name deviates from the description (which is for {@link #show}). This is most likely due to show_config being an alias for show.
     */
    public final Object show_config() {
        write("np.show_config()");
        return null;
    }

    /**
     * Return the normalized sinc function.
     * 
     * The sinc function is :math:`\sin(\pi x)/(\pi x)`.
     * 
     * .. note::
     * 
     * Note the normalization factor of ``pi`` used in the definition.
     * This is the most commonly used definition in signal processing.
     * Use ``sinc(x / np.pi)`` to obtain the unnormalized sinc function
     * :math:`\sin(x)/(x)` that is more common in mathematics.
     * <p>
     * <em>Notes:</em><br>
     * ``sinc(0)`` is the limit value 1.
     * 
     * The name sinc is short for "sine cardinal" or "sinus cardinalis".
     * 
     * The sinc function is used in various signal processing applications,
     * including in anti-aliasing, in the construction of a Lanczos resampling
     * filter, and in interpolation.
     * 
     * For bandlimited interpolation of discrete-time signals, the ideal
     * interpolation kernel is proportional to the sinc function.
     * 
     * @param x ndarray<br>
     *          Array (possibly multi-dimensional) of values for which to to
     *          calculate ``sinc(x)``.
     * 
     * @return out ndarray<br>
     *             ``sinc(x)``, which has the same shape as the input.
     */
    public final Object sinc(Object x) {
        write("np.sinc("+PythonGrammar.toPythonArgs(x)+")");
        return null;
    }

    /**
     * Return the number of elements along a given axis.
     * 
     * @param a array_like<br>
     *          Input data.
     * @param axis int, optional<br>
     *             Axis along which the elements are counted.  By default, give
     *             the total number of elements.
     * 
     * @return element_count int<br>
     *                       Number of elements along the specified axis.
     */
    public final Object size(Object a, Object... args) {
        write("np.size("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Check whether some values are true.
     * 
     * Refer to `any` for full documentation.
     * 
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     */
    public final Object sometrue(Object... args) {
        write("np.sometrue("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return a sorted copy of an array.
     * <p>
     * <em>Notes:</em><br>
     * The various sorting algorithms are characterized by their average speed,
     * worst case performance, work space size, and whether they are stable. A
     * stable sort keeps items with the same key in the same relative
     * order. The four algorithms implemented in NumPy have the following
     * properties:
     * 
     * =========== ======= ============= ============ ========
     * kind      speed   worst case    work space   stable
     * =========== ======= ============= ============ ========
     * 'quicksort'    1     O(n^2)            0          no
     * 'heapsort'     3     O(n*log(n))       0          no
     * 'mergesort'    2     O(n*log(n))      ~n/2        yes
     * 'timsort'      2     O(n*log(n))      ~n/2        yes
     * =========== ======= ============= ============ ========
     * 
     * .. note:: The datatype determines which of 'mergesort' or 'timsort'
     * is actually used, even if 'mergesort' is specified. User selection
     * at a finer scale is not currently available.
     * 
     * All the sort algorithms make temporary copies of the data when
     * sorting along any but the last axis.  Consequently, sorting along
     * the last axis is faster and uses less space than sorting along
     * any other axis.
     * 
     * The sort order for complex numbers is lexicographic. If both the real
     * and imaginary parts are non-nan then the order is determined by the
     * real parts except when they are equal, in which case the order is
     * determined by the imaginary parts.
     * 
     * Previous to numpy 1.4.0 sorting real and complex arrays containing nan
     * values led to undefined behaviour. In numpy versions >= 1.4.0 nan
     * values are sorted to the end. The extended sort order is:
     * 
     * * Real: [R, nan]
     * * Complex: [R + Rj, R + nanj, nan + Rj, nan + nanj]
     * 
     * where R is a non-nan real value. Complex values with the same nan
     * placements are sorted according to the non-nan part if it exists.
     * Non-nan values are sorted as before.
     * 
     * .. versionadded:: 1.12.0
     * 
     * quicksort has been changed to `introsort <https://en.wikipedia.org/wiki/Introsort>`_.
     * When sorting does not make enough progress it switches to
     * `heapsort <https://en.wikipedia.org/wiki/Heapsort>`_.
     * This implementation makes quicksort O(n*log(n)) in the worst case.
     * 
     * 'stable' automatically chooses the best stable sorting algorithm
     * for the data type being sorted.
     * It, along with 'mergesort' is currently mapped to
     * `timsort <https://en.wikipedia.org/wiki/Timsort>`_
     * or `radix sort <https://en.wikipedia.org/wiki/Radix_sort>`_
     * depending on the data type.
     * API forward compatibility currently limits the
     * ability to select the implementation and it is hardwired for the different
     * data types.
     * 
     * .. versionadded:: 1.17.0
     * 
     * Timsort is added for better performance on already or nearly
     * sorted data. On random data timsort is almost identical to
     * mergesort. It is now used for stable sort while quicksort is still the
     * default sort if none is chosen. For timsort details, refer to
     * `CPython listsort.txt <https://github.com/python/cpython/blob/3.7/Objects/listsort.txt>`_.
     * 'mergesort' and 'stable' are mapped to radix sort for integer data types. Radix sort is an
     * O(n) sort instead of O(n log n).
     * 
     * .. versionchanged:: 1.18.0
     * 
     * NaT now sorts to the end of arrays for consistency with NaN.
     * 
     * @param a array_like<br>
     *          Array to be sorted.
     * @param axis int or None, optional<br>
     *             Axis along which to sort. If None, the array is flattened before
     *             sorting. The default is -1, which sorts along the last axis.
     * @param kind &#123;'quicksort', 'mergesort', 'heapsort', 'stable'&#125;, optional<br>
     *             Sorting algorithm. The default is 'quicksort'. Note that both 'stable'
     *             and 'mergesort' use timsort or radix sort under the covers and, in general,
     *             the actual implementation will vary with data type. The 'mergesort' option
     *             is retained for backwards compatibility.
     *             
     *             .. versionchanged:: 1.15.0.
     *             The 'stable' option was added.
     *             
     * @param order str or list of str, optional<br>
     *              When `a` is an array with fields defined, this argument specifies
     *              which fields to compare first, second, etc.  A single field can
     *              be specified as a string, and not all fields need be specified,
     *              but unspecified fields will still be used, in the order in which
     *              they come up in the dtype, to break ties.
     * 
     * @return sorted_array ndarray<br>
     *                      Array of the same type and shape as `a`.
     */
    public final Object sort(Object a, Object... args) {
        write("np.sort("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Sort a complex array using the real part first, then the imaginary part.
     * 
     * @param a array_like<br>
     *          Input array
     * 
     * @return out complex ndarray<br>
     *             Always returns a sorted complex array.
     */
    public final Object sort_complex(Object a) {
        write("np.sort_complex("+PythonGrammar.toPythonArgs(a)+")");
        return null;
    }

    /**
     * Print or write to a file the source code for a NumPy object.
     * 
     * The source code is only returned for objects written in Python. Many
     * functions and classes are defined in C and will therefore not return
     * useful information.
     * 
     * @param object numpy object<br>
     *               Input object. This can be any object (function, class, module,
     *               ...).
     * @param output file object, optional<br>
     *               If `output` not supplied then source code is printed to screen
     *               (sys.stdout).  File object must be created with either write 'w' or
     *               append 'a' modes.
     */
    public final Object source(Object object, Object... args) {
        write("np.source("+PythonGrammar.toPythonArgs(object)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Split an array into multiple sub-arrays as views into `ary`.
     * 
     * @param ary ndarray<br>
     *            Array to be divided into sub-arrays.
     * @param indices_or_sections int or 1-D array<br>
     *                            If `indices_or_sections` is an integer, N, the array will be divided
     *                            into N equal arrays along `axis`.  If such a split is not possible,
     *                            an error is raised.
     *                            
     *                            If `indices_or_sections` is a 1-D array of sorted integers, the entries
     *                            indicate where along `axis` the array is split.  For example,
     *                            ``[2, 3]`` would, for ``axis=0``, result in
     *                            
     *                            - ary[:2]
     *                            - ary[2:3]
     *                            - ary[3:]
     *                            
     *                            If an index exceeds the dimension of the array along `axis`,
     *                            an empty sub-array is returned correspondingly.
     * @param axis int, optional<br>
     *             The axis along which to split, default is 0.
     * 
     * @return sub-arrays list of ndarrays<br>
     *                    A list of sub-arrays as views into `ary`.
     */
    public final Object split(Object ary, Object indices_or_sections, Object... args) {
        write("np.split("+PythonGrammar.toPythonArgs(ary),PythonGrammar.toPythonArgs(indices_or_sections)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Remove axes of length one from `a`.
     * 
     * @param a array_like<br>
     *          Input data.
     * @param axis None or int or tuple of ints, optional<br>
     *             .. versionadded:: 1.7.0
     *             
     *             Selects a subset of the entries of length one in the
     *             shape. If an axis is selected with shape entry greater than
     *             one, an error is raised.
     * 
     * @return squeezed ndarray<br>
     *                  The input array, but with all or a subset of the
     *                  dimensions of length 1 removed. This is always `a` itself
     *                  or a view into `a`. Note that if all axes are squeezed,
     *                  the result is a 0d array and not a scalar.
     */
    public final Object squeeze(Object a, Object... args) {
        write("np.squeeze("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Join a sequence of arrays along a new axis.
     * 
     * The ``axis`` parameter specifies the index of the new axis in the
     * dimensions of the result. For example, if ``axis=0`` it will be the first
     * dimension and if ``axis=-1`` it will be the last dimension.
     * 
     * .. versionadded:: 1.10.0
     * 
     * @param arrays sequence of array_like<br>
     *               Each array must have the same shape.
     *               
     * @param axis int, optional<br>
     *             The axis in the result array along which the input arrays are stacked.
     *             
     * @param out ndarray, optional<br>
     *            If provided, the destination to place the result. The shape must be
     *            correct, matching that of what stack would have returned if no
     *            out argument were specified.
     * 
     * @return stacked ndarray<br>
     *                 The stacked array has one more dimension than the input arrays.
     */
    public final Object stack(Object arrays, Object... args) {
        write("np.stack("+PythonGrammar.toPythonArgs(arrays)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Compute the standard deviation along the specified axis.
     * 
     * Returns the standard deviation, a measure of the spread of a distribution,
     * of the array elements. The standard deviation is computed for the
     * flattened array by default, otherwise over the specified axis.
     * <p>
     * <em>Notes:</em><br>
     * The standard deviation is the square root of the average of the squared
     * deviations from the mean, i.e., ``std = sqrt(mean(x))``, where
     * ``x = abs(a - a.mean())**2``.
     * 
     * The average squared deviation is typically calculated as ``x.sum() / N``,
     * where ``N = len(x)``. If, however, `ddof` is specified, the divisor
     * ``N - ddof`` is used instead. In standard statistical practice, ``ddof=1``
     * provides an unbiased estimator of the variance of the infinite population.
     * ``ddof=0`` provides a maximum likelihood estimate of the variance for
     * normally distributed variables. The standard deviation computed in this
     * function is the square root of the estimated variance, so even with
     * ``ddof=1``, it will not be an unbiased estimate of the standard deviation
     * per se.
     * 
     * Note that, for complex numbers, `std` takes the absolute
     * value before squaring, so that the result is always real and nonnegative.
     * 
     * For floating-point input, the *std* is computed using the same
     * precision the input has. Depending on the input data, this can cause
     * the results to be inaccurate, especially for float32 (see example below).
     * Specifying a higher-accuracy accumulator using the `dtype` keyword can
     * alleviate this issue.
     * 
     * @param a array_like<br>
     *          Calculate the standard deviation of these values.
     * @param axis None or int or tuple of ints, optional<br>
     *             Axis or axes along which the standard deviation is computed. The
     *             default is to compute the standard deviation of the flattened array.
     *             
     *             .. versionadded:: 1.7.0
     *             
     *             If this is a tuple of ints, a standard deviation is performed over
     *             multiple axes, instead of a single axis or all the axes as before.
     * @param dtype dtype, optional<br>
     *              Type to use in computing the standard deviation. For arrays of
     *              integer type the default is float64, for arrays of float types it is
     *              the same as the array type.
     * @param out ndarray, optional<br>
     *            Alternative output array in which to place the result. It must have
     *            the same shape as the expected output but the type (of the calculated
     *            values) will be cast if necessary.
     * @param ddof int, optional<br>
     *             Means Delta Degrees of Freedom.  The divisor used in calculations
     *             is ``N - ddof``, where ``N`` represents the number of elements.
     *             By default `ddof` is zero.
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left
     *                 in the result as dimensions with size one. With this option,
     *                 the result will broadcast correctly against the input array.
     *                 
     *                 If the default value is passed, then `keepdims` will not be
     *                 passed through to the `std` method of sub-classes of
     *                 `ndarray`, however any non-default value will be.  If the
     *                 sub-class' method does not implement `keepdims` any
     *                 exceptions will be raised.
     *                 
     * @param where array_like of bool, optional<br>
     *              Elements to include in the standard deviation.
     *              See `~numpy.ufunc.reduce` for details.
     *              
     *              .. versionadded:: 1.20.0
     * 
     * @return standard_deviation ndarray, see dtype parameter above.<br>
     *                            If `out` is None, return a new array containing the standard deviation,
     *                            otherwise return a reference to the output array.
     */
    public final Object std(Object a, Object... args) {
        write("np.std("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Sum of array elements over a given axis.
     * <p>
     * <em>Notes:</em><br>
     * Arithmetic is modular when using integer types, and no error is
     * raised on overflow.
     * 
     * The sum of an empty array is the neutral element 0:
     * 
     * >>> np.sum([])
     * 0.0
     * 
     * For floating point numbers the numerical precision of sum (and
     * ``np.add.reduce``) is in general limited by directly adding each number
     * individually to the result causing rounding errors in every step.
     * However, often numpy will use a  numerically better approach (partial
     * pairwise summation) leading to improved precision in many use-cases.
     * This improved precision is always provided when no ``axis`` is given.
     * When ``axis`` is given, it will depend on which axis is summed.
     * Technically, to provide the best speed possible, the improved precision
     * is only used when the summation is along the fast axis in memory.
     * Note that the exact precision may vary depending on other parameters.
     * In contrast to NumPy, Python's ``math.fsum`` function uses a slower but
     * more precise approach to summation.
     * Especially when summing a large number of lower precision floating point
     * numbers, such as ``float32``, numerical errors can become significant.
     * In such cases it can be advisable to use `dtype="float64"` to use a higher
     * precision for the output.
     * 
     * @param a array_like<br>
     *          Elements to sum.
     * @param axis None or int or tuple of ints, optional<br>
     *             Axis or axes along which a sum is performed.  The default,
     *             axis=None, will sum all of the elements of the input array.  If
     *             axis is negative it counts from the last to the first axis.
     *             
     *             .. versionadded:: 1.7.0
     *             
     *             If axis is a tuple of ints, a sum is performed on all of the axes
     *             specified in the tuple instead of a single axis or all the axes as
     *             before.
     * @param dtype dtype, optional<br>
     *              The type of the returned array and of the accumulator in which the
     *              elements are summed.  The dtype of `a` is used by default unless `a`
     *              has an integer dtype of less precision than the default platform
     *              integer.  In that case, if `a` is signed then the platform integer
     *              is used while if `a` is unsigned then an unsigned integer of the
     *              same precision as the platform integer is used.
     * @param out ndarray, optional<br>
     *            Alternative output array in which to place the result. It must have
     *            the same shape as the expected output, but the type of the output
     *            values will be cast if necessary.
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left
     *                 in the result as dimensions with size one. With this option,
     *                 the result will broadcast correctly against the input array.
     *                 
     *                 If the default value is passed, then `keepdims` will not be
     *                 passed through to the `sum` method of sub-classes of
     *                 `ndarray`, however any non-default value will be.  If the
     *                 sub-class' method does not implement `keepdims` any
     *                 exceptions will be raised.
     * @param initial scalar, optional<br>
     *                Starting value for the sum. See `~numpy.ufunc.reduce` for details.
     *                
     *                .. versionadded:: 1.15.0
     *                
     * @param where array_like of bool, optional<br>
     *              Elements to include in the sum. See `~numpy.ufunc.reduce` for details.
     *              
     *              .. versionadded:: 1.17.0
     * 
     * @return sum_along_axis ndarray<br>
     *                        An array with the same shape as `a`, with the specified
     *                        axis removed.   If `a` is a 0-d array, or if `axis` is None, a scalar
     *                        is returned.  If an output array is specified, a reference to
     *                        `out` is returned.
     */
    public final Object sum(Object a, Object... args) {
        write("np.sum("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Interchange two axes of an array.
     * 
     * @param a array_like<br>
     *          Input array.
     * @param axis1 int<br>
     *              First axis.
     * @param axis2 int<br>
     *              Second axis.
     * 
     * @return a_swapped ndarray<br>
     *                   For NumPy &gt;= 1.10.0, if `a` is an ndarray, then a view of `a` is
     *                   returned; otherwise a new array is created. For earlier NumPy
     *                   versions a view of `a` is returned only if the order of the
     *                   axes is changed, otherwise the input array is returned.
     */
    public final Object swapaxes(Object a, Object axis1, Object axis2) {
        write("np.swapaxes("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(axis1),PythonGrammar.toPythonArgs(axis2)+")");
        return null;
    }

    /**
     * Take elements from an array along an axis.
     * 
     * When axis is not None, this function does the same thing as "fancy"
     * indexing (indexing arrays using arrays); however, it can be easier to use
     * if you need elements along a given axis. A call such as
     * ``np.take(arr, indices, axis=3)`` is equivalent to
     * ``arr[:,:,:,indices,...]``.
     * 
     * Explained without fancy indexing, this is equivalent to the following use
     * of `ndindex`, which sets each of ``ii``, ``jj``, and ``kk`` to a tuple of
     * indices::
     * 
     * Ni, Nk = a.shape[:axis], a.shape[axis+1:]
     * Nj = indices.shape
     * for ii in ndindex(Ni):
     * for jj in ndindex(Nj):
     * for kk in ndindex(Nk):
     * out[ii + jj + kk] = a[ii + (indices[jj],) + kk]
     * <p>
     * <em>Notes:</em><br>
     * By eliminating the inner loop in the description above, and using `s_` to
     * build simple slice objects, `take` can be expressed  in terms of applying
     * fancy indexing to each 1-d slice::
     * 
     * Ni, Nk = a.shape[:axis], a.shape[axis+1:]
     * for ii in ndindex(Ni):
     * for kk in ndindex(Nj):
     * out[ii + s_[...,] + kk] = a[ii + s_[:,] + kk][indices]
     * 
     * For this reason, it is equivalent to (but faster than) the following use
     * of `apply_along_axis`::
     * 
     * out = np.apply_along_axis(lambda a_1d: a_1d[indices], axis, a)
     * 
     * @param a array_like (Ni..., M, Nk...)<br>
     *          The source array.
     * @param indices array_like (Nj...)<br>
     *                The indices of the values to extract.
     *                
     *                .. versionadded:: 1.8.0
     *                
     *                Also allow scalars for indices.
     * @param axis int, optional<br>
     *             The axis over which to select values. By default, the flattened
     *             input array is used.
     * @param out ndarray, optional (Ni..., Nj..., Nk...)<br>
     *            If provided, the result will be placed in this array. It should
     *            be of the appropriate shape and dtype. Note that `out` is always
     *            buffered if `mode='raise'`; use other modes for better performance.
     * @param mode &#123;'raise', 'wrap', 'clip'&#125;, optional<br>
     *             Specifies how out-of-bounds indices will behave.
     *             
     *             * 'raise' -- raise an error (default)
     *             * 'wrap' -- wrap around
     *             * 'clip' -- clip to the range
     *             
     *             'clip' mode means that all indices that are too large are replaced
     *             by the index that addresses the last element along that axis. Note
     *             that this disables indexing with negative numbers.
     * 
     * @return out ndarray (Ni..., Nj..., Nk...)<br>
     *             The returned array has the same type as `a`.
     */
    public final Object take(Object a, Object indices, Object... args) {
        write("np.take("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(indices)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Take values from the input array by matching 1d index and data slices.
     * 
     * This iterates over matching 1d slices oriented along the specified axis in
     * the index and data arrays, and uses the former to look up values in the
     * latter. These slices can be different lengths.
     * 
     * Functions returning an index along an axis, like `argsort` and
     * `argpartition`, produce suitable indices for this function.
     * 
     * .. versionadded:: 1.15.0
     * <p>
     * <em>Notes:</em><br>
     * This is equivalent to (but faster than) the following use of `ndindex` and
     * `s_`, which sets each of ``ii`` and ``kk`` to a tuple of indices::
     * 
     * Ni, M, Nk = a.shape[:axis], a.shape[axis], a.shape[axis+1:]
     * J = indices.shape[axis]  # Need not equal M
     * out = np.empty(Ni + (J,) + Nk)
     * 
     * for ii in ndindex(Ni):
     * for kk in ndindex(Nk):
     * a_1d       = a      [ii + s_[:,] + kk]
     * indices_1d = indices[ii + s_[:,] + kk]
     * out_1d     = out    [ii + s_[:,] + kk]
     * for j in range(J):
     * out_1d[j] = a_1d[indices_1d[j]]
     * 
     * Equivalently, eliminating the inner loop, the last two lines would be::
     * 
     * out_1d[:] = a_1d[indices_1d]
     * 
     * @param arr ndarray (Ni..., M, Nk...)<br>
     *            Source array
     * @param indices ndarray (Ni..., J, Nk...)<br>
     *                Indices to take along each 1d slice of `arr`. This must match the
     *                dimension of arr, but dimensions Ni and Nj only need to broadcast
     *                against `arr`.
     * @param axis int<br>
     *             The axis to take 1d slices along. If axis is None, the input array is
     *             treated as if it had first been flattened to 1d, for consistency with
     *             `sort` and `argsort`.
     * 
     * @return out ndarray (Ni..., J, Nk...)<br>
     *             The indexed result.
     */
    public final Object take_along_axis(Object arr, Object indices, Object axis) {
        write("np.take_along_axis("+PythonGrammar.toPythonArgs(arr),PythonGrammar.toPythonArgs(indices),PythonGrammar.toPythonArgs(axis)+")");
        return null;
    }

    /**
     * Compute tensor dot product along specified axes.
     * 
     * Given two tensors, `a` and `b`, and an array_like object containing
     * two array_like objects, ``(a_axes, b_axes)``, sum the products of
     * `a`'s and `b`'s elements (components) over the axes specified by
     * ``a_axes`` and ``b_axes``. The third argument can be a single non-negative
     * integer_like scalar, ``N``; if it is such, then the last ``N`` dimensions
     * of `a` and the first ``N`` dimensions of `b` are summed over.
     * <p>
     * <em>Notes:</em><br>
     * Three common use cases are:
     * * ``axes = 0`` : tensor product :math:`a\otimes b`
     * * ``axes = 1`` : tensor dot product :math:`a\cdot b`
     * * ``axes = 2`` : (default) tensor double contraction :math:`a:b`
     * 
     * When `axes` is integer_like, the sequence for evaluation will be: first
     * the -Nth axis in `a` and 0th axis in `b`, and the -1th axis in `a` and
     * Nth axis in `b` last.
     * 
     * When there is more than one axis to sum over - and they are not the last
     * (first) axes of `a` (`b`) - the argument `axes` should consist of
     * two sequences of the same length, with the first axis to sum over given
     * first in both sequences, the second axis second, and so forth.
     * 
     * The shape of the result consists of the non-contracted axes of the
     * first tensor, followed by the non-contracted axes of the second.
     * 
     * @param a array_like<br>
     *          Tensors to "dot".
     *          
     * @param b array_like<br>
     *          Tensors to "dot".
     *          
     * @param axes int or (2,) array_like<br>
     *             * integer_like
     *             If an int N, sum over the last N axes of `a` and the first N axes
     *             of `b` in order. The sizes of the corresponding axes must match.
     *             * (2,) array_like
     *             Or, a list of axes to be summed over, first sequence applying to `a`,
     *             second to `b`. Both elements array_like must be of the same length.
     * 
     * @return output ndarray<br>
     *                The tensor dot product of the input.
     */
    public final Object tensordot(Object a, Object b, Object... args) {
        write("np.tensordot("+PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(b)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Construct an array by repeating A the number of times given by reps.
     * 
     * If `reps` has length ``d``, the result will have dimension of
     * ``max(d, A.ndim)``.
     * 
     * If ``A.ndim < d``, `A` is promoted to be d-dimensional by prepending new
     * axes. So a shape (3,) array is promoted to (1, 3) for 2-D replication,
     * or shape (1, 1, 3) for 3-D replication. If this is not the desired
     * behavior, promote `A` to d-dimensions manually before calling this
     * function.
     * 
     * If ``A.ndim > d``, `reps` is promoted to `A`.ndim by pre-pending 1's to it.
     * Thus for an `A` of shape (2, 3, 4, 5), a `reps` of (2, 2) is treated as
     * (1, 1, 2, 2).
     * 
     * Note : Although tile may be used for broadcasting, it is strongly
     * recommended to use numpy's broadcasting operations and functions.
     * 
     * @param A array_like<br>
     *          The input array.
     * @param reps array_like<br>
     *             The number of repetitions of `A` along each axis.
     * 
     * @return c ndarray<br>
     *           The tiled output array.
     */
    public final Object tile(Object A, Object reps) {
        write("np.tile("+PythonGrammar.toPythonArgs(A),PythonGrammar.toPythonArgs(reps)+")");
        return null;
    }

    /**
     * Return the sum along diagonals of the array.
     * 
     * If `a` is 2-D, the sum along its diagonal with the given offset
     * is returned, i.e., the sum of elements ``a[i,i+offset]`` for all i.
     * 
     * If `a` has more than two dimensions, then the axes specified by axis1 and
     * axis2 are used to determine the 2-D sub-arrays whose traces are returned.
     * The shape of the resulting array is the same as that of `a` with `axis1`
     * and `axis2` removed.
     * 
     * @param a array_like<br>
     *          Input array, from which the diagonals are taken.
     * @param offset int, optional<br>
     *               Offset of the diagonal from the main diagonal. Can be both positive
     *               and negative. Defaults to 0.
     * @param axis1 int, optional<br>
     *              Axes to be used as the first and second axis of the 2-D sub-arrays
     *              from which the diagonals should be taken. Defaults are the first two
     *              axes of `a`.
     * @param axis2 int, optional<br>
     *              Axes to be used as the first and second axis of the 2-D sub-arrays
     *              from which the diagonals should be taken. Defaults are the first two
     *              axes of `a`.
     * @param dtype dtype, optional<br>
     *              Determines the data-type of the returned array and of the accumulator
     *              where the elements are summed. If dtype has the value None and `a` is
     *              of integer type of precision less than the default integer
     *              precision, then the default integer precision is used. Otherwise,
     *              the precision is the same as that of `a`.
     * @param out ndarray, optional<br>
     *            Array into which the output is placed. Its type is preserved and
     *            it must be of the right shape to hold the output.
     * 
     * @return sum_along_diagonals ndarray<br>
     *                             If `a` is 2-D, the sum along the diagonal is returned.  If `a` has
     *                             larger dimensions, then an array of sums along diagonals is returned.
     */
    public final Object trace(Object a, Object... args) {
        write("np.trace("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Reverse or permute the axes of an array; returns the modified array.
     * 
     * For an array a with two axes, transpose(a) gives the matrix transpose.
     * 
     * Refer to `numpy.ndarray.transpose` for full documentation.
     * <p>
     * <em>Notes:</em><br>
     * Use `transpose(a, argsort(axes))` to invert the transposition of tensors
     * when using the `axes` keyword argument.
     * 
     * Transposing a 1-D array returns an unchanged view of the original array.
     * 
     * @param a array_like<br>
     *          Input array.
     * @param axes tuple or list of ints, optional<br>
     *             If specified, it must be a tuple or list which contains a permutation of
     *             [0,1,..,N-1] where N is the number of axes of a.  The i'th axis of the
     *             returned array will correspond to the axis numbered ``axes[i]`` of the
     *             input.  If not specified, defaults to ``range(a.ndim)[::-1]``, which
     *             reverses the order of the axes.
     * 
     * @return p ndarray<br>
     *           `a` with its axes permuted.  A view is returned whenever
     *           possible.
     */
    public final Object transpose(Object a, Object... args) {
        write("np.transpose("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Integrate along the given axis using the composite trapezoidal rule.
     * 
     * If `x` is provided, the integration happens in sequence along its
     * elements - they are not sorted.
     * 
     * Integrate `y` (`x`) along each 1d slice on the given axis, compute
     * :math:`\int y(x) dx`.
     * When `x` is specified, this integrates along the parametric curve,
     * computing :math:`\int_t y(t) dt =
     * \int_t y(t) \left.\frac{dx}{dt}\right|_{x=x(t)} dt`.
     * <p>
     * <em>Notes:</em><br>
     * Image [2]_ illustrates trapezoidal rule -- y-axis locations of points
     * will be taken from `y` array, by default x-axis distances between
     * points will be 1.0, alternatively they can be provided with `x` array
     * or with `dx` scalar.  Return value will be equal to combined area under
     * the red lines.
     * 
     * @param y array_like<br>
     *          Input array to integrate.
     * @param x array_like, optional<br>
     *          The sample points corresponding to the `y` values. If `x` is None,
     *          the sample points are assumed to be evenly spaced `dx` apart. The
     *          default is None.
     * @param dx scalar, optional<br>
     *           The spacing between sample points when `x` is None. The default is 1.
     * @param axis int, optional<br>
     *             The axis along which to integrate.
     * 
     * @return trapz float or ndarray<br>
     *               Definite integral of 'y' = n-dimensional array as approximated along
     *               a single axis by the trapezoidal rule. If 'y' is a 1-dimensional array,
     *               then the result is a float. If 'n' is greater than 1, then the result
     *               is an 'n-1' dimensional array.
     */
    public final Object trapz(Object y, Object... args) {
        write("np.trapz("+PythonGrammar.toPythonArgs(y)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * An array with ones at and below the given diagonal and zeros elsewhere.
     * 
     * @param N int<br>
     *          Number of rows in the array.
     * @param M int, optional<br>
     *          Number of columns in the array.
     *          By default, `M` is taken equal to `N`.
     * @param k int, optional<br>
     *          The sub-diagonal at and below which the array is filled.
     *          `k` = 0 is the main diagonal, while `k` &lt; 0 is below it,
     *          and `k` &gt; 0 is above.  The default is 0.
     * @param dtype dtype, optional<br>
     *              Data type of the returned array.  The default is float.
     * @param like array_like<br>
     *             Reference object to allow the creation of arrays which are not
     *             NumPy arrays. If an array-like passed in as ``like`` supports
     *             the ``__array_function__`` protocol, the result will be defined
     *             by it. In this case, it ensures the creation of an array object
     *             compatible with that passed in via this argument.
     *             
     *             .. versionadded:: 1.20.0
     * 
     * @return tri ndarray of shape (N, M)<br>
     *             Array with its lower triangle filled with ones and zero elsewhere;
     *             in other words ``T[i,j] == 1`` for ``j &lt;= i + k``, 0 otherwise.
     */
    public final Object tri(Object N, Object... args) {
        write("np.tri("+PythonGrammar.toPythonArgs(N)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Lower triangle of an array.
     * 
     * Return a copy of an array with elements above the `k`-th diagonal zeroed.
     * 
     * @param m array_like, shape (M, N)<br>
     *          Input array.
     * @param k int, optional<br>
     *          Diagonal above which to zero elements.  `k = 0` (the default) is the
     *          main diagonal, `k &lt; 0` is below it and `k &gt; 0` is above.
     * 
     * @return tril ndarray, shape (M, N)<br>
     *              Lower triangle of `m`, of same shape and data-type as `m`.
     */
    public final Object tril(Object m, Object... args) {
        write("np.tril("+PythonGrammar.toPythonArgs(m)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the indices for the lower-triangle of an (n, m) array.
     * <p>
     * <em>Notes:</em><br>
     * .. versionadded:: 1.4.0
     * 
     * @param n int<br>
     *          The row dimension of the arrays for which the returned
     *          indices will be valid.
     * @param k int, optional<br>
     *          Diagonal offset (see `tril` for details).
     * @param m int, optional<br>
     *          .. versionadded:: 1.9.0
     *          
     *          The column dimension of the arrays for which the returned
     *          arrays will be valid.
     *          By default `m` is taken equal to `n`.
     * 
     * @return inds tuple of arrays<br>
     *              The indices for the triangle. The returned tuple contains two arrays,
     *              each with the indices along one dimension of the array.
     */
    public final Object tril_indices(Object n, Object... args) {
        write("np.tril_indices("+PythonGrammar.toPythonArgs(n)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the indices for the lower-triangle of arr.
     * 
     * See `tril_indices` for full details.
     * <p>
     * <em>Notes:</em><br>
     * .. versionadded:: 1.4.0
     * 
     * @param arr array_like<br>
     *            The indices will be valid for square arrays whose dimensions are
     *            the same as arr.
     * @param k int, optional<br>
     *          Diagonal offset (see `tril` for details).
     */
    public final Object tril_indices_from(Object arr, Object... args) {
        write("np.tril_indices_from("+PythonGrammar.toPythonArgs(arr)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Trim the leading and/or trailing zeros from a 1-D array or sequence.
     * 
     * @param filt 1-D array or sequence<br>
     *             Input array.
     * @param trim str, optional<br>
     *             A string with 'f' representing trim from front and 'b' to trim from
     *             back. Default is 'fb', trim zeros from both front and back of the
     *             array.
     * 
     * @return trimmed 1-D array or sequence<br>
     *                 The result of trimming the input. The input data type is preserved.
     */
    public final Object trim_zeros(Object filt, Object... args) {
        write("np.trim_zeros("+PythonGrammar.toPythonArgs(filt)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Upper triangle of an array.
     * 
     * Return a copy of an array with the elements below the `k`-th diagonal
     * zeroed.
     * 
     * Please refer to the documentation for `tril` for further details.
     * 
     * @param m n/a<br>undocumented
     * @param k n/a<br>undocumented
     */
    public final Object triu(Object... args) {
        write("np.triu("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the indices for the upper-triangle of an (n, m) array.
     * <p>
     * <em>Notes:</em><br>
     * .. versionadded:: 1.4.0
     * 
     * @param n int<br>
     *          The size of the arrays for which the returned indices will
     *          be valid.
     * @param k int, optional<br>
     *          Diagonal offset (see `triu` for details).
     * @param m int, optional<br>
     *          .. versionadded:: 1.9.0
     *          
     *          The column dimension of the arrays for which the returned
     *          arrays will be valid.
     *          By default `m` is taken equal to `n`.
     * 
     * @return inds tuple, shape(2) of ndarrays, shape(`n`)<br>
     *              The indices for the triangle. The returned tuple contains two arrays,
     *              each with the indices along one dimension of the array.  Can be used
     *              to slice a ndarray of shape(`n`, `n`).
     */
    public final Object triu_indices(Object n, Object... args) {
        write("np.triu_indices("+PythonGrammar.toPythonArgs(n)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the indices for the upper-triangle of arr.
     * 
     * See `triu_indices` for full details.
     * <p>
     * <em>Notes:</em><br>
     * .. versionadded:: 1.4.0
     * 
     * @param arr ndarray, shape(N, N)<br>
     *            The indices will be valid for square arrays.
     * @param k int, optional<br>
     *          Diagonal offset (see `triu` for details).
     * 
     * @return triu_indices_from tuple, shape(2) of ndarray, shape(N)<br>
     *                           Indices for the upper-triangle of `arr`.
     */
    public final Object triu_indices_from(Object arr, Object... args) {
        write("np.triu_indices_from("+PythonGrammar.toPythonArgs(arr)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return a description for the given data type code.
     * 
     * @param char str<br>
     *             Data type code.
     * 
     * @return out str<br>
     *             Description of the input data type code.
     */
    public final Object typename(Object char) {
        write("np.typename("+PythonGrammar.toPythonArgs(char)+")");
        return null;
    }

    /**
     * Find the union of two arrays.
     * 
     * Return the unique, sorted array of values that are in either of the two
     * input arrays.
     * 
     * @param ar1 array_like<br>
     *            Input arrays. They are flattened if they are not already 1D.
     * @param ar2 array_like<br>
     *            Input arrays. They are flattened if they are not already 1D.
     * 
     * @return union1d ndarray<br>
     *                 Unique, sorted union of the input arrays.
     */
    public final Object union1d(Object ar1, Object ar2) {
        write("np.union1d("+PythonGrammar.toPythonArgs(ar1),PythonGrammar.toPythonArgs(ar2)+")");
        return null;
    }

    /**
     * Find the unique elements of an array.
     * 
     * Returns the sorted unique elements of an array. There are three optional
     * outputs in addition to the unique elements:
     * 
     * * the indices of the input array that give the unique values
     * * the indices of the unique array that reconstruct the input array
     * * the number of times each unique value comes up in the input array
     * <p>
     * <em>Notes:</em><br>
     * When an axis is specified the subarrays indexed by the axis are sorted.
     * This is done by making the specified axis the first dimension of the array
     * (move the axis to the first dimension to keep the order of the other axes)
     * and then flattening the subarrays in C order. The flattened subarrays are
     * then viewed as a structured type with each element given a label, with the
     * effect that we end up with a 1-D array of structured types that can be
     * treated in the same way as any other 1-D array. The result is that the
     * flattened subarrays are sorted in lexicographic order starting with the
     * first element.
     * 
     * .. versionchanged: NumPy 1.21
     * If nan values are in the input array, a single nan is put
     * to the end of the sorted unique values.
     * 
     * Also for complex arrays all NaN values are considered equivalent
     * (no matter whether the NaN is in the real or imaginary part).
     * As the representant for the returned array the smallest one in the
     * lexicographical order is chosen - see np.sort for how the lexicographical
     * order is defined for complex arrays.
     * 
     * @param ar array_like<br>
     *           Input array. Unless `axis` is specified, this will be flattened if it
     *           is not already 1-D.
     * @param return_index bool, optional<br>
     *                     If True, also return the indices of `ar` (along the specified axis,
     *                     if provided, or in the flattened array) that result in the unique array.
     * @param return_inverse bool, optional<br>
     *                       If True, also return the indices of the unique array (for the specified
     *                       axis, if provided) that can be used to reconstruct `ar`.
     * @param return_counts bool, optional<br>
     *                      If True, also return the number of times each unique item appears
     *                      in `ar`.
     *                      
     *                      .. versionadded:: 1.9.0
     *                      
     * @param axis int or None, optional<br>
     *             The axis to operate on. If None, `ar` will be flattened. If an integer,
     *             the subarrays indexed by the given axis will be flattened and treated
     *             as the elements of a 1-D array with the dimension of the given axis,
     *             see the notes for more details.  Object arrays or structured arrays
     *             that contain objects are not supported if the `axis` kwarg is used. The
     *             default is None.
     *             
     *             .. versionadded:: 1.13.0
     * 
     * @return (unique,unique_indices,unique_inverse,unique_counts) (ndarray,ndarray, optional,ndarray, optional,ndarray, optional)<br>
     *          The sorted unique values.
     *          
     *          The indices of the first occurrences of the unique values in the
     *          original array. Only provided if `return_index` is True.
     *          
     *          The indices to reconstruct the original array from the
     *          unique array. Only provided if `return_inverse` is True.
     *          
     *          The number of times each of the unique values comes up in the
     *          original array. Only provided if `return_counts` is True.
     *          
     *          .. versionadded:: 1.9.0
     */
    public final Object unique(Object ar, Object... args) {
        write("np.unique("+PythonGrammar.toPythonArgs(ar)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * unpackbits(a, axis=None, count=None, bitorder='big')
     * 
     * Unpacks elements of a uint8 array into a binary-valued output array.
     * 
     * Each element of `a` represents a bit-field that should be unpacked
     * into a binary-valued output array. The shape of the output array is
     * either 1-D (if `axis` is ``None``) or the same shape as the input
     * array with unpacking done along the axis specified.
     * 
     * @param a ndarray, uint8 type<br>
     *          Input array.
     * @param axis int, optional<br>
     *             The dimension over which bit-unpacking is done.
     *             ``None`` implies unpacking the flattened array.
     * @param count int or None, optional<br>
     *              The number of elements to unpack along `axis`, provided as a way
     *              of undoing the effect of packing a size that is not a multiple
     *              of eight. A non-negative number means to only unpack `count`
     *              bits. A negative number means to trim off that many bits from
     *              the end. ``None`` means to unpack the entire array (the
     *              default). Counts larger than the available number of bits will
     *              add zero padding to the output. Negative counts must not
     *              exceed the available number of bits.
     *              
     *              .. versionadded:: 1.17.0
     *              
     * @param bitorder &#123;'big', 'little'&#125;, optional<br>
     *                 The order of the returned bits. 'big' will mimic bin(val),
     *                 ``3 = 0b00000011 =&gt; [0, 0, 0, 0, 0, 0, 1, 1]``, 'little' will reverse
     *                 the order to ``[1, 1, 0, 0, 0, 0, 0, 0]``.
     *                 Defaults to 'big'.
     *                 
     *                 .. versionadded:: 1.17.0
     * @param ... n/a<br>undocumented
     * 
     * @return unpacked ndarray, uint8 type<br>
     *                  The elements are binary-valued (0 or 1).
     */
    public final Object unpackbits(Object... args) {
        write("np.unpackbits("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * unravel_index(indices, shape, order='C')
     * 
     * Converts a flat index or array of flat indices into a tuple
     * of coordinate arrays.
     * 
     * @param indices array_like<br>
     *                An integer array whose elements are indices into the flattened
     *                version of an array of dimensions ``shape``. Before version 1.6.0,
     *                this function accepted just one index value.
     * @param shape tuple of ints<br>
     *              The shape of the array to use for unraveling ``indices``.
     *              
     *              .. versionchanged:: 1.16.0
     *              Renamed from ``dims`` to ``shape``.
     *              
     * @param order &#123;'C', 'F'&#125;, optional<br>
     *              Determines whether the indices should be viewed as indexing in
     *              row-major (C-style) or column-major (Fortran-style) order.
     *              
     *              .. versionadded:: 1.6.0
     * @param ... n/a<br>undocumented
     * 
     * @return unraveled_coords tuple of ndarray<br>
     *                          Each array in the tuple has the same shape as the ``indices``
     *                          array.
     */
    public final Object unravel_index(Object... args) {
        write("np.unravel_index("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Unwrap by taking the complement of large deltas with respect to the period.
     * 
     * This unwraps a signal `p` by changing elements which have an absolute
     * difference from their predecessor of more than ``max(discont, period/2)``
     * to their `period`-complementary values.
     * 
     * For the default case where `period` is :math:`2\pi` and is `discont` is
     * :math:`\pi`, this unwraps a radian phase `p` such that adjacent differences
     * are never greater than :math:`\pi` by adding :math:`2k\pi` for some
     * integer :math:`k`.
     * <p>
     * <em>Notes:</em><br>
     * If the discontinuity in `p` is smaller than ``period/2``,
     * but larger than `discont`, no unwrapping is done because taking
     * the complement would only make the discontinuity larger.
     * 
     * @param p array_like<br>
     *          Input array.
     * @param discont float, optional<br>
     *                Maximum discontinuity between values, default is ``period/2``.
     *                Values below ``period/2`` are treated as if they were ``period/2``.
     *                To have an effect different from the default, `discont` should be
     *                larger than ``period/2``.
     * @param axis int, optional<br>
     *             Axis along which unwrap will operate, default is the last axis.
     * @param period float, optional<br>
     *               Size of the range over which the input wraps. By default, it is
     *               ``2 pi``.
     *               
     *               .. versionadded:: 1.21.0
     * 
     * @return out ndarray<br>
     *             Output array.
     */
    public final Object unwrap(Object p, Object... args) {
        write("np.unwrap("+PythonGrammar.toPythonArgs(p)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Generate a Vandermonde matrix.
     * 
     * The columns of the output matrix are powers of the input vector. The
     * order of the powers is determined by the `increasing` boolean argument.
     * Specifically, when `increasing` is False, the `i`-th output column is
     * the input vector raised element-wise to the power of ``N - i - 1``. Such
     * a matrix with a geometric progression in each row is named for Alexandre-
     * Theophile Vandermonde.
     * 
     * @param x array_like<br>
     *          1-D input array.
     * @param N int, optional<br>
     *          Number of columns in the output.  If `N` is not specified, a square
     *          array is returned (``N = len(x)``).
     * @param increasing bool, optional<br>
     *                   Order of the powers of the columns.  If True, the powers increase
     *                   from left to right, if False (the default) they are reversed.
     *                   
     *                   .. versionadded:: 1.9.0
     * 
     * @return out ndarray<br>
     *             Vandermonde matrix.  If `increasing` is False, the first column is
     *             ``x^(N-1)``, the second ``x^(N-2)`` and so forth. If `increasing` is
     *             True, the columns are ``x^0, x^1, ..., x^(N-1)``.
     */
    public final Object vander(Object x, Object... args) {
        write("np.vander("+PythonGrammar.toPythonArgs(x)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Compute the variance along the specified axis.
     * 
     * Returns the variance of the array elements, a measure of the spread of a
     * distribution.  The variance is computed for the flattened array by
     * default, otherwise over the specified axis.
     * <p>
     * <em>Notes:</em><br>
     * The variance is the average of the squared deviations from the mean,
     * i.e.,  ``var = mean(x)``, where ``x = abs(a - a.mean())**2``.
     * 
     * The mean is typically calculated as ``x.sum() / N``, where ``N = len(x)``.
     * If, however, `ddof` is specified, the divisor ``N - ddof`` is used
     * instead.  In standard statistical practice, ``ddof=1`` provides an
     * unbiased estimator of the variance of a hypothetical infinite population.
     * ``ddof=0`` provides a maximum likelihood estimate of the variance for
     * normally distributed variables.
     * 
     * Note that for complex numbers, the absolute value is taken before
     * squaring, so that the result is always real and nonnegative.
     * 
     * For floating-point input, the variance is computed using the same
     * precision the input has.  Depending on the input data, this can cause
     * the results to be inaccurate, especially for `float32` (see example
     * below).  Specifying a higher-accuracy accumulator using the ``dtype``
     * keyword can alleviate this issue.
     * 
     * @param a array_like<br>
     *          Array containing numbers whose variance is desired.  If `a` is not an
     *          array, a conversion is attempted.
     * @param axis None or int or tuple of ints, optional<br>
     *             Axis or axes along which the variance is computed.  The default is to
     *             compute the variance of the flattened array.
     *             
     *             .. versionadded:: 1.7.0
     *             
     *             If this is a tuple of ints, a variance is performed over multiple axes,
     *             instead of a single axis or all the axes as before.
     * @param dtype data-type, optional<br>
     *              Type to use in computing the variance.  For arrays of integer type
     *              the default is `float64`; for arrays of float types it is the same as
     *              the array type.
     * @param out ndarray, optional<br>
     *            Alternate output array in which to place the result.  It must have
     *            the same shape as the expected output, but the type is cast if
     *            necessary.
     * @param ddof int, optional<br>
     *             "Delta Degrees of Freedom": the divisor used in the calculation is
     *             ``N - ddof``, where ``N`` represents the number of elements. By
     *             default `ddof` is zero.
     * @param keepdims bool, optional<br>
     *                 If this is set to True, the axes which are reduced are left
     *                 in the result as dimensions with size one. With this option,
     *                 the result will broadcast correctly against the input array.
     *                 
     *                 If the default value is passed, then `keepdims` will not be
     *                 passed through to the `var` method of sub-classes of
     *                 `ndarray`, however any non-default value will be.  If the
     *                 sub-class' method does not implement `keepdims` any
     *                 exceptions will be raised.
     *                 
     * @param where array_like of bool, optional<br>
     *              Elements to include in the variance. See `~numpy.ufunc.reduce` for
     *              details.
     *              
     *              .. versionadded:: 1.20.0
     * 
     * @return variance ndarray, see dtype parameter above<br>
     *                  If ``out=None``, returns a new array containing the variance;
     *                  otherwise, a reference to the output array is returned.
     */
    public final Object var(Object a, Object... args) {
        write("np.var("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * vdot(a, b)
     * 
     * Return the dot product of two vectors.
     * 
     * The vdot(`a`, `b`) function handles complex numbers differently than
     * dot(`a`, `b`).  If the first argument is complex the complex conjugate
     * of the first argument is used for the calculation of the dot product.
     * 
     * Note that `vdot` handles multidimensional arrays differently than `dot`:
     * it does *not* perform a matrix product, but flattens input arguments
     * to 1-D vectors first. Consequently, it should only be used for vectors.
     * 
     * @param a array_like<br>
     *          If `a` is complex the complex conjugate is taken before calculation
     *          of the dot product.
     * @param b array_like<br>
     *          Second argument to the dot product.
     * @param ... n/a<br>undocumented
     * 
     * @return output ndarray<br>
     *                Dot product of `a` and `b`.  Can be an int, float, or
     *                complex depending on the types of `a` and `b`.
     */
    public final Object vdot(Object... args) {
        write("np.vdot("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Split an array into multiple sub-arrays vertically (row-wise).
     * 
     * Please refer to the ``split`` documentation.  ``vsplit`` is equivalent
     * to ``split`` with `axis=0` (default), the array is always split along the
     * first axis regardless of the array dimension.
     * 
     * @param ary n/a<br>undocumented
     * @param indices_or_sections n/a<br>undocumented
     */
    public final Object vsplit(Object... args) {
        write("np.vsplit("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Stack arrays in sequence vertically (row wise).
     * 
     * This is equivalent to concatenation along the first axis after 1-D arrays
     * of shape `(N,)` have been reshaped to `(1,N)`. Rebuilds arrays divided by
     * `vsplit`.
     * 
     * This function makes most sense for arrays with up to 3 dimensions. For
     * instance, for pixel-data with a height (first axis), width (second axis),
     * and r/g/b channels (third axis). The functions `concatenate`, `stack` and
     * `block` provide more general stacking and concatenation operations.
     * 
     * @param tup sequence of ndarrays<br>
     *            The arrays must have the same shape along all but the first axis.
     *            1-D arrays must have the same length.
     * 
     * @return stacked ndarray<br>
     *                 The array formed by stacking the given arrays, will be at least 2-D.
     */
    public final Object vstack(Object tup) {
        write("np.vstack("+PythonGrammar.toPythonArgs(tup)+")");
        return null;
    }

    /**
     * where(condition, [x, y])
     * 
     * Return elements chosen from `x` or `y` depending on `condition`.
     * 
     * .. note::
     * When only `condition` is provided, this function is a shorthand for
     * ``np.asarray(condition).nonzero()``. Using `nonzero` directly should be
     * preferred, as it behaves correctly for subclasses. The rest of this
     * documentation covers only the case where all three arguments are
     * provided.
     * <p>
     * <em>Notes:</em><br>
     * If all the arrays are 1-D, `where` is equivalent to::
     * 
     * [xv if c else yv
     * for c, xv, yv in zip(condition, x, y)]
     * 
     * @param condition array_like, bool<br>
     *                  Where True, yield `x`, otherwise yield `y`.
     * @param x array_like<br>
     *          Values from which to choose. `x`, `y` and `condition` need to be
     *          broadcastable to some shape.
     * @param y array_like<br>
     *          Values from which to choose. `x`, `y` and `condition` need to be
     *          broadcastable to some shape.
     * @param ... n/a<br>undocumented
     * 
     * @return out ndarray<br>
     *             An array with elements from `x` where `condition` is True, and elements
     *             from `y` elsewhere.
     */
    public final Object where(Object... args) {
        write("np.where("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Print the NumPy arrays in the given dictionary.
     * 
     * If there is no dictionary passed in or `vardict` is None then returns
     * NumPy arrays in the globals() dictionary (all NumPy arrays in the
     * namespace).
     * <p>
     * <em>Notes:</em><br>
     * Prints out the name, shape, bytes and type of all of the ndarrays
     * present in `vardict`.
     * 
     * @param vardict dict, optional<br>
     *                A dictionary possibly containing ndarrays.  Default is globals().
     * 
     * @return out None<br>
     *             Returns 'None'.
     */
    public final void who(Object... args) {
        write("np.who("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
    }

    /**
     * Return an array of zeros with the same shape and type as a given array.
     * 
     * @param a array_like<br>
     *          The shape and data-type of `a` define these same attributes of
     *          the returned array.
     * @param dtype data-type, optional<br>
     *              Overrides the data type of the result.
     *              
     *              .. versionadded:: 1.6.0
     * @param order &#123;'C', 'F', 'A', or 'K'&#125;, optional<br>
     *              Overrides the memory layout of the result. 'C' means C-order,
     *              'F' means F-order, 'A' means 'F' if `a` is Fortran contiguous,
     *              'C' otherwise. 'K' means match the layout of `a` as closely
     *              as possible.
     *              
     *              .. versionadded:: 1.6.0
     * @param subok bool, optional.<br>
     *              If True, then the newly created array will use the sub-class
     *              type of `a`, otherwise it will be a base-class array. Defaults
     *              to True.
     * @param shape int or sequence of ints, optional.<br>
     *              Overrides the shape of the result. If order='K' and the number of
     *              dimensions is unchanged, will try to keep order, otherwise,
     *              order='C' is implied.
     *              
     *              .. versionadded:: 1.17.0
     * 
     * @return out ndarray<br>
     *             Array of zeros with the same shape and type as `a`.
     */
    public final Object zeros_like(Object a, Object... args) {
        write("np.zeros_like("+PythonGrammar.toPythonArgs(a)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

}
