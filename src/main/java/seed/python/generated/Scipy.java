package seed.python.generated;

import seed.python.core.PythonGrammar;
import seed.python.core.PythonScript;

public final class Scipy extends PythonScript {

    /**
     * Find a root of a function, using (extended) Anderson mixing.
     * 
     * The Jacobian is formed by for a 'best' solution in the space
     * spanned by last `M` vectors. As a result, only a MxM matrix
     * inversions and MxN multiplications are required. [Ey]_
     * 
     * @param F function(x) -&gt; f<br>
     *          Function whose root to find; should take and return an array-like
     *          object.
     * @param xin array_like<br>
     *            Initial guess for the solution
     * @param alpha float, optional<br>
     *              Initial guess for the Jacobian is (-1/alpha).
     * @param M float, optional<br>
     *          Number of previous vectors to retain. Defaults to 5.
     * @param w0 float, optional<br>
     *           Regularization parameter for numerical stability.
     *           Compared to unity, good values of the order of 0.01.
     * @param iter int, optional<br>
     *             Number of iterations to make. If omitted (default), make as many
     *             as required to meet tolerances.
     * @param verbose bool, optional<br>
     *                Print status to stdout on every iteration.
     * @param maxiter int, optional<br>
     *                Maximum number of iterations to make. If more are needed to
     *                meet convergence, `NoConvergence` is raised.
     * @param f_tol float, optional<br>
     *              Absolute tolerance (in max-norm) for the residual.
     *              If omitted, default is 6e-6.
     * @param f_rtol float, optional<br>
     *               Relative tolerance for the residual. If omitted, not used.
     * @param x_tol float, optional<br>
     *              Absolute minimum step size, as determined from the Jacobian
     *              approximation. If the step size is smaller than this, optimization
     *              is terminated as successful. If omitted, not used.
     * @param x_rtol float, optional<br>
     *               Relative minimum step size. If omitted, not used.
     * @param tol_norm function(vector) -&gt; scalar, optional<br>
     *                 Norm to use in convergence check. Default is the maximum norm.
     * @param line_search &#123;None, 'armijo' (default), 'wolfe'&#125;, optional<br>
     *                    Which type of a line search to use to determine the step size in the
     *                    direction given by the Jacobian approximation. Defaults to 'armijo'.
     * @param callback function, optional<br>
     *                 Optional callback function. It is called on every iteration as
     *                 ``callback(x, f)`` where `x` is the current solution and `f`
     *                 the corresponding residual.
     * @param **kw n/a<br>undocumented
     * 
     * @return sol ndarray<br>
     *             An array (of similar array type as `x0`) containing the final solution.
     */
    public final Object anderson(Object F, Object xin, Object... args) {
        write("optimize.anderson("+PythonGrammar.toPythonArgs(F),PythonGrammar.toPythonArgs(xin)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Finite-difference approximation of the gradient of a scalar function.
     * <p>
     * <em>Notes:</em><br>
     * The function gradient is determined by the forward finite difference
     * formula::
     * 
     * f(xk[i] + epsilon[i]) - f(xk[i])
     * f'[i] = ---------------------------------
     * epsilon[i]
     * 
     * The main use of `approx_fprime` is in scalar function optimizers like
     * `fmin_bfgs`, to determine numerically the Jacobian of a function.
     * 
     * @param xk array_like<br>
     *           The coordinate vector at which to determine the gradient of `f`.
     * @param f callable<br>
     *          The function of which to determine the gradient (partial derivatives).
     *          Should take `xk` as first argument, other arguments to `f` can be
     *          supplied in ``*args``. Should return a scalar, the value of the
     *          function at `xk`.
     * @param epsilon array_like<br>
     *                Increment to `xk` to use for determining the function gradient.
     *                If a scalar, uses the same finite difference delta for all partial
     *                derivatives. If an array, should contain one value per element of
     *                `xk`.
     * @param \*args args, optional<br>
     *               Any other arguments that are to be passed to `f`.
     * @param *args n/a<br>undocumented
     * 
     * @return grad ndarray<br>
     *              The partial derivatives of `f` to `xk`.
     */
    public final Object approx_fprime(Object xk, Object f, Object epsilon, Object... args) {
        write("optimize.approx_fprime("+PythonGrammar.toPythonArgs(xk),PythonGrammar.toPythonArgs(f),PythonGrammar.toPythonArgs(epsilon)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find the global minimum of a function using the basin-hopping algorithm.
     * 
     * Basin-hopping is a two-phase method that combines a global stepping
     * algorithm with local minimization at each step. Designed to mimic
     * the natural process of energy minimization of clusters of atoms, it works
     * well for similar problems with "funnel-like, but rugged" energy landscapes
     * [5]_.
     * 
     * As the step-taking, step acceptance, and minimization methods are all
     * customizable, this function can also be used to implement other two-phase
     * methods.
     * <p>
     * <em>Notes:</em><br>
     * Basin-hopping is a stochastic algorithm which attempts to find the global
     * minimum of a smooth scalar function of one or more variables [1]_ [2]_ [3]_
     * [4]_. The algorithm in its current form was described by David Wales and
     * Jonathan Doye [2]_ http://www-wales.ch.cam.ac.uk/.
     * 
     * The algorithm is iterative with each cycle composed of the following
     * features
     * 
     * 1) random perturbation of the coordinates
     * 
     * 2) local minimization
     * 
     * 3) accept or reject the new coordinates based on the minimized function
     * value
     * 
     * The acceptance test used here is the Metropolis criterion of standard Monte
     * Carlo algorithms, although there are many other possibilities [3]_.
     * 
     * This global minimization method has been shown to be extremely efficient
     * for a wide variety of problems in physics and chemistry. It is
     * particularly useful when the function has many minima separated by large
     * barriers. See the Cambridge Cluster Database
     * http://www-wales.ch.cam.ac.uk/CCD.html for databases of molecular systems
     * that have been optimized primarily using basin-hopping. This database
     * includes minimization problems exceeding 300 degrees of freedom.
     * 
     * See the free software program GMIN (http://www-wales.ch.cam.ac.uk/GMIN) for
     * a Fortran implementation of basin-hopping. This implementation has many
     * different variations of the procedure described above, including more
     * advanced step taking algorithms and alternate acceptance criterion.
     * 
     * For stochastic global optimization there is no way to determine if the true
     * global minimum has actually been found. Instead, as a consistency check,
     * the algorithm can be run from a number of different random starting points
     * to ensure the lowest minimum found in each example has converged to the
     * global minimum. For this reason, ``basinhopping`` will by default simply
     * run for the number of iterations ``niter`` and return the lowest minimum
     * found. It is left to the user to ensure that this is in fact the global
     * minimum.
     * 
     * Choosing ``stepsize``:  This is a crucial parameter in ``basinhopping`` and
     * depends on the problem being solved. The step is chosen uniformly in the
     * region from x0-stepsize to x0+stepsize, in each dimension. Ideally, it
     * should be comparable to the typical separation (in argument values) between
     * local minima of the function being optimized. ``basinhopping`` will, by
     * default, adjust ``stepsize`` to find an optimal value, but this may take
     * many iterations. You will get quicker results if you set a sensible
     * initial value for ``stepsize``.
     * 
     * Choosing ``T``: The parameter ``T`` is the "temperature" used in the
     * Metropolis criterion. Basinhopping steps are always accepted if
     * ``func(xnew) < func(xold)``. Otherwise, they are accepted with
     * probability::
     * 
     * exp( -(func(xnew) - func(xold)) / T )
     * 
     * So, for best results, ``T`` should to be comparable to the typical
     * difference (in function values) between local minima. (The height of
     * "walls" between local minima is irrelevant.)
     * 
     * If ``T`` is 0, the algorithm becomes Monotonic Basin-Hopping, in which all
     * steps that increase energy are rejected.
     * 
     * .. versionadded:: 0.12.0
     * 
     * @param func callable ``f(x, *args)``<br>
     *             Function to be optimized.  ``args`` can be passed as an optional item
     *             in the dict ``minimizer_kwargs``
     * @param x0 array_like<br>
     *           Initial guess.
     * @param niter integer, optional<br>
     *              The number of basin-hopping iterations. There will be a total of
     *              ``niter + 1`` runs of the local minimizer.
     * @param T float, optional<br>
     *          The "temperature" parameter for the accept or reject criterion. Higher
     *          "temperatures" mean that larger jumps in function value will be
     *          accepted.  For best results ``T`` should be comparable to the
     *          separation (in function value) between local minima.
     * @param stepsize float, optional<br>
     *                 Maximum step size for use in the random displacement.
     * @param minimizer_kwargs dict, optional<br>
     *                         Extra keyword arguments to be passed to the local minimizer
     *                         ``scipy.optimize.minimize()`` Some important options could be:
     *                         
     *                         method : str
     *                         The minimization method (e.g. ``"L-BFGS-B"``)
     *                         args : tuple
     *                         Extra arguments passed to the objective function (``func``) and
     *                         its derivatives (Jacobian, Hessian).
     *                         
     * @param take_step callable ``take_step(x)``, optional<br>
     *                  Replace the default step-taking routine with this routine. The default
     *                  step-taking routine is a random displacement of the coordinates, but
     *                  other step-taking algorithms may be better for some systems.
     *                  ``take_step`` can optionally have the attribute ``take_step.stepsize``.
     *                  If this attribute exists, then ``basinhopping`` will adjust
     *                  ``take_step.stepsize`` in order to try to optimize the global minimum
     *                  search.
     * @param accept_test callable, ``accept_test(f_new=f_new, x_new=x_new, f_old=fold, x_old=x_old)``, optional<br>
     *                    Define a test which will be used to judge whether or not to accept the
     *                    step.  This will be used in addition to the Metropolis test based on
     *                    "temperature" ``T``.  The acceptable return values are True,
     *                    False, or ``"force accept"``. If any of the tests return False
     *                    then the step is rejected. If the latter, then this will override any
     *                    other tests in order to accept the step. This can be used, for example,
     *                    to forcefully escape from a local minimum that ``basinhopping`` is
     *                    trapped in.
     * @param callback callable, ``callback(x, f, accept)``, optional<br>
     *                 A callback function which will be called for all minima found. ``x``
     *                 and ``f`` are the coordinates and function value of the trial minimum,
     *                 and ``accept`` is whether or not that minimum was accepted. This can
     *                 be used, for example, to save the lowest N minima found. Also,
     *                 ``callback`` can be used to specify a user defined stop criterion by
     *                 optionally returning True to stop the ``basinhopping`` routine.
     * @param interval integer, optional<br>
     *                 interval for how often to update the ``stepsize``
     * @param disp bool, optional<br>
     *             Set to True to print status messages
     * @param niter_success integer, optional<br>
     *                      Stop the run if the global minimum candidate remains the same for this
     *                      number of iterations.
     * @param seed &#123;None, int, `numpy.random.Generator`,<br>
     *             `numpy.random.RandomState`&#125;, optional
     *             
     *             If `seed` is None (or `np.random`), the `numpy.random.RandomState`
     *             singleton is used.
     *             If `seed` is an int, a new ``RandomState`` instance is used,
     *             seeded with `seed`.
     *             If `seed` is already a ``Generator`` or ``RandomState`` instance then
     *             that instance is used.
     *             Specify `seed` for repeatable minimizations. The random numbers
     *             generated with this seed only affect the default Metropolis
     *             `accept_test` and the default `take_step`. If you supply your own
     *             `take_step` and `accept_test`, and these functions use random
     *             number generation, then those functions are responsible for the state
     *             of their random number generator.
     * 
     * @return res OptimizeResult<br>
     *             The optimization result represented as a ``OptimizeResult`` object.
     *             Important attributes are: ``x`` the solution array, ``fun`` the value
     *             of the function at the solution, and ``message`` which describes the
     *             cause of the termination. The ``OptimizeResult`` object returned by the
     *             selected minimizer at the lowest minimum is also contained within this
     *             object and can be accessed through the ``lowest_optimization_result``
     *             attribute.  See `OptimizeResult` for a description of other attributes.
     */
    public final Object basinhopping(Object func, Object x0, Object... args) {
        write("optimize.basinhopping("+PythonGrammar.toPythonArgs(func),PythonGrammar.toPythonArgs(x0)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find root of a function within an interval using bisection.
     * 
     * Basic bisection routine to find a zero of the function `f` between the
     * arguments `a` and `b`. `f(a)` and `f(b)` cannot have the same signs.
     * Slow but sure.
     * 
     * @param f function<br>
     *          Python function returning a number.  `f` must be continuous, and
     *          f(a) and f(b) must have opposite signs.
     * @param a scalar<br>
     *          One end of the bracketing interval [a,b].
     * @param b scalar<br>
     *          The other end of the bracketing interval [a,b].
     * @param xtol number, optional<br>
     *             The computed root ``x0`` will satisfy ``np.allclose(x, x0,
     *             atol=xtol, rtol=rtol)``, where ``x`` is the exact root. The
     *             parameter must be nonnegative.
     * @param rtol number, optional<br>
     *             The computed root ``x0`` will satisfy ``np.allclose(x, x0,
     *             atol=xtol, rtol=rtol)``, where ``x`` is the exact root. The
     *             parameter cannot be smaller than its default value of
     *             ``4*np.finfo(float).eps``.
     * @param maxiter int, optional<br>
     *                If convergence is not achieved in `maxiter` iterations, an error is
     *                raised. Must be &gt;= 0.
     * @param args tuple, optional<br>
     *             Containing extra arguments for the function `f`.
     *             `f` is called by ``apply(f, (x)+args)``.
     * @param full_output bool, optional<br>
     *                    If `full_output` is False, the root is returned. If `full_output` is
     *                    True, the return value is ``(x, r)``, where x is the root, and r is
     *                    a `RootResults` object.
     * @param disp bool, optional<br>
     *             If True, raise RuntimeError if the algorithm didn't converge.
     *             Otherwise, the convergence status is recorded in a `RootResults`
     *             return object.
     * 
     * @return (x0,r) (float,`RootResults` (present if ``full_output = True``))<br>
     *          Zero of `f` between `a` and `b`.
     *          
     *          Object containing information about the convergence. In particular,
     *          ``r.converged`` is True if the routine converged.
     */
    public final Object bisect(Object f, Object a, Object b, Object... args) {
        write("optimize.bisect("+PythonGrammar.toPythonArgs(f),PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(b)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Bracket the minimum of the function.
     * 
     * Given a function and distinct initial points, search in the
     * downhill direction (as defined by the initial points) and return
     * new points xa, xb, xc that bracket the minimum of the function
     * f(xa) > f(xb) < f(xc). It doesn't always mean that obtained
     * solution will satisfy xa<=x<=xb.
     * 
     * @param func callable f(x,*args)<br>
     *             Objective function to minimize.
     * @param xa float, optional<br>
     *           Bracketing interval. Defaults `xa` to 0.0, and `xb` to 1.0.
     * @param xb float, optional<br>
     *           Bracketing interval. Defaults `xa` to 0.0, and `xb` to 1.0.
     * @param args tuple, optional<br>
     *             Additional arguments (if present), passed to `func`.
     * @param grow_limit float, optional<br>
     *                   Maximum grow limit.  Defaults to 110.0
     * @param maxiter int, optional<br>
     *                Maximum number of iterations to perform. Defaults to 1000.
     * 
     * @return (xa,xb,xc,fa,fb,fc,funcalls) (float,float,float,float,float,float,int)<br>
     *          Bracket.
     *          
     *          Bracket.
     *          
     *          Bracket.
     *          
     *          Objective function values in bracket.
     *          
     *          Objective function values in bracket.
     *          
     *          Objective function values in bracket.
     *          
     *          Number of function evaluations made.
     */
    public final Object bracket(Object func, Object... args) {
        write("optimize.bracket("+PythonGrammar.toPythonArgs(func)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Given a function of one variable and a possible bracket, return
     * the local minimum of the function isolated to a fractional precision
     * of tol.
     * <p>
     * <em>Notes:</em><br>
     * Uses inverse parabolic interpolation when possible to speed up
     * convergence of golden section method.
     * 
     * Does not ensure that the minimum lies in the range specified by
     * `brack`. See `fminbound`.
     * 
     * @param func callable f(x,*args)<br>
     *             Objective function.
     * @param args tuple, optional<br>
     *             Additional arguments (if present).
     * @param brack tuple, optional<br>
     *              Either a triple (xa,xb,xc) where xa&lt;xb&lt;xc and func(xb) &lt;
     *              func(xa), func(xc) or a pair (xa,xb) which are used as a
     *              starting interval for a downhill bracket search (see
     *              `bracket`). Providing the pair (xa,xb) does not always mean
     *              the obtained solution will satisfy xa&lt;=x&lt;=xb.
     * @param tol float, optional<br>
     *            Stop if between iteration change is less than `tol`.
     * @param full_output bool, optional<br>
     *                    If True, return all output args (xmin, fval, iter,
     *                    funcalls).
     * @param maxiter int, optional<br>
     *                Maximum number of iterations in solution.
     * 
     * @return (xmin,fval,iter,funcalls) (ndarray,float,int,int)<br>
     *          Optimum point.
     *          
     *          Optimum value.
     *          
     *          Number of iterations.
     *          
     *          Number of objective function evaluations made.
     */
    public final Object brent(Object func, Object... args) {
        write("optimize.brent("+PythonGrammar.toPythonArgs(func)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find a root of a function in a bracketing interval using Brent's
     * method with hyperbolic extrapolation.
     * 
     * A variation on the classic Brent routine to find a zero of the function f
     * between the arguments a and b that uses hyperbolic extrapolation instead of
     * inverse quadratic extrapolation. There was a paper back in the 1980's ...
     * f(a) and f(b) cannot have the same signs. Generally, on a par with the
     * brent routine, but not as heavily tested. It is a safe version of the
     * secant method that uses hyperbolic extrapolation. The version here is by
     * Chuck Harris.
     * 
     * @param f function<br>
     *          Python function returning a number. f must be continuous, and f(a) and
     *          f(b) must have opposite signs.
     * @param a scalar<br>
     *          One end of the bracketing interval [a,b].
     * @param b scalar<br>
     *          The other end of the bracketing interval [a,b].
     * @param xtol number, optional<br>
     *             The computed root ``x0`` will satisfy ``np.allclose(x, x0,
     *             atol=xtol, rtol=rtol)``, where ``x`` is the exact root. The
     *             parameter must be nonnegative. As with `brentq`, for nice
     *             functions the method will often satisfy the above condition
     *             with ``xtol/2`` and ``rtol/2``.
     * @param rtol number, optional<br>
     *             The computed root ``x0`` will satisfy ``np.allclose(x, x0,
     *             atol=xtol, rtol=rtol)``, where ``x`` is the exact root. The
     *             parameter cannot be smaller than its default value of
     *             ``4*np.finfo(float).eps``. As with `brentq`, for nice functions
     *             the method will often satisfy the above condition with
     *             ``xtol/2`` and ``rtol/2``.
     * @param maxiter int, optional<br>
     *                If convergence is not achieved in `maxiter` iterations, an error is
     *                raised. Must be &gt;= 0.
     * @param args tuple, optional<br>
     *             Containing extra arguments for the function `f`.
     *             `f` is called by ``apply(f, (x)+args)``.
     * @param full_output bool, optional<br>
     *                    If `full_output` is False, the root is returned. If `full_output` is
     *                    True, the return value is ``(x, r)``, where `x` is the root, and `r` is
     *                    a `RootResults` object.
     * @param disp bool, optional<br>
     *             If True, raise RuntimeError if the algorithm didn't converge.
     *             Otherwise, the convergence status is recorded in any `RootResults`
     *             return object.
     * 
     * @return (x0,r) (float,`RootResults` (present if ``full_output = True``))<br>
     *          Zero of `f` between `a` and `b`.
     *          
     *          Object containing information about the convergence. In particular,
     *          ``r.converged`` is True if the routine converged.
     */
    public final Object brenth(Object f, Object a, Object b, Object... args) {
        write("optimize.brenth("+PythonGrammar.toPythonArgs(f),PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(b)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find a root of a function in a bracketing interval using Brent's method.
     * 
     * Uses the classic Brent's method to find a zero of the function `f` on
     * the sign changing interval [a , b]. Generally considered the best of the
     * rootfinding routines here. It is a safe version of the secant method that
     * uses inverse quadratic extrapolation. Brent's method combines root
     * bracketing, interval bisection, and inverse quadratic interpolation. It is
     * sometimes known as the van Wijngaarden-Dekker-Brent method. Brent (1973)
     * claims convergence is guaranteed for functions computable within [a,b].
     * 
     * [Brent1973]_ provides the classic description of the algorithm. Another
     * description can be found in a recent edition of Numerical Recipes, including
     * [PressEtal1992]_. A third description is at
     * http://mathworld.wolfram.com/BrentsMethod.html. It should be easy to
     * understand the algorithm just by reading our code. Our code diverges a bit
     * from standard presentations: we choose a different formula for the
     * extrapolation step.
     * <p>
     * <em>Notes:</em><br>
     * `f` must be continuous.  f(a) and f(b) must have opposite signs.
     * 
     * Related functions fall into several classes:
     * 
     * multivariate local optimizers
     * `fmin`, `fmin_powell`, `fmin_cg`, `fmin_bfgs`, `fmin_ncg`
     * nonlinear least squares minimizer
     * `leastsq`
     * constrained multivariate optimizers
     * `fmin_l_bfgs_b`, `fmin_tnc`, `fmin_cobyla`
     * global optimizers
     * `basinhopping`, `brute`, `differential_evolution`
     * local scalar minimizers
     * `fminbound`, `brent`, `golden`, `bracket`
     * N-D root-finding
     * `fsolve`
     * 1-D root-finding
     * `brenth`, `ridder`, `bisect`, `newton`
     * scalar fixed-point finder
     * `fixed_point`
     * 
     * @param f function<br>
     *          Python function returning a number. The function :math:`f`
     *          must be continuous, and :math:`f(a)` and :math:`f(b)` must
     *          have opposite signs.
     * @param a scalar<br>
     *          One end of the bracketing interval :math:`[a, b]`.
     * @param b scalar<br>
     *          The other end of the bracketing interval :math:`[a, b]`.
     * @param xtol number, optional<br>
     *             The computed root ``x0`` will satisfy ``np.allclose(x, x0,
     *             atol=xtol, rtol=rtol)``, where ``x`` is the exact root. The
     *             parameter must be nonnegative. For nice functions, Brent's
     *             method will often satisfy the above condition with ``xtol/2``
     *             and ``rtol/2``. [Brent1973]_
     * @param rtol number, optional<br>
     *             The computed root ``x0`` will satisfy ``np.allclose(x, x0,
     *             atol=xtol, rtol=rtol)``, where ``x`` is the exact root. The
     *             parameter cannot be smaller than its default value of
     *             ``4*np.finfo(float).eps``. For nice functions, Brent's
     *             method will often satisfy the above condition with ``xtol/2``
     *             and ``rtol/2``. [Brent1973]_
     * @param maxiter int, optional<br>
     *                If convergence is not achieved in `maxiter` iterations, an error is
     *                raised. Must be &gt;= 0.
     * @param args tuple, optional<br>
     *             Containing extra arguments for the function `f`.
     *             `f` is called by ``apply(f, (x)+args)``.
     * @param full_output bool, optional<br>
     *                    If `full_output` is False, the root is returned. If `full_output` is
     *                    True, the return value is ``(x, r)``, where `x` is the root, and `r` is
     *                    a `RootResults` object.
     * @param disp bool, optional<br>
     *             If True, raise RuntimeError if the algorithm didn't converge.
     *             Otherwise, the convergence status is recorded in any `RootResults`
     *             return object.
     * 
     * @return (x0,r) (float,`RootResults` (present if ``full_output = True``))<br>
     *          Zero of `f` between `a` and `b`.
     *          
     *          Object containing information about the convergence. In particular,
     *          ``r.converged`` is True if the routine converged.
     */
    public final Object brentq(Object f, Object a, Object b, Object... args) {
        write("optimize.brentq("+PythonGrammar.toPythonArgs(f),PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(b)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find a root of a function, using Broyden's first Jacobian approximation.
     * 
     * This method is also known as \"Broyden's good method\".
     * <p>
     * <em>Notes:</em><br>
     * This algorithm implements the inverse Jacobian Quasi-Newton update
     * 
     * .. math:: H_+ = H + (dx - H df) dx^\dagger H / ( dx^\dagger H df)
     * 
     * which corresponds to Broyden's first Jacobian update
     * 
     * .. math:: J_+ = J + (df - J dx) dx^\dagger / dx^\dagger dx
     * 
     * @param F function(x) -&gt; f<br>
     *          Function whose root to find; should take and return an array-like
     *          object.
     * @param xin array_like<br>
     *            Initial guess for the solution
     * @param alpha float, optional<br>
     *              Initial guess for the Jacobian is ``(-1/alpha)``.
     * @param reduction_method str or tuple, optional<br>
     *                         Method used in ensuring that the rank of the Broyden matrix
     *                         stays low. Can either be a string giving the name of the method,
     *                         or a tuple of the form ``(method, param1, param2, ...)``
     *                         that gives the name of the method and values for additional parameters.
     *                         
     *                         Methods available:
     *                         
     *                         - ``restart``: drop all matrix columns. Has no extra parameters.
     *                         - ``simple``: drop oldest matrix column. Has no extra parameters.
     *                         - ``svd``: keep only the most significant SVD components.
     *                         Takes an extra parameter, ``to_retain``, which determines the
     *                         number of SVD components to retain when rank reduction is done.
     *                         Default is ``max_rank - 2``.
     *                         
     * @param max_rank int, optional<br>
     *                 Maximum rank for the Broyden matrix.
     *                 Default is infinity (i.e., no rank reduction).
     * @param iter int, optional<br>
     *             Number of iterations to make. If omitted (default), make as many
     *             as required to meet tolerances.
     * @param verbose bool, optional<br>
     *                Print status to stdout on every iteration.
     * @param maxiter int, optional<br>
     *                Maximum number of iterations to make. If more are needed to
     *                meet convergence, `NoConvergence` is raised.
     * @param f_tol float, optional<br>
     *              Absolute tolerance (in max-norm) for the residual.
     *              If omitted, default is 6e-6.
     * @param f_rtol float, optional<br>
     *               Relative tolerance for the residual. If omitted, not used.
     * @param x_tol float, optional<br>
     *              Absolute minimum step size, as determined from the Jacobian
     *              approximation. If the step size is smaller than this, optimization
     *              is terminated as successful. If omitted, not used.
     * @param x_rtol float, optional<br>
     *               Relative minimum step size. If omitted, not used.
     * @param tol_norm function(vector) -&gt; scalar, optional<br>
     *                 Norm to use in convergence check. Default is the maximum norm.
     * @param line_search &#123;None, 'armijo' (default), 'wolfe'&#125;, optional<br>
     *                    Which type of a line search to use to determine the step size in the
     *                    direction given by the Jacobian approximation. Defaults to 'armijo'.
     * @param callback function, optional<br>
     *                 Optional callback function. It is called on every iteration as
     *                 ``callback(x, f)`` where `x` is the current solution and `f`
     *                 the corresponding residual.
     * @param **kw n/a<br>undocumented
     * 
     * @return sol ndarray<br>
     *             An array (of similar array type as `x0`) containing the final solution.
     */
    public final Object broyden1(Object F, Object xin, Object... args) {
        write("optimize.broyden1("+PythonGrammar.toPythonArgs(F),PythonGrammar.toPythonArgs(xin)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find a root of a function, using Broyden's second Jacobian approximation.
     * 
     * This method is also known as "Broyden's bad method".
     * <p>
     * <em>Notes:</em><br>
     * This algorithm implements the inverse Jacobian Quasi-Newton update
     * 
     * .. math:: H_+ = H + (dx - H df) df^\dagger / ( df^\dagger df)
     * 
     * corresponding to Broyden's second method.
     * 
     * @param F function(x) -&gt; f<br>
     *          Function whose root to find; should take and return an array-like
     *          object.
     * @param xin array_like<br>
     *            Initial guess for the solution
     * @param alpha float, optional<br>
     *              Initial guess for the Jacobian is ``(-1/alpha)``.
     * @param reduction_method str or tuple, optional<br>
     *                         Method used in ensuring that the rank of the Broyden matrix
     *                         stays low. Can either be a string giving the name of the method,
     *                         or a tuple of the form ``(method, param1, param2, ...)``
     *                         that gives the name of the method and values for additional parameters.
     *                         
     *                         Methods available:
     *                         
     *                         - ``restart``: drop all matrix columns. Has no extra parameters.
     *                         - ``simple``: drop oldest matrix column. Has no extra parameters.
     *                         - ``svd``: keep only the most significant SVD components.
     *                         Takes an extra parameter, ``to_retain``, which determines the
     *                         number of SVD components to retain when rank reduction is done.
     *                         Default is ``max_rank - 2``.
     *                         
     * @param max_rank int, optional<br>
     *                 Maximum rank for the Broyden matrix.
     *                 Default is infinity (i.e., no rank reduction).
     * @param iter int, optional<br>
     *             Number of iterations to make. If omitted (default), make as many
     *             as required to meet tolerances.
     * @param verbose bool, optional<br>
     *                Print status to stdout on every iteration.
     * @param maxiter int, optional<br>
     *                Maximum number of iterations to make. If more are needed to
     *                meet convergence, `NoConvergence` is raised.
     * @param f_tol float, optional<br>
     *              Absolute tolerance (in max-norm) for the residual.
     *              If omitted, default is 6e-6.
     * @param f_rtol float, optional<br>
     *               Relative tolerance for the residual. If omitted, not used.
     * @param x_tol float, optional<br>
     *              Absolute minimum step size, as determined from the Jacobian
     *              approximation. If the step size is smaller than this, optimization
     *              is terminated as successful. If omitted, not used.
     * @param x_rtol float, optional<br>
     *               Relative minimum step size. If omitted, not used.
     * @param tol_norm function(vector) -&gt; scalar, optional<br>
     *                 Norm to use in convergence check. Default is the maximum norm.
     * @param line_search &#123;None, 'armijo' (default), 'wolfe'&#125;, optional<br>
     *                    Which type of a line search to use to determine the step size in the
     *                    direction given by the Jacobian approximation. Defaults to 'armijo'.
     * @param callback function, optional<br>
     *                 Optional callback function. It is called on every iteration as
     *                 ``callback(x, f)`` where `x` is the current solution and `f`
     *                 the corresponding residual.
     * @param **kw n/a<br>undocumented
     * 
     * @return sol ndarray<br>
     *             An array (of similar array type as `x0`) containing the final solution.
     */
    public final Object broyden2(Object F, Object xin, Object... args) {
        write("optimize.broyden2("+PythonGrammar.toPythonArgs(F),PythonGrammar.toPythonArgs(xin)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Minimize a function over a given range by brute force.
     * 
     * Uses the "brute force" method, i.e., computes the function's value
     * at each point of a multidimensional grid of points, to find the global
     * minimum of the function.
     * 
     * The function is evaluated everywhere in the range with the datatype of the
     * first call to the function, as enforced by the ``vectorize`` NumPy
     * function. The value and type of the function evaluation returned when
     * ``full_output=True`` are affected in addition by the ``finish`` argument
     * (see Notes).
     * 
     * The brute force approach is inefficient because the number of grid points
     * increases exponentially - the number of grid points to evaluate is
     * ``Ns ** len(x)``. Consequently, even with coarse grid spacing, even
     * moderately sized problems can take a long time to run, and/or run into
     * memory limitations.
     * <p>
     * <em>Notes:</em><br>
     * *Note 1*: The program finds the gridpoint at which the lowest value
     * of the objective function occurs. If `finish` is None, that is the
     * point returned. When the global minimum occurs within (or not very far
     * outside) the grid's boundaries, and the grid is fine enough, that
     * point will be in the neighborhood of the global minimum.
     * 
     * However, users often employ some other optimization program to
     * "polish" the gridpoint values, i.e., to seek a more precise
     * (local) minimum near `brute's` best gridpoint.
     * The `brute` function's `finish` option provides a convenient way to do
     * that. Any polishing program used must take `brute's` output as its
     * initial guess as a positional argument, and take `brute's` input values
     * for `args` as keyword arguments, otherwise an error will be raised.
     * It may additionally take `full_output` and/or `disp` as keyword arguments.
     * 
     * `brute` assumes that the `finish` function returns either an
     * `OptimizeResult` object or a tuple in the form:
     * ``(xmin, Jmin, ... , statuscode)``, where ``xmin`` is the minimizing
     * value of the argument, ``Jmin`` is the minimum value of the objective
     * function, "..." may be some other returned values (which are not used
     * by `brute`), and ``statuscode`` is the status code of the `finish` program.
     * 
     * Note that when `finish` is not None, the values returned are those
     * of the `finish` program, *not* the gridpoint ones. Consequently,
     * while `brute` confines its search to the input grid points,
     * the `finish` program's results usually will not coincide with any
     * gridpoint, and may fall outside the grid's boundary. Thus, if a
     * minimum only needs to be found over the provided grid points, make
     * sure to pass in `finish=None`.
     * 
     * *Note 2*: The grid of points is a `numpy.mgrid` object.
     * For `brute` the `ranges` and `Ns` inputs have the following effect.
     * Each component of the `ranges` tuple can be either a slice object or a
     * two-tuple giving a range of values, such as (0, 5). If the component is a
     * slice object, `brute` uses it directly. If the component is a two-tuple
     * range, `brute` internally converts it to a slice object that interpolates
     * `Ns` points from its low-value to its high-value, inclusive.
     * 
     * @param func callable<br>
     *             The objective function to be minimized. Must be in the
     *             form ``f(x, *args)``, where ``x`` is the argument in
     *             the form of a 1-D array and ``args`` is a tuple of any
     *             additional fixed parameters needed to completely specify
     *             the function.
     * @param ranges tuple<br>
     *               Each component of the `ranges` tuple must be either a
     *               "slice object" or a range tuple of the form ``(low, high)``.
     *               The program uses these to create the grid of points on which
     *               the objective function will be computed. See `Note 2` for
     *               more detail.
     * @param args tuple, optional<br>
     *             Any additional fixed parameters needed to completely specify
     *             the function.
     * @param Ns int, optional<br>
     *           Number of grid points along the axes, if not otherwise
     *           specified. See `Note2`.
     * @param full_output bool, optional<br>
     *                    If True, return the evaluation grid and the objective function's
     *                    values on it.
     * @param finish callable, optional<br>
     *               An optimization function that is called with the result of brute force
     *               minimization as initial guess. `finish` should take `func` and
     *               the initial guess as positional arguments, and take `args` as
     *               keyword arguments. It may additionally take `full_output`
     *               and/or `disp` as keyword arguments. Use None if no "polishing"
     *               function is to be used. See Notes for more details.
     * @param disp bool, optional<br>
     *             Set to True to print convergence messages from the `finish` callable.
     * @param workers int or map-like callable, optional<br>
     *                If `workers` is an int the grid is subdivided into `workers`
     *                sections and evaluated in parallel (uses
     *                `multiprocessing.Pool &lt;multiprocessing&gt;`).
     *                Supply `-1` to use all cores available to the Process.
     *                Alternatively supply a map-like callable, such as
     *                `multiprocessing.Pool.map` for evaluating the grid in parallel.
     *                This evaluation is carried out as ``workers(func, iterable)``.
     *                Requires that `func` be pickleable.
     *                
     *                .. versionadded:: 1.3.0
     * 
     * @return (x0,fval,grid,Jout) (ndarray,float,tuple,ndarray)<br>
     *          A 1-D array containing the coordinates of a point at which the
     *          objective function had its minimum value. (See `Note 1` for
     *          which point is returned.)
     *          
     *          Function value at the point `x0`. (Returned when `full_output` is
     *          True.)
     *          
     *          Representation of the evaluation grid. It has the same
     *          length as `x0`. (Returned when `full_output` is True.)
     *          
     *          Function values at each point of the evaluation
     *          grid, i.e., ``Jout = func(*grid)``. (Returned
     *          when `full_output` is True.)
     */
    public final Object brute(Object func, Object ranges, Object... args) {
        write("optimize.brute("+PythonGrammar.toPythonArgs(func),PythonGrammar.toPythonArgs(ranges)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Check the correctness of a gradient function by comparing it against a
     * (forward) finite-difference approximation of the gradient.
     * 
     * @param func callable ``func(x0, *args)``<br>
     *             Function whose derivative is to be checked.
     * @param grad callable ``grad(x0, *args)``<br>
     *             Gradient of `func`.
     * @param x0 ndarray<br>
     *           Points to check `grad` against forward difference approximation of grad
     *           using `func`.
     * @param args \*args, optional<br>
     *             Extra arguments passed to `func` and `grad`.
     * @param epsilon float, optional<br>
     *                Step size used for the finite difference approximation. It defaults to
     *                ``sqrt(np.finfo(float).eps)``, which is approximately 1.49e-08.
     * @param **kwargs n/a<br>undocumented
     * 
     * @return err float<br>
     *             The square root of the sum of squares (i.e., the 2-norm) of the
     *             difference between ``grad(x0, *args)`` and the finite difference
     *             approximation of `grad` using func at the points `x0`.
     */
    public final Object check_grad(Object func, Object grad, Object x0, Object... args) {
        write("optimize.check_grad("+PythonGrammar.toPythonArgs(func),PythonGrammar.toPythonArgs(grad),PythonGrammar.toPythonArgs(x0)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Use non-linear least squares to fit a function, f, to data.
     * 
     * Assumes ``ydata = f(xdata, *params) + eps``.
     * <p>
     * <em>Notes:</em><br>
     * With ``method='lm'``, the algorithm uses the Levenberg-Marquardt algorithm
     * through `leastsq`. Note that this algorithm can only deal with
     * unconstrained problems.
     * 
     * Box constraints can be handled by methods 'trf' and 'dogbox'. Refer to
     * the docstring of `least_squares` for more information.
     * 
     * @param f callable<br>
     *          The model function, f(x, ...). It must take the independent
     *          variable as the first argument and the parameters to fit as
     *          separate remaining arguments.
     * @param xdata array_like or object<br>
     *              The independent variable where the data is measured.
     *              Should usually be an M-length sequence or an (k,M)-shaped array for
     *              functions with k predictors, but can actually be any object.
     * @param ydata array_like<br>
     *              The dependent data, a length M array - nominally ``f(xdata, ...)``.
     * @param p0 array_like, optional<br>
     *           Initial guess for the parameters (length N). If None, then the
     *           initial values will all be 1 (if the number of parameters for the
     *           function can be determined using introspection, otherwise a
     *           ValueError is raised).
     * @param sigma None or M-length sequence or MxM array, optional<br>
     *              Determines the uncertainty in `ydata`. If we define residuals as
     *              ``r = ydata - f(xdata, *popt)``, then the interpretation of `sigma`
     *              depends on its number of dimensions:
     *              
     *              - A 1-D `sigma` should contain values of standard deviations of
     *              errors in `ydata`. In this case, the optimized function is
     *              ``chisq = sum((r / sigma) ** 2)``.
     *              
     *              - A 2-D `sigma` should contain the covariance matrix of
     *              errors in `ydata`. In this case, the optimized function is
     *              ``chisq = r.T @ inv(sigma) @ r``.
     *              
     *              .. versionadded:: 0.19
     *              
     *              None (default) is equivalent of 1-D `sigma` filled with ones.
     * @param absolute_sigma bool, optional<br>
     *                       If True, `sigma` is used in an absolute sense and the estimated parameter
     *                       covariance `pcov` reflects these absolute values.
     *                       
     *                       If False (default), only the relative magnitudes of the `sigma` values matter.
     *                       The returned parameter covariance matrix `pcov` is based on scaling
     *                       `sigma` by a constant factor. This constant is set by demanding that the
     *                       reduced `chisq` for the optimal parameters `popt` when using the
     *                       *scaled* `sigma` equals unity. In other words, `sigma` is scaled to
     *                       match the sample variance of the residuals after the fit. Default is False.
     *                       Mathematically,
     *                       ``pcov(absolute_sigma=False) = pcov(absolute_sigma=True) * chisq(popt)/(M-N)``
     * @param check_finite bool, optional<br>
     *                     If True, check that the input arrays do not contain nans of infs,
     *                     and raise a ValueError if they do. Setting this parameter to
     *                     False may silently produce nonsensical results if the input arrays
     *                     do contain nans. Default is True.
     * @param bounds 2-tuple of array_like, optional<br>
     *               Lower and upper bounds on parameters. Defaults to no bounds.
     *               Each element of the tuple must be either an array with the length equal
     *               to the number of parameters, or a scalar (in which case the bound is
     *               taken to be the same for all parameters). Use ``np.inf`` with an
     *               appropriate sign to disable bounds on all or some parameters.
     *               
     *               .. versionadded:: 0.17
     * @param method &#123;'lm', 'trf', 'dogbox'&#125;, optional<br>
     *               Method to use for optimization. See `least_squares` for more details.
     *               Default is 'lm' for unconstrained problems and 'trf' if `bounds` are
     *               provided. The method 'lm' won't work when the number of observations
     *               is less than the number of variables, use 'trf' or 'dogbox' in this
     *               case.
     *               
     *               .. versionadded:: 0.17
     * @param jac callable, string or None, optional<br>
     *            Function with signature ``jac(x, ...)`` which computes the Jacobian
     *            matrix of the model function with respect to parameters as a dense
     *            array_like structure. It will be scaled according to provided `sigma`.
     *            If None (default), the Jacobian will be estimated numerically.
     *            String keywords for 'trf' and 'dogbox' methods can be used to select
     *            a finite difference scheme, see `least_squares`.
     *            
     *            .. versionadded:: 0.18
     * @param kwargs <br>
     *               Keyword arguments passed to `leastsq` for ``method='lm'`` or
     *               `least_squares` otherwise.
     * 
     * @return (popt,pcov) (array,2-D array)<br>
     *          Optimal values for the parameters so that the sum of the squared
     *          residuals of ``f(xdata, *popt) - ydata`` is minimized.
     *          
     *          The estimated covariance of popt. The diagonals provide the variance
     *          of the parameter estimate. To compute one standard deviation errors
     *          on the parameters use ``perr = np.sqrt(np.diag(pcov))``.
     *          
     *          How the `sigma` parameter affects the estimated covariance
     *          depends on `absolute_sigma` argument, as described above.
     *          
     *          If the Jacobian matrix at the solution doesn't have a full rank, then
     *          'lm' method returns a matrix filled with ``np.inf``, on the other hand
     *          'trf'  and 'dogbox' methods use Moore-Penrose pseudoinverse to compute
     *          the covariance matrix.
     */
    public final Object curve_fit(Object f, Object xdata, Object ydata, Object... args) {
        write("optimize.curve_fit("+PythonGrammar.toPythonArgs(f),PythonGrammar.toPythonArgs(xdata),PythonGrammar.toPythonArgs(ydata)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find a root of a function, using diagonal Broyden Jacobian approximation.
     * 
     * The Jacobian approximation is derived from previous iterations, by
     * retaining only the diagonal of Broyden matrices.
     * 
     * .. warning::
     * 
     * This algorithm may be useful for specific problems, but whether
     * it will work may depend strongly on the problem.
     * 
     * @param F function(x) -&gt; f<br>
     *          Function whose root to find; should take and return an array-like
     *          object.
     * @param xin array_like<br>
     *            Initial guess for the solution
     * @param alpha float, optional<br>
     *              Initial guess for the Jacobian is (-1/alpha).
     * @param iter int, optional<br>
     *             Number of iterations to make. If omitted (default), make as many
     *             as required to meet tolerances.
     * @param verbose bool, optional<br>
     *                Print status to stdout on every iteration.
     * @param maxiter int, optional<br>
     *                Maximum number of iterations to make. If more are needed to
     *                meet convergence, `NoConvergence` is raised.
     * @param f_tol float, optional<br>
     *              Absolute tolerance (in max-norm) for the residual.
     *              If omitted, default is 6e-6.
     * @param f_rtol float, optional<br>
     *               Relative tolerance for the residual. If omitted, not used.
     * @param x_tol float, optional<br>
     *              Absolute minimum step size, as determined from the Jacobian
     *              approximation. If the step size is smaller than this, optimization
     *              is terminated as successful. If omitted, not used.
     * @param x_rtol float, optional<br>
     *               Relative minimum step size. If omitted, not used.
     * @param tol_norm function(vector) -&gt; scalar, optional<br>
     *                 Norm to use in convergence check. Default is the maximum norm.
     * @param line_search &#123;None, 'armijo' (default), 'wolfe'&#125;, optional<br>
     *                    Which type of a line search to use to determine the step size in the
     *                    direction given by the Jacobian approximation. Defaults to 'armijo'.
     * @param callback function, optional<br>
     *                 Optional callback function. It is called on every iteration as
     *                 ``callback(x, f)`` where `x` is the current solution and `f`
     *                 the corresponding residual.
     * @param **kw n/a<br>undocumented
     * 
     * @return sol ndarray<br>
     *             An array (of similar array type as `x0`) containing the final solution.
     */
    public final Object diagbroyden(Object F, Object xin, Object... args) {
        write("optimize.diagbroyden("+PythonGrammar.toPythonArgs(F),PythonGrammar.toPythonArgs(xin)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Finds the global minimum of a multivariate function.
     * 
     * Differential Evolution is stochastic in nature (does not use gradient
     * methods) to find the minimum, and can search large areas of candidate
     * space, but often requires larger numbers of function evaluations than
     * conventional gradient-based techniques.
     * 
     * The algorithm is due to Storn and Price [1]_.
     * <p>
     * <em>Notes:</em><br>
     * Differential evolution is a stochastic population based method that is
     * useful for global optimization problems. At each pass through the population
     * the algorithm mutates each candidate solution by mixing with other candidate
     * solutions to create a trial candidate. There are several strategies [2]_ for
     * creating trial candidates, which suit some problems more than others. The
     * 'best1bin' strategy is a good starting point for many systems. In this
     * strategy two members of the population are randomly chosen. Their difference
     * is used to mutate the best member (the 'best' in 'best1bin'), :math:`b_0`,
     * so far:
     * 
     * .. math::
     * 
     * b' = b_0 + mutation * (population[rand0] - population[rand1])
     * 
     * A trial vector is then constructed. Starting with a randomly chosen ith
     * parameter the trial is sequentially filled (in modulo) with parameters from
     * ``b'`` or the original candidate. The choice of whether to use ``b'`` or the
     * original candidate is made with a binomial distribution (the 'bin' in
     * 'best1bin') - a random number in [0, 1) is generated. If this number is
     * less than the `recombination` constant then the parameter is loaded from
     * ``b'``, otherwise it is loaded from the original candidate. The final
     * parameter is always loaded from ``b'``. Once the trial candidate is built
     * its fitness is assessed. If the trial is better than the original candidate
     * then it takes its place. If it is also better than the best overall
     * candidate it also replaces that.
     * To improve your chances of finding a global minimum use higher `popsize`
     * values, with higher `mutation` and (dithering), but lower `recombination`
     * values. This has the effect of widening the search radius, but slowing
     * convergence.
     * By default the best solution vector is updated continuously within a single
     * iteration (``updating='immediate'``). This is a modification [4]_ of the
     * original differential evolution algorithm which can lead to faster
     * convergence as trial vectors can immediately benefit from improved
     * solutions. To use the original Storn and Price behaviour, updating the best
     * solution once per iteration, set ``updating='deferred'``.
     * 
     * .. versionadded:: 0.15.0
     * 
     * @param func callable<br>
     *             The objective function to be minimized. Must be in the form
     *             ``f(x, *args)``, where ``x`` is the argument in the form of a 1-D array
     *             and ``args`` is a  tuple of any additional fixed parameters needed to
     *             completely specify the function.
     * @param bounds sequence or `Bounds`<br>
     *               Bounds for variables. There are two ways to specify the bounds:
     *               1. Instance of `Bounds` class.
     *               2. ``(min, max)`` pairs for each element in ``x``, defining the finite
     *               lower and upper bounds for the optimizing argument of `func`. It is
     *               required to have ``len(bounds) == len(x)``. ``len(bounds)`` is used
     *               to determine the number of parameters in ``x``.
     * @param args tuple, optional<br>
     *             Any additional fixed parameters needed to
     *             completely specify the objective function.
     * @param strategy str, optional<br>
     *                 The differential evolution strategy to use. Should be one of:
     *                 
     *                 - 'best1bin'
     *                 - 'best1exp'
     *                 - 'rand1exp'
     *                 - 'randtobest1exp'
     *                 - 'currenttobest1exp'
     *                 - 'best2exp'
     *                 - 'rand2exp'
     *                 - 'randtobest1bin'
     *                 - 'currenttobest1bin'
     *                 - 'best2bin'
     *                 - 'rand2bin'
     *                 - 'rand1bin'
     *                 
     *                 The default is 'best1bin'.
     * @param maxiter int, optional<br>
     *                The maximum number of generations over which the entire population is
     *                evolved. The maximum number of function evaluations (with no polishing)
     *                is: ``(maxiter + 1) * popsize * len(x)``
     * @param popsize int, optional<br>
     *                A multiplier for setting the total population size. The population has
     *                ``popsize * len(x)`` individuals. This keyword is overridden if an
     *                initial population is supplied via the `init` keyword. When using
     *                ``init='sobol'`` the population size is calculated as the next power
     *                of 2 after ``popsize * len(x)``.
     * @param tol float, optional<br>
     *            Relative tolerance for convergence, the solving stops when
     *            ``np.std(pop) &lt;= atol + tol * np.abs(np.mean(population_energies))``,
     *            where and `atol` and `tol` are the absolute and relative tolerance
     *            respectively.
     * @param mutation float or tuple(float, float), optional<br>
     *                 The mutation constant. In the literature this is also known as
     *                 differential weight, being denoted by F.
     *                 If specified as a float it should be in the range [0, 2].
     *                 If specified as a tuple ``(min, max)`` dithering is employed. Dithering
     *                 randomly changes the mutation constant on a generation by generation
     *                 basis. The mutation constant for that generation is taken from
     *                 ``U[min, max)``. Dithering can help speed convergence significantly.
     *                 Increasing the mutation constant increases the search radius, but will
     *                 slow down convergence.
     * @param recombination float, optional<br>
     *                      The recombination constant, should be in the range [0, 1]. In the
     *                      literature this is also known as the crossover probability, being
     *                      denoted by CR. Increasing this value allows a larger number of mutants
     *                      to progress into the next generation, but at the risk of population
     *                      stability.
     * @param seed &#123;None, int, `numpy.random.Generator`,<br>
     *             `numpy.random.RandomState`&#125;, optional
     *             
     *             If `seed` is None (or `np.random`), the `numpy.random.RandomState`
     *             singleton is used.
     *             If `seed` is an int, a new ``RandomState`` instance is used,
     *             seeded with `seed`.
     *             If `seed` is already a ``Generator`` or ``RandomState`` instance then
     *             that instance is used.
     *             Specify `seed` for repeatable minimizations.
     * @param disp bool, optional<br>
     *             Prints the evaluated `func` at every iteration.
     * @param callback callable, `callback(xk, convergence=val)`, optional<br>
     *                 A function to follow the progress of the minimization. ``xk`` is
     *                 the current value of ``x0``. ``val`` represents the fractional
     *                 value of the population convergence.  When ``val`` is greater than one
     *                 the function halts. If callback returns `True`, then the minimization
     *                 is halted (any polishing is still carried out).
     * @param polish bool, optional<br>
     *               If True (default), then `scipy.optimize.minimize` with the `L-BFGS-B`
     *               method is used to polish the best population member at the end, which
     *               can improve the minimization slightly. If a constrained problem is
     *               being studied then the `trust-constr` method is used instead.
     * @param init str or array-like, optional<br>
     *             Specify which type of population initialization is performed. Should be
     *             one of:
     *             
     *             - 'latinhypercube'
     *             - 'sobol'
     *             - 'halton'
     *             - 'random'
     *             - array specifying the initial population. The array should have
     *             shape ``(M, len(x))``, where M is the total population size and
     *             len(x) is the number of parameters.
     *             `init` is clipped to `bounds` before use.
     *             
     *             The default is 'latinhypercube'. Latin Hypercube sampling tries to
     *             maximize coverage of the available parameter space.
     *             
     *             'sobol' and 'halton' are superior alternatives and maximize even more
     *             the parameter space. 'sobol' will enforce an initial population
     *             size which is calculated as the next power of 2 after
     *             ``popsize * len(x)``. 'halton' has no requirements but is a bit less
     *             efficient. See `scipy.stats.qmc` for more details.
     *             
     *             'random' initializes the population randomly - this has the drawback
     *             that clustering can occur, preventing the whole of parameter space
     *             being covered. Use of an array to specify a population could be used,
     *             for example, to create a tight bunch of initial guesses in an location
     *             where the solution is known to exist, thereby reducing time for
     *             convergence.
     * @param atol float, optional<br>
     *             Absolute tolerance for convergence, the solving stops when
     *             ``np.std(pop) &lt;= atol + tol * np.abs(np.mean(population_energies))``,
     *             where and `atol` and `tol` are the absolute and relative tolerance
     *             respectively.
     * @param updating &#123;'immediate', 'deferred'&#125;, optional<br>
     *                 If ``'immediate'``, the best solution vector is continuously updated
     *                 within a single generation [4]_. This can lead to faster convergence as
     *                 trial vectors can take advantage of continuous improvements in the best
     *                 solution.
     *                 With ``'deferred'``, the best solution vector is updated once per
     *                 generation. Only ``'deferred'`` is compatible with parallelization, and
     *                 the `workers` keyword can over-ride this option.
     *                 
     *                 .. versionadded:: 1.2.0
     *                 
     * @param workers int or map-like callable, optional<br>
     *                If `workers` is an int the population is subdivided into `workers`
     *                sections and evaluated in parallel
     *                (uses `multiprocessing.Pool &lt;multiprocessing&gt;`).
     *                Supply -1 to use all available CPU cores.
     *                Alternatively supply a map-like callable, such as
     *                `multiprocessing.Pool.map` for evaluating the population in parallel.
     *                This evaluation is carried out as ``workers(func, iterable)``.
     *                This option will override the `updating` keyword to
     *                ``updating='deferred'`` if ``workers != 1``.
     *                Requires that `func` be pickleable.
     *                
     *                .. versionadded:: 1.2.0
     *                
     * @param constraints &#123;NonLinearConstraint, LinearConstraint, Bounds&#125;<br>
     *                    Constraints on the solver, over and above those applied by the `bounds`
     *                    kwd. Uses the approach by Lampinen [5]_.
     *                    
     *                    .. versionadded:: 1.4.0
     *                    
     * @param x0 None or array-like, optional<br>
     *           Provides an initial guess to the minimization. Once the population has
     *           been initialized this vector replaces the first (best) member. This
     *           replacement is done even if `init` is given an initial population.
     *           
     *           .. versionadded:: 1.7.0
     * 
     * @return res OptimizeResult<br>
     *             The optimization result represented as a `OptimizeResult` object.
     *             Important attributes are: ``x`` the solution array, ``success`` a
     *             Boolean flag indicating if the optimizer exited successfully and
     *             ``message`` which describes the cause of the termination. See
     *             `OptimizeResult` for a description of other attributes. If `polish`
     *             was employed, and a lower minimum was obtained by the polishing, then
     *             OptimizeResult also contains the ``jac`` attribute.
     *             If the eventual solution does not satisfy the applied constraints
     *             ``success`` will be `False`.
     */
    public final Object differential_evolution(Object func, Object bounds, Object... args) {
        write("optimize.differential_evolution("+PythonGrammar.toPythonArgs(func),PythonGrammar.toPythonArgs(bounds)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find the global minimum of a function using Dual Annealing.
     * <p>
     * <em>Notes:</em><br>
     * This function implements the Dual Annealing optimization. This stochastic
     * approach derived from [3]_ combines the generalization of CSA (Classical
     * Simulated Annealing) and FSA (Fast Simulated Annealing) [1]_ [2]_ coupled
     * to a strategy for applying a local search on accepted locations [4]_.
     * An alternative implementation of this same algorithm is described in [5]_
     * and benchmarks are presented in [6]_. This approach introduces an advanced
     * method to refine the solution found by the generalized annealing
     * process. This algorithm uses a distorted Cauchy-Lorentz visiting
     * distribution, with its shape controlled by the parameter :math:`q_{v}`
     * 
     * .. math::
     * 
     * g_{q_{v}}(\Delta x(t)) \propto \frac{ \
     * \left[T_{q_{v}}(t) \right]^{-\frac{D}{3-q_{v}}}}{ \
     * \left[{1+(q_{v}-1)\frac{(\Delta x(t))^{2}} { \
     * \left[T_{q_{v}}(t)\right]^{\frac{2}{3-q_{v}}}}}\right]^{ \
     * \frac{1}{q_{v}-1}+\frac{D-1}{2}}}
     * 
     * Where :math:`t` is the artificial time. This visiting distribution is used
     * to generate a trial jump distance :math:`\Delta x(t)` of variable
     * :math:`x(t)` under artificial temperature :math:`T_{q_{v}}(t)`.
     * 
     * From the starting point, after calling the visiting distribution
     * function, the acceptance probability is computed as follows:
     * 
     * .. math::
     * 
     * p_{q_{a}} = \min{\{1,\left[1-(1-q_{a}) \beta \Delta E \right]^{ \
     * \frac{1}{1-q_{a}}}\}}
     * 
     * Where :math:`q_{a}` is a acceptance parameter. For :math:`q_{a}<1`, zero
     * acceptance probability is assigned to the cases where
     * 
     * .. math::
     * 
     * [1-(1-q_{a}) \beta \Delta E] < 0
     * 
     * The artificial temperature :math:`T_{q_{v}}(t)` is decreased according to
     * 
     * .. math::
     * 
     * T_{q_{v}}(t) = T_{q_{v}}(1) \frac{2^{q_{v}-1}-1}{\left( \
     * 1 + t\right)^{q_{v}-1}-1}
     * 
     * Where :math:`q_{v}` is the visiting parameter.
     * 
     * .. versionadded:: 1.2.0
     * 
     * @param func callable<br>
     *             The objective function to be minimized. Must be in the form
     *             ``f(x, *args)``, where ``x`` is the argument in the form of a 1-D array
     *             and ``args`` is a  tuple of any additional fixed parameters needed to
     *             completely specify the function.
     * @param bounds sequence, shape (n, 2)<br>
     *               Bounds for variables.  ``(min, max)`` pairs for each element in ``x``,
     *               defining bounds for the objective function parameter.
     * @param args tuple, optional<br>
     *             Any additional fixed parameters needed to completely specify the
     *             objective function.
     * @param maxiter int, optional<br>
     *                The maximum number of global search iterations. Default value is 1000.
     * @param local_search_options dict, optional<br>
     *                             Extra keyword arguments to be passed to the local minimizer
     *                             (`minimize`). Some important options could be:
     *                             ``method`` for the minimizer method to use and ``args`` for
     *                             objective function additional arguments.
     * @param initial_temp float, optional<br>
     *                     The initial temperature, use higher values to facilitates a wider
     *                     search of the energy landscape, allowing dual_annealing to escape
     *                     local minima that it is trapped in. Default value is 5230. Range is
     *                     (0.01, 5.e4].
     * @param restart_temp_ratio float, optional<br>
     *                           During the annealing process, temperature is decreasing, when it
     *                           reaches ``initial_temp * restart_temp_ratio``, the reannealing process
     *                           is triggered. Default value of the ratio is 2e-5. Range is (0, 1).
     * @param visit float, optional<br>
     *              Parameter for visiting distribution. Default value is 2.62. Higher
     *              values give the visiting distribution a heavier tail, this makes
     *              the algorithm jump to a more distant region. The value range is (1, 3].
     * @param accept float, optional<br>
     *               Parameter for acceptance distribution. It is used to control the
     *               probability of acceptance. The lower the acceptance parameter, the
     *               smaller the probability of acceptance. Default value is -5.0 with
     *               a range (-1e4, -5].
     * @param maxfun int, optional<br>
     *               Soft limit for the number of objective function calls. If the
     *               algorithm is in the middle of a local search, this number will be
     *               exceeded, the algorithm will stop just after the local search is
     *               done. Default value is 1e7.
     * @param seed &#123;None, int, `numpy.random.Generator`,<br>
     *             `numpy.random.RandomState`&#125;, optional
     *             
     *             If `seed` is None (or `np.random`), the `numpy.random.RandomState`
     *             singleton is used.
     *             If `seed` is an int, a new ``RandomState`` instance is used,
     *             seeded with `seed`.
     *             If `seed` is already a ``Generator`` or ``RandomState`` instance then
     *             that instance is used.
     *             Specify `seed` for repeatable minimizations. The random numbers
     *             generated with this seed only affect the visiting distribution function
     *             and new coordinates generation.
     * @param no_local_search bool, optional<br>
     *                        If `no_local_search` is set to True, a traditional Generalized
     *                        Simulated Annealing will be performed with no local search
     *                        strategy applied.
     * @param callback callable, optional<br>
     *                 A callback function with signature ``callback(x, f, context)``,
     *                 which will be called for all minima found.
     *                 ``x`` and ``f`` are the coordinates and function value of the
     *                 latest minimum found, and ``context`` has value in [0, 1, 2], with the
     *                 following meaning:
     *                 
     *                 - 0: minimum detected in the annealing process.
     *                 - 1: detection occurred in the local search process.
     *                 - 2: detection done in the dual annealing process.
     *                 
     *                 If the callback implementation returns True, the algorithm will stop.
     * @param x0 ndarray, shape(n,), optional<br>
     *           Coordinates of a single N-D starting point.
     * 
     * @return res OptimizeResult<br>
     *             The optimization result represented as a `OptimizeResult` object.
     *             Important attributes are: ``x`` the solution array, ``fun`` the value
     *             of the function at the solution, and ``message`` which describes the
     *             cause of the termination.
     *             See `OptimizeResult` for a description of other attributes.
     */
    public final Object dual_annealing(Object func, Object bounds, Object... args) {
        write("optimize.dual_annealing("+PythonGrammar.toPythonArgs(func),PythonGrammar.toPythonArgs(bounds)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find a root of a function, using a tuned diagonal Jacobian approximation.
     * 
     * The Jacobian matrix is diagonal and is tuned on each iteration.
     * 
     * .. warning::
     * 
     * This algorithm may be useful for specific problems, but whether
     * it will work may depend strongly on the problem.
     * 
     * @param F function(x) -&gt; f<br>
     *          Function whose root to find; should take and return an array-like
     *          object.
     * @param xin array_like<br>
     *            Initial guess for the solution
     * @param alpha float, optional<br>
     *              Initial Jacobian approximation is (-1/alpha).
     * @param alphamax float, optional<br>
     *                 The entries of the diagonal Jacobian are kept in the range
     *                 ``[alpha, alphamax]``.
     * @param iter int, optional<br>
     *             Number of iterations to make. If omitted (default), make as many
     *             as required to meet tolerances.
     * @param verbose bool, optional<br>
     *                Print status to stdout on every iteration.
     * @param maxiter int, optional<br>
     *                Maximum number of iterations to make. If more are needed to
     *                meet convergence, `NoConvergence` is raised.
     * @param f_tol float, optional<br>
     *              Absolute tolerance (in max-norm) for the residual.
     *              If omitted, default is 6e-6.
     * @param f_rtol float, optional<br>
     *               Relative tolerance for the residual. If omitted, not used.
     * @param x_tol float, optional<br>
     *              Absolute minimum step size, as determined from the Jacobian
     *              approximation. If the step size is smaller than this, optimization
     *              is terminated as successful. If omitted, not used.
     * @param x_rtol float, optional<br>
     *               Relative minimum step size. If omitted, not used.
     * @param tol_norm function(vector) -&gt; scalar, optional<br>
     *                 Norm to use in convergence check. Default is the maximum norm.
     * @param line_search &#123;None, 'armijo' (default), 'wolfe'&#125;, optional<br>
     *                    Which type of a line search to use to determine the step size in the
     *                    direction given by the Jacobian approximation. Defaults to 'armijo'.
     * @param callback function, optional<br>
     *                 Optional callback function. It is called on every iteration as
     *                 ``callback(x, f)`` where `x` is the current solution and `f`
     *                 the corresponding residual.
     * @param **kw n/a<br>undocumented
     * 
     * @return sol ndarray<br>
     *             An array (of similar array type as `x0`) containing the final solution.
     */
    public final Object excitingmixing(Object F, Object xin, Object... args) {
        write("optimize.excitingmixing("+PythonGrammar.toPythonArgs(F),PythonGrammar.toPythonArgs(xin)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find a fixed point of the function.
     * 
     * Given a function of one or more variables and a starting point, find a
     * fixed point of the function: i.e., where ``func(x0) == x0``.
     * 
     * @param func function<br>
     *             Function to evaluate.
     * @param x0 array_like<br>
     *           Fixed point of function.
     * @param args tuple, optional<br>
     *             Extra arguments to `func`.
     * @param xtol float, optional<br>
     *             Convergence tolerance, defaults to 1e-08.
     * @param maxiter int, optional<br>
     *                Maximum number of iterations, defaults to 500.
     * @param method &#123;"del2", "iteration"&#125;, optional<br>
     *               Method of finding the fixed-point, defaults to "del2",
     *               which uses Steffensen's Method with Aitken's ``Del^2``
     *               convergence acceleration [1]_. The "iteration" method simply iterates
     *               the function until convergence is detected, without attempting to
     *               accelerate the convergence.
     */
    public final Object fixed_point(Object func, Object x0, Object... args) {
        write("optimize.fixed_point("+PythonGrammar.toPythonArgs(func),PythonGrammar.toPythonArgs(x0)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Minimize a function using the downhill simplex algorithm.
     * 
     * This algorithm only uses function values, not derivatives or second
     * derivatives.
     * <p>
     * <em>Notes:</em><br>
     * Uses a Nelder-Mead simplex algorithm to find the minimum of function of
     * one or more variables.
     * 
     * This algorithm has a long history of successful use in applications.
     * But it will usually be slower than an algorithm that uses first or
     * second derivative information. In practice, it can have poor
     * performance in high-dimensional problems and is not robust to
     * minimizing complicated functions. Additionally, there currently is no
     * complete theory describing when the algorithm will successfully
     * converge to the minimum, or how fast it will if it does. Both the ftol and
     * xtol criteria must be met for convergence.
     * 
     * @param func callable func(x,*args)<br>
     *             The objective function to be minimized.
     * @param x0 ndarray<br>
     *           Initial guess.
     * @param args tuple, optional<br>
     *             Extra arguments passed to func, i.e., ``f(x,*args)``.
     * @param xtol float, optional<br>
     *             Absolute error in xopt between iterations that is acceptable for
     *             convergence.
     * @param ftol number, optional<br>
     *             Absolute error in func(xopt) between iterations that is acceptable for
     *             convergence.
     * @param maxiter int, optional<br>
     *                Maximum number of iterations to perform.
     * @param maxfun number, optional<br>
     *               Maximum number of function evaluations to make.
     * @param full_output bool, optional<br>
     *                    Set to True if fopt and warnflag outputs are desired.
     * @param disp bool, optional<br>
     *             Set to True to print convergence messages.
     * @param retall bool, optional<br>
     *               Set to True to return list of solutions at each iteration.
     * @param callback callable, optional<br>
     *                 Called after each iteration, as callback(xk), where xk is the
     *                 current parameter vector.
     * @param initial_simplex array_like of shape (N + 1, N), optional<br>
     *                        Initial simplex. If given, overrides `x0`.
     *                        ``initial_simplex[j,:]`` should contain the coordinates of
     *                        the jth vertex of the ``N+1`` vertices in the simplex, where
     *                        ``N`` is the dimension.
     * 
     * @return (xopt,fopt,iter,funcalls,warnflag,allvecs) (ndarray,float,int,int,int,list)<br>
     *          Parameter that minimizes function.
     *          
     *          Value of function at minimum: ``fopt = func(xopt)``.
     *          
     *          Number of iterations performed.
     *          
     *          Number of function calls made.
     *          
     *          1 : Maximum number of function evaluations made.
     *          2 : Maximum number of iterations reached.
     *          
     *          Solution at each iteration.
     */
    public final Object fmin(Object func, Object x0, Object... args) {
        write("optimize.fmin("+PythonGrammar.toPythonArgs(func),PythonGrammar.toPythonArgs(x0)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Minimize a function using the BFGS algorithm.
     * <p>
     * <em>Notes:</em><br>
     * Optimize the function, `f`, whose gradient is given by `fprime`
     * using the quasi-Newton method of Broyden, Fletcher, Goldfarb,
     * and Shanno (BFGS).
     * 
     * @param f callable ``f(x,*args)``<br>
     *          Objective function to be minimized.
     * @param x0 ndarray<br>
     *           Initial guess.
     * @param fprime callable ``f'(x,*args)``, optional<br>
     *               Gradient of f.
     * @param args tuple, optional<br>
     *             Extra arguments passed to f and fprime.
     * @param gtol float, optional<br>
     *             Gradient norm must be less than `gtol` before successful termination.
     * @param norm float, optional<br>
     *             Order of norm (Inf is max, -Inf is min)
     * @param epsilon int or ndarray, optional<br>
     *                If `fprime` is approximated, use this value for the step size.
     * @param callback callable, optional<br>
     *                 An optional user-supplied function to call after each
     *                 iteration. Called as ``callback(xk)``, where ``xk`` is the
     *                 current parameter vector.
     * @param maxiter int, optional<br>
     *                Maximum number of iterations to perform.
     * @param full_output bool, optional<br>
     *                    If True, return ``fopt``, ``func_calls``, ``grad_calls``, and
     *                    ``warnflag`` in addition to ``xopt``.
     * @param disp bool, optional<br>
     *             Print convergence message if True.
     * @param retall bool, optional<br>
     *               Return a list of results at each iteration if True.
     * 
     * @return (xopt,fopt,gopt,Bopt,func_calls,grad_calls,warnflag,allvecs) (ndarray,float,ndarray,ndarray,int,int,integer,list)<br>
     *          Parameters which minimize f, i.e., ``f(xopt) == fopt``.
     *          
     *          Minimum value.
     *          
     *          Value of gradient at minimum, f'(xopt), which should be near 0.
     *          
     *          Value of 1/f''(xopt), i.e., the inverse Hessian matrix.
     *          
     *          Number of function_calls made.
     *          
     *          Number of gradient calls made.
     *          
     *          1 : Maximum number of iterations exceeded.
     *          2 : Gradient and/or function calls not changing.
     *          3 : NaN result encountered.
     *          
     *          The value of `xopt` at each iteration. Only returned if `retall` is
     *          True.
     */
    public final Object fmin_bfgs(Object f, Object x0, Object... args) {
        write("optimize.fmin_bfgs("+PythonGrammar.toPythonArgs(f),PythonGrammar.toPythonArgs(x0)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Minimize a function using a nonlinear conjugate gradient algorithm.
     * <p>
     * <em>Notes:</em><br>
     * This conjugate gradient algorithm is based on that of Polak and Ribiere
     * [1]_.
     * 
     * Conjugate gradient methods tend to work better when:
     * 
     * 1. `f` has a unique global minimizing point, and no local minima or
     * other stationary points,
     * 2. `f` is, at least locally, reasonably well approximated by a
     * quadratic function of the variables,
     * 3. `f` is continuous and has a continuous gradient,
     * 4. `fprime` is not too large, e.g., has a norm less than 1000,
     * 5. The initial guess, `x0`, is reasonably close to `f` 's global
     * minimizing point, `xopt`.
     * 
     * @param f callable, ``f(x, *args)``<br>
     *          Objective function to be minimized. Here `x` must be a 1-D array of
     *          the variables that are to be changed in the search for a minimum, and
     *          `args` are the other (fixed) parameters of `f`.
     * @param x0 ndarray<br>
     *           A user-supplied initial estimate of `xopt`, the optimal value of `x`.
     *           It must be a 1-D array of values.
     * @param fprime callable, ``fprime(x, *args)``, optional<br>
     *               A function that returns the gradient of `f` at `x`. Here `x` and `args`
     *               are as described above for `f`. The returned value must be a 1-D array.
     *               Defaults to None, in which case the gradient is approximated
     *               numerically (see `epsilon`, below).
     * @param args tuple, optional<br>
     *             Parameter values passed to `f` and `fprime`. Must be supplied whenever
     *             additional fixed parameters are needed to completely specify the
     *             functions `f` and `fprime`.
     * @param gtol float, optional<br>
     *             Stop when the norm of the gradient is less than `gtol`.
     * @param norm float, optional<br>
     *             Order to use for the norm of the gradient
     *             (``-np.Inf`` is min, ``np.Inf`` is max).
     * @param epsilon float or ndarray, optional<br>
     *                Step size(s) to use when `fprime` is approximated numerically. Can be a
     *                scalar or a 1-D array. Defaults to ``sqrt(eps)``, with eps the
     *                floating point machine precision.  Usually ``sqrt(eps)`` is about
     *                1.5e-8.
     * @param maxiter int, optional<br>
     *                Maximum number of iterations to perform. Default is ``200 * len(x0)``.
     * @param full_output bool, optional<br>
     *                    If True, return `fopt`, `func_calls`, `grad_calls`, and `warnflag` in
     *                    addition to `xopt`.  See the Returns section below for additional
     *                    information on optional return values.
     * @param disp bool, optional<br>
     *             If True, return a convergence message, followed by `xopt`.
     * @param retall bool, optional<br>
     *               If True, add to the returned values the results of each iteration.
     * @param callback callable, optional<br>
     *                 An optional user-supplied function, called after each iteration.
     *                 Called as ``callback(xk)``, where ``xk`` is the current value of `x0`.
     * 
     * @return (xopt,fopt,func_calls,grad_calls,warnflag,allvecs) (ndarray,float, optional,int, optional,int, optional,int, optional,list of ndarray, optional)<br>
     *          Parameters which minimize f, i.e., ``f(xopt) == fopt``.
     *          
     *          Minimum value found, f(xopt). Only returned if `full_output` is True.
     *          
     *          The number of function_calls made. Only returned if `full_output`
     *          is True.
     *          
     *          The number of gradient calls made. Only returned if `full_output` is
     *          True.
     *          
     *          Integer value with warning status, only returned if `full_output` is
     *          True.
     *          
     *          0 : Success.
     *          
     *          1 : The maximum number of iterations was exceeded.
     *          
     *          2 : Gradient and/or function calls were not changing. May indicate
     *          that precision was lost, i.e., the routine did not converge.
     *          
     *          3 : NaN result encountered.
     *          
     *          
     *          List of arrays, containing the results at each iteration.
     *          Only returned if `retall` is True.
     */
    public final Object fmin_cg(Object f, Object x0, Object... args) {
        write("optimize.fmin_cg("+PythonGrammar.toPythonArgs(f),PythonGrammar.toPythonArgs(x0)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Minimize a function using the Constrained Optimization By Linear
     * Approximation (COBYLA) method. This method wraps a FORTRAN
     * implementation of the algorithm.
     * <p>
     * <em>Notes:</em><br>
     * This algorithm is based on linear approximations to the objective
     * function and each constraint. We briefly describe the algorithm.
     * 
     * Suppose the function is being minimized over k variables. At the
     * jth iteration the algorithm has k+1 points v_1, ..., v_(k+1),
     * an approximate solution x_j, and a radius RHO_j.
     * (i.e., linear plus a constant) approximations to the objective
     * function and constraint functions such that their function values
     * agree with the linear approximation on the k+1 points v_1,.., v_(k+1).
     * This gives a linear program to solve (where the linear approximations
     * of the constraint functions are constrained to be non-negative).
     * 
     * However, the linear approximations are likely only good
     * approximations near the current simplex, so the linear program is
     * given the further requirement that the solution, which
     * will become x_(j+1), must be within RHO_j from x_j. RHO_j only
     * decreases, never increases. The initial RHO_j is rhobeg and the
     * final RHO_j is rhoend. In this way COBYLA's iterations behave
     * like a trust region algorithm.
     * 
     * Additionally, the linear program may be inconsistent, or the
     * approximation may give poor improvement. For details about
     * how these issues are resolved, as well as how the points v_i are
     * updated, refer to the source code or the references below.
     * 
     * @param func callable<br>
     *             Function to minimize. In the form func(x, \*args).
     * @param x0 ndarray<br>
     *           Initial guess.
     * @param cons sequence<br>
     *             Constraint functions; must all be ``&gt;=0`` (a single function
     *             if only 1 constraint). Each function takes the parameters `x`
     *             as its first argument, and it can return either a single number or
     *             an array or list of numbers.
     * @param args tuple, optional<br>
     *             Extra arguments to pass to function.
     * @param consargs tuple, optional<br>
     *                 Extra arguments to pass to constraint functions (default of None means
     *                 use same extra arguments as those passed to func).
     *                 Use ``()`` for no extra arguments.
     * @param rhobeg float, optional<br>
     *               Reasonable initial changes to the variables.
     * @param rhoend float, optional<br>
     *               Final accuracy in the optimization (not precisely guaranteed). This
     *               is a lower bound on the size of the trust region.
     * @param disp &#123;0, 1, 2, 3&#125;, optional<br>
     *             Controls the frequency of output; 0 implies no output.
     * @param maxfun int, optional<br>
     *               Maximum number of function evaluations.
     * @param catol float, optional<br>
     *              Absolute tolerance for constraint violations.
     * 
     * @return x ndarray<br>
     *           The argument that minimises `f`.
     */
    public final Object fmin_cobyla(Object func, Object x0, Object cons, Object... args) {
        write("optimize.fmin_cobyla("+PythonGrammar.toPythonArgs(func),PythonGrammar.toPythonArgs(x0),PythonGrammar.toPythonArgs(cons)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Minimize a function func using the L-BFGS-B algorithm.
     * <p>
     * <em>Notes:</em><br>
     * License of L-BFGS-B (FORTRAN code):
     * 
     * The version included here (in fortran code) is 3.0
     * (released April 25, 2011). It was written by Ciyou Zhu, Richard Byrd,
     * and Jorge Nocedal <nocedal@ece.nwu.edu>. It carries the following
     * condition for use:
     * 
     * This software is freely available, but we expect that all publications
     * describing work using this software, or all commercial products using it,
     * quote at least one of the references given below. This software is released
     * under the BSD License.
     * 
     * @param func callable f(x,*args)<br>
     *             Function to minimize.
     * @param x0 ndarray<br>
     *           Initial guess.
     * @param fprime callable fprime(x,*args), optional<br>
     *               The gradient of `func`. If None, then `func` returns the function
     *               value and the gradient (``f, g = func(x, *args)``), unless
     *               `approx_grad` is True in which case `func` returns only ``f``.
     * @param args sequence, optional<br>
     *             Arguments to pass to `func` and `fprime`.
     * @param approx_grad bool, optional<br>
     *                    Whether to approximate the gradient numerically (in which case
     *                    `func` returns only the function value).
     * @param bounds list, optional<br>
     *               ``(min, max)`` pairs for each element in ``x``, defining
     *               the bounds on that parameter. Use None or +-inf for one of ``min`` or
     *               ``max`` when there is no bound in that direction.
     * @param m int, optional<br>
     *          The maximum number of variable metric corrections
     *          used to define the limited memory matrix. (The limited memory BFGS
     *          method does not store the full hessian but uses this many terms in an
     *          approximation to it.)
     * @param factr float, optional<br>
     *              The iteration stops when
     *              ``(f^k - f^&#123;k+1&#125;)/max&#123;|f^k|,|f^&#123;k+1&#125;|,1&#125; &lt;= factr * eps``,
     *              where ``eps`` is the machine precision, which is automatically
     *              generated by the code. Typical values for `factr` are: 1e12 for
     *              low accuracy; 1e7 for moderate accuracy; 10.0 for extremely
     *              high accuracy. See Notes for relationship to `ftol`, which is exposed
     *              (instead of `factr`) by the `scipy.optimize.minimize` interface to
     *              L-BFGS-B.
     * @param pgtol float, optional<br>
     *              The iteration will stop when
     *              ``max&#123;|proj g_i | i = 1, ..., n&#125; &lt;= pgtol``
     *              where ``pg_i`` is the i-th component of the projected gradient.
     * @param epsilon float, optional<br>
     *                Step size used when `approx_grad` is True, for numerically
     *                calculating the gradient
     * @param iprint int, optional<br>
     *               Controls the frequency of output. ``iprint &lt; 0`` means no output;
     *               ``iprint = 0``    print only one line at the last iteration;
     *               ``0 &lt; iprint &lt; 99`` print also f and ``|proj g|`` every iprint iterations;
     *               ``iprint = 99``   print details of every iteration except n-vectors;
     *               ``iprint = 100``  print also the changes of active set and final x;
     *               ``iprint &gt; 100``  print details of every iteration including x and g.
     * @param disp int, optional<br>
     *             If zero, then no output. If a positive number, then this over-rides
     *             `iprint` (i.e., `iprint` gets the value of `disp`).
     * @param maxfun int, optional<br>
     *               Maximum number of function evaluations.
     * @param maxiter int, optional<br>
     *                Maximum number of iterations.
     * @param callback callable, optional<br>
     *                 Called after each iteration, as ``callback(xk)``, where ``xk`` is the
     *                 current parameter vector.
     * @param maxls int, optional<br>
     *              Maximum number of line search steps (per iteration). Default is 20.
     * 
     * @return (x,f,d) (array_like,float,dict)<br>
     *          Estimated position of the minimum.
     *          
     *          Value of `func` at the minimum.
     *          
     *          Information dictionary.
     *          
     *          * d['warnflag'] is
     *          
     *          - 0 if converged,
     *          - 1 if too many function evaluations or too many iterations,
     *          - 2 if stopped for another reason, given in d['task']
     *          
     *          * d['grad'] is the gradient at the minimum (should be 0 ish)
     *          * d['funcalls'] is the number of function calls made.
     *          * d['nit'] is the number of iterations.
     */
    public final Object fmin_l_bfgs_b(Object func, Object x0, Object... args) {
        write("optimize.fmin_l_bfgs_b("+PythonGrammar.toPythonArgs(func),PythonGrammar.toPythonArgs(x0)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Unconstrained minimization of a function using the Newton-CG method.
     * <p>
     * <em>Notes:</em><br>
     * Only one of `fhess_p` or `fhess` need to be given.  If `fhess`
     * is provided, then `fhess_p` will be ignored. If neither `fhess`
     * nor `fhess_p` is provided, then the hessian product will be
     * approximated using finite differences on `fprime`. `fhess_p`
     * must compute the hessian times an arbitrary vector. If it is not
     * given, finite-differences on `fprime` are used to compute
     * it.
     * 
     * Newton-CG methods are also called truncated Newton methods. This
     * function differs from scipy.optimize.fmin_tnc because
     * 
     * 1. scipy.optimize.fmin_ncg is written purely in Python using NumPy
     * and scipy while scipy.optimize.fmin_tnc calls a C function.
     * 2. scipy.optimize.fmin_ncg is only for unconstrained minimization
     * while scipy.optimize.fmin_tnc is for unconstrained minimization
     * or box constrained minimization. (Box constraints give
     * lower and upper bounds for each variable separately.)
     * 
     * @param f callable ``f(x, *args)``<br>
     *          Objective function to be minimized.
     * @param x0 ndarray<br>
     *           Initial guess.
     * @param fprime callable ``f'(x, *args)``<br>
     *               Gradient of f.
     * @param fhess_p callable ``fhess_p(x, p, *args)``, optional<br>
     *                Function which computes the Hessian of f times an
     *                arbitrary vector, p.
     * @param fhess callable ``fhess(x, *args)``, optional<br>
     *              Function to compute the Hessian matrix of f.
     * @param args tuple, optional<br>
     *             Extra arguments passed to f, fprime, fhess_p, and fhess
     *             (the same set of extra arguments is supplied to all of
     *             these functions).
     * @param epsilon float or ndarray, optional<br>
     *                If fhess is approximated, use this value for the step size.
     * @param callback callable, optional<br>
     *                 An optional user-supplied function which is called after
     *                 each iteration. Called as callback(xk), where xk is the
     *                 current parameter vector.
     * @param avextol float, optional<br>
     *                Convergence is assumed when the average relative error in
     *                the minimizer falls below this amount.
     * @param maxiter int, optional<br>
     *                Maximum number of iterations to perform.
     * @param full_output bool, optional<br>
     *                    If True, return the optional outputs.
     * @param disp bool, optional<br>
     *             If True, print convergence message.
     * @param retall bool, optional<br>
     *               If True, return a list of results at each iteration.
     * 
     * @return (xopt,fopt,fcalls,gcalls,hcalls,warnflag,allvecs) (ndarray,float,int,int,int,int,list)<br>
     *          Parameters which minimize f, i.e., ``f(xopt) == fopt``.
     *          
     *          Value of the function at xopt, i.e., ``fopt = f(xopt)``.
     *          
     *          Number of function calls made.
     *          
     *          Number of gradient calls made.
     *          
     *          Number of Hessian calls made.
     *          
     *          Warnings generated by the algorithm.
     *          1 : Maximum number of iterations exceeded.
     *          2 : Line search failure (precision loss).
     *          3 : NaN result encountered.
     *          
     *          The result at each iteration, if retall is True (see below).
     */
    public final Object fmin_ncg(Object f, Object x0, Object fprime, Object... args) {
        write("optimize.fmin_ncg("+PythonGrammar.toPythonArgs(f),PythonGrammar.toPythonArgs(x0),PythonGrammar.toPythonArgs(fprime)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Minimize a function using modified Powell's method.
     * 
     * This method only uses function values, not derivatives.
     * <p>
     * <em>Notes:</em><br>
     * Uses a modification of Powell's method to find the minimum of
     * a function of N variables. Powell's method is a conjugate
     * direction method.
     * 
     * The algorithm has two loops. The outer loop merely iterates over the inner
     * loop. The inner loop minimizes over each current direction in the direction
     * set. At the end of the inner loop, if certain conditions are met, the
     * direction that gave the largest decrease is dropped and replaced with the
     * difference between the current estimated x and the estimated x from the
     * beginning of the inner-loop.
     * 
     * The technical conditions for replacing the direction of greatest
     * increase amount to checking that
     * 
     * 1. No further gain can be made along the direction of greatest increase
     * from that iteration.
     * 2. The direction of greatest increase accounted for a large sufficient
     * fraction of the decrease in the function value from that iteration of
     * the inner loop.
     * 
     * @param func callable f(x,*args)<br>
     *             Objective function to be minimized.
     * @param x0 ndarray<br>
     *           Initial guess.
     * @param args tuple, optional<br>
     *             Extra arguments passed to func.
     * @param xtol float, optional<br>
     *             Line-search error tolerance.
     * @param ftol float, optional<br>
     *             Relative error in ``func(xopt)`` acceptable for convergence.
     * @param maxiter int, optional<br>
     *                Maximum number of iterations to perform.
     * @param maxfun int, optional<br>
     *               Maximum number of function evaluations to make.
     * @param full_output bool, optional<br>
     *                    If True, ``fopt``, ``xi``, ``direc``, ``iter``, ``funcalls``, and
     *                    ``warnflag`` are returned.
     * @param disp bool, optional<br>
     *             If True, print convergence messages.
     * @param retall bool, optional<br>
     *               If True, return a list of the solution at each iteration.
     * @param callback callable, optional<br>
     *                 An optional user-supplied function, called after each
     *                 iteration.  Called as ``callback(xk)``, where ``xk`` is the
     *                 current parameter vector.
     * @param direc ndarray, optional<br>
     *              Initial fitting step and parameter order set as an (N, N) array, where N
     *              is the number of fitting parameters in `x0`. Defaults to step size 1.0
     *              fitting all parameters simultaneously (``np.eye((N, N))``). To
     *              prevent initial consideration of values in a step or to change initial
     *              step size, set to 0 or desired step size in the Jth position in the Mth
     *              block, where J is the position in `x0` and M is the desired evaluation
     *              step, with steps being evaluated in index order. Step size and ordering
     *              will change freely as minimization proceeds.
     * 
     * @return (xopt,fopt,direc,iter,funcalls,warnflag,allvecs) (ndarray,number,ndarray,int,int,int,list)<br>
     *          Parameter which minimizes `func`.
     *          
     *          Value of function at minimum: ``fopt = func(xopt)``.
     *          
     *          Current direction set.
     *          
     *          Number of iterations.
     *          
     *          Number of function calls made.
     *          
     *          Integer warning flag:
     *          1 : Maximum number of function evaluations.
     *          2 : Maximum number of iterations.
     *          3 : NaN result encountered.
     *          4 : The result is out of the provided bounds.
     *          
     *          List of solutions at each iteration.
     */
    public final Object fmin_powell(Object func, Object x0, Object... args) {
        write("optimize.fmin_powell("+PythonGrammar.toPythonArgs(func),PythonGrammar.toPythonArgs(x0)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Minimize a function using Sequential Least Squares Programming
     * 
     * Python interface function for the SLSQP Optimization subroutine
     * originally implemented by Dieter Kraft.
     * <p>
     * <em>Notes:</em><br>
     * Exit modes are defined as follows ::
     * 
     * -1 : Gradient evaluation required (g & a)
     * 0 : Optimization terminated successfully
     * 1 : Function evaluation required (f & c)
     * 2 : More equality constraints than independent variables
     * 3 : More than 3*n iterations in LSQ subproblem
     * 4 : Inequality constraints incompatible
     * 5 : Singular matrix E in LSQ subproblem
     * 6 : Singular matrix C in LSQ subproblem
     * 7 : Rank-deficient equality constraint subproblem HFTI
     * 8 : Positive directional derivative for linesearch
     * 9 : Iteration limit reached
     * 
     * @param func callable f(x,*args)<br>
     *             Objective function.  Must return a scalar.
     * @param x0 1-D ndarray of float<br>
     *           Initial guess for the independent variable(s).
     * @param eqcons list, optional<br>
     *               A list of functions of length n such that
     *               eqcons[j](x,*args) == 0.0 in a successfully optimized
     *               problem.
     * @param f_eqcons callable f(x,*args), optional<br>
     *                 Returns a 1-D array in which each element must equal 0.0 in a
     *                 successfully optimized problem. If f_eqcons is specified,
     *                 eqcons is ignored.
     * @param ieqcons list, optional<br>
     *                A list of functions of length n such that
     *                ieqcons[j](x,*args) &gt;= 0.0 in a successfully optimized
     *                problem.
     * @param f_ieqcons callable f(x,*args), optional<br>
     *                  Returns a 1-D ndarray in which each element must be greater or
     *                  equal to 0.0 in a successfully optimized problem. If
     *                  f_ieqcons is specified, ieqcons is ignored.
     * @param bounds list, optional<br>
     *               A list of tuples specifying the lower and upper bound
     *               for each independent variable [(xl0, xu0),(xl1, xu1),...]
     *               Infinite values will be interpreted as large floating values.
     * @param fprime callable `f(x,*args)`, optional<br>
     *               A function that evaluates the partial derivatives of func.
     * @param fprime_eqcons callable `f(x,*args)`, optional<br>
     *                      A function of the form `f(x, *args)` that returns the m by n
     *                      array of equality constraint normals. If not provided,
     *                      the normals will be approximated. The array returned by
     *                      fprime_eqcons should be sized as ( len(eqcons), len(x0) ).
     * @param fprime_ieqcons callable `f(x,*args)`, optional<br>
     *                       A function of the form `f(x, *args)` that returns the m by n
     *                       array of inequality constraint normals. If not provided,
     *                       the normals will be approximated. The array returned by
     *                       fprime_ieqcons should be sized as ( len(ieqcons), len(x0) ).
     * @param args sequence, optional<br>
     *             Additional arguments passed to func and fprime.
     * @param iter int, optional<br>
     *             The maximum number of iterations.
     * @param acc float, optional<br>
     *            Requested accuracy.
     * @param iprint int, optional<br>
     *               The verbosity of fmin_slsqp :
     *               
     *               * iprint &lt;= 0 : Silent operation
     *               * iprint == 1 : Print summary upon completion (default)
     *               * iprint &gt;= 2 : Print status of each iterate and summary
     * @param disp int, optional<br>
     *             Overrides the iprint interface (preferred).
     * @param full_output bool, optional<br>
     *                    If False, return only the minimizer of func (default).
     *                    Otherwise, output final objective function and summary
     *                    information.
     * @param epsilon float, optional<br>
     *                The step size for finite-difference derivative estimates.
     * @param callback callable, optional<br>
     *                 Called after each iteration, as ``callback(x)``, where ``x`` is the
     *                 current parameter vector.
     * 
     * @return (out,fx,its,imode,smode) (ndarray of float,ndarray of float, if full_output is true,int, if full_output is true,int, if full_output is true,string, if full_output is true)<br>
     *          The final minimizer of func.
     *          
     *          The final value of the objective function.
     *          
     *          The number of iterations.
     *          
     *          The exit mode from the optimizer (see below).
     *          
     *          Message describing the exit mode from the optimizer.
     */
    public final Object fmin_slsqp(Object func, Object x0, Object... args) {
        write("optimize.fmin_slsqp("+PythonGrammar.toPythonArgs(func),PythonGrammar.toPythonArgs(x0)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Minimize a function with variables subject to bounds, using
     * gradient information in a truncated Newton algorithm. This
     * method wraps a C implementation of the algorithm.
     * <p>
     * <em>Notes:</em><br>
     * The underlying algorithm is truncated Newton, also called
     * Newton Conjugate-Gradient. This method differs from
     * scipy.optimize.fmin_ncg in that
     * 
     * 1. it wraps a C implementation of the algorithm
     * 2. it allows each variable to be given an upper and lower bound.
     * 
     * The algorithm incorporates the bound constraints by determining
     * the descent direction as in an unconstrained truncated Newton,
     * but never taking a step-size large enough to leave the space
     * of feasible x's. The algorithm keeps track of a set of
     * currently active constraints, and ignores them when computing
     * the minimum allowable step size. (The x's associated with the
     * active constraint are kept fixed.) If the maximum allowable
     * step size is zero then a new constraint is added. At the end
     * of each iteration one of the constraints may be deemed no
     * longer active and removed. A constraint is considered
     * no longer active is if it is currently active
     * but the gradient for that variable points inward from the
     * constraint. The specific constraint removed is the one
     * associated with the variable of largest index whose
     * constraint is no longer active.
     * 
     * Return codes are defined as follows::
     * 
     * -1 : Infeasible (lower bound > upper bound)
     * 0 : Local minimum reached (|pg| ~= 0)
     * 1 : Converged (|f_n-f_(n-1)| ~= 0)
     * 2 : Converged (|x_n-x_(n-1)| ~= 0)
     * 3 : Max. number of function evaluations reached
     * 4 : Linear search failed
     * 5 : All lower bounds are equal to the upper bounds
     * 6 : Unable to progress
     * 7 : User requested end of minimization
     * 
     * @param func callable ``func(x, *args)``<br>
     *             Function to minimize.  Must do one of:
     *             
     *             1. Return f and g, where f is the value of the function and g its
     *             gradient (a list of floats).
     *             
     *             2. Return the function value but supply gradient function
     *             separately as `fprime`.
     *             
     *             3. Return the function value and set ``approx_grad=True``.
     *             
     *             If the function returns None, the minimization
     *             is aborted.
     * @param x0 array_like<br>
     *           Initial estimate of minimum.
     * @param fprime callable ``fprime(x, *args)``, optional<br>
     *               Gradient of `func`. If None, then either `func` must return the
     *               function value and the gradient (``f,g = func(x, *args)``)
     *               or `approx_grad` must be True.
     * @param args tuple, optional<br>
     *             Arguments to pass to function.
     * @param approx_grad bool, optional<br>
     *                    If true, approximate the gradient numerically.
     * @param bounds list, optional<br>
     *               (min, max) pairs for each element in x0, defining the
     *               bounds on that parameter. Use None or +/-inf for one of
     *               min or max when there is no bound in that direction.
     * @param epsilon float, optional<br>
     *                Used if approx_grad is True. The stepsize in a finite
     *                difference approximation for fprime.
     * @param scale array_like, optional<br>
     *              Scaling factors to apply to each variable. If None, the
     *              factors are up-low for interval bounded variables and
     *              1+|x| for the others. Defaults to None.
     * @param offset array_like, optional<br>
     *               Value to subtract from each variable. If None, the
     *               offsets are (up+low)/2 for interval bounded variables
     *               and x for the others.
     * @param messages int, optional<br>
     *                 Bit mask used to select messages display during
     *                 minimization values defined in the MSGS dict. Defaults to
     *                 MGS_ALL.
     * @param disp int, optional<br>
     *             Integer interface to messages. 0 = no message, 5 = all messages
     * @param maxCGit int, optional<br>
     *                Maximum number of hessian*vector evaluations per main
     *                iteration. If maxCGit == 0, the direction chosen is
     *                -gradient if maxCGit &lt; 0, maxCGit is set to
     *                max(1,min(50,n/2)). Defaults to -1.
     * @param maxfun int, optional<br>
     *               Maximum number of function evaluation. If None, maxfun is
     *               set to max(100, 10*len(x0)). Defaults to None.
     * @param eta float, optional<br>
     *            Severity of the line search. If &lt; 0 or &gt; 1, set to 0.25.
     *            Defaults to -1.
     * @param stepmx float, optional<br>
     *               Maximum step for the line search. May be increased during
     *               call. If too small, it will be set to 10.0. Defaults to 0.
     * @param accuracy float, optional<br>
     *                 Relative precision for finite difference calculations. If
     *                 &lt;= machine_precision, set to sqrt(machine_precision).
     *                 Defaults to 0.
     * @param fmin float, optional<br>
     *             Minimum function value estimate. Defaults to 0.
     * @param ftol float, optional<br>
     *             Precision goal for the value of f in the stopping criterion.
     *             If ftol &lt; 0.0, ftol is set to 0.0 defaults to -1.
     * @param xtol float, optional<br>
     *             Precision goal for the value of x in the stopping
     *             criterion (after applying x scaling factors). If xtol &lt;
     *             0.0, xtol is set to sqrt(machine_precision). Defaults to
     *             -1.
     * @param pgtol float, optional<br>
     *              Precision goal for the value of the projected gradient in
     *              the stopping criterion (after applying x scaling factors).
     *              If pgtol &lt; 0.0, pgtol is set to 1e-2 * sqrt(accuracy).
     *              Setting it to 0.0 is not recommended. Defaults to -1.
     * @param rescale float, optional<br>
     *                Scaling factor (in log10) used to trigger f value
     *                rescaling. If 0, rescale at each iteration. If a large
     *                value, never rescale. If &lt; 0, rescale is set to 1.3.
     * @param callback callable, optional<br>
     *                 Called after each iteration, as callback(xk), where xk is the
     *                 current parameter vector.
     * 
     * @return (x,nfeval,rc) (ndarray,int,int)<br>
     *          The solution.
     *          
     *          The number of function evaluations.
     *          
     *          Return code, see below
     */
    public final Object fmin_tnc(Object func, Object x0, Object... args) {
        write("optimize.fmin_tnc("+PythonGrammar.toPythonArgs(func),PythonGrammar.toPythonArgs(x0)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Bounded minimization for scalar functions.
     * <p>
     * <em>Notes:</em><br>
     * Finds a local minimizer of the scalar function `func` in the
     * interval x1 < xopt < x2 using Brent's method. (See `brent`
     * for auto-bracketing.)
     * 
     * @param func callable f(x,*args)<br>
     *             Objective function to be minimized (must accept and return scalars).
     * @param x1 float or array scalar<br>
     *           The optimization bounds.
     * @param x2 float or array scalar<br>
     *           The optimization bounds.
     * @param args tuple, optional<br>
     *             Extra arguments passed to function.
     * @param xtol float, optional<br>
     *             The convergence tolerance.
     * @param maxfun int, optional<br>
     *               Maximum number of function evaluations allowed.
     * @param full_output bool, optional<br>
     *                    If True, return optional outputs.
     * @param disp int, optional<br>
     *             If non-zero, print messages.
     *             0 : no message printing.
     *             1 : non-convergence notification messages only.
     *             2 : print a message on convergence too.
     *             3 : print iteration results.
     * 
     * @return (xopt,fval,ierr,numfunc) (ndarray,number,int,int)<br>
     *          Parameters (over given interval) which minimize the
     *          objective function.
     *          
     *          The function value at the minimum point.
     *          
     *          An error flag (0 if converged, 1 if maximum number of
     *          function calls reached).
     *          
     *          The number of function calls made.
     */
    public final Object fminbound(Object func, Object x1, Object x2, Object... args) {
        write("optimize.fminbound("+PythonGrammar.toPythonArgs(func),PythonGrammar.toPythonArgs(x1),PythonGrammar.toPythonArgs(x2)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find the roots of a function.
     * 
     * Return the roots of the (non-linear) equations defined by
     * ``func(x) = 0`` given a starting estimate.
     * <p>
     * <em>Notes:</em><br>
     * ``fsolve`` is a wrapper around MINPACK's hybrd and hybrj algorithms.
     * 
     * @param func callable ``f(x, *args)``<br>
     *             A function that takes at least one (possibly vector) argument,
     *             and returns a value of the same length.
     * @param x0 ndarray<br>
     *           The starting estimate for the roots of ``func(x) = 0``.
     * @param args tuple, optional<br>
     *             Any extra arguments to `func`.
     * @param fprime callable ``f(x, *args)``, optional<br>
     *               A function to compute the Jacobian of `func` with derivatives
     *               across the rows. By default, the Jacobian will be estimated.
     * @param full_output bool, optional<br>
     *                    If True, return optional outputs.
     * @param col_deriv bool, optional<br>
     *                  Specify whether the Jacobian function computes derivatives down
     *                  the columns (faster, because there is no transpose operation).
     * @param xtol float, optional<br>
     *             The calculation will terminate if the relative error between two
     *             consecutive iterates is at most `xtol`.
     * @param maxfev int, optional<br>
     *               The maximum number of calls to the function. If zero, then
     *               ``100*(N+1)`` is the maximum where N is the number of elements
     *               in `x0`.
     * @param band tuple, optional<br>
     *             If set to a two-sequence containing the number of sub- and
     *             super-diagonals within the band of the Jacobi matrix, the
     *             Jacobi matrix is considered banded (only for ``fprime=None``).
     * @param epsfcn float, optional<br>
     *               A suitable step length for the forward-difference
     *               approximation of the Jacobian (for ``fprime=None``). If
     *               `epsfcn` is less than the machine precision, it is assumed
     *               that the relative errors in the functions are of the order of
     *               the machine precision.
     * @param factor float, optional<br>
     *               A parameter determining the initial step bound
     *               (``factor * || diag * x||``). Should be in the interval
     *               ``(0.1, 100)``.
     * @param diag sequence, optional<br>
     *             N positive entries that serve as a scale factors for the
     *             variables.
     * 
     * @return (x,infodict,ier,mesg) (ndarray,dict,int,str)<br>
     *          The solution (or the result of the last iteration for
     *          an unsuccessful call).
     *          
     *          A dictionary of optional outputs with the keys:
     *          
     *          ``nfev``
     *          number of function calls
     *          ``njev``
     *          number of Jacobian calls
     *          ``fvec``
     *          function evaluated at the output
     *          ``fjac``
     *          the orthogonal matrix, q, produced by the QR
     *          factorization of the final approximate Jacobian
     *          matrix, stored column wise
     *          ``r``
     *          upper triangular matrix produced by QR factorization
     *          of the same matrix
     *          ``qtf``
     *          the vector ``(transpose(q) * fvec)``
     *          
     *          
     *          An integer flag.  Set to 1 if a solution was found, otherwise refer
     *          to `mesg` for more information.
     *          
     *          If no solution is found, `mesg` details the cause of failure.
     */
    public final Object fsolve(Object func, Object x0, Object... args) {
        write("optimize.fsolve("+PythonGrammar.toPythonArgs(func),PythonGrammar.toPythonArgs(x0)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the minimum of a function of one variable using golden section
     * method.
     * 
     * Given a function of one variable and a possible bracketing interval,
     * return the minimum of the function isolated to a fractional precision of
     * tol.
     * <p>
     * <em>Notes:</em><br>
     * Uses analog of bisection method to decrease the bracketed
     * interval.
     * 
     * @param func callable func(x,*args)<br>
     *             Objective function to minimize.
     * @param args tuple, optional<br>
     *             Additional arguments (if present), passed to func.
     * @param brack tuple, optional<br>
     *              Triple (a,b,c), where (a&lt;b&lt;c) and func(b) &lt;
     *              func(a),func(c). If bracket consists of two numbers (a,
     *              c), then they are assumed to be a starting interval for a
     *              downhill bracket search (see `bracket`); it doesn't always
     *              mean that obtained solution will satisfy a&lt;=x&lt;=c.
     * @param tol float, optional<br>
     *            x tolerance stop criterion
     * @param full_output bool, optional<br>
     *                    If True, return optional outputs.
     * @param maxiter int<br>
     *                Maximum number of iterations to perform.
     */
    public final Object golden(Object func, Object... args) {
        write("optimize.golden("+PythonGrammar.toPythonArgs(func)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Solve a nonlinear least-squares problem with bounds on the variables.
     * 
     * Given the residuals f(x) (an m-D real function of n real
     * variables) and the loss function rho(s) (a scalar function), `least_squares`
     * finds a local minimum of the cost function F(x)::
     * 
     * minimize F(x) = 0.5 * sum(rho(f_i(x)**2), i = 0, ..., m - 1)
     * subject to lb <= x <= ub
     * 
     * The purpose of the loss function rho(s) is to reduce the influence of
     * outliers on the solution.
     * <p>
     * <em>Notes:</em><br>
     * Method 'lm' (Levenberg-Marquardt) calls a wrapper over least-squares
     * algorithms implemented in MINPACK (lmder, lmdif). It runs the
     * Levenberg-Marquardt algorithm formulated as a trust-region type algorithm.
     * The implementation is based on paper [JJMore]_, it is very robust and
     * efficient with a lot of smart tricks. It should be your first choice
     * for unconstrained problems. Note that it doesn't support bounds. Also,
     * it doesn't work when m < n.
     * 
     * Method 'trf' (Trust Region Reflective) is motivated by the process of
     * solving a system of equations, which constitute the first-order optimality
     * condition for a bound-constrained minimization problem as formulated in
     * [STIR]_. The algorithm iteratively solves trust-region subproblems
     * augmented by a special diagonal quadratic term and with trust-region shape
     * determined by the distance from the bounds and the direction of the
     * gradient. This enhancements help to avoid making steps directly into bounds
     * and efficiently explore the whole space of variables. To further improve
     * convergence, the algorithm considers search directions reflected from the
     * bounds. To obey theoretical requirements, the algorithm keeps iterates
     * strictly feasible. With dense Jacobians trust-region subproblems are
     * solved by an exact method very similar to the one described in [JJMore]_
     * (and implemented in MINPACK). The difference from the MINPACK
     * implementation is that a singular value decomposition of a Jacobian
     * matrix is done once per iteration, instead of a QR decomposition and series
     * of Givens rotation eliminations. For large sparse Jacobians a 2-D subspace
     * approach of solving trust-region subproblems is used [STIR]_, [Byrd]_.
     * The subspace is spanned by a scaled gradient and an approximate
     * Gauss-Newton solution delivered by `scipy.sparse.linalg.lsmr`. When no
     * constraints are imposed the algorithm is very similar to MINPACK and has
     * generally comparable performance. The algorithm works quite robust in
     * unbounded and bounded problems, thus it is chosen as a default algorithm.
     * 
     * Method 'dogbox' operates in a trust-region framework, but considers
     * rectangular trust regions as opposed to conventional ellipsoids [Voglis]_.
     * The intersection of a current trust region and initial bounds is again
     * rectangular, so on each iteration a quadratic minimization problem subject
     * to bound constraints is solved approximately by Powell's dogleg method
     * [NumOpt]_. The required Gauss-Newton step can be computed exactly for
     * dense Jacobians or approximately by `scipy.sparse.linalg.lsmr` for large
     * sparse Jacobians. The algorithm is likely to exhibit slow convergence when
     * the rank of Jacobian is less than the number of variables. The algorithm
     * often outperforms 'trf' in bounded problems with a small number of
     * variables.
     * 
     * Robust loss functions are implemented as described in [BA]_. The idea
     * is to modify a residual vector and a Jacobian matrix on each iteration
     * such that computed gradient and Gauss-Newton Hessian approximation match
     * the true gradient and Hessian approximation of the cost function. Then
     * the algorithm proceeds in a normal way, i.e., robust loss functions are
     * implemented as a simple wrapper over standard least-squares algorithms.
     * 
     * .. versionadded:: 0.17.0
     * 
     * @param fun callable<br>
     *            Function which computes the vector of residuals, with the signature
     *            ``fun(x, *args, **kwargs)``, i.e., the minimization proceeds with
     *            respect to its first argument. The argument ``x`` passed to this
     *            function is an ndarray of shape (n,) (never a scalar, even for n=1).
     *            It must allocate and return a 1-D array_like of shape (m,) or a scalar.
     *            If the argument ``x`` is complex or the function ``fun`` returns
     *            complex residuals, it must be wrapped in a real function of real
     *            arguments, as shown at the end of the Examples section.
     * @param x0 array_like with shape (n,) or float<br>
     *           Initial guess on independent variables. If float, it will be treated
     *           as a 1-D array with one element.
     * @param jac &#123;'2-point', '3-point', 'cs', callable&#125;, optional<br>
     *            Method of computing the Jacobian matrix (an m-by-n matrix, where
     *            element (i, j) is the partial derivative of f[i] with respect to
     *            x[j]). The keywords select a finite difference scheme for numerical
     *            estimation. The scheme '3-point' is more accurate, but requires
     *            twice as many operations as '2-point' (default). The scheme 'cs'
     *            uses complex steps, and while potentially the most accurate, it is
     *            applicable only when `fun` correctly handles complex inputs and
     *            can be analytically continued to the complex plane. Method 'lm'
     *            always uses the '2-point' scheme. If callable, it is used as
     *            ``jac(x, *args, **kwargs)`` and should return a good approximation
     *            (or the exact value) for the Jacobian as an array_like (np.atleast_2d
     *            is applied), a sparse matrix (csr_matrix preferred for performance) or
     *            a `scipy.sparse.linalg.LinearOperator`.
     * @param bounds 2-tuple of array_like, optional<br>
     *               Lower and upper bounds on independent variables. Defaults to no bounds.
     *               Each array must match the size of `x0` or be a scalar, in the latter
     *               case a bound will be the same for all variables. Use ``np.inf`` with
     *               an appropriate sign to disable bounds on all or some variables.
     * @param method &#123;'trf', 'dogbox', 'lm'&#125;, optional<br>
     *               Algorithm to perform minimization.
     *               
     *               * 'trf' : Trust Region Reflective algorithm, particularly suitable
     *               for large sparse problems with bounds. Generally robust method.
     *               * 'dogbox' : dogleg algorithm with rectangular trust regions,
     *               typical use case is small problems with bounds. Not recommended
     *               for problems with rank-deficient Jacobian.
     *               * 'lm' : Levenberg-Marquardt algorithm as implemented in MINPACK.
     *               Doesn't handle bounds and sparse Jacobians. Usually the most
     *               efficient method for small unconstrained problems.
     *               
     *               Default is 'trf'. See Notes for more information.
     * @param ftol float or None, optional<br>
     *             Tolerance for termination by the change of the cost function. Default
     *             is 1e-8. The optimization process is stopped when ``dF &lt; ftol * F``,
     *             and there was an adequate agreement between a local quadratic model and
     *             the true model in the last step.
     *             
     *             If None and 'method' is not 'lm', the termination by this condition is
     *             disabled. If 'method' is 'lm', this tolerance must be higher than
     *             machine epsilon.
     * @param xtol float or None, optional<br>
     *             Tolerance for termination by the change of the independent variables.
     *             Default is 1e-8. The exact condition depends on the `method` used:
     *             
     *             * For 'trf' and 'dogbox' : ``norm(dx) &lt; xtol * (xtol + norm(x))``.
     *             * For 'lm' : ``Delta &lt; xtol * norm(xs)``, where ``Delta`` is
     *             a trust-region radius and ``xs`` is the value of ``x``
     *             scaled according to `x_scale` parameter (see below).
     *             
     *             If None and 'method' is not 'lm', the termination by this condition is
     *             disabled. If 'method' is 'lm', this tolerance must be higher than
     *             machine epsilon.
     * @param gtol float or None, optional<br>
     *             Tolerance for termination by the norm of the gradient. Default is 1e-8.
     *             The exact condition depends on a `method` used:
     *             
     *             * For 'trf' : ``norm(g_scaled, ord=np.inf) &lt; gtol``, where
     *             ``g_scaled`` is the value of the gradient scaled to account for
     *             the presence of the bounds [STIR]_.
     *             * For 'dogbox' : ``norm(g_free, ord=np.inf) &lt; gtol``, where
     *             ``g_free`` is the gradient with respect to the variables which
     *             are not in the optimal state on the boundary.
     *             * For 'lm' : the maximum absolute value of the cosine of angles
     *             between columns of the Jacobian and the residual vector is less
     *             than `gtol`, or the residual vector is zero.
     *             
     *             If None and 'method' is not 'lm', the termination by this condition is
     *             disabled. If 'method' is 'lm', this tolerance must be higher than
     *             machine epsilon.
     * @param x_scale array_like or 'jac', optional<br>
     *                Characteristic scale of each variable. Setting `x_scale` is equivalent
     *                to reformulating the problem in scaled variables ``xs = x / x_scale``.
     *                An alternative view is that the size of a trust region along jth
     *                dimension is proportional to ``x_scale[j]``. Improved convergence may
     *                be achieved by setting `x_scale` such that a step of a given size
     *                along any of the scaled variables has a similar effect on the cost
     *                function. If set to 'jac', the scale is iteratively updated using the
     *                inverse norms of the columns of the Jacobian matrix (as described in
     *                [JJMore]_).
     * @param loss str or callable, optional<br>
     *             Determines the loss function. The following keyword values are allowed:
     *             
     *             * 'linear' (default) : ``rho(z) = z``. Gives a standard
     *             least-squares problem.
     *             * 'soft_l1' : ``rho(z) = 2 * ((1 + z)**0.5 - 1)``. The smooth
     *             approximation of l1 (absolute value) loss. Usually a good
     *             choice for robust least squares.
     *             * 'huber' : ``rho(z) = z if z &lt;= 1 else 2*z**0.5 - 1``. Works
     *             similarly to 'soft_l1'.
     *             * 'cauchy' : ``rho(z) = ln(1 + z)``. Severely weakens outliers
     *             influence, but may cause difficulties in optimization process.
     *             * 'arctan' : ``rho(z) = arctan(z)``. Limits a maximum loss on
     *             a single residual, has properties similar to 'cauchy'.
     *             
     *             If callable, it must take a 1-D ndarray ``z=f**2`` and return an
     *             array_like with shape (3, m) where row 0 contains function values,
     *             row 1 contains first derivatives and row 2 contains second
     *             derivatives. Method 'lm' supports only 'linear' loss.
     * @param f_scale float, optional<br>
     *                Value of soft margin between inlier and outlier residuals, default
     *                is 1.0. The loss function is evaluated as follows
     *                ``rho_(f**2) = C**2 * rho(f**2 / C**2)``, where ``C`` is `f_scale`,
     *                and ``rho`` is determined by `loss` parameter. This parameter has
     *                no effect with ``loss='linear'``, but for other `loss` values it is
     *                of crucial importance.
     * @param max_nfev None or int, optional<br>
     *                 Maximum number of function evaluations before the termination.
     *                 If None (default), the value is chosen automatically:
     *                 
     *                 * For 'trf' and 'dogbox' : 100 * n.
     *                 * For 'lm' :  100 * n if `jac` is callable and 100 * n * (n + 1)
     *                 otherwise (because 'lm' counts function calls in Jacobian
     *                 estimation).
     *                 
     * @param diff_step None or array_like, optional<br>
     *                  Determines the relative step size for the finite difference
     *                  approximation of the Jacobian. The actual step is computed as
     *                  ``x * diff_step``. If None (default), then `diff_step` is taken to be
     *                  a conventional "optimal" power of machine epsilon for the finite
     *                  difference scheme used [NR]_.
     * @param tr_solver &#123;None, 'exact', 'lsmr'&#125;, optional<br>
     *                  Method for solving trust-region subproblems, relevant only for 'trf'
     *                  and 'dogbox' methods.
     *                  
     *                  * 'exact' is suitable for not very large problems with dense
     *                  Jacobian matrices. The computational complexity per iteration is
     *                  comparable to a singular value decomposition of the Jacobian
     *                  matrix.
     *                  * 'lsmr' is suitable for problems with sparse and large Jacobian
     *                  matrices. It uses the iterative procedure
     *                  `scipy.sparse.linalg.lsmr` for finding a solution of a linear
     *                  least-squares problem and only requires matrix-vector product
     *                  evaluations.
     *                  
     *                  If None (default), the solver is chosen based on the type of Jacobian
     *                  returned on the first iteration.
     * @param tr_options dict, optional<br>
     *                   Keyword options passed to trust-region solver.
     *                   
     *                   * ``tr_solver='exact'``: `tr_options` are ignored.
     *                   * ``tr_solver='lsmr'``: options for `scipy.sparse.linalg.lsmr`.
     *                   Additionally,  ``method='trf'`` supports  'regularize' option
     *                   (bool, default is True), which adds a regularization term to the
     *                   normal equation, which improves convergence if the Jacobian is
     *                   rank-deficient [Byrd]_ (eq. 3.4).
     *                   
     * @param jac_sparsity &#123;None, array_like, sparse matrix&#125;, optional<br>
     *                     Defines the sparsity structure of the Jacobian matrix for finite
     *                     difference estimation, its shape must be (m, n). If the Jacobian has
     *                     only few non-zero elements in *each* row, providing the sparsity
     *                     structure will greatly speed up the computations [Curtis]_. A zero
     *                     entry means that a corresponding element in the Jacobian is identically
     *                     zero. If provided, forces the use of 'lsmr' trust-region solver.
     *                     If None (default), then dense differencing will be used. Has no effect
     *                     for 'lm' method.
     * @param verbose &#123;0, 1, 2&#125;, optional<br>
     *                Level of algorithm's verbosity:
     *                
     *                * 0 (default) : work silently.
     *                * 1 : display a termination report.
     *                * 2 : display progress during iterations (not supported by 'lm'
     *                method).
     *                
     * @param args tuple and dict, optional<br>
     *             Additional arguments passed to `fun` and `jac`. Both empty by default.
     *             The calling signature is ``fun(x, *args, **kwargs)`` and the same for
     *             `jac`.
     * @param kwargs tuple and dict, optional<br>
     *               Additional arguments passed to `fun` and `jac`. Both empty by default.
     *               The calling signature is ``fun(x, *args, **kwargs)`` and the same for
     *               `jac`.
     * 
     * @return result OptimizeResult<br>
     *                `OptimizeResult` with the following fields defined:
     *                
     *                x : ndarray, shape (n,)
     *                Solution found.
     *                cost : float
     *                Value of the cost function at the solution.
     *                fun : ndarray, shape (m,)
     *                Vector of residuals at the solution.
     *                jac : ndarray, sparse matrix or LinearOperator, shape (m, n)
     *                Modified Jacobian matrix at the solution, in the sense that J^T J
     *                is a Gauss-Newton approximation of the Hessian of the cost function.
     *                The type is the same as the one used by the algorithm.
     *                grad : ndarray, shape (m,)
     *                Gradient of the cost function at the solution.
     *                optimality : float
     *                First-order optimality measure. In unconstrained problems, it is
     *                always the uniform norm of the gradient. In constrained problems,
     *                it is the quantity which was compared with `gtol` during iterations.
     *                active_mask : ndarray of int, shape (n,)
     *                Each component shows whether a corresponding constraint is active
     *                (that is, whether a variable is at the bound):
     *                
     *                *  0 : a constraint is not active.
     *                * -1 : a lower bound is active.
     *                *  1 : an upper bound is active.
     *                
     *                Might be somewhat arbitrary for 'trf' method as it generates a
     *                sequence of strictly feasible iterates and `active_mask` is
     *                determined within a tolerance threshold.
     *                nfev : int
     *                Number of function evaluations done. Methods 'trf' and 'dogbox' do
     *                not count function calls for numerical Jacobian approximation, as
     *                opposed to 'lm' method.
     *                njev : int or None
     *                Number of Jacobian evaluations done. If numerical Jacobian
     *                approximation is used in 'lm' method, it is set to None.
     *                status : int
     *                The reason for algorithm termination:
     *                
     *                * -1 : improper input parameters status returned from MINPACK.
     *                *  0 : the maximum number of function evaluations is exceeded.
     *                *  1 : `gtol` termination condition is satisfied.
     *                *  2 : `ftol` termination condition is satisfied.
     *                *  3 : `xtol` termination condition is satisfied.
     *                *  4 : Both `ftol` and `xtol` termination conditions are satisfied.
     *                
     *                message : str
     *                Verbal description of the termination reason.
     *                success : bool
     *                True if one of the convergence criteria is satisfied (`status` &gt; 0).
     */
    public final Object least_squares(Object fun, Object x0, Object... args) {
        write("optimize.least_squares("+PythonGrammar.toPythonArgs(fun),PythonGrammar.toPythonArgs(x0)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Minimize the sum of squares of a set of equations.
     * 
     * ::
     * 
     * x = arg min(sum(func(y)**2,axis=0))
     * y
     * <p>
     * <em>Notes:</em><br>
     * "leastsq" is a wrapper around MINPACK's lmdif and lmder algorithms.
     * 
     * cov_x is a Jacobian approximation to the Hessian of the least squares
     * objective function.
     * This approximation assumes that the objective function is based on the
     * difference between some observed target data (ydata) and a (non-linear)
     * function of the parameters `f(xdata, params)` ::
     * 
     * func(params) = ydata - f(xdata, params)
     * 
     * so that the objective function is ::
     * 
     * min   sum((ydata - f(xdata, params))**2, axis=0)
     * params
     * 
     * The solution, `x`, is always a 1-D array, regardless of the shape of `x0`,
     * or whether `x0` is a scalar.
     * 
     * @param func callable<br>
     *             Should take at least one (possibly length ``N`` vector) argument and
     *             returns ``M`` floating point numbers. It must not return NaNs or
     *             fitting might fail. ``M`` must be greater than or equal to ``N``.
     * @param x0 ndarray<br>
     *           The starting estimate for the minimization.
     * @param args tuple, optional<br>
     *             Any extra arguments to func are placed in this tuple.
     * @param Dfun callable, optional<br>
     *             A function or method to compute the Jacobian of func with derivatives
     *             across the rows. If this is None, the Jacobian will be estimated.
     * @param full_output bool, optional<br>
     *                    non-zero to return all optional outputs.
     * @param col_deriv bool, optional<br>
     *                  non-zero to specify that the Jacobian function computes derivatives
     *                  down the columns (faster, because there is no transpose operation).
     * @param ftol float, optional<br>
     *             Relative error desired in the sum of squares.
     * @param xtol float, optional<br>
     *             Relative error desired in the approximate solution.
     * @param gtol float, optional<br>
     *             Orthogonality desired between the function vector and the columns of
     *             the Jacobian.
     * @param maxfev int, optional<br>
     *               The maximum number of calls to the function. If `Dfun` is provided,
     *               then the default `maxfev` is 100*(N+1) where N is the number of elements
     *               in x0, otherwise the default `maxfev` is 200*(N+1).
     * @param epsfcn float, optional<br>
     *               A variable used in determining a suitable step length for the forward-
     *               difference approximation of the Jacobian (for Dfun=None).
     *               Normally the actual step length will be sqrt(epsfcn)*x
     *               If epsfcn is less than the machine precision, it is assumed that the
     *               relative errors are of the order of the machine precision.
     * @param factor float, optional<br>
     *               A parameter determining the initial step bound
     *               (``factor * || diag * x||``). Should be in interval ``(0.1, 100)``.
     * @param diag sequence, optional<br>
     *             N positive entries that serve as a scale factors for the variables.
     * 
     * @return (x,cov_x,infodict,mesg,ier) (ndarray,ndarray,dict,str,int)<br>
     *          The solution (or the result of the last iteration for an unsuccessful
     *          call).
     *          
     *          The inverse of the Hessian. `fjac` and `ipvt` are used to construct an
     *          estimate of the Hessian. A value of None indicates a singular matrix,
     *          which means the curvature in parameters `x` is numerically flat. To
     *          obtain the covariance matrix of the parameters `x`, `cov_x` must be
     *          multiplied by the variance of the residuals -- see curve_fit.
     *          
     *          a dictionary of optional outputs with the keys:
     *          
     *          ``nfev``
     *          The number of function calls
     *          ``fvec``
     *          The function evaluated at the output
     *          ``fjac``
     *          A permutation of the R matrix of a QR
     *          factorization of the final approximate
     *          Jacobian matrix, stored column wise.
     *          Together with ipvt, the covariance of the
     *          estimate can be approximated.
     *          ``ipvt``
     *          An integer array of length N which defines
     *          a permutation matrix, p, such that
     *          fjac*p = q*r, where r is upper triangular
     *          with diagonal elements of nonincreasing
     *          magnitude. Column j of p is column ipvt(j)
     *          of the identity matrix.
     *          ``qtf``
     *          The vector (transpose(q) * fvec).
     *          
     *          
     *          A string message giving information about the cause of failure.
     *          
     *          An integer flag. If it is equal to 1, 2, 3 or 4, the solution was
     *          found. Otherwise, the solution was not found. In either case, the
     *          optional output variable 'mesg' gives more information.
     */
    public final Object leastsq(Object func, Object x0, Object... args) {
        write("optimize.leastsq("+PythonGrammar.toPythonArgs(func),PythonGrammar.toPythonArgs(x0)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find alpha that satisfies strong Wolfe conditions.
     * <p>
     * <em>Notes:</em><br>
     * Uses the line search algorithm to enforce strong Wolfe
     * conditions. See Wright and Nocedal, 'Numerical Optimization',
     * 1999, pp. 59-61.
     * 
     * 
     * Note that the method name deviates from the description (which is for {@link #line_search_wolfe2}). This is most likely due to line_search being an alias for line_search_wolfe2.
     * 
     * @param f callable f(x,*args)<br>
     *          Objective function.
     * @param myfprime callable f'(x,*args)<br>
     *                 Objective function gradient.
     * @param xk ndarray<br>
     *           Starting point.
     * @param pk ndarray<br>
     *           Search direction.
     * @param gfk ndarray, optional<br>
     *            Gradient value for x=xk (xk being the current parameter
     *            estimate). Will be recomputed if omitted.
     * @param old_fval float, optional<br>
     *                 Function value for x=xk. Will be recomputed if omitted.
     * @param old_old_fval float, optional<br>
     *                     Function value for the point preceding x=xk.
     * @param args tuple, optional<br>
     *             Additional arguments passed to objective function.
     * @param c1 float, optional<br>
     *           Parameter for Armijo condition rule.
     * @param c2 float, optional<br>
     *           Parameter for curvature condition rule.
     * @param amax float, optional<br>
     *             Maximum step size
     * @param extra_condition callable, optional<br>
     *                        A callable of the form ``extra_condition(alpha, x, f, g)``
     *                        returning a boolean. Arguments are the proposed step ``alpha``
     *                        and the corresponding ``x``, ``f`` and ``g`` values. The line search
     *                        accepts the value of ``alpha`` only if this
     *                        callable returns ``True``. If the callable returns ``False``
     *                        for the step length, the algorithm will continue with
     *                        new iterates. The callable is only called for iterates
     *                        satisfying the strong Wolfe conditions.
     * @param maxiter int, optional<br>
     *                Maximum number of iterations to perform.
     * 
     * @return (alpha,fc,gc,new_fval,old_fval,new_slope) (float or None,int,int,float or None,float,float or None)<br>
     *          Alpha for which ``x_new = x0 + alpha * pk``,
     *          or None if the line search algorithm did not converge.
     *          
     *          Number of function evaluations made.
     *          
     *          Number of gradient evaluations made.
     *          
     *          New function value ``f(x_new)=f(x0+alpha*pk)``,
     *          or None if the line search algorithm did not converge.
     *          
     *          Old function value ``f(x0)``.
     *          
     *          The local slope along the search direction at the
     *          new value ``&lt;myfprime(x_new), pk&gt;``,
     *          or None if the line search algorithm did not converge.
     */
    public final Object line_search(Object f, Object myfprime, Object xk, Object pk, Object... args) {
        write("optimize.line_search("+PythonGrammar.toPythonArgs(f),PythonGrammar.toPythonArgs(myfprime),PythonGrammar.toPythonArgs(xk),PythonGrammar.toPythonArgs(pk)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Solve the linear sum assignment problem.
     * <p>
     * <em>Notes:</em><br>
     * The linear sum assignment problem [1]_ is also known as minimum weight
     * matching in bipartite graphs. A problem instance is described by a matrix
     * C, where each C[i,j] is the cost of matching vertex i of the first partite
     * set (a "worker") and vertex j of the second set (a "job"). The goal is to
     * find a complete assignment of workers to jobs of minimal cost.
     * 
     * Formally, let X be a boolean matrix where :math:`X[i,j] = 1` iff row i is
     * assigned to column j. Then the optimal assignment has cost
     * 
     * .. math::
     * \min \sum_i \sum_j C_{i,j} X_{i,j}
     * 
     * where, in the case where the matrix X is square, each row is assigned to
     * exactly one column, and each column to exactly one row.
     * 
     * This function can also solve a generalization of the classic assignment
     * problem where the cost matrix is rectangular. If it has more rows than
     * columns, then not every row needs to be assigned to a column, and vice
     * versa.
     * 
     * This implementation is a modified Jonker-Volgenant algorithm with no
     * initialization, described in ref. [2]_.
     * 
     * .. versionadded:: 0.17.0
     * 
     * @param cost_matrix array<br>
     *                    The cost matrix of the bipartite graph.
     *                    
     * @param maximize bool (default: False)<br>
     *                 Calculates a maximum weight matching if true.
     * 
     * @return (row_ind,col_ind) (array,array)<br>
     *          An array of row indices and one of corresponding column indices giving
     *          the optimal assignment. The cost of the assignment can be computed
     *          as ``cost_matrix[row_ind, col_ind].sum()``. The row indices will be
     *          sorted; in the case of a square cost matrix they will be equal to
     *          ``numpy.arange(cost_matrix.shape[0])``.
     *          
     *          An array of row indices and one of corresponding column indices giving
     *          the optimal assignment. The cost of the assignment can be computed
     *          as ``cost_matrix[row_ind, col_ind].sum()``. The row indices will be
     *          sorted; in the case of a square cost matrix they will be equal to
     *          ``numpy.arange(cost_matrix.shape[0])``.
     */
    public final Object linear_sum_assignment(Object cost_matrix, Object... args) {
        write("optimize.linear_sum_assignment("+PythonGrammar.toPythonArgs(cost_matrix)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find a root of a function, using a scalar Jacobian approximation.
     * 
     * .. warning::
     * 
     * This algorithm may be useful for specific problems, but whether
     * it will work may depend strongly on the problem.
     * 
     * @param F function(x) -&gt; f<br>
     *          Function whose root to find; should take and return an array-like
     *          object.
     * @param xin array_like<br>
     *            Initial guess for the solution
     * @param alpha float, optional<br>
     *              The Jacobian approximation is (-1/alpha).
     * @param iter int, optional<br>
     *             Number of iterations to make. If omitted (default), make as many
     *             as required to meet tolerances.
     * @param verbose bool, optional<br>
     *                Print status to stdout on every iteration.
     * @param maxiter int, optional<br>
     *                Maximum number of iterations to make. If more are needed to
     *                meet convergence, `NoConvergence` is raised.
     * @param f_tol float, optional<br>
     *              Absolute tolerance (in max-norm) for the residual.
     *              If omitted, default is 6e-6.
     * @param f_rtol float, optional<br>
     *               Relative tolerance for the residual. If omitted, not used.
     * @param x_tol float, optional<br>
     *              Absolute minimum step size, as determined from the Jacobian
     *              approximation. If the step size is smaller than this, optimization
     *              is terminated as successful. If omitted, not used.
     * @param x_rtol float, optional<br>
     *               Relative minimum step size. If omitted, not used.
     * @param tol_norm function(vector) -&gt; scalar, optional<br>
     *                 Norm to use in convergence check. Default is the maximum norm.
     * @param line_search &#123;None, 'armijo' (default), 'wolfe'&#125;, optional<br>
     *                    Which type of a line search to use to determine the step size in the
     *                    direction given by the Jacobian approximation. Defaults to 'armijo'.
     * @param callback function, optional<br>
     *                 Optional callback function. It is called on every iteration as
     *                 ``callback(x, f)`` where `x` is the current solution and `f`
     *                 the corresponding residual.
     * @param **kw n/a<br>undocumented
     * 
     * @return sol ndarray<br>
     *             An array (of similar array type as `x0`) containing the final solution.
     */
    public final Object linearmixing(Object F, Object xin, Object... args) {
        write("optimize.linearmixing("+PythonGrammar.toPythonArgs(F),PythonGrammar.toPythonArgs(xin)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Linear programming: minimize a linear objective function subject to linear
     * equality and inequality constraints.
     * 
     * Linear programming solves problems of the following form:
     * 
     * .. math::
     * 
     * \min_x \ & c^T x \\
     * \mbox{such that} \ & A_{ub} x \leq b_{ub},\\
     * & A_{eq} x = b_{eq},\\
     * & l \leq x \leq u ,
     * 
     * where :math:`x` is a vector of decision variables; :math:`c`,
     * :math:`b_{ub}`, :math:`b_{eq}`, :math:`l`, and :math:`u` are vectors; and
     * :math:`A_{ub}` and :math:`A_{eq}` are matrices.
     * 
     * Alternatively, that's:
     * 
     * minimize::
     * 
     * c @ x
     * 
     * such that::
     * 
     * A_ub @ x <= b_ub
     * A_eq @ x == b_eq
     * lb <= x <= ub
     * 
     * Note that by default ``lb = 0`` and ``ub = None`` unless specified with
     * ``bounds``.
     * <p>
     * <em>Notes:</em><br>
     * This section describes the available solvers that can be selected by the
     * 'method' parameter.
     * 
     * `'highs-ds'` and
     * `'highs-ipm'` are interfaces to the
     * HiGHS simplex and interior-point method solvers [13]_, respectively.
     * `'highs'` chooses between
     * the two automatically. These are the fastest linear
     * programming solvers in SciPy, especially for large, sparse problems;
     * which of these two is faster is problem-dependent.
     * `'interior-point'` is the default
     * as it was the fastest and most robust method before the recent
     * addition of the HiGHS solvers.
     * `'revised simplex'` is more
     * accurate than interior-point for the problems it solves.
     * `'simplex'` is the legacy method and is
     * included for backwards compatibility and educational purposes.
     * 
     * Method *highs-ds* is a wrapper of the C++ high performance dual
     * revised simplex implementation (HSOL) [13]_, [14]_. Method *highs-ipm*
     * is a wrapper of a C++ implementation of an **i**\ nterior-\ **p**\ oint
     * **m**\ ethod [13]_; it features a crossover routine, so it is as accurate
     * as a simplex solver. Method *highs* chooses between the two automatically.
     * For new code involving `linprog`, we recommend explicitly choosing one of
     * these three method values.
     * 
     * .. versionadded:: 1.6.0
     * 
     * Method *interior-point* uses the primal-dual path following algorithm
     * as outlined in [4]_. This algorithm supports sparse constraint matrices and
     * is typically faster than the simplex methods, especially for large, sparse
     * problems. Note, however, that the solution returned may be slightly less
     * accurate than those of the simplex methods and will not, in general,
     * correspond with a vertex of the polytope defined by the constraints.
     * 
     * .. versionadded:: 1.0.0
     * 
     * Method *revised simplex* uses the revised simplex method as described in
     * [9]_, except that a factorization [11]_ of the basis matrix, rather than
     * its inverse, is efficiently maintained and used to solve the linear systems
     * at each iteration of the algorithm.
     * 
     * .. versionadded:: 1.3.0
     * 
     * Method *simplex* uses a traditional, full-tableau implementation of
     * Dantzig's simplex algorithm [1]_, [2]_ (*not* the
     * Nelder-Mead simplex). This algorithm is included for backwards
     * compatibility and educational purposes.
     * 
     * .. versionadded:: 0.15.0
     * 
     * Before applying *interior-point*, *revised simplex*, or *simplex*,
     * a presolve procedure based on [8]_ attempts
     * to identify trivial infeasibilities, trivial unboundedness, and potential
     * problem simplifications. Specifically, it checks for:
     * 
     * - rows of zeros in ``A_eq`` or ``A_ub``, representing trivial constraints;
     * - columns of zeros in ``A_eq`` `and` ``A_ub``, representing unconstrained
     * variables;
     * - column singletons in ``A_eq``, representing fixed variables; and
     * - column singletons in ``A_ub``, representing simple bounds.
     * 
     * If presolve reveals that the problem is unbounded (e.g. an unconstrained
     * and unbounded variable has negative cost) or infeasible (e.g., a row of
     * zeros in ``A_eq`` corresponds with a nonzero in ``b_eq``), the solver
     * terminates with the appropriate status code. Note that presolve terminates
     * as soon as any sign of unboundedness is detected; consequently, a problem
     * may be reported as unbounded when in reality the problem is infeasible
     * (but infeasibility has not been detected yet). Therefore, if it is
     * important to know whether the problem is actually infeasible, solve the
     * problem again with option ``presolve=False``.
     * 
     * If neither infeasibility nor unboundedness are detected in a single pass
     * of the presolve, bounds are tightened where possible and fixed
     * variables are removed from the problem. Then, linearly dependent rows
     * of the ``A_eq`` matrix are removed, (unless they represent an
     * infeasibility) to avoid numerical difficulties in the primary solve
     * routine. Note that rows that are nearly linearly dependent (within a
     * prescribed tolerance) may also be removed, which can change the optimal
     * solution in rare cases. If this is a concern, eliminate redundancy from
     * your problem formulation and run with option ``rr=False`` or
     * ``presolve=False``.
     * 
     * Several potential improvements can be made here: additional presolve
     * checks outlined in [8]_ should be implemented, the presolve routine should
     * be run multiple times (until no further simplifications can be made), and
     * more of the efficiency improvements from [5]_ should be implemented in the
     * redundancy removal routines.
     * 
     * After presolve, the problem is transformed to standard form by converting
     * the (tightened) simple bounds to upper bound constraints, introducing
     * non-negative slack variables for inequality constraints, and expressing
     * unbounded variables as the difference between two non-negative variables.
     * Optionally, the problem is automatically scaled via equilibration [12]_.
     * The selected algorithm solves the standard form problem, and a
     * postprocessing routine converts the result to a solution to the original
     * problem.
     * 
     * @param c 1-D array<br>
     *          The coefficients of the linear objective function to be minimized.
     * @param A_ub 2-D array, optional<br>
     *             The inequality constraint matrix. Each row of ``A_ub`` specifies the
     *             coefficients of a linear inequality constraint on ``x``.
     * @param b_ub 1-D array, optional<br>
     *             The inequality constraint vector. Each element represents an
     *             upper bound on the corresponding value of ``A_ub @ x``.
     * @param A_eq 2-D array, optional<br>
     *             The equality constraint matrix. Each row of ``A_eq`` specifies the
     *             coefficients of a linear equality constraint on ``x``.
     * @param b_eq 1-D array, optional<br>
     *             The equality constraint vector. Each element of ``A_eq @ x`` must equal
     *             the corresponding element of ``b_eq``.
     * @param bounds sequence, optional<br>
     *               A sequence of ``(min, max)`` pairs for each element in ``x``, defining
     *               the minimum and maximum values of that decision variable. Use ``None``
     *               to indicate that there is no bound. By default, bounds are
     *               ``(0, None)`` (all decision variables are non-negative).
     *               If a single tuple ``(min, max)`` is provided, then ``min`` and
     *               ``max`` will serve as bounds for all decision variables.
     * @param method str, optional<br>
     *               The algorithm used to solve the standard form problem.
     *               :ref:`'highs-ds' &lt;optimize.linprog-highs-ds&gt;`,
     *               :ref:`'highs-ipm' &lt;optimize.linprog-highs-ipm&gt;`,
     *               :ref:`'highs' &lt;optimize.linprog-highs&gt;`,
     *               :ref:`'interior-point' &lt;optimize.linprog-interior-point&gt;` (default),
     *               :ref:`'revised simplex' &lt;optimize.linprog-revised_simplex&gt;`, and
     *               :ref:`'simplex' &lt;optimize.linprog-simplex&gt;` (legacy)
     *               are supported.
     * @param callback callable, optional<br>
     *                 If a callback function is provided, it will be called at least once per
     *                 iteration of the algorithm. The callback function must accept a single
     *                 `scipy.optimize.OptimizeResult` consisting of the following fields:
     *                 
     *                 x : 1-D array
     *                 The current solution vector.
     *                 fun : float
     *                 The current value of the objective function ``c @ x``.
     *                 success : bool
     *                 ``True`` when the algorithm has completed successfully.
     *                 slack : 1-D array
     *                 The (nominally positive) values of the slack,
     *                 ``b_ub - A_ub @ x``.
     *                 con : 1-D array
     *                 The (nominally zero) residuals of the equality constraints,
     *                 ``b_eq - A_eq @ x``.
     *                 phase : int
     *                 The phase of the algorithm being executed.
     *                 status : int
     *                 An integer representing the status of the algorithm.
     *                 
     *                 ``0`` : Optimization proceeding nominally.
     *                 
     *                 ``1`` : Iteration limit reached.
     *                 
     *                 ``2`` : Problem appears to be infeasible.
     *                 
     *                 ``3`` : Problem appears to be unbounded.
     *                 
     *                 ``4`` : Numerical difficulties encountered.
     *                 
     *                 nit : int
     *                 The current iteration number.
     *                 message : str
     *                 A string descriptor of the algorithm status.
     *                 
     *                 Callback functions are not currently supported by the HiGHS methods.
     *                 
     * @param options dict, optional<br>
     *                A dictionary of solver options. All methods accept the following
     *                options:
     *                
     *                maxiter : int
     *                Maximum number of iterations to perform.
     *                Default: see method-specific documentation.
     *                disp : bool
     *                Set to ``True`` to print convergence messages.
     *                Default: ``False``.
     *                presolve : bool
     *                Set to ``False`` to disable automatic presolve.
     *                Default: ``True``.
     *                
     *                All methods except the HiGHS solvers also accept:
     *                
     *                tol : float
     *                A tolerance which determines when a residual is "close enough" to
     *                zero to be considered exactly zero.
     *                autoscale : bool
     *                Set to ``True`` to automatically perform equilibration.
     *                Consider using this option if the numerical values in the
     *                constraints are separated by several orders of magnitude.
     *                Default: ``False``.
     *                rr : bool
     *                Set to ``False`` to disable automatic redundancy removal.
     *                Default: ``True``.
     *                rr_method : string
     *                Method used to identify and remove redundant rows from the
     *                equality constraint matrix after presolve. For problems with
     *                dense input, the available methods for redundancy removal are:
     *                
     *                "SVD":
     *                Repeatedly performs singular value decomposition on
     *                the matrix, detecting redundant rows based on nonzeros
     *                in the left singular vectors that correspond with
     *                zero singular values. May be fast when the matrix is
     *                nearly full rank.
     *                "pivot":
     *                Uses the algorithm presented in [5]_ to identify
     *                redundant rows.
     *                "ID":
     *                Uses a randomized interpolative decomposition.
     *                Identifies columns of the matrix transpose not used in
     *                a full-rank interpolative decomposition of the matrix.
     *                None:
     *                Uses "svd" if the matrix is nearly full rank, that is,
     *                the difference between the matrix rank and the number
     *                of rows is less than five. If not, uses "pivot". The
     *                behavior of this default is subject to change without
     *                prior notice.
     *                
     *                Default: None.
     *                For problems with sparse input, this option is ignored, and the
     *                pivot-based algorithm presented in [5]_ is used.
     *                
     *                For method-specific options, see
     *                :func:`show_options('linprog') &lt;show_options&gt;`.
     *                
     * @param x0 1-D array, optional<br>
     *           Guess values of the decision variables, which will be refined by
     *           the optimization algorithm. This argument is currently used only by the
     *           'revised simplex' method, and can only be used if `x0` represents a
     *           basic feasible solution.
     * 
     * @return res OptimizeResult<br>
     *             A :class:`scipy.optimize.OptimizeResult` consisting of the fields:
     *             
     *             x : 1-D array
     *             The values of the decision variables that minimizes the
     *             objective function while satisfying the constraints.
     *             fun : float
     *             The optimal value of the objective function ``c @ x``.
     *             slack : 1-D array
     *             The (nominally positive) values of the slack variables,
     *             ``b_ub - A_ub @ x``.
     *             con : 1-D array
     *             The (nominally zero) residuals of the equality constraints,
     *             ``b_eq - A_eq @ x``.
     *             success : bool
     *             ``True`` when the algorithm succeeds in finding an optimal
     *             solution.
     *             status : int
     *             An integer representing the exit status of the algorithm.
     *             
     *             ``0`` : Optimization terminated successfully.
     *             
     *             ``1`` : Iteration limit reached.
     *             
     *             ``2`` : Problem appears to be infeasible.
     *             
     *             ``3`` : Problem appears to be unbounded.
     *             
     *             ``4`` : Numerical difficulties encountered.
     *             
     *             nit : int
     *             The total number of iterations performed in all phases.
     *             message : str
     *             A string descriptor of the exit status of the algorithm.
     */
    public final Object linprog(Object c, Object... args) {
        write("optimize.linprog("+PythonGrammar.toPythonArgs(c)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * A sample callback function demonstrating the linprog callback interface.
     * This callback produces detailed output to sys.stdout before each iteration
     * and after the final iteration of the simplex algorithm.
     * 
     * @param res A `scipy.optimize.OptimizeResult` consisting of the following fields:<br>
     *            
     *            x : 1-D array
     *            The independent variable vector which optimizes the linear
     *            programming problem.
     *            fun : float
     *            Value of the objective function.
     *            success : bool
     *            True if the algorithm succeeded in finding an optimal solution.
     *            slack : 1-D array
     *            The values of the slack variables. Each slack variable corresponds
     *            to an inequality constraint. If the slack is zero, then the
     *            corresponding constraint is active.
     *            con : 1-D array
     *            The (nominally zero) residuals of the equality constraints, that is,
     *            ``b - A_eq @ x``
     *            phase : int
     *            The phase of the optimization being executed. In phase 1 a basic
     *            feasible solution is sought and the T has an additional row
     *            representing an alternate objective function.
     *            status : int
     *            An integer representing the exit status of the optimization::
     *            
     *            0 : Optimization terminated successfully
     *            1 : Iteration limit reached
     *            2 : Problem appears to be infeasible
     *            3 : Problem appears to be unbounded
     *            4 : Serious numerical difficulties encountered
     *            
     *            nit : int
     *            The number of iterations performed.
     *            message : str
     *            A string descriptor of the exit status of the optimization.
     */
    public final Object linprog_verbose_callback(Object res) {
        write("optimize.linprog_verbose_callback("+PythonGrammar.toPythonArgs(res)+")");
        return null;
    }

    /**
     * Solve a linear least-squares problem with bounds on the variables.
     * 
     * Given a m-by-n design matrix A and a target vector b with m elements,
     * `lsq_linear` solves the following optimization problem::
     * 
     * minimize 0.5 * ||A x - b||**2
     * subject to lb <= x <= ub
     * 
     * This optimization problem is convex, hence a found minimum (if iterations
     * have converged) is guaranteed to be global.
     * <p>
     * <em>Notes:</em><br>
     * The algorithm first computes the unconstrained least-squares solution by
     * `numpy.linalg.lstsq` or `scipy.sparse.linalg.lsmr` depending on
     * `lsq_solver`. This solution is returned as optimal if it lies within the
     * bounds.
     * 
     * Method 'trf' runs the adaptation of the algorithm described in [STIR]_ for
     * a linear least-squares problem. The iterations are essentially the same as
     * in the nonlinear least-squares algorithm, but as the quadratic function
     * model is always accurate, we don't need to track or modify the radius of
     * a trust region. The line search (backtracking) is used as a safety net
     * when a selected step does not decrease the cost function. Read more
     * detailed description of the algorithm in `scipy.optimize.least_squares`.
     * 
     * Method 'bvls' runs a Python implementation of the algorithm described in
     * [BVLS]_. The algorithm maintains active and free sets of variables, on
     * each iteration chooses a new variable to move from the active set to the
     * free set and then solves the unconstrained least-squares problem on free
     * variables. This algorithm is guaranteed to give an accurate solution
     * eventually, but may require up to n iterations for a problem with n
     * variables. Additionally, an ad-hoc initialization procedure is
     * implemented, that determines which variables to set free or active
     * initially. It takes some number of iterations before actual BVLS starts,
     * but can significantly reduce the number of further iterations.
     * 
     * @param A array_like, sparse matrix of LinearOperator, shape (m, n)<br>
     *          Design matrix. Can be `scipy.sparse.linalg.LinearOperator`.
     * @param b array_like, shape (m,)<br>
     *          Target vector.
     * @param bounds 2-tuple of array_like, optional<br>
     *               Lower and upper bounds on independent variables. Defaults to no bounds.
     *               Each array must have shape (n,) or be a scalar, in the latter
     *               case a bound will be the same for all variables. Use ``np.inf`` with
     *               an appropriate sign to disable bounds on all or some variables.
     * @param method 'trf' or 'bvls', optional<br>
     *               Method to perform minimization.
     *               
     *               * 'trf' : Trust Region Reflective algorithm adapted for a linear
     *               least-squares problem. This is an interior-point-like method
     *               and the required number of iterations is weakly correlated with
     *               the number of variables.
     *               * 'bvls' : Bounded-variable least-squares algorithm. This is
     *               an active set method, which requires the number of iterations
     *               comparable to the number of variables. Can't be used when `A` is
     *               sparse or LinearOperator.
     *               
     *               Default is 'trf'.
     * @param tol float, optional<br>
     *            Tolerance parameter. The algorithm terminates if a relative change
     *            of the cost function is less than `tol` on the last iteration.
     *            Additionally, the first-order optimality measure is considered:
     *            
     *            * ``method='trf'`` terminates if the uniform norm of the gradient,
     *            scaled to account for the presence of the bounds, is less than
     *            `tol`.
     *            * ``method='bvls'`` terminates if Karush-Kuhn-Tucker conditions
     *            are satisfied within `tol` tolerance.
     *            
     * @param lsq_solver &#123;None, 'exact', 'lsmr'&#125;, optional<br>
     *                   Method of solving unbounded least-squares problems throughout
     *                   iterations:
     *                   
     *                   * 'exact' : Use dense QR or SVD decomposition approach. Can't be
     *                   used when `A` is sparse or LinearOperator.
     *                   * 'lsmr' : Use `scipy.sparse.linalg.lsmr` iterative procedure
     *                   which requires only matrix-vector product evaluations. Can't
     *                   be used with ``method='bvls'``.
     *                   
     *                   If None (default), the solver is chosen based on type of `A`.
     * @param lsmr_tol None, float or 'auto', optional<br>
     *                 Tolerance parameters 'atol' and 'btol' for `scipy.sparse.linalg.lsmr`
     *                 If None (default), it is set to ``1e-2 * tol``. If 'auto', the
     *                 tolerance will be adjusted based on the optimality of the current
     *                 iterate, which can speed up the optimization process, but is not always
     *                 reliable.
     * @param max_iter None or int, optional<br>
     *                 Maximum number of iterations before termination. If None (default), it
     *                 is set to 100 for ``method='trf'`` or to the number of variables for
     *                 ``method='bvls'`` (not counting iterations for 'bvls' initialization).
     * @param verbose &#123;0, 1, 2&#125;, optional<br>
     *                Level of algorithm's verbosity:
     *                
     *                * 0 : work silently (default).
     *                * 1 : display a termination report.
     *                * 2 : display progress during iterations.
     * 
     * @return (OptimizeResult with the following fields defined,x,cost,fun,optimality,active_mask,nit,status,message,success) (,ndarray, shape (n,),float,ndarray, shape (m,),float,ndarray of int, shape (n,),int,int,str,bool)<br>
     *          
     *          Solution found.
     *          
     *          Value of the cost function at the solution.
     *          
     *          Vector of residuals at the solution.
     *          
     *          First-order optimality measure. The exact meaning depends on `method`,
     *          refer to the description of `tol` parameter.
     *          
     *          Each component shows whether a corresponding constraint is active
     *          (that is, whether a variable is at the bound):
     *          
     *          *  0 : a constraint is not active.
     *          * -1 : a lower bound is active.
     *          *  1 : an upper bound is active.
     *          
     *          Might be somewhat arbitrary for the `trf` method as it generates a
     *          sequence of strictly feasible iterates and active_mask is determined
     *          within a tolerance threshold.
     *          
     *          Number of iterations. Zero if the unconstrained solution is optimal.
     *          
     *          Reason for algorithm termination:
     *          
     *          * -1 : the algorithm was not able to make progress on the last
     *          iteration.
     *          *  0 : the maximum number of iterations is exceeded.
     *          *  1 : the first-order optimality measure is less than `tol`.
     *          *  2 : the relative change of the cost function is less than `tol`.
     *          *  3 : the unconstrained solution is optimal.
     *          
     *          
     *          Verbal description of the termination reason.
     *          
     *          True if one of the convergence criteria is satisfied (`status` &gt; 0).
     */
    public final Object lsq_linear(Object A, Object b, Object... args) {
        write("optimize.lsq_linear("+PythonGrammar.toPythonArgs(A),PythonGrammar.toPythonArgs(b)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Minimization of scalar function of one or more variables.
     * <p>
     * <em>Notes:</em><br>
     * This section describes the available solvers that can be selected by the
     * 'method' parameter. The default method is *BFGS*.
     * 
     * **Unconstrained minimization**
     * 
     * Method :ref:`CG <optimize.minimize-cg>` uses a nonlinear conjugate
     * gradient algorithm by Polak and Ribiere, a variant of the
     * Fletcher-Reeves method described in [5]_ pp.120-122. Only the
     * first derivatives are used.
     * 
     * Method :ref:`BFGS <optimize.minimize-bfgs>` uses the quasi-Newton
     * method of Broyden, Fletcher, Goldfarb, and Shanno (BFGS) [5]_
     * pp. 136. It uses the first derivatives only. BFGS has proven good
     * performance even for non-smooth optimizations. This method also
     * returns an approximation of the Hessian inverse, stored as
     * `hess_inv` in the OptimizeResult object.
     * 
     * Method :ref:`Newton-CG <optimize.minimize-newtoncg>` uses a
     * Newton-CG algorithm [5]_ pp. 168 (also known as the truncated
     * Newton method). It uses a CG method to the compute the search
     * direction. See also *TNC* method for a box-constrained
     * minimization with a similar algorithm. Suitable for large-scale
     * problems.
     * 
     * Method :ref:`dogleg <optimize.minimize-dogleg>` uses the dog-leg
     * trust-region algorithm [5]_ for unconstrained minimization. This
     * algorithm requires the gradient and Hessian; furthermore the
     * Hessian is required to be positive definite.
     * 
     * Method :ref:`trust-ncg <optimize.minimize-trustncg>` uses the
     * Newton conjugate gradient trust-region algorithm [5]_ for
     * unconstrained minimization. This algorithm requires the gradient
     * and either the Hessian or a function that computes the product of
     * the Hessian with a given vector. Suitable for large-scale problems.
     * 
     * Method :ref:`trust-krylov <optimize.minimize-trustkrylov>` uses
     * the Newton GLTR trust-region algorithm [14]_, [15]_ for unconstrained
     * minimization. This algorithm requires the gradient
     * and either the Hessian or a function that computes the product of
     * the Hessian with a given vector. Suitable for large-scale problems.
     * On indefinite problems it requires usually less iterations than the
     * `trust-ncg` method and is recommended for medium and large-scale problems.
     * 
     * Method :ref:`trust-exact <optimize.minimize-trustexact>`
     * is a trust-region method for unconstrained minimization in which
     * quadratic subproblems are solved almost exactly [13]_. This
     * algorithm requires the gradient and the Hessian (which is
     * *not* required to be positive definite). It is, in many
     * situations, the Newton method to converge in fewer iteraction
     * and the most recommended for small and medium-size problems.
     * 
     * **Bound-Constrained minimization**
     * 
     * Method :ref:`Nelder-Mead <optimize.minimize-neldermead>` uses the
     * Simplex algorithm [1]_, [2]_. This algorithm is robust in many
     * applications. However, if numerical computation of derivative can be
     * trusted, other algorithms using the first and/or second derivatives
     * information might be preferred for their better performance in
     * general.
     * 
     * Method :ref:`L-BFGS-B <optimize.minimize-lbfgsb>` uses the L-BFGS-B
     * algorithm [6]_, [7]_ for bound constrained minimization.
     * 
     * Method :ref:`Powell <optimize.minimize-powell>` is a modification
     * of Powell's method [3]_, [4]_ which is a conjugate direction
     * method. It performs sequential one-dimensional minimizations along
     * each vector of the directions set (`direc` field in `options` and
     * `info`), which is updated at each iteration of the main
     * minimization loop. The function need not be differentiable, and no
     * derivatives are taken. If bounds are not provided, then an
     * unbounded line search will be used. If bounds are provided and
     * the initial guess is within the bounds, then every function
     * evaluation throughout the minimization procedure will be within
     * the bounds. If bounds are provided, the initial guess is outside
     * the bounds, and `direc` is full rank (default has full rank), then
     * some function evaluations during the first iteration may be
     * outside the bounds, but every function evaluation after the first
     * iteration will be within the bounds. If `direc` is not full rank,
     * then some parameters may not be optimized and the solution is not
     * guaranteed to be within the bounds.
     * 
     * Method :ref:`TNC <optimize.minimize-tnc>` uses a truncated Newton
     * algorithm [5]_, [8]_ to minimize a function with variables subject
     * to bounds. This algorithm uses gradient information; it is also
     * called Newton Conjugate-Gradient. It differs from the *Newton-CG*
     * method described above as it wraps a C implementation and allows
     * each variable to be given upper and lower bounds.
     * 
     * **Constrained Minimization**
     * 
     * Method :ref:`COBYLA <optimize.minimize-cobyla>` uses the
     * Constrained Optimization BY Linear Approximation (COBYLA) method
     * [9]_, [10]_, [11]_. The algorithm is based on linear
     * approximations to the objective function and each constraint. The
     * method wraps a FORTRAN implementation of the algorithm. The
     * constraints functions 'fun' may return either a single number
     * or an array or list of numbers.
     * 
     * Method :ref:`SLSQP <optimize.minimize-slsqp>` uses Sequential
     * Least SQuares Programming to minimize a function of several
     * variables with any combination of bounds, equality and inequality
     * constraints. The method wraps the SLSQP Optimization subroutine
     * originally implemented by Dieter Kraft [12]_. Note that the
     * wrapper handles infinite values in bounds by converting them into
     * large floating values.
     * 
     * Method :ref:`trust-constr <optimize.minimize-trustconstr>` is a
     * trust-region algorithm for constrained optimization. It swiches
     * between two implementations depending on the problem definition.
     * It is the most versatile constrained minimization algorithm
     * implemented in SciPy and the most appropriate for large-scale problems.
     * For equality constrained problems it is an implementation of Byrd-Omojokun
     * Trust-Region SQP method described in [17]_ and in [5]_, p. 549. When
     * inequality constraints  are imposed as well, it swiches to the trust-region
     * interior point  method described in [16]_. This interior point algorithm,
     * in turn, solves inequality constraints by introducing slack variables
     * and solving a sequence of equality-constrained barrier problems
     * for progressively smaller values of the barrier parameter.
     * The previously described equality constrained SQP method is
     * used to solve the subproblems with increasing levels of accuracy
     * as the iterate gets closer to a solution.
     * 
     * **Finite-Difference Options**
     * 
     * For Method :ref:`trust-constr <optimize.minimize-trustconstr>`
     * the gradient and the Hessian may be approximated using
     * three finite-difference schemes: {'2-point', '3-point', 'cs'}.
     * The scheme 'cs' is, potentially, the most accurate but it
     * requires the function to correctly handles complex inputs and to
     * be differentiable in the complex plane. The scheme '3-point' is more
     * accurate than '2-point' but requires twice as many operations.
     * 
     * **Custom minimizers**
     * 
     * It may be useful to pass a custom minimization method, for example
     * when using a frontend to this method such as `scipy.optimize.basinhopping`
     * or a different library.  You can simply pass a callable as the ``method``
     * parameter.
     * 
     * The callable is called as ``method(fun, x0, args, **kwargs, **options)``
     * where ``kwargs`` corresponds to any other parameters passed to `minimize`
     * (such as `callback`, `hess`, etc.), except the `options` dict, which has
     * its contents also passed as `method` parameters pair by pair.  Also, if
     * `jac` has been passed as a bool type, `jac` and `fun` are mangled so that
     * `fun` returns just the function values and `jac` is converted to a function
     * returning the Jacobian.  The method shall return an `OptimizeResult`
     * object.
     * 
     * The provided `method` callable must be able to accept (and possibly ignore)
     * arbitrary parameters; the set of parameters accepted by `minimize` may
     * expand in future versions and then these parameters will be passed to
     * the method.  You can find an example in the scipy.optimize tutorial.
     * 
     * .. versionadded:: 0.11.0
     * 
     * @param fun callable<br>
     *            The objective function to be minimized.
     *            
     *            ``fun(x, *args) -&gt; float``
     *            
     *            where ``x`` is an 1-D array with shape (n,) and ``args``
     *            is a tuple of the fixed parameters needed to completely
     *            specify the function.
     * @param x0 ndarray, shape (n,)<br>
     *           Initial guess. Array of real elements of size (n,),
     *           where 'n' is the number of independent variables.
     * @param args tuple, optional<br>
     *             Extra arguments passed to the objective function and its
     *             derivatives (`fun`, `jac` and `hess` functions).
     * @param method str or callable, optional<br>
     *               Type of solver.  Should be one of
     *               
     *               - 'Nelder-Mead' :ref:`(see here) &lt;optimize.minimize-neldermead&gt;`
     *               - 'Powell'      :ref:`(see here) &lt;optimize.minimize-powell&gt;`
     *               - 'CG'          :ref:`(see here) &lt;optimize.minimize-cg&gt;`
     *               - 'BFGS'        :ref:`(see here) &lt;optimize.minimize-bfgs&gt;`
     *               - 'Newton-CG'   :ref:`(see here) &lt;optimize.minimize-newtoncg&gt;`
     *               - 'L-BFGS-B'    :ref:`(see here) &lt;optimize.minimize-lbfgsb&gt;`
     *               - 'TNC'         :ref:`(see here) &lt;optimize.minimize-tnc&gt;`
     *               - 'COBYLA'      :ref:`(see here) &lt;optimize.minimize-cobyla&gt;`
     *               - 'SLSQP'       :ref:`(see here) &lt;optimize.minimize-slsqp&gt;`
     *               - 'trust-constr':ref:`(see here) &lt;optimize.minimize-trustconstr&gt;`
     *               - 'dogleg'      :ref:`(see here) &lt;optimize.minimize-dogleg&gt;`
     *               - 'trust-ncg'   :ref:`(see here) &lt;optimize.minimize-trustncg&gt;`
     *               - 'trust-exact' :ref:`(see here) &lt;optimize.minimize-trustexact&gt;`
     *               - 'trust-krylov' :ref:`(see here) &lt;optimize.minimize-trustkrylov&gt;`
     *               - custom - a callable object (added in version 0.14.0),
     *               see below for description.
     *               
     *               If not given, chosen to be one of ``BFGS``, ``L-BFGS-B``, ``SLSQP``,
     *               depending if the problem has constraints or bounds.
     * @param jac &#123;callable,  '2-point', '3-point', 'cs', bool&#125;, optional<br>
     *            Method for computing the gradient vector. Only for CG, BFGS,
     *            Newton-CG, L-BFGS-B, TNC, SLSQP, dogleg, trust-ncg, trust-krylov,
     *            trust-exact and trust-constr.
     *            If it is a callable, it should be a function that returns the gradient
     *            vector:
     *            
     *            ``jac(x, *args) -&gt; array_like, shape (n,)``
     *            
     *            where ``x`` is an array with shape (n,) and ``args`` is a tuple with
     *            the fixed parameters. If `jac` is a Boolean and is True, `fun` is
     *            assumed to return a tuple ``(f, g)`` containing the objective
     *            function and the gradient.
     *            Methods 'Newton-CG', 'trust-ncg', 'dogleg', 'trust-exact', and
     *            'trust-krylov' require that either a callable be supplied, or that
     *            `fun` return the objective and gradient.
     *            If None or False, the gradient will be estimated using 2-point finite
     *            difference estimation with an absolute step size.
     *            Alternatively, the keywords  &#123;'2-point', '3-point', 'cs'&#125; can be used
     *            to select a finite difference scheme for numerical estimation of the
     *            gradient with a relative step size. These finite difference schemes
     *            obey any specified `bounds`.
     * @param hess &#123;callable, '2-point', '3-point', 'cs', HessianUpdateStrategy&#125;, optional<br>
     *             Method for computing the Hessian matrix. Only for Newton-CG, dogleg,
     *             trust-ncg, trust-krylov, trust-exact and trust-constr. If it is
     *             callable, it should return the Hessian matrix:
     *             
     *             ``hess(x, *args) -&gt; &#123;LinearOperator, spmatrix, array&#125;, (n, n)``
     *             
     *             where x is a (n,) ndarray and `args` is a tuple with the fixed
     *             parameters. LinearOperator and sparse matrix returns are only allowed
     *             for 'trust-constr' method. Alternatively, the keywords
     *             &#123;'2-point', '3-point', 'cs'&#125; select a finite difference scheme
     *             for numerical estimation. Or, objects implementing the
     *             `HessianUpdateStrategy` interface can be used to approximate
     *             the Hessian. Available quasi-Newton methods implementing
     *             this interface are:
     *             
     *             - `BFGS`;
     *             - `SR1`.
     *             
     *             Whenever the gradient is estimated via finite-differences,
     *             the Hessian cannot be estimated with options
     *             &#123;'2-point', '3-point', 'cs'&#125; and needs to be
     *             estimated using one of the quasi-Newton strategies.
     *             'trust-exact' cannot use a finite-difference scheme, and must be used
     *             with a callable returning an (n, n) array.
     * @param hessp callable, optional<br>
     *              Hessian of objective function times an arbitrary vector p. Only for
     *              Newton-CG, trust-ncg, trust-krylov, trust-constr.
     *              Only one of `hessp` or `hess` needs to be given.  If `hess` is
     *              provided, then `hessp` will be ignored.  `hessp` must compute the
     *              Hessian times an arbitrary vector:
     *              
     *              ``hessp(x, p, *args) -&gt;  ndarray shape (n,)``
     *              
     *              where x is a (n,) ndarray, p is an arbitrary vector with
     *              dimension (n,) and `args` is a tuple with the fixed
     *              parameters.
     * @param bounds sequence or `Bounds`, optional<br>
     *               Bounds on variables for Nelder-Mead, L-BFGS-B, TNC, SLSQP, Powell, and
     *               trust-constr methods. There are two ways to specify the bounds:
     *               
     *               1. Instance of `Bounds` class.
     *               2. Sequence of ``(min, max)`` pairs for each element in `x`. None
     *               is used to specify no bound.
     *               
     * @param constraints &#123;Constraint, dict&#125; or List of &#123;Constraint, dict&#125;, optional<br>
     *                    Constraints definition (only for COBYLA, SLSQP and trust-constr).
     *                    
     *                    Constraints for 'trust-constr' are defined as a single object or a
     *                    list of objects specifying constraints to the optimization problem.
     *                    Available constraints are:
     *                    
     *                    - `LinearConstraint`
     *                    - `NonlinearConstraint`
     *                    
     *                    Constraints for COBYLA, SLSQP are defined as a list of dictionaries.
     *                    Each dictionary with fields:
     *                    
     *                    type : str
     *                    Constraint type: 'eq' for equality, 'ineq' for inequality.
     *                    fun : callable
     *                    The function defining the constraint.
     *                    jac : callable, optional
     *                    The Jacobian of `fun` (only for SLSQP).
     *                    args : sequence, optional
     *                    Extra arguments to be passed to the function and Jacobian.
     *                    
     *                    Equality constraint means that the constraint function result is to
     *                    be zero whereas inequality means that it is to be non-negative.
     *                    Note that COBYLA only supports inequality constraints.
     * @param tol float, optional<br>
     *            Tolerance for termination. When `tol` is specified, the selected
     *            minimization algorithm sets some relevant solver-specific tolerance(s)
     *            equal to `tol`. For detailed control, use solver-specific
     *            options.
     * @param options dict, optional<br>
     *                A dictionary of solver options. All methods accept the following
     *                generic options:
     *                
     *                maxiter : int
     *                Maximum number of iterations to perform. Depending on the
     *                method each iteration may use several function evaluations.
     *                disp : bool
     *                Set to True to print convergence messages.
     *                
     *                For method-specific options, see :func:`show_options()`.
     * @param callback callable, optional<br>
     *                 Called after each iteration. For 'trust-constr' it is a callable with
     *                 the signature:
     *                 
     *                 ``callback(xk, OptimizeResult state) -&gt; bool``
     *                 
     *                 where ``xk`` is the current parameter vector. and ``state``
     *                 is an `OptimizeResult` object, with the same fields
     *                 as the ones from the return. If callback returns True
     *                 the algorithm execution is terminated.
     *                 For all the other methods, the signature is:
     *                 
     *                 ``callback(xk)``
     *                 
     *                 where ``xk`` is the current parameter vector.
     * 
     * @return res OptimizeResult<br>
     *             The optimization result represented as a ``OptimizeResult`` object.
     *             Important attributes are: ``x`` the solution array, ``success`` a
     *             Boolean flag indicating if the optimizer exited successfully and
     *             ``message`` which describes the cause of the termination. See
     *             `OptimizeResult` for a description of other attributes.
     */
    public final Object minimize(Object fun, Object x0, Object... args) {
        write("optimize.minimize("+PythonGrammar.toPythonArgs(fun),PythonGrammar.toPythonArgs(x0)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Minimization of scalar function of one variable.
     * <p>
     * <em>Notes:</em><br>
     * This section describes the available solvers that can be selected by the
     * 'method' parameter. The default method is *Brent*.
     * 
     * Method :ref:`Brent <optimize.minimize_scalar-brent>` uses Brent's
     * algorithm to find a local minimum.  The algorithm uses inverse
     * parabolic interpolation when possible to speed up convergence of
     * the golden section method.
     * 
     * Method :ref:`Golden <optimize.minimize_scalar-golden>` uses the
     * golden section search technique. It uses analog of the bisection
     * method to decrease the bracketed interval. It is usually
     * preferable to use the *Brent* method.
     * 
     * Method :ref:`Bounded <optimize.minimize_scalar-bounded>` can
     * perform bounded minimization. It uses the Brent method to find a
     * local minimum in the interval x1 < xopt < x2.
     * 
     * **Custom minimizers**
     * 
     * It may be useful to pass a custom minimization method, for example
     * when using some library frontend to minimize_scalar. You can simply
     * pass a callable as the ``method`` parameter.
     * 
     * The callable is called as ``method(fun, args, **kwargs, **options)``
     * where ``kwargs`` corresponds to any other parameters passed to `minimize`
     * (such as `bracket`, `tol`, etc.), except the `options` dict, which has
     * its contents also passed as `method` parameters pair by pair.  The method
     * shall return an `OptimizeResult` object.
     * 
     * The provided `method` callable must be able to accept (and possibly ignore)
     * arbitrary parameters; the set of parameters accepted by `minimize` may
     * expand in future versions and then these parameters will be passed to
     * the method. You can find an example in the scipy.optimize tutorial.
     * 
     * .. versionadded:: 0.11.0
     * 
     * @param fun callable<br>
     *            Objective function.
     *            Scalar function, must return a scalar.
     * @param bracket sequence, optional<br>
     *                For methods 'brent' and 'golden', `bracket` defines the bracketing
     *                interval and can either have three items ``(a, b, c)`` so that
     *                ``a &lt; b &lt; c`` and ``fun(b) &lt; fun(a), fun(c)`` or two items ``a`` and
     *                ``c`` which are assumed to be a starting interval for a downhill
     *                bracket search (see `bracket`); it doesn't always mean that the
     *                obtained solution will satisfy ``a &lt;= x &lt;= c``.
     * @param bounds sequence, optional<br>
     *               For method 'bounded', `bounds` is mandatory and must have two items
     *               corresponding to the optimization bounds.
     * @param args tuple, optional<br>
     *             Extra arguments passed to the objective function.
     * @param method str or callable, optional<br>
     *               Type of solver.  Should be one of:
     *               
     *               - 'Brent'     :ref:`(see here) &lt;optimize.minimize_scalar-brent&gt;`
     *               - 'Bounded'   :ref:`(see here) &lt;optimize.minimize_scalar-bounded&gt;`
     *               - 'Golden'    :ref:`(see here) &lt;optimize.minimize_scalar-golden&gt;`
     *               - custom - a callable object (added in version 0.14.0), see below
     *               
     * @param tol float, optional<br>
     *            Tolerance for termination. For detailed control, use solver-specific
     *            options.
     * @param options dict, optional<br>
     *                A dictionary of solver options.
     *                
     *                maxiter : int
     *                Maximum number of iterations to perform.
     *                disp : bool
     *                Set to True to print convergence messages.
     *                
     *                See :func:`show_options()` for solver-specific options.
     * 
     * @return res OptimizeResult<br>
     *             The optimization result represented as a ``OptimizeResult`` object.
     *             Important attributes are: ``x`` the solution array, ``success`` a
     *             Boolean flag indicating if the optimizer exited successfully and
     *             ``message`` which describes the cause of the termination. See
     *             `OptimizeResult` for a description of other attributes.
     */
    public final Object minimize_scalar(Object fun, Object... args) {
        write("optimize.minimize_scalar("+PythonGrammar.toPythonArgs(fun)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find a zero of a real or complex function using the Newton-Raphson
     * (or secant or Halley's) method.
     * 
     * Find a zero of the function `func` given a nearby starting point `x0`.
     * The Newton-Raphson method is used if the derivative `fprime` of `func`
     * is provided, otherwise the secant method is used. If the second order
     * derivative `fprime2` of `func` is also provided, then Halley's method is
     * used.
     * 
     * If `x0` is a sequence with more than one item, then `newton` returns an
     * array, and `func` must be vectorized and return a sequence or array of the
     * same shape as its first argument. If `fprime` or `fprime2` is given, then
     * its return must also have the same shape.
     * <p>
     * <em>Notes:</em><br>
     * The convergence rate of the Newton-Raphson method is quadratic,
     * the Halley method is cubic, and the secant method is
     * sub-quadratic. This means that if the function is well-behaved
     * the actual error in the estimated zero after the nth iteration
     * is approximately the square (cube for Halley) of the error
     * after the (n-1)th step. However, the stopping criterion used
     * here is the step size and there is no guarantee that a zero
     * has been found. Consequently, the result should be verified.
     * Safer algorithms are brentq, brenth, ridder, and bisect,
     * but they all require that the root first be bracketed in an
     * interval where the function changes sign. The brentq algorithm
     * is recommended for general use in one dimensional problems
     * when such an interval has been found.
     * 
     * When `newton` is used with arrays, it is best suited for the following
     * types of problems:
     * 
     * * The initial guesses, `x0`, are all relatively the same distance from
     * the roots.
     * * Some or all of the extra arguments, `args`, are also arrays so that a
     * class of similar problems can be solved together.
     * * The size of the initial guesses, `x0`, is larger than O(100) elements.
     * Otherwise, a naive loop may perform as well or better than a vector.
     * 
     * @param func callable<br>
     *             The function whose zero is wanted. It must be a function of a
     *             single variable of the form ``f(x,a,b,c...)``, where ``a,b,c...``
     *             are extra arguments that can be passed in the `args` parameter.
     * @param x0 float, sequence, or ndarray<br>
     *           An initial estimate of the zero that should be somewhere near the
     *           actual zero. If not scalar, then `func` must be vectorized and return
     *           a sequence or array of the same shape as its first argument.
     * @param fprime callable, optional<br>
     *               The derivative of the function when available and convenient. If it
     *               is None (default), then the secant method is used.
     * @param args tuple, optional<br>
     *             Extra arguments to be used in the function call.
     * @param tol float, optional<br>
     *            The allowable error of the zero value. If `func` is complex-valued,
     *            a larger `tol` is recommended as both the real and imaginary parts
     *            of `x` contribute to ``|x - x0|``.
     * @param maxiter int, optional<br>
     *                Maximum number of iterations.
     * @param fprime2 callable, optional<br>
     *                The second order derivative of the function when available and
     *                convenient. If it is None (default), then the normal Newton-Raphson
     *                or the secant method is used. If it is not None, then Halley's method
     *                is used.
     * @param x1 float, optional<br>
     *           Another estimate of the zero that should be somewhere near the
     *           actual zero. Used if `fprime` is not provided.
     * @param rtol float, optional<br>
     *             Tolerance (relative) for termination.
     * @param full_output bool, optional<br>
     *                    If `full_output` is False (default), the root is returned.
     *                    If True and `x0` is scalar, the return value is ``(x, r)``, where ``x``
     *                    is the root and ``r`` is a `RootResults` object.
     *                    If True and `x0` is non-scalar, the return value is ``(x, converged,
     *                    zero_der)`` (see Returns section for details).
     * @param disp bool, optional<br>
     *             If True, raise a RuntimeError if the algorithm didn't converge, with
     *             the error message containing the number of iterations and current
     *             function value. Otherwise, the convergence status is recorded in a
     *             `RootResults` return object.
     *             Ignored if `x0` is not scalar.
     *             *Note: this has little to do with displaying, however,
     *             the `disp` keyword cannot be renamed for backwards compatibility.*
     * 
     * @return (root,r,converged,zero_der) (float, sequence, or ndarray,`RootResults`, optional,ndarray of bool, optional,ndarray of bool, optional)<br>
     *          Estimated location where function is zero.
     *          
     *          Present if ``full_output=True`` and `x0` is scalar.
     *          Object containing information about the convergence. In particular,
     *          ``r.converged`` is True if the routine converged.
     *          
     *          Present if ``full_output=True`` and `x0` is non-scalar.
     *          For vector functions, indicates which elements converged successfully.
     *          
     *          Present if ``full_output=True`` and `x0` is non-scalar.
     *          For vector functions, indicates which elements had a zero derivative.
     */
    public final Object newton(Object func, Object x0, Object... args) {
        write("optimize.newton("+PythonGrammar.toPythonArgs(func),PythonGrammar.toPythonArgs(x0)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find a root of a function, using Krylov approximation for inverse Jacobian.
     * 
     * This method is suitable for solving large-scale problems.
     * <p>
     * <em>Notes:</em><br>
     * This function implements a Newton-Krylov solver. The basic idea is
     * to compute the inverse of the Jacobian with an iterative Krylov
     * method. These methods require only evaluating the Jacobian-vector
     * products, which are conveniently approximated by a finite difference:
     * 
     * .. math:: J v \approx (f(x + \omega*v/|v|) - f(x)) / \omega
     * 
     * Due to the use of iterative matrix inverses, these methods can
     * deal with large nonlinear problems.
     * 
     * SciPy's `scipy.sparse.linalg` module offers a selection of Krylov
     * solvers to choose from. The default here is `lgmres`, which is a
     * variant of restarted GMRES iteration that reuses some of the
     * information obtained in the previous Newton steps to invert
     * Jacobians in subsequent steps.
     * 
     * For a review on Newton-Krylov methods, see for example [1]_,
     * and for the LGMRES sparse inverse method, see [2]_.
     * 
     * @param F function(x) -&gt; f<br>
     *          Function whose root to find; should take and return an array-like
     *          object.
     * @param xin array_like<br>
     *            Initial guess for the solution
     * @param rdiff float, optional<br>
     *              Relative step size to use in numerical differentiation.
     * @param method &#123;'lgmres', 'gmres', 'bicgstab', 'cgs', 'minres'&#125; or function<br>
     *               Krylov method to use to approximate the Jacobian.
     *               Can be a string, or a function implementing the same interface as
     *               the iterative solvers in `scipy.sparse.linalg`.
     *               
     *               The default is `scipy.sparse.linalg.lgmres`.
     * @param inner_maxiter int, optional<br>
     *                      Parameter to pass to the "inner" Krylov solver: maximum number of
     *                      iterations. Iteration will stop after maxiter steps even if the
     *                      specified tolerance has not been achieved.
     * @param inner_M LinearOperator or InverseJacobian<br>
     *                Preconditioner for the inner Krylov iteration.
     *                Note that you can use also inverse Jacobians as (adaptive)
     *                preconditioners. For example,
     *                
     *                &gt;&gt;&gt; from scipy.optimize.nonlin import BroydenFirst, KrylovJacobian
     *                &gt;&gt;&gt; from scipy.optimize.nonlin import InverseJacobian
     *                &gt;&gt;&gt; jac = BroydenFirst()
     *                &gt;&gt;&gt; kjac = KrylovJacobian(inner_M=InverseJacobian(jac))
     *                
     *                If the preconditioner has a method named 'update', it will be called
     *                as ``update(x, f)`` after each nonlinear step, with ``x`` giving
     *                the current point, and ``f`` the current function value.
     * @param outer_k int, optional<br>
     *                Size of the subspace kept across LGMRES nonlinear iterations.
     *                See `scipy.sparse.linalg.lgmres` for details.
     * @param inner_kwargs kwargs<br>
     *                     Keyword parameters for the "inner" Krylov solver
     *                     (defined with `method`). Parameter names must start with
     *                     the `inner_` prefix which will be stripped before passing on
     *                     the inner method. See, e.g., `scipy.sparse.linalg.gmres` for details.
     * @param iter int, optional<br>
     *             Number of iterations to make. If omitted (default), make as many
     *             as required to meet tolerances.
     * @param verbose bool, optional<br>
     *                Print status to stdout on every iteration.
     * @param maxiter int, optional<br>
     *                Maximum number of iterations to make. If more are needed to
     *                meet convergence, `NoConvergence` is raised.
     * @param f_tol float, optional<br>
     *              Absolute tolerance (in max-norm) for the residual.
     *              If omitted, default is 6e-6.
     * @param f_rtol float, optional<br>
     *               Relative tolerance for the residual. If omitted, not used.
     * @param x_tol float, optional<br>
     *              Absolute minimum step size, as determined from the Jacobian
     *              approximation. If the step size is smaller than this, optimization
     *              is terminated as successful. If omitted, not used.
     * @param x_rtol float, optional<br>
     *               Relative minimum step size. If omitted, not used.
     * @param tol_norm function(vector) -&gt; scalar, optional<br>
     *                 Norm to use in convergence check. Default is the maximum norm.
     * @param line_search &#123;None, 'armijo' (default), 'wolfe'&#125;, optional<br>
     *                    Which type of a line search to use to determine the step size in the
     *                    direction given by the Jacobian approximation. Defaults to 'armijo'.
     * @param callback function, optional<br>
     *                 Optional callback function. It is called on every iteration as
     *                 ``callback(x, f)`` where `x` is the current solution and `f`
     *                 the corresponding residual.
     * @param **kw n/a<br>undocumented
     * 
     * @return sol ndarray<br>
     *             An array (of similar array type as `x0`) containing the final solution.
     */
    public final Object newton_krylov(Object F, Object xin, Object... args) {
        write("optimize.newton_krylov("+PythonGrammar.toPythonArgs(F),PythonGrammar.toPythonArgs(xin)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Solve ``argmin_x || Ax - b ||_2`` for ``x>=0``. This is a wrapper
     * for a FORTRAN non-negative least squares solver.
     * <p>
     * <em>Notes:</em><br>
     * The FORTRAN code was published in the book below. The algorithm
     * is an active set method. It solves the KKT (Karush-Kuhn-Tucker)
     * conditions for the non-negative least squares problem.
     * 
     * @param A ndarray<br>
     *          Matrix ``A`` as shown above.
     * @param b ndarray<br>
     *          Right-hand side vector.
     * @param maxiter int, optional<br>
     *                Maximum number of iterations, optional.
     *                Default is ``3 * A.shape[1]``.
     * 
     * @return (x,rnorm) (ndarray,float)<br>
     *          Solution vector.
     *          
     *          The residual, ``|| Ax-b ||_2``.
     */
    public final Object nnls(Object A, Object b, Object... args) {
        write("optimize.nnls("+PythonGrammar.toPythonArgs(A),PythonGrammar.toPythonArgs(b)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Approximates solution to the quadratic assignment problem and
     * the graph matching problem.
     * 
     * Quadratic assignment solves problems of the following form:
     * 
     * .. math::
     * 
     * \min_P & \ {\ \text{trace}(A^T P B P^T)}\\
     * \mbox{s.t. } & {P \ \epsilon \ \mathcal{P}}\\
     * 
     * where :math:`\mathcal{P}` is the set of all permutation matrices,
     * and :math:`A` and :math:`B` are square matrices.
     * 
     * Graph matching tries to *maximize* the same objective function.
     * This algorithm can be thought of as finding the alignment of the
     * nodes of two graphs that minimizes the number of induced edge
     * disagreements, or, in the case of weighted graphs, the sum of squared
     * edge weight differences.
     * 
     * Note that the quadratic assignment problem is NP-hard. The results given
     * here are approximations and are not guaranteed to be optimal.
     * <p>
     * <em>Notes:</em><br>
     * The default method :ref:`'faq' <optimize.qap-faq>` uses the Fast
     * Approximate QAP algorithm [1]_; it typically offers the best combination of
     * speed and accuracy.
     * Method :ref:`'2opt' <optimize.qap-2opt>` can be computationally expensive,
     * but may be a useful alternative, or it can be used to refine the solution
     * returned by another method.
     * 
     * @param A 2-D array, square<br>
     *          The square matrix :math:`A` in the objective function above.
     *          
     * @param B 2-D array, square<br>
     *          The square matrix :math:`B` in the objective function above.
     *          
     * @param method  str in &#123;'faq', '2opt'&#125; (default: 'faq')<br>
     *               The algorithm used to solve the problem.
     *               :ref:`'faq' &lt;optimize.qap-faq&gt;` (default) and
     *               :ref:`'2opt' &lt;optimize.qap-2opt&gt;` are available.
     *               
     * @param options dict, optional<br>
     *                A dictionary of solver options. All solvers support the following:
     *                
     *                maximize : bool (default: False)
     *                Maximizes the objective function if ``True``.
     *                
     *                partial_match : 2-D array of integers, optional (default: None)
     *                Fixes part of the matching. Also known as a "seed" [2]_.
     *                
     *                Each row of `partial_match` specifies a pair of matched nodes:
     *                node ``partial_match[i, 0]`` of `A` is matched to node
     *                ``partial_match[i, 1]`` of `B`. The array has shape ``(m, 2)``,
     *                where ``m`` is not greater than the number of nodes, :math:`n`.
     *                
     *                rng : &#123;None, int, `numpy.random.Generator`,
     *                `numpy.random.RandomState`&#125;, optional
     *                
     *                If `seed` is None (or `np.random`), the `numpy.random.RandomState`
     *                singleton is used.
     *                If `seed` is an int, a new ``RandomState`` instance is used,
     *                seeded with `seed`.
     *                If `seed` is already a ``Generator`` or ``RandomState`` instance then
     *                that instance is used.
     *                
     *                For method-specific options, see
     *                :func:`show_options('quadratic_assignment') &lt;show_options&gt;`.
     * 
     * @return res OptimizeResult<br>
     *             `OptimizeResult` containing the following fields.
     *             
     *             col_ind : 1-D array
     *             Column indices corresponding to the best permutation found of the
     *             nodes of `B`.
     *             fun : float
     *             The objective value of the solution.
     *             nit : int
     *             The number of iterations performed during optimization.
     */
    public final Object quadratic_assignment(Object A, Object B, Object... args) {
        write("optimize.quadratic_assignment("+PythonGrammar.toPythonArgs(A),PythonGrammar.toPythonArgs(B)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find a root of a function in an interval using Ridder's method.
     * <p>
     * <em>Notes:</em><br>
     * Uses [Ridders1979]_ method to find a zero of the function `f` between the
     * arguments `a` and `b`. Ridders' method is faster than bisection, but not
     * generally as fast as the Brent routines. [Ridders1979]_ provides the
     * classic description and source of the algorithm. A description can also be
     * found in any recent edition of Numerical Recipes.
     * 
     * The routine used here diverges slightly from standard presentations in
     * order to be a bit more careful of tolerance.
     * 
     * @param f function<br>
     *          Python function returning a number. f must be continuous, and f(a) and
     *          f(b) must have opposite signs.
     * @param a scalar<br>
     *          One end of the bracketing interval [a,b].
     * @param b scalar<br>
     *          The other end of the bracketing interval [a,b].
     * @param xtol number, optional<br>
     *             The computed root ``x0`` will satisfy ``np.allclose(x, x0,
     *             atol=xtol, rtol=rtol)``, where ``x`` is the exact root. The
     *             parameter must be nonnegative.
     * @param rtol number, optional<br>
     *             The computed root ``x0`` will satisfy ``np.allclose(x, x0,
     *             atol=xtol, rtol=rtol)``, where ``x`` is the exact root. The
     *             parameter cannot be smaller than its default value of
     *             ``4*np.finfo(float).eps``.
     * @param maxiter int, optional<br>
     *                If convergence is not achieved in `maxiter` iterations, an error is
     *                raised. Must be &gt;= 0.
     * @param args tuple, optional<br>
     *             Containing extra arguments for the function `f`.
     *             `f` is called by ``apply(f, (x)+args)``.
     * @param full_output bool, optional<br>
     *                    If `full_output` is False, the root is returned. If `full_output` is
     *                    True, the return value is ``(x, r)``, where `x` is the root, and `r` is
     *                    a `RootResults` object.
     * @param disp bool, optional<br>
     *             If True, raise RuntimeError if the algorithm didn't converge.
     *             Otherwise, the convergence status is recorded in any `RootResults`
     *             return object.
     * 
     * @return (x0,r) (float,`RootResults` (present if ``full_output = True``))<br>
     *          Zero of `f` between `a` and `b`.
     *          
     *          Object containing information about the convergence.
     *          In particular, ``r.converged`` is True if the routine converged.
     */
    public final Object ridder(Object f, Object a, Object b, Object... args) {
        write("optimize.ridder("+PythonGrammar.toPythonArgs(f),PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(b)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find a root of a vector function.
     * <p>
     * <em>Notes:</em><br>
     * This section describes the available solvers that can be selected by the
     * 'method' parameter. The default method is *hybr*.
     * 
     * Method *hybr* uses a modification of the Powell hybrid method as
     * implemented in MINPACK [1]_.
     * 
     * Method *lm* solves the system of nonlinear equations in a least squares
     * sense using a modification of the Levenberg-Marquardt algorithm as
     * implemented in MINPACK [1]_.
     * 
     * Method *df-sane* is a derivative-free spectral method. [3]_
     * 
     * Methods *broyden1*, *broyden2*, *anderson*, *linearmixing*,
     * *diagbroyden*, *excitingmixing*, *krylov* are inexact Newton methods,
     * with backtracking or full line searches [2]_. Each method corresponds
     * to a particular Jacobian approximations. See `nonlin` for details.
     * 
     * - Method *broyden1* uses Broyden's first Jacobian approximation, it is
     * known as Broyden's good method.
     * - Method *broyden2* uses Broyden's second Jacobian approximation, it
     * is known as Broyden's bad method.
     * - Method *anderson* uses (extended) Anderson mixing.
     * - Method *Krylov* uses Krylov approximation for inverse Jacobian. It
     * is suitable for large-scale problem.
     * - Method *diagbroyden* uses diagonal Broyden Jacobian approximation.
     * - Method *linearmixing* uses a scalar Jacobian approximation.
     * - Method *excitingmixing* uses a tuned diagonal Jacobian
     * approximation.
     * 
     * .. warning::
     * 
     * The algorithms implemented for methods *diagbroyden*,
     * *linearmixing* and *excitingmixing* may be useful for specific
     * problems, but whether they will work may depend strongly on the
     * problem.
     * 
     * .. versionadded:: 0.11.0
     * 
     * @param fun callable<br>
     *            A vector function to find a root of.
     * @param x0 ndarray<br>
     *           Initial guess.
     * @param args tuple, optional<br>
     *             Extra arguments passed to the objective function and its Jacobian.
     * @param method str, optional<br>
     *               Type of solver. Should be one of
     *               
     *               - 'hybr'             :ref:`(see here) &lt;optimize.root-hybr&gt;`
     *               - 'lm'               :ref:`(see here) &lt;optimize.root-lm&gt;`
     *               - 'broyden1'         :ref:`(see here) &lt;optimize.root-broyden1&gt;`
     *               - 'broyden2'         :ref:`(see here) &lt;optimize.root-broyden2&gt;`
     *               - 'anderson'         :ref:`(see here) &lt;optimize.root-anderson&gt;`
     *               - 'linearmixing'     :ref:`(see here) &lt;optimize.root-linearmixing&gt;`
     *               - 'diagbroyden'      :ref:`(see here) &lt;optimize.root-diagbroyden&gt;`
     *               - 'excitingmixing'   :ref:`(see here) &lt;optimize.root-excitingmixing&gt;`
     *               - 'krylov'           :ref:`(see here) &lt;optimize.root-krylov&gt;`
     *               - 'df-sane'          :ref:`(see here) &lt;optimize.root-dfsane&gt;`
     *               
     * @param jac bool or callable, optional<br>
     *            If `jac` is a Boolean and is True, `fun` is assumed to return the
     *            value of Jacobian along with the objective function. If False, the
     *            Jacobian will be estimated numerically.
     *            `jac` can also be a callable returning the Jacobian of `fun`. In
     *            this case, it must accept the same arguments as `fun`.
     * @param tol float, optional<br>
     *            Tolerance for termination. For detailed control, use solver-specific
     *            options.
     * @param callback function, optional<br>
     *                 Optional callback function. It is called on every iteration as
     *                 ``callback(x, f)`` where `x` is the current solution and `f`
     *                 the corresponding residual. For all methods but 'hybr' and 'lm'.
     * @param options dict, optional<br>
     *                A dictionary of solver options. E.g., `xtol` or `maxiter`, see
     *                :obj:`show_options()` for details.
     * 
     * @return sol OptimizeResult<br>
     *             The solution represented as a ``OptimizeResult`` object.
     *             Important attributes are: ``x`` the solution array, ``success`` a
     *             Boolean flag indicating if the algorithm exited successfully and
     *             ``message`` which describes the cause of the termination. See
     *             `OptimizeResult` for a description of other attributes.
     */
    public final Object root(Object fun, Object x0, Object... args) {
        write("optimize.root("+PythonGrammar.toPythonArgs(fun),PythonGrammar.toPythonArgs(x0)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find a root of a scalar function.
     * <p>
     * <em>Notes:</em><br>
     * This section describes the available solvers that can be selected by the
     * 'method' parameter.
     * 
     * The default is to use the best method available for the situation
     * presented.
     * If a bracket is provided, it may use one of the bracketing methods.
     * If a derivative and an initial value are specified, it may
     * select one of the derivative-based methods.
     * If no method is judged applicable, it will raise an Exception.
     * 
     * @param f callable<br>
     *          A function to find a root of.
     * @param args tuple, optional<br>
     *             Extra arguments passed to the objective function and its derivative(s).
     * @param method str, optional<br>
     *               Type of solver.  Should be one of
     *               
     *               - 'bisect'    :ref:`(see here) &lt;optimize.root_scalar-bisect&gt;`
     *               - 'brentq'    :ref:`(see here) &lt;optimize.root_scalar-brentq&gt;`
     *               - 'brenth'    :ref:`(see here) &lt;optimize.root_scalar-brenth&gt;`
     *               - 'ridder'    :ref:`(see here) &lt;optimize.root_scalar-ridder&gt;`
     *               - 'toms748'    :ref:`(see here) &lt;optimize.root_scalar-toms748&gt;`
     *               - 'newton'    :ref:`(see here) &lt;optimize.root_scalar-newton&gt;`
     *               - 'secant'    :ref:`(see here) &lt;optimize.root_scalar-secant&gt;`
     *               - 'halley'    :ref:`(see here) &lt;optimize.root_scalar-halley&gt;`
     *               
     * @param bracket A sequence of 2 floats, optional<br>
     *                An interval bracketing a root.  `f(x, *args)` must have different
     *                signs at the two endpoints.
     * @param x0 float, optional<br>
     *           Initial guess.
     * @param x1 float, optional<br>
     *           A second guess.
     * @param fprime bool or callable, optional<br>
     *               If `fprime` is a boolean and is True, `f` is assumed to return the
     *               value of the objective function and of the derivative.
     *               `fprime` can also be a callable returning the derivative of `f`. In
     *               this case, it must accept the same arguments as `f`.
     * @param fprime2 bool or callable, optional<br>
     *                If `fprime2` is a boolean and is True, `f` is assumed to return the
     *                value of the objective function and of the
     *                first and second derivatives.
     *                `fprime2` can also be a callable returning the second derivative of `f`.
     *                In this case, it must accept the same arguments as `f`.
     * @param xtol float, optional<br>
     *             Tolerance (absolute) for termination.
     * @param rtol float, optional<br>
     *             Tolerance (relative) for termination.
     * @param maxiter int, optional<br>
     *                Maximum number of iterations.
     * @param options dict, optional<br>
     *                A dictionary of solver options. E.g., ``k``, see
     *                :obj:`show_options()` for details.
     * 
     * @return sol RootResults<br>
     *             The solution represented as a ``RootResults`` object.
     *             Important attributes are: ``root`` the solution , ``converged`` a
     *             boolean flag indicating if the algorithm exited successfully and
     *             ``flag`` which describes the cause of the termination. See
     *             `RootResults` for a description of other attributes.
     */
    public final Object root_scalar(Object f, Object... args) {
        write("optimize.root_scalar("+PythonGrammar.toPythonArgs(f)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * The Rosenbrock function.
     * 
     * The function computed is::
     * 
     * sum(100.0*(x[1:] - x[:-1]**2.0)**2.0 + (1 - x[:-1])**2.0)
     * 
     * @param x array_like<br>
     *          1-D array of points at which the Rosenbrock function is to be computed.
     * 
     * @return f float<br>
     *           The value of the Rosenbrock function.
     */
    public final Object rosen(Object x) {
        write("optimize.rosen("+PythonGrammar.toPythonArgs(x)+")");
        return null;
    }

    /**
     * The derivative (i.e. gradient) of the Rosenbrock function.
     * 
     * @param x array_like<br>
     *          1-D array of points at which the derivative is to be computed.
     * 
     * @return rosen_der (N,) ndarray<br>
     *                   The gradient of the Rosenbrock function at `x`.
     */
    public final Object rosen_der(Object x) {
        write("optimize.rosen_der("+PythonGrammar.toPythonArgs(x)+")");
        return null;
    }

    /**
     * The Hessian matrix of the Rosenbrock function.
     * 
     * @param x array_like<br>
     *          1-D array of points at which the Hessian matrix is to be computed.
     * 
     * @return rosen_hess ndarray<br>
     *                    The Hessian matrix of the Rosenbrock function at `x`.
     */
    public final Object rosen_hess(Object x) {
        write("optimize.rosen_hess("+PythonGrammar.toPythonArgs(x)+")");
        return null;
    }

    /**
     * Product of the Hessian matrix of the Rosenbrock function with a vector.
     * 
     * @param x array_like<br>
     *          1-D array of points at which the Hessian matrix is to be computed.
     * @param p array_like<br>
     *          1-D array, the vector to be multiplied by the Hessian matrix.
     * 
     * @return rosen_hess_prod ndarray<br>
     *                         The Hessian matrix of the Rosenbrock function at `x` multiplied
     *                         by the vector `p`.
     */
    public final Object rosen_hess_prod(Object x, Object p) {
        write("optimize.rosen_hess_prod("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(p)+")");
        return null;
    }

    /**
     * Finds the global minimum of a function using SHG optimization.
     * 
     * SHGO stands for "simplicial homology global optimization".
     * <p>
     * <em>Notes:</em><br>
     * Global optimization using simplicial homology global optimization [1]_.
     * Appropriate for solving general purpose NLP and blackbox optimization
     * problems to global optimality (low-dimensional problems).
     * 
     * In general, the optimization problems are of the form::
     * 
     * minimize f(x) subject to
     * 
     * g_i(x) >= 0,  i = 1,...,m
     * h_j(x)  = 0,  j = 1,...,p
     * 
     * where x is a vector of one or more variables. ``f(x)`` is the objective
     * function ``R^n -> R``, ``g_i(x)`` are the inequality constraints, and
     * ``h_j(x)`` are the equality constraints.
     * 
     * Optionally, the lower and upper bounds for each element in x can also be
     * specified using the `bounds` argument.
     * 
     * While most of the theoretical advantages of SHGO are only proven for when
     * ``f(x)`` is a Lipschitz smooth function, the algorithm is also proven to
     * converge to the global optimum for the more general case where ``f(x)`` is
     * non-continuous, non-convex and non-smooth, if the default sampling method
     * is used [1]_.
     * 
     * The local search method may be specified using the ``minimizer_kwargs``
     * parameter which is passed on to ``scipy.optimize.minimize``. By default,
     * the ``SLSQP`` method is used. In general, it is recommended to use the
     * ``SLSQP`` or ``COBYLA`` local minimization if inequality constraints
     * are defined for the problem since the other methods do not use constraints.
     * 
     * The ``halton`` and ``sobol`` method points are generated using
     * `scipy.stats.qmc`. Any other QMC method could be used.
     * 
     * @param func callable<br>
     *             The objective function to be minimized.  Must be in the form
     *             ``f(x, *args)``, where ``x`` is the argument in the form of a 1-D array
     *             and ``args`` is a tuple of any additional fixed parameters needed to
     *             completely specify the function.
     * @param bounds sequence<br>
     *               Bounds for variables.  ``(min, max)`` pairs for each element in ``x``,
     *               defining the lower and upper bounds for the optimizing argument of
     *               `func`. It is required to have ``len(bounds) == len(x)``.
     *               ``len(bounds)`` is used to determine the number of parameters in ``x``.
     *               Use ``None`` for one of min or max when there is no bound in that
     *               direction. By default bounds are ``(None, None)``.
     * @param args tuple, optional<br>
     *             Any additional fixed parameters needed to completely specify the
     *             objective function.
     * @param constraints dict or sequence of dict, optional<br>
     *                    Constraints definition.
     *                    Function(s) ``R**n`` in the form::
     *                    
     *                    g(x) &gt;= 0 applied as g : R^n -&gt; R^m
     *                    h(x) == 0 applied as h : R^n -&gt; R^p
     *                    
     *                    Each constraint is defined in a dictionary with fields:
     *                    
     *                    type : str
     *                    Constraint type: 'eq' for equality, 'ineq' for inequality.
     *                    fun : callable
     *                    The function defining the constraint.
     *                    jac : callable, optional
     *                    The Jacobian of `fun` (only for SLSQP).
     *                    args : sequence, optional
     *                    Extra arguments to be passed to the function and Jacobian.
     *                    
     *                    Equality constraint means that the constraint function result is to
     *                    be zero whereas inequality means that it is to be non-negative.
     *                    Note that COBYLA only supports inequality constraints.
     *                    
     *                    .. note::
     *                    
     *                    Only the COBYLA and SLSQP local minimize methods currently
     *                    support constraint arguments. If the ``constraints`` sequence
     *                    used in the local optimization problem is not defined in
     *                    ``minimizer_kwargs`` and a constrained method is used then the
     *                    global ``constraints`` will be used.
     *                    (Defining a ``constraints`` sequence in ``minimizer_kwargs``
     *                    means that ``constraints`` will not be added so if equality
     *                    constraints and so forth need to be added then the inequality
     *                    functions in ``constraints`` need to be added to
     *                    ``minimizer_kwargs`` too).
     *                    
     * @param n int, optional<br>
     *          Number of sampling points used in the construction of the simplicial
     *          complex. Note that this argument is only used for ``sobol`` and other
     *          arbitrary `sampling_methods`. In case of ``sobol``, it must be a
     *          power of 2: ``n=2**m``, and the argument will automatically be
     *          converted to the next higher power of 2. Default is 100 for
     *          ``sampling_method='simplicial'`` and 128 for
     *          ``sampling_method='sobol'``.
     * @param iters int, optional<br>
     *              Number of iterations used in the construction of the simplicial
     *              complex. Default is 1.
     * @param callback callable, optional<br>
     *                 Called after each iteration, as ``callback(xk)``, where ``xk`` is the
     *                 current parameter vector.
     * @param minimizer_kwargs dict, optional<br>
     *                         Extra keyword arguments to be passed to the minimizer
     *                         ``scipy.optimize.minimize`` Some important options could be:
     *                         
     *                         * method : str
     *                         The minimization method, the default is ``SLSQP``.
     *                         * args : tuple
     *                         Extra arguments passed to the objective function (``func``) and
     *                         its derivatives (Jacobian, Hessian).
     *                         * options : dict, optional
     *                         Note that by default the tolerance is specified as
     *                         ``&#123;ftol: 1e-12&#125;``
     *                         
     * @param options dict, optional<br>
     *                A dictionary of solver options. Many of the options specified for the
     *                global routine are also passed to the scipy.optimize.minimize routine.
     *                The options that are also passed to the local routine are marked with
     *                "(L)".
     *                
     *                Stopping criteria, the algorithm will terminate if any of the specified
     *                criteria are met. However, the default algorithm does not require any to
     *                be specified:
     *                
     *                * maxfev : int (L)
     *                Maximum number of function evaluations in the feasible domain.
     *                (Note only methods that support this option will terminate
     *                the routine at precisely exact specified value. Otherwise the
     *                criterion will only terminate during a global iteration)
     *                * f_min
     *                Specify the minimum objective function value, if it is known.
     *                * f_tol : float
     *                Precision goal for the value of f in the stopping
     *                criterion. Note that the global routine will also
     *                terminate if a sampling point in the global routine is
     *                within this tolerance.
     *                * maxiter : int
     *                Maximum number of iterations to perform.
     *                * maxev : int
     *                Maximum number of sampling evaluations to perform (includes
     *                searching in infeasible points).
     *                * maxtime : float
     *                Maximum processing runtime allowed
     *                * minhgrd : int
     *                Minimum homology group rank differential. The homology group of the
     *                objective function is calculated (approximately) during every
     *                iteration. The rank of this group has a one-to-one correspondence
     *                with the number of locally convex subdomains in the objective
     *                function (after adequate sampling points each of these subdomains
     *                contain a unique global minimum). If the difference in the hgr is 0
     *                between iterations for ``maxhgrd`` specified iterations the
     *                algorithm will terminate.
     *                
     *                Objective function knowledge:
     *                
     *                * symmetry : bool
     *                Specify True if the objective function contains symmetric variables.
     *                The search space (and therefore performance) is decreased by O(n!).
     *                
     *                * jac : bool or callable, optional
     *                Jacobian (gradient) of objective function. Only for CG, BFGS,
     *                Newton-CG, L-BFGS-B, TNC, SLSQP, dogleg, trust-ncg. If ``jac`` is a
     *                boolean and is True, ``fun`` is assumed to return the gradient along
     *                with the objective function. If False, the gradient will be
     *                estimated numerically. ``jac`` can also be a callable returning the
     *                gradient of the objective. In this case, it must accept the same
     *                arguments as ``fun``. (Passed to `scipy.optimize.minmize` automatically)
     *                
     *                * hess, hessp : callable, optional
     *                Hessian (matrix of second-order derivatives) of objective function
     *                or Hessian of objective function times an arbitrary vector p.
     *                Only for Newton-CG, dogleg, trust-ncg. Only one of ``hessp`` or
     *                ``hess`` needs to be given. If ``hess`` is provided, then
     *                ``hessp`` will be ignored. If neither ``hess`` nor ``hessp`` is
     *                provided, then the Hessian product will be approximated using
     *                finite differences on ``jac``. ``hessp`` must compute the Hessian
     *                times an arbitrary vector. (Passed to `scipy.optimize.minmize`
     *                automatically)
     *                
     *                Algorithm settings:
     *                
     *                * minimize_every_iter : bool
     *                If True then promising global sampling points will be passed to a
     *                local minimization routine every iteration. If False then only the
     *                final minimizer pool will be run. Defaults to False.
     *                * local_iter : int
     *                Only evaluate a few of the best minimizer pool candidates every
     *                iteration. If False all potential points are passed to the local
     *                minimization routine.
     *                * infty_constraints: bool
     *                If True then any sampling points generated which are outside will
     *                the feasible domain will be saved and given an objective function
     *                value of ``inf``. If False then these points will be discarded.
     *                Using this functionality could lead to higher performance with
     *                respect to function evaluations before the global minimum is found,
     *                specifying False will use less memory at the cost of a slight
     *                decrease in performance. Defaults to True.
     *                
     *                Feedback:
     *                
     *                * disp : bool (L)
     *                Set to True to print convergence messages.
     *                
     * @param sampling_method str or function, optional<br>
     *                        Current built in sampling method options are ``halton``, ``sobol`` and
     *                        ``simplicial``. The default ``simplicial`` provides
     *                        the theoretical guarantee of convergence to the global minimum in finite
     *                        time. ``halton`` and ``sobol`` method are faster in terms of sampling
     *                        point generation at the cost of the loss of
     *                        guaranteed convergence. It is more appropriate for most "easier"
     *                        problems where the convergence is relatively fast.
     *                        User defined sampling functions must accept two arguments of ``n``
     *                        sampling points of dimension ``dim`` per call and output an array of
     *                        sampling points with shape `n x dim`.
     * 
     * @return res OptimizeResult<br>
     *             The optimization result represented as a `OptimizeResult` object.
     *             Important attributes are:
     *             ``x`` the solution array corresponding to the global minimum,
     *             ``fun`` the function output at the global solution,
     *             ``xl`` an ordered list of local minima solutions,
     *             ``funl`` the function output at the corresponding local solutions,
     *             ``success`` a Boolean flag indicating if the optimizer exited
     *             successfully,
     *             ``message`` which describes the cause of the termination,
     *             ``nfev`` the total number of objective function evaluations including
     *             the sampling calls,
     *             ``nlfev`` the total number of objective function evaluations
     *             culminating from all local search optimizations,
     *             ``nit`` number of iterations performed by the global routine.
     */
    public final Object shgo(Object func, Object bounds, Object... args) {
        write("optimize.shgo("+PythonGrammar.toPythonArgs(func),PythonGrammar.toPythonArgs(bounds)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Show documentation for additional options of optimization solvers.
     * 
     * These are method-specific options that can be supplied through the
     * ``options`` dict.
     * <p>
     * <em>Notes:</em><br>
     * The solver-specific methods are:
     * 
     * `scipy.optimize.minimize`
     * 
     * - :ref:`Nelder-Mead <optimize.minimize-neldermead>`
     * - :ref:`Powell      <optimize.minimize-powell>`
     * - :ref:`CG          <optimize.minimize-cg>`
     * - :ref:`BFGS        <optimize.minimize-bfgs>`
     * - :ref:`Newton-CG   <optimize.minimize-newtoncg>`
     * - :ref:`L-BFGS-B    <optimize.minimize-lbfgsb>`
     * - :ref:`TNC         <optimize.minimize-tnc>`
     * - :ref:`COBYLA      <optimize.minimize-cobyla>`
     * - :ref:`SLSQP       <optimize.minimize-slsqp>`
     * - :ref:`dogleg      <optimize.minimize-dogleg>`
     * - :ref:`trust-ncg   <optimize.minimize-trustncg>`
     * 
     * `scipy.optimize.root`
     * 
     * - :ref:`hybr              <optimize.root-hybr>`
     * - :ref:`lm                <optimize.root-lm>`
     * - :ref:`broyden1          <optimize.root-broyden1>`
     * - :ref:`broyden2          <optimize.root-broyden2>`
     * - :ref:`anderson          <optimize.root-anderson>`
     * - :ref:`linearmixing      <optimize.root-linearmixing>`
     * - :ref:`diagbroyden       <optimize.root-diagbroyden>`
     * - :ref:`excitingmixing    <optimize.root-excitingmixing>`
     * - :ref:`krylov            <optimize.root-krylov>`
     * - :ref:`df-sane           <optimize.root-dfsane>`
     * 
     * `scipy.optimize.minimize_scalar`
     * 
     * - :ref:`brent       <optimize.minimize_scalar-brent>`
     * - :ref:`golden      <optimize.minimize_scalar-golden>`
     * - :ref:`bounded     <optimize.minimize_scalar-bounded>`
     * 
     * `scipy.optimize.root_scalar`
     * 
     * - :ref:`bisect  <optimize.root_scalar-bisect>`
     * - :ref:`brentq  <optimize.root_scalar-brentq>`
     * - :ref:`brenth  <optimize.root_scalar-brenth>`
     * - :ref:`ridder  <optimize.root_scalar-ridder>`
     * - :ref:`toms748 <optimize.root_scalar-toms748>`
     * - :ref:`newton  <optimize.root_scalar-newton>`
     * - :ref:`secant  <optimize.root_scalar-secant>`
     * - :ref:`halley  <optimize.root_scalar-halley>`
     * 
     * `scipy.optimize.linprog`
     * 
     * - :ref:`simplex           <optimize.linprog-simplex>`
     * - :ref:`interior-point    <optimize.linprog-interior-point>`
     * - :ref:`revised simplex   <optimize.linprog-revised_simplex>`
     * - :ref:`highs             <optimize.linprog-highs>`
     * - :ref:`highs-ds          <optimize.linprog-highs-ds>`
     * - :ref:`highs-ipm         <optimize.linprog-highs-ipm>`
     * 
     * `scipy.optimize.quadratic_assignment`
     * 
     * - :ref:`faq             <optimize.qap-faq>`
     * - :ref:`2opt            <optimize.qap-2opt>`
     * 
     * @param solver str<br>
     *               Type of optimization solver. One of 'minimize', 'minimize_scalar',
     *               'root', 'root_scalar', 'linprog', or 'quadratic_assignment'.
     * @param method str, optional<br>
     *               If not given, shows all methods of the specified solver. Otherwise,
     *               show only the options for the specified method. Valid values
     *               corresponds to methods' names of respective solver (e.g., 'BFGS' for
     *               'minimize').
     * @param disp bool, optional<br>
     *             Whether to print the result rather than returning it.
     * 
     * @return text <br>
     *              Either None (for disp=True) or the text string (disp=False)
     */
    public final Object show_options(Object... args) {
        write("optimize.show_options("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find a zero using TOMS Algorithm 748 method.
     * 
     * Implements the Algorithm 748 method of Alefeld, Potro and Shi to find a
     * zero of the function `f` on the interval `[a , b]`, where `f(a)` and
     * `f(b)` must have opposite signs.
     * 
     * It uses a mixture of inverse cubic interpolation and
     * "Newton-quadratic" steps. [APS1995].
     * <p>
     * <em>Notes:</em><br>
     * `f` must be continuous.
     * Algorithm 748 with ``k=2`` is asymptotically the most efficient
     * algorithm known for finding roots of a four times continuously
     * differentiable function.
     * In contrast with Brent's algorithm, which may only decrease the length of
     * the enclosing bracket on the last step, Algorithm 748 decreases it each
     * iteration with the same asymptotic efficiency as it finds the root.
     * 
     * For easy statement of efficiency indices, assume that `f` has 4
     * continuouous deriviatives.
     * For ``k=1``, the convergence order is at least 2.7, and with about
     * asymptotically 2 function evaluations per iteration, the efficiency
     * index is approximately 1.65.
     * For ``k=2``, the order is about 4.6 with asymptotically 3 function
     * evaluations per iteration, and the efficiency index 1.66.
     * For higher values of `k`, the efficiency index approaches
     * the kth root of ``(3k-2)``, hence ``k=1`` or ``k=2`` are
     * usually appropriate.
     * 
     * @param f function<br>
     *          Python function returning a scalar. The function :math:`f`
     *          must be continuous, and :math:`f(a)` and :math:`f(b)`
     *          have opposite signs.
     * @param a scalar,<br>
     *          lower boundary of the search interval
     * @param b scalar,<br>
     *          upper boundary of the search interval
     * @param args tuple, optional<br>
     *             containing extra arguments for the function `f`.
     *             `f` is called by ``f(x, *args)``.
     * @param k int, optional<br>
     *          The number of Newton quadratic steps to perform each
     *          iteration. ``k&gt;=1``.
     * @param xtol scalar, optional<br>
     *             The computed root ``x0`` will satisfy ``np.allclose(x, x0,
     *             atol=xtol, rtol=rtol)``, where ``x`` is the exact root. The
     *             parameter must be nonnegative.
     * @param rtol scalar, optional<br>
     *             The computed root ``x0`` will satisfy ``np.allclose(x, x0,
     *             atol=xtol, rtol=rtol)``, where ``x`` is the exact root.
     * @param maxiter int, optional<br>
     *                If convergence is not achieved in `maxiter` iterations, an error is
     *                raised. Must be &gt;= 0.
     * @param full_output bool, optional<br>
     *                    If `full_output` is False, the root is returned. If `full_output` is
     *                    True, the return value is ``(x, r)``, where `x` is the root, and `r` is
     *                    a `RootResults` object.
     * @param disp bool, optional<br>
     *             If True, raise RuntimeError if the algorithm didn't converge.
     *             Otherwise, the convergence status is recorded in the `RootResults`
     *             return object.
     * 
     * @return (x0,r) (float,`RootResults` (present if ``full_output = True``))<br>
     *          Approximate Zero of `f`
     *          
     *          Object containing information about the convergence. In particular,
     *          ``r.converged`` is True if the routine converged.
     */
    public final Object toms748(Object f, Object a, Object b, Object... args) {
        write("optimize.toms748("+PythonGrammar.toPythonArgs(f),PythonGrammar.toPythonArgs(a),PythonGrammar.toPythonArgs(b)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

}
