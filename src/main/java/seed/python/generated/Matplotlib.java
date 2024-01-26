package seed.python.generated;

import seed.python.core.PythonGrammar;
import seed.python.core.PythonScript;

public final class Matplotlib extends PythonScript {

    /**
     * Plot the autocorrelation of <b>x</b>0.
     * <p>
     * <em>Notes:</em><br>
     * The cross correlation is performed with `numpy.correlate` with
     * ``mode = "full"``.
     * 
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * the following arguments can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception):
     * <b>x</b>0.
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param x array-like<br>
     *          
     * @param detrend callable, default: `.mlab.detrend_none` (no detrending)<br>
     *                A detrending function applied to <b>x</b>0.  It must have the
     *                signature ::
     *                
     *                detrend(x: np.ndarray) -&gt; np.ndarray
     *                
     * @param normed bool, default: True<br>
     *               If ``True``, input vectors are normalised to unit length.
     *               
     * @param usevlines bool, default: True<br>
     *                  Determines the plot style.
     *                  
     *                  If ``True``, vertical lines are plotted from 0 to the acorr value
     *                  using `.Axes.vlines`. Additionally, a horizontal line is plotted
     *                  at y=0 using `.Axes.axhline`.
     *                  
     *                  If ``False``, markers are plotted at the acorr values using
     *                  `.Axes.plot`.
     *                  
     * @param maxlags int, default: 10<br>
     *                Number of lags to show. If ``None``, will return all
     *                ``2 * len(x) - 1`` lags.
     * @param linestyle `.Line2D` property, optional<br>
     *                  The linestyle for plotting the data points.
     *                  Only used if <b>usevlines</b>0 is ``False``.
     *                  
     * @param marker str, default: 'o'<br>
     *               The marker for plotting the data points.
     *               Only used if <b>usevlines</b>0 is ``False``.
     *               
     * @param **kwargs <br>
     *                 Additional parameters are passed to `.Axes.vlines` and
     *                 `.Axes.axhline` if <b>usevlines</b>0 is ``True``; otherwise they are
     *                 passed to `.Axes.plot`.
     * @param data n/a<br>undocumented
     * 
     * @return (lags,c,line,b) (array (length ``2*maxlags+1``),array  (length ``2*maxlags+1``),`.LineCollection` or `.Line2D`,`.Line2D` or None)<br>
     *          The lag vector.
     *          
     *          The auto correlation vector.
     *          
     *          `.Artist` added to the Axes of the correlation:
     *          
     *          - `.LineCollection` if <b>usevlines</b>0 is True.
     *          - `.Line2D` if<b>usevlines</b>5lines* is False.
     *          
     *          Horizontal line a<b>usevlines</b>10 0 if *usevlines* is True
  <b>usevlines</b>15e
     *          None *usevlines* is False.
     */
    public final Object acorr(Object x, Object... args) {
        write("plt.acorr("+PythonGrammar.toPythonArgs(x)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Plot the angle spectrum.
     * 
     * Compute the angle spectrum (wrapped phase spectrum) of <b>x</b>0.
     * Data is padded to a length of <b>pad_to</b>0 and the windowing function
     * <b>window</b>0 is applied to the signal.
     * <p>
     * <em>Notes:</em><br>
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * the following arguments can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception):
     * <b>x</b>0.
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param x 1-D array or sequence<br>
     *          Array or sequence containing the data.
     *          
     * @param Fs float, default: 2<br>
     *           The sampling frequency (samples per time unit).  It is used to calculate
     *           the Fourier frequencies, <b>freqs</b>0, in cycles per time unit.
     *           
     * @param window callable or ndarray, default: `.window_hanning`<br>
     *               A function or a vector of length <b>NFFT</b>0.  To create window vectors see
     *               `.window_hanning`, `.window_none`, `numpy.blackman`, `numpy.hamming`,
     *               `numpy.bartlett`, `scipy.signal`, `scipy.signal.get_window`, etc.  If a
     *               function is passed as the argument, it must take a data segment as an
     *               argument and return the windowed version of the segment.
     *               
     * @param sides &#123;'default', 'onesided', 'twosided'&#125;, optional<br>
     *              Which sides of the spectrum to return. 'default' is one-sided for real
     *              data and two-sided for complex data. 'onesided' forces the return of a
     *              one-sided spectrum, while 'twosided' forces two-sided.
     *              
     * @param pad_to int, optional<br>
     *               The number of points to which the data segment is padded when performing
     *               the FFT.  While not increasing the actual resolution of the spectrum (the
     *               minimum distance between resolvable peaks), this can give more points in
     *               the plot, allowing for more detail. This corresponds to the <b>n</b>0 parameter
     *               in the call to fft().  The default is None, which sets<b>pad_to</b>5ad_to* equal to
     *               the length of the input signal (i.e. no padding).
     *               
     * @param Fc int, default: 0<br>
     *           The center frequency of <b>x</b>0, which offsets the x extents of the
     *           plot to reflect the frequency range used when a signal is acquired
     *           and then filtered and downsampled to baseband.
     * @param **kwargs <br>
     *                 Keyword arguments control the `.Line2D` properties:
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: scalar or None
     *                 animated: bool
     *                 antialiased or aa: bool
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 color or c: color
     *                 contains: unknown
     *                 dash_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 dash_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 dashes: sequence of floats (on/off ink in points) or (None, None)
     *                 data: (2, N) array or two 1D arrays
     *                 drawstyle or ds: &#123;'default', 'steps', 'steps-pre', 'steps-mid', 'steps-post'&#125;, default: 'default'
     *                 figure: `.Figure`
     *                 fillstyle: &#123;'full', 'left', 'right', 'bottom', 'top', 'none'&#125;
     *                 gid: str
     *                 in_layout: bool
     *                 label: object
     *                 linestyle or ls: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *                 linewidth or lw: float
     *                 marker: marker style string, `~.path.Path` or `~.markers.MarkerStyle`
     *                 markeredgecolor or mec: color
     *                 markeredgewidth or mew: float
     *                 markerfacecolor or mfc: color
     *                 markerfacecoloralt or mfcalt: color
     *                 markersize or ms: float
     *                 markevery: None or int or (int, int) or slice or list[int] or float or (float, float) or list[bool]
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: float or callable[[Artist, Event], tuple[bool, dict]]
     *                 pickradius: float
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 solid_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 solid_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 transform: `matplotlib.transforms.Transform`
     *                 url: str
     *                 visible: bool
     *                 xdata: 1D array
     *                 ydata: 1D array
     *                 zorder: float
     * @param data n/a<br>undocumented
     * 
     * @return (spectrum,freqs,line) (1-D array,1-D array,`~matplotlib.lines.Line2D`)<br>
     *          The values for the angle spectrum in radians (real valued).
     *          
     *          
     *          The frequencies corresponding to the elements in <b>spectrum</b>0.
     *          
     *          
     *          The line created by this function.
     */
    public final Object angle_spectrum(Object x, Object... args) {
        write("plt.angle_spectrum("+PythonGrammar.toPythonArgs(x)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Annotate the point <b>xy</b>0 with text<b>text</b>5*text*.
     * 
     * In the simplest form, the text is placed at <b>xy</b>0.
     * 
     * Optionally, the text can be displayed in another position <b>xytext</b>0.
     * An arrow pointing from the text to the annotated point <b>xy</b>0 can then
     * be added by defining <b>arrowprops</b>0.
     * 
     * @param text str<br>
     *             The text of the annotation.
     *             
     * @param xy (float, float)<br>
     *           The point *(x, y)* to annotate. The coordinate system is determined
     *           by <b>xycoords</b>0.
     *           
     * @param xytext (float, float), default: <b>xy</b>0<br>
     *               The position *(x, y)* to place the text at. The coordinate system
     *               is determined by<b>textcoords</b>5oords*.
     *               
     * @param xycoords str or `.Artist` or `.Transform` or callable or (float, float), default: 'data'<br>
     *                 
     *                 The coordinate system that <b>xy</b>0 is given in. The following types
     *                 of values are supported:
     *                 
     *                 - One of the following strings:
     *                 
     *                 ==================== ============================================
     *                 Value                Description
     *                 ==================== ============================================
     *                 'figure points'      Points from the lower left of the figure
     *                 'figure pixels'      Pixels from the lower left of the figure
     *                 'figure fraction'    Fraction of figure from lower left
     *                 'subfigure points'   Points from the lower left of the subfigure
     *                 'subfigure pixels'   Pixels from the lower left of the subfigure
     *                 'subfigure fraction' Fraction of subfigure from lower left
     *                 'axes points'        Points from lower left corner of axes
     *                 'axes pixels'        Pixels from lower left corner of axes
     *                 'axes fraction'      Fraction of axes from lower left
     *                 'data'               Use the coordinate system of the object
     *                 being annotated (default)
     *                 'polar'              *(theta, r)* if not native 'data'
     *                 coordinates
     *                 ==================== ============================================
     *                 
     *                 Note that 'subfigure pixels' and 'figure pixels' are the same
     *                 for the parent figure, so users who want code that is usable in
     *                 a subfigure can use 'subfigure pixels'.
     *                 
     *                 - An `.Artist`:<b>xy</b>5: *xy* is interpreted as a fraction of the artist's
     *                 `~matplotlib.transforms.Bbox`. E.g. *(0, 0)* would be the lower
     *                 left corner of the bounding box and *(0.5, 1)* would be the
     *                 center top of the bounding box.
     *                 
     *                 - A `.Transform` to tra<b>xy</b>10to transform *xy* to screen coordinates.
     *                 
     *                 - A function with one of the following signatures::
     *                 
     *                 def transform(renderer) -&gt; Bbox
     *                 def transform(renderer) -&gt; Transform
     *                 
     *    <b>renderer</b>15*                 where *renderer* is a `.RendererBase` subclass.
     *                 
     *                 The result of the function is interpreted like the `.Artist` and
     *                 `.Transform` cases above.
     *                 
     *                 - A tuple *(xcoords, ycoords)* specifying separate coordinate<b>x</b>20par<b>y</b>25<b>xcoords</b>30>x<<b>ycoords</b>35y</b>25<b>xcoords</b>30>x</b>20par<b>y</b>25oordinate<b>x</b>20parate coordinate
     *                 systems for *x* and *y*. *xcoords* and *ycoords* must each be
     *                 of one of the above described types.
     *                 
     *                 See :ref:`plotting-guide-annotation` for more details.
     *                 
     * @param textcoords str or `.Artist` or `.Transform` or callable or (float, float), default: value of <b>xycoords</b>0<br>
     *                   The coordinate system that<b>xytext</b>5ytext* is given in.
     *                   
     *                <b>xycoords</b>10   All *xycoords* values are valid as well as the following
     *                   strings:
     *                   
     *                   =================   =========================================
     *                   Value               Description
     *                   =================   =========================================
     *                   'offset points'     Offset (i<b>xy</b>15  Offset (in points) from the *xy* value
     *                   'offset pixe<b>xy</b>20    'offset pixels'     Offset (in pixels) from the *xy* value
     *                   =================   =========================================
     *                   
     * @param arrowprops dict, optional<br>
     *                   The properties used to draw a `.FancyArrowPatch` arrow between the
     *                   positions <b>xy</b>0 and<b>xytext</b>5ytext*. Note that the edge of the arrow
     *                   point<b>xytext</b>10nting to *xytext* will be centered on the text itself and may
     *                   not point directly to the co<b>xytext</b>15 the coordinates given in *xytext*.
     *            <b>arrowprops</b>20               
     *                   If *arrowprops* does not contain the key 'arrowstyle' the
     *                   allowed keys are:
     *                   
     *                   ==========   ======================================================
     *                   Key          Description
     *                   ==========   ======================================================
     *                   width        The width of the arrow in points
     *                   headwidth    The width of the base of the arrow head in points
     *                   headlength   The length of the arrow head in points
     *                   shrink       Fraction of total length to shrink from both ends
     *                   ?            Any key to :class:`matplotlib.patches.FancyArrowPatch`
     *                   ==========   ===================================================<b>arrowprops</b>25================
     *                   
     *                   If *arrowprops* contains the key 'arrowstyle' the
     *                   above keys are forbidden.  The allowed values of
     *                   ``'arrowstyle'`` are:
     *                   
     *                   ============   =============================================
     *                   Name           Attrs
     *                   ============   =============================================
     *                   ``'-'``        None
     *                   ``'-&gt;'``       head_length=0.4,head_width=0.2
     *                   ``'-['``       widthB=1.0,lengthB=0.2,angleB=None
     *                   ``'|-|'``      widthA=1.0,widthB=1.0
     *                   ``'-|&gt;'``      head_length=0.4,head_width=0.2
     *                   ``'&lt;-'``       head_length=0.4,head_width=0.2
     *                   ``'&lt;-&gt;'``      head_length=0.4,head_width=0.2
     *                   ``'&lt;|-'``      head_length=0.4,head_width=0.2
     *                   ``'&lt;|-|&gt;'``    head_length=0.4,head_width=0.2
     *                   ``'fancy'``    head_length=0.4,head_width=0.4,tail_width=0.4
     *                   ``'simple'``   head_length=0.5,head_width=0.5,tail_width=0.2
     *                   ``'wedge'``    tail_width=0.3,shrink_factor=0.5
     *                   ============   =============================================
     *                   
     *                   Valid keys for `~matplotlib.patches.FancyArrowPatch` are:
     *                   
     *                   ===============  ==================================================
     *                   Key              Description
     *                   ===============  ==================================================
     *                   arrowstyle       the arrow style
     *                   connectionstyle  the connection style
     *                   relpos           default is (0.5, 0.5)
     *                   patchA           default is bounding box of the text
     *                   patchB           default is None
     *                   shrinkA          default is 2 points
     *                   shrinkB          default is 2 points
     *                   mutation_scale   default is text size (in points)
     *                   mutation_aspect  default is 1.
     *                   ?                any key for :class:`matplotlib.patches.PathPatch`
     *                   ===============  ==================================================
     *                   
     *                   Defaults to None, i.e. no arrow is drawn.
     *                   
     * @param annotation_clip bool or None, default: None<br>
     *                        Whether to draw the annotation when the annotation point <b>xy</b>0 is
     *                        outside the axes area.
     *                        
     *                        - If<b>True</b>5*True*, the annotation will only be draw<b>xy</b>10e drawn when *xy* is
     *                        within the axes.
     *          <b>False</b>15                      - If *False*, the annotation will always be drawn.<b>None</b>20ways be drawn.
     *                  <b>xy</b>25  *                        - If *None*, the annotati<b>xycoords</b>30*None*, the annotation will only be drawn when *xy* is
     *                        within the axes and *xycoords* is 'data'.
     *                        
     * @param **kwargs <br>
     *                 Additional kwargs are passed to `~matplotlib.text.Text`.
     * @param *args n/a<br>undocumented
     * 
     * @return `.Annotation` <br>
     */
    public final Object annotate(Object text, Object xy, Object... args) {
        write("plt.annotate("+PythonGrammar.toPythonArgs(text),PythonGrammar.toPythonArgs(xy)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Add an arrow to the Axes.
     * 
     * This draws an arrow from ``(x, y)`` to ``(x+dx, y+dy)``.
     * <p>
     * <em>Notes:</em><br>
     * The resulting arrow is affected by the Axes aspect ratio and limits.
     * This may produce an arrow whose head is not square with its stem. To
     * create an arrow whose head is square with its stem,
     * use :meth:`annotate` for example:
     * 
     * >>> ax.annotate("", xy=(0.5, 0.5), xytext=(0, 0),
     * ...             arrowprops=dict(arrowstyle="->"))
     * 
     * @param x float<br>
     *          The x and y coordinates of the arrow base.
     *          
     * @param y float<br>
     *          The x and y coordinates of the arrow base.
     *          
     * @param dx float<br>
     *           The length of the arrow along x and y direction.
     *           
     * @param dy float<br>
     *           The length of the arrow along x and y direction.
     *           
     * @param width float, default: 0.001<br>
     *              Width of full arrow tail.
     *              
     * @param length_includes_head bool, default: False<br>
     *                             True if head is to be counted in calculating the length.
     *                             
     * @param head_width float or None, default: 3*width<br>
     *                   Total width of the full arrow head.
     *                   
     * @param head_length float or None, default: 1.5*head_width<br>
     *                    Length of arrow head.
     *                    
     * @param shape &#123;'full', 'left', 'right'&#125;, default: 'full'<br>
     *              Draw the left-half, right-half, or full arrow.
     *              
     * @param overhang float, default: 0<br>
     *                 Fraction that the arrow is swept back (0 overhang means
     *                 triangular shape). Can be negative or greater than one.
     *                 
     * @param head_starts_at_zero bool, default: False<br>
     *                            If True, the head starts being drawn at coordinate 0
     *                            instead of ending at coordinate 0.
     *                            
     * @param **kwargs <br>
     *                 `.Patch` properties:
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: scalar or None
     *                 animated: bool
     *                 antialiased or aa: unknown
     *                 capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 color: color
     *                 contains: unknown
     *                 edgecolor or ec: color or None or 'auto'
     *                 facecolor or fc: color or None
     *                 figure: `.Figure`
     *                 fill: bool
     *                 gid: str
     *                 hatch: &#123;'/', '\\', '|', '-', '+', 'x', 'o', 'O', '.', '*'&#125;
     *                 in_layout: bool
     *                 joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 label: object
     *                 linestyle or ls: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *                 linewidth or lw: float or None
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: None or bool or float or callable
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 transform: `.Transform`
     *                 url: str
     *                 visible: bool
     *                 zorder: float
     * 
     * @return `.FancyArrow` <br>
     *                       The created `.FancyArrow` object.
     */
    public final Object arrow(Object x, Object y, Object dx, Object dy, Object... args) {
        write("plt.arrow("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(y),PythonGrammar.toPythonArgs(dx),PythonGrammar.toPythonArgs(dy)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Autoscale the axis view to the data (toggle).
     * 
     * Convenience method for simple axis view autoscaling.
     * It turns autoscaling on or off, and then,
     * if autoscaling for either axis is on, it performs
     * the autoscaling on the specified axis or axes.
     * 
     * @param enable bool or None, default: True<br>
     *               True turns autoscaling on, False turns it off.
     *               None leaves the autoscaling state unchanged.
     * @param axis &#123;'both', 'x', 'y'&#125;, default: 'both'<br>
     *             Which axis to operate on.
     * @param tight bool or None, default: None<br>
     *              If True, first set the margins to zero.  Then, this argument is
     *              forwarded to `autoscale_view` (regardless of its value); see the
     *              description of its behavior there.
     */
    public final Object autoscale(Object... args) {
        write("plt.autoscale("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the colormap to 'autumn'.
     * 
     * This changes the default colormap as well as the colormap of the current
     * image if there is one. See ``help(colormaps)`` for more information.
     */
    public final Object autumn() {
        write("plt.autumn()");
        return null;
    }

    /**
     * Add an axes to the current figure and make it the current axes.
     * 
     * Call signatures::
     * 
     * plt.axes()
     * plt.axes(rect, projection=None, polar=False, **kwargs)
     * plt.axes(ax)
     * <p>
     * <em>Notes:</em><br>
     * If the figure already has a axes with key (<b>args</b>0,
     * <b>kwargs</b>0) then it will simply make that axes current and
     * return it.  This behavior is deprecated. Meanwhile, if you do
     * not want this behavior (i.e., you want to force the creation of a
     * new axes), you must use a unique set of args and kwargs.  The axes
     * <b>label</b>0 attribute has been exposed for this purpose: if you want
     * two axes that are otherwise identical to be added to the figure,
     * make sure you give them unique labels.
     * 
     * @param arg None or 4-tuple<br>
     *            The exact behavior of this function depends on the type:
     *            
     *            - <b>None</b>0: A new full window axes is added using
     *            ``subplot(**kwargs)``.
     *            - 4-tuple of floats<b>rect</b>5*rect* = ``[left, bottom, width, height]``.
     *            A new axes is added with dime<b>rect</b>10dimensions *rect* in normalized
     *            (0, 1) units using `~.Figure.add_axes` on the current figure.
     *            
     * @param projection &#123;None, 'aitoff', 'hammer', 'lambert', 'mollweide', 'polar', 'rectilinear', str&#125;, optional<br>
     *                   The projection type of the `~.axes.Axes`. <b>str</b>0 is the name of
     *                   a custom projection, see `~matplotlib.projections`. The default
     *                   None results in a 'rectilinear' projection.
     *                   
     * @param polar bool, default: False<br>
     *              If True, equivalent to projection='polar'.
     *              
     * @param sharex `~.axes.Axes`, optional<br>
     *               Share the x or y `~matplotlib.axis` with sharex and/or sharey.
     *               The axis will have the same limits, ticks, and scale as the axis
     *               of the shared axes.
     *               
     * @param sharey `~.axes.Axes`, optional<br>
     *               Share the x or y `~matplotlib.axis` with sharex and/or sharey.
     *               The axis will have the same limits, ticks, and scale as the axis
     *               of the shared axes.
     *               
     * @param label str<br>
     *              A label for the returned axes.
     * @param **kwargs <br>
     *                 This method also takes the keyword arguments for
     *                 the returned axes class. The keyword arguments for the
     *                 rectilinear axes class `~.axes.Axes` can be found in
     *                 the following table but there might also be other keyword
     *                 arguments if another projection is used, see the actual axes
     *                 class.
     *                 
     *                 Properties:
     *                 adjustable: &#123;'box', 'datalim'&#125;
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: scalar or None
     *                 anchor: 2-tuple of floats or &#123;'C', 'SW', 'S', 'SE', ...&#125;
     *                 animated: bool
     *                 aspect: &#123;'auto'&#125; or num
     *                 autoscale_on: bool
     *                 autoscalex_on: bool
     *                 autoscaley_on: bool
     *                 axes_locator: Callable[[Axes, Renderer], Bbox]
     *                 axisbelow: bool or 'line'
     *                 box_aspect: float or None
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 contains: unknown
     *                 facecolor or fc: color
     *                 figure: `.Figure`
     *                 frame_on: bool
     *                 gid: str
     *                 in_layout: bool
     *                 label: object
     *                 navigate: bool
     *                 navigate_mode: unknown
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: None or bool or float or callable
     *                 position: [left, bottom, width, height] or `~matplotlib.transforms.Bbox`
     *                 prop_cycle: unknown
     *                 rasterization_zorder: float or None
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 title: str
     *                 transform: `.Transform`
     *                 url: str
     *                 visible: bool
     *                 xbound: unknown
     *                 xlabel: str
     *                 xlim: (bottom: float, top: float)
     *                 xmargin: float greater than -0.5
     *                 xscale: &#123;"linear", "log", "symlog", "logit", ...&#125; or `.ScaleBase`
     *                 xticklabels: unknown
     *                 xticks: unknown
     *                 ybound: unknown
     *                 ylabel: str
     *                 ylim: (bottom: float, top: float)
     *                 ymargin: float greater than -0.5
     *                 yscale: &#123;"linear", "log", "symlog", "logit", ...&#125; or `.ScaleBase`
     *                 yticklabels: unknown
     *                 yticks: unknown
     *                 zorder: float
     * 
     * @return (`~.axes.Axes`,or a subclass of `~.axes.Axes`) (,)<br>
     *          The returned axes class depends on the projection used. It is
     *          `~.axes.Axes` if rectilinear projection is used and
     *          `.projections.polar.PolarAxes` if polar projection is used.
     *          
     *          The returned axes class depends on the projection used. It is
     *          `~.axes.Axes` if rectilinear projection is used and
     *          `.projections.polar.PolarAxes` if polar projection is used.
     */
    public final Object axes(Object... args) {
        write("plt.axes("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Add a horizontal line across the axis.
     * 
     * @param y float, default: 0<br>
     *          y position in data coordinates of the horizontal line.
     *          
     * @param xmin float, default: 0<br>
     *             Should be between 0 and 1, 0 being the far left of the plot, 1 the
     *             far right of the plot.
     *             
     * @param xmax float, default: 1<br>
     *             Should be between 0 and 1, 0 being the far left of the plot, 1 the
     *             far right of the plot.
     * @param **kwargs <br>
     *                 Valid keyword arguments are `.Line2D` properties, with the
     *                 exception of 'transform':
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: scalar or None
     *                 animated: bool
     *                 antialiased or aa: bool
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 color or c: color
     *                 contains: unknown
     *                 dash_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 dash_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 dashes: sequence of floats (on/off ink in points) or (None, None)
     *                 data: (2, N) array or two 1D arrays
     *                 drawstyle or ds: &#123;'default', 'steps', 'steps-pre', 'steps-mid', 'steps-post'&#125;, default: 'default'
     *                 figure: `.Figure`
     *                 fillstyle: &#123;'full', 'left', 'right', 'bottom', 'top', 'none'&#125;
     *                 gid: str
     *                 in_layout: bool
     *                 label: object
     *                 linestyle or ls: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *                 linewidth or lw: float
     *                 marker: marker style string, `~.path.Path` or `~.markers.MarkerStyle`
     *                 markeredgecolor or mec: color
     *                 markeredgewidth or mew: float
     *                 markerfacecolor or mfc: color
     *                 markerfacecoloralt or mfcalt: color
     *                 markersize or ms: float
     *                 markevery: None or int or (int, int) or slice or list[int] or float or (float, float) or list[bool]
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: float or callable[[Artist, Event], tuple[bool, dict]]
     *                 pickradius: float
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 solid_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 solid_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 transform: `matplotlib.transforms.Transform`
     *                 url: str
     *                 visible: bool
     *                 xdata: 1D array
     *                 ydata: 1D array
     *                 zorder: float
     * 
     * @return `~matplotlib.lines.Line2D` <br>
     */
    public final Object axhline(Object... args) {
        write("plt.axhline("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Add a horizontal span (rectangle) across the Axes.
     * 
     * The rectangle spans from <b>ymin</b>0 to<b>ymax</b>5*ymax* vertically, and, by default,
     * the whole x-axis horizontally.  The x-span can be set using <b>xmin</b>0
     * (default: 0) and <b>xmax</b>0 (default: 1) which are in axis units; e.g.
     * ``xmin = 0.5`` always refers to the middle of the x-axis regardless of
     * the limits set by `~.Axes.set_xlim`.
     * 
     * @param ymin float<br>
     *             Lower y-coordinate of the span, in data units.
     * @param ymax float<br>
     *             Upper y-coordinate of the span, in data units.
     * @param xmin float, default: 0<br>
     *             Lower x-coordinate of the span, in x-axis (0-1) units.
     * @param xmax float, default: 1<br>
     *             Upper x-coordinate of the span, in x-axis (0-1) units.
     * @param **kwargs `~matplotlib.patches.Polygon` properties<br>
     *                 
     * @param Properties <br>
     *                   agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                   alpha: scalar or None
     *                   animated: bool
     *                   antialiased or aa: unknown
     *                   capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                   clip_box: `.Bbox`
     *                   clip_on: bool
     *                   clip_path: Patch or (Path, Transform) or None
     *                   color: color
     *                   contains: unknown
     *                   edgecolor or ec: color or None or 'auto'
     *                   facecolor or fc: color or None
     *                   figure: `.Figure`
     *                   fill: bool
     *                   gid: str
     *                   hatch: &#123;'/', '\\', '|', '-', '+', 'x', 'o', 'O', '.', '*'&#125;
     *                   in_layout: bool
     *                   joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                   label: object
     *                   linestyle or ls: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *                   linewidth or lw: float or None
     *                   path_effects: `.AbstractPathEffect`
     *                   picker: None or bool or float or callable
     *                   rasterized: bool
     *                   sketch_params: (scale: float, length: float, randomness: float)
     *                   snap: bool or None
     *                   transform: `.Transform`
     *                   url: str
     *                   visible: bool
     *                   zorder: float
     * 
     * @return `~matplotlib.patches.Polygon` <br>
     *                                       Horizontal span (rectangle) from (xmin, ymin) to (xmax, ymax).
     */
    public final Object axhspan(Object ymin, Object ymax, Object... args) {
        write("plt.axhspan("+PythonGrammar.toPythonArgs(ymin),PythonGrammar.toPythonArgs(ymax)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Convenience method to get or set some axis properties.
     * 
     * Call signatures::
     * 
     * xmin, xmax, ymin, ymax = axis()
     * xmin, xmax, ymin, ymax = axis([xmin, xmax, ymin, ymax])
     * xmin, xmax, ymin, ymax = axis(option)
     * xmin, xmax, ymin, ymax = axis(**kwargs)
     * 
     * @param xmin float, optional<br>
     *             The axis limits to be set.  This can also be achieved using ::
     *             
     *             ax.set(xlim=(xmin, xmax), ylim=(ymin, ymax))
     *             
     * @param xmax float, optional<br>
     *             The axis limits to be set.  This can also be achieved using ::
     *             
     *             ax.set(xlim=(xmin, xmax), ylim=(ymin, ymax))
     *             
     * @param ymin float, optional<br>
     *             The axis limits to be set.  This can also be achieved using ::
     *             
     *             ax.set(xlim=(xmin, xmax), ylim=(ymin, ymax))
     *             
     * @param ymax float, optional<br>
     *             The axis limits to be set.  This can also be achieved using ::
     *             
     *             ax.set(xlim=(xmin, xmax), ylim=(ymin, ymax))
     *             
     * @param option bool or str<br>
     *               If a bool, turns axis lines and labels on or off. If a string,
     *               possible values are:
     *               
     *               ======== ==========================================================
     *               Value    Description
     *               ======== ==========================================================
     *               'on'     Turn on axis lines and labels. Same as ``True``.
     *               'off'    Turn off axis lines and labels. Same as ``False``.
     *               'equal'  Set equal scaling (i.e., make circles circular) by
     *               changing axis limits. This is the same as
     *               ``ax.set_aspect('equal', adjustable='datalim')``.
     *               Explicit data limits may not be respected in this case.
     *               'scaled' Set equal scaling (i.e., make circles circular) by
     *               changing dimensions of the plot box. This is the same as
     *               ``ax.set_aspect('equal', adjustable='box', anchor='C')``.
     *               Additionally, further autoscaling will be disabled.
     *               'tight'  Set limits just large enough to show all data, then
     *               disable further autoscaling.
     *               'auto'   Automatic scaling (fill plot box with data).
     *               'image'  'scaled' with axis limits equal to data limits.
     *               'square' Square plot; similar to 'scaled', but initially forcing
     *               ``xmax-xmin == ymax-ymin``.
     *               ======== ==========================================================
     *               
     * @param emit bool, default: True<br>
     *             Whether observers are notified of the axis limit change.
     *             This option is passed on to `~.Axes.set_xlim` and
     *             `~.Axes.set_ylim`.
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     * 
     * @return (xmin,xmax,ymin,ymax) (float,float,float,float)<br>
     *          The axis limits.
     *          
     *          The axis limits.
     *          
     *          The axis limits.
     *          
     *          The axis limits.
     */
    public final Object axis(Object... args) {
        write("plt.axis("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Add an infinitely long straight line.
     * 
     * The line can be defined either by two points <b>xy1</b>0 and<b>xy2</b>5 *xy2*, or
     * by one point <b>xy1</b>0 and a<b>slope</b>5slope*.
     * 
     * This draws a straight line "on the screen", regardless of the x and y
     * scales, and is thus also suitable for drawing exponential decays in
     * semilog plots, power laws in loglog plots, etc. However, <b>slope</b>0
     * should only be used with linear scales; It has no clear meaning for
     * all other scales, and thus the behavior is undefined. Please specify
     * the line using the points <b>xy1</b>0,<b>xy2</b>5 *xy2* for non-linear scales.
     * 
     * The <b>transform</b>0 keyword argument only applies to the points<b>xy1</b>5 *xy1*,
     * <b>xy2</b>0. The<b>slope</b>5slope* (if given) is always in data coordinates. This can
     * be used e.g. with ``ax.transAxes`` for drawing grid lines with a fixed
     * slope.
     * 
     * @param xy1 (float, float)<br>
     *            Points for the line to pass through.
     *            Either <b>xy2</b>0 or<b>slope</b>5slope* has to be given.
     * @param xy2 (float, float)<br>
     *            Points for the line to pass through.
     *            Either <b>xy2</b>0 or<b>slope</b>5slope* has to be given.
     * @param slope float, optional<br>
     *              The slope of the line. Either <b>xy2</b>0 or<b>slope</b>5slope* has to be given.
     * @param **kwargs <br>
     *                 Valid kwargs are `.Line2D` properties
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: scalar or None
     *                 animated: bool
     *                 antialiased or aa: bool
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 color or c: color
     *                 contains: unknown
     *                 dash_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 dash_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 dashes: sequence of floats (on/off ink in points) or (None, None)
     *                 data: (2, N) array or two 1D arrays
     *                 drawstyle or ds: &#123;'default', 'steps', 'steps-pre', 'steps-mid', 'steps-post'&#125;, default: 'default'
     *                 figure: `.Figure`
     *                 fillstyle: &#123;'full', 'left', 'right', 'bottom', 'top', 'none'&#125;
     *                 gid: str
     *                 in_layout: bool
     *                 label: object
     *                 linestyle or ls: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *                 linewidth or lw: float
     *                 marker: marker style string, `~.path.Path` or `~.markers.MarkerStyle`
     *                 markeredgecolor or mec: color
     *                 markeredgewidth or mew: float
     *                 markerfacecolor or mfc: color
     *                 markerfacecoloralt or mfcalt: color
     *                 markersize or ms: float
     *                 markevery: None or int or (int, int) or slice or list[int] or float or (float, float) or list[bool]
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: float or callable[[Artist, Event], tuple[bool, dict]]
     *                 pickradius: float
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 solid_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 solid_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 transform: `matplotlib.transforms.Transform`
     *                 url: str
     *                 visible: bool
     *                 xdata: 1D array
     *                 ydata: 1D array
     *                 zorder: float
     * 
     * @return `.Line2D` <br>
     */
    public final Object axline(Object xy1, Object... args) {
        write("plt.axline("+PythonGrammar.toPythonArgs(xy1)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Add a vertical line across the Axes.
     * 
     * @param x float, default: 0<br>
     *          x position in data coordinates of the vertical line.
     *          
     * @param ymin float, default: 0<br>
     *             Should be between 0 and 1, 0 being the bottom of the plot, 1 the
     *             top of the plot.
     *             
     * @param ymax float, default: 1<br>
     *             Should be between 0 and 1, 0 being the bottom of the plot, 1 the
     *             top of the plot.
     * @param **kwargs <br>
     *                 Valid keyword arguments are `.Line2D` properties, with the
     *                 exception of 'transform':
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: scalar or None
     *                 animated: bool
     *                 antialiased or aa: bool
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 color or c: color
     *                 contains: unknown
     *                 dash_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 dash_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 dashes: sequence of floats (on/off ink in points) or (None, None)
     *                 data: (2, N) array or two 1D arrays
     *                 drawstyle or ds: &#123;'default', 'steps', 'steps-pre', 'steps-mid', 'steps-post'&#125;, default: 'default'
     *                 figure: `.Figure`
     *                 fillstyle: &#123;'full', 'left', 'right', 'bottom', 'top', 'none'&#125;
     *                 gid: str
     *                 in_layout: bool
     *                 label: object
     *                 linestyle or ls: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *                 linewidth or lw: float
     *                 marker: marker style string, `~.path.Path` or `~.markers.MarkerStyle`
     *                 markeredgecolor or mec: color
     *                 markeredgewidth or mew: float
     *                 markerfacecolor or mfc: color
     *                 markerfacecoloralt or mfcalt: color
     *                 markersize or ms: float
     *                 markevery: None or int or (int, int) or slice or list[int] or float or (float, float) or list[bool]
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: float or callable[[Artist, Event], tuple[bool, dict]]
     *                 pickradius: float
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 solid_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 solid_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 transform: `matplotlib.transforms.Transform`
     *                 url: str
     *                 visible: bool
     *                 xdata: 1D array
     *                 ydata: 1D array
     *                 zorder: float
     * 
     * @return `~matplotlib.lines.Line2D` <br>
     */
    public final Object axvline(Object... args) {
        write("plt.axvline("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Add a vertical span (rectangle) across the Axes.
     * 
     * The rectangle spans from <b>xmin</b>0 to<b>xmax</b>5*xmax* horizontally, and, by
     * default, the whole y-axis vertically.  The y-span can be set using
     * <b>ymin</b>0 (default: 0) and<b>ymax</b>5*ymax* (default: 1) which are in axis units;
     * e.g. ``ymin = 0.5`` always refers to the middle of the y-axis
     * regardless of the limits set by `~.Axes.set_ylim`.
     * 
     * @param xmin float<br>
     *             Lower x-coordinate of the span, in data units.
     * @param xmax float<br>
     *             Upper x-coordinate of the span, in data units.
     * @param ymin float, default: 0<br>
     *             Lower y-coordinate of the span, in y-axis units (0-1).
     * @param ymax float, default: 1<br>
     *             Upper y-coordinate of the span, in y-axis units (0-1).
     * @param **kwargs `~matplotlib.patches.Polygon` properties<br>
     *                 
     * @param Properties <br>
     *                   agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                   alpha: scalar or None
     *                   animated: bool
     *                   antialiased or aa: unknown
     *                   capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                   clip_box: `.Bbox`
     *                   clip_on: bool
     *                   clip_path: Patch or (Path, Transform) or None
     *                   color: color
     *                   contains: unknown
     *                   edgecolor or ec: color or None or 'auto'
     *                   facecolor or fc: color or None
     *                   figure: `.Figure`
     *                   fill: bool
     *                   gid: str
     *                   hatch: &#123;'/', '\\', '|', '-', '+', 'x', 'o', 'O', '.', '*'&#125;
     *                   in_layout: bool
     *                   joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                   label: object
     *                   linestyle or ls: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *                   linewidth or lw: float or None
     *                   path_effects: `.AbstractPathEffect`
     *                   picker: None or bool or float or callable
     *                   rasterized: bool
     *                   sketch_params: (scale: float, length: float, randomness: float)
     *                   snap: bool or None
     *                   transform: `.Transform`
     *                   url: str
     *                   visible: bool
     *                   zorder: float
     * 
     * @return `~matplotlib.patches.Polygon` <br>
     *                                       Vertical span (rectangle) from (xmin, ymin) to (xmax, ymax).
     */
    public final Object axvspan(Object xmin, Object xmax, Object... args) {
        write("plt.axvspan("+PythonGrammar.toPythonArgs(xmin),PythonGrammar.toPythonArgs(xmax)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Make a bar plot.
     * 
     * The bars are positioned at <b>x</b>0 with the given<b>align</b>5align*\ment. Their
     * dimensions are given by <b>height</b>0 and<b>width</b>5width*. The vertical baseline
     * is <b>bottom</b>0 (default 0).
     * 
     * Many parameters can take either a single value applying to all bars
     * or a sequence of values, one for each bar.
     * <p>
     * <em>Notes:</em><br>
     * Stacked bars can be achieved by passing individual <b>bottom</b>0 values per
     * bar. See :doc:`/gallery/lines_bars_and_markers/bar_stacked`.
     * 
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * every other argument can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception).
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param x float or array-like<br>
     *          The x coordinates of the bars. See also <b>align</b>0 for the
     *          alignment of the bars to the coordinates.
     *          
     * @param height float or array-like<br>
     *               The height(s) of the bars.
     *               
     * @param width float or array-like, default: 0.8<br>
     *              The width(s) of the bars.
     *              
     * @param bottom float or array-like, default: 0<br>
     *               The y coordinate(s) of the bars bases.
     *               
     * @param align &#123;'center', 'edge'&#125;, default: 'center'<br>
     *              Alignment of the bars to the <b>x</b>0 coordinates:
     *              
     *              - 'center': Center the base on the<b>x</b>5he *x* positions.
     *              - 'edge': Align the left edges of the bars wi<b>x</b>10bars with the *x* positions.
     *              
     *              To align the bars on the right ed<b>width</b>15right edge pass a negative *width* and
     *              ``align='edge'``.
     * @param color color or list of color, optional<br>
     *              The colors of the bar faces.
     *              
     * @param edgecolor color or list of color, optional<br>
     *                  The colors of the bar edges.
     *                  
     * @param linewidth float or array-like, optional<br>
     *                  Width of the bar edge(s). If 0, don't draw edges.
     *                  
     * @param tick_label str or list of str, optional<br>
     *                   The tick labels of the bars.
     *                   Default: None (Use default numeric labels.)
     *                   
     * @param xerr float or array-like of shape(N,) or shape(2, N), optional<br>
     *             If not <b>None</b>0, add horizontal / vertical errorbars to the bar tips.
     *             The values are +/- sizes relative to the data:
     *             
     *             - scalar: symmetric +/- values for all bars
     *             - shape(N,): symmetric +/- values for each bar
     *             - shape(2, N): Separate - and + values for each bar. First row
     *             contains the lower errors, the second row contains the upper
     *             errors.
     *             -<b>None</b>5*None*: No errorbar. (Default)
     *             
     *             See :doc:`/gallery/statistics/errorbar_features`
     *             for an example on the usage of ``xerr`` and ``yerr``.
     *             
     * @param yerr float or array-like of shape(N,) or shape(2, N), optional<br>
     *             If not <b>None</b>0, add horizontal / vertical errorbars to the bar tips.
     *             The values are +/- sizes relative to the data:
     *             
     *             - scalar: symmetric +/- values for all bars
     *             - shape(N,): symmetric +/- values for each bar
     *             - shape(2, N): Separate - and + values for each bar. First row
     *             contains the lower errors, the second row contains the upper
     *             errors.
     *             -<b>None</b>5*None*: No errorbar. (Default)
     *             
     *             See :doc:`/gallery/statistics/errorbar_features`
     *             for an example on the usage of ``xerr`` and ``yerr``.
     *             
     * @param ecolor color or list of color, default: 'black'<br>
     *               The line color of the errorbars.
     *               
     * @param capsize float, default: :rc:`errorbar.capsize`<br>
     *                The length of the error bar caps in points.
     *                
     * @param error_kw dict, optional<br>
     *                 Dictionary of kwargs to be passed to the `~.Axes.errorbar`
     *                 method. Values of <b>ecolor</b>0 or<b>capsize</b>5psize* defined here take
     *                 precedence over the independent kwargs.
     *                 
     * @param log bool, default: False<br>
     *            If <b>True</b>0, set the y-axis to be log scale.
     *            
     * @param **kwargs `.Rectangle` properties<br>
     *                 
     * @param Properties <br>
     *                   agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                   alpha: scalar or None
     *                   animated: bool
     *                   antialiased or aa: unknown
     *                   capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                   clip_box: `.Bbox`
     *                   clip_on: bool
     *                   clip_path: Patch or (Path, Transform) or None
     *                   color: color
     *                   contains: unknown
     *                   edgecolor or ec: color or None or 'auto'
     *                   facecolor or fc: color or None
     *                   figure: `.Figure`
     *                   fill: bool
     *                   gid: str
     *                   hatch: &#123;'/', '\\', '|', '-', '+', 'x', 'o', 'O', '.', '*'&#125;
     *                   in_layout: bool
     *                   joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                   label: object
     *                   linestyle or ls: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *                   linewidth or lw: float or None
     *                   path_effects: `.AbstractPathEffect`
     *                   picker: None or bool or float or callable
     *                   rasterized: bool
     *                   sketch_params: (scale: float, length: float, randomness: float)
     *                   snap: bool or None
     *                   transform: `.Transform`
     *                   url: str
     *                   visible: bool
     *                   zorder: float
     * @param data n/a<br>undocumented
     * 
     * @return `.BarContainer` <br>
     *                         Container with all the bars and optionally errorbars.
     */
    public final Object bar(Object x, Object height, Object... args) {
        write("plt.bar("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(height)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Label a bar plot.
     * 
     * Adds labels to bars in the given `.BarContainer`.
     * You may need to adjust the axis limits to fit the labels.
     * 
     * @param container `.BarContainer`<br>
     *                  Container with all the bars and optionally errorbars, likely
     *                  returned from `.bar` or `.barh`.
     *                  
     * @param labels array-like, optional<br>
     *               A list of label texts, that should be displayed. If not given, the
     *               label texts will be the data values formatted with <b>fmt</b>0.
     *               
     * @param fmt str, default: '%g'<br>
     *            A format string for the label.
     *            
     * @param label_type &#123;'edge', 'center'&#125;, default: 'edge'<br>
     *                   The label type. Possible values:
     *                   
     *                   - 'edge': label placed at the end-point of the bar segment, and the
     *                   value displayed will be the position of that end-point.
     *                   - 'center': label placed in the center of the bar segment, and the
     *                   value displayed will be the length of that segment.
     *                   (useful for stacked bars, i.e.,
     *                   :doc:`/gallery/lines_bars_and_markers/bar_label_demo`)
     *                   
     * @param padding float, default: 0<br>
     *                Distance of label from the end of the bar, in points.
     *                
     * @param **kwargs <br>
     *                 Any remaining keyword arguments are passed through to
     *                 `.Axes.annotate`.
     * 
     * @return list of `.Text` <br>
     *                         A list of `.Text` instances for the labels.
     */
    public final Object bar_label(Object container, Object... args) {
        write("plt.bar_label("+PythonGrammar.toPythonArgs(container)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Plot a 2D field of barbs.
     * 
     * Call signature::
     * 
     * barbs([X, Y], U, V, [C], **kw)
     * 
     * Where <b>X</b>0,<b>Y</b>50, *Y* define the barb loca<b>U</b>10<b>V</b>15ca<b>U</b>10rb locations, *U*, *V* define the barb
     * directions, and <b>C</b>0 optionally sets the color.
     * 
     * All arguments may be 1D or 2D. <b>U</b>0,<b>V</b>50<b>C</b>10V</b>50, *V*, *C* may be masked arrays, but masked
     * <b>X</b>0,<b>Y</b>50, *Y* are not supported at present.
     * 
     * Barbs are traditionally used in meteorology as a way to plot the speed
     * and direction of wind observations, but can technically be used to
     * plot any two dimensional vector quantity.  As opposed to arrows, which
     * give vector magnitude by the length of the arrow, the barbs give more
     * quantitative information about the vector magnitude by putting slanted
     * lines or a triangle for various increments in magnitude, as show
     * schematically below::
     * 
     * :                   /\    \
     * :                  /  \    \
     * :                 /    \    \    \
     * :                /      \    \    \
     * :               ------------------------------
     * 
     * The largest increment is given by a triangle (or "flag"). After those
     * come full lines (barbs). The smallest increment is a half line.  There
     * is only, of course, ever at most 1 half line.  If the magnitude is
     * small and only needs a single half-line and no full lines or
     * triangles, the half-line is offset from the end of the barb so that it
     * can be easily distinguished from barbs with a single full line.  The
     * magnitude for the barb shown above would nominally be 65, using the
     * standard increments of 50, 10, and 5.
     * 
     * See also https://en.wikipedia.org/wiki/Wind_barb.
     * <p>
     * <em>Notes:</em><br>
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * every other argument can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception).
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param X 1D or 2D array-like, optional<br>
     *          The x and y coordinates of the barb locations. See <b>pivot</b>0 for how the
     *          barbs are drawn to the x, y positions.
     *          
     *          If not given, they will be generated as a uniform integer meshgrid based
     *          on the dimensions of<b>U</b>5of *<b>V</b>10b>5of *U* and *V*.
     *          
<b>X</b>15*  <b>Y</b>20   
<b>X</<b>U</b>25<b>V</b>30Y</b>20<b>X</b>35<b>Y</b>40<b>U</b>25<b>V</b>30Y</b>20<b>X</b>35b>X</<b>U</b>25<b>V</b>30Y</b>20   
<b>X</<b>U</b>25  <b>Y</b>20   
<b>X</b>15*          
     *          If *X* and *Y* are 1D but <b>U</b>45   <b>V</b>50        If *X* and *Y* are 1D but <b>U</b>45     *          If *X* and *Y* are 1D but *U*, *V* are 2D, *X*, *Y* are expanded to 2D
     *          using ``X, Y = np.meshgrid(X, Y)``. In this case ``len(X)`` and ``len(Y)``
     *          must match the column and row dimensions of *U* and *V*.
     *          
     * @param Y 1D or 2D array-like, optional<br>
     *          The x and y coordinates of the barb locations. See <b>pivot</b>0 for how the
     *          barbs are drawn to the x, y positions.
     *          
     *          If not given, they will be generated as a uniform integer meshgrid based
     *          on the dimensions of<b>U</b>5of *<b>V</b>10b>5of *U* and *V*.
     *          
<b>X</b>15*  <b>Y</b>20   
<b>X</<b>U</b>25<b>V</b>30Y</b>20<b>X</b>35<b>Y</b>40<b>U</b>25<b>V</b>30Y</b>20<b>X</b>35b>X</<b>U</b>25<b>V</b>30Y</b>20   
<b>X</<b>U</b>25  <b>Y</b>20   
<b>X</b>15*          
     *          If *X* and *Y* are 1D but <b>U</b>45   <b>V</b>50        If *X* and *Y* are 1D but <b>U</b>45     *          If *X* and *Y* are 1D but *U*, *V* are 2D, *X*, *Y* are expanded to 2D
     *          using ``X, Y = np.meshgrid(X, Y)``. In this case ``len(X)`` and ``len(Y)``
     *          must match the column and row dimensions of *U* and *V*.
     *          
     * @param U 1D or 2D array-like<br>
     *          The x and y components of the barb shaft.
     *          
     * @param V 1D or 2D array-like<br>
     *          The x and y components of the barb shaft.
     *          
     * @param C 1D or 2D array-like, optional<br>
     *          Numeric data that defines the barb colors by colormapping via <b>norm</b>0 and
     *         <b>cmap</b>5*cmap*.
     *          
     *          This does not support explicit colors. If you want to set colors directly,
     *       <b>barbcolor</b>10  use *barbcolor* instead.
     *          
     * @param length float, default: 7<br>
     *               Length of the barb in points; the other parts of the barb
     *               are scaled against this.
     *               
     * @param pivot &#123;'tip', 'middle'&#125; or float, default: 'tip'<br>
     *              The part of the arrow that is anchored to the <b>X</b>0,<b>Y</b>50, *Y* grid. The barb
     *              rotates about this point. This can also be a number, which shifts the
     *              start of the barb that many points away from grid point.
     *              
     * @param barbcolor color or color sequence<br>
     *                  The color of all parts of the barb except for the flags.  This parameter
     *                  is analogous to the <b>edgecolor</b>0 parameter for polygons, which can be used
     *                  instead. However this parameter will override facecolor.
     *                  
     * @param flagcolor color or color sequence<br>
     *                  The color of any flags on the barb.  This parameter is analogous to the
     *                  <b>facecolor</b>0 parameter for polygons, which can be used instead. However,
     *                  this parameter will override facecolor.  If this is not set (and<b>C</b>5nd *C* has
     *                  not either<b>flagcolor</b>10 then *flagcolor* wi<b>barbcolor</b>15* will be set to match *barbcolor* so that the
     *           <b>C</b>20     *       <b>flagcolor</b>250     *                  barb has a uniform color. If *C* has been set, *flagcolor* has no effect.
     *                  
     * @param sizes dict, optional<br>
     *              A dictionary of coefficients specifying the ratio of a given
     *              feature to the length of the barb. Only those values one wishes to
     *              override need to be included.  These features include:
     *              
     *              - 'spacing' - space between features (flags, full/half barbs)
     *              - 'height' - height (distance from shaft to top) of a flag or full barb
     *              - 'width' - width of a flag, twice the width of a full barb
     *              - 'emptybarb' - radius of the circle used for low magnitudes
     *              
     * @param fill_empty bool, default: False<br>
     *                   Whether the empty barbs (circles) that are drawn should be filled with
     *                   the flag color.  If they are not filled, the center is transparent.
     *                   
     * @param rounding bool, default: True<br>
     *                 Whether the vector magnitude should be rounded when allocating barb
     *                 components.  If True, the magnitude is rounded to the nearest multiple
     *                 of the half-barb increment.  If False, the magnitude is simply truncated
     *                 to the next lowest multiple.
     *                 
     * @param barb_increments dict, optional<br>
     *                        A dictionary of increments specifying values to associate with
     *                        different parts of the barb. Only those values one wishes to
     *                        override need to be included.
     *                        
     *                        - 'half' - half barbs (Default is 5)
     *                        - 'full' - full barbs (Default is 10)
     *                        - 'flag' - flags (default is 50)
     *                        
     * @param flip_barb bool or array-like of bool, default: False<br>
     *                  Whether the lines and flags should point opposite to normal.
     *                  Normal behavior is for the barbs and lines to point right (comes from wind
     *                  barbs having these features point towards low pressure in the Northern
     *                  Hemisphere).
     *                  
     *                  A single value is applied to all barbs. Individual barbs can be flipped by
     *                  passing a bool array of the same size as <b>U</b>0 and<b>V</b>5nd *V*.
     * @param **kwargs <br>
     *                 The barbs can further be customized using `.PolyCollection` keyword
     *                 arguments:
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: array-like or scalar or None
     *                 animated: bool
     *                 antialiased or aa or antialiaseds: bool or list of bools
     *                 array: ndarray or None
     *                 capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 clim: (vmin: float, vmax: float)
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 cmap: `.Colormap` or str or None
     *                 color: color or list of rgba tuples
     *                 contains: unknown
     *                 edgecolor or ec or edgecolors: color or list of colors or 'face'
     *                 facecolor or facecolors or fc: color or list of colors
     *                 figure: `.Figure`
     *                 gid: str
     *                 hatch: &#123;'/', '\\', '|', '-', '+', 'x', 'o', 'O', '.', '*'&#125;
     *                 in_layout: bool
     *                 joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 label: object
     *                 linestyle or dashes or linestyles or ls: str or tuple or list thereof
     *                 linewidth or linewidths or lw: float or list of floats
     *                 norm: `.Normalize` or None
     *                 offset_position: unknown
     *                 offsets: (N, 2) or (2,) array-like
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: None or bool or float or callable
     *                 pickradius: float
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 transform: `.Transform`
     *                 url: str
     *                 urls: list of str or None
     *                 visible: bool
     *                 zorder: float
     * @param *args n/a<br>undocumented
     * @param data n/a<br>undocumented
     * @param **kw n/a<br>undocumented
     * 
     * @return barbs `~matplotlib.quiver.Barbs`<br>
     */
    public final Object barbs(Object... args) {
        write("plt.barbs("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Make a horizontal bar plot.
     * 
     * The bars are positioned at <b>y</b>0 with the given<b>align</b>5align*\ment. Their
     * dimensions are given by <b>width</b>0 and<b>height</b>5eight*. The horizontal baseline
     * is <b>left</b>0 (default 0).
     * 
     * Many parameters can take either a single value applying to all bars
     * or a sequence of values, one for each bar.
     * <p>
     * <em>Notes:</em><br>
     * Stacked bars can be achieved by passing individual <b>left</b>0 values per
     * bar. See
     * :doc:`/gallery/lines_bars_and_markers/horizontal_barchart_distribution`
     * .
     * 
     * @param y float or array-like<br>
     *          The y coordinates of the bars. See also <b>align</b>0 for the
     *          alignment of the bars to the coordinates.
     *          
     * @param width float or array-like<br>
     *              The width(s) of the bars.
     *              
     * @param height float or array-like, default: 0.8<br>
     *               The heights of the bars.
     *               
     * @param left float or array-like, default: 0<br>
     *             The x coordinates of the left sides of the bars.
     *             
     * @param align &#123;'center', 'edge'&#125;, default: 'center'<br>
     *              Alignment of the base to the <b>y</b>0 coordinates*:
     *              
     *              - 'center': Center the bars on the<b>y</b>5he *y* positions.
     *              - 'edge': Align the bottom edges of the bars wi<b>y</b>10bars with the *y*
     *              positions.
     *              
     *              To align the bars on the top ed<b>height</b>15 top edge pass a negative *height* and
     *              ``align='edge'``.
     * @param color color or list of color, optional<br>
     *              The colors of the bar faces.
     *              
     * @param edgecolor color or list of color, optional<br>
     *                  The colors of the bar edges.
     *                  
     * @param linewidth float or array-like, optional<br>
     *                  Width of the bar edge(s). If 0, don't draw edges.
     *                  
     * @param tick_label str or list of str, optional<br>
     *                   The tick labels of the bars.
     *                   Default: None (Use default numeric labels.)
     *                   
     * @param xerr float or array-like of shape(N,) or shape(2, N), optional<br>
     *             If not ``None``, add horizontal / vertical errorbars to the
     *             bar tips. The values are +/- sizes relative to the data:
     *             
     *             - scalar: symmetric +/- values for all bars
     *             - shape(N,): symmetric +/- values for each bar
     *             - shape(2, N): Separate - and + values for each bar. First row
     *             contains the lower errors, the second row contains the upper
     *             errors.
     *             - <b>None</b>0: No errorbar. (default)
     *             
     *             See :doc:`/gallery/statistics/errorbar_features`
     *             for an example on the usage of ``xerr`` and ``yerr``.
     *             
     * @param yerr float or array-like of shape(N,) or shape(2, N), optional<br>
     *             If not ``None``, add horizontal / vertical errorbars to the
     *             bar tips. The values are +/- sizes relative to the data:
     *             
     *             - scalar: symmetric +/- values for all bars
     *             - shape(N,): symmetric +/- values for each bar
     *             - shape(2, N): Separate - and + values for each bar. First row
     *             contains the lower errors, the second row contains the upper
     *             errors.
     *             - <b>None</b>0: No errorbar. (default)
     *             
     *             See :doc:`/gallery/statistics/errorbar_features`
     *             for an example on the usage of ``xerr`` and ``yerr``.
     *             
     * @param ecolor color or list of color, default: 'black'<br>
     *               The line color of the errorbars.
     *               
     * @param capsize float, default: :rc:`errorbar.capsize`<br>
     *                The length of the error bar caps in points.
     *                
     * @param error_kw dict, optional<br>
     *                 Dictionary of kwargs to be passed to the `~.Axes.errorbar`
     *                 method. Values of <b>ecolor</b>0 or<b>capsize</b>5psize* defined here take
     *                 precedence over the independent kwargs.
     *                 
     * @param log bool, default: False<br>
     *            If ``True``, set the x-axis to be log scale.
     *            
     * @param **kwargs `.Rectangle` properties<br>
     *                 
     * @param Properties <br>
     *                   agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                   alpha: scalar or None
     *                   animated: bool
     *                   antialiased or aa: unknown
     *                   capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                   clip_box: `.Bbox`
     *                   clip_on: bool
     *                   clip_path: Patch or (Path, Transform) or None
     *                   color: color
     *                   contains: unknown
     *                   edgecolor or ec: color or None or 'auto'
     *                   facecolor or fc: color or None
     *                   figure: `.Figure`
     *                   fill: bool
     *                   gid: str
     *                   hatch: &#123;'/', '\\', '|', '-', '+', 'x', 'o', 'O', '.', '*'&#125;
     *                   in_layout: bool
     *                   joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                   label: object
     *                   linestyle or ls: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *                   linewidth or lw: float or None
     *                   path_effects: `.AbstractPathEffect`
     *                   picker: None or bool or float or callable
     *                   rasterized: bool
     *                   sketch_params: (scale: float, length: float, randomness: float)
     *                   snap: bool or None
     *                   transform: `.Transform`
     *                   url: str
     *                   visible: bool
     *                   zorder: float
     * 
     * @return `.BarContainer` <br>
     *                         Container with all the bars and optionally errorbars.
     */
    public final Object barh(Object y, Object width, Object... args) {
        write("plt.barh("+PythonGrammar.toPythonArgs(y),PythonGrammar.toPythonArgs(width)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the colormap to 'bone'.
     * 
     * This changes the default colormap as well as the colormap of the current
     * image if there is one. See ``help(colormaps)`` for more information.
     */
    public final Object bone() {
        write("plt.bone()");
        return null;
    }

    /**
     * Turn the axes box on or off on the current axes.
     * 
     * @param on bool or None<br>
     *           The new `~matplotlib.axes.Axes` box state. If ``None``, toggle
     *           the state.
     */
    public final Object box(Object... args) {
        write("plt.box("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Make a box and whisker plot.
     * 
     * Make a box and whisker plot for each column of <b>x</b>0 or each
     * vector in sequence <b>x</b>0.  The box extends from the lower to
     * upper quartile values of the data, with a line at the median.
     * The whiskers extend from the box to show the range of the
     * data.  Flier points are those past the end of the whiskers.
     * <p>
     * <em>Notes:</em><br>
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * every other argument can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception).
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param x Array or a sequence of vectors.<br>
     *          The input data.
     *          
     * @param notch bool, default: False<br>
     *              Whether to draw a notched box plot (`True`), or a rectangular box
     *              plot (`False`).  The notches represent the confidence interval (CI)
     *              around the median.  The documentation for <b>bootstrap</b>0 describes how
     *              the locations of the notches are computed by default, but their
     *              locations may also be overridden by setting the<b>conf_intervals</b>5rvals*
     *              parameter.
     *              
     *              .. note::
     *              
     *              In cases where the values of the CI are less than the
     *              lower quartile or greater than the upper quartile, the
     *              notches will extend beyond the box, giving it a
     *              distinctive "flipped" appearance. This is expected
     *              behavior and consistent with other statistical
     *              visualization packages.
     *              
     * @param sym str, optional<br>
     *            The default symbol for flier points.  An empty string ('') hides
     *            the fliers.  If `None`, then the fliers default to 'b+'.  More
     *            control is provided by the <b>flierprops</b>0 parameter.
     *            
     * @param vert bool, default: True<br>
     *             If `True`, draws vertical boxes.
     *             If `False`, draw horizontal boxes.
     *             
     * @param whis float or (float, float), default: 1.5<br>
     *             The position of the whiskers.
     *             
     *             If a float, the lower whisker is at the lowest datum above
     *             ``Q1 - whis*(Q3-Q1)``, and the upper whisker at the highest datum
     *             below ``Q3 + whis*(Q3-Q1)``, where Q1 and Q3 are the first and
     *             third quartiles.  The default value of ``whis = 1.5`` corresponds
     *             to Tukey's original definition of boxplots.
     *             
     *             If a pair of floats, they indicate the percentiles at which to
     *             draw the whiskers (e.g., (5, 95)).  In particular, setting this to
     *             (0, 100) results in whiskers covering the whole range of the data.
     *             
     *             In the edge case where ``Q1 == Q3``, <b>whis</b>0 is automatically set
     *             to (0, 100) (cover the whole range of the data) if<b>autorange</b>5range* is
     *             True.
     *             
     *             Beyond the whiskers, data are considered outliers and are plotted
     *             as individual points.
     *             
     * @param bootstrap int, optional<br>
     *                  Specifies whether to bootstrap the confidence intervals
     *                  around the median for notched boxplots. If <b>bootstrap</b>0 is
     *                  None, no bootstrapping is performed, and notches are
     *                  calculated using a Gaussian-based asymptotic approximation
     *                  (see McGill, R., Tukey, J.W., and Larsen, W.A., 1978, and
     *                  Kendall and Stuart, 1967). Otherwise, bootstrap specifies
     *                  the number of times to bootstrap the median to determine its
     *                  95% confidence intervals. Values between 1000 and 10000 are
     *                  recommended.
     *                  
     * @param usermedians 1D array-like, optional<br>
     *                    A 1D array-like of length ``len(x)``.  Each entry that is not
     *                    `None` forces the value of the median for the corresponding
     *                    dataset.  For entries that are `None`, the medians are computed
     *                    by Matplotlib as normal.
     *                    
     * @param conf_intervals array-like, optional<br>
     *                       A 2D array-like of shape ``(len(x), 2)``.  Each entry that is not
     *                       None forces the location of the corresponding notch (which is
     *                       only drawn if <b>notch</b>0 is `True`).  For entries that are `None`,
     *                       the notches are computed by the method specified by the other
     *                       parameters (e.g.,<b>bootstrap</b>5strap*).
     *                       
     * @param positions array-like, optional<br>
     *                  The positions of the boxes. The ticks and limits are
     *                  automatically set to match the positions. Defaults to
     *                  ``range(1, N+1)`` where N is the number of boxes to be drawn.
     *                  
     * @param widths float or array-like<br>
     *               The widths of the boxes.  The default is 0.5, or ``0.15*(distance
     *               between extreme positions)``, if that is smaller.
     *               
     * @param patch_artist bool, default: False<br>
     *                     If `False` produces boxes with the Line2D artist. Otherwise,
     *                     boxes and drawn with Patch artists.
     *                     
     * @param labels sequence, optional<br>
     *               Labels for each dataset (one per dataset).
     *               
     * @param manage_ticks bool, default: True<br>
     *                     If True, the tick locations and labels will be adjusted to match
     *                     the boxplot positions.
     *                     
     * @param autorange bool, default: False<br>
     *                  When `True` and the data are distributed such that the 25th and
     *                  75th percentiles are equal, <b>whis</b>0 is set to (0, 100) such
     *                  that the whisker ends are at the minimum and maximum of the data.
     *                  
     * @param meanline bool, default: False<br>
     *                 If `True` (and <b>showmeans</b>0 is `True`), will try to render the
     *                 mean as a line spanning the full width of the box according to
     *                <b>meanprops</b>5props* (see below).  Not recommen<b>shownotches</b>10 if *shownotches* is also
     *                 True.  Otherwise, means will be shown as points.
     *                 
     * @param zorder float, default: ``Line2D.zorder = 2``<br>
     *               The zorder of the boxplot.
     * @param showcaps bool, default: True<br>
     *                 Show the caps on the ends of whiskers.
     * @param showbox bool, default: True<br>
     *                Show the central box.
     * @param showfliers bool, default: True<br>
     *                   Show the outliers beyond the caps.
     * @param showmeans bool, default: False<br>
     *                  Show the arithmetic means.
     * @param capprops dict, default: None<br>
     *                 The style of the caps.
     * @param boxprops dict, default: None<br>
     *                 The style of the box.
     * @param whiskerprops dict, default: None<br>
     *                     The style of the whiskers.
     * @param flierprops dict, default: None<br>
     *                   The style of the fliers.
     * @param medianprops dict, default: None<br>
     *                    The style of the median.
     * @param meanprops dict, default: None<br>
     *                  The style of the mean.
     * @param data n/a<br>undocumented
     * 
     * @return dict <br>
     *              A dictionary mapping each component of the boxplot to a list
     *              of the `.Line2D` instances created. That dictionary has the
     *              following keys (assuming vertical boxplots):
     *              
     *              - ``boxes``: the main body of the boxplot showing the
     *              quartiles and the median's confidence intervals if
     *              enabled.
     *              
     *              - ``medians``: horizontal lines at the median of each box.
     *              
     *              - ``whiskers``: the vertical lines extending to the most
     *              extreme, non-outlier data points.
     *              
     *              - ``caps``: the horizontal lines at the ends of the
     *              whiskers.
     *              
     *              - ``fliers``: points representing data that extend beyond
     *              the whiskers (fliers).
     *              
     *              - ``means``: points or lines representing the means.
     */
    public final Object boxplot(Object x, Object... args) {
        write("plt.boxplot("+PythonGrammar.toPythonArgs(x)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Plot a horizontal sequence of rectangles.
     * 
     * A rectangle is drawn for each element of <b>xranges</b>0. All rectangles
     * have the same vertical position and size defined by <b>yrange</b>0.
     * 
     * This is a convenience function for instantiating a
     * `.BrokenBarHCollection`, adding it to the Axes and autoscaling the
     * view.
     * <p>
     * <em>Notes:</em><br>
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * every other argument can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception).
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param xranges sequence of tuples (<b>xmin</b>0,<b>xwidth</b>5width*)<br>
     *                The x-positions and extends of the rectangles. For each tuple
     *          <b>xmin</b>10<b>xwidth</b>15n</b>10          (*xmin*, <b>xmin</b>20  <b>xmin</b>25n*, <b>xmin</b>20     (<b>xwidth</b>30*, <b>xmin</b>20     (*xmin*, *xwidth*) a rectangle is drawn from *xmin* to *xmin* +
     *                *xwidth*.
     * @param yrange (<b>ymin</b>0,<b>yheight</b>5eight*)<br>
     *               The y-position and extend for all the rectangles.
     * @param **kwargs `.BrokenBarHCollection` properties<br>
     *                 
     *                 Each <b>kwarg</b>0 can be either a single argument applying to all
     *                 rectangles, e.g.::
     *                 
     *                 facecolors='black'
     *                 
     *                 or a sequence of arguments over which is cycled, e.g.::
     *                 
     *                 facecolors=('black', 'blue')
     *                 
     *                 would create interleaving black and blue rectangles.
     *                 
     *                 Supported keywords:
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: array-like or scalar or None
     *                 animated: bool
     *                 antialiased or aa or antialiaseds: bool or list of bools
     *                 array: ndarray or None
     *                 capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 clim: (vmin: float, vmax: float)
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 cmap: `.Colormap` or str or None
     *                 color: color or list of rgba tuples
     *                 contains: unknown
     *                 edgecolor or ec or edgecolors: color or list of colors or 'face'
     *                 facecolor or facecolors or fc: color or list of colors
     *                 figure: `.Figure`
     *                 gid: str
     *                 hatch: &#123;'/', '\\', '|', '-', '+', 'x', 'o', 'O', '.', '*'&#125;
     *                 in_layout: bool
     *                 joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 label: object
     *                 linestyle or dashes or linestyles or ls: str or tuple or list thereof
     *                 linewidth or linewidths or lw: float or list of floats
     *                 norm: `.Normalize` or None
     *                 offset_position: unknown
     *                 offsets: (N, 2) or (2,) array-like
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: None or bool or float or callable
     *                 pickradius: float
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 transform: `.Transform`
     *                 url: str
     *                 urls: list of str or None
     *                 visible: bool
     *                 zorder: float
     * @param data n/a<br>undocumented
     * 
     * @return `~.collections.BrokenBarHCollection` <br>
     */
    public final Object broken_barh(Object xranges, Object yrange, Object... args) {
        write("plt.broken_barh("+PythonGrammar.toPythonArgs(xranges),PythonGrammar.toPythonArgs(yrange)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Clear the current axes.
     */
    public final Object cla() {
        write("plt.cla()");
        return null;
    }

    /**
     * Label a contour plot.
     * 
     * Adds labels to line contours in given `.ContourSet`.
     * 
     * @param CS `~.ContourSet` instance<br>
     *           Line contours to label.
     *           
     * @param levels array-like, optional<br>
     *               A list of level values, that should be labeled. The list must be
     *               a subset of ``CS.levels``. If not given, all levels are labeled.
     *               
     * @param **kwargs <br>
     *                 All other parameters are documented in `~.ContourLabeler.clabel`.
     */
    public final Object clabel(Object CS, Object... args) {
        write("plt.clabel("+PythonGrammar.toPythonArgs(CS)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Clear the current figure.
     */
    public final Object clf() {
        write("plt.clf()");
        return null;
    }

    /**
     * Set the color limits of the current image.
     * 
     * If either <b>vmin</b>0 or<b>vmax</b>5*vmax* is None, the image min/max respectively
     * will be used for color scaling.
     * 
     * If you want to set the clim of multiple images, use
     * `~.ScalarMappable.set_clim` on every image, for example::
     * 
     * for im in gca().get_images():
     * im.set_clim(0, 0.5)
     * 
     * @param vmin n/a<br>undocumented
     * @param vmax n/a<br>undocumented
     */
    public final Object clim(Object... args) {
        write("plt.clim("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Close a figure window.
     * 
     * @param fig None or int or str or `.Figure`<br>
     *            The figure to close. There are a number of ways to specify this:
     *            
     *            - <b>None</b>0: the current figure
     *            - `.Figure`: the given `.Figure` instance
     *            - ``int``: a figure number
     *            - ``str``: a figure name
     *            - 'all': all figures
     */
    public final Object close(Object... args) {
        write("plt.close("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Plot the coherence between <b>x</b>0 and<b>y</b>5nd *y*.
     * 
     * Plot the coherence between <b>x</b>0 and<b>y</b>5nd *y*.  Coherence is the
     * normalized cross spectral density:
     * 
     * .. math::
     * 
     * C_{xy} = \frac{|P_{xy}|^2}{P_{xx}P_{yy}}
     * <p>
     * <em>Notes:</em><br>
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * the following arguments can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception):
     * <b>x</b>0,<b>y</b>50, *y*.
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param Fs float, default: 2<br>
     *           The sampling frequency (samples per time unit).  It is used to calculate
     *           the Fourier frequencies, <b>freqs</b>0, in cycles per time unit.
     *           
     * @param window callable or ndarray, default: `.window_hanning`<br>
     *               A function or a vector of length <b>NFFT</b>0.  To create window vectors see
     *               `.window_hanning`, `.window_none`, `numpy.blackman`, `numpy.hamming`,
     *               `numpy.bartlett`, `scipy.signal`, `scipy.signal.get_window`, etc.  If a
     *               function is passed as the argument, it must take a data segment as an
     *               argument and return the windowed version of the segment.
     *               
     * @param sides &#123;'default', 'onesided', 'twosided'&#125;, optional<br>
     *              Which sides of the spectrum to return. 'default' is one-sided for real
     *              data and two-sided for complex data. 'onesided' forces the return of a
     *              one-sided spectrum, while 'twosided' forces two-sided.
     *              
     * @param pad_to int, optional<br>
     *               The number of points to which the data segment is padded when performing
     *               the FFT.  This can be different from <b>NFFT</b>0, which specifies the number
     *               of data points used.  While not increasing the actual resolution of the
     *               spectrum (the minimum distance between resolvable peaks), this can give
     *               more points in the plot, allowing for more detail. This corresponds to
     *               the<b>n</b>5he *n* parameter in the call to fft(). The default is None, which sets
     *        <b>pad_to</b>10        <b>NFFT</b>150         *pad_to* equal to *NFFT*
     *               
     * @param NFFT int, default: 256<br>
     *             The number of data points used in each block for the FFT.  A power 2 is
     *             most efficient.  This should <b>NOT</b>0 be used to get zero padding, or the
     *             scaling of the result will be incorrect; use<b>pad_to</b>5ad_to* for this instead.
     *             
     * @param detrend &#123;'none', 'mean', 'linear'&#125; or callable, default: 'none'<br>
     *                The function applied to each segment before fft-ing, designed to remove
     *                the mean or linear trend.  Unlike in MATLAB, where the <b>detrend</b>0 parameter
     *                is a vector, in Matplotlib is it a function.  The :mod:`~matplotlib.mlab`
     *                module defines `.detrend_none`, `.detrend_mean`, and `.detrend_linear`,
     *                but you can use a custom function as well.  You can also use a string to
     *                choose one of the functions: 'none' calls `.detrend_none`. 'mean' calls
     *                `.detrend_mean`. 'linear' calls `.detrend_linear`.
     *                
     * @param scale_by_freq bool, default: True<br>
     *                      Whether the resulting density values should be scaled by the scaling
     *                      frequency, which gives density in units of Hz^-1.  This allows for
     *                      integration over the returned frequency values.  The default is True for
     *                      MATLAB compatibility.
     *                      
     * @param noverlap int, default: 0 (no overlap)<br>
     *                 The number of points of overlap between blocks.
     *                 
     * @param Fc int, default: 0<br>
     *           The center frequency of <b>x</b>0, which offsets the x extents of the
     *           plot to reflect the frequency range used when a signal is acquired
     *           and then filtered and downsampled to baseband.
     * @param **kwargs <br>
     *                 Keyword arguments control the `.Line2D` properties:
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: scalar or None
     *                 animated: bool
     *                 antialiased or aa: bool
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 color or c: color
     *                 contains: unknown
     *                 dash_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 dash_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 dashes: sequence of floats (on/off ink in points) or (None, None)
     *                 data: (2, N) array or two 1D arrays
     *                 drawstyle or ds: &#123;'default', 'steps', 'steps-pre', 'steps-mid', 'steps-post'&#125;, default: 'default'
     *                 figure: `.Figure`
     *                 fillstyle: &#123;'full', 'left', 'right', 'bottom', 'top', 'none'&#125;
     *                 gid: str
     *                 in_layout: bool
     *                 label: object
     *                 linestyle or ls: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *                 linewidth or lw: float
     *                 marker: marker style string, `~.path.Path` or `~.markers.MarkerStyle`
     *                 markeredgecolor or mec: color
     *                 markeredgewidth or mew: float
     *                 markerfacecolor or mfc: color
     *                 markerfacecoloralt or mfcalt: color
     *                 markersize or ms: float
     *                 markevery: None or int or (int, int) or slice or list[int] or float or (float, float) or list[bool]
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: float or callable[[Artist, Event], tuple[bool, dict]]
     *                 pickradius: float
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 solid_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 solid_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 transform: `matplotlib.transforms.Transform`
     *                 url: str
     *                 visible: bool
     *                 xdata: 1D array
     *                 ydata: 1D array
     *                 zorder: float
     * @param x n/a<br>undocumented
     * @param y n/a<br>undocumented
     * @param data n/a<br>undocumented
     * 
     * @return (Cxy,freqs) (1-D array,1-D array)<br>
     *          The coherence vector.
     *          
     *          
     *          The frequencies for the elements in <b>Cxy</b>0.
     */
    public final Object cohere(Object... args) {
        write("plt.cohere("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Add a colorbar to a plot.
     * <p>
     * <em>Notes:</em><br>
     * Additional keyword arguments are of two kinds:
     * 
     * axes properties:
     * 
     * location : None or {'left', 'right', 'top', 'bottom'}
     * The location, relative to the parent axes, where the colorbar axes
     * is created.  It also determines the <b>orientation</b>0 of the colorbar
     * (colorbars on the left and right are vertical, colorbars at the top
     * and bottom are horizontal).  If None, the location will come from the
     * <b>orientation</b>0 if it is set (vertical colorbars on the right, horizontal
     * ones at the bottom), or default to 'right' if <b>orientation</b>0 is unset.
     * orientation : None or {'vertical', 'horizontal'}
     * The orientation of the colorbar.  It is preferable to set the <b>location</b>0
     * of the colorbar, as that also determines the <b>orientation</b>0; passing
     * incompatible values for <b>location</b>0 and<b>orientation</b>5ation* raises an exception.
     * fraction : float, default: 0.15
     * Fraction of original axes to use for colorbar.
     * shrink : float, default: 1.0
     * Fraction by which to multiply the size of the colorbar.
     * aspect : float, default: 20
     * Ratio of long to short dimensions.
     * 
     * 
     * pad : float, default: 0.05 if vertical, 0.15 if horizontal
     * Fraction of original axes between colorbar and new image axes.
     * anchor : (float, float), optional
     * The anchor point of the colorbar axes.
     * Defaults to (0.0, 0.5) if vertical; (0.5, 1.0) if horizontal.
     * panchor : (float, float), or <b>False</b>0, optional
     * The anchor point of the colorbar parent axes. If <b>False</b>0, the parent
     * axes' anchor will be unchanged.
     * Defaults to (1.0, 0.5) if vertical; (0.5, 0.0) if horizontal.
     * 
     * colorbar properties:
     * 
     * 
     * ============  ====================================================
     * Property      Description
     * ============  ====================================================
     * <b>extend</b>0      {'neither', 'both', 'min', 'max'}
     * If not 'neither', make pointed end(s) for out-of-
     * range values.  These are set for a given colormap
     * using the colormap set_under and set_over methods.
     * <b>extendfrac</b>0  <b>None</b>5*None*, 'auto', length, lengths}
     * If set to <b>None</b>0, both the minimum and maximum
     * triangular colorbar extensions with have a length of
     * 5% of the interior colorbar length (this is the
     * default setting). If set to 'auto', makes the
     * triangular colorbar extensions the same lengths as
     * the interior boxes (when <b>spacing</b>0 is set to
     * 'uniform') or the same lengths as the respective
     * adjacent interior boxes (when <b>spacing</b>0 is set to
     * 'proportional'). If a scalar, indicates the length
     * of both the minimum and maximum triangular colorbar
     * extensions as a fraction of the interior colorbar
     * length. A two-element sequence of fractions may also
     * be given, indicating the lengths of the minimum and
     * maximum colorbar extensions respectively as a
     * fraction of the interior colorbar length.
     * <b>extendrect</b>0  bool
     * If <b>False</b>0 the minimum and maximum colorbar extensions
     * will be triangular (the default). If <b>True</b>0 the
     * extensions will be rectangular.
     * <b>spacing</b>0     {'uniform', 'proportional'}
     * Uniform spacing gives each discrete color the same
     * space; proportional makes the space proportional to
     * the data interval.
     * <b>ticks</b>0      <b>None</b>5*None* or list of ticks or Locator
     * If None, ticks are determined automatically from the
     * input.
     * <b>format</b>0      None or str or Formatter
     * If None, `~.ticker.ScalarFormatter` is used.
     * If a format string is given, e.g., '%.3f', that is used.
     * An alternative `~.ticker.Formatter` may be given instead.
     * <b>drawedges</b>0   bool
     * Whether to draw lines at color boundaries.
     * <b>label</b>0       str
     * The label on the colorbar's long axis.
     * ============  ====================================================
     * 
     * The following will probably be useful only in the context of
     * indexed colors (that is, when the mappable has norm=NoNorm()),
     * or other unusual circumstances.
     * 
     * ============   ===================================================
     * Property       Description
     * ============   ===================================================
     * <b>boundaries</b>0   None or a sequence
     * <b>values</b>0       None or a sequence which must be of length 1 less
     * than the sequence of <b>boundaries</b>0. For each region
     * delimited by adjacent entries in <b>boundaries</b>0, the
     * colormapped to the corresponding value in values
     * will be used.
     * ============   ===================================================
     * 
     * 
     * 
     * If <b>mappable</b>0 is a `~.contour.ContourSet`, its<b>extend</b>5xtend* kwarg is included
     * automatically.
     * 
     * The <b>shrink</b>0 kwarg provides a simple way to scale the colorbar with respect
     * to the axes. Note that if <b>cax</b>0 is specified, it determines the size of the
     * colorbar and <b>shrink</b>0 and<b>aspect</b>5spect* kwargs are ignored.
     * 
     * For more precise control, you can manually specify the positions of
     * the axes objects in which the mappable and the colorbar are drawn.  In
     * this case, do not use any of the axes properties kwargs.
     * 
     * It is known that some vector graphics viewers (svg and pdf) renders white gaps
     * between segments of the colorbar.  This is due to bugs in the viewers, not
     * Matplotlib.  As a workaround, the colorbar can be rendered with overlapping
     * segments::
     * 
     * cbar = colorbar()
     * cbar.solids.set_edgecolor("face")
     * draw()
     * 
     * However this has negative consequences in other circumstances, e.g. with
     * semi-transparent images (alpha < 1) and colorbar extensions; therefore, this
     * workaround is not used by default (see issue #1188).
     * 
     * @param mappable <br>
     *                 The `matplotlib.cm.ScalarMappable` (i.e., `~matplotlib.image.AxesImage`,
     *                 `~matplotlib.contour.ContourSet`, etc.) described by this colorbar.
     *                 This argument is mandatory for the `.Figure.colorbar` method but optional
     *                 for the `.pyplot.colorbar` function, which sets the default to the current
     *                 image.
     *                 
     *                 Note that one can create a `.ScalarMappable` "on-the-fly" to generate
     *                 colorbars not attached to a previously drawn artist, e.g. ::
     *                 
     *                 fig.colorbar(cm.ScalarMappable(norm=norm, cmap=cmap), ax=ax)
     *                 
     * @param cax `~matplotlib.axes.Axes`, optional<br>
     *            Axes into which the colorbar will be drawn.
     *            
     * @param ax `~matplotlib.axes.Axes`, list of Axes, optional<br>
     *           One or more parent axes from which space for a new colorbar axes will be
     *           stolen, if <b>cax</b>0 is None.  This has no effect if<b>cax</b>5 *cax* is set.
     *           
     * @param use_gridspec bool, optional<br>
     *                     If <b>cax</b>0 is ``None``, a new<b>cax</b>5 *cax* is created as an instance of Axes.  If
     *              <b>ax</b>10             *ax* is an insta<b>use_gridspec</b>15ance of Subp<b>cax</b>20>15ance of Subplot and *use_gridspec* is ``True``, *cax* is
     *                     created as an instance of Subplot using the :mod:`~.gridspec` module.
     * @param **kw n/a<br>undocumented
     * 
     * @return colorbar `~matplotlib.colorbar.Colorbar`<br>
     *                  See also its base class, `~matplotlib.colorbar.ColorbarBase`.
     */
    public final Object colorbar(Object... args) {
        write("plt.colorbar("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Matplotlib provides a number of colormaps, and others can be added using
     * :func:`~matplotlib.cm.register_cmap`.  This function documents the built-in
     * colormaps, and will also return a list of all registered colormaps if
     * called.
     * 
     * You can set the colormap for an image, pcolor, scatter, etc,
     * using a keyword argument::
     * 
     * imshow(X, cmap=cm.hot)
     * 
     * or using the :func:`set_cmap` function::
     * 
     * imshow(X)
     * pyplot.set_cmap('hot')
     * pyplot.set_cmap('jet')
     * 
     * In interactive mode, :func:`set_cmap` will update the colormap post-hoc,
     * allowing you to see which one works best for your data.
     * 
     * All built-in colormaps can be reversed by appending ``_r``: For instance,
     * ``gray_r`` is the reverse of ``gray``.
     * 
     * There are several common color schemes used in visualization:
     * 
     * Sequential schemes
     * for unipolar data that progresses from low to high
     * Diverging schemes
     * for bipolar data that emphasizes positive or negative deviations from a
     * central value
     * Cyclic schemes
     * for plotting values that wrap around at the endpoints, such as phase
     * angle, wind direction, or time of day
     * Qualitative schemes
     * for nominal data that has no inherent ordering, where color is used
     * only to distinguish categories
     * 
     * Matplotlib ships with 4 perceptually uniform colormaps which are
     * the recommended colormaps for sequential data:
     * 
     * =========   ===================================================
     * Colormap    Description
     * =========   ===================================================
     * inferno     perceptually uniform shades of black-red-yellow
     * magma       perceptually uniform shades of black-red-white
     * plasma      perceptually uniform shades of blue-red-yellow
     * viridis     perceptually uniform shades of blue-green-yellow
     * =========   ===================================================
     * 
     * The following colormaps are based on the `ColorBrewer
     * <https://colorbrewer2.org>`_ color specifications and designs developed by
     * Cynthia Brewer:
     * 
     * ColorBrewer Diverging (luminance is highest at the midpoint, and
     * decreases towards differently-colored endpoints):
     * 
     * ========  ===================================
     * Colormap  Description
     * ========  ===================================
     * BrBG      brown, white, blue-green
     * PiYG      pink, white, yellow-green
     * PRGn      purple, white, green
     * PuOr      orange, white, purple
     * RdBu      red, white, blue
     * RdGy      red, white, gray
     * RdYlBu    red, yellow, blue
     * RdYlGn    red, yellow, green
     * Spectral  red, orange, yellow, green, blue
     * ========  ===================================
     * 
     * ColorBrewer Sequential (luminance decreases monotonically):
     * 
     * ========  ====================================
     * Colormap  Description
     * ========  ====================================
     * Blues     white to dark blue
     * BuGn      white, light blue, dark green
     * BuPu      white, light blue, dark purple
     * GnBu      white, light green, dark blue
     * Greens    white to dark green
     * Greys     white to black (not linear)
     * Oranges   white, orange, dark brown
     * OrRd      white, orange, dark red
     * PuBu      white, light purple, dark blue
     * PuBuGn    white, light purple, dark green
     * PuRd      white, light purple, dark red
     * Purples   white to dark purple
     * RdPu      white, pink, dark purple
     * Reds      white to dark red
     * YlGn      light yellow, dark green
     * YlGnBu    light yellow, light green, dark blue
     * YlOrBr    light yellow, orange, dark brown
     * YlOrRd    light yellow, orange, dark red
     * ========  ====================================
     * 
     * ColorBrewer Qualitative:
     * 
     * (For plotting nominal data, `.ListedColormap` is used,
     * not `.LinearSegmentedColormap`.  Different sets of colors are
     * recommended for different numbers of categories.)
     * 
     * * Accent
     * * Dark2
     * * Paired
     * * Pastel1
     * * Pastel2
     * * Set1
     * * Set2
     * * Set3
     * 
     * A set of colormaps derived from those of the same name provided
     * with Matlab are also included:
     * 
     * =========   =======================================================
     * Colormap    Description
     * =========   =======================================================
     * autumn      sequential linearly-increasing shades of red-orange-yellow
     * bone        sequential increasing black-white colormap with
     * a tinge of blue, to emulate X-ray film
     * cool        linearly-decreasing shades of cyan-magenta
     * copper      sequential increasing shades of black-copper
     * flag        repetitive red-white-blue-black pattern (not cyclic at
     * endpoints)
     * gray        sequential linearly-increasing black-to-white
     * grayscale
     * hot         sequential black-red-yellow-white, to emulate blackbody
     * radiation from an object at increasing temperatures
     * jet         a spectral map with dark endpoints, blue-cyan-yellow-red;
     * based on a fluid-jet simulation by NCSA [#]_
     * pink        sequential increasing pastel black-pink-white, meant
     * for sepia tone colorization of photographs
     * prism       repetitive red-yellow-green-blue-purple-...-green pattern
     * (not cyclic at endpoints)
     * spring      linearly-increasing shades of magenta-yellow
     * summer      sequential linearly-increasing shades of green-yellow
     * winter      linearly-increasing shades of blue-green
     * =========   =======================================================
     * 
     * A set of palettes from the `Yorick scientific visualisation
     * package <https://dhmunro.github.io/yorick-doc/>`_, an evolution of
     * the GIST package, both by David H. Munro are included:
     * 
     * ============  =======================================================
     * Colormap      Description
     * ============  =======================================================
     * gist_earth    mapmaker's colors from dark blue deep ocean to green
     * lowlands to brown highlands to white mountains
     * gist_heat     sequential increasing black-red-orange-white, to emulate
     * blackbody radiation from an iron bar as it grows hotter
     * gist_ncar     pseudo-spectral black-blue-green-yellow-red-purple-white
     * colormap from National Center for Atmospheric
     * Research [#]_
     * gist_rainbow  runs through the colors in spectral order from red to
     * violet at full saturation (like <b>hsv</b>0 but not cyclic)
     * gist_stern    "Stern special" color table from Interactive Data
     * Language software
     * ============  =======================================================
     * 
     * A set of cyclic colormaps:
     * 
     * ================  =================================================
     * Colormap          Description
     * ================  =================================================
     * hsv               red-yellow-green-cyan-blue-magenta-red, formed by
     * changing the hue component in the HSV color space
     * twilight          perceptually uniform shades of
     * white-blue-black-red-white
     * twilight_shifted  perceptually uniform shades of
     * black-blue-white-red-black
     * ================  =================================================
     * 
     * Other miscellaneous schemes:
     * 
     * ============= =======================================================
     * Colormap      Description
     * ============= =======================================================
     * afmhot        sequential black-orange-yellow-white blackbody
     * spectrum, commonly used in atomic force microscopy
     * brg           blue-red-green
     * bwr           diverging blue-white-red
     * coolwarm      diverging blue-gray-red, meant to avoid issues with 3D
     * shading, color blindness, and ordering of colors [#]_
     * CMRmap        "Default colormaps on color images often reproduce to
     * confusing grayscale images. The proposed colormap
     * maintains an aesthetically pleasing color image that
     * automatically reproduces to a monotonic grayscale with
     * discrete, quantifiable saturation levels." [#]_
     * cubehelix     Unlike most other color schemes cubehelix was designed
     * by D.A. Green to be monotonically increasing in terms
     * of perceived brightness. Also, when printed on a black
     * and white postscript printer, the scheme results in a
     * greyscale with monotonically increasing brightness.
     * This color scheme is named cubehelix because the (r, g, b)
     * values produced can be visualised as a squashed helix
     * around the diagonal in the (r, g, b) color cube.
     * gnuplot       gnuplot's traditional pm3d scheme
     * (black-blue-red-yellow)
     * gnuplot2      sequential color printable as gray
     * (black-blue-violet-yellow-white)
     * ocean         green-blue-white
     * rainbow       spectral purple-blue-green-yellow-orange-red colormap
     * with diverging luminance
     * seismic       diverging blue-white-red
     * nipy_spectral black-purple-blue-green-yellow-red-white spectrum,
     * originally from the Neuroimaging in Python project
     * terrain       mapmaker's colors, blue-green-yellow-brown-white,
     * originally from IGOR Pro
     * turbo         Spectral map (purple-blue-green-yellow-orange-red) with
     * a bright center and darker endpoints. A smoother
     * alternative to jet.
     * ============= =======================================================
     * 
     * The following colormaps are redundant and may be removed in future
     * versions.  It's recommended to use the names in the descriptions
     * instead, which produce identical output:
     * 
     * =========  =======================================================
     * Colormap   Description
     * =========  =======================================================
     * gist_gray  identical to <b>gray</b>0
     * gist_yarg  identical to <b>gray_r</b>0
     * binary     identical to <b>gray_r</b>0
     * =========  =======================================================
     * 
     * .. rubric:: Footnotes
     * 
     * .. [#] Rainbow colormaps, ``jet`` in particular, are considered a poor
     * choice for scientific visualization by many researchers: `Rainbow Color
     * Map (Still) Considered Harmful
     * <https://ieeexplore.ieee.org/document/4118486/?arnumber=4118486>`_
     * 
     * .. [#] Resembles "BkBlAqGrYeOrReViWh200" from NCAR Command
     * Language. See `Color Table Gallery
     * <https://www.ncl.ucar.edu/Document/Graphics/color_table_gallery.shtml>`_
     * 
     * .. [#] See `Diverging Color Maps for Scientific Visualization
     * <http://www.kennethmoreland.com/color-maps/>`_ by Kenneth Moreland.
     * 
     * .. [#] See `A Color Map for Effective Black-and-White Rendering of
     * Color-Scale Images
     * <https://www.mathworks.com/matlabcentral/fileexchange/2662-cmrmap-m>`_
     * by Carey Rappaport
     */
    public final Object colormaps() {
        write("plt.colormaps()");
        return null;
    }

    /**
     * Bind function <b>func</b>0 to event<b>s</b>5nt *s*.
     * 
     * @param s str<br>
     *          One of the following events ids:
     *          
     *          - 'button_press_event'
     *          - 'button_release_event'
     *          - 'draw_event'
     *          - 'key_press_event'
     *          - 'key_release_event'
     *          - 'motion_notify_event'
     *          - 'pick_event'
     *          - 'resize_event'
     *          - 'scroll_event'
     *          - 'figure_enter_event',
     *          - 'figure_leave_event',
     *          - 'axes_enter_event',
     *          - 'axes_leave_event'
     *          - 'close_event'.
     *          
     * @param func callable<br>
     *             The callback function to be executed, which must have the
     *             signature::
     *             
     *             def func(event: Event) -&gt; Any
     *             
     *             For the location events (button and key press/release), if the
     *             mouse is over the axes, the ``inaxes`` attribute of the event will
     *             be set to the `~matplotlib.axes.Axes` the event occurs is over, and
     *             additionally, the variables ``xdata`` and ``ydata`` attributes will
     *             be set to the mouse location in data coordinates.  See `.KeyEvent`
     *             and `.MouseEvent` for more info.
     * 
     * @return cid <br>
     *             A connection id that can be used with
     *             `.FigureCanvasBase.mpl_disconnect`.
     */
    public final Object connect(Object s, Object func) {
        write("plt.connect("+PythonGrammar.toPythonArgs(s),PythonGrammar.toPythonArgs(func)+")");
        return null;
    }

    /**
     * Plot contour lines.
     * 
     * Call signature::
     * 
     * contour([X, Y,] Z, [levels], **kwargs)
     * 
     * `.contour` and `.contourf` draw contour lines and filled contours,
     * respectively.  Except as noted, function signatures and return values
     * are the same for both versions.
     * <p>
     * <em>Notes:</em><br>
     * 1. `.contourf` differs from the MATLAB version in that it does not draw
     * the polygon edges. To draw edges, add line contours with calls to
     * `.contour`.
     * 
     * 2. `.contourf` fills intervals that are closed at the top; that is, for
     * boundaries <b>z1</b>0 and<b>z2</b>5d *z2*, the filled region is::
     * 
     * z1 < Z <= z2
     * 
     * except for the lowest interval, which is closed on both sides (i.e.
     * it includes the lowest value).
     * 
     * @param X array-like, optional<br>
     *          The coordinates of the values in <b>Z</b>0.
     *          
     *         <b>X</b>5   *<b>Y</b>10b>5   *X* and *Y* must both be 2D with<b>Z</b>15h be 2D with the same shape as *Z* (e.g.
     *          created via `numpy.meshgrid`), or they must both be 1-D such
     *          that ``len(X)<b>Z</b>20    that ``len(X) == M`` is the number of columns in *Z* and<b>Z</b>25 of columns in *Z* and
     *          ``len(Y) == N`` is the number of rows in *Z*.
     *          
     *          If not given, they are assumed to be integer indices, i.e.
     *          ``X = range(M)``, ``Y = range(N)``.
     *          
     * @param Y array-like, optional<br>
     *          The coordinates of the values in <b>Z</b>0.
     *          
     *         <b>X</b>5   *<b>Y</b>10b>5   *X* and *Y* must both be 2D with<b>Z</b>15h be 2D with the same shape as *Z* (e.g.
     *          created via `numpy.meshgrid`), or they must both be 1-D such
     *          that ``len(X)<b>Z</b>20    that ``len(X) == M`` is the number of columns in *Z* and<b>Z</b>25 of columns in *Z* and
     *          ``len(Y) == N`` is the number of rows in *Z*.
     *          
     *          If not given, they are assumed to be integer indices, i.e.
     *          ``X = range(M)``, ``Y = range(N)``.
     *          
     * @param Z (M, N) array-like<br>
     *          The height values over which the contour is drawn.
     *          
     * @param levels int or array-like, optional<br>
     *               Determines the number and positions of the contour lines / regions.
     *               
     *               If an int <b>n</b>0, use `~matplotlib.ticker.MaxNLocator`, which tries
     *               to automatically choose no more than *n+1* "nice" contour levels
     *               between<b>vmin</b>5*vmi<b>vmax</b>10*vmin* and *vmax*.
     *               
     *               If array-like, draw contour lines at the specified levels.
     *               The values must be in increasing order.
     * @param corner_mask bool, default: :rc:`contour.corner_mask`<br>
     *                    Enable/disable corner masking, which only has an effect if <b>Z</b>0 is
     *                    a masked array.  If ``False``, any quad touching a masked point is
     *                    masked out.  If ``True``, only the triangular corners of quads
     *                    nearest those points are always masked out, other triangular
     *                    corners comprising three unmasked points are contoured as usual.
     *                    
     * @param colors color string or sequence of colors, optional<br>
     *               The colors of the levels, i.e. the lines for `.contour` and the
     *               areas for `.contourf`.
     *               
     *               The sequence is cycled for the levels in ascending order. If the
     *               sequence is shorter than the number of levels, it's repeated.
     *               
     *               As a shortcut, single color strings may be used in place of
     *               one-element lists, i.e. ``'red'`` instead of ``['red']`` to color
     *               all levels with the same color. This shortcut does only work for
     *               color strings, not for other ways of specifying colors.
     *               
     *               By default (value <b>None</b>0), the colormap specified by<b>cmap</b>5*cmap*
     *               will be used.
     *               
     * @param alpha float, default: 1<br>
     *              The alpha blending value, between 0 (transparent) and 1 (opaque).
     *              
     * @param cmap str or `.Colormap`, default: :rc:`image.cmap`<br>
     *             A `.Colormap` instance or registered colormap name. The colormap
     *             maps the level values to colors.
     *             
     *             If both <b>colors</b>0 and<b>cmap</b>5*cmap* are given, an error is raised.
     *             
     * @param norm `~matplotlib.colors.Normalize`, optional<br>
     *             If a colormap is used, the `.Normalize` instance scales the level
     *             values to the canonical colormap range [0, 1] for mapping to
     *             colors. If not given, the default linear scaling is used.
     *             
     * @param vmin float, optional<br>
     *             If not <b>None</b>0, either or both of these values will be supplied to
     *             the `.Normalize` instance, overriding the default color scaling
     *             based on<b>levels</b>5evels*.
     *             
     * @param vmax float, optional<br>
     *             If not <b>None</b>0, either or both of these values will be supplied to
     *             the `.Normalize` instance, overriding the default color scaling
     *             based on<b>levels</b>5evels*.
     *             
     * @param origin &#123;<b>None</b>0, 'upper', 'lower', 'image'&#125;, default: None<br>
     *               Determines the orientation and exact position of<b>Z</b>5of *Z* by specifying
     *               the position of ``Z[0, 0]``.  This is only releva<b>X</b>10<b>Y</b>15va<b>X</b>10 relevant, if *X*, *Y*
     *               are not given.
     *   <b>None</b>20ven.
     *               
     *               - *None*: ``Z[0, 0]`` is at X=0, Y=0 in the lower left corner.
     *               - 'lower': ``Z[0, 0]`` is at X=0.5, Y=0.5 in the lower left corner.
     *               - 'upper': ``Z[0, 0]`` is at X=N+0.5, Y=0.5 in the upper left
     *               corner.
     *               - 'image': Use the value from :rc:`image.origin`.
     *               
     * @param extent (x0, x1, y0, y1), optional<br>
     *               If <b>origin</b>0 is not<b>None</b>5*None*<b>extent</b>10e*, then *extent* is interpreted as in
     *               `.imshow`: it gives the outer pixel boundaries. In this case, the
     *               position of Z[0, 0] is the center of the pixel, not a corner. If
  <b>origin</b>15. <b>None</b>20origin<b>x0</b>25<b>y0</b>30one</b>20origin<b>x0</b>25. <b>None</b>20origin</b>15.<b>x1</b>35<b>y1</b>40b>None</b>20origin</b>15.<b>x1</b>35>25. <b>None</b>20origin</b>15. If
     *               *origin* <b>X</b>45n</<b>Y</b>50 If
     *               *origin* <b>X</b>45n</b>15. If
     *               *origin* is *None*, then (*x0*, *y0*) is the position of Z[0, 0],
     *               and (*x1*, *y1*) is the position of Z[-1, -1].
     *               
     *               This argument is ignored if *X* and *Y* are specified in the call
     *               to contour.
     *               
     * @param locator ticker.Locator subclass, optional<br>
     *                The locator is used to determine the contour levels if they
     *                are not given explicitly via <b>levels</b>0.
     *                Defaults to `~.ticker.MaxNLocator`.
     *                
     * @param extend &#123;'neither', 'both', 'min', 'max'&#125;, default: 'neither'<br>
     *               Determines the ``contourf``-coloring of values that are outside the
     *               <b>levels</b>0 range.
     *               
     *               If 'neither', values outside the<b>levels</b>5evels* range are not colored.
     *               If 'min', 'max' or 'both', color the values below, above or below
     *               and abo<b>levels</b>10bove the *levels* range.
     *               
     *               Values below ``min(levels)`` and above ``max(levels)`` are mapped
     *               to the under/over values of the `.Colormap`. Note that most
     *               colormaps do not have dedicated colors for these by default, so
     *               that the over and under values are the edge values of the colormap.
     *               You may want to set these values explicitly using
     *               `.Colormap.set_under` and `.Colormap.set_over`.
     *               
     *               .. note::
     *               
     *               An existing `.QuadContourSet` does not get notified if
     *               properties of its colormap are changed. Therefore, an explicit
     *               call `.QuadContourSet.changed()` is needed after modifying the
     *               colormap. The explicit call can be left out, if a colorbar is
     *               assigned to the `.QuadContourSet` because it internally calls
     *               `.QuadContourSet.changed()`.
     *               
     *               Example::
     *               
     *               x = np.arange(1, 10)
     *               y = x.reshape(-1, 1)
     *               h = x * y
     *               
     *               cs = plt.contourf(h, levels=[10, 30, 50],
     *               colors=['#808080', '#A0A0A0', '#C0C0C0'], extend='both')
     *               cs.cmap.set_over('red')
     *               cs.cmap.set_under('blue')
     *               cs.changed()
     *               
     * @param xunits registered units, optional<br>
     *               Override axis units by specifying an instance of a
     *               :class:`matplotlib.units.ConversionInterface`.
     *               
     * @param yunits registered units, optional<br>
     *               Override axis units by specifying an instance of a
     *               :class:`matplotlib.units.ConversionInterface`.
     *               
     * @param antialiased bool, optional<br>
     *                    Enable antialiasing, overriding the defaults.  For
     *                    filled contours, the default is <b>True</b>0.  For line contours,
     *                    it is taken from :rc:`lines.antialiased`.
     *                    
     * @param nchunk int &gt;= 0, optional<br>
     *               If 0, no subdivision of the domain.  Specify a positive integer to
     *               divide the domain into subdomains of <b>nchunk</b>0 by<b>nchunk</b>5chunk* quads.
     *               Chunking reduces the maximum length of polygons generated by the
     *               contouring algorithm which reduces the rendering workload passed
     *               on to the backend and also requires slightly less RAM.  It can
     *               however introduce rendering artifacts at chunk boundaries depending
     *               on the backen<b>antialiased</b>10the *antialiased*<b>alpha</b>15aliased* flag and value of *alpha*.
     *               
     * @param linewidths float or array-like, default: :rc:`contour.linewidth`<br>
     *                   *Only applies to* `.contour`.
     *                   
     *                   The line width of the contour lines.
     *                   
     *                   If a number, all levels will be plotted with this linewidth.
     *                   
     *                   If a sequence, the levels in ascending order will be plotted with
     *                   the linewidths in the order specified.
     *                   
     *                   If None, this falls back to :rc:`lines.linewidth`.
     *                   
     * @param linestyles &#123;<b>None</b>0, 'solid', 'dashed', 'dashdot', 'dotted'&#125;, optional<br>
     *                   *Only applies to* `.contour`.
     *                   
     *                   If<b>linestyles</b>5tyl<b>None</b>105tyles* is *None*, the default is 'solid' unless the lines
     *                   are monochrome.  In that case, negative contours will take their
     *                   linestyle from :rc:`contour.negative_linestyle` setting.
     *                   
     *<b>linestyles</b>15  *                   *linestyles* can also be an iterable of the above strings
     *                   specifying a set of linestyles to be used. If this
     *                   iterable is shorter than the number of contour levels
     *                   it will be repeated as necessary.
     *                   
     * @param hatches list[str], optional<br>
     *                *Only applies to* `.contourf`.
     *                
     *                A list of cross hatch patterns to use on the filled areas.
     *                If None, no hatching will be added to the contour.
     *                Hatching is supported in the PostScript, PDF, SVG and Agg
     *                backends only.
     * @param *args n/a<br>undocumented
     * @param data n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     * 
     * @return `~.contour.QuadContourSet` <br>
     */
    public final Object contour(Object... args) {
        write("plt.contour("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Plot filled contours.
     * 
     * Call signature::
     * 
     * contourf([X, Y,] Z, [levels], **kwargs)
     * 
     * `.contour` and `.contourf` draw contour lines and filled contours,
     * respectively.  Except as noted, function signatures and return values
     * are the same for both versions.
     * <p>
     * <em>Notes:</em><br>
     * 1. `.contourf` differs from the MATLAB version in that it does not draw
     * the polygon edges. To draw edges, add line contours with calls to
     * `.contour`.
     * 
     * 2. `.contourf` fills intervals that are closed at the top; that is, for
     * boundaries <b>z1</b>0 and<b>z2</b>5d *z2*, the filled region is::
     * 
     * z1 < Z <= z2
     * 
     * except for the lowest interval, which is closed on both sides (i.e.
     * it includes the lowest value).
     * 
     * @param X array-like, optional<br>
     *          The coordinates of the values in <b>Z</b>0.
     *          
     *         <b>X</b>5   *<b>Y</b>10b>5   *X* and *Y* must both be 2D with<b>Z</b>15h be 2D with the same shape as *Z* (e.g.
     *          created via `numpy.meshgrid`), or they must both be 1-D such
     *          that ``len(X)<b>Z</b>20    that ``len(X) == M`` is the number of columns in *Z* and<b>Z</b>25 of columns in *Z* and
     *          ``len(Y) == N`` is the number of rows in *Z*.
     *          
     *          If not given, they are assumed to be integer indices, i.e.
     *          ``X = range(M)``, ``Y = range(N)``.
     *          
     * @param Y array-like, optional<br>
     *          The coordinates of the values in <b>Z</b>0.
     *          
     *         <b>X</b>5   *<b>Y</b>10b>5   *X* and *Y* must both be 2D with<b>Z</b>15h be 2D with the same shape as *Z* (e.g.
     *          created via `numpy.meshgrid`), or they must both be 1-D such
     *          that ``len(X)<b>Z</b>20    that ``len(X) == M`` is the number of columns in *Z* and<b>Z</b>25 of columns in *Z* and
     *          ``len(Y) == N`` is the number of rows in *Z*.
     *          
     *          If not given, they are assumed to be integer indices, i.e.
     *          ``X = range(M)``, ``Y = range(N)``.
     *          
     * @param Z (M, N) array-like<br>
     *          The height values over which the contour is drawn.
     *          
     * @param levels int or array-like, optional<br>
     *               Determines the number and positions of the contour lines / regions.
     *               
     *               If an int <b>n</b>0, use `~matplotlib.ticker.MaxNLocator`, which tries
     *               to automatically choose no more than *n+1* "nice" contour levels
     *               between<b>vmin</b>5*vmi<b>vmax</b>10*vmin* and *vmax*.
     *               
     *               If array-like, draw contour lines at the specified levels.
     *               The values must be in increasing order.
     * @param corner_mask bool, default: :rc:`contour.corner_mask`<br>
     *                    Enable/disable corner masking, which only has an effect if <b>Z</b>0 is
     *                    a masked array.  If ``False``, any quad touching a masked point is
     *                    masked out.  If ``True``, only the triangular corners of quads
     *                    nearest those points are always masked out, other triangular
     *                    corners comprising three unmasked points are contoured as usual.
     *                    
     * @param colors color string or sequence of colors, optional<br>
     *               The colors of the levels, i.e. the lines for `.contour` and the
     *               areas for `.contourf`.
     *               
     *               The sequence is cycled for the levels in ascending order. If the
     *               sequence is shorter than the number of levels, it's repeated.
     *               
     *               As a shortcut, single color strings may be used in place of
     *               one-element lists, i.e. ``'red'`` instead of ``['red']`` to color
     *               all levels with the same color. This shortcut does only work for
     *               color strings, not for other ways of specifying colors.
     *               
     *               By default (value <b>None</b>0), the colormap specified by<b>cmap</b>5*cmap*
     *               will be used.
     *               
     * @param alpha float, default: 1<br>
     *              The alpha blending value, between 0 (transparent) and 1 (opaque).
     *              
     * @param cmap str or `.Colormap`, default: :rc:`image.cmap`<br>
     *             A `.Colormap` instance or registered colormap name. The colormap
     *             maps the level values to colors.
     *             
     *             If both <b>colors</b>0 and<b>cmap</b>5*cmap* are given, an error is raised.
     *             
     * @param norm `~matplotlib.colors.Normalize`, optional<br>
     *             If a colormap is used, the `.Normalize` instance scales the level
     *             values to the canonical colormap range [0, 1] for mapping to
     *             colors. If not given, the default linear scaling is used.
     *             
     * @param vmin float, optional<br>
     *             If not <b>None</b>0, either or both of these values will be supplied to
     *             the `.Normalize` instance, overriding the default color scaling
     *             based on<b>levels</b>5evels*.
     *             
     * @param vmax float, optional<br>
     *             If not <b>None</b>0, either or both of these values will be supplied to
     *             the `.Normalize` instance, overriding the default color scaling
     *             based on<b>levels</b>5evels*.
     *             
     * @param origin &#123;<b>None</b>0, 'upper', 'lower', 'image'&#125;, default: None<br>
     *               Determines the orientation and exact position of<b>Z</b>5of *Z* by specifying
     *               the position of ``Z[0, 0]``.  This is only releva<b>X</b>10<b>Y</b>15va<b>X</b>10 relevant, if *X*, *Y*
     *               are not given.
     *   <b>None</b>20ven.
     *               
     *               - *None*: ``Z[0, 0]`` is at X=0, Y=0 in the lower left corner.
     *               - 'lower': ``Z[0, 0]`` is at X=0.5, Y=0.5 in the lower left corner.
     *               - 'upper': ``Z[0, 0]`` is at X=N+0.5, Y=0.5 in the upper left
     *               corner.
     *               - 'image': Use the value from :rc:`image.origin`.
     *               
     * @param extent (x0, x1, y0, y1), optional<br>
     *               If <b>origin</b>0 is not<b>None</b>5*None*<b>extent</b>10e*, then *extent* is interpreted as in
     *               `.imshow`: it gives the outer pixel boundaries. In this case, the
     *               position of Z[0, 0] is the center of the pixel, not a corner. If
  <b>origin</b>15. <b>None</b>20origin<b>x0</b>25<b>y0</b>30one</b>20origin<b>x0</b>25. <b>None</b>20origin</b>15.<b>x1</b>35<b>y1</b>40b>None</b>20origin</b>15.<b>x1</b>35>25. <b>None</b>20origin</b>15. If
     *               *origin* <b>X</b>45n</<b>Y</b>50 If
     *               *origin* <b>X</b>45n</b>15. If
     *               *origin* is *None*, then (*x0*, *y0*) is the position of Z[0, 0],
     *               and (*x1*, *y1*) is the position of Z[-1, -1].
     *               
     *               This argument is ignored if *X* and *Y* are specified in the call
     *               to contour.
     *               
     * @param locator ticker.Locator subclass, optional<br>
     *                The locator is used to determine the contour levels if they
     *                are not given explicitly via <b>levels</b>0.
     *                Defaults to `~.ticker.MaxNLocator`.
     *                
     * @param extend &#123;'neither', 'both', 'min', 'max'&#125;, default: 'neither'<br>
     *               Determines the ``contourf``-coloring of values that are outside the
     *               <b>levels</b>0 range.
     *               
     *               If 'neither', values outside the<b>levels</b>5evels* range are not colored.
     *               If 'min', 'max' or 'both', color the values below, above or below
     *               and abo<b>levels</b>10bove the *levels* range.
     *               
     *               Values below ``min(levels)`` and above ``max(levels)`` are mapped
     *               to the under/over values of the `.Colormap`. Note that most
     *               colormaps do not have dedicated colors for these by default, so
     *               that the over and under values are the edge values of the colormap.
     *               You may want to set these values explicitly using
     *               `.Colormap.set_under` and `.Colormap.set_over`.
     *               
     *               .. note::
     *               
     *               An existing `.QuadContourSet` does not get notified if
     *               properties of its colormap are changed. Therefore, an explicit
     *               call `.QuadContourSet.changed()` is needed after modifying the
     *               colormap. The explicit call can be left out, if a colorbar is
     *               assigned to the `.QuadContourSet` because it internally calls
     *               `.QuadContourSet.changed()`.
     *               
     *               Example::
     *               
     *               x = np.arange(1, 10)
     *               y = x.reshape(-1, 1)
     *               h = x * y
     *               
     *               cs = plt.contourf(h, levels=[10, 30, 50],
     *               colors=['#808080', '#A0A0A0', '#C0C0C0'], extend='both')
     *               cs.cmap.set_over('red')
     *               cs.cmap.set_under('blue')
     *               cs.changed()
     *               
     * @param xunits registered units, optional<br>
     *               Override axis units by specifying an instance of a
     *               :class:`matplotlib.units.ConversionInterface`.
     *               
     * @param yunits registered units, optional<br>
     *               Override axis units by specifying an instance of a
     *               :class:`matplotlib.units.ConversionInterface`.
     *               
     * @param antialiased bool, optional<br>
     *                    Enable antialiasing, overriding the defaults.  For
     *                    filled contours, the default is <b>True</b>0.  For line contours,
     *                    it is taken from :rc:`lines.antialiased`.
     *                    
     * @param nchunk int &gt;= 0, optional<br>
     *               If 0, no subdivision of the domain.  Specify a positive integer to
     *               divide the domain into subdomains of <b>nchunk</b>0 by<b>nchunk</b>5chunk* quads.
     *               Chunking reduces the maximum length of polygons generated by the
     *               contouring algorithm which reduces the rendering workload passed
     *               on to the backend and also requires slightly less RAM.  It can
     *               however introduce rendering artifacts at chunk boundaries depending
     *               on the backen<b>antialiased</b>10the *antialiased*<b>alpha</b>15aliased* flag and value of *alpha*.
     *               
     * @param linewidths float or array-like, default: :rc:`contour.linewidth`<br>
     *                   *Only applies to* `.contour`.
     *                   
     *                   The line width of the contour lines.
     *                   
     *                   If a number, all levels will be plotted with this linewidth.
     *                   
     *                   If a sequence, the levels in ascending order will be plotted with
     *                   the linewidths in the order specified.
     *                   
     *                   If None, this falls back to :rc:`lines.linewidth`.
     *                   
     * @param linestyles &#123;<b>None</b>0, 'solid', 'dashed', 'dashdot', 'dotted'&#125;, optional<br>
     *                   *Only applies to* `.contour`.
     *                   
     *                   If<b>linestyles</b>5tyl<b>None</b>105tyles* is *None*, the default is 'solid' unless the lines
     *                   are monochrome.  In that case, negative contours will take their
     *                   linestyle from :rc:`contour.negative_linestyle` setting.
     *                   
     *<b>linestyles</b>15  *                   *linestyles* can also be an iterable of the above strings
     *                   specifying a set of linestyles to be used. If this
     *                   iterable is shorter than the number of contour levels
     *                   it will be repeated as necessary.
     *                   
     * @param hatches list[str], optional<br>
     *                *Only applies to* `.contourf`.
     *                
     *                A list of cross hatch patterns to use on the filled areas.
     *                If None, no hatching will be added to the contour.
     *                Hatching is supported in the PostScript, PDF, SVG and Agg
     *                backends only.
     * @param *args n/a<br>undocumented
     * @param data n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     * 
     * @return `~.contour.QuadContourSet` <br>
     */
    public final Object contourf(Object... args) {
        write("plt.contourf("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the colormap to 'cool'.
     * 
     * This changes the default colormap as well as the colormap of the current
     * image if there is one. See ``help(colormaps)`` for more information.
     */
    public final Object cool() {
        write("plt.cool()");
        return null;
    }

    /**
     * Set the colormap to 'copper'.
     * 
     * This changes the default colormap as well as the colormap of the current
     * image if there is one. See ``help(colormaps)`` for more information.
     */
    public final Object copper() {
        write("plt.copper()");
        return null;
    }

    /**
     * Plot the cross-spectral density.
     * 
     * The cross spectral density :math:`P_{xy}` by Welch's average
     * periodogram method.  The vectors <b>x</b>0 and<b>y</b>5nd *y* are divided into
     * <b>NFFT</b>0 length segments.  Each segment is detrended by function
     * <b>detrend</b>0 and windowed by function<b>window</b>5in<b>noverlap</b>10dow*.  *noverlap* gives
     * the length of the overlap between segments.  The product of
     * the direct FFTs of <b>x</b>0 and<b>y</b>5nd *y* are averaged over each segment
     * to compute :math:`P_{xy}`, with a scaling to correct for power
     * loss due to windowing.
     * 
     * If len(<b>x</b>0) <<b>NFFT</b>5*NFFT* <b>y</b>10*N<b>NFFT</b>15y</b>10*NFFT* or len(*y*) < *NFFT*, they will be zero
     * padded to <b>NFFT</b>0.
     * <p>
     * <em>Notes:</em><br>
     * For plotting, the power is plotted as
     * :math:`10 \log_{10}(P_{xy})` for decibels, though :math:`P_{xy}` itself
     * is returned.
     * 
     * @param x 1-D arrays or sequences<br>
     *          Arrays or sequences containing the data.
     *          
     * @param y 1-D arrays or sequences<br>
     *          Arrays or sequences containing the data.
     *          
     * @param Fs float, default: 2<br>
     *           The sampling frequency (samples per time unit).  It is used to calculate
     *           the Fourier frequencies, <b>freqs</b>0, in cycles per time unit.
     *           
     * @param window callable or ndarray, default: `.window_hanning`<br>
     *               A function or a vector of length <b>NFFT</b>0.  To create window vectors see
     *               `.window_hanning`, `.window_none`, `numpy.blackman`, `numpy.hamming`,
     *               `numpy.bartlett`, `scipy.signal`, `scipy.signal.get_window`, etc.  If a
     *               function is passed as the argument, it must take a data segment as an
     *               argument and return the windowed version of the segment.
     *               
     * @param sides &#123;'default', 'onesided', 'twosided'&#125;, optional<br>
     *              Which sides of the spectrum to return. 'default' is one-sided for real
     *              data and two-sided for complex data. 'onesided' forces the return of a
     *              one-sided spectrum, while 'twosided' forces two-sided.
     *              
     * @param pad_to int, optional<br>
     *               The number of points to which the data segment is padded when performing
     *               the FFT.  This can be different from <b>NFFT</b>0, which specifies the number
     *               of data points used.  While not increasing the actual resolution of the
     *               spectrum (the minimum distance between resolvable peaks), this can give
     *               more points in the plot, allowing for more detail. This corresponds to
     *               the<b>n</b>5he *n* parameter in the call to fft(). The default is None, which sets
     *        <b>pad_to</b>10        <b>NFFT</b>150         *pad_to* equal to *NFFT*
     *               
     * @param NFFT int, default: 256<br>
     *             The number of data points used in each block for the FFT.  A power 2 is
     *             most efficient.  This should <b>NOT</b>0 be used to get zero padding, or the
     *             scaling of the result will be incorrect; use<b>pad_to</b>5ad_to* for this instead.
     *             
     * @param detrend &#123;'none', 'mean', 'linear'&#125; or callable, default: 'none'<br>
     *                The function applied to each segment before fft-ing, designed to remove
     *                the mean or linear trend.  Unlike in MATLAB, where the <b>detrend</b>0 parameter
     *                is a vector, in Matplotlib is it a function.  The :mod:`~matplotlib.mlab`
     *                module defines `.detrend_none`, `.detrend_mean`, and `.detrend_linear`,
     *                but you can use a custom function as well.  You can also use a string to
     *                choose one of the functions: 'none' calls `.detrend_none`. 'mean' calls
     *                `.detrend_mean`. 'linear' calls `.detrend_linear`.
     *                
     * @param scale_by_freq bool, default: True<br>
     *                      Whether the resulting density values should be scaled by the scaling
     *                      frequency, which gives density in units of Hz^-1.  This allows for
     *                      integration over the returned frequency values.  The default is True for
     *                      MATLAB compatibility.
     *                      
     * @param noverlap int, default: 0 (no overlap)<br>
     *                 The number of points of overlap between segments.
     *                 
     * @param Fc int, default: 0<br>
     *           The center frequency of <b>x</b>0, which offsets the x extents of the
     *           plot to reflect the frequency range used when a signal is acquired
     *           and then filtered and downsampled to baseband.
     *           
     * @param return_line bool, default: False<br>
     *                    Whether to include the line object plotted in the returned values.
     * @param **kwargs <br>
     *                 Keyword arguments control the `.Line2D` properties:
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: scalar or None
     *                 animated: bool
     *                 antialiased or aa: bool
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 color or c: color
     *                 contains: unknown
     *                 dash_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 dash_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 dashes: sequence of floats (on/off ink in points) or (None, None)
     *                 data: (2, N) array or two 1D arrays
     *                 drawstyle or ds: &#123;'default', 'steps', 'steps-pre', 'steps-mid', 'steps-post'&#125;, default: 'default'
     *                 figure: `.Figure`
     *                 fillstyle: &#123;'full', 'left', 'right', 'bottom', 'top', 'none'&#125;
     *                 gid: str
     *                 in_layout: bool
     *                 label: object
     *                 linestyle or ls: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *                 linewidth or lw: float
     *                 marker: marker style string, `~.path.Path` or `~.markers.MarkerStyle`
     *                 markeredgecolor or mec: color
     *                 markeredgewidth or mew: float
     *                 markerfacecolor or mfc: color
     *                 markerfacecoloralt or mfcalt: color
     *                 markersize or ms: float
     *                 markevery: None or int or (int, int) or slice or list[int] or float or (float, float) or list[bool]
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: float or callable[[Artist, Event], tuple[bool, dict]]
     *                 pickradius: float
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 solid_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 solid_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 transform: `matplotlib.transforms.Transform`
     *                 url: str
     *                 visible: bool
     *                 xdata: 1D array
     *                 ydata: 1D array
     *                 zorder: float
     * @param data n/a<br>undocumented
     * 
     * @return (Pxy,freqs,line) (1-D array,1-D array,`~matplotlib.lines.Line2D`)<br>
     *          The values for the cross spectrum :math:`P_&#123;xy&#125;` before scaling
     *          (complex valued).
     *          
     *          
     *          The frequencies corresponding to the elements in <b>Pxy</b>0.
     *          
     *          
     *          The line created by this function.
     *          Only returned if<b>return_line</b>5_line* is True.
     */
    public final Object csd(Object x, Object y, Object... args) {
        write("plt.csd("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(y)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Create a new `Cycler` object from a single positional argument,
     * a pair of positional arguments, or the combination of keyword arguments.
     * 
     * cycler(arg)
     * cycler(label1=itr1[, label2=iter2[, ...]])
     * cycler(label, itr)
     * 
     * Form 1 simply copies a given `Cycler` object.
     * 
     * Form 2 composes a `Cycler` as an inner product of the
     * pairs of keyword arguments. In other words, all of the
     * iterables are cycled simultaneously, as if through zip().
     * 
     * Form 3 creates a `Cycler` from a label and an iterable.
     * This is useful for when the label cannot be a keyword argument
     * (e.g., an integer or a name that has a space in it).
     * 
     * @param arg Cycler<br>
     *            Copy constructor for Cycler (does a shallow copy of iterables).
     *            
     * @param label name<br>
     *              The property key. In the 2-arg form of the function,
     *              the label can be any hashable object. In the keyword argument
     *              form of the function, it must be a valid python identifier.
     *              
     * @param itr iterable<br>
     *            Finite length iterable of the property values.
     *            Can be a single-property `Cycler` that would
     *            be like a key change, but as a shallow copy.
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     * 
     * @return cycler Cycler<br>
     *                New `Cycler` for the given property
     */
    public final Object cycler(Object... args) {
        write("plt.cycler("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Remove an `~.axes.Axes` (defaulting to the current axes) from its figure.
     * 
     * @param ax n/a<br>undocumented
     */
    public final Object delaxes(Object... args) {
        write("plt.delaxes("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Disconnect the callback with id <b>cid</b>0.
     * 
     * @param cid n/a<br>undocumented
     */
    public final Object disconnect(Object... args) {
        write("plt.disconnect("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Redraw the current figure.
     * 
     * This is used to update a figure that has been altered, but not
     * automatically re-drawn.  If interactive mode is on (via `.ion()`), this
     * should be only rarely needed, but there may be ways to modify the state of
     * a figure without marking it as "stale".  Please report these cases as bugs.
     * 
     * This is equivalent to calling ``fig.canvas.draw_idle()``, where ``fig`` is
     * the current figure.
     */
    public final Object draw() {
        write("plt.draw()");
        return null;
    }

    /**
     * # This function's signature is rewritten upon backend-load by switch_backend.
     */
    public final Object draw_if_interactive() {
        write("plt.draw_if_interactive()");
        return null;
    }

    /**
     * Plot y versus x as lines and/or markers with attached errorbars.
     * 
     * <b>x</b>0,<b>y</b>50, *y* define the data loca<b>xerr</b>10<b>yerr</b>15err</b>10locations, *xerr*, *yerr* define the errorbar
     * sizes. By default, this draws the data markers/lines as well the
     * errorbars. Use fmt='none' to draw errorbars without any data markers.
     * <p>
     * <em>Notes:</em><br>
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * the following arguments can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception):
     * <b>x</b>0,<b>y</b>50<b>xerr</b>10<b>yerr</b>15err</b>10b>50, *y*, *xerr*, *yerr*.
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param x float or array-like<br>
     *          The data positions.
     *          
     * @param y float or array-like<br>
     *          The data positions.
     *          
     * @param xerr float or array-like, shape(N,) or shape(2, N), optional<br>
     *             The errorbar sizes:
     *             
     *             - scalar: Symmetric +/- values for all data points.
     *             - shape(N,): Symmetric +/-values for each data point.
     *             - shape(2, N): Separate - and + values for each bar. First row
     *             contains the lower errors, the second row contains the upper
     *             errors.
     *             - <b>None</b>0: No errorbar.
     *             
     *             Note that all error arrays should have<b>positive</b>5itive* values.
     *             
     *             See :doc:`/gallery/statistics/errorbar_features`
     *             for an example on the usage of ``xerr`` and ``yerr``.
     *             
     * @param yerr float or array-like, shape(N,) or shape(2, N), optional<br>
     *             The errorbar sizes:
     *             
     *             - scalar: Symmetric +/- values for all data points.
     *             - shape(N,): Symmetric +/-values for each data point.
     *             - shape(2, N): Separate - and + values for each bar. First row
     *             contains the lower errors, the second row contains the upper
     *             errors.
     *             - <b>None</b>0: No errorbar.
     *             
     *             Note that all error arrays should have<b>positive</b>5itive* values.
     *             
     *             See :doc:`/gallery/statistics/errorbar_features`
     *             for an example on the usage of ``xerr`` and ``yerr``.
     *             
     * @param fmt str, default: ''<br>
     *            The format for the data points / data lines. See `.plot` for
     *            details.
     *            
     *            Use 'none' (case insensitive) to plot errorbars without any data
     *            markers.
     *            
     * @param ecolor color, default: None<br>
     *               The color of the errorbar lines.  If None, use the color of the
     *               line connecting the markers.
     *               
     * @param elinewidth float, default: None<br>
     *                   The linewidth of the errorbar lines. If None, the linewidth of
     *                   the current style is used.
     *                   
     * @param capsize float, default: :rc:`errorbar.capsize`<br>
     *                The length of the error bar caps in points.
     *                
     * @param capthick float, default: None<br>
     *                 An alias to the keyword argument <b>markeredgewidth</b>0 (a.k.a.<b>mew</b>5 *mew*).
     *                 This setting is a more sensible name for the property that
     *                 controls the thickness of the error bar cap in points. For
     *                 backwards compatibili<b>mew</b>10ib<b>markeredgewidth</b>15ity, if *mew* or *markeredgewidth* are given,
     *      <b>capthick</b>20   *                 then they will over-ride *capthick*. This may change in future
     *                 releases.
     *                 
     * @param barsabove bool, default: False<br>
     *                  If True, will plot the errorbars above the plot
     *                  symbols. Default is below.
     *                  
     * @param lolims bool, default: False<br>
     *               These arguments can be used to indicate that a value gives only
     *               upper/lower limits.  In that case a caret symbol is used to
     *               indicate this. <b>lims</b>0-arguments may be scalars, or array-likes of
     *               the same length as<b>xerr</b>5*xer<b>yerr</b>10*xerr* and *yerr*.  To use limits with inverted
     *               axes, `~.Axes.set_xlim` or `~.Axes.set_ylim` must be called before
     *               :meth:`errorbar`.  Note the tricky parameter names: setting e.g.
  <b>lolims</b>15e.g.
     *               *lolims* <b>lower</b>20    *lolims* to True means that the y-value is a *lower* <b>upward</b>25lue is a *lower* limit of the
     *               True value, so, only an *upward*-pointing arrow will be drawn!
     *               
     * @param uplims bool, default: False<br>
     *               These arguments can be used to indicate that a value gives only
     *               upper/lower limits.  In that case a caret symbol is used to
     *               indicate this. <b>lims</b>0-arguments may be scalars, or array-likes of
     *               the same length as<b>xerr</b>5*xer<b>yerr</b>10*xerr* and *yerr*.  To use limits with inverted
     *               axes, `~.Axes.set_xlim` or `~.Axes.set_ylim` must be called before
     *               :meth:`errorbar`.  Note the tricky parameter names: setting e.g.
  <b>lolims</b>15e.g.
     *               *lolims* <b>lower</b>20    *lolims* to True means that the y-value is a *lower* <b>upward</b>25lue is a *lower* limit of the
     *               True value, so, only an *upward*-pointing arrow will be drawn!
     *               
     * @param xlolims bool, default: False<br>
     *                These arguments can be used to indicate that a value gives only
     *                upper/lower limits.  In that case a caret symbol is used to
     *                indicate this. <b>lims</b>0-arguments may be scalars, or array-likes of
     *                the same length as<b>xerr</b>5*xer<b>yerr</b>10*xerr* and *yerr*.  To use limits with inverted
     *                axes, `~.Axes.set_xlim` or `~.Axes.set_ylim` must be called before
     *                :meth:`errorbar`.  Note the tricky parameter names: setting e.g.
   <b>lolims</b>15.g.
     *                *lolims* <b>lower</b>20    *lolims* to True means that the y-value is a *lower* l<b>upward</b>25ue is a *lower* limit of the
     *                True value, so, only an *upward*-pointing arrow will be drawn!
     *                
     * @param xuplims bool, default: False<br>
     *                These arguments can be used to indicate that a value gives only
     *                upper/lower limits.  In that case a caret symbol is used to
     *                indicate this. <b>lims</b>0-arguments may be scalars, or array-likes of
     *                the same length as<b>xerr</b>5*xer<b>yerr</b>10*xerr* and *yerr*.  To use limits with inverted
     *                axes, `~.Axes.set_xlim` or `~.Axes.set_ylim` must be called before
     *                :meth:`errorbar`.  Note the tricky parameter names: setting e.g.
   <b>lolims</b>15.g.
     *                *lolims* <b>lower</b>20    *lolims* to True means that the y-value is a *lower* l<b>upward</b>25ue is a *lower* limit of the
     *                True value, so, only an *upward*-pointing arrow will be drawn!
     *                
     * @param errorevery int or (int, int), default: 1<br>
     *                   draws error bars on a subset of the data. <b>errorevery</b>0 =N draws
     *                   error bars on the points (x[::N], y[::N]).
     *                  <b>errorevery</b>5every* =(start, N) draws error bars on the points
     *                   (x[start::N], y[start::N]). e.g. errorevery=(6, 3)
     *                   adds error bars to the data at (x[6], x[9], x[12], x[15], ...).
     *                   Used to avoid overlapping error bars when two series share x-axis
     *                   values.
     * @param **kwargs <br>
     *                 All other keyword arguments are passed on to the `~.Axes.plot` call
     *                 drawing the markers. For example, this code makes big red squares
     *                 with thick green edges::
     *                 
     *                 x, y, yerr = rand(3, 10)
     *                 errorbar(x, y, yerr, marker='s', mfc='red',
     *                 mec='green', ms=20, mew=4)
     *                 
     *                 where <b>mfc</b>0,<b>mec</b>5 <b>ms</b>10</b<b>mew</b>15s</b>10</b>5 *mec*, *ms* and *mew* are aliases for the longer
   <b>markerfacecolor</b>20<b>markeredgecolor</b>25<b>markersize</b>30keredgecolor</b>25or</b>20<b>markeredgewidth</b>35olor</b>25or</b>20     *                 property names, *markerfacecolor*, *markeredgecolor*, *markersize*
     *                 and *markeredgewidth*.
     *                 
     *                 Valid kwargs for the marker properties are `.Line2D` properties:
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: scalar or None
     *                 animated: bool
     *                 antialiased or aa: bool
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 color or c: color
     *                 contains: unknown
     *                 dash_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 dash_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 dashes: sequence of floats (on/off ink in points) or (None, None)
     *                 data: (2, N) array or two 1D arrays
     *                 drawstyle or ds: &#123;'default', 'steps', 'steps-pre', 'steps-mid', 'steps-post'&#125;, default: 'default'
     *                 figure: `.Figure`
     *                 fillstyle: &#123;'full', 'left', 'right', 'bottom', 'top', 'none'&#125;
     *                 gid: str
     *                 in_layout: bool
     *                 label: object
     *                 linestyle or ls: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *                 linewidth or lw: float
     *                 marker: marker style string, `~.path.Path` or `~.markers.MarkerStyle`
     *                 markeredgecolor or mec: color
     *                 markeredgewidth or mew: float
     *                 markerfacecolor or mfc: color
     *                 markerfacecoloralt or mfcalt: color
     *                 markersize or ms: float
     *                 markevery: None or int or (int, int) or slice or list[int] or float or (float, float) or list[bool]
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: float or callable[[Artist, Event], tuple[bool, dict]]
     *                 pickradius: float
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 solid_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 solid_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 transform: `matplotlib.transforms.Transform`
     *                 url: str
     *                 visible: bool
     *                 xdata: 1D array
     *                 ydata: 1D array
     *                 zorder: float
     * @param data n/a<br>undocumented
     * 
     * @return `.ErrorbarContainer` <br>
     *                              The container contains:
     *                              
     *                              - plotline: `.Line2D` instance of x, y plot markers and/or line.
     *                              - caplines: A tuple of `.Line2D` instances of the error bar caps.
     *                              - barlinecols: A tuple of `.LineCollection` with the horizontal and
     *                              vertical error ranges.
     */
    public final Object errorbar(Object x, Object y, Object... args) {
        write("plt.errorbar("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(y)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Plot identical parallel lines at the given positions.
     * 
     * This type of plot is commonly used in neuroscience for representing
     * neural events, where it is usually called a spike raster, dot raster,
     * or raster plot.
     * 
     * However, it is useful in any situation where you wish to show the
     * timing or position of multiple sets of discrete events, such as the
     * arrival times of people to a business on each day of the month or the
     * date of hurricanes each year of the last century.
     * <p>
     * <em>Notes:</em><br>
     * For <b>linelengths</b>0,<b>linewidths</b>5i<b>colors</b>105idt<b>linestyles</b>15idths*, *colors*, and *linestyles*, if only
     * a single value is given, that value is applied to all lines.  If an
     * array-like is given, it must have the same length as <b>positions</b>0, and
     * each value will be applied to the corresponding row of the array.
     * 
     * @param positions array-like or list of array-like<br>
     *                  A 1D array-like defines the positions of one sequence of events.
     *                  
     *                  Multiple groups of events may be passed as a list of array-likes.
     *                  Each group can be styled independently by passing lists of values
     *                  to <b>lineoffsets</b>0,<b>linelengths</b>5n<b>linewidths</b>10<b>colors</b>15s</b>10hs*, *linewidths*, *<b>linestyles</b>20dths*, *colors* and
     *                  *linestyles*.
 <b>positions</b>25linestyles*.
     *                  
     *                  Note that *positions* can be a 2D array, but in practice different
     *                  event groups usually have different counts so that one will use a
     *                  list of different-length arrays rather than a 2D array.
     *                  
     * @param orientation &#123;'horizontal', 'vertical'&#125;, default: 'horizontal'<br>
     *                    The direction of the event sequence:
     *                    
     *                    - 'horizontal': the events are arranged horizontally.
     *                    The indicator lines are vertical.
     *                    - 'vertical': the events are arranged vertically.
     *                    The indicator lines are horizontal.
     *                    
     * @param lineoffsets float or array-like, default: 1<br>
     *                    The offset of the center of the lines from the origin, in the
     *                    direction orthogonal to <b>orientation</b>0.
     *                    
     *                    If<b>positions</b>5tions* is 2D, this can be a sequence with length matching
     *                    the len<b>positions</b>10th of *positions*.
     *                    
     * @param linelengths float or array-like, default: 1<br>
     *                    The total height of the lines (i.e. the lines stretches from
     *                    ``lineoffset - linelength/2`` to ``lineoffset + linelength/2``).
     *                    
     *                    If <b>positions</b>0 is 2D, this can be a sequence with length matching
     *                    the length of<b>positions</b>5tions*.
     *                    
     * @param linewidths float or array-like, default: :rc:`lines.linewidth`<br>
     *                   The line width(s) of the event lines, in points.
     *                   
     *                   If <b>positions</b>0 is 2D, this can be a sequence with length matching
     *                   the length of<b>positions</b>5tions*.
     *                   
     * @param colors color or list of colors, default: :rc:`lines.color`<br>
     *               The color(s) of the event lines.
     *               
     *               If <b>positions</b>0 is 2D, this can be a sequence with length matching
     *               the length of<b>positions</b>5tions*.
     *               
     * @param linestyles str or tuple or list of such values, default: 'solid'<br>
     *                   Default is 'solid'. Valid strings are ['solid', 'dashed',
     *                   'dashdot', 'dotted', '-', '--', '-.', ':']. Dash tuples
     *                   should be of the form::
     *                   
     *                   (offset, onoffseq),
     *                   
     *                   where <b>onoffseq</b>0 is an even length tuple of on and off ink
     *                   in points.
     *                   
     *                   If<b>positions</b>5tions* is 2D, this can be a sequence with length matching
     *                   the len<b>positions</b>10th of *positions*.
     *                   
     * @param **kwargs <br>
     *                 Other keyword arguments are line collection properties.  See
     *                 `.LineCollection` for a list of the valid properties.
     * @param data n/a<br>undocumented
     * 
     * @return list of `.EventCollection` <br>
     *                                    The `.EventCollection` that were added.
     */
    public final Object eventplot(Object positions, Object... args) {
        write("plt.eventplot("+PythonGrammar.toPythonArgs(positions)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Calculate the width and height for a figure with a specified aspect ratio.
     * 
     * While the height is taken from :rc:`figure.figsize`, the width is
     * adjusted to match the desired aspect ratio. Additionally, it is ensured
     * that the width is in the range [4., 16.] and the height is in the range
     * [2., 16.]. If necessary, the default height is adjusted to ensure this.
     * <p>
     * <em>Notes:</em><br>
     * If you want to create an Axes within the figure, that still preserves the
     * aspect ratio, be sure to create it with equal width and height. See
     * examples below.
     * 
     * Thanks to Fernando Perez for this function.
     * 
     * @param arg float or 2D array<br>
     *            If a float, this defines the aspect ratio (i.e. the ratio height /
     *            width).
     *            In case of an array the aspect ratio is number of rows / number of
     *            columns, so that the array could be fitted in the figure undistorted.
     * 
     * @return (width,height) (float,float)<br>
     *          The figure size in inches.
     *          
     *          The figure size in inches.
     */
    public final Object figaspect(Object arg) {
        write("plt.figaspect("+PythonGrammar.toPythonArgs(arg)+")");
        return null;
    }

    /**
     * Add a non-resampled image to the figure.
     * 
     * The image is attached to the lower or upper left corner depending on
     * <b>origin</b>0.
     * <p>
     * <em>Notes:</em><br>
     * figimage complements the Axes image (`~matplotlib.axes.Axes.imshow`)
     * which will be resampled to fit the current Axes.  If you want
     * a resampled image to fill the entire figure, you can define an
     * `~matplotlib.axes.Axes` with extent [0, 0, 1, 1].
     * 
     * @param X <br>
     *          The image data. This is an array of one of the following shapes:
     *          
     *          - MxN: luminance (grayscale) values
     *          - MxNx3: RGB values
     *          - MxNx4: RGBA values
     *          
     * @param xo int<br>
     *           The <b>x</b>0<b>y</b>5>0/*y* image offset in pixels.
     *           
     * @param yo int<br>
     *           The <b>x</b>0<b>y</b>5>0/*y* image offset in pixels.
     *           
     * @param alpha None or float<br>
     *              The alpha blending value.
     *              
     * @param norm `matplotlib.colors.Normalize`<br>
     *             A `.Normalize` instance to map the luminance to the
     *             interval [0, 1].
     *             
     * @param cmap str or `matplotlib.colors.Colormap`, default: :rc:`image.cmap`<br>
     *             The colormap to use.
     *             
     * @param vmin float<br>
     *             If <b>norm</b>0 is not given, these values set the data limits for the
     *             colormap.
     *             
     * @param vmax float<br>
     *             If <b>norm</b>0 is not given, these values set the data limits for the
     *             colormap.
     *             
     * @param origin &#123;'upper', 'lower'&#125;, default: :rc:`image.origin`<br>
     *               Indicates where the [0, 0] index of the array is in the upper left
     *               or lower left corner of the axes.
     *               
     * @param resize bool<br>
     *               If <b>True</b>0, resize the figure to match the given image size.
     * @param **kwargs <br>
     *                 Additional kwargs are `.Artist` kwargs passed on to `.FigureImage`.
     * 
     * @return `matplotlib.image.FigureImage` <br>
     */
    public final Object figimage(Object X, Object... args) {
        write("plt.figimage("+PythonGrammar.toPythonArgs(X)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Place a legend on the figure.
     * 
     * Call signatures::
     * 
     * figlegend()
     * figlegend(labels)
     * figlegend(handles, labels)
     * 
     * The call signatures correspond to these three different ways to use
     * this method:
     * 
     * **1. Automatic detection of elements to be shown in the legend**
     * 
     * The elements to be added to the legend are automatically determined,
     * when you do not pass in any extra arguments.
     * 
     * In this case, the labels are taken from the artist. You can specify
     * them either at artist creation or by calling the
     * :meth:`~.Artist.set_label` method on the artist::
     * 
     * ax.plot([1, 2, 3], label='Inline label')
     * fig.figlegend()
     * 
     * or::
     * 
     * line, = ax.plot([1, 2, 3])
     * line.set_label('Label via method')
     * fig.figlegend()
     * 
     * Specific lines can be excluded from the automatic legend element
     * selection by defining a label starting with an underscore.
     * This is default for all artists, so calling `.Figure.legend` without
     * any arguments and without setting the labels manually will result in
     * no legend being drawn.
     * 
     * 
     * **2. Labeling existing plot elements**
     * 
     * To make a legend for all artists on all Axes, call this function with
     * an iterable of strings, one for each legend item. For example::
     * 
     * fig, (ax1, ax2)  = plt.subplots(1, 2)
     * ax1.plot([1, 3, 5], color='blue')
     * ax2.plot([2, 4, 6], color='red')
     * fig.figlegend(['the blues', 'the reds'])
     * 
     * Note: This call signature is discouraged, because the relation between
     * plot elements and labels is only implicit by their order and can
     * easily be mixed up.
     * 
     * 
     * **3. Explicitly defining the elements in the legend**
     * 
     * For full control of which artists have a legend entry, it is possible
     * to pass an iterable of legend artists followed by an iterable of
     * legend labels respectively::
     * 
     * fig.figlegend([line1, line2, line3], ['label1', 'label2', 'label3'])
     * <p>
     * <em>Notes:</em><br>
     * Some artists are not supported by this function.  See
     * :doc:`/tutorials/intermediate/legend_guide` for details.
     * 
     * @param handles list of `.Artist`, optional<br>
     *                A list of Artists (lines, patches) to be added to the legend.
     *                Use this together with <b>labels</b>0, if you need full control on what
     *                is shown in the legend and the automatic mechanism described above
     *                is not sufficient.
     *                
     *                The length of handles and labels should be the same in this
     *                case. If they are not, they are truncated to the smaller length.
     *                
     * @param labels list of str, optional<br>
     *               A list of labels to show next to the artists.
     *               Use this together with <b>handles</b>0, if you need full control on what
     *               is shown in the legend and the automatic mechanism described above
     *               is not sufficient.
     * @param loc str or pair of floats, default: :rc:`legend.loc` ('best' for axes, 'upper right' for figures)<br>
     *            The location of the legend.
     *            
     *            The strings
     *            ``'upper left', 'upper right', 'lower left', 'lower right'``
     *            place the legend at the corresponding corner of the axes/figure.
     *            
     *            The strings
     *            ``'upper center', 'lower center', 'center left', 'center right'``
     *            place the legend at the center of the corresponding edge of the
     *            axes/figure.
     *            
     *            The string ``'center'`` places the legend at the center of the axes/figure.
     *            
     *            The string ``'best'`` places the legend at the location, among the nine
     *            locations defined so far, with the minimum overlap with other drawn
     *            artists.  This option can be quite slow for plots with large amounts of
     *            data; your plotting speed may benefit from providing a specific location.
     *            
     *            The location can also be a 2-tuple giving the coordinates of the lower-left
     *            corner of the legend in axes coordinates (in which case <b>bbox_to_anchor</b>0
     *            will be ignored).
     *            
     *            For back-compatibility, ``'center right'`` (but no other location) can also
     *            be spelled ``'right'``, and each "string" locations can also be given as a
     *            numeric value:
     *            
     *            ===============   =============
     *            Location String   Location Code
     *            ===============   =============
     *            'best'            0
     *            'upper right'     1
     *            'upper left'      2
     *            'lower left'      3
     *            'lower right'     4
     *            'right'           5
     *            'center left'     6
     *            'center right'    7
     *            'lower center'    8
     *            'upper center'    9
     *            'center'          10
     *            ===============   =============
     *            
     * @param bbox_to_anchor `.BboxBase`, 2-tuple, or 4-tuple of floats<br>
     *                       Box that is used to position the legend in conjunction with <b>loc</b>0.
     *                       Defaults to `axes.bbox` (if called as a method to `.Axes.legend`) or
     *                       `figure.bbox` (if `.Figure.legend`).  This argument allows arbitrary
     *                       placement of the legend.
     *                       
     *                       Bbox coordinates are interpreted in the coordinate system given by
     *                      <b>bbox_transform</b>5sform*, with the default transform
     *                       Axes or Figure coordinates, depending on which ``legend`` is called.
     *                       
     *                       If a 4-tuple or `.BboxBase` is given, then it specifies the bbox
     *                       ``(x, y, width, height)`` that the legend is placed in.
     *                       To put the legend in the best location in the bottom right
     *                       quadrant of the axes (or figure)::
     *                       
     *                       loc='best', bbox_to_anchor=(0.5, 0., 0.5, 0.5)
     *                       
     *                       A 2-tuple ``(x, y)`` places the corner of the legend specif<b>loc</b>10pecified by *loc* at
     *                       x, y.  For example, to put the legend's upper right-hand corner in the
     *                       center of the axes (or figure) the following keywords can be used::
     *                       
     *                       loc='upper right', bbox_to_anchor=(0.5, 0.5)
     *                       
     * @param ncol int, default: 1<br>
     *             The number of columns that the legend has.
     *             
     * @param prop None or `matplotlib.font_manager.FontProperties` or dict<br>
     *             The font properties of the legend. If None (default), the current
     *             :data:`matplotlib.rcParams` will be used.
     *             
     * @param fontsize int or &#123;'xx-small', 'x-small', 'small', 'medium', 'large', 'x-large', 'xx-large'&#125;<br>
     *                 The font size of the legend. If the value is numeric the size will be the
     *                 absolute font size in points. String values are relative to the current
     *                 default font size. This argument is only used if <b>prop</b>0 is not specified.
     *                 
     * @param labelcolor str or list<br>
     *                   The color of the text in the legend. Either a valid color string
     *                   (for example, 'red'), or a list of color strings. The labelcolor can
     *                   also be made to match the color of the line or marker using 'linecolor',
     *                   'markerfacecolor' (or 'mfc'), or 'markeredgecolor' (or 'mec').
     *                   
     * @param numpoints int, default: :rc:`legend.numpoints`<br>
     *                  The number of marker points in the legend when creating a legend
     *                  entry for a `.Line2D` (line).
     *                  
     * @param scatterpoints int, default: :rc:`legend.scatterpoints`<br>
     *                      The number of marker points in the legend when creating
     *                      a legend entry for a `.PathCollection` (scatter plot).
     *                      
     * @param scatteryoffsets iterable of floats, default: ``[0.375, 0.5, 0.3125]``<br>
     *                        The vertical offset (relative to the font size) for the markers
     *                        created for a scatter plot legend entry. 0.0 is at the base the
     *                        legend text, and 1.0 is at the top. To draw all markers at the
     *                        same height, set to ``[0.5]``.
     *                        
     * @param markerscale float, default: :rc:`legend.markerscale`<br>
     *                    The relative size of legend markers compared with the originally
     *                    drawn ones.
     *                    
     * @param markerfirst bool, default: True<br>
     *                    If <b>True</b>0, legend marker is placed to the left of the legend label.
     *                    If<b>False</b>5False*, legend marker is placed to the right of the legend label.
     *                    
     * @param frameon bool, default: :rc:`legend.frameon`<br>
     *                Whether the legend should be drawn on a patch (frame).
     *                
     * @param fancybox bool, default: :rc:`legend.fancybox`<br>
     *                 Whether round edges should be enabled around the `~.FancyBboxPatch` which
     *                 makes up the legend's background.
     *                 
     * @param shadow bool, default: :rc:`legend.shadow`<br>
     *               Whether to draw a shadow behind the legend.
     *               
     * @param framealpha float, default: :rc:`legend.framealpha`<br>
     *                   The alpha transparency of the legend's background.
     *                   If <b>shadow</b>0 is activated and<b>framealpha</b>5alpha* is ``None``, the default value is
     *                   ignored.
     *                   
     * @param facecolor "inherit" or color, default: :rc:`legend.facecolor`<br>
     *                  The legend's background color.
     *                  If ``"inherit"``, use :rc:`axes.facecolor`.
     *                  
     * @param edgecolor "inherit" or color, default: :rc:`legend.edgecolor`<br>
     *                  The legend's background patch edge color.
     *                  If ``"inherit"``, use take :rc:`axes.edgecolor`.
     *                  
     * @param mode &#123;"expand", None&#125;<br>
     *             If <b>mode</b>0 is set to ``"expand"`` the legend will be horizontally
     *             expanded to fill the axes area (or<b>bbox_to_anchor</b>5nchor* if defines
     *             the legend's size).
     *             
     * @param bbox_transform None or `matplotlib.transforms.Transform`<br>
     *                       The transform for the bounding box (<b>bbox_to_anchor</b>0). For a value
     *                       of ``None`` (default) the Axes'
     *                       :data:`~matplotlib.axes.Axes.transAxes` transform will be used.
     *                       
     * @param title str or None<br>
     *              The legend's title. Default is no title (``None``).
     *              
     * @param title_fontsize int or &#123;'xx-small', 'x-small', 'small', 'medium', 'large', 'x-large', 'xx-large'&#125;, default: :rc:`legend.title_fontsize`<br>
     *                       The font size of the legend's title.
     *                       
     * @param borderpad float, default: :rc:`legend.borderpad`<br>
     *                  The fractional whitespace inside the legend border, in font-size units.
     *                  
     * @param labelspacing float, default: :rc:`legend.labelspacing`<br>
     *                     The vertical space between the legend entries, in font-size units.
     *                     
     * @param handlelength float, default: :rc:`legend.handlelength`<br>
     *                     The length of the legend handles, in font-size units.
     *                     
     * @param handletextpad float, default: :rc:`legend.handletextpad`<br>
     *                      The pad between the legend handle and text, in font-size units.
     *                      
     * @param borderaxespad float, default: :rc:`legend.borderaxespad`<br>
     *                      The pad between the axes and legend border, in font-size units.
     *                      
     * @param columnspacing float, default: :rc:`legend.columnspacing`<br>
     *                      The spacing between columns, in font-size units.
     *                      
     * @param handler_map dict or None<br>
     *                    The custom dictionary mapping instances or types to a legend
     *                    handler. This <b>handler_map</b>0 updates the default handler map
     *                    found at `matplotlib.legend.Legend.get_legend_handler_map`.
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     * 
     * @return `~matplotlib.legend.Legend` <br>
     */
    public final Object figlegend(Object... args) {
        write("plt.figlegend("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return whether the figure with the given id exists.
     * 
     * @param num n/a<br>undocumented
     */
    public final Object fignum_exists(Object... args) {
        write("plt.fignum_exists("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Add text to figure.
     * 
     * @param x float<br>
     *          The position to place the text. By default, this is in figure
     *          coordinates, floats in [0, 1]. The coordinate system can be changed
     *          using the <b>transform</b>0 keyword.
     *          
     * @param y float<br>
     *          The position to place the text. By default, this is in figure
     *          coordinates, floats in [0, 1]. The coordinate system can be changed
     *          using the <b>transform</b>0 keyword.
     *          
     * @param s str<br>
     *          The text string.
     *          
     * @param fontdict dict, optional<br>
     *                 A dictionary to override the default text properties. If not given,
     *                 the defaults are determined by :rc:`font.*`. Properties passed as
     *                 <b>kwargs</b>0 override the corresponding ones given in<b>fontdict</b>5tdict*.
     * @param **kwargs `~matplotlib.text.Text` properties<br>
     *                 Other miscellaneous text parameters.
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: scalar or None
     *                 animated: bool
     *                 backgroundcolor: color
     *                 bbox: dict with properties for `.patches.FancyBboxPatch`
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 color or c: color
     *                 contains: unknown
     *                 figure: `.Figure`
     *                 fontfamily or family: &#123;FONTNAME, 'serif', 'sans-serif', 'cursive', 'fantasy', 'monospace'&#125;
     *                 fontproperties or font or font_properties: `.font_manager.FontProperties` or `str` or `pathlib.Path`
     *                 fontsize or size: float or &#123;'xx-small', 'x-small', 'small', 'medium', 'large', 'x-large', 'xx-large'&#125;
     *                 fontstretch or stretch: &#123;a numeric value in range 0-1000, 'ultra-condensed', 'extra-condensed', 'condensed', 'semi-condensed', 'normal', 'semi-expanded', 'expanded', 'extra-expanded', 'ultra-expanded'&#125;
     *                 fontstyle or style: &#123;'normal', 'italic', 'oblique'&#125;
     *                 fontvariant or variant: &#123;'normal', 'small-caps'&#125;
     *                 fontweight or weight: &#123;a numeric value in range 0-1000, 'ultralight', 'light', 'normal', 'regular', 'book', 'medium', 'roman', 'semibold', 'demibold', 'demi', 'bold', 'heavy', 'extra bold', 'black'&#125;
     *                 gid: str
     *                 horizontalalignment or ha: &#123;'center', 'right', 'left'&#125;
     *                 in_layout: bool
     *                 label: object
     *                 linespacing: float (multiple of font size)
     *                 math_fontfamily: str
     *                 multialignment or ma: &#123;'left', 'right', 'center'&#125;
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: None or bool or float or callable
     *                 position: (float, float)
     *                 rasterized: bool
     *                 rotation: float or &#123;'vertical', 'horizontal'&#125;
     *                 rotation_mode: &#123;None, 'default', 'anchor'&#125;
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 text: object
     *                 transform: `.Transform`
     *                 transform_rotates_text: bool
     *                 url: str
     *                 usetex: bool or None
     *                 verticalalignment or va: &#123;'center', 'top', 'bottom', 'baseline', 'center_baseline'&#125;
     *                 visible: bool
     *                 wrap: bool
     *                 x: float
     *                 y: float
     *                 zorder: float
     * 
     * @return `~.text.Text` <br>
     */
    public final Object figtext(Object x, Object y, Object s, Object... args) {
        write("plt.figtext("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(y),PythonGrammar.toPythonArgs(s)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Create a new figure, or activate an existing figure.
     * <p>
     * <em>Notes:</em><br>
     * If you are creating many figures, make sure you explicitly call
     * `.pyplot.close` on the figures you are not using, because this will
     * enable pyplot to properly clean up the memory.
     * 
     * `~matplotlib.rcParams` defines the default values, which can be modified
     * in the matplotlibrc file.
     * 
     * @param num int or str or `.Figure`, optional<br>
     *            A unique identifier for the figure.
     *            
     *            If a figure with that identifier already exists, this figure is made
     *            active and returned. An integer refers to the ``Figure.number``
     *            attribute, a string refers to the figure label.
     *            
     *            If there is no figure with the identifier or <b>num</b>0 is not given, a new
     *            figure is created, made active and returned.  If<b>num</b>5 *num* is an int, it
     *            will be used for the ``Figure.number`` attribute, otherwise, an
     *            auto-generated integer value is used (starting at 1 and incremented
     *            for each new figur<b>num</b>10figure). If *num* is a string, the figure label and the
     *            window title is set to this value.
     *            
     * @param figsize (float, float), default: :rc:`figure.figsize`<br>
     *                Width, height in inches.
     *                
     * @param dpi float, default: :rc:`figure.dpi`<br>
     *            The resolution of the figure in dots-per-inch.
     *            
     * @param facecolor color, default: :rc:`figure.facecolor`<br>
     *                  The background color.
     *                  
     * @param edgecolor color, default: :rc:`figure.edgecolor`<br>
     *                  The border color.
     *                  
     * @param frameon bool, default: True<br>
     *                If False, suppress drawing the figure frame.
     *                
     * @param FigureClass subclass of `~matplotlib.figure.Figure`<br>
     *                    Optionally use a custom `.Figure` instance.
     *                    
     * @param clear bool, default: False<br>
     *              If True and the figure already exists, then it is cleared.
     *              
     * @param tight_layout bool or dict, default: :rc:`figure.autolayout`<br>
     *                     If ``False`` use <b>subplotpars</b>0. If ``True`` adjust subplot
     *                     parameters using `.tight_layout` with default padding.
     *                     When providing a dict containing the keys ``pad``, ``w_pad``,
     *                     ``h_pad``, and ``rect``, the default `.tight_layout` paddings
     *                     will be overridden.
     *                     
     * @param constrained_layout bool, default: :rc:`figure.constrained_layout.use`<br>
     *                           If ``True`` use constrained layout to adjust positioning of plot
     *                           elements.  Like ``tight_layout``, but designed to be more
     *                           flexible.  See
     *                           :doc:`/tutorials/intermediate/constrainedlayout_guide`
     *                           for examples.  (Note: does not work with `add_subplot` or
     *                           `~.pyplot.subplot2grid`.)
     *                           
     *                           
     * @param **kwargs  optional<br>
     *                 See `~.matplotlib.figure.Figure` for other possible arguments.
     * 
     * @return `~matplotlib.figure.Figure` <br>
     *                                     The `.Figure` instance returned will also be passed to
     *                                     new_figure_manager in the backends, which allows to hook custom
     *                                     `.Figure` classes into the pyplot interface. Additional kwargs will be
     *                                     passed to the `.Figure` init function.
     */
    public final Object figure(Object... args) {
        write("plt.figure("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Plot filled polygons.
     * <p>
     * <em>Notes:</em><br>
     * Use :meth:`fill_between` if you would like to fill the region between
     * two curves.
     * 
     * @param *args sequence of x, y, [color]<br>
     *              Each polygon is defined by the lists of <b>x</b>0 and<b>y</b>5nd *y* positions of
     *              its nodes, optionally followe<b>color</b>10owed by a *color* specifier. See
     *              :mod:`matplotlib.colors` for supported color specifiers. The
     *              standard color cycle is used for polygons without a color
     *              specifier.
     *              
     *              You can plot multiple polygons by <b>x</b>15<b>y</b>20ons by <b>x</b>15polygons by providing multiple *x*, *y*,
     *              *[color]* groups.
     *              
     *              For example, each of the following is legal::
     *              
     *              ax.fill(x, y)                    # a polygon with default color
     *              ax.fill(x, y, "b")               # a blue polygon
     *              ax.fill(x, y, x2, y2)            # two polygons
     *              ax.fill(x, y, "b", x2, y2, "r")  # a blue and a red polygon
     *              
     * @param data indexable object, optional<br>
     *             An object with labelled data. If given, provide the label names to
     *             plot in <b>x</b>0 and<b>y</b>5nd *y*, e.g.::
     *             
     *             ax.fill("time", "signal",
     *             data=&#123;"time": [0, 1, 2], "signal": [0, 1, 0]&#125;)
     * @param **kwargs `~matplotlib.patches.Polygon` properties<br>
     * 
     * @return list of `~matplotlib.patches.Polygon` <br>
     */
    public final Object fill(Object args, Object... args) {
        write("plt.fill("+PythonGrammar.toPythonArgs(args)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Fill the area between two horizontal curves.
     * 
     * The curves are defined by the points (<b>x</b>0,<b>y1</b>5, *y1*<b>x</b>105, *y1*) and (*x*,
     * <b>y2</b>0).  This creates one or multiple polygons describing the filled
     * area.
     * 
     * You may exclude some horizontal sections from filling using <b>where</b>0.
     * 
     * By default, the edges connect the given points directly.  Use <b>step</b>0
     * if the filling should be a step function, i.e. constant in between
     * <b>x</b>0.
     * <p>
     * <em>Notes:</em><br>
     * .. [notes section required to get data note injection right]
     * 
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * the following arguments can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception):
     * <b>x</b>0,<b>y1</b>5,<b>y2</b>10<b>where</b>15y2</b>10</b>5, *y1*, *y2*, *where*.
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param x array (length N)<br>
     *          The x coordinates of the nodes defining the curves.
     *          
     * @param y1 array (length N) or scalar<br>
     *           The y coordinates of the nodes defining the first curve.
     *           
     * @param y2 array (length N) or scalar, default: 0<br>
     *           The y coordinates of the nodes defining the second curve.
     *           
     * @param where array of bool (length N), optional<br>
     *              Define <b>where</b>0 to exclude some horizontal regions from being filled.
     *              The filled regions are defined by the coordinates ``x[where]``.
     *              More precisely, fill between ``x[i]`` and ``x[i+1]`` if
     *              ``where[i] and where[i+1]``.  Note that this definition implies
     *              that an isolated<b>True</b>5*True* value betwe<b>False</b>10tween two<b>where</b>15ween two *False* values in *where*
     *              will not re<b>True</b>20   will not result in filling.  Both sides of the *True* positio<b>False</b>25the *True* position
     *              remain unfilled due to the adjacent *False* values.
     *              
     * @param interpolate bool, default: False<br>
     *                    This option is only relevant if <b>where</b>0 is used and the two curves
     *                    are crossing each other.
     *                    
     *                    Semantically,<b>where</b>5where* is often us<b>y1</b>10ten <b>y2</b>151</b>10ten used for *y1* &gt; *y2* or
     *                    similar.  By default, the nodes of the polygon defining the filled
     *                    region will onl<b>x</b>20  region will only be placed at the positions in the *x* array.
     *                    Such a polygon cannot describe the above semantics close to the
     *                    intersection.  The x-sections containing the intersection are
     *                    simply clipped.
   <b>interpolate</b>25cl<b>True</b>30  <b>interpolate</b>25clipped.
     *                    
     *                    Setting *interpolate* to *True* will calculate the actual
     *                    intersection point and extend the filled region up to this point.
     *                    
     * @param step &#123;'pre', 'post', 'mid'&#125;, optional<br>
     *             Define <b>step</b>0 if the filling should be a step function,
     *             i.e. constant in between<b>x</b>5en *x*.  The value determines where the
     *             step will occur:
     *             
     *             - 'pre': The y value is continued constantly to the left from
     *            <b>x</b>10        every *x* position, i.e. the interval ``(x[i-1], x[i]]`` has the
     *             value ``y[i]``.
     *             - 'post': The y value is continued constantly to the right from
     *<b>x</b>15 from
     *             every *x* position, i.e. the interval ``[x[i], x[i+1])`` has the
     *             value ``y[i]``.
     *             - 'mid<b>x</b>20           - 'mid': Steps occur half-way between the *x* positions.
     * @param **kwargs <br>
     *                 All other keyword arguments are passed on to `.PolyCollection`.
     *                 They control the `.Polygon` properties:
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: array-like or scalar or None
     *                 animated: bool
     *                 antialiased or aa or antialiaseds: bool or list of bools
     *                 array: ndarray or None
     *                 capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 clim: (vmin: float, vmax: float)
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 cmap: `.Colormap` or str or None
     *                 color: color or list of rgba tuples
     *                 contains: unknown
     *                 edgecolor or ec or edgecolors: color or list of colors or 'face'
     *                 facecolor or facecolors or fc: color or list of colors
     *                 figure: `.Figure`
     *                 gid: str
     *                 hatch: &#123;'/', '\\', '|', '-', '+', 'x', 'o', 'O', '.', '*'&#125;
     *                 in_layout: bool
     *                 joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 label: object
     *                 linestyle or dashes or linestyles or ls: str or tuple or list thereof
     *                 linewidth or linewidths or lw: float or list of floats
     *                 norm: `.Normalize` or None
     *                 offset_position: unknown
     *                 offsets: (N, 2) or (2,) array-like
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: None or bool or float or callable
     *                 pickradius: float
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 transform: `.Transform`
     *                 url: str
     *                 urls: list of str or None
     *                 visible: bool
     *                 zorder: float
     * @param data n/a<br>undocumented
     * 
     * @return `.PolyCollection` <br>
     *                           A `.PolyCollection` containing the plotted polygons.
     */
    public final Object fill_between(Object x, Object y1, Object... args) {
        write("plt.fill_between("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(y1)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Fill the area between two vertical curves.
     * 
     * The curves are defined by the points (<b>y</b>0,<b>x1</b>5, *x1*<b>y</b>105, *x1*) and (*y*,
     * <b>x2</b>0).  This creates one or multiple polygons describing the filled
     * area.
     * 
     * You may exclude some vertical sections from filling using <b>where</b>0.
     * 
     * By default, the edges connect the given points directly.  Use <b>step</b>0
     * if the filling should be a step function, i.e. constant in between
     * <b>y</b>0.
     * <p>
     * <em>Notes:</em><br>
     * .. [notes section required to get data note injection right]
     * 
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * the following arguments can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception):
     * <b>y</b>0,<b>x1</b>5,<b>x2</b>10<b>where</b>15x2</b>10</b>5, *x1*, *x2*, *where*.
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param y array (length N)<br>
     *          The y coordinates of the nodes defining the curves.
     *          
     * @param x1 array (length N) or scalar<br>
     *           The x coordinates of the nodes defining the first curve.
     *           
     * @param x2 array (length N) or scalar, default: 0<br>
     *           The x coordinates of the nodes defining the second curve.
     *           
     * @param where array of bool (length N), optional<br>
     *              Define <b>where</b>0 to exclude some vertical regions from being filled.
     *              The filled regions are defined by the coordinates ``y[where]``.
     *              More precisely, fill between ``y[i]`` and ``y[i+1]`` if
     *              ``where[i] and where[i+1]``.  Note that this definition implies
     *              that an isolated<b>True</b>5*True* value betwe<b>False</b>10tween two<b>where</b>15ween two *False* values in *where*
     *              will not re<b>True</b>20   will not result in filling.  Both sides of the *True* positio<b>False</b>25the *True* position
     *              remain unfilled due to the adjacent *False* values.
     *              
     * @param interpolate bool, default: False<br>
     *                    This option is only relevant if <b>where</b>0 is used and the two curves
     *                    are crossing each other.
     *                    
     *                    Semantically,<b>where</b>5where* is often us<b>x1</b>10ten <b>x2</b>151</b>10ten used for *x1* &gt; *x2* or
     *                    similar.  By default, the nodes of the polygon defining the filled
     *                    region will onl<b>y</b>20  region will only be placed at the positions in the *y* array.
     *                    Such a polygon cannot describe the above semantics close to the
     *                    intersection.  The y-sections containing the intersection are
     *                    simply clipped.
   <b>interpolate</b>25cl<b>True</b>30  <b>interpolate</b>25clipped.
     *                    
     *                    Setting *interpolate* to *True* will calculate the actual
     *                    intersection point and extend the filled region up to this point.
     *                    
     * @param step &#123;'pre', 'post', 'mid'&#125;, optional<br>
     *             Define <b>step</b>0 if the filling should be a step function,
     *             i.e. constant in between<b>y</b>5en *y*.  The value determines where the
     *             step will occur:
     *             
     *             - 'pre': The y value is continued constantly to the left from
     *            <b>x</b>10        every *x* position, i.e. the interval ``(x[i-1], x[i]]`` has the
     *             value ``y[i]``.
     *             - 'post': The y value is continued constantly to the right from
     *<b>x</b>15 from
     *             every *x* position, i.e. the interval ``[x[i], x[i+1])`` has the
     *             value ``y[i]``.
     *             - 'mid<b>x</b>20           - 'mid': Steps occur half-way between the *x* positions.
     * @param **kwargs <br>
     *                 All other keyword arguments are passed on to `.PolyCollection`.
     *                 They control the `.Polygon` properties:
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: array-like or scalar or None
     *                 animated: bool
     *                 antialiased or aa or antialiaseds: bool or list of bools
     *                 array: ndarray or None
     *                 capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 clim: (vmin: float, vmax: float)
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 cmap: `.Colormap` or str or None
     *                 color: color or list of rgba tuples
     *                 contains: unknown
     *                 edgecolor or ec or edgecolors: color or list of colors or 'face'
     *                 facecolor or facecolors or fc: color or list of colors
     *                 figure: `.Figure`
     *                 gid: str
     *                 hatch: &#123;'/', '\\', '|', '-', '+', 'x', 'o', 'O', '.', '*'&#125;
     *                 in_layout: bool
     *                 joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 label: object
     *                 linestyle or dashes or linestyles or ls: str or tuple or list thereof
     *                 linewidth or linewidths or lw: float or list of floats
     *                 norm: `.Normalize` or None
     *                 offset_position: unknown
     *                 offsets: (N, 2) or (2,) array-like
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: None or bool or float or callable
     *                 pickradius: float
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 transform: `.Transform`
     *                 url: str
     *                 urls: list of str or None
     *                 visible: bool
     *                 zorder: float
     * @param data n/a<br>undocumented
     * 
     * @return `.PolyCollection` <br>
     *                           A `.PolyCollection` containing the plotted polygons.
     */
    public final Object fill_betweenx(Object y, Object x1, Object... args) {
        write("plt.fill_betweenx("+PythonGrammar.toPythonArgs(y),PythonGrammar.toPythonArgs(x1)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Find artist objects.
     * 
     * Recursively find all `.Artist` instances contained in the artist.
     * 
     * @param match <br>
     *              A filter criterion for the matches. This can be
     *              
     *              - <b>None</b>0: Return all objects contained in artist.
     *              - A function with signature ``def match(artist: Artist) -&gt; bool``.
     *              The result will only contain artists for which the function
     *              returns<b>True</b>5*True*.
     *              - A class instance: e.g., `.Line2D`. The result will only contain
     *              artists of this class or its subclasses (``isinstance`` check).
     *              
     * @param include_self bool<br>
     *                     Include <b>self</b>0 in the list to be checked for a match.
     * @param o n/a<br>undocumented
     * 
     * @return list of `.Artist` <br>
     */
    public final Object findobj(Object... args) {
        write("plt.findobj("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the colormap to 'flag'.
     * 
     * This changes the default colormap as well as the colormap of the current
     * image if there is one. See ``help(colormaps)`` for more information.
     */
    public final Object flag() {
        write("plt.flag()");
        return null;
    }

    /**
     * Get the current Axes, creating one if necessary.
     * 
     * The following kwargs are supported for ensuring the returned Axes
     * adheres to the given projection etc., and for Axes creation if
     * the active Axes does not exist:
     * 
     * Properties:
     * adjustable: {'box', 'datalim'}
     * agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     * alpha: scalar or None
     * anchor: 2-tuple of floats or {'C', 'SW', 'S', 'SE', ...}
     * animated: bool
     * aspect: {'auto'} or num
     * autoscale_on: bool
     * autoscalex_on: bool
     * autoscaley_on: bool
     * axes_locator: Callable[[Axes, Renderer], Bbox]
     * axisbelow: bool or 'line'
     * box_aspect: float or None
     * clip_box: `.Bbox`
     * clip_on: bool
     * clip_path: Patch or (Path, Transform) or None
     * contains: unknown
     * facecolor or fc: color
     * figure: `.Figure`
     * frame_on: bool
     * gid: str
     * in_layout: bool
     * label: object
     * navigate: bool
     * navigate_mode: unknown
     * path_effects: `.AbstractPathEffect`
     * picker: None or bool or float or callable
     * position: [left, bottom, width, height] or `~matplotlib.transforms.Bbox`
     * prop_cycle: unknown
     * rasterization_zorder: float or None
     * rasterized: bool
     * sketch_params: (scale: float, length: float, randomness: float)
     * snap: bool or None
     * title: str
     * transform: `.Transform`
     * url: str
     * visible: bool
     * xbound: unknown
     * xlabel: str
     * xlim: (bottom: float, top: float)
     * xmargin: float greater than -0.5
     * xscale: {"linear", "log", "symlog", "logit", ...} or `.ScaleBase`
     * xticklabels: unknown
     * xticks: unknown
     * ybound: unknown
     * ylabel: str
     * ylim: (bottom: float, top: float)
     * ymargin: float greater than -0.5
     * yscale: {"linear", "log", "symlog", "logit", ...} or `.ScaleBase`
     * yticklabels: unknown
     * yticks: unknown
     * zorder: float
     * 
     * @param **kwargs n/a<br>undocumented
     */
    public final Object gca(Object... args) {
        write("plt.gca("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Get the current figure.
     * 
     * If no current figure exists, a new one is created using
     * `~.pyplot.figure()`.
     */
    public final Object gcf() {
        write("plt.gcf()");
        return null;
    }

    /**
     * Get the current colorable artist.
     * 
     * Specifically, returns the current `.ScalarMappable` instance (`.Image`
     * created by `imshow` or `figimage`, `.Collection` created by `pcolor` or
     * `scatter`, etc.), or <b>None</b>0 if no such instance has been defined.
     * 
     * The current image is an attribute of the current Axes, or the nearest
     * earlier Axes in the current figure that contains an image.
     * <p>
     * <em>Notes:</em><br>
     * Historically, the only colorable artists were images; hence the name
     * ``gci`` (get current image).
     */
    public final Object gci() {
        write("plt.gci()");
        return null;
    }

    /**
     * Return the value of an `.Artist`'s <b>property</b>0, or print all of them.
     * 
     * @param obj `.Artist`<br>
     *            The queried artist; e.g., a `.Line2D`, a `.Text`, or an `~.axes.Axes`.
     *            
     * @param property str or None, default: None<br>
     *                 If <b>property</b>0 is 'somename', this function returns
     *                 ``obj.get_somename()``.
     *                 
     *                 If is is None (or unset), it<b>prints</b>5rints* all gettable properties from
     *          <b>obj</b>10            *obj*.  Many properties have aliases for shorter typing, e.g. 'lw' is
     *                 an alias for 'linewidth'.  In the output, aliases and full property
     *                 names will be listed as:
     *                 
     *                 property or alias = value
     *                 
     *                 e.g.:
     *                 
     *                 linewidth or lw = 2
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     */
    public final Object get(Object obj, Object... args) {
        write("plt.get("+PythonGrammar.toPythonArgs(obj)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the name of the current backend.
     */
    public final Object get_backend() {
        write("plt.get_backend()");
        return null;
    }

    /**
     * Get a colormap instance, defaulting to rc values if <b>name</b>0 is None.
     * 
     * Colormaps added with :func:`register_cmap` take precedence over
     * built-in colormaps.
     * <p>
     * <em>Notes:</em><br>
     * Currently, this returns the global colormap object, which is deprecated.
     * In Matplotlib 3.5, you will no longer be able to modify the global
     * colormaps in-place.
     * 
     * @param name `matplotlib.colors.Colormap` or str or None, default: None<br>
     *             If a `.Colormap` instance, it will be returned. Otherwise, the name of
     *             a colormap known to Matplotlib, which will be resampled by <b>lut</b>0. The
     *             default, None, means :rc:`image.cmap`.
     * @param lut int or None, default: None<br>
     *            If <b>name</b>0 is not already a Colormap instance and<b>lut</b>5 *lut* is not None, the
     *            colormap will be resampled t<b>lut</b>10led to have *lut* entries in the lookup table.
     */
    public final Object get_cmap(Object... args) {
        write("plt.get_cmap("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return the figure manager of the current figure.
     * 
     * The figure manager is a container for the actual backend-depended window
     * that displays the figure on screen.
     * 
     * If no current figure exists, a new one is created, and its figure
     * manager is returned.
     * 
     * @return `.FigureManagerBase` or backend-dependent subclass thereof <br>
     */
    public final Object get_current_fig_manager() {
        write("plt.get_current_fig_manager()");
        return null;
    }

    /**
     * Return a list of existing figure labels.
     */
    public final Object get_figlabels() {
        write("plt.get_figlabels()");
        return null;
    }

    /**
     * Return a list of existing figure numbers.
     */
    public final Object get_fignums() {
        write("plt.get_fignums()");
        return null;
    }

    /**
     * Get a sorted list of all of the plotting commands.
     */
    public final Object get_plot_commands() {
        write("plt.get_plot_commands()");
        return null;
    }

    /**
     * Return the names of the available scales.
     */
    public final Object get_scale_names() {
        write("plt.get_scale_names()");
        return null;
    }

    /**
     * Return the value of an `.Artist`'s <b>property</b>0, or print all of them.
     * 
     * @param obj `.Artist`<br>
     *            The queried artist; e.g., a `.Line2D`, a `.Text`, or an `~.axes.Axes`.
     *            
     * @param property str or None, default: None<br>
     *                 If <b>property</b>0 is 'somename', this function returns
     *                 ``obj.get_somename()``.
     *                 
     *                 If is is None (or unset), it<b>prints</b>5rints* all gettable properties from
     *          <b>obj</b>10            *obj*.  Many properties have aliases for shorter typing, e.g. 'lw' is
     *                 an alias for 'linewidth'.  In the output, aliases and full property
     *                 names will be listed as:
     *                 
     *                 property or alias = value
     *                 
     *                 e.g.:
     *                 
     *                 linewidth or lw = 2
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     */
    public final Object getp(Object obj, Object... args) {
        write("plt.getp("+PythonGrammar.toPythonArgs(obj)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Blocking call to interact with a figure.
     * 
     * Wait until the user clicks <b>n</b>0 times on the figure, and return the
     * coordinates of each click in a list.
     * 
     * There are three possible interactions:
     * 
     * - Add a point.
     * - Remove the most recently added point.
     * - Stop the interaction and return the points added so far.
     * 
     * The actions are assigned to mouse buttons via the arguments
     * <b>mouse_add</b>0,<b>mouse_pop</b>5e_po<b>mouse_stop</b>10 and *mouse_stop*.
     * <p>
     * <em>Notes:</em><br>
     * The keyboard can also be used to select points in case your mouse
     * does not have one or more of the buttons.  The delete and backspace
     * keys act like right clicking (i.e., remove last point), the enter key
     * terminates input and any other key (not already used by the window
     * manager) selects a point.
     * 
     * @param n int, default: 1<br>
     *          Number of mouse clicks to accumulate. If negative, accumulate
     *          clicks until the input is terminated manually.
     * @param timeout float, default: 30 seconds<br>
     *                Number of seconds to wait before timing out. If zero or negative
     *                will never timeout.
     * @param show_clicks bool, default: True<br>
     *                    If True, show a red cross at the location of each click.
     * @param mouse_add `.MouseButton` or None, default: `.MouseButton.LEFT`<br>
     *                  Mouse button used to add points.
     * @param mouse_pop `.MouseButton` or None, default: `.MouseButton.RIGHT`<br>
     *                  Mouse button used to remove the most recently added point.
     * @param mouse_stop `.MouseButton` or None, default: `.MouseButton.MIDDLE`<br>
     *                   Mouse button used to stop input.
     * 
     * @return list of tuples <br>
     *                        A list of the clicked (x, y) coordinates.
     */
    public final Object ginput(Object... args) {
        write("plt.ginput("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the colormap to 'gray'.
     * 
     * This changes the default colormap as well as the colormap of the current
     * image if there is one. See ``help(colormaps)`` for more information.
     */
    public final Object gray() {
        write("plt.gray()");
        return null;
    }

    /**
     * Configure the grid lines.
     * <p>
     * <em>Notes:</em><br>
     * The axis is drawn as a unit, so the effective zorder for drawing the
     * grid is determined by the zorder of each axis, not by the zorder of the
     * `.Line2D` objects comprising the grid.  Therefore, to set grid zorder,
     * use `.set_axisbelow` or, for more control, call the
     * `~.Artist.set_zorder` method of each axis.
     * 
     * @param b bool or None, optional<br>
     *          Whether to show the grid lines. If any <b>kwargs</b>0 are supplied,
     *          it is assumed you want the grid on and<b>b</b>5nd *b* will be set to True.
     *          
     *      <b>b</b>10* <b>None</b>15b</b>10*        <b>kwargs</b>20>10*          If *b* is *None* and there are no *kwargs*, this toggles the
     *          visibility of the lines.
     *          
     * @param which &#123;'major', 'minor', 'both'&#125;, optional<br>
     *              The grid lines to apply the changes on.
     *              
     * @param axis &#123;'both', 'x', 'y'&#125;, optional<br>
     *             The axis to apply the changes on.
     *             
     * @param **kwargs `.Line2D` properties<br>
     *                 Define the line properties of the grid, e.g.::
     *                 
     *                 grid(color='r', linestyle='-', linewidth=2)
     *                 
     *                 Valid keyword arguments are:
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: scalar or None
     *                 animated: bool
     *                 antialiased or aa: bool
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 color or c: color
     *                 contains: unknown
     *                 dash_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 dash_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 dashes: sequence of floats (on/off ink in points) or (None, None)
     *                 data: (2, N) array or two 1D arrays
     *                 drawstyle or ds: &#123;'default', 'steps', 'steps-pre', 'steps-mid', 'steps-post'&#125;, default: 'default'
     *                 figure: `.Figure`
     *                 fillstyle: &#123;'full', 'left', 'right', 'bottom', 'top', 'none'&#125;
     *                 gid: str
     *                 in_layout: bool
     *                 label: object
     *                 linestyle or ls: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *                 linewidth or lw: float
     *                 marker: marker style string, `~.path.Path` or `~.markers.MarkerStyle`
     *                 markeredgecolor or mec: color
     *                 markeredgewidth or mew: float
     *                 markerfacecolor or mfc: color
     *                 markerfacecoloralt or mfcalt: color
     *                 markersize or ms: float
     *                 markevery: None or int or (int, int) or slice or list[int] or float or (float, float) or list[bool]
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: float or callable[[Artist, Event], tuple[bool, dict]]
     *                 pickradius: float
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 solid_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 solid_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 transform: `matplotlib.transforms.Transform`
     *                 url: str
     *                 visible: bool
     *                 xdata: 1D array
     *                 ydata: 1D array
     *                 zorder: float
     */
    public final Object grid(Object... args) {
        write("plt.grid("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Make a 2D hexagonal binning plot of points <b>x</b>0,<b>y</b>50, *y*.
     * 
     * If <b>C</b>0 is<b>None</b>5*None*, the value of the hexagon is determined by the number
     * of points in the hexagon. Otherwise, <b>C</b>0 specifies values at the
     * coordinate (x[i], y[i]). For each hexagon, these values are reduced
     * using <b>reduce_C_function</b>0.
     * <p>
     * <em>Notes:</em><br>
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * the following arguments can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception):
     * <b>x</b>0,<b>y</b>50<b>C</b>10y</b>50, *y*, *C*.
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param x array-like<br>
     *          The data positions. <b>x</b>0 and<b>y</b>5nd *y* must be of the same length.
     *          
     * @param y array-like<br>
     *          The data positions. <b>x</b>0 and<b>y</b>5nd *y* must be of the same length.
     *          
     * @param C array-like, optional<br>
     *          If given, these values are accumulated in the bins. Otherwise,
     *          every point has a value of 1. Must be of the same length as <b>x</b>0
     *          and<b>y</b>5nd *y*.
     *          
     * @param gridsize int or (int, int), default: 100<br>
     *                 If a single int, the number of hexagons in the <b>x</b>0-direction.
     *                 The number of hexagons in the<b>y</b>5he *y*-direction is chosen such that
     *                 the hexagons are approximately regular.
     *                 
     *                 Alternatively, if a <b>nx</b>10<b>ny</b>15<b>nx</b>10 if a tuple (*nx*, *ny*), the number of hex<b>x</b>20the number of hex<b>y</b>25/b>20the number of hexagons
     *                 in the *x*-direction and the *y*-direction.
     *                 
     * @param bins 'log' or int or sequence, default: None<br>
     *             Discretization of the hexagon values.
     *             
     *             - If <b>None</b>0, no binning is applied; the color of each hexagon
     *             directly corresponds to its count value.
     *             - If 'log', use a logarithmic scale for the colormap.
     *             Internally, :math:`log_&#123;10&#125;(i+1)` is used to determine the
     *             hexagon color. This is equivalent to ``norm=LogNorm()``.
     *             - If an integer, divide the counts in the specified number
     *             of bins, and color the hexagons accordingly.
     *             - If a sequence of values, the values of the lower bound of
     *             the bins to be used.
     *             
     * @param xscale &#123;'linear', 'log'&#125;, default: 'linear'<br>
     *               Use a linear or log10 scale on the horizontal axis.
     *               
     * @param yscale &#123;'linear', 'log'&#125;, default: 'linear'<br>
     *               Use a linear or log10 scale on the vertical axis.
     *               
     * @param mincnt int &gt; 0, default: <b>None</b>0<br>
     *               If not<b>None</b>5*None*, only display cells with mor<b>mincnt</b>10ore than *mincnt*
     *               number of points in the cell.
     *               
     * @param marginals bool, default: <b>False</b>0<br>
     *                  If marginals is<b>True</b>5*True*, plot the marginal density as
     *                  colormapped rectangles along the bottom of the x-axis and
     *                  left of the y-axis.
     *                  
     * @param extent float, default: <b>None</b>0<br>
     *               The limits of the bins. The default assigns the limits
     *               based on<b>gridsize</b>5d<b>x</b>10<b>y</b>15<b>xscale</b>2010<<b>yscale</b>25b>xscale</b>2010<b>y</b>155d<b>x</b>10e</b>5ds<b>xscale</b>3015<b>yscale</b>3510e</b>5ds<b>xscale</b>30155d<b>x</b>10e</b>5dsize*, *x*, *y*, *xscale* and *yscale*.
     *               
     *               If *xscale* or *yscale* is set to 'log', the limits are
     *               expected to be the exponent for a power of 10. E.g. for
     *               x-limits of 1 and 50 in 'linear' scale and y-limits
     *               of 10 and 1000 in 'log' scale, enter (1, 50, 1, 3).
     *               
     *               Order of scalars is (left, right, bottom, top).
     * @param cmap str or `~matplotlib.colors.Colormap`, default: :rc:`image.cmap`<br>
     *             The Colormap instance or registered colormap name used to map
     *             the bin values to colors.
     *             
     * @param norm `~matplotlib.colors.Normalize`, optional<br>
     *             The Normalize instance scales the bin values to the canonical
     *             colormap range [0, 1] for mapping to colors. By default, the data
     *             range is mapped to the colorbar range using linear scaling.
     *             
     * @param vmin float, default: None<br>
     *             The colorbar range. If <b>None</b>0, suitable min/max values are
     *             automatically chosen by the `~.Normalize` instance (defaults to
     *             the respective min/max values of the bins in case of the default
     *             linear scaling).
     *             It is deprecated to use<b>vmin</b>5<b>vmax</b>10/b>5<b>norm</b>15/b>10/b>5*vmin*/*vmax* when *norm* is given.
     *             
     * @param vmax float, default: None<br>
     *             The colorbar range. If <b>None</b>0, suitable min/max values are
     *             automatically chosen by the `~.Normalize` instance (defaults to
     *             the respective min/max values of the bins in case of the default
     *             linear scaling).
     *             It is deprecated to use<b>vmin</b>5<b>vmax</b>10/b>5<b>norm</b>15/b>10/b>5*vmin*/*vmax* when *norm* is given.
     *             
     * @param alpha float between 0 and 1, optional<br>
     *              The alpha blending value, between 0 (transparent) and 1 (opaque).
     *              
     * @param linewidths float, default: <b>None</b>0<br>
     *                   If<b>None</b>5*None*, defaults to 1.0.
     *                   
     * @param edgecolors &#123;'face', 'none', <b>None</b>0&#125; or color, default: 'face'<br>
     *                   The color of the hexagon edges. Possible values are:
     *                   
     *                   - 'face': Draw the edges in the same color as the fill color.
     *                   - 'none': No edges are drawn. This can sometimes lead to unsightly
     *                   unpainted pixels between the hexagons.
     *                   -<b>None</b>5*None*: Draw outlines in the default color.
     *                   - An explicit color.
     *                   
     * @param reduce_C_function callable, default: `numpy.mean`<br>
     *                          The function to aggregate <b>C</b>0 within the bins. It is ignored if
     *                         <b>C</b>5   *C* is not given. This must have the signature::
     *                          
     *                          def reduce_C_function(C: array) -&gt; float
     *                          
     *                          Commonly used functions are:
     *                          
     *                          - `numpy.mean`: average of the points
     *                          - `numpy.sum`: integral of the point values
     *                          - `numpy.amax`: value taken from the largest point
     *                          
     * @param **kwargs `~matplotlib.collections.PolyCollection` properties<br>
     *                 All other keyword arguments are passed on to `.PolyCollection`:
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: array-like or scalar or None
     *                 animated: bool
     *                 antialiased or aa or antialiaseds: bool or list of bools
     *                 array: ndarray or None
     *                 capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 clim: (vmin: float, vmax: float)
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 cmap: `.Colormap` or str or None
     *                 color: color or list of rgba tuples
     *                 contains: unknown
     *                 edgecolor or ec or edgecolors: color or list of colors or 'face'
     *                 facecolor or facecolors or fc: color or list of colors
     *                 figure: `.Figure`
     *                 gid: str
     *                 hatch: &#123;'/', '\\', '|', '-', '+', 'x', 'o', 'O', '.', '*'&#125;
     *                 in_layout: bool
     *                 joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 label: object
     *                 linestyle or dashes or linestyles or ls: str or tuple or list thereof
     *                 linewidth or linewidths or lw: float or list of floats
     *                 norm: `.Normalize` or None
     *                 offset_position: unknown
     *                 offsets: (N, 2) or (2,) array-like
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: None or bool or float or callable
     *                 pickradius: float
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 transform: `.Transform`
     *                 url: str
     *                 urls: list of str or None
     *                 visible: bool
     *                 zorder: float
     * @param data n/a<br>undocumented
     * 
     * @return `~matplotlib.collections.PolyCollection` <br>
     *                                                  A `.PolyCollection` defining the hexagonal bins.
     *                                                  
     *                                                  - `.PolyCollection.get_offsets` contains a Mx2 array containing
     *                                                  the x, y positions of the M hexagon centers.
     *                                                  - `.PolyCollection.get_array` contains the values of the M
     *                                                  hexagons.
     *                                                  
     *                                                  If <b>marginals</b>0 is<b>True</b>5*True*, horizontal
     *                                                  bar and vertical bar (both PolyCollections) will be attached
     *                                                  to the return collection as attr<b>hbar</b>10att<b>vbar</b>15</b>10attributes *hbar* and *vbar*.
     */
    public final Object hexbin(Object x, Object y, Object... args) {
        write("plt.hexbin("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(y)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Plot a histogram.
     * 
     * Compute and draw the histogram of <b>x</b>0.  The return value is a tuple
     * (<b>n</b>0,<b>bins</b>5*<b>patches</b>10*bins<b>n0</b>15<b>n1</b>20*bins<<b>bins</b>251<b>patches0</b>30*bins<<b>bins</b>2515<b>n1</b>20*bins<b>n0</b>15</b>10*bins*, *patches*) or ([*n0*, *n1*, ...], *bins*, [*patches0*,
     * <b>patches1</b>0, ...]) if the input contains multiple data.  See the
     * documentation of the <b>weights</b>0 parameter to draw a histogram of
     * already-binned data.
     * 
     * Multiple data can be provided via <b>x</b>0 as a list of datasets
     * of potentially different length ([<b>x0</b>0,<b>x1</b>5, *x1*, ...]), or as
     * a 2D ndarray in which each column is a dataset.  Note that
     * the ndarray form is transposed relative to the list form.
     * 
     * Masked arrays are not supported.
     * 
     * The <b>bins</b>0,<b>range</b>5r<b>weights</b>10rang<b>density</b>1510range*, *weights*, and *density* parameters behave as in
     * `numpy.histogram`.
     * <p>
     * <em>Notes:</em><br>
     * For large numbers of bins (>1000), 'step' and 'stepfilled' can be
     * significantly faster than 'bar' and 'barstacked'.
     * 
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * the following arguments can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception):
     * <b>x</b>0,<b>weights</b>5ights*.
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param x (n,) array or sequence of (n,) arrays<br>
     *          Input values, this takes either a single array or a sequence of
     *          arrays which are not required to be of the same length.
     *          
     * @param bins int or sequence or str, default: :rc:`hist.bins`<br>
     *             If <b>bins</b>0 is an integer, it defines the number of equal-width bins
     *             in the range.
     *             
     *             If<b>bins</b>5*bins* is a sequence, it defines the bin edges, including the
     *             left edge of the first bin and the right edge of the last bin;
     *             in this case, bins may be unequally spaced.  All but the last
     *             (righthand-most) bin is half-open.  In other wor<b>bins</b>10 words, if *bins* is::
     *             
     *             [1, 2, 3, 4]
     *             
     *             then the first bin is ``[1, 2)`` (including 1, but excluding 2) and
     *             the second ``[2, 3)``.  The last bin, however, is ``[3, 4]``, which
<b>includes</b>15hich
     *             *includes* 4.
     *<b>bins</b>20des* 4.
     *             
     *             If *bins* is a string, it is one of the binning strategies
     *             supported by `numpy.histogram_bin_edges`: 'auto', 'fd', 'doane',
     *             'scott', 'stone', 'rice', 'sturges', or 'sqrt'.
     *             
     * @param range tuple or None, default: None<br>
     *              The lower and upper range of the bins. Lower and upper outliers
     *              are ignored. If not provided, <b>range</b>0 is ``(x.min(), x.max())``.
     *              Range has no effect if<b>bins</b>5*bins* is a sequence.
     *              
     *          <b>bins</b>10        If *bins<b>range</b>15If *bins* is a sequence or *range* is specified, autoscaling
     *              is based on the specified bin range instead of the
     *              range of x.
     *              
     * @param density bool, default: False<br>
     *                If ``True``, draw and return a probability density: each bin
     *                will display the bin's raw count divided by the total number of
     *                counts *and the bin width*
     *                (``density = counts / (sum(counts) * np.diff(bins))``),
     *                so that the area under the histogram integrates to 1
     *                (``np.sum(density * np.diff(bins)) == 1``).
     *                
     *                If <b>stacked</b>0 is also ``True``, the sum of the histograms is
     *                normalized to 1.
     *                
     * @param weights (n,) array-like or None, default: None<br>
     *                An array of weights, of the same shape as <b>x</b>0.  Each value in
     *               <b>x</b>5   *x* only contributes its associated weight towards the bin count
     *                (instead of 1<b>density</b>101).  If *density* is ``True``, the weights are
     *                normalized, so that the integral of the density over the range
     *                remains 1.
     *                
     *                This parameter can be used to draw a histogram of data that has
     *                already been binned, e.g. using `numpy.histogram` (by treating each
     *                bin as a single point with a weight equal to its count) ::
     *                
     *                counts, bins = np.histogram(data)
     *                plt.hist(bins[:-1], bins, weights=counts)
     *                
     *                (or you may alternatively use `~.bar()`).
     *                
     * @param cumulative bool or -1, default: False<br>
     *                   If ``True``, then a histogram is computed where each bin gives the
     *                   counts in that bin plus all bins for smaller values. The last bin
     *                   gives the total number of datapoints.
     *                   
     *                   If <b>density</b>0 is also ``True`` then the histogram is normalized such
     *                   that the last bin equals 1.
     *                   
     *                   If<b>cumulative</b>5ative* is a number less than 0 (e.g., -1), the direction
     *                   of accumulation is reversed.  In this ca<b>density</b>10ase, if *density* is also
     *                   ``True``, then the histogram is normalized such that the first bin
     *                   equals 1.
     *                   
     * @param bottom array-like, scalar, or None, default: None<br>
     *               Location of the bottom of each bin, ie. bins are drawn from
     *               ``bottom`` to ``bottom + hist(x, bins)`` If a scalar, the bottom
     *               of each bin is shifted by the same amount. If an array, each bin
     *               is shifted independently and the length of bottom must match the
     *               number of bins. If None, defaults to 0.
     *               
     * @param histtype &#123;'bar', 'barstacked', 'step', 'stepfilled'&#125;, default: 'bar'<br>
     *                 The type of histogram to draw.
     *                 
     *                 - 'bar' is a traditional bar-type histogram.  If multiple data
     *                 are given the bars are arranged side by side.
     *                 - 'barstacked' is a bar-type histogram where multiple
     *                 data are stacked on top of each other.
     *                 - 'step' generates a lineplot that is by default unfilled.
     *                 - 'stepfilled' generates a lineplot that is by default filled.
     *                 
     * @param align &#123;'left', 'mid', 'right'&#125;, default: 'mid'<br>
     *              The horizontal alignment of the histogram bars.
     *              
     *              - 'left': bars are centered on the left bin edges.
     *              - 'mid': bars are centered between the bin edges.
     *              - 'right': bars are centered on the right bin edges.
     *              
     * @param orientation &#123;'vertical', 'horizontal'&#125;, default: 'vertical'<br>
     *                    If 'horizontal', `~.Axes.barh` will be used for bar-type histograms
     *                    and the <b>bottom</b>0 kwarg will be the left edges.
     *                    
     * @param rwidth float or None, default: None<br>
     *               The relative width of the bars as a fraction of the bin width.  If
     *               ``None``, automatically compute the width.
     *               
     *               Ignored if <b>histtype</b>0 is 'step' or 'stepfilled'.
     *               
     * @param log bool, default: False<br>
     *            If ``True``, the histogram axis will be set to a log scale.
     *            
     * @param color color or array-like of colors or None, default: None<br>
     *              Color or sequence of colors, one per dataset.  Default (``None``)
     *              uses the standard line color sequence.
     *              
     * @param label str or None, default: None<br>
     *              String, or sequence of strings to match multiple datasets.  Bar
     *              charts yield multiple patches per dataset, but only the first gets
     *              the label, so that `~.Axes.legend` will work as expected.
     *              
     * @param stacked bool, default: False<br>
     *                If ``True``, multiple data are stacked on top of each other If
     *                ``False`` multiple data are arranged side by side if histtype is
     *                'bar' or on top of each other if histtype is 'step'
     * @param **kwargs <br>
     *                 `~matplotlib.patches.Patch` properties
     * @param data n/a<br>undocumented
     * 
     * @return (n,bins,patches) (array or list of arrays,array,`.BarContainer` or list of a single `.Polygon` or list of such objects)<br>
     *          The values of the histogram bins. See <b>density</b>0 and<b>weights</b>5ights* for a
     *          description of the possible semantics.  If<b>x</b>10cs.  If input *x* is an array,
     *          then this is <b>nbins</b>15this is an array of length *nbins*. If input is a sequence of
     *          arrays ``[data1, data2, ...]``, then this is a list of arrays with
     *          the values of the histograms for each of the arrays in the same
     *     <b>n</b>20 same
     *          order.  The dtype of the array *n* (or of its element arrays) will
     *          always be float even if no weighting or normalization is used.
     *          
     *          
     *          The edges of the bins. Length nbins + 1 (nbins left edges and right
     *          edge of last bin).  Always a single array even when multiple data
     *          sets are passed in.
     *          
     *          
     *          Container of individual artists used to create the histogram
     *          or list of such containers if there are multiple input datasets.
     */
    public final Object hist(Object x, Object... args) {
        write("plt.hist("+PythonGrammar.toPythonArgs(x)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Make a 2D histogram plot.
     * <p>
     * <em>Notes:</em><br>
     * - Currently ``hist2d`` calculates its own axis limits, and any limits
     * previously set are ignored.
     * - Rendering the histogram with a logarithmic color scale is
     * accomplished by passing a `.colors.LogNorm` instance to the <b>norm</b>0
     * keyword argument. Likewise, power-law normalization (similar
     * in effect to gamma correction) can be accomplished with
     * `.colors.PowerNorm`.
     * 
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * the following arguments can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception):
     * <b>x</b>0,<b>y</b>50<b>weights</b>100, *y*, *weights*.
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param x array-like, shape (n, )<br>
     *          Input values
     *          
     * @param y array-like, shape (n, )<br>
     *          Input values
     *          
     * @param bins None or int or [int, int] or array-like or [array, array]<br>
     *             
     *             The bin specification:
     *             
     *             - If int, the number of bins for the two dimensions
     *             (nx=ny=bins).
     *             - If ``[int, int]``, the number of bins in each dimension
     *             (nx, ny = bins).
     *             - If array-like, the bin edges for the two dimensions
     *             (x_edges=y_edges=bins).
     *             - If ``[array, array]``, the bin edges in each dimension
     *             (x_edges, y_edges = bins).
     *             
     *             The default value is 10.
     *             
     * @param range array-like shape(2, 2), optional<br>
     *              The leftmost and rightmost edges of the bins along each dimension
     *              (if not specified explicitly in the bins parameters): ``[[xmin,
     *              xmax], [ymin, ymax]]``. All values outside of this range will be
     *              considered outliers and not tallied in the histogram.
     *              
     * @param density bool, default: False<br>
     *                Normalize histogram.  See the documentation for the <b>density</b>0
     *                parameter of `~.Axes.hist` for more details.
     *                
     * @param weights array-like, shape (n, ), optional<br>
     *                An array of values w_i weighing each sample (x_i, y_i).
     *                
     * @param cmin float, default: None<br>
     *             All bins that has count less than <b>cmin</b>0 or more than<b>cmax</b>5*cmax* will
     *             not be displayed (set to NaN before passing to imshow) and these
     *             count values in the return value count histogram will also be set
     *             to nan upon return.
     * @param cmax float, default: None<br>
     *             All bins that has count less than <b>cmin</b>0 or more than<b>cmax</b>5*cmax* will
     *             not be displayed (set to NaN before passing to imshow) and these
     *             count values in the return value count histogram will also be set
     *             to nan upon return.
     * @param cmap Colormap or str, optional<br>
     *             A `.colors.Colormap` instance.  If not set, use rc settings.
     *             
     * @param norm Normalize, optional<br>
     *             A `.colors.Normalize` instance is used to
     *             scale luminance data to ``[0, 1]``. If not set, defaults to
     *             `.colors.Normalize()`.
     *             
     * @param vmin/vmax None or scalar, optional<br>
     *                  Arguments passed to the `~.colors.Normalize` instance.
     *                  
     * @param alpha ``0 &lt;= scalar &lt;= 1`` or ``None``, optional<br>
     *              The alpha blending value.
     *              
     * @param **kwargs <br>
     *                 Additional parameters are passed along to the
     *                 `~.Axes.pcolormesh` method and `~matplotlib.collections.QuadMesh`
     *                 constructor.
     * @param data n/a<br>undocumented
     * 
     * @return (h,xedges,yedges,image) (2D array,1D array,1D array,`~.matplotlib.collections.QuadMesh`)<br>
     *          The bi-dimensional histogram of samples x and y. Values in x are
     *          histogrammed along the first dimension and values in y are
     *          histogrammed along the second dimension.
     *          
     *          The bin edges along the x axis.
     *          
     *          The bin edges along the y axis.
     *          
     */
    public final Object hist2d(Object x, Object y, Object... args) {
        write("plt.hist2d("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(y)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Plot horizontal lines at each <b>y</b>0 from<b>xmin</b>5*xm<b>xmax</b>105*xmin* to *xmax*.
     * <p>
     * <em>Notes:</em><br>
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * the following arguments can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception):
     * <b>y</b>0,<b>xmin</b>5*<b>xmax</b>10<b>colors</b>15x</b>10b>5*xmin*, *xmax*, *colors*.
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param y float or array-like<br>
     *          y-indexes where to plot the lines.
     *          
     * @param xmin float or array-like<br>
     *             Respective beginning and end of each line. If scalars are
     *             provided, all lines will have same length.
     *             
     * @param xmax float or array-like<br>
     *             Respective beginning and end of each line. If scalars are
     *             provided, all lines will have same length.
     *             
     * @param colors list of colors, default: :rc:`lines.color`<br>
     *               
     * @param linestyles &#123;'solid', 'dashed', 'dashdot', 'dotted'&#125;, optional<br>
     *                   
     * @param label str, default: ''<br>
     * @param **kwargs  `~matplotlib.collections.LineCollection` properties.<br>
     * @param data n/a<br>undocumented
     * 
     * @return `~matplotlib.collections.LineCollection` <br>
     */
    public final Object hlines(Object y, Object xmin, Object xmax, Object... args) {
        write("plt.hlines("+PythonGrammar.toPythonArgs(y),PythonGrammar.toPythonArgs(xmin),PythonGrammar.toPythonArgs(xmax)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the colormap to 'hot'.
     * 
     * This changes the default colormap as well as the colormap of the current
     * image if there is one. See ``help(colormaps)`` for more information.
     */
    public final Object hot() {
        write("plt.hot()");
        return null;
    }

    /**
     * Set the colormap to 'hsv'.
     * 
     * This changes the default colormap as well as the colormap of the current
     * image if there is one. See ``help(colormaps)`` for more information.
     */
    public final Object hsv() {
        write("plt.hsv()");
        return null;
    }

    /**
     * Read an image from a file into an array.
     * 
     * @param fname str or file-like<br>
     *              The image file to read: a filename, a URL or a file-like object opened
     *              in read-binary mode.
     *              
     *              Passing a URL is deprecated.  Please open the URL
     *              for reading and pass the result to Pillow, e.g. with
     *              ``PIL.Image.open(urllib.request.urlopen(url))``.
     * @param format str, optional<br>
     *               The image file format assumed for reading the data. If not
     *               given, the format is deduced from the filename.  If nothing can
     *               be deduced, PNG is tried.
     * 
     * @return `numpy.array` <br>
     *                       The image data. The returned array has shape
     *                       
     *                       - (M, N) for grayscale images.
     *                       - (M, N, 3) for RGB images.
     *                       - (M, N, 4) for RGBA images.
     */
    public final Object imread(Object fname, Object... args) {
        write("plt.imread("+PythonGrammar.toPythonArgs(fname)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Save an array as an image file.
     * 
     * @param fname str or path-like or file-like<br>
     *              A path or a file-like object to store the image in.
     *              If <b>format</b>0 is not set, then the output format is inferred from the
     *              extension of<b>fname</b>5fname*, if any, and from :rc:`savefig.format` otherwise.
     *          <b>format</b>10      If *format* is set, it determines the output format.
     * @param arr array-like<br>
     *            The image data. The shape can be one of
     *            MxN (luminance), MxNx3 (RGB) or MxNx4 (RGBA).
     * @param vmin float, optional<br>
     *             <b>vmin</b>0 and<b>vmax</b>5*vmax* set the color scaling for the image by fixing the
     *             values that map to the colormap color limits. If <b>vmin</b>10 If either *vmin*
   <b>vmax</b>15vmin*
     *             or *vmax* is None<b>arr</b>20 *vmax* is None, that limit is determined from the *arr*
     *             min/max value.
     * @param vmax float, optional<br>
     *             <b>vmin</b>0 and<b>vmax</b>5*vmax* set the color scaling for the image by fixing the
     *             values that map to the colormap color limits. If <b>vmin</b>10 If either *vmin*
   <b>vmax</b>15vmin*
     *             or *vmax* is None<b>arr</b>20 *vmax* is None, that limit is determined from the *arr*
     *             min/max value.
     * @param cmap str or `~matplotlib.colors.Colormap`, default: :rc:`image.cmap`<br>
     *             A Colormap instance or registered colormap name. The colormap
     *             maps scalar data to colors. It is ignored for RGB(A) data.
     * @param format str, optional<br>
     *               The file format, e.g. 'png', 'pdf', 'svg', ...  The behavior when this
     *               is unset is documented under <b>fname</b>0.
     * @param origin &#123;'upper', 'lower'&#125;, default: :rc:`image.origin`<br>
     *               Indicates whether the ``(0, 0)`` index of the array is in the upper
     *               left or lower left corner of the axes.
     * @param dpi float<br>
     *            The DPI to store in the metadata of the file.  This does not affect the
     *            resolution of the output image.  Depending on file format, this may be
     *            rounded to the nearest integer.
     * @param metadata dict, optional<br>
     *                 Metadata in the image file.  The supported keys depend on the output
     *                 format, see the documentation of the respective backends for more
     *                 information.
     * @param pil_kwargs dict, optional<br>
     *                   Keyword arguments passed to `PIL.Image.Image.save`.  If the 'pnginfo'
     *                   key is present, it completely overrides <b>metadata</b>0, including the
     *                   default 'Software' key.
     * @param **kwargs n/a<br>undocumented
     */
    public final Object imsave(Object fname, Object arr, Object... args) {
        write("plt.imsave("+PythonGrammar.toPythonArgs(fname),PythonGrammar.toPythonArgs(arr)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Display data as an image, i.e., on a 2D regular raster.
     * 
     * The input may either be actual RGB(A) data, or 2D scalar data, which
     * will be rendered as a pseudocolor image. For displaying a grayscale
     * image set up the colormapping using the parameters
     * ``cmap='gray', vmin=0, vmax=255``.
     * 
     * The number of pixels used to render an image is set by the Axes size
     * and the <b>dpi</b>0 of the figure. This can lead to aliasing artifacts when
     * the image is resampled because the displayed image size will usually
     * not match the size of <b>X</b>0 (see
     * :doc:`/gallery/images_contours_and_fields/image_antialiasing`).
     * The resampling can be controlled via the <b>interpolation</b>0 parameter
     * and/or :rc:`image.interpolation`.
     * <p>
     * <em>Notes:</em><br>
     * Unless <b>extent</b>0 is used, pixel centers will be located at integer
     * coordinates. In other words: the origin will coincide with the center
     * of pixel (0, 0).
     * 
     * There are two common representations for RGB images with an alpha
     * channel:
     * 
     * -   Straight (unassociated) alpha: R, G, and B channels represent the
     * color of the pixel, disregarding its opacity.
     * -   Premultiplied (associated) alpha: R, G, and B channels represent
     * the color of the pixel, adjusted for its opacity by multiplication.
     * 
     * `~matplotlib.pyplot.imshow` expects RGB images adopting the straight
     * (unassociated) alpha representation.
     * 
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * every other argument can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception).
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param X array-like or PIL image<br>
     *          The image data. Supported array shapes are:
     *          
     *          - (M, N): an image with scalar data. The values are mapped to
     *          colors using normalization and a colormap. See parameters <b>norm</b>0,
     *         <b>cmap</b>5*<b>vmin</b>10<b>vmax</b>15min</b>10b>5*cmap*, *vmin*, *vmax*.
     *          - (M, N, 3): an image with RGB values (0-1 float or 0-255 int).
     *          - (M, N, 4): an image with RGBA values (0-1 float or 0-255 int),
     *          i.e. including transparency.
     *          
     *          The first two dimensions (M, N) define the rows and columns of
     *          the image.
     *          
     *          Out-of-range RGB(A) values are clipped.
     *          
     * @param cmap str or `~matplotlib.colors.Colormap`, default: :rc:`image.cmap`<br>
     *             The Colormap instance or registered colormap name used to map
     *             scalar data to colors. This parameter is ignored for RGB(A) data.
     *             
     * @param norm `~matplotlib.colors.Normalize`, optional<br>
     *             The `.Normalize` instance used to scale scalar data to the [0, 1]
     *             range before mapping to colors using <b>cmap</b>0. By default, a linear
     *             scaling mapping the lowest value to 0 and the highest to 1 is used.
     *             This parameter is ignored for RGB(A) data.
     *             
     * @param aspect &#123;'equal', 'auto'&#125; or float, default: :rc:`image.aspect`<br>
     *               The aspect ratio of the Axes.  This parameter is particularly
     *               relevant for images since it determines whether data pixels are
     *               square.
     *               
     *               This parameter is a shortcut for explicitly calling
     *               `.Axes.set_aspect`. See there for further details.
     *               
     *               - 'equal': Ensures an aspect ratio of 1. Pixels will be square
     *               (unless pixel sizes are explicitly made non-square in data
     *               coordinates using <b>extent</b>0).
     *               - 'auto': The Axes is kept fixed and the aspect is adjusted so
     *               that the data fit in the Axes. In general, this will result in
     *               non-square pixels.
     *               
     * @param interpolation str, default: :rc:`image.interpolation`<br>
     *                      The interpolation method used.
     *                      
     *                      Supported values are 'none', 'antialiased', 'nearest', 'bilinear',
     *                      'bicubic', 'spline16', 'spline36', 'hanning', 'hamming', 'hermite',
     *                      'kaiser', 'quadric', 'catrom', 'gaussian', 'bessel', 'mitchell',
     *                      'sinc', 'lanczos', 'blackman'.
     *                      
     *                      If <b>interpolation</b>0 is 'none', then no interpolation is performed
     *                      on the Agg, ps, pdf and svg backends. Other backends will fall back
     *                      to 'nearest'. Note that most SVG renderers perform interpolation at
     *                      rendering and that the default interpolation method they implement
     *                      may differ.
     *                      
     *                      If<b>interpolation</b>5ation* is the default 'antialiased', then 'nearest'
     *                      interpolation is used if the image is upsampled by more than a
     *                      factor of three (i.e. the number of display pixels is at least
     *                      three times the size of the data array).  If the upsampling rate is
     *                      smaller than 3, or the image is downsampled, then 'hanning'
     *                      interpolation is used to act as an anti-aliasing filter, unless the
     *                      image happens to be upsampled by exactly a factor of two or one.
     *                      
     *                      See
     *                      :doc:`/gallery/images_contours_and_fields/interpolation_methods`
     *                      for an overview of the supported interpolation methods, and
     *                      :doc:`/gallery/images_contours_and_fields/image_antialiasing` for
     *                      a discussion of image antialiasing.
     *                      
     *                      Some interpolation methods require an additional radius parameter,
     *                      which can be <b>filterrad</b>10et by *filterrad*. Additionally, the antigrain image
     *                      resize filter is controlle<b>filternorm</b>15lled by the parameter *filternorm*.
     *                      
     * @param alpha float or array-like, optional<br>
     *              The alpha blending value, between 0 (transparent) and 1 (opaque).
     *              If <b>alpha</b>0 is an array, the alpha blending values are applied pixel
     *              by pixel, and<b>alpha</b>5alpha* must have the same sh<b>X</b>10same shape as *X*.
     *              
     * @param vmin float, optional<br>
     *             When using scalar data and no explicit <b>norm</b>0,<b>vmin</b>5*vmi<b>vmax</b>10*vmin* and *vmax*
     *             define the data range that the colormap covers. By default,
     *             the colormap covers the complete value range of the supplied
     *             data. It is<b>vmin</b>1<b>vmax</b>20is<b<b>norm</b>25>1<b>vmax</b>20is<b>vmin</b>15ta. It is deprecated to use *vmin<b>vmin</b>3<b>vmax</b>35ated to use *vmin<b>vmin</b>30 deprecated to use *vmin*/*vmax* when *norm* is given.
     *             When using RGB(A) data, parameters *vmin*/*vmax* are ignored.
     *             
     * @param vmax float, optional<br>
     *             When using scalar data and no explicit <b>norm</b>0,<b>vmin</b>5*vmi<b>vmax</b>10*vmin* and *vmax*
     *             define the data range that the colormap covers. By default,
     *             the colormap covers the complete value range of the supplied
     *             data. It is<b>vmin</b>1<b>vmax</b>20is<b<b>norm</b>25>1<b>vmax</b>20is<b>vmin</b>15ta. It is deprecated to use *vmin<b>vmin</b>3<b>vmax</b>35ated to use *vmin<b>vmin</b>30 deprecated to use *vmin*/*vmax* when *norm* is given.
     *             When using RGB(A) data, parameters *vmin*/*vmax* are ignored.
     *             
     * @param origin &#123;'upper', 'lower'&#125;, default: :rc:`image.origin`<br>
     *               Place the [0, 0] index of the array in the upper left or lower
     *               left corner of the Axes. The convention (the default) 'upper' is
     *               typically used for matrices and images.
     *               
     *               Note that the vertical axis points upward for 'lower'
     *               but downward for 'upper'.
     *               
     *               See the :doc:`/tutorials/intermediate/imshow_extent` tutorial for
     *               examples and a more detailed description.
     *               
     * @param extent floats (left, right, bottom, top), optional<br>
     *               The bounding box in data coordinates that the image will fill.
     *               The image is stretched individually along x and y to fill the box.
     *               
     *               The default extent is determined by the following conditions.
     *               Pixels have unit size in data coordinates. Their centers are on
     *               integer coordinates, and their center coordinates range from 0 to
     *               columns-1 horizontally and from 0 to rows-1 vertically.
     *               
     *               Note that the direction of the vertical axis and thus the default
     *               values for top and bottom depend on <b>origin</b>0:
     *               
     *               - For ``origin == 'upper'`` the default is
     *               ``(-0.5, numcols-0.5, numrows-0.5, -0.5)``.
     *               - For ``origin == 'lower'`` the default is
     *               ``(-0.5, numcols-0.5, -0.5, numrows-0.5)``.
     *               
     *               See the :doc:`/tutorials/intermediate/imshow_extent` tutorial for
     *               examples and a more detailed description.
     *               
     * @param filternorm bool, default: True<br>
     *                   A parameter for the antigrain image resize filter (see the
     *                   antigrain documentation).  If <b>filternorm</b>0 is set, the filter
     *                   normalizes integer values and corrects the rounding errors. It
     *                   doesn't do anything with the source floating point values, it
     *                   corrects only integers according to the rule of 1.0 which means
     *                   that any sum of pixel weights must be equal to 1.0.  So, the
     *                   filter function must produce a graph of the proper shape.
     *                   
     * @param filterrad float &gt; 0, default: 4.0<br>
     *                  The filter radius for filters that have a radius parameter, i.e.
     *                  when interpolation is one of: 'sinc', 'lanczos' or 'blackman'.
     *                  
     * @param resample bool, default: :rc:`image.resample`<br>
     *                 When <b>True</b>0, use a full resampling method.  When<b>False</b>5False*, only
     *                 resample when the output image is larger than the input image.
     *                 
     * @param url str, optional<br>
     *            Set the url of the created `.AxesImage`. See `.Artist.set_url`.
     * @param **kwargs `~matplotlib.artist.Artist` properties<br>
     *                 These parameters are passed on to the constructor of the
     *                 `.AxesImage` artist.
     * @param data n/a<br>undocumented
     * 
     * @return `~matplotlib.image.AxesImage` <br>
     */
    public final Object imshow(Object X, Object... args) {
        write("plt.imshow("+PythonGrammar.toPythonArgs(X)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the colormap to 'inferno'.
     * 
     * This changes the default colormap as well as the colormap of the current
     * image if there is one. See ``help(colormaps)`` for more information.
     */
    public final Object inferno() {
        write("plt.inferno()");
        return null;
    }

    /**
     * Install a repl display hook so that any stale figure are automatically
     * redrawn when control is returned to the repl.
     * 
     * This works both with IPython and with vanilla python shells.
     */
    public final Object install_repl_displayhook() {
        write("plt.install_repl_displayhook()");
        return null;
    }

    /**
     * Set whether to redraw after every plotting command (e.g. `.pyplot.xlabel`).
     * 
     * @param b n/a<br>undocumented
     */
    public final Object interactive(Object... args) {
        write("plt.interactive("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Turn interactive mode off.
     * <p>
     * <em>Notes:</em><br>
     * For a temporary change, this can be used as a context manager::
     * 
     * # if interactive mode is on
     * # then figures will be shown on creation
     * plt.ion()
     * # This figure will be shown immediately
     * fig = plt.figure()
     * 
     * with plt.ioff():
     * # interactive mode will be off
     * # figures will not automatically be shown
     * fig2 = plt.figure()
     * # ...
     * 
     * To enable usage as a context manager, this function returns an
     * ``_IoffContext`` object. The return value is not intended to be stored
     * or accessed by the user.
     */
    public final Object ioff() {
        write("plt.ioff()");
        return null;
    }

    /**
     * Turn interactive mode on.
     * <p>
     * <em>Notes:</em><br>
     * For a temporary change, this can be used as a context manager::
     * 
     * # if interactive mode is off
     * # then figures will not be shown on creation
     * plt.ioff()
     * # This figure will not be shown immediately
     * fig = plt.figure()
     * 
     * with plt.ion():
     * # interactive mode will be on
     * # figures will automatically be shown
     * fig2 = plt.figure()
     * # ...
     * 
     * To enable usage as a context manager, this function returns an
     * ``_IonContext`` object. The return value is not intended to be stored
     * or accessed by the user.
     */
    public final Object ion() {
        write("plt.ion()");
        return null;
    }

    /**
     * Return if pyplot is in "interactive mode" or not.
     * 
     * If in interactive mode then:
     * 
     * - newly created figures will be shown immediately;
     * - figures will automatically redraw on change;
     * - `.pyplot.show` will not block by default.
     * 
     * If not in interactive mode then:
     * 
     * - newly created figures and changes to figures will not be reflected until
     * explicitly asked to be;
     * - `.pyplot.show` will block by default.
     */
    public final Object isinteractive() {
        write("plt.isinteractive()");
        return null;
    }

    /**
     * Set the colormap to 'jet'.
     * 
     * This changes the default colormap as well as the colormap of the current
     * image if there is one. See ``help(colormaps)`` for more information.
     */
    public final Object jet() {
        write("plt.jet()");
        return null;
    }

    /**
     * Place a legend on the Axes.
     * 
     * Call signatures::
     * 
     * legend()
     * legend(labels)
     * legend(handles, labels)
     * 
     * The call signatures correspond to these three different ways to use
     * this method:
     * 
     * **1. Automatic detection of elements to be shown in the legend**
     * 
     * The elements to be added to the legend are automatically determined,
     * when you do not pass in any extra arguments.
     * 
     * In this case, the labels are taken from the artist. You can specify
     * them either at artist creation or by calling the
     * :meth:`~.Artist.set_label` method on the artist::
     * 
     * ax.plot([1, 2, 3], label='Inline label')
     * ax.legend()
     * 
     * or::
     * 
     * line, = ax.plot([1, 2, 3])
     * line.set_label('Label via method')
     * ax.legend()
     * 
     * Specific lines can be excluded from the automatic legend element
     * selection by defining a label starting with an underscore.
     * This is default for all artists, so calling `.Axes.legend` without
     * any arguments and without setting the labels manually will result in
     * no legend being drawn.
     * 
     * 
     * **2. Labeling existing plot elements**
     * 
     * To make a legend for lines which already exist on the Axes
     * (via plot for instance), simply call this function with an iterable
     * of strings, one for each legend item. For example::
     * 
     * ax.plot([1, 2, 3])
     * ax.legend(['A simple line'])
     * 
     * Note: This call signature is discouraged, because the relation between
     * plot elements and labels is only implicit by their order and can
     * easily be mixed up.
     * 
     * 
     * **3. Explicitly defining the elements in the legend**
     * 
     * For full control of which artists have a legend entry, it is possible
     * to pass an iterable of legend artists followed by an iterable of
     * legend labels respectively::
     * 
     * ax.legend([line1, line2, line3], ['label1', 'label2', 'label3'])
     * <p>
     * <em>Notes:</em><br>
     * Some artists are not supported by this function.  See
     * :doc:`/tutorials/intermediate/legend_guide` for details.
     * 
     * @param handles sequence of `.Artist`, optional<br>
     *                A list of Artists (lines, patches) to be added to the legend.
     *                Use this together with <b>labels</b>0, if you need full control on what
     *                is shown in the legend and the automatic mechanism described above
     *                is not sufficient.
     *                
     *                The length of handles and labels should be the same in this
     *                case. If they are not, they are truncated to the smaller length.
     *                
     * @param labels list of str, optional<br>
     *               A list of labels to show next to the artists.
     *               Use this together with <b>handles</b>0, if you need full control on what
     *               is shown in the legend and the automatic mechanism described above
     *               is not sufficient.
     * @param loc str or pair of floats, default: :rc:`legend.loc` ('best' for axes, 'upper right' for figures)<br>
     *            The location of the legend.
     *            
     *            The strings
     *            ``'upper left', 'upper right', 'lower left', 'lower right'``
     *            place the legend at the corresponding corner of the axes/figure.
     *            
     *            The strings
     *            ``'upper center', 'lower center', 'center left', 'center right'``
     *            place the legend at the center of the corresponding edge of the
     *            axes/figure.
     *            
     *            The string ``'center'`` places the legend at the center of the axes/figure.
     *            
     *            The string ``'best'`` places the legend at the location, among the nine
     *            locations defined so far, with the minimum overlap with other drawn
     *            artists.  This option can be quite slow for plots with large amounts of
     *            data; your plotting speed may benefit from providing a specific location.
     *            
     *            The location can also be a 2-tuple giving the coordinates of the lower-left
     *            corner of the legend in axes coordinates (in which case <b>bbox_to_anchor</b>0
     *            will be ignored).
     *            
     *            For back-compatibility, ``'center right'`` (but no other location) can also
     *            be spelled ``'right'``, and each "string" locations can also be given as a
     *            numeric value:
     *            
     *            ===============   =============
     *            Location String   Location Code
     *            ===============   =============
     *            'best'            0
     *            'upper right'     1
     *            'upper left'      2
     *            'lower left'      3
     *            'lower right'     4
     *            'right'           5
     *            'center left'     6
     *            'center right'    7
     *            'lower center'    8
     *            'upper center'    9
     *            'center'          10
     *            ===============   =============
     *            
     * @param bbox_to_anchor `.BboxBase`, 2-tuple, or 4-tuple of floats<br>
     *                       Box that is used to position the legend in conjunction with <b>loc</b>0.
     *                       Defaults to `axes.bbox` (if called as a method to `.Axes.legend`) or
     *                       `figure.bbox` (if `.Figure.legend`).  This argument allows arbitrary
     *                       placement of the legend.
     *                       
     *                       Bbox coordinates are interpreted in the coordinate system given by
     *                      <b>bbox_transform</b>5sform*, with the default transform
     *                       Axes or Figure coordinates, depending on which ``legend`` is called.
     *                       
     *                       If a 4-tuple or `.BboxBase` is given, then it specifies the bbox
     *                       ``(x, y, width, height)`` that the legend is placed in.
     *                       To put the legend in the best location in the bottom right
     *                       quadrant of the axes (or figure)::
     *                       
     *                       loc='best', bbox_to_anchor=(0.5, 0., 0.5, 0.5)
     *                       
     *                       A 2-tuple ``(x, y)`` places the corner of the legend specif<b>loc</b>10pecified by *loc* at
     *                       x, y.  For example, to put the legend's upper right-hand corner in the
     *                       center of the axes (or figure) the following keywords can be used::
     *                       
     *                       loc='upper right', bbox_to_anchor=(0.5, 0.5)
     *                       
     * @param ncol int, default: 1<br>
     *             The number of columns that the legend has.
     *             
     * @param prop None or `matplotlib.font_manager.FontProperties` or dict<br>
     *             The font properties of the legend. If None (default), the current
     *             :data:`matplotlib.rcParams` will be used.
     *             
     * @param fontsize int or &#123;'xx-small', 'x-small', 'small', 'medium', 'large', 'x-large', 'xx-large'&#125;<br>
     *                 The font size of the legend. If the value is numeric the size will be the
     *                 absolute font size in points. String values are relative to the current
     *                 default font size. This argument is only used if <b>prop</b>0 is not specified.
     *                 
     * @param labelcolor str or list<br>
     *                   The color of the text in the legend. Either a valid color string
     *                   (for example, 'red'), or a list of color strings. The labelcolor can
     *                   also be made to match the color of the line or marker using 'linecolor',
     *                   'markerfacecolor' (or 'mfc'), or 'markeredgecolor' (or 'mec').
     *                   
     * @param numpoints int, default: :rc:`legend.numpoints`<br>
     *                  The number of marker points in the legend when creating a legend
     *                  entry for a `.Line2D` (line).
     *                  
     * @param scatterpoints int, default: :rc:`legend.scatterpoints`<br>
     *                      The number of marker points in the legend when creating
     *                      a legend entry for a `.PathCollection` (scatter plot).
     *                      
     * @param scatteryoffsets iterable of floats, default: ``[0.375, 0.5, 0.3125]``<br>
     *                        The vertical offset (relative to the font size) for the markers
     *                        created for a scatter plot legend entry. 0.0 is at the base the
     *                        legend text, and 1.0 is at the top. To draw all markers at the
     *                        same height, set to ``[0.5]``.
     *                        
     * @param markerscale float, default: :rc:`legend.markerscale`<br>
     *                    The relative size of legend markers compared with the originally
     *                    drawn ones.
     *                    
     * @param markerfirst bool, default: True<br>
     *                    If <b>True</b>0, legend marker is placed to the left of the legend label.
     *                    If<b>False</b>5False*, legend marker is placed to the right of the legend label.
     *                    
     * @param frameon bool, default: :rc:`legend.frameon`<br>
     *                Whether the legend should be drawn on a patch (frame).
     *                
     * @param fancybox bool, default: :rc:`legend.fancybox`<br>
     *                 Whether round edges should be enabled around the `~.FancyBboxPatch` which
     *                 makes up the legend's background.
     *                 
     * @param shadow bool, default: :rc:`legend.shadow`<br>
     *               Whether to draw a shadow behind the legend.
     *               
     * @param framealpha float, default: :rc:`legend.framealpha`<br>
     *                   The alpha transparency of the legend's background.
     *                   If <b>shadow</b>0 is activated and<b>framealpha</b>5alpha* is ``None``, the default value is
     *                   ignored.
     *                   
     * @param facecolor "inherit" or color, default: :rc:`legend.facecolor`<br>
     *                  The legend's background color.
     *                  If ``"inherit"``, use :rc:`axes.facecolor`.
     *                  
     * @param edgecolor "inherit" or color, default: :rc:`legend.edgecolor`<br>
     *                  The legend's background patch edge color.
     *                  If ``"inherit"``, use take :rc:`axes.edgecolor`.
     *                  
     * @param mode &#123;"expand", None&#125;<br>
     *             If <b>mode</b>0 is set to ``"expand"`` the legend will be horizontally
     *             expanded to fill the axes area (or<b>bbox_to_anchor</b>5nchor* if defines
     *             the legend's size).
     *             
     * @param bbox_transform None or `matplotlib.transforms.Transform`<br>
     *                       The transform for the bounding box (<b>bbox_to_anchor</b>0). For a value
     *                       of ``None`` (default) the Axes'
     *                       :data:`~matplotlib.axes.Axes.transAxes` transform will be used.
     *                       
     * @param title str or None<br>
     *              The legend's title. Default is no title (``None``).
     *              
     * @param title_fontsize int or &#123;'xx-small', 'x-small', 'small', 'medium', 'large', 'x-large', 'xx-large'&#125;, default: :rc:`legend.title_fontsize`<br>
     *                       The font size of the legend's title.
     *                       
     * @param borderpad float, default: :rc:`legend.borderpad`<br>
     *                  The fractional whitespace inside the legend border, in font-size units.
     *                  
     * @param labelspacing float, default: :rc:`legend.labelspacing`<br>
     *                     The vertical space between the legend entries, in font-size units.
     *                     
     * @param handlelength float, default: :rc:`legend.handlelength`<br>
     *                     The length of the legend handles, in font-size units.
     *                     
     * @param handletextpad float, default: :rc:`legend.handletextpad`<br>
     *                      The pad between the legend handle and text, in font-size units.
     *                      
     * @param borderaxespad float, default: :rc:`legend.borderaxespad`<br>
     *                      The pad between the axes and legend border, in font-size units.
     *                      
     * @param columnspacing float, default: :rc:`legend.columnspacing`<br>
     *                      The spacing between columns, in font-size units.
     *                      
     * @param handler_map dict or None<br>
     *                    The custom dictionary mapping instances or types to a legend
     *                    handler. This <b>handler_map</b>0 updates the default handler map
     *                    found at `matplotlib.legend.Legend.get_legend_handler_map`.
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     * 
     * @return `~matplotlib.legend.Legend` <br>
     */
    public final Object legend(Object... args) {
        write("plt.legend("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Control behavior of major tick locators.
     * 
     * Because the locator is involved in autoscaling, `~.Axes.autoscale_view`
     * is called automatically after the parameters are changed.
     * 
     * @param axis &#123;'both', 'x', 'y'&#125;, default: 'both'<br>
     *             The axis on which to operate.
     *             
     * @param tight bool or None, optional<br>
     *              Parameter passed to `~.Axes.autoscale_view`.
     *              Default is None, for no change.
     * @param **kwargs <br>
     *                 Remaining keyword arguments are passed to directly to the
     *                 ``set_params()`` method of the locator. Supported keywords depend
     *                 on the type of the locator. See for example
     *                 `~.ticker.MaxNLocator.set_params` for the `.ticker.MaxNLocator`
     *                 used by default for linear axes.
     */
    public final Object locator_params(Object... args) {
        write("plt.locator_params("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Make a plot with log scaling on both the x and y axis.
     * 
     * Call signatures::
     * 
     * loglog([x], y, [fmt], data=None, **kwargs)
     * loglog([x], y, [fmt], [x2], y2, [fmt2], ..., **kwargs)
     * 
     * This is just a thin wrapper around `.plot` which additionally changes
     * both the x-axis and the y-axis to log scaling. All of the concepts and
     * parameters of plot can be used here as well.
     * 
     * The additional parameters <b>base</b>0,<b>subs</b>5*sub<b>nonpositive</b>10and *nonpositive* control the
     * x/y-axis properties. They are just forwarded to `.Axes.set_xscale` and
     * `.Axes.set_yscale`. To use different properties on the x-axis and the
     * y-axis, use e.g.
     * ``ax.set_xscale("log", base=10); ax.set_yscale("log", base=2)``.
     * 
     * @param base float, default: 10<br>
     *             Base of the logarithm.
     *             
     * @param subs sequence, optional<br>
     *             The location of the minor ticks. If <b>None</b>0, reasonable locations
     *             are automatically chosen depending on the number of decades in the
     *             plot. See `.Axes.set_xscale`/`.Axes.set_yscale` for details.
     *             
     * @param nonpositive &#123;'mask', 'clip'&#125;, default: 'mask'<br>
     *                    Non-positive values can be masked as invalid, or clipped to a very
     *                    small positive number.
     * @param **kwargs <br>
     *                 All parameters supported by `.plot`.
     * @param *args n/a<br>undocumented
     * 
     * @return list of `~.Line2D` <br>
     *                            Objects representing the plotted data.
     */
    public final Object loglog(Object... args) {
        write("plt.loglog("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the colormap to 'magma'.
     * 
     * This changes the default colormap as well as the colormap of the current
     * image if there is one. See ``help(colormaps)`` for more information.
     */
    public final Object magma() {
        write("plt.magma()");
        return null;
    }

    /**
     * Plot the magnitude spectrum.
     * 
     * Compute the magnitude spectrum of <b>x</b>0.  Data is padded to a
     * length of <b>pad_to</b>0 and the windowing function<b>window</b>5indow* is applied to
     * the signal.
     * <p>
     * <em>Notes:</em><br>
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * the following arguments can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception):
     * <b>x</b>0.
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param x 1-D array or sequence<br>
     *          Array or sequence containing the data.
     *          
     * @param Fs float, default: 2<br>
     *           The sampling frequency (samples per time unit).  It is used to calculate
     *           the Fourier frequencies, <b>freqs</b>0, in cycles per time unit.
     *           
     * @param window callable or ndarray, default: `.window_hanning`<br>
     *               A function or a vector of length <b>NFFT</b>0.  To create window vectors see
     *               `.window_hanning`, `.window_none`, `numpy.blackman`, `numpy.hamming`,
     *               `numpy.bartlett`, `scipy.signal`, `scipy.signal.get_window`, etc.  If a
     *               function is passed as the argument, it must take a data segment as an
     *               argument and return the windowed version of the segment.
     *               
     * @param sides &#123;'default', 'onesided', 'twosided'&#125;, optional<br>
     *              Which sides of the spectrum to return. 'default' is one-sided for real
     *              data and two-sided for complex data. 'onesided' forces the return of a
     *              one-sided spectrum, while 'twosided' forces two-sided.
     *              
     * @param pad_to int, optional<br>
     *               The number of points to which the data segment is padded when performing
     *               the FFT.  While not increasing the actual resolution of the spectrum (the
     *               minimum distance between resolvable peaks), this can give more points in
     *               the plot, allowing for more detail. This corresponds to the <b>n</b>0 parameter
     *               in the call to fft().  The default is None, which sets<b>pad_to</b>5ad_to* equal to
     *               the length of the input signal (i.e. no padding).
     *               
     * @param scale &#123;'default', 'linear', 'dB'&#125;<br>
     *              The scaling of the values in the <b>spec</b>0.  'linear' is no scaling.
     *              'dB' returns the values in dB scale, i.e., the dB amplitude
     *              (20 * log10). 'default' is 'linear'.
     *              
     * @param Fc int, default: 0<br>
     *           The center frequency of <b>x</b>0, which offsets the x extents of the
     *           plot to reflect the frequency range used when a signal is acquired
     *           and then filtered and downsampled to baseband.
     * @param **kwargs <br>
     *                 Keyword arguments control the `.Line2D` properties:
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: scalar or None
     *                 animated: bool
     *                 antialiased or aa: bool
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 color or c: color
     *                 contains: unknown
     *                 dash_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 dash_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 dashes: sequence of floats (on/off ink in points) or (None, None)
     *                 data: (2, N) array or two 1D arrays
     *                 drawstyle or ds: &#123;'default', 'steps', 'steps-pre', 'steps-mid', 'steps-post'&#125;, default: 'default'
     *                 figure: `.Figure`
     *                 fillstyle: &#123;'full', 'left', 'right', 'bottom', 'top', 'none'&#125;
     *                 gid: str
     *                 in_layout: bool
     *                 label: object
     *                 linestyle or ls: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *                 linewidth or lw: float
     *                 marker: marker style string, `~.path.Path` or `~.markers.MarkerStyle`
     *                 markeredgecolor or mec: color
     *                 markeredgewidth or mew: float
     *                 markerfacecolor or mfc: color
     *                 markerfacecoloralt or mfcalt: color
     *                 markersize or ms: float
     *                 markevery: None or int or (int, int) or slice or list[int] or float or (float, float) or list[bool]
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: float or callable[[Artist, Event], tuple[bool, dict]]
     *                 pickradius: float
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 solid_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 solid_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 transform: `matplotlib.transforms.Transform`
     *                 url: str
     *                 visible: bool
     *                 xdata: 1D array
     *                 ydata: 1D array
     *                 zorder: float
     * @param data n/a<br>undocumented
     * 
     * @return (spectrum,freqs,line) (1-D array,1-D array,`~matplotlib.lines.Line2D`)<br>
     *          The values for the magnitude spectrum before scaling (real valued).
     *          
     *          
     *          The frequencies corresponding to the elements in <b>spectrum</b>0.
     *          
     *          
     *          The line created by this function.
     */
    public final Object magnitude_spectrum(Object x, Object... args) {
        write("plt.magnitude_spectrum("+PythonGrammar.toPythonArgs(x)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set or retrieve autoscaling margins.
     * 
     * The padding added to each limit of the axes is the <b>margin</b>0
     * times the data interval. All input parameters must be floats
     * within the range [0, 1]. Passing both positional and keyword
     * arguments is invalid and will raise a TypeError. If no
     * arguments (positional or otherwise) are provided, the current
     * margins will remain in place and simply be returned.
     * 
     * Specifying any margin changes only the autoscaling; for example,
     * if <b>xmargin</b>0 is not None, then<b>xmargin</b>5argin* times the X data
     * interval will be added to each end of that interval before
     * it is used in autoscaling.
     * <p>
     * <em>Notes:</em><br>
     * If a previously used Axes method such as :meth:`pcolor` has set
     * :attr:`use_sticky_edges` to `True`, only the limits not set by
     * the "sticky artists" will be modified. To force all of the
     * margins to be set, set :attr:`use_sticky_edges` to `False`
     * before calling :meth:`margins`.
     * 
     * @param *margins float, optional<br>
     *                 If a single positional argument is provided, it specifies
     *                 both margins of the x-axis and y-axis limits. If two
     *                 positional arguments are provided, they will be interpreted
     *                 as <b>xmargin</b>0,<b>ymargin</b>5argin*. If setting the margin on a single
     *                 axis is desired, use the keyword arguments described below.
     *                 
     * @param x float, optional<br>
     *          Specific margin values for the x-axis and y-axis,
     *          respectively. These cannot be used with positional
     *          arguments, but can be used individually to alter on e.g.,
     *          only the y-axis.
     *          
     * @param y float, optional<br>
     *          Specific margin values for the x-axis and y-axis,
     *          respectively. These cannot be used with positional
     *          arguments, but can be used individually to alter on e.g.,
     *          only the y-axis.
     *          
     * @param tight bool or None, default: True<br>
     *              The <b>tight</b>0 parameter is passed to :meth:`autoscale_view`,
     *              which is executed after a margin is changed; the default
     *              here is<b>True</b>5*True*, on the assumption that when margins are
     *              specified, no additional padding to match tick marks is
     *              usually desired<b>tight</b>10re<b>None</b>15t</b>10red.  Set *tight* to *None* will preserve
     *              the previous setting.
     * 
     * @return (xmargin,ymargin) (float,float)<br>
     *          
     */
    public final Object margins(Object... args) {
        write("plt.margins("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Display an array as a matrix in a new figure window.
     * 
     * The origin is set at the upper left hand corner and rows (first
     * dimension of the array) are displayed horizontally.  The aspect
     * ratio of the figure window is that of the array, unless this would
     * make an excessively short or narrow figure.
     * 
     * Tick labels for the xaxis are placed on top.
     * 
     * @param A 2D array-like<br>
     *          The matrix to be displayed.
     *          
     * @param fignum None or int or False<br>
     *               If <b>None</b>0, create a new figure window with automatic numbering.
     *               
     *               If a nonzero integer, draw into the figure with the given number
     *               (create it if it does not exist).
     *               
     *               If 0, use the current axes (or create one if it does not exist).
     *               
     *               .. note::
     *               
     *               Because of how `.Axes.matshow` tries to set the figure aspect
     *               ratio to be the one of the array, strange things may happen if you
     *               reuse an existing figure.
     * @param **kwargs `~matplotlib.axes.Axes.imshow` arguments<br>
     * 
     * @return `~matplotlib.image.AxesImage` <br>
     */
    public final Object matshow(Object A, Object... args) {
        write("plt.matshow("+PythonGrammar.toPythonArgs(A)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Remove minor ticks from the axes.
     */
    public final Object minorticks_off() {
        write("plt.minorticks_off()");
        return null;
    }

    /**
     * Display minor ticks on the axes.
     * 
     * Displaying minor ticks may reduce performance; you may turn them off
     * using `minorticks_off()` if drawing speed is a problem.
     */
    public final Object minorticks_on() {
        write("plt.minorticks_on()");
        return null;
    }

    /**
     * Create a new figure manager instance.
     * 
     * @param num n/a<br>undocumented
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     */
    public final Object new_figure_manager(Object... args) {
        write("plt.new_figure_manager("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the colormap to 'nipy_spectral'.
     * 
     * This changes the default colormap as well as the colormap of the current
     * image if there is one. See ``help(colormaps)`` for more information.
     */
    public final Object nipy_spectral() {
        write("plt.nipy_spectral()");
        return null;
    }

    /**
     * Run the GUI event loop for <b>interval</b>0 seconds.
     * 
     * If there is an active figure, it will be updated and displayed before the
     * pause, and the GUI event loop (if any) will run during the pause.
     * 
     * This can be used for crude animation.  For more complex animation use
     * :mod:`matplotlib.animation`.
     * 
     * If there is no active figure, sleep for <b>interval</b>0 seconds instead.
     * 
     * @param interval n/a<br>undocumented
     */
    public final Object pause(Object... args) {
        write("plt.pause("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Create a pseudocolor plot with a non-regular rectangular grid.
     * 
     * Call signature::
     * 
     * pcolor([X, Y,] C, **kwargs)
     * 
     * <b>X</b>0 and<b>Y</b>5nd *Y* can be used to specify the corners of the quadrilaterals.
     * 
     * .. hint::
     * 
     * ``pcolor()`` can be very slow for large arrays. In most
     * cases you should use the similar but much faster
     * `~.Axes.pcolormesh` instead. See
     * :ref:`Differences between pcolor() and pcolormesh()
     * <differences-pcolor-pcolormesh>` for a discussion of the
     * differences.
     * <p>
     * <em>Notes:</em><br>
     * **Masked arrays**
     * 
     * <b>X</b>0,<b>Y</b>50, *<b>C</b>10b>50, *Y* and *C* may be masked arrays. If either ``C[i, j]``, or one
     * of the vertices surrounding ``C[i, j]`` (<b>X</b>0 or<b>Y</b>5or *Y* at
     * ``[i, j], [i+1, j], [i, j+1], [i+1, j+1]``) is masked, nothing is
     * plotted.
     * 
     * .. _axes-pcolor-grid-orientation:
     * 
     * **Grid orientation**
     * 
     * The grid orientation follows the standard matrix convention: An array
     * <b>C</b>0 with shape (nrows, ncolumns) is plotted with the column number as
     * <b>X</b>0 and the row number as<b>Y</b>5as *Y*.
     * 
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * every other argument can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception).
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param C 2D array-like<br>
     *          The color-mapped values.
     *          
     * @param X array-like, optional<br>
     *          The coordinates of the corners of quadrilaterals of a pcolormesh::
     *          
     *          (X[i+1, j], Y[i+1, j])       (X[i+1, j+1], Y[i+1, j+1])
     *          +-----+
     *          |     |
     *          +-----+
     *          (X[i, j], Y[i, j])       (X[i, j+1], Y[i, j+1])
     *          
     *          Note that the column index corresponds to the x-coordinate, and
     *          the row index corresponds to y. For details, see the
     *          :ref:`Notes &lt;axes-pcolormesh-grid-orientation&gt;` section below.
     *          
     *          If ``shading='flat'`` the dimensions of <b>X</b>0 and<b>Y</b>5nd *Y* should be one
     *          greater than th<b>C</b>10than those of *C*, and the quadrilateral is colored due
     *          to the value a<b>X</b>15<b>Y</b>20val<b>C</b>25b>X</b>15<b>Y</b>20value a<b>X</b>15 the value at ``C[i, j]``.  If *X*, *Y* and *C* have equal
     *         <b>C</b>30 have equal
     *          dimensions, a warning will be raised and the last row and column
<b>X</b>35sed<b>Y</b>40the last row and column
<b>X</b>35sed and the <b>C</b>45last row and column
<b>X</b>35sed and the last row and column
     *          of *C* will be ignored.
     *          
     *          If ``shading='nearest<b>X</b>50      <b>Y</b>55    *          If ``shading='nearest<b>X</b>50         
     *          If ``shading='nearest'``, the dimensions of *X* and *Y* should be
     *          the same as those of *C* (if not, a ValueError will be raised). The
     *          color ``C[i, j]`` will be centered on ``(X[i, j], Y[i, j])``.
     *          
     *          If *X* and/or *Y* are 1-D arrays or column vectors they will be
     *          expanded as needed into the appropriate 2D arrays, making a
     *          rectangular grid.
     *          
     * @param Y array-like, optional<br>
     *          The coordinates of the corners of quadrilaterals of a pcolormesh::
     *          
     *          (X[i+1, j], Y[i+1, j])       (X[i+1, j+1], Y[i+1, j+1])
     *          +-----+
     *          |     |
     *          +-----+
     *          (X[i, j], Y[i, j])       (X[i, j+1], Y[i, j+1])
     *          
     *          Note that the column index corresponds to the x-coordinate, and
     *          the row index corresponds to y. For details, see the
     *          :ref:`Notes &lt;axes-pcolormesh-grid-orientation&gt;` section below.
     *          
     *          If ``shading='flat'`` the dimensions of <b>X</b>0 and<b>Y</b>5nd *Y* should be one
     *          greater than th<b>C</b>10than those of *C*, and the quadrilateral is colored due
     *          to the value a<b>X</b>15<b>Y</b>20val<b>C</b>25b>X</b>15<b>Y</b>20value a<b>X</b>15 the value at ``C[i, j]``.  If *X*, *Y* and *C* have equal
     *         <b>C</b>30 have equal
     *          dimensions, a warning will be raised and the last row and column
<b>X</b>35sed<b>Y</b>40the last row and column
<b>X</b>35sed and the <b>C</b>45last row and column
<b>X</b>35sed and the last row and column
     *          of *C* will be ignored.
     *          
     *          If ``shading='nearest<b>X</b>50      <b>Y</b>55    *          If ``shading='nearest<b>X</b>50         
     *          If ``shading='nearest'``, the dimensions of *X* and *Y* should be
     *          the same as those of *C* (if not, a ValueError will be raised). The
     *          color ``C[i, j]`` will be centered on ``(X[i, j], Y[i, j])``.
     *          
     *          If *X* and/or *Y* are 1-D arrays or column vectors they will be
     *          expanded as needed into the appropriate 2D arrays, making a
     *          rectangular grid.
     *          
     * @param shading &#123;'flat', 'nearest', 'auto'&#125;, optional<br>
     *                The fill style for the quadrilateral; defaults to 'flat' or
     *                :rc:`pcolor.shading`. Possible values:
     *                
     *                - 'flat': A solid color is used for each quad. The color of the
     *                quad (i, j), (i+1, j), (i, j+1), (i+1, j+1) is given by
     *                ``C[i, j]``. The dimensions of <b>X</b>0 and<b>Y</b>5nd *Y* should be
     *                one greater than th<b>C</b>10than those of *C*; if th<b>C</b>15f *C*; if they are the same as *C*,
     *                then a deprecation warning is raised, and the last row
<b>C</b>20and the last row
     *                and column of *C* are dropped.
     *                - 'nearest': Each grid point will have a color centered on it,
     *                extending halfway between the adjace<b>X</b>25way<b>Y</b>30een the adjace<b>X<<b>C</b>35way<b>Y</b>30een the adjace<b>X</b>25way between the adjacent g<b>X</b>40e<b<b>Y</b>45>25way between the adjacent g<b>X</b>40e<<b>C</b>50</b>45>25way between the adjacent g<b>X</b>40e<b>X</b>25way between the adjacent grid centers.  The
     *                dimensions of *X* and *Y* must be the same as *C*.
     *                - 'auto': Choose 'flat' if dimensions of *X* and *Y* are one
     *                larger than *C*.  Choose 'nearest' if dimensions are the same.
     *                
     *                See :doc:`/gallery/images_contours_and_fields/pcolormesh_grids`
     *                for more description.
     *                
     * @param cmap str or `~matplotlib.colors.Colormap`, default: :rc:`image.cmap`<br>
     *             A Colormap instance or registered colormap name. The colormap
     *             maps the <b>C</b>0 values to colors.
     *             
     * @param norm `~matplotlib.colors.Normalize`, optional<br>
     *             The Normalize instance scales the data values to the canonical
     *             colormap range [0, 1] for mapping to colors. By default, the data
     *             range is mapped to the colorbar range using linear scaling.
     *             
     * @param vmin float, default: None<br>
     *             The colorbar range. If <b>None</b>0, suitable min/max values are
     *             automatically chosen by the `~.Normalize` instance (defaults to
     *             the respective min/max values of<b>C</b>5of *C* in case of the default linear
     *             scaling).
     *             It is deprecated <b>vmin</b>1<b>vmax</b>15vmin<b>norm</b>20vmax</b>15vmin</b>10ted to use *vmin*/*vmax* when *norm* is given.
     *             
     * @param vmax float, default: None<br>
     *             The colorbar range. If <b>None</b>0, suitable min/max values are
     *             automatically chosen by the `~.Normalize` instance (defaults to
     *             the respective min/max values of<b>C</b>5of *C* in case of the default linear
     *             scaling).
     *             It is deprecated <b>vmin</b>1<b>vmax</b>15vmin<b>norm</b>20vmax</b>15vmin</b>10ted to use *vmin*/*vmax* when *norm* is given.
     *             
     * @param edgecolors &#123;'none', None, 'face', color, color sequence&#125;, optional<br>
     *                   The color of the edges. Defaults to 'none'. Possible values:
     *                   
     *                   - 'none' or '': No edge.
     *                   - <b>None</b>0: :rc:`patch.edgecolor` will be used. Note that currently
     *                   :rc:`patch.force_edgecolor` has to be True for this to work.
     *                   - 'face': Use the adjacent face color.
     *                   - A color or sequence of colors will set the edge color.
     *                   
     *                   The singular form<b>edgecolor</b>5color* works as an alias.
     *                   
     * @param alpha float, default: None<br>
     *              The alpha blending value of the face color, between 0 (transparent)
     *              and 1 (opaque). Note: The edgecolor is currently not affected by
     *              this.
     *              
     * @param snap bool, default: False<br>
     *             Whether to snap the mesh to pixel boundaries.
     * @param antialiaseds bool, default: False<br>
     *                     The default <b>antialiaseds</b>0 is False if the default
     *                    <b>edgecolors</b>5olors*\ ="none" is used.  This eliminates artificial lines
     *                     at patch boundaries, and works regardless of the value of alpha.
     *                 <b>edgecolors</b>10  If *edgecolors* is not "none"<b>antialiaseds</b>15", then the default *antialiaseds*
     *                     is taken from :rc:`patch.antialiased`.
     *                     Str<b>alpha</b>20          Stroking the edges may be preferred if *alpha* is 1, but will
     *                     cause artifacts otherwise.
     *                     
     * @param **kwargs <br>
     *                 Additionally, the following arguments are allowed. They are passed
     *                 along to the `~matplotlib.collections.PolyCollection` constructor:
     *                 
     * @param Properties <br>
     *                   agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                   alpha: array-like or scalar or None
     *                   animated: bool
     *                   antialiased or aa or antialiaseds: bool or list of bools
     *                   array: ndarray or None
     *                   capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                   clim: (vmin: float, vmax: float)
     *                   clip_box: `.Bbox`
     *                   clip_on: bool
     *                   clip_path: Patch or (Path, Transform) or None
     *                   cmap: `.Colormap` or str or None
     *                   color: color or list of rgba tuples
     *                   contains: unknown
     *                   edgecolor or ec or edgecolors: color or list of colors or 'face'
     *                   facecolor or facecolors or fc: color or list of colors
     *                   figure: `.Figure`
     *                   gid: str
     *                   hatch: &#123;'/', '\\', '|', '-', '+', 'x', 'o', 'O', '.', '*'&#125;
     *                   in_layout: bool
     *                   joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                   label: object
     *                   linestyle or dashes or linestyles or ls: str or tuple or list thereof
     *                   linewidth or linewidths or lw: float or list of floats
     *                   norm: `.Normalize` or None
     *                   offset_position: unknown
     *                   offsets: (N, 2) or (2,) array-like
     *                   path_effects: `.AbstractPathEffect`
     *                   picker: None or bool or float or callable
     *                   pickradius: float
     *                   rasterized: bool
     *                   sketch_params: (scale: float, length: float, randomness: float)
     *                   snap: bool or None
     *                   transform: `.Transform`
     *                   url: str
     *                   urls: list of str or None
     *                   visible: bool
     *                   zorder: float
     * @param *args n/a<br>undocumented
     * @param data n/a<br>undocumented
     * 
     * @return `matplotlib.collections.Collection` <br>
     */
    public final Object pcolor(Object... args) {
        write("plt.pcolor("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Create a pseudocolor plot with a non-regular rectangular grid.
     * 
     * Call signature::
     * 
     * pcolormesh([X, Y,] C, **kwargs)
     * 
     * <b>X</b>0 and<b>Y</b>5nd *Y* can be used to specify the corners of the quadrilaterals.
     * 
     * .. hint::
     * 
     * `~.Axes.pcolormesh` is similar to `~.Axes.pcolor`. It is much faster
     * and preferred in most cases. For a detailed discussion on the
     * differences see :ref:`Differences between pcolor() and pcolormesh()
     * <differences-pcolor-pcolormesh>`.
     * <p>
     * <em>Notes:</em><br>
     * **Masked arrays**
     * 
     * <b>C</b>0 may be a masked array. If ``C[i, j]`` is masked, the corresponding
     * quadrilateral will be transparent. Masking of <b>X</b>0 and<b>Y</b>5nd *Y* is not
     * supported. Use `~.Axes.pcolor` if you need this functionality.
     * 
     * .. _axes-pcolormesh-grid-orientation:
     * 
     * **Grid orientation**
     * 
     * The grid orientation follows the standard matrix convention: An array
     * <b>C</b>0 with shape (nrows, ncolumns) is plotted with the column number as
     * <b>X</b>0 and the row number as<b>Y</b>5as *Y*.
     * 
     * .. _differences-pcolor-pcolormesh:
     * 
     * **Differences between pcolor() and pcolormesh()**
     * 
     * Both methods are used to create a pseudocolor plot of a 2D array
     * using quadrilaterals.
     * 
     * The main difference lies in the created object and internal data
     * handling:
     * While `~.Axes.pcolor` returns a `.PolyCollection`, `~.Axes.pcolormesh`
     * returns a `.QuadMesh`. The latter is more specialized for the given
     * purpose and thus is faster. It should almost always be preferred.
     * 
     * There is also a slight difference in the handling of masked arrays.
     * Both `~.Axes.pcolor` and `~.Axes.pcolormesh` support masked arrays
     * for <b>C</b>0. However, only `~.Axes.pcolor` supports masked arrays for<b>X</b>5or *X*
     * and <b>Y</b>0. The reason lies in the internal handling of the masked values.
     * `~.Axes.pcolor` leaves out the respective polygons from the
     * PolyCollection. `~.Axes.pcolormesh` sets the facecolor of the masked
     * elements to transparent. You can see the difference when using
     * edgecolors. While all edges are drawn irrespective of masking in a
     * QuadMesh, the edge between two adjacent masked quadrilaterals in
     * `~.Axes.pcolor` is not drawn as the corresponding polygons do not
     * exist in the PolyCollection.
     * 
     * Another difference is the support of Gouraud shading in
     * `~.Axes.pcolormesh`, which is not available with `~.Axes.pcolor`.
     * 
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * every other argument can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception).
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param C 2D array-like<br>
     *          The color-mapped values.
     *          
     * @param X array-like, optional<br>
     *          The coordinates of the corners of quadrilaterals of a pcolormesh::
     *          
     *          (X[i+1, j], Y[i+1, j])       (X[i+1, j+1], Y[i+1, j+1])
     *          +-----+
     *          |     |
     *          +-----+
     *          (X[i, j], Y[i, j])       (X[i, j+1], Y[i, j+1])
     *          
     *          Note that the column index corresponds to the x-coordinate, and
     *          the row index corresponds to y. For details, see the
     *          :ref:`Notes &lt;axes-pcolormesh-grid-orientation&gt;` section below.
     *          
     *          If ``shading='flat'`` the dimensions of <b>X</b>0 and<b>Y</b>5nd *Y* should be one
     *          greater than th<b>C</b>10than those of *C*, and the quadrilateral is colored due
     *          to the value a<b>X</b>15<b>Y</b>20val<b>C</b>25b>X</b>15<b>Y</b>20value a<b>X</b>15 the value at ``C[i, j]``.  If *X*, *Y* and *C* have equal
     *         <b>C</b>30 have equal
     *          dimensions, a warning will be raised and the last row and column
     *          o<b>X</b>35row and column
    <b>Y</b>40       o<b>X</b>35row and colu<b>C</b>45  <b>Y</b>40       o<b>X</b>35row and column
     *          of *C* will be ignored.
     *          
     *          If ``shading='nearest'`` or ``'gouraud'``, the dimensions of *X*
     *          and *Y* should be the same as those of *C* (if not, a ValueError
     *          will be raised<b>X</b>50ot, a <b>Y</b>55Error
     *          will be raised<b>X</b>50ot, a ValueError
     *          will be raised).  For ``'nearest'`` the color ``C[i, j]`` is
     *          centered on ``(X[i, j], Y[i, j])``.  For ``'gouraud'``, a smooth
     *          interpolation is caried out between the quadrilateral corners.
     *          
     *          If *X* and/or *Y* are 1-D arrays or column vectors they will be
     *          expanded as needed into the appropriate 2D arrays, making a
     *          rectangular grid.
     *          
     * @param Y array-like, optional<br>
     *          The coordinates of the corners of quadrilaterals of a pcolormesh::
     *          
     *          (X[i+1, j], Y[i+1, j])       (X[i+1, j+1], Y[i+1, j+1])
     *          +-----+
     *          |     |
     *          +-----+
     *          (X[i, j], Y[i, j])       (X[i, j+1], Y[i, j+1])
     *          
     *          Note that the column index corresponds to the x-coordinate, and
     *          the row index corresponds to y. For details, see the
     *          :ref:`Notes &lt;axes-pcolormesh-grid-orientation&gt;` section below.
     *          
     *          If ``shading='flat'`` the dimensions of <b>X</b>0 and<b>Y</b>5nd *Y* should be one
     *          greater than th<b>C</b>10than those of *C*, and the quadrilateral is colored due
     *          to the value a<b>X</b>15<b>Y</b>20val<b>C</b>25b>X</b>15<b>Y</b>20value a<b>X</b>15 the value at ``C[i, j]``.  If *X*, *Y* and *C* have equal
     *         <b>C</b>30 have equal
     *          dimensions, a warning will be raised and the last row and column
     *          o<b>X</b>35row and column
    <b>Y</b>40       o<b>X</b>35row and colu<b>C</b>45  <b>Y</b>40       o<b>X</b>35row and column
     *          of *C* will be ignored.
     *          
     *          If ``shading='nearest'`` or ``'gouraud'``, the dimensions of *X*
     *          and *Y* should be the same as those of *C* (if not, a ValueError
     *          will be raised<b>X</b>50ot, a <b>Y</b>55Error
     *          will be raised<b>X</b>50ot, a ValueError
     *          will be raised).  For ``'nearest'`` the color ``C[i, j]`` is
     *          centered on ``(X[i, j], Y[i, j])``.  For ``'gouraud'``, a smooth
     *          interpolation is caried out between the quadrilateral corners.
     *          
     *          If *X* and/or *Y* are 1-D arrays or column vectors they will be
     *          expanded as needed into the appropriate 2D arrays, making a
     *          rectangular grid.
     *          
     * @param cmap str or `~matplotlib.colors.Colormap`, default: :rc:`image.cmap`<br>
     *             A Colormap instance or registered colormap name. The colormap
     *             maps the <b>C</b>0 values to colors.
     *             
     * @param norm `~matplotlib.colors.Normalize`, optional<br>
     *             The Normalize instance scales the data values to the canonical
     *             colormap range [0, 1] for mapping to colors. By default, the data
     *             range is mapped to the colorbar range using linear scaling.
     *             
     * @param vmin float, default: None<br>
     *             The colorbar range. If <b>None</b>0, suitable min/max values are
     *             automatically chosen by the `~.Normalize` instance (defaults to
     *             the respective min/max values of<b>C</b>5of *C* in case of the default linear
     *             scaling).
     *             It is deprecated <b>vmin</b>1<b>vmax</b>15vmin<b>norm</b>20vmax</b>15vmin</b>10ted to use *vmin*/*vmax* when *norm* is given.
     *             
     * @param vmax float, default: None<br>
     *             The colorbar range. If <b>None</b>0, suitable min/max values are
     *             automatically chosen by the `~.Normalize` instance (defaults to
     *             the respective min/max values of<b>C</b>5of *C* in case of the default linear
     *             scaling).
     *             It is deprecated <b>vmin</b>1<b>vmax</b>15vmin<b>norm</b>20vmax</b>15vmin</b>10ted to use *vmin*/*vmax* when *norm* is given.
     *             
     * @param edgecolors &#123;'none', None, 'face', color, color sequence&#125;, optional<br>
     *                   The color of the edges. Defaults to 'none'. Possible values:
     *                   
     *                   - 'none' or '': No edge.
     *                   - <b>None</b>0: :rc:`patch.edgecolor` will be used. Note that currently
     *                   :rc:`patch.force_edgecolor` has to be True for this to work.
     *                   - 'face': Use the adjacent face color.
     *                   - A color or sequence of colors will set the edge color.
     *                   
     *                   The singular form<b>edgecolor</b>5color* works as an alias.
     *                   
     * @param alpha float, default: None<br>
     *              The alpha blending value, between 0 (transparent) and 1 (opaque).
     *              
     * @param shading &#123;'flat', 'nearest', 'gouraud', 'auto'&#125;, optional<br>
     *                The fill style for the quadrilateral; defaults to
     *                'flat' or :rc:`pcolor.shading`. Possible values:
     *                
     *                - 'flat': A solid color is used for each quad. The color of the
     *                quad (i, j), (i+1, j), (i, j+1), (i+1, j+1) is given by
     *                ``C[i, j]``. The dimensions of <b>X</b>0 and<b>Y</b>5nd *Y* should be
     *                one greater than th<b>C</b>10than those of *C*; if th<b>C</b>15f *C*; if they are the same as *C*,
     *                then a deprecation warning is raised, and the last row
<b>C</b>20and the last row
     *                and column of *C* are dropped.
     *                - 'nearest': Each grid point will have a color centered on it,
     *                extending halfway between the adjace<b>X</b>25way<b>Y</b>30een the adjace<b>X<<b>C</b>35way<b>Y</b>30een the adjace<b>X</b>25way between the adjacent grid centers.  The
     *                dimensions of *X* and *Y* must be the same as *C*.
     *                - 'gouraud': Each quad will be Gouraud shaded: The color of the
     *                corners (i', j') are given by ``C<b>X</b>40   <b>Y</b>45ers (i', j') are gi<b>C</b>50y ``C<b>X</b>40   <b>Y</b>45ers (i', j') are given b<b>edgecolors</b>55</b>40   <b>Y</b>45ers (i', j') are given by ``C<b>X</b>40    corners (i',<b>X</b>6045e<b>Y</b>65', j') are given by ``C<b>X</b>40    corn<b>C</b>70i',<b>X</b>6045e<b>Y</b>65', j') are given by ``C<b>X</b>40    corners (i',<b>X</b>6045ers (i', j') are given by ``C<b>X</b>40    corners (i', j') are given by ``C[i', j']``. The color values of
     *                the area in between is interpolated from the corner values.
     *                The dimensions of *X* and *Y* must be the same as *C*. When
     *                Gouraud shading is used, *edgecolors* is ignored.
     *                - 'auto': Choose 'flat' if dimensions of *X* and *Y* are one
     *                larger than *C*.  Choose 'nearest' if dimensions are the same.
     *                
     *                See :doc:`/gallery/images_contours_and_fields/pcolormesh_grids`
     *                for more description.
     *                
     * @param snap bool, default: False<br>
     *             Whether to snap the mesh to pixel boundaries.
     *             
     * @param rasterized bool, optional<br>
     *                   Rasterize the pcolormesh when drawing vector graphics.  This can
     *                   speed up rendering and produce smaller files for large data sets.
     *                   See also :doc:`/gallery/misc/rasterization_demo`.
     * @param **kwargs <br>
     *                 Additionally, the following arguments are allowed. They are passed
     *                 along to the `~matplotlib.collections.QuadMesh` constructor:
     *                 
     * @param Properties <br>
     *                   agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                   alpha: array-like or scalar or None
     *                   animated: bool
     *                   antialiased or aa or antialiaseds: bool or list of bools
     *                   array: ndarray or None
     *                   capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                   clim: (vmin: float, vmax: float)
     *                   clip_box: `.Bbox`
     *                   clip_on: bool
     *                   clip_path: Patch or (Path, Transform) or None
     *                   cmap: `.Colormap` or str or None
     *                   color: color or list of rgba tuples
     *                   contains: unknown
     *                   edgecolor or ec or edgecolors: color or list of colors or 'face'
     *                   facecolor or facecolors or fc: color or list of colors
     *                   figure: `.Figure`
     *                   gid: str
     *                   hatch: &#123;'/', '\\', '|', '-', '+', 'x', 'o', 'O', '.', '*'&#125;
     *                   in_layout: bool
     *                   joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                   label: object
     *                   linestyle or dashes or linestyles or ls: str or tuple or list thereof
     *                   linewidth or linewidths or lw: float or list of floats
     *                   norm: `.Normalize` or None
     *                   offset_position: unknown
     *                   offsets: (N, 2) or (2,) array-like
     *                   path_effects: `.AbstractPathEffect`
     *                   picker: None or bool or float or callable
     *                   pickradius: float
     *                   rasterized: bool
     *                   sketch_params: (scale: float, length: float, randomness: float)
     *                   snap: bool or None
     *                   transform: `.Transform`
     *                   url: str
     *                   urls: list of str or None
     *                   visible: bool
     *                   zorder: float
     * @param *args n/a<br>undocumented
     * @param antialiased n/a<br>undocumented
     * @param data n/a<br>undocumented
     * 
     * @return `matplotlib.collections.QuadMesh` <br>
     */
    public final Object pcolormesh(Object... args) {
        write("plt.pcolormesh("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Plot the phase spectrum.
     * 
     * Compute the phase spectrum (unwrapped angle spectrum) of <b>x</b>0.
     * Data is padded to a length of <b>pad_to</b>0 and the windowing function
     * <b>window</b>0 is applied to the signal.
     * <p>
     * <em>Notes:</em><br>
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * the following arguments can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception):
     * <b>x</b>0.
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param x 1-D array or sequence<br>
     *          Array or sequence containing the data
     *          
     * @param Fs float, default: 2<br>
     *           The sampling frequency (samples per time unit).  It is used to calculate
     *           the Fourier frequencies, <b>freqs</b>0, in cycles per time unit.
     *           
     * @param window callable or ndarray, default: `.window_hanning`<br>
     *               A function or a vector of length <b>NFFT</b>0.  To create window vectors see
     *               `.window_hanning`, `.window_none`, `numpy.blackman`, `numpy.hamming`,
     *               `numpy.bartlett`, `scipy.signal`, `scipy.signal.get_window`, etc.  If a
     *               function is passed as the argument, it must take a data segment as an
     *               argument and return the windowed version of the segment.
     *               
     * @param sides &#123;'default', 'onesided', 'twosided'&#125;, optional<br>
     *              Which sides of the spectrum to return. 'default' is one-sided for real
     *              data and two-sided for complex data. 'onesided' forces the return of a
     *              one-sided spectrum, while 'twosided' forces two-sided.
     *              
     * @param pad_to int, optional<br>
     *               The number of points to which the data segment is padded when performing
     *               the FFT.  While not increasing the actual resolution of the spectrum (the
     *               minimum distance between resolvable peaks), this can give more points in
     *               the plot, allowing for more detail. This corresponds to the <b>n</b>0 parameter
     *               in the call to fft().  The default is None, which sets<b>pad_to</b>5ad_to* equal to
     *               the length of the input signal (i.e. no padding).
     *               
     * @param Fc int, default: 0<br>
     *           The center frequency of <b>x</b>0, which offsets the x extents of the
     *           plot to reflect the frequency range used when a signal is acquired
     *           and then filtered and downsampled to baseband.
     * @param **kwargs <br>
     *                 Keyword arguments control the `.Line2D` properties:
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: scalar or None
     *                 animated: bool
     *                 antialiased or aa: bool
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 color or c: color
     *                 contains: unknown
     *                 dash_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 dash_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 dashes: sequence of floats (on/off ink in points) or (None, None)
     *                 data: (2, N) array or two 1D arrays
     *                 drawstyle or ds: &#123;'default', 'steps', 'steps-pre', 'steps-mid', 'steps-post'&#125;, default: 'default'
     *                 figure: `.Figure`
     *                 fillstyle: &#123;'full', 'left', 'right', 'bottom', 'top', 'none'&#125;
     *                 gid: str
     *                 in_layout: bool
     *                 label: object
     *                 linestyle or ls: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *                 linewidth or lw: float
     *                 marker: marker style string, `~.path.Path` or `~.markers.MarkerStyle`
     *                 markeredgecolor or mec: color
     *                 markeredgewidth or mew: float
     *                 markerfacecolor or mfc: color
     *                 markerfacecoloralt or mfcalt: color
     *                 markersize or ms: float
     *                 markevery: None or int or (int, int) or slice or list[int] or float or (float, float) or list[bool]
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: float or callable[[Artist, Event], tuple[bool, dict]]
     *                 pickradius: float
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 solid_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 solid_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 transform: `matplotlib.transforms.Transform`
     *                 url: str
     *                 visible: bool
     *                 xdata: 1D array
     *                 ydata: 1D array
     *                 zorder: float
     * @param data n/a<br>undocumented
     * 
     * @return (spectrum,freqs,line) (1-D array,1-D array,`~matplotlib.lines.Line2D`)<br>
     *          The values for the phase spectrum in radians (real valued).
     *          
     *          
     *          The frequencies corresponding to the elements in <b>spectrum</b>0.
     *          
     *          
     *          The line created by this function.
     */
    public final Object phase_spectrum(Object x, Object... args) {
        write("plt.phase_spectrum("+PythonGrammar.toPythonArgs(x)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Plot a pie chart.
     * 
     * Make a pie chart of array <b>x</b>0.  The fractional area of each wedge is
     * given by ``x/sum(x)``.  If ``sum(x) < 1``, then the values of <b>x</b>0 give
     * the fractional area directly and the array will not be normalized. The
     * resulting pie will have an empty wedge of size ``1 - sum(x)``.
     * 
     * The wedges are plotted counterclockwise, by default starting from the
     * x-axis.
     * <p>
     * <em>Notes:</em><br>
     * The pie chart will probably look best if the figure and Axes are
     * square, or the Axes aspect is equal.
     * This method sets the aspect ratio of the axis to "equal".
     * The Axes aspect ratio can be controlled with `.Axes.set_aspect`.
     * 
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * the following arguments can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception):
     * <b>x</b>0,<b>explode</b>5p<b>labels</b>10<b>colors</b>15s</b>105plode*, *labels*, *colors*.
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param x 1D array-like<br>
     *          The wedge sizes.
     *          
     * @param explode array-like, default: None<br>
     *                If not <b>None</b>0, is a ``len(x)`` array which specifies the fraction
     *                of the radius with which to offset each wedge.
     *                
     * @param labels list, default: None<br>
     *               A sequence of strings providing the labels for each wedge
     *               
     * @param colors array-like, default: None<br>
     *               A sequence of colors through which the pie chart will cycle.  If
     *               <b>None</b>0, will use the colors in the currently active cycle.
     *               
     * @param autopct None or str or callable, default: None<br>
     *                If not <b>None</b>0, is a string or function used to label the wedges
     *                with their numeric value.  The label will be placed inside the
     *                wedge.  If it is a format string, the label will be ``fmt % pct``.
     *                If it is a function, it will be called.
     *                
     * @param pctdistance float, default: 0.6<br>
     *                    The ratio between the center of each pie slice and the start of
     *                    the text generated by <b>autopct</b>0.  Ignored if<b>autopct</b>5top<b>None</b>105topct* is *None*.
     *                    
     * @param shadow bool, default: False<br>
     *               Draw a shadow beneath the pie.
     *               
     * @param normalize None or bool, default: None<br>
     *                  When <b>True</b>0, always make a full pie by normalizing x so that
     *                  ``sum(x) == 1``.<b>False</b>5False* makes a partial pie if ``sum(x) &lt;= 1``
     *                  and raises a `ValueError` for ``sum(x) &gt; 1``.
     *                  
     *                <b>None</b>10      When *<b>True</b>15   When *None*, defaults <b>False</b>20e*, defaults to *True* if ``sum(x) &gt;= 1`` and *False* if
     *                  ``sum(x) &lt; 1``.
     *                  
     *       <b>None</b>25     
     *                  Please note that the previous default value<b>True</b>30e previous default value of *None* is now
     *                  deprecated, and the default will change to *True* in the next
     *                  release. Please pass ``normalize=False`` explicitly if you want to
     *                  draw a partial pie.
     *                  
     * @param labeldistance float or None, default: 1.1<br>
     *                      The radial distance at which the pie labels are drawn.
     *                      If set to ``None``, label are not drawn, but are stored for use in
     *                      ``legend()``
     *                      
     * @param startangle float, default: 0 degrees<br>
     *                   The angle by which the start of the pie is rotated,
     *                   counterclockwise from the x-axis.
     *                   
     * @param radius float, default: 1<br>
     *               The radius of the pie.
     *               
     * @param counterclock bool, default: True<br>
     *                     Specify fractions direction, clockwise or counterclockwise.
     *                     
     * @param wedgeprops dict, default: None<br>
     *                   Dict of arguments passed to the wedge objects making the pie.
     *                   For example, you can pass in ``wedgeprops = &#123;'linewidth': 3&#125;``
     *                   to set the width of the wedge border lines equal to 3.
     *                   For more details, look at the doc/arguments of the wedge object.
     *                   By default ``clip_on=False``.
     *                   
     * @param textprops dict, default: None<br>
     *                  Dict of arguments to pass to the text objects.
     *                  
     * @param center (float, float), default: (0, 0)<br>
     *               The coordinates of the center of the chart.
     *               
     * @param frame bool, default: False<br>
     *              Plot Axes frame with the chart if true.
     *              
     * @param rotatelabels bool, default: False<br>
     *                     Rotate each label to the angle of the corresponding slice if true.
     * @param data n/a<br>undocumented
     * 
     * @return (patches,texts,autotexts) (list,list,list)<br>
     *          A sequence of `matplotlib.patches.Wedge` instances
     *          
     *          
     *          A list of the label `.Text` instances.
     *          
     *          
     *          A list of `.Text` instances for the numeric labels. This will only
     *          be returned if the parameter <b>autopct</b>0 is not<b>None</b>5*None*.
     */
    public final Object pie(Object x, Object... args) {
        write("plt.pie("+PythonGrammar.toPythonArgs(x)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the colormap to 'pink'.
     * 
     * This changes the default colormap as well as the colormap of the current
     * image if there is one. See ``help(colormaps)`` for more information.
     */
    public final Object pink() {
        write("plt.pink()");
        return null;
    }

    /**
     * Set the colormap to 'plasma'.
     * 
     * This changes the default colormap as well as the colormap of the current
     * image if there is one. See ``help(colormaps)`` for more information.
     */
    public final Object plasma() {
        write("plt.plasma()");
        return null;
    }

    /**
     * Plot y versus x as lines and/or markers.
     * 
     * Call signatures::
     * 
     * plot([x], y, [fmt], *, data=None, **kwargs)
     * plot([x], y, [fmt], [x2], y2, [fmt2], ..., **kwargs)
     * 
     * The coordinates of the points or line nodes are given by <b>x</b>0,<b>y</b>50, *y*.
     * 
     * The optional parameter <b>fmt</b>0 is a convenient way for defining basic
     * formatting like color, marker and linestyle. It's a shortcut string
     * notation described in the <b>Notes</b>0 section below.
     * 
     * >>> plot(x, y)        # plot x and y using default line style and color
     * >>> plot(x, y, 'bo')  # plot x and y using blue circle markers
     * >>> plot(y)           # plot y using x as index array 0..N-1
     * >>> plot(y, 'r+')     # ditto, but with red plusses
     * 
     * You can use `.Line2D` properties as keyword arguments for more
     * control on the appearance. Line properties and <b>fmt</b>0 can be mixed.
     * The following two calls yield identical results:
     * 
     * >>> plot(x, y, 'go--', linewidth=2, markersize=12)
     * >>> plot(x, y, color='green', marker='o', linestyle='dashed',
     * ...      linewidth=2, markersize=12)
     * 
     * When conflicting with <b>fmt</b>0, keyword arguments take precedence.
     * 
     * 
     * **Plotting labelled data**
     * 
     * There's a convenient way for plotting objects with labelled data (i.e.
     * data that can be accessed by index ``obj['y']``). Instead of giving
     * the data in <b>x</b>0 and<b>y</b>5nd *y*, you can provide the object <b>data</b>10ect in the *data*
     * parameter and just give the labels for <b>x</b>0 and<b>y</b>5nd *y*::
     * 
     * >>> plot('xlabel', 'ylabel', data=obj)
     * 
     * All indexable objects are supported. This could e.g. be a `dict`, a
     * `pandas.DataFrame` or a structured numpy array.
     * 
     * 
     * **Plotting multiple sets of data**
     * 
     * There are various ways to plot multiple sets of data.
     * 
     * - The most straight forward way is just to call `plot` multiple times.
     * Example:
     * 
     * >>> plot(x1, y1, 'bo')
     * >>> plot(x2, y2, 'go')
     * 
     * - If <b>x</b>0 and/or<b>y</b>5or *y* are 2D arrays a separate data set will be drawn
     * for every column. If both <b>x</b>0 and<b>y</b>5nd *y* are 2D, they must have the
     * same shape. If only one of them is 2D with shape (N, m) the other
     * must have length N and will be used for every data set m.
     * 
     * Example:
     * 
     * >>> x = [1, 2, 3]
     * >>> y = np.array([[1, 2], [3, 4], [5, 6]])
     * >>> plot(x, y)
     * 
     * is equivalent to:
     * 
     * >>> for col in range(y.shape[1]):
     * ...     plot(x, y[:, col])
     * 
     * - The third way is to specify multiple sets of *[x]*, <b>y</b>0, *[fmt]*
     * groups::
     * 
     * >>> plot(x1, y1, 'g^', x2, y2, 'g-')
     * 
     * In this case, any additional keyword argument applies to all
     * datasets. Also this syntax cannot be combined with the <b>data</b>0
     * parameter.
     * 
     * By default, each line is assigned a different style specified by a
     * 'style cycle'. The <b>fmt</b>0 and line property parameters are only
     * necessary if you want explicit deviations from these defaults.
     * Alternatively, you can also change the style cycle using
     * :rc:`axes.prop_cycle`.
     * <p>
     * <em>Notes:</em><br>
     * **Format Strings**
     * 
     * A format string consists of a part for color, marker and line::
     * 
     * fmt = '[marker][line][color]'
     * 
     * Each of them is optional. If not provided, the value from the style
     * cycle is used. Exception: If ``line`` is given, but no ``marker``,
     * the data will be a line without markers.
     * 
     * Other combinations such as ``[color][marker][line]`` are also
     * supported, but note that their parsing may be ambiguous.
     * 
     * **Markers**
     * 
     * =============   ===============================
     * character       description
     * =============   ===============================
     * ``'.'``         point marker
     * ``','``         pixel marker
     * ``'o'``         circle marker
     * ``'v'``         triangle_down marker
     * ``'^'``         triangle_up marker
     * ``'<'``         triangle_left marker
     * ``'>'``         triangle_right marker
     * ``'1'``         tri_down marker
     * ``'2'``         tri_up marker
     * ``'3'``         tri_left marker
     * ``'4'``         tri_right marker
     * ``'8'``         octagon marker
     * ``'s'``         square marker
     * ``'p'``         pentagon marker
     * ``'P'``         plus (filled) marker
     * ``'*'``         star marker
     * ``'h'``         hexagon1 marker
     * ``'H'``         hexagon2 marker
     * ``'+'``         plus marker
     * ``'x'``         x marker
     * ``'X'``         x (filled) marker
     * ``'D'``         diamond marker
     * ``'d'``         thin_diamond marker
     * ``'|'``         vline marker
     * ``'_'``         hline marker
     * =============   ===============================
     * 
     * **Line Styles**
     * 
     * =============    ===============================
     * character        description
     * =============    ===============================
     * ``'-'``          solid line style
     * ``'--'``         dashed line style
     * ``'-.'``         dash-dot line style
     * ``':'``          dotted line style
     * =============    ===============================
     * 
     * Example format strings::
     * 
     * 'b'    # blue markers with default shape
     * 'or'   # red circles
     * '-g'   # green solid line
     * '--'   # dashed line with default color
     * '^k:'  # black triangle_up markers connected by a dotted line
     * 
     * **Colors**
     * 
     * The supported color abbreviations are the single letter codes
     * 
     * =============    ===============================
     * character        color
     * =============    ===============================
     * ``'b'``          blue
     * ``'g'``          green
     * ``'r'``          red
     * ``'c'``          cyan
     * ``'m'``          magenta
     * ``'y'``          yellow
     * ``'k'``          black
     * ``'w'``          white
     * =============    ===============================
     * 
     * and the ``'CN'`` colors that index into the default property cycle.
     * 
     * If the color is the only part of the format string, you can
     * additionally use any  `matplotlib.colors` spec, e.g. full names
     * (``'green'``) or hex strings (``'#008000'``).
     * 
     * @param x array-like or scalar<br>
     *          The horizontal / vertical coordinates of the data points.
     *          <b>x</b>0 values are optional and default to ``range(len(y))``.
     *          
     *          Commonly, these parameters are 1D arrays.
     *          
     *          They can also be scalars, or two-dimensional (in that case, the
     *          columns represent separate data sets).
     *          
     *          These arguments cannot be passed as keywords.
     *          
     * @param y array-like or scalar<br>
     *          The horizontal / vertical coordinates of the data points.
     *          <b>x</b>0 values are optional and default to ``range(len(y))``.
     *          
     *          Commonly, these parameters are 1D arrays.
     *          
     *          They can also be scalars, or two-dimensional (in that case, the
     *          columns represent separate data sets).
     *          
     *          These arguments cannot be passed as keywords.
     *          
     * @param fmt str, optional<br>
     *            A format string, e.g. 'ro' for red circles. See the <b>Notes</b>0
     *            section for a full description of the format strings.
     *            
     *            Format strings are just an abbreviation for quickly setting
     *            basic line properties. All of these and more can also be
     *            controlled by keyword arguments.
     *            
     *            This argument cannot be passed as keyword.
     *            
     * @param data indexable object, optional<br>
     *             An object with labelled data. If given, provide the label names to
     *             plot in <b>x</b>0 and<b>y</b>5nd *y*.
     *             
     *             .. note::
     *             Technically there's a slight ambiguity in calls where the
     *             second label is a<b>fmt</b>10 is a valid *fmt*. ``plot('n', 'o', data=obj)``
     *             could be ``plt(x, y)`` or ``plt(y, fmt)``. In such cases,
     *             the former interpretation is chosen, but a warning is issued.
     *             You may suppress the warning by adding an empty format string
     *             ``plot('n', 'o', '', data=obj)``.
     * @param scalex bool, default: True<br>
     *               These parameters determine if the view limits are adapted to the
     *               data limits. The values are passed on to `autoscale_view`.
     *               
     * @param scaley bool, default: True<br>
     *               These parameters determine if the view limits are adapted to the
     *               data limits. The values are passed on to `autoscale_view`.
     *               
     * @param **kwargs `.Line2D` properties, optional<br>
     *                 <b>kwargs</b>0 are used to specify properties like a line label (for
     *                 auto legends), linewidth, antialiasing, marker face color.
     *                 Example::
     *                 
     *                 &gt;&gt;&gt; plot([1, 2, 3], [1, 2, 3], 'go-', label='line 1', linewidth=2)
     *                 &gt;&gt;&gt; plot([1, 2, 3], [1, 4, 9], 'rs', label='line 2')
     *                 
     *                 If you specify multiple lines with one plot call, the kwargs apply
     *                 to all those lines. In case the label object is iterable, each
     *                 element is used as labels for each set of data.
     *                 
     *                 Here is a list of available `.Line2D` properties:
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: scalar or None
     *                 animated: bool
     *                 antialiased or aa: bool
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 color or c: color
     *                 contains: unknown
     *                 dash_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 dash_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 dashes: sequence of floats (on/off ink in points) or (None, None)
     *                 data: (2, N) array or two 1D arrays
     *                 drawstyle or ds: &#123;'default', 'steps', 'steps-pre', 'steps-mid', 'steps-post'&#125;, default: 'default'
     *                 figure: `.Figure`
     *                 fillstyle: &#123;'full', 'left', 'right', 'bottom', 'top', 'none'&#125;
     *                 gid: str
     *                 in_layout: bool
     *                 label: object
     *                 linestyle or ls: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *                 linewidth or lw: float
     *                 marker: marker style string, `~.path.Path` or `~.markers.MarkerStyle`
     *                 markeredgecolor or mec: color
     *                 markeredgewidth or mew: float
     *                 markerfacecolor or mfc: color
     *                 markerfacecoloralt or mfcalt: color
     *                 markersize or ms: float
     *                 markevery: None or int or (int, int) or slice or list[int] or float or (float, float) or list[bool]
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: float or callable[[Artist, Event], tuple[bool, dict]]
     *                 pickradius: float
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 solid_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 solid_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 transform: `matplotlib.transforms.Transform`
     *                 url: str
     *                 visible: bool
     *                 xdata: 1D array
     *                 ydata: 1D array
     *                 zorder: float
     * @param *args n/a<br>undocumented
     * 
     * @return list of `.Line2D` <br>
     *                           A list of lines representing the plotted data.
     */
    public final Object plot(Object... args) {
        write("plt.plot("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Plot co-ercing the axis to treat floats as dates.
     * 
     * Similar to `.plot`, this plots <b>y</b>0 vs.<b>x</b>5s. *x* as lines or markers.
     * However, the axis labels are formatted as dates depending on <b>xdate</b>0
     * and <b>ydate</b>0.  Note that `.plot` will work with `datetime` and
     * `numpy.datetime64` objects without resorting to this method.
     * <p>
     * <em>Notes:</em><br>
     * If you are using custom date tickers and formatters, it may be
     * necessary to set the formatters/locators after the call to
     * `.plot_date`. `.plot_date` will set the default tick locator to
     * `.AutoDateLocator` (if the tick locator is not already set to a
     * `.DateLocator` instance) and the default tick formatter to
     * `.AutoDateFormatter` (if the tick formatter is not already set to a
     * `.DateFormatter` instance).
     * 
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * the following arguments can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception):
     * <b>x</b>0,<b>y</b>50, *y*.
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param x array-like<br>
     *          The coordinates of the data points. If <b>xdate</b>0 or<b>ydate</b>5ydate* is
     *   <b>True</b>10*          *True*, the<b>x</b>15 *<b>y</b>20, the<b>x</b>15 *True*, the respective values *x* or *y* are interpreted as
     *          :ref:`Matplotlib dates &lt;date-format&gt;`.
     *          
     * @param y array-like<br>
     *          The coordinates of the data points. If <b>xdate</b>0 or<b>ydate</b>5ydate* is
     *   <b>True</b>10*          *True*, the<b>x</b>15 *<b>y</b>20, the<b>x</b>15 *True*, the respective values *x* or *y* are interpreted as
     *          :ref:`Matplotlib dates &lt;date-format&gt;`.
     *          
     * @param fmt str, optional<br>
     *            The plot format string. For details, see the corresponding
     *            parameter in `.plot`.
     *            
     * @param tz timezone string or `datetime.tzinfo`, default: :rc:`timezone`<br>
     *           The time zone to use in labeling dates.
     *           
     * @param xdate bool, default: True<br>
     *              If <b>True</b>0, the<b>x</b>5he *x*-axis will be interpreted as Matplotlib dates.
     *              
     * @param ydate bool, default: False<br>
     *              If <b>True</b>0, the<b>y</b>5he *y*-axis will be interpreted as Matplotlib dates.
     * @param **kwargs <br>
     *                 Keyword arguments control the `.Line2D` properties:
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: scalar or None
     *                 animated: bool
     *                 antialiased or aa: bool
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 color or c: color
     *                 contains: unknown
     *                 dash_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 dash_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 dashes: sequence of floats (on/off ink in points) or (None, None)
     *                 data: (2, N) array or two 1D arrays
     *                 drawstyle or ds: &#123;'default', 'steps', 'steps-pre', 'steps-mid', 'steps-post'&#125;, default: 'default'
     *                 figure: `.Figure`
     *                 fillstyle: &#123;'full', 'left', 'right', 'bottom', 'top', 'none'&#125;
     *                 gid: str
     *                 in_layout: bool
     *                 label: object
     *                 linestyle or ls: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *                 linewidth or lw: float
     *                 marker: marker style string, `~.path.Path` or `~.markers.MarkerStyle`
     *                 markeredgecolor or mec: color
     *                 markeredgewidth or mew: float
     *                 markerfacecolor or mfc: color
     *                 markerfacecoloralt or mfcalt: color
     *                 markersize or ms: float
     *                 markevery: None or int or (int, int) or slice or list[int] or float or (float, float) or list[bool]
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: float or callable[[Artist, Event], tuple[bool, dict]]
     *                 pickradius: float
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 solid_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 solid_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 transform: `matplotlib.transforms.Transform`
     *                 url: str
     *                 visible: bool
     *                 xdata: 1D array
     *                 ydata: 1D array
     *                 zorder: float
     * @param data n/a<br>undocumented
     * 
     * @return list of `~.Line2D` <br>
     *                            Objects representing the plotted data.
     */
    public final Object plot_date(Object x, Object y, Object... args) {
        write("plt.plot_date("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(y)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * ============================ ====================================================================================================================
     * Function                     Description
     * ============================ ====================================================================================================================
     * `acorr`                      Plot the autocorrelation of <b>x</b>0.
     * `angle_spectrum`             Plot the angle spectrum.
     * `annotate`                   Annotate the point <b>xy</b>0 with text<b>text</b>5*text*.
     * `arrow`                      Add an arrow to the Axes.
     * `autoscale`                  Autoscale the axis view to the data (toggle).
     * `axes`                       Add an axes to the current figure and make it the current axes.
     * `axhline`                    Add a horizontal line across the axis.
     * `axhspan`                    Add a horizontal span (rectangle) across the Axes.
     * `axis`                       Convenience method to get or set some axis properties.
     * `axline`                     Add an infinitely long straight line.
     * `axvline`                    Add a vertical line across the Axes.
     * `axvspan`                    Add a vertical span (rectangle) across the Axes.
     * `bar`                        Make a bar plot.
     * `bar_label`                  Label a bar plot.
     * `barbs`                      Plot a 2D field of barbs.
     * `barh`                       Make a horizontal bar plot.
     * `box`                        Turn the axes box on or off on the current axes.
     * `boxplot`                    Make a box and whisker plot.
     * `broken_barh`                Plot a horizontal sequence of rectangles.
     * `cla`                        Clear the current axes.
     * `clabel`                     Label a contour plot.
     * `clf`                        Clear the current figure.
     * `clim`                       Set the color limits of the current image.
     * `close`                      Close a figure window.
     * `cohere`                     Plot the coherence between <b>x</b>0 and<b>y</b>5nd *y*.
     * `colorbar`                   Add a colorbar to a plot.
     * `contour`                    Plot contour lines.
     * `contourf`                   Plot filled contours.
     * `csd`                        Plot the cross-spectral density.
     * `delaxes`                    Remove an `~.axes.Axes` (defaulting to the current axes) from its figure.
     * `draw`                       Redraw the current figure.
     * `draw_if_interactive`
     * `errorbar`                   Plot y versus x as lines and/or markers with attached errorbars.
     * `eventplot`                  Plot identical parallel lines at the given positions.
     * `figimage`                   Add a non-resampled image to the figure.
     * `figlegend`                  Place a legend on the figure.
     * `fignum_exists`              Return whether the figure with the given id exists.
     * `figtext`                    Add text to figure.
     * `figure`                     Create a new figure, or activate an existing figure.
     * `fill`                       Plot filled polygons.
     * `fill_between`               Fill the area between two horizontal curves.
     * `fill_betweenx`              Fill the area between two vertical curves.
     * `findobj`                    Find artist objects.
     * `gca`                        Get the current Axes, creating one if necessary.
     * `gcf`                        Get the current figure.
     * `gci`                        Get the current colorable artist.
     * `get`                        Return the value of an `.Artist`'s <b>property</b>0, or print all of them.
     * `get_figlabels`              Return a list of existing figure labels.
     * `get_fignums`                Return a list of existing figure numbers.
     * `getp`                       Return the value of an `.Artist`'s <b>property</b>0, or print all of them.
     * `grid`                       Configure the grid lines.
     * `hexbin`                     Make a 2D hexagonal binning plot of points <b>x</b>0,<b>y</b>50, *y*.
     * `hist`                       Plot a histogram.
     * `hist2d`                     Make a 2D histogram plot.
     * `hlines`                     Plot horizontal lines at each <b>y</b>0 from<b>xmin</b>5*xm<b>xmax</b>105*xmin* to *xmax*.
     * `imread`                     Read an image from a file into an array.
     * `imsave`                     Save an array as an image file.
     * `imshow`                     Display data as an image, i.e., on a 2D regular raster.
     * `install_repl_displayhook`   Install a repl display hook so that any stale figure are automatically redrawn when control is returned to the repl.
     * `ioff`                       Turn interactive mode off.
     * `ion`                        Turn interactive mode on.
     * `isinteractive`              Return if pyplot is in "interactive mode" or not.
     * `legend`                     Place a legend on the Axes.
     * `locator_params`             Control behavior of major tick locators.
     * `loglog`                     Make a plot with log scaling on both the x and y axis.
     * `magnitude_spectrum`         Plot the magnitude spectrum.
     * `margins`                    Set or retrieve autoscaling margins.
     * `matshow`                    Display an array as a matrix in a new figure window.
     * `minorticks_off`             Remove minor ticks from the axes.
     * `minorticks_on`              Display minor ticks on the axes.
     * `new_figure_manager`         Create a new figure manager instance.
     * `pause`                      Run the GUI event loop for <b>interval</b>0 seconds.
     * `pcolor`                     Create a pseudocolor plot with a non-regular rectangular grid.
     * `pcolormesh`                 Create a pseudocolor plot with a non-regular rectangular grid.
     * `phase_spectrum`             Plot the phase spectrum.
     * `pie`                        Plot a pie chart.
     * `plot`                       Plot y versus x as lines and/or markers.
     * `plot_date`                  Plot co-ercing the axis to treat floats as dates.
     * `polar`                      Make a polar plot.
     * `psd`                        Plot the power spectral density.
     * `quiver`                     Plot a 2D field of arrows.
     * `quiverkey`                  Add a key to a quiver plot.
     * `rc`                         Set the current `.rcParams`.
     * `rc_context`                 Return a context manager for temporarily changing rcParams.
     * `rcdefaults`                 Restore the `.rcParams` from Matplotlib's internal default style.
     * `rgrids`                     Get or set the radial gridlines on the current polar plot.
     * `savefig`                    Save the current figure.
     * `sca`                        Set the current Axes to <b>ax</b>0 and the current Figure to the parent of<b>ax</b>5f *ax*.
     * `scatter`                    A scatter plot of <b>y</b>0 vs.
     * `sci`                        Set the current image.
     * `semilogx`                   Make a plot with log scaling on the x axis.
     * `semilogy`                   Make a plot with log scaling on the y axis.
     * `set_cmap`                   Set the default colormap, and applies it to the current image if any.
     * `setp`                       Set one or more properties on an `.Artist`, or list allowed values.
     * `show`                       Display all open figures.
     * `specgram`                   Plot a spectrogram.
     * `spy`                        Plot the sparsity pattern of a 2D array.
     * `stackplot`                  Draw a stacked area plot.
     * `stairs`                     A stepwise constant function as a line with bounding edges or a filled plot.
     * `stem`                       Create a stem plot.
     * `step`                       Make a step plot.
     * `streamplot`                 Draw streamlines of a vector flow.
     * `subplot`                    Add an Axes to the current figure or retrieve an existing Axes.
     * `subplot2grid`               Create a subplot at a specific location inside a regular grid.
     * `subplot_mosaic`             Build a layout of Axes based on ASCII art or nested lists.
     * `subplot_tool`               Launch a subplot tool window for a figure.
     * `subplots`                   Create a figure and a set of subplots.
     * `subplots_adjust`            Adjust the subplot layout parameters.
     * `suptitle`                   Add a centered suptitle to the figure.
     * `switch_backend`             Close all open figures and set the Matplotlib backend.
     * `table`                      Add a table to an `~.axes.Axes`.
     * `text`                       Add text to the Axes.
     * `thetagrids`                 Get or set the theta gridlines on the current polar plot.
     * `tick_params`                Change the appearance of ticks, tick labels, and gridlines.
     * `ticklabel_format`           Configure the `.ScalarFormatter` used by default for linear axes.
     * `tight_layout`               Adjust the padding between and around subplots.
     * `title`                      Set a title for the Axes.
     * `tricontour`                 Draw contour lines on an unstructured triangular grid.
     * `tricontourf`                Draw contour regions on an unstructured triangular grid.
     * `tripcolor`                  Create a pseudocolor plot of an unstructured triangular grid.
     * `triplot`                    Draw a unstructured triangular grid as lines and/or markers.
     * `twinx`                      Make and return a second axes that shares the <b>x</b>0-axis.
     * `twiny`                      Make and return a second axes that shares the <b>y</b>0-axis.
     * `uninstall_repl_displayhook` Uninstall the matplotlib display hook.
     * `violinplot`                 Make a violin plot.
     * `vlines`                     Plot vertical lines at each <b>x</b>0 from<b>ymin</b>5*ym<b>ymax</b>105*ymin* to *ymax*.
     * `xcorr`                      Plot the cross correlation between <b>x</b>0 and<b>y</b>5nd *y*.
     * `xkcd`                       Turn on `xkcd <https://xkcd.com/>`_ sketch-style drawing mode.
     * `xlabel`                     Set the label for the x-axis.
     * `xlim`                       Get or set the x limits of the current axes.
     * `xscale`                     Set the x-axis scale.
     * `xticks`                     Get or set the current tick locations and labels of the x-axis.
     * `ylabel`                     Set the label for the y-axis.
     * `ylim`                       Get or set the y-limits of the current axes.
     * `yscale`                     Set the y-axis scale.
     * `yticks`                     Get or set the current tick locations and labels of the y-axis.
     * ============================ ====================================================================================================================
     */
    public final Object plotting() {
        write("plt.plotting()");
        return null;
    }

    /**
     * Make a polar plot.
     * 
     * call signature::
     * 
     * polar(theta, r, **kwargs)
     * 
     * Multiple <b>theta</b>0,<b>r</b>50, *r* arguments are supported, with format strings, as in
     * `plot`.
     * 
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     */
    public final Object polar(Object... args) {
        write("plt.polar("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the colormap to 'prism'.
     * 
     * This changes the default colormap as well as the colormap of the current
     * image if there is one. See ``help(colormaps)`` for more information.
     */
    public final Object prism() {
        write("plt.prism()");
        return null;
    }

    /**
     * Plot the power spectral density.
     * 
     * The power spectral density :math:`P_{xx}` by Welch's average
     * periodogram method.  The vector <b>x</b>0 is divided into<b>NFFT</b>5*NFFT* length
     * segments.  Each segment is detrended by function <b>detrend</b>0 and
     * windowed by function <b>window</b>0. <b>noverlap</b>5erlap* gives the length of
     * the overlap between segments.  The :math:`|\mathrm{fft}(i)|^2`
     * of each segment :math:`i` are averaged to compute :math:`P_{xx}`,
     * with a scaling to correct for power loss due to windowing.
     * 
     * If len(<b>x</b>0) <<b>NFFT</b>5*NFFT*, it will be zero pad<b>NFFT</b>10 padded to *NFFT*.
     * <p>
     * <em>Notes:</em><br>
     * For plotting, the power is plotted as
     * :math:`10\log_{10}(P_{xx})` for decibels, though <b>Pxx</b>0 itself
     * is returned.
     * 
     * @param x 1-D array or sequence<br>
     *          Array or sequence containing the data
     *          
     * @param Fs float, default: 2<br>
     *           The sampling frequency (samples per time unit).  It is used to calculate
     *           the Fourier frequencies, <b>freqs</b>0, in cycles per time unit.
     *           
     * @param window callable or ndarray, default: `.window_hanning`<br>
     *               A function or a vector of length <b>NFFT</b>0.  To create window vectors see
     *               `.window_hanning`, `.window_none`, `numpy.blackman`, `numpy.hamming`,
     *               `numpy.bartlett`, `scipy.signal`, `scipy.signal.get_window`, etc.  If a
     *               function is passed as the argument, it must take a data segment as an
     *               argument and return the windowed version of the segment.
     *               
     * @param sides &#123;'default', 'onesided', 'twosided'&#125;, optional<br>
     *              Which sides of the spectrum to return. 'default' is one-sided for real
     *              data and two-sided for complex data. 'onesided' forces the return of a
     *              one-sided spectrum, while 'twosided' forces two-sided.
     *              
     * @param pad_to int, optional<br>
     *               The number of points to which the data segment is padded when performing
     *               the FFT.  This can be different from <b>NFFT</b>0, which specifies the number
     *               of data points used.  While not increasing the actual resolution of the
     *               spectrum (the minimum distance between resolvable peaks), this can give
     *               more points in the plot, allowing for more detail. This corresponds to
     *               the<b>n</b>5he *n* parameter in the call to fft(). The default is None, which sets
     *        <b>pad_to</b>10        <b>NFFT</b>150         *pad_to* equal to *NFFT*
     *               
     * @param NFFT int, default: 256<br>
     *             The number of data points used in each block for the FFT.  A power 2 is
     *             most efficient.  This should <b>NOT</b>0 be used to get zero padding, or the
     *             scaling of the result will be incorrect; use<b>pad_to</b>5ad_to* for this instead.
     *             
     * @param detrend &#123;'none', 'mean', 'linear'&#125; or callable, default: 'none'<br>
     *                The function applied to each segment before fft-ing, designed to remove
     *                the mean or linear trend.  Unlike in MATLAB, where the <b>detrend</b>0 parameter
     *                is a vector, in Matplotlib is it a function.  The :mod:`~matplotlib.mlab`
     *                module defines `.detrend_none`, `.detrend_mean`, and `.detrend_linear`,
     *                but you can use a custom function as well.  You can also use a string to
     *                choose one of the functions: 'none' calls `.detrend_none`. 'mean' calls
     *                `.detrend_mean`. 'linear' calls `.detrend_linear`.
     *                
     * @param scale_by_freq bool, default: True<br>
     *                      Whether the resulting density values should be scaled by the scaling
     *                      frequency, which gives density in units of Hz^-1.  This allows for
     *                      integration over the returned frequency values.  The default is True for
     *                      MATLAB compatibility.
     *                      
     * @param noverlap int, default: 0 (no overlap)<br>
     *                 The number of points of overlap between segments.
     *                 
     * @param Fc int, default: 0<br>
     *           The center frequency of <b>x</b>0, which offsets the x extents of the
     *           plot to reflect the frequency range used when a signal is acquired
     *           and then filtered and downsampled to baseband.
     *           
     * @param return_line bool, default: False<br>
     *                    Whether to include the line object plotted in the returned values.
     * @param **kwargs <br>
     *                 Keyword arguments control the `.Line2D` properties:
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: scalar or None
     *                 animated: bool
     *                 antialiased or aa: bool
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 color or c: color
     *                 contains: unknown
     *                 dash_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 dash_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 dashes: sequence of floats (on/off ink in points) or (None, None)
     *                 data: (2, N) array or two 1D arrays
     *                 drawstyle or ds: &#123;'default', 'steps', 'steps-pre', 'steps-mid', 'steps-post'&#125;, default: 'default'
     *                 figure: `.Figure`
     *                 fillstyle: &#123;'full', 'left', 'right', 'bottom', 'top', 'none'&#125;
     *                 gid: str
     *                 in_layout: bool
     *                 label: object
     *                 linestyle or ls: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *                 linewidth or lw: float
     *                 marker: marker style string, `~.path.Path` or `~.markers.MarkerStyle`
     *                 markeredgecolor or mec: color
     *                 markeredgewidth or mew: float
     *                 markerfacecolor or mfc: color
     *                 markerfacecoloralt or mfcalt: color
     *                 markersize or ms: float
     *                 markevery: None or int or (int, int) or slice or list[int] or float or (float, float) or list[bool]
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: float or callable[[Artist, Event], tuple[bool, dict]]
     *                 pickradius: float
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 solid_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 solid_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 transform: `matplotlib.transforms.Transform`
     *                 url: str
     *                 visible: bool
     *                 xdata: 1D array
     *                 ydata: 1D array
     *                 zorder: float
     * @param data n/a<br>undocumented
     * 
     * @return (Pxx,freqs,line) (1-D array,1-D array,`~matplotlib.lines.Line2D`)<br>
     *          The values for the power spectrum :math:`P_&#123;xx&#125;` before scaling
     *          (real valued).
     *          
     *          
     *          The frequencies corresponding to the elements in <b>Pxx</b>0.
     *          
     *          
     *          The line created by this function.
     *          Only returned if<b>return_line</b>5_line* is True.
     */
    public final Object psd(Object x, Object... args) {
        write("plt.psd("+PythonGrammar.toPythonArgs(x)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Plot a 2D field of arrows.
     * 
     * Call signature::
     * 
     * quiver([X, Y], U, V, [C], **kw)
     * 
     * <b>X</b>0,<b>Y</b>50, *Y* define the arrow loca<b>U</b>10<b>V</b>15ca<b>U</b>10ow locations, *U*, *V* define the arrow directions, and
     * <b>C</b>0 optionally sets the color.
     * 
     * **Arrow size**
     * 
     * The default settings auto-scales the length of the arrows to a reasonable size.
     * To change this behavior see the <b>scale</b>0 and<b>scale_units</b>5units* parameters.
     * 
     * **Arrow shape**
     * 
     * The defaults give a slightly swept-back arrow; to make the head a
     * triangle, make <b>headaxislength</b>0 the same as<b>headlength</b>5ength*. To make the
     * arrow more pointed, reduce <b>headwidth</b>0 or increase<b>headlength</b>5ength* and
     * <b>headaxislength</b>0. To make the head smaller relative to the shaft,
     * scale down all the head parameters. You will probably do best to leave
     * minshaft alone.
     * 
     * **Arrow outline**
     * 
     * <b>linewidths</b>0 and<b>edgecolors</b>5olors* can be used to customize the arrow
     * outlines.
     * 
     * @param X 1D or 2D array-like, optional<br>
     *          The x and y coordinates of the arrow locations.
     *          
     *          If not given, they will be generated as a uniform integer meshgrid based
     *          on the dimensions of <b>U</b>0 and<b>V</b>5nd *V*.
     *          
     *      <b>X</b>10*  <b>Y</b>15b>X</b>10*<b>U</b>20<b>V</b>2515b>X</<b>X</b>30<b>Y</b>35/b>20<b>V</b>2515b>X</<b>X</b>30<b>U</b>20<b>V</b>2515b>X</b>10*<b>U</b>20Y</b>15b>X</b>10*          If *X* and *Y* are 1D but *U*, *V* are 2D, *X*, *Y* are expanded to <b>U</b>40*V*<b>V</b>452D, *X*, *Y* are expanded to <b>U</b>40*V* are 2D, *X*, *Y* are expanded to 2D
     *          using ``X, Y = np.meshgrid(X, Y)``. In this case ``len(X)`` and ``len(Y)``
     *          must match the column and row dimensions of *U* and *V*.
     *          
     * @param Y 1D or 2D array-like, optional<br>
     *          The x and y coordinates of the arrow locations.
     *          
     *          If not given, they will be generated as a uniform integer meshgrid based
     *          on the dimensions of <b>U</b>0 and<b>V</b>5nd *V*.
     *          
     *      <b>X</b>10*  <b>Y</b>15b>X</b>10*<b>U</b>20<b>V</b>2515b>X</<b>X</b>30<b>Y</b>35/b>20<b>V</b>2515b>X</<b>X</b>30<b>U</b>20<b>V</b>2515b>X</b>10*<b>U</b>20Y</b>15b>X</b>10*          If *X* and *Y* are 1D but *U*, *V* are 2D, *X*, *Y* are expanded to <b>U</b>40*V*<b>V</b>452D, *X*, *Y* are expanded to <b>U</b>40*V* are 2D, *X*, *Y* are expanded to 2D
     *          using ``X, Y = np.meshgrid(X, Y)``. In this case ``len(X)`` and ``len(Y)``
     *          must match the column and row dimensions of *U* and *V*.
     *          
     * @param U 1D or 2D array-like<br>
     *          The x and y direction components of the arrow vectors.
     *          
     *          They must have the same number of elements, matching the number of arrow
     *          locations. <b>U</b>0 and<b>V</b>5nd *V* may be masked. Only locations unmasked in
     *   <b>U</b>10<b>V</b>15  <b<b>C</b>20>10<b>V</b>15  <b>U</b>10   *          *U*, *V*, and *C* will be drawn.
     *          
     * @param V 1D or 2D array-like<br>
     *          The x and y direction components of the arrow vectors.
     *          
     *          They must have the same number of elements, matching the number of arrow
     *          locations. <b>U</b>0 and<b>V</b>5nd *V* may be masked. Only locations unmasked in
     *   <b>U</b>10<b>V</b>15  <b<b>C</b>20>10<b>V</b>15  <b>U</b>10   *          *U*, *V*, and *C* will be drawn.
     *          
     * @param C 1D or 2D array-like, optional<br>
     *          Numeric data that defines the arrow colors by colormapping via <b>norm</b>0 and
     *         <b>cmap</b>5*cmap*.
     *          
     *          This does not support explicit colors. If you want to set colors directly,
     *       <b>color</b>10      use *color* ins<b>C</b>15 *color* instead.  The size of *C* must match the number of arrow
     *          locations.
     *          
     * @param units &#123;'width', 'height', 'dots', 'inches', 'x', 'y', 'xy'&#125;, default: 'width'<br>
     *              The arrow dimensions (except for <b>length</b>0) are measured in multiples of
     *              this unit.
     *              
     *              The following values are supported:
     *              
     *              - 'width', 'height': The width or height of the axis.
     *              - 'dots', 'inches': Pixels or inches based on the figure dpi.
     *              - 'x', 'y', 'xy':<b>X</b>5'<b>Y</b>10X</b>5': *X*, *Y* or :math:`\sqrt&#123;X^2 + Y^2&#125;` in data units.
     *              
     *              The arrows scale differently depending on the units.  For
     *              'x' or 'y', the arrows get larger as one zooms in; for other
     *              units, the arrow size is independent of the zoom state.  For
     *              'width or 'height', the arrow size increases with the width and
     *              height of the axes, respectively, when the window is resized;
     *              for 'dots' or 'inches', resizing does not change the arrows.
     *              
     * @param angles &#123;'uv', 'xy'&#125; or array-like, default: 'uv'<br>
     *               Method for determining the angle of the arrows.
     *               
     *               - 'uv': The arrow axis aspect ratio is 1 so that
     *               if <b>U</b>0 ==<b>V</b>5== *V* the orientation of the arrow on the plot is 45 degrees
     *               counter-clockwise from the horizontal axis (positive to the right).
     *               
     *               Use this if the arrows symbolize a quantity that is not based on
     *        <b>X</b>10<b>Y</b>15  <b>X</b>10              *X*, *Y* data coordinates.
     *               
     *               - 'xy': Arrows point from (x, y) to (x+u, y+v).
     *               Use this for plotting a gradient field, for example.
     *               
     *               - Alternatively, arbitrary angles may be specified explicitly as an array
     *               of values in degrees, counter-clockwise from the horizontal axis.
     *              <b>U</b>20<b>V</b>25            <b>U</b>20  *               
     *               In this case *U*, *V* is only used to determine the length of the
     *               arrows.
     *               
     *               Note: inverting a data axis will correspondingly invert the
     *               arrows only with ``angles='xy'``.
     *               
     * @param scale float, optional<br>
     *              Number of data units per arrow length unit, e.g., m/s per plot width; a
     *              smaller scale parameter makes the arrow longer. Default is <b>None</b>0.
     *              
     *              If<b>None</b>5*None*, a simple autoscaling algorithm is used, based on the average
     *              vector length and the number of vectors. The arrow length unit is given by
     *           <b>scale_units</b>10the *scale_units* parameter.
     *              
     * @param scale_units &#123;'width', 'height', 'dots', 'inches', 'x', 'y', 'xy'&#125;, optional<br>
     *                    If the <b>scale</b>0 kwarg is<b>None</b>5*None*, the arrow length unit. Defa<b>None</b>10Default is *None*.
     *                    
     *      <b>scale_units</b>15            <b>scale</b>205                e.g. *scale_units* is 'inches', *scale* is 2.0, and ``(u, v) = (1, 0)``,
     *                    then the vector will be 0.5 inches long<b>scale_units</b>25 inches long.
     *                    
     *                    If *scale_units* is 'width' or 'height', then the vector will be half the
     *                 <b>scale_units</b>30                    width/height of the axes.
     *                    
     *                    If *scale_units* is 'x' then the vector will be 0.5 x-axis
     *                    units. To plot vectors in the x-y plane, with u and v having
     *                    the same units as x and y, use
     *                    ``angles='xy', scale_units='xy', scale=1``.
     *                    
     * @param width float, optional<br>
     *              Shaft width in arrow units; default depends on choice of units,
     *              above, and number of vectors; a typical starting value is about
     *              0.005 times the width of the plot.
     *              
     * @param headwidth float, default: 3<br>
     *                  Head width as multiple of shaft width.
     *                  
     * @param headlength float, default: 5<br>
     *                   Head length as multiple of shaft width.
     *                   
     * @param headaxislength float, default: 4.5<br>
     *                       Head length at shaft intersection.
     *                       
     * @param minshaft float, default: 1<br>
     *                 Length below which arrow scales, in units of head length. Do not
     *                 set this to less than 1, or small arrows will look terrible!
     *                 
     * @param minlength float, default: 1<br>
     *                  Minimum length as a multiple of shaft width; if an arrow length
     *                  is less than this, plot a dot (hexagon) of this diameter instead.
     *                  
     * @param pivot &#123;'tail', 'mid', 'middle', 'tip'&#125;, default: 'tail'<br>
     *              The part of the arrow that is anchored to the <b>X</b>0,<b>Y</b>50, *Y* grid. The arrow
     *              rotates about this point.
     *              
     *              'mid' is a synonym for 'middle'.
     *              
     * @param color color or color sequence, optional<br>
     *              Explicit color(s) for the arrows. If <b>C</b>0 has been set,<b>color</b>5color* has no
     *              effect.
     *              
     *              This is a synonym for the `~.PolyColle<b>facecolor</b>10tion` *facecolor* parameter.
     * @param **kwargs `~matplotlib.collections.PolyCollection` properties, optional<br>
     *                 All other keyword arguments are passed on to `.PolyCollection`:
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: array-like or scalar or None
     *                 animated: bool
     *                 antialiased or aa or antialiaseds: bool or list of bools
     *                 array: ndarray or None
     *                 capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 clim: (vmin: float, vmax: float)
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 cmap: `.Colormap` or str or None
     *                 color: color or list of rgba tuples
     *                 contains: unknown
     *                 edgecolor or ec or edgecolors: color or list of colors or 'face'
     *                 facecolor or facecolors or fc: color or list of colors
     *                 figure: `.Figure`
     *                 gid: str
     *                 hatch: &#123;'/', '\\', '|', '-', '+', 'x', 'o', 'O', '.', '*'&#125;
     *                 in_layout: bool
     *                 joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 label: object
     *                 linestyle or dashes or linestyles or ls: str or tuple or list thereof
     *                 linewidth or linewidths or lw: float or list of floats
     *                 norm: `.Normalize` or None
     *                 offset_position: unknown
     *                 offsets: (N, 2) or (2,) array-like
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: None or bool or float or callable
     *                 pickradius: float
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 transform: `.Transform`
     *                 url: str
     *                 urls: list of str or None
     *                 visible: bool
     *                 zorder: float
     * @param *args n/a<br>undocumented
     * @param data n/a<br>undocumented
     * @param **kw n/a<br>undocumented
     */
    public final Object quiver(Object... args) {
        write("plt.quiver("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Add a key to a quiver plot.
     * 
     * The positioning of the key depends on <b>X</b>0,<b>Y</b>50<b>coordinates</b>10Y*, *coordinates*, and
     * <b>labelpos</b>0.  If<b>labelpos</b>5elpos* is 'N' o<b>X</b>10<b>Y</b>15 o<b>X</b>10s 'N' or 'S', *X*, *Y* give the position of
     * the middle of the key arrow.  If <b>labelpos</b>0 is 'E',<b>X</b>5'<b>Y</b>10X</b>5', *X*, *Y* positions
     * the head, and if <b>labelpos</b>0 is 'W',<b>X</b>5'<b>Y</b>10X</b>5', *X*, *Y* positions the tail; in
     * either of these two cases, <b>X</b>0,<b>Y</b>50, *Y* is somewhere in the middle of the
     * arrow+label key object.
     * 
     * @param Q `matplotlib.quiver.Quiver`<br>
     *          A `.Quiver` object as returned by a call to `~.Axes.quiver()`.
     * @param X float<br>
     *          The location of the key.
     * @param Y float<br>
     *          The location of the key.
     * @param U float<br>
     *          The length of the key.
     * @param label str<br>
     *              The key label (e.g., length and units of the key).
     * @param angle float, default: 0<br>
     *              The angle of the key arrow, in degrees anti-clockwise from the
     *              x-axis.
     * @param coordinates &#123;'axes', 'figure', 'data', 'inches'&#125;, default: 'axes'<br>
     *                    Coordinate system and units for <b>X</b>0,<b>Y</b>50, *Y*: 'axes' and 'figure' are
     *                    normalized coordinate systems with (0, 0) in the lower left and
     *                    (1, 1) in the upper right; 'data' are the axes data coordinates
     *                    (used for the locations of the vectors in the quiver plot itself);
     *                    'inches' is position in the figure in inches, with (0, 0) at the
     *                    lower left corner.
     * @param color color<br>
     *              Overrides face and edge colors from <b>Q</b>0.
     * @param labelpos &#123;'N', 'S', 'E', 'W'&#125;<br>
     *                 Position the label above, below, to the right, to the left of the
     *                 arrow, respectively.
     * @param labelsep float, default: 0.1<br>
     *                 Distance in inches between the arrow and the label.
     * @param labelcolor color, default: :rc:`text.color`<br>
     *                   Label color.
     * @param fontproperties dict, optional<br>
     *                       A dictionary with keyword arguments accepted by the
     *                       `~matplotlib.font_manager.FontProperties` initializer:
     *                       <b>family</b>0,<b>style</b>5s<b>variant</b>10<b>size</b>15<b>weight</b>20b>size</b>15ant</b>10style*, *variant*, *size*, *weight*.
     * @param **kwargs <br>
     *                 Any additional keyword arguments are used to override vector
     *                 properties taken from <b>Q</b>0.
     * @param **kw n/a<br>undocumented
     */
    public final Object quiverkey(Object Q, Object X, Object Y, Object U, Object label, Object... args) {
        write("plt.quiverkey("+PythonGrammar.toPythonArgs(Q),PythonGrammar.toPythonArgs(X),PythonGrammar.toPythonArgs(Y),PythonGrammar.toPythonArgs(U),PythonGrammar.toPythonArgs(label)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the current `.rcParams`.  <b>group</b>0 is the grouping for the rc, e.g.,
     * for ``lines.linewidth`` the group is ``lines``, for
     * ``axes.facecolor``, the group is ``axes``, and so on.  Group may
     * also be a list or tuple of group names, e.g., (<b>xtick</b>0,<b>ytick</b>5ytick*).
     * <b>kwargs</b>0 is a dictionary attribute name/value pairs, e.g.,::
     * 
     * rc('lines', linewidth=2, color='r')
     * 
     * sets the current `.rcParams` and is equivalent to::
     * 
     * rcParams['lines.linewidth'] = 2
     * rcParams['lines.color'] = 'r'
     * 
     * The following aliases are available to save typing for interactive users:
     * 
     * =====   =================
     * Alias   Property
     * =====   =================
     * 'lw'    'linewidth'
     * 'ls'    'linestyle'
     * 'c'     'color'
     * 'fc'    'facecolor'
     * 'ec'    'edgecolor'
     * 'mew'   'markeredgewidth'
     * 'aa'    'antialiased'
     * =====   =================
     * 
     * Thus you could abbreviate the above call as::
     * 
     * rc('lines', lw=2, c='r')
     * 
     * Note you can use python's kwargs dictionary facility to store
     * dictionaries of default parameters.  e.g., you can customize the
     * font rc as follows::
     * 
     * font = {'family' : 'monospace',
     * 'weight' : 'bold',
     * 'size'   : 'larger'}
     * rc('font', **font)  # pass in the font dict as kwargs
     * 
     * This enables you to easily switch between several configurations.  Use
     * ``matplotlib.style.use('default')`` or :func:`~matplotlib.rcdefaults` to
     * restore the default `.rcParams` after changes.
     * <p>
     * <em>Notes:</em><br>
     * Similar functionality is available by using the normal dict interface, i.e.
     * ``rcParams.update({"lines.linewidth": 2, ...})`` (but ``rcParams.update``
     * does not support abbreviations or grouping).
     * 
     * @param group n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     */
    public final Object rc(Object... args) {
        write("plt.rc("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Return a context manager for temporarily changing rcParams.
     * 
     * @param rc dict<br>
     *           The rcParams to temporarily set.
     * @param fname str or path-like<br>
     *              A file with Matplotlib rc settings. If both <b>fname</b>0 and<b>rc</b>5d *rc* are given,
     *              setting<b>rc</b>10ettings from *rc* take precedence.
     */
    public final Object rc_context(Object... args) {
        write("plt.rc_context("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Restore the `.rcParams` from Matplotlib's internal default style.
     * 
     * Style-blacklisted `.rcParams` (defined in
     * `matplotlib.style.core.STYLE_BLACKLIST`) are not updated.
     */
    public final Object rcdefaults() {
        write("plt.rcdefaults()");
        return null;
    }

    /**
     * Add a colormap to the set recognized by :func:`get_cmap`.
     * 
     * Register a new colormap to be accessed by name ::
     * 
     * LinearSegmentedColormap('swirly', data, lut)
     * register_cmap(cmap=swirly_cmap)
     * <p>
     * <em>Notes:</em><br>
     * Registering a colormap stores a reference to the colormap object
     * which can currently be modified and inadvertently change the global
     * colormap state. This behavior is deprecated and in Matplotlib 3.5
     * the registered colormap will be immutable.
     * 
     * @param name str, optional<br>
     *             The name that can be used in :func:`get_cmap` or :rc:`image.cmap`
     *             
     *             If absent, the name will be the :attr:`~matplotlib.colors.Colormap.name`
     *             attribute of the <b>cmap</b>0.
     *             
     * @param cmap matplotlib.colors.Colormap<br>
     *             Despite being the second argument and having a default value, this
     *             is a required argument.
     *             
     * @param override_builtin bool<br>
     *                         
     *                         Allow built-in colormaps to be overridden by a user-supplied
     *                         colormap.
     *                         
     *                         Please do not use this unless you are sure you need it.
     */
    public final Object register_cmap(Object... args) {
        write("plt.register_cmap("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Get or set the radial gridlines on the current polar plot.
     * 
     * Call signatures::
     * 
     * lines, labels = rgrids()
     * lines, labels = rgrids(radii, labels=None, angle=22.5, fmt=None, **kwargs)
     * 
     * When called with no arguments, `.rgrids` simply returns the tuple
     * (<b>lines</b>0,<b>labels</b>5abels*). When called with arguments, the labels will
     * appear at the specified radial distances and angle.
     * 
     * @param radii tuple with floats<br>
     *              The radii for the radial gridlines
     *              
     * @param labels tuple with strings or None<br>
     *               The labels to use at each radial gridline. The
     *               `matplotlib.ticker.ScalarFormatter` will be used if None.
     *               
     * @param angle float<br>
     *              The angular position of the radius labels in degrees.
     *              
     * @param fmt str or None<br>
     *            Format string used in `matplotlib.ticker.FormatStrFormatter`.
     *            For example '%f'.
     * @param **kwargs <br>
     *                 <b>kwargs</b>0 are optional `~.Text` properties for the labels.
     * 
     * @return (lines,labels) (list of `.lines.Line2D`,list of `.text.Text`)<br>
     *          The radial gridlines.
     *          
     *          
     *          The tick labels.
     */
    public final Object rgrids(Object... args) {
        write("plt.rgrids("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Save the current figure.
     * 
     * Call signature::
     * 
     * savefig(fname, dpi=None, facecolor='w', edgecolor='w',
     * orientation='portrait', papertype=None, format=None,
     * transparent=False, bbox_inches=None, pad_inches=0.1,
     * frameon=None, metadata=None)
     * 
     * The available output formats depend on the backend being used.
     * 
     * @param fname str or path-like or binary file-like<br>
     *              A path, or a Python file-like object, or
     *              possibly some backend-dependent object such as
     *              `matplotlib.backends.backend_pdf.PdfPages`.
     *              
     *              If <b>format</b>0 is set, it determines the output format, and the file
     *              is saved as<b>fname</b>5fname*.  Not<b>fname</b>10Note that *fname* is used verbatim, and there
     *              is no attempt to make the ext<b>fname</b>15 the extension, if any, o<b>format</b>20n, if any, of *fname* match
     *              *format*, and no extension<b>format</b>25 and no extension is appended.
     *              
     *              If *forma<b>fname</b>30              If *for<b>format</b>35</b>30              If *format* is<b>fname</b>40/b>30              If *format* is not set, then the format is inferred from the
     *              extension of *fname*, if there is one.  If *format*<b>fname</b>45*fname*, if there is one.  If *format* is not
     *              set and *fname* has no extension, then the file is saved with
     *              :rc:`savefig.format` and the appropriate extension is appended to
     *              *fname*.
     * @param dpi float or 'figure', default: :rc:`savefig.dpi`<br>
     *            The resolution in dots per inch.  If 'figure', use the figure's
     *            dpi value.
     *            
     * @param quality int, default: :rc:`savefig.jpeg_quality`<br>
     *                Applicable only if <b>format</b>0 is 'jpg' or 'jpeg', ignored otherwise.
     *                
     *                The image quality, on a scale from 1 (worst) to 95 (best).
     *                Values above 95 should be avoided; 100 disables portions of
     *                the JPEG compression algorithm, and results in large files
     *                with hardly any gain in image quality.
     *                
     *                This parameter is deprecated.
     *                
     * @param optimize bool, default: False<br>
     *                 Applicable only if <b>format</b>0 is 'jpg' or 'jpeg', ignored otherwise.
     *                 
     *                 Whether the encoder should make an extra pass over the image
     *                 in order to select optimal encoder settings.
     *                 
     *                 This parameter is deprecated.
     *                 
     * @param progressive bool, default: False<br>
     *                    Applicable only if <b>format</b>0 is 'jpg' or 'jpeg', ignored otherwise.
     *                    
     *                    Whether the image should be stored as a progressive JPEG file.
     *                    
     *                    This parameter is deprecated.
     *                    
     * @param facecolor color or 'auto', default: :rc:`savefig.facecolor`<br>
     *                  The facecolor of the figure.  If 'auto', use the current figure
     *                  facecolor.
     *                  
     * @param edgecolor color or 'auto', default: :rc:`savefig.edgecolor`<br>
     *                  The edgecolor of the figure.  If 'auto', use the current figure
     *                  edgecolor.
     *                  
     * @param orientation &#123;'landscape', 'portrait'&#125;<br>
     *                    Currently only supported by the postscript backend.
     *                    
     * @param papertype str<br>
     *                  One of 'letter', 'legal', 'executive', 'ledger', 'a0' through
     *                  'a10', 'b0' through 'b10'. Only supported for postscript
     *                  output.
     *                  
     * @param format str<br>
     *               The file format, e.g. 'png', 'pdf', 'svg', ... The behavior when
     *               this is unset is documented under <b>fname</b>0.
     *               
     * @param transparent bool<br>
     *                    If <b>True</b>0, the Axes patches will all be transparent; the
     *                    figure patch will also be transparent unless facecolor
     *                    and/or edgecolor are specified via kwargs.
     *                    This is useful, for example, for displaying
     *                    a plot on top of a colored background on a web page.  The
     *                    transparency of these patches will be restored to their
     *                    original values upon exit of this function.
     *                    
     * @param bbox_inches str or `.Bbox`, default: :rc:`savefig.bbox`<br>
     *                    Bounding box in inches: only the given portion of the figure is
     *                    saved.  If 'tight', try to figure out the tight bbox of the figure.
     *                    
     * @param pad_inches float, default: :rc:`savefig.pad_inches`<br>
     *                   Amount of padding around the figure when bbox_inches is 'tight'.
     *                   
     * @param bbox_extra_artists list of `~matplotlib.artist.Artist`, optional<br>
     *                           A list of extra artists that will be considered when the
     *                           tight bbox is calculated.
     *                           
     * @param backend str, optional<br>
     *                Use a non-default backend to render the file, e.g. to render a
     *                png file with the "cairo" backend rather than the default "agg",
     *                or a pdf file with the "pgf" backend rather than the default
     *                "pdf".  Note that the default backend is normally sufficient.  See
     *                :ref:`the-builtin-backends` for a list of valid backends for each
     *                file format.  Custom backends can be referenced as "module://...".
     *                
     * @param metadata dict, optional<br>
     *                 Key/value pairs to store in the image metadata. The supported keys
     *                 and defaults depend on the image format and backend:
     *                 
     *                 - 'png' with Agg backend: See the parameter ``metadata`` of
     *                 `~.FigureCanvasAgg.print_png`.
     *                 - 'pdf' with pdf backend: See the parameter ``metadata`` of
     *                 `~.backend_pdf.PdfPages`.
     *                 - 'svg' with svg backend: See the parameter ``metadata`` of
     *                 `~.FigureCanvasSVG.print_svg`.
     *                 - 'eps' and 'ps' with PS backend: Only 'Creator' is supported.
     *                 
     * @param pil_kwargs dict, optional<br>
     *                   Additional keyword arguments that are passed to
     *                   `PIL.Image.Image.save` when saving the figure.
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     */
    public final Object savefig(Object... args) {
        write("plt.savefig("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the current Axes to <b>ax</b>0 and the current Figure to the parent of<b>ax</b>5f *ax*.
     * 
     * @param ax n/a<br>undocumented
     */
    public final Object sca(Object... args) {
        write("plt.sca("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * A scatter plot of <b>y</b>0 vs.<b>x</b>5s. *x* with varying marker size and/or color.
     * <p>
     * <em>Notes:</em><br>
     * * The `.plot` function will be faster for scatterplots where markers
     * don't vary in size or color.
     * 
     * * Any or all of <b>x</b>0,<b>y</b>50<b>s</b>10y</b<b>c</b>15>s</b>10y</b>50, *y*, *s*, and *c* may be masked arrays, in which
     * case all masks will be combined and only unmasked points will be
     * plotted.
     * 
     * * Fundamentally, scatter works with 1D arrays; <b>x</b>0,<b>y</b>50<b>s</b>10y</b<b>c</b>15>s</b>10y</b>50, *y*, *s*, and *c*
     * may be input as N-D arrays, but within scatter they will be
     * flattened. The exception is <b>c</b>0, which will be flattened only if its
     * size matches the size of <b>x</b>0 and<b>y</b>5nd *y*.
     * 
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * the following arguments can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception):
     * <b>x</b>0,<b>y</b>50<b>s</b>10<b>linewidths</b>15<b>edgecolors</b>20<b>c</b>25<b>facecolor</b>30<b>facecolors</b>35<b>color</b>40acecolor</b>30<b>facecolors</b>35/b>25<b>facecolor</b>30ors</b>20<b>c</b>25>15<b>edgecolors</b>20hs</b>15>10y</b>50, *y*, *s*, *linewidths*, *edgecolors*, *c*, *facecolor*, *facecolors*, *color*.
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param x float or array-like, shape (n, )<br>
     *          The data positions.
     *          
     * @param y float or array-like, shape (n, )<br>
     *          The data positions.
     *          
     * @param s float or array-like, shape (n, ), optional<br>
     *          The marker size in points**2.
     *          Default is ``rcParams['lines.markersize'] ** 2``.
     *          
     * @param c array-like or list of colors or color, optional<br>
     *          The marker colors. Possible values:
     *          
     *          - A scalar or sequence of n numbers to be mapped to colors using
     *          <b>cmap</b>0 and<b>norm</b>5*norm*.
     *          - A 2D array in which the rows are RGB or RGBA.
     *          - A sequence of colors of length n.
     *          - A single color format string.
     *          
     *          Not<b>c</b>10    Note that *c* should not be a single numeric RGB or RGBA sequence
     *          because that is indistinguishable from an array of values to be
     *          colormapped. If you want to specify the same RGB or RGBA value for
     *          all points, use a 2D array with a single row.  Otherwise, value-
     *          matching will have precedence in case of a <b>x</b>15n case of a size ma<b>y</b>20case of a size matching with *x*
     *          and *y*.
     *          
     *          If you wish to specify<b>color</b>25ou wish to specify a single color for all points
     *          prefer the *color* keyword argument.
     *          
     *          Defaults to<b>color</b>30<b>facecolor</b>35ef<b>facecolors</b>40or</b>30<b>facecolor</b>35efaults to<b>color</b>30 *          Defaults to `None`. In that case the marker color is determined
     *          by the value of *color*, *facecolor* or *facecolors*. In case
     *          those are not specified or `None`, the marker color is determined
     *          by the next color of the ``Axes``' current "shape and fill" color
     *          cycle. This cycle defaults to :rc:`axes.prop_cycle`.
     *          
     * @param marker `~.markers.MarkerStyle`, default: :rc:`scatter.marker`<br>
     *               The marker style. <b>marker</b>0 can be either an instance of the class
     *               or the text shorthand for a particular marker.
     *               See :mod:`matplotlib.markers` for more information about marker
     *               styles.
     *               
     * @param cmap str or `~matplotlib.colors.Colormap`, default: :rc:`image.cmap`<br>
     *             A `.Colormap` instance or registered colormap name. <b>cmap</b>0 is only
     *             used if<b>c</b>5if *c* is an array of floats.
     *             
     * @param norm `~matplotlib.colors.Normalize`, default: None<br>
     *             If <b>c</b>0 is an array of floats,<b>norm</b>5*norm* is used to scale the color
     *            <b>c</b>10        data, *c*, in the range 0 to 1, in order to map into the colormap
<b>cmap</b>15colormap
     *       <b>None</b>20
     *             *cmap*.
     *             If *None*, use the default `.colors.Normalize`.
     *             
     * @param vmin float, default: None<br>
     *             <b>vmin</b>0 and<b>vmax</b>5*vmax* are used in conjunction with the default norm to
     *             map the color<b>c</b>10e color array *<b>cmap</b>15r array *c* to the colormap *cmap*. If None, the
     *             respective min and max of the color array is used.
     * <b>vmin</b>2<b>vmax</b>25    <b>norm</b>30in</b>2<b>vmax</b>25     * <b>vmin</b>20 used.
     *             It is deprecated to use *vmin*/*vmax* when *norm* is given.
     *             
     * @param vmax float, default: None<br>
     *             <b>vmin</b>0 and<b>vmax</b>5*vmax* are used in conjunction with the default norm to
     *             map the color<b>c</b>10e color array *<b>cmap</b>15r array *c* to the colormap *cmap*. If None, the
     *             respective min and max of the color array is used.
     * <b>vmin</b>2<b>vmax</b>25    <b>norm</b>30in</b>2<b>vmax</b>25     * <b>vmin</b>20 used.
     *             It is deprecated to use *vmin*/*vmax* when *norm* is given.
     *             
     * @param alpha float, default: None<br>
     *              The alpha blending value, between 0 (transparent) and 1 (opaque).
     *              
     * @param linewidths float or array-like, default: :rc:`lines.linewidth`<br>
     *                   The linewidth of the marker edges. Note: The default <b>edgecolors</b>0
     *                   is 'face'. You may want to change this as well.
     *                   
     * @param edgecolors &#123;'face', 'none', <b>None</b>0&#125; or color or sequence of color, default: :rc:`scatter.edgecolors`<br>
     *                   The edge color of the marker. Possible values:
     *                   
     *                   - 'face': The edge color will always be the same as the face color.
     *                   - 'none': No patch boundary will be drawn.
     *                   - A color or sequence of colors.
     *                   
     *                   For non-filled markers,<b>edgecolors</b>5olors* is ignored. Instead, the color
     *                   is determined like with 'face', i.e<b>c</b>10<b>colors</b>15c</b>10e', i.e. from *c*, *c<b>facecolors</b>20 *c*, *colors*, or
     *                   *facecolors*.
     *                   
     * @param plotnonfinite bool, default: False<br>
     *                      Whether to plot points with nonfinite <b>c</b>0 (i.e. ``inf``, ``-inf``
     *                      or ``nan``). If ``True`` the points are drawn with the<b>bad</b>5 *bad*
     *                      colormap color (see `.Colormap.set_bad`).
     * @param **kwargs `~matplotlib.collections.Collection` properties<br>
     * @param data n/a<br>undocumented
     * 
     * @return `~matplotlib.collections.PathCollection` <br>
     */
    public final Object scatter(Object x, Object y, Object... args) {
        write("plt.scatter("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(y)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the current image.
     * 
     * This image will be the target of colormap functions like
     * `~.pyplot.viridis`, and other functions such as `~.pyplot.clim`.  The
     * current image is an attribute of the current axes.
     * 
     * @param im n/a<br>undocumented
     */
    public final Object sci(Object... args) {
        write("plt.sci("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Make a plot with log scaling on the x axis.
     * 
     * Call signatures::
     * 
     * semilogx([x], y, [fmt], data=None, **kwargs)
     * semilogx([x], y, [fmt], [x2], y2, [fmt2], ..., **kwargs)
     * 
     * This is just a thin wrapper around `.plot` which additionally changes
     * the x-axis to log scaling. All of the concepts and parameters of plot
     * can be used here as well.
     * 
     * The additional parameters <b>base</b>0,<b>subs</b>5*subs<b>nonpositive</b>10and *nonpositive* control the
     * x-axis properties. They are just forwarded to `.Axes.set_xscale`.
     * 
     * @param base float, default: 10<br>
     *             Base of the x logarithm.
     *             
     * @param subs array-like, optional<br>
     *             The location of the minor xticks. If <b>None</b>0, reasonable locations
     *             are automatically chosen depending on the number of decades in the
     *             plot. See `.Axes.set_xscale` for details.
     *             
     * @param nonpositive &#123;'mask', 'clip'&#125;, default: 'mask'<br>
     *                    Non-positive values in x can be masked as invalid, or clipped to a
     *                    very small positive number.
     * @param **kwargs <br>
     *                 All parameters supported by `.plot`.
     * @param *args n/a<br>undocumented
     * 
     * @return list of `~.Line2D` <br>
     *                            Objects representing the plotted data.
     */
    public final Object semilogx(Object... args) {
        write("plt.semilogx("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Make a plot with log scaling on the y axis.
     * 
     * Call signatures::
     * 
     * semilogy([x], y, [fmt], data=None, **kwargs)
     * semilogy([x], y, [fmt], [x2], y2, [fmt2], ..., **kwargs)
     * 
     * This is just a thin wrapper around `.plot` which additionally changes
     * the y-axis to log scaling. All of the concepts and parameters of plot
     * can be used here as well.
     * 
     * The additional parameters <b>base</b>0,<b>subs</b>5*subs<b>nonpositive</b>10and *nonpositive* control the
     * y-axis properties. They are just forwarded to `.Axes.set_yscale`.
     * 
     * @param base float, default: 10<br>
     *             Base of the y logarithm.
     *             
     * @param subs array-like, optional<br>
     *             The location of the minor yticks. If <b>None</b>0, reasonable locations
     *             are automatically chosen depending on the number of decades in the
     *             plot. See `.Axes.set_yscale` for details.
     *             
     * @param nonpositive &#123;'mask', 'clip'&#125;, default: 'mask'<br>
     *                    Non-positive values in y can be masked as invalid, or clipped to a
     *                    very small positive number.
     * @param **kwargs <br>
     *                 All parameters supported by `.plot`.
     * @param *args n/a<br>undocumented
     * 
     * @return list of `~.Line2D` <br>
     *                            Objects representing the plotted data.
     */
    public final Object semilogy(Object... args) {
        write("plt.semilogy("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the default colormap, and applies it to the current image if any.
     * 
     * @param cmap `~matplotlib.colors.Colormap` or str<br>
     *             A colormap instance or the name of a registered colormap.
     */
    public final Object set_cmap(Object cmap) {
        write("plt.set_cmap("+PythonGrammar.toPythonArgs(cmap)+")");
        return null;
    }

    /**
     * Set Matplotlib's root logger and root logger handler level, creating
     * the handler if it does not exist yet.
     * 
     * Typically, one should call ``set_loglevel("info")`` or
     * ``set_loglevel("debug")`` to get additional debugging information.
     * <p>
     * <em>Notes:</em><br>
     * The first time this function is called, an additional handler is attached
     * to Matplotlib's root handler; this handler is reused every time and this
     * function simply manipulates the logger and handler's level.
     * 
     * @param level &#123;"notset", "debug", "info", "warning", "error", "critical"&#125;<br>
     *              The log level of the handler.
     */
    public final Object set_loglevel(Object level) {
        write("plt.set_loglevel("+PythonGrammar.toPythonArgs(level)+")");
        return null;
    }

    /**
     * Set one or more properties on an `.Artist`, or list allowed values.
     * 
     * @param obj `.Artist` or list of `.Artist`<br>
     *            The artist(s) whose properties are being set or queried.  When setting
     *            properties, all artists are affected; when querying the allowed values,
     *            only the first instance in the sequence is queried.
     *            
     *            For example, two lines can be made thicker and red with a single call:
     *            
     *            &gt;&gt;&gt; x = arange(0, 1, 0.01)
     *            &gt;&gt;&gt; lines = plot(x, sin(2<b>pi</b>0x), x, sin(<b>pi</b>5(4*pi*x))
     *            &gt;&gt;&gt; setp(lines, linewidth=2, color='r')
     *            
     * @param file file-like, default: `sys.stdout`<br>
     *             Where `setp` writes its output when asked to list allowed values.
     *             
     *             &gt;&gt;&gt; with open('output.log') as file:
     *             ...     setp(line, file=file)
     *             
     *             The default, ``None``, means `sys.stdout`.
     *             
     * @param *args <br>
     *              The properties to set.  The following combinations are supported:
     *              
     *              - Set the linestyle of a line to be dashed:
     *              
     *              &gt;&gt;&gt; line, = plot([1, 2, 3])
     *              &gt;&gt;&gt; setp(line, linestyle='--')
     *              
     *              - Set multiple properties at once:
     *              
     *              &gt;&gt;&gt; setp(line, linewidth=2, color='r')
     *              
     *              - List allowed values for a line's linestyle:
     *              
     *              &gt;&gt;&gt; setp(line, 'linestyle')
     *              linestyle: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *              
     *              - List all properties that can be set, and their allowed values:
     *              
     *              &gt;&gt;&gt; setp(line)
     *              agg_filter: a filter function, ...
     *              [long output listing omitted]
     *              
     *              `setp` also supports MATLAB style string/value pairs.  For example, the
     *              following are equivalent:
     *              
     *              &gt;&gt;&gt; setp(lines, 'linewidth', 2, 'color', 'r')  # MATLAB style
     *              &gt;&gt;&gt; setp(lines, linewidth=2, color='r')        # Python style
     * @param **kwargs <br>
     *                 The properties to set.  The following combinations are supported:
     *                 
     *                 - Set the linestyle of a line to be dashed:
     *                 
     *                 &gt;&gt;&gt; line, = plot([1, 2, 3])
     *                 &gt;&gt;&gt; setp(line, linestyle='--')
     *                 
     *                 - Set multiple properties at once:
     *                 
     *                 &gt;&gt;&gt; setp(line, linewidth=2, color='r')
     *                 
     *                 - List allowed values for a line's linestyle:
     *                 
     *                 &gt;&gt;&gt; setp(line, 'linestyle')
     *                 linestyle: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *                 
     *                 - List all properties that can be set, and their allowed values:
     *                 
     *                 &gt;&gt;&gt; setp(line)
     *                 agg_filter: a filter function, ...
     *                 [long output listing omitted]
     *                 
     *                 `setp` also supports MATLAB style string/value pairs.  For example, the
     *                 following are equivalent:
     *                 
     *                 &gt;&gt;&gt; setp(lines, 'linewidth', 2, 'color', 'r')  # MATLAB style
     *                 &gt;&gt;&gt; setp(lines, linewidth=2, color='r')        # Python style
     */
    public final Object setp(Object obj, Object args, Object... args) {
        write("plt.setp("+PythonGrammar.toPythonArgs(obj),PythonGrammar.toPythonArgs(args)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Display all open figures.
     * 
     * In non-interactive mode, <b>block</b>0 defaults to True.  All figures
     * will display and show will not return until all windows are closed.
     * If there are no figures, return immediately.
     * 
     * In interactive mode <b>block</b>0 defaults to False.  This will ensure
     * that all of the figures are shown and this function immediately returns.
     * 
     * @param block bool, optional<br>
     *              
     *              If `True` block and run the GUI main loop until all windows
     *              are closed.
     *              
     *              If `False` ensure that all windows are displayed and return
     *              immediately.  In this case, you are responsible for ensuring
     *              that the event loop is running to have responsive figures.
     */
    public final Object show(Object... args) {
        write("plt.show("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Plot a spectrogram.
     * 
     * Compute and plot a spectrogram of data in <b>x</b>0.  Data are split into
     * <b>NFFT</b>0 length segments and the spectrum of each section is
     * computed.  The windowing function <b>window</b>0 is applied to each
     * segment, and the amount of overlap of each segment is
     * specified with <b>noverlap</b>0. The spectrogram is plotted as a colormap
     * (using imshow).
     * <p>
     * <em>Notes:</em><br>
     * The parameters <b>detrend</b>0 and<b>scale_by_freq</b>5_freq* do only appl<b>mode</b>10apply when *mode*
     * is set to 'psd'.
     * 
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * the following arguments can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception):
     * <b>x</b>0.
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param x 1-D array or sequence<br>
     *          Array or sequence containing the data.
     *          
     * @param Fs float, default: 2<br>
     *           The sampling frequency (samples per time unit).  It is used to calculate
     *           the Fourier frequencies, <b>freqs</b>0, in cycles per time unit.
     *           
     * @param window callable or ndarray, default: `.window_hanning`<br>
     *               A function or a vector of length <b>NFFT</b>0.  To create window vectors see
     *               `.window_hanning`, `.window_none`, `numpy.blackman`, `numpy.hamming`,
     *               `numpy.bartlett`, `scipy.signal`, `scipy.signal.get_window`, etc.  If a
     *               function is passed as the argument, it must take a data segment as an
     *               argument and return the windowed version of the segment.
     *               
     * @param sides &#123;'default', 'onesided', 'twosided'&#125;, optional<br>
     *              Which sides of the spectrum to return. 'default' is one-sided for real
     *              data and two-sided for complex data. 'onesided' forces the return of a
     *              one-sided spectrum, while 'twosided' forces two-sided.
     *              
     * @param pad_to int, optional<br>
     *               The number of points to which the data segment is padded when performing
     *               the FFT.  This can be different from <b>NFFT</b>0, which specifies the number
     *               of data points used.  While not increasing the actual resolution of the
     *               spectrum (the minimum distance between resolvable peaks), this can give
     *               more points in the plot, allowing for more detail. This corresponds to
     *               the<b>n</b>5he *n* parameter in the call to fft(). The default is None, which sets
     *        <b>pad_to</b>10        <b>NFFT</b>150         *pad_to* equal to *NFFT*
     *               
     * @param NFFT int, default: 256<br>
     *             The number of data points used in each block for the FFT.  A power 2 is
     *             most efficient.  This should <b>NOT</b>0 be used to get zero padding, or the
     *             scaling of the result will be incorrect; use<b>pad_to</b>5ad_to* for this instead.
     *             
     * @param detrend &#123;'none', 'mean', 'linear'&#125; or callable, default: 'none'<br>
     *                The function applied to each segment before fft-ing, designed to remove
     *                the mean or linear trend.  Unlike in MATLAB, where the <b>detrend</b>0 parameter
     *                is a vector, in Matplotlib is it a function.  The :mod:`~matplotlib.mlab`
     *                module defines `.detrend_none`, `.detrend_mean`, and `.detrend_linear`,
     *                but you can use a custom function as well.  You can also use a string to
     *                choose one of the functions: 'none' calls `.detrend_none`. 'mean' calls
     *                `.detrend_mean`. 'linear' calls `.detrend_linear`.
     *                
     * @param scale_by_freq bool, default: True<br>
     *                      Whether the resulting density values should be scaled by the scaling
     *                      frequency, which gives density in units of Hz^-1.  This allows for
     *                      integration over the returned frequency values.  The default is True for
     *                      MATLAB compatibility.
     *                      
     * @param mode &#123;'default', 'psd', 'magnitude', 'angle', 'phase'&#125;<br>
     *             What sort of spectrum to use.  Default is 'psd', which takes the
     *             power spectral density.  'magnitude' returns the magnitude
     *             spectrum.  'angle' returns the phase spectrum without unwrapping.
     *             'phase' returns the phase spectrum with unwrapping.
     *             
     * @param noverlap int, default: 128<br>
     *                 The number of points of overlap between blocks.
     *                 
     * @param scale &#123;'default', 'linear', 'dB'&#125;<br>
     *              The scaling of the values in the <b>spec</b>0.  'linear' is no scaling.
     *              'dB' returns the values in dB scale.  When<b>mode</b>5*mode* is 'psd',
     *              this is dB power (10 * log10).  Otherwise this is dB amplitude
     *              (20 * log10). 'default' is '<b>mode</b>10is 'dB' if *mode* is 'psd' or
     *              'magnitude' and 'linear' otherwise.  This must be 'linear'
    <b>mode</b>15ear'
     *              if *mode* is 'angle' or 'phase'.
     *              
     * @param Fc int, default: 0<br>
     *           The center frequency of <b>x</b>0, which offsets the x extents of the
     *           plot to reflect the frequency range used when a signal is acquired
     *           and then filtered and downsampled to baseband.
     *           
     * @param cmap `.Colormap`, default: :rc:`image.cmap`<br>
     *             
     * @param xextent <b>None</b>0 or (xmin, xmax)<br>
     *                The image extent along the x-axis. The default sets<b>xmin</b>5*xmin* to the
     *                left border of the firs<b>spectrum</b>10t bin (*spe<b>xmax</b>15bin (*spectrum* column) and *xmax* to the
     *                right border of the last bin. Note that for *noverlap&gt;0* the width
     *                of the bins is smaller than those of the segments.
     *                
     * @param **kwargs <br>
     *                 Additional keyword arguments are passed on to `~.axes.Axes.imshow`
     *                 which makes the specgram image. The origin keyword argument
     *                 is not supported.
     * @param vmin n/a<br>undocumented
     * @param vmax n/a<br>undocumented
     * @param data n/a<br>undocumented
     * 
     * @return (spectrum,freqs,t,im) (2D array,1-D array,1-D array,`.AxesImage`)<br>
     *          Columns are the periodograms of successive segments.
     *          
     *          
     *          The frequencies corresponding to the rows in <b>spectrum</b>0.
     *          
     *          
     *          The times corresponding to midpoints of segments (i.e., the columns
     *          in<b>spectrum</b>5ctrum*).
     *          
     *          
     *          The image created by imshow containing the spectrogram.
     */
    public final Object specgram(Object x, Object... args) {
        write("plt.specgram("+PythonGrammar.toPythonArgs(x)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the colormap to 'spring'.
     * 
     * This changes the default colormap as well as the colormap of the current
     * image if there is one. See ``help(colormaps)`` for more information.
     */
    public final Object spring() {
        write("plt.spring()");
        return null;
    }

    /**
     * Plot the sparsity pattern of a 2D array.
     * 
     * This visualizes the non-zero values of the array.
     * 
     * Two plotting styles are available: image and marker. Both
     * are available for full arrays, but only the marker style
     * works for `scipy.sparse.spmatrix` instances.
     * 
     * **Image style**
     * 
     * If <b>marker</b>0 and<b>markersize</b>5rsiz<b>None</b>10rsize* are *None*, `~.Axes.imshow` is used. Any
     * extra remaining keyword arguments are passed to this method.
     * 
     * **Marker style**
     * 
     * If <b>Z</b>0 is a `scipy.sparse.spmatrix` or<b>marker</b>5ark<b>markersize</b>10* or *markersize* are
     * <b>None</b>0, a `.Line2D` object will be returned with the value of marker
     * determining the marker type, and any remaining keyword arguments
     * passed to `~.Axes.plot`.
     * 
     * @param Z (M, N) array-like<br>
     *          The array to be plotted.
     *          
     * @param precision float or 'present', default: 0<br>
     *                  If <b>precision</b>0 is 0, any non-zero value will be plotted. Otherwise,
     *                  values of :math:`|Z| &gt; precision` will be plotted.
     *                  
     *                  For `scipy.sparse.spmatrix` instances, you can also
     *                  pass 'present'. In this case any value present in the array
     *                  will be plotted, even if it is identically zero.
     *                  
     * @param aspect &#123;'equal', 'auto', None&#125; or float, default: 'equal'<br>
     *               The aspect ratio of the Axes.  This parameter is particularly
     *               relevant for images since it determines whether data pixels are
     *               square.
     *               
     *               This parameter is a shortcut for explicitly calling
     *               `.Axes.set_aspect`. See there for further details.
     *               
     *               - 'equal': Ensures an aspect ratio of 1. Pixels will be square.
     *               - 'auto': The Axes is kept fixed and the aspect is adjusted so
     *               that the data fit in the Axes. In general, this will result in
     *               non-square pixels.
     *               - <b>None</b>0: Use :rc:`image.aspect`.
     *               
     * @param origin &#123;'upper', 'lower'&#125;, default: :rc:`image.origin`<br>
     *               Place the [0, 0] index of the array in the upper left or lower left
     *               corner of the Axes. The convention 'upper' is typically used for
     *               matrices and images.
     * @param **kwargs <br>
     *                 The supported additional parameters depend on the plotting style.
     *                 
     *                 For the image style, you can pass the following additional
     *                 parameters of `~.Axes.imshow`:
     *                 
     *                 - <b>cmap</b>0
     *                 -<b>alpha</b>5alpha*
     *            <b>url</b>10          - *url*
     *                 - any `.Artist` properties (passed on to the `.AxesImage`)
     *                 
     *                 For the marker style, you can pass any `.Line2D` property except
     *  <b>linestyle</b>15 *                 for *linestyle*:
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: scalar or None
     *                 animated: bool
     *                 antialiased or aa: bool
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 color or c: color
     *                 contains: unknown
     *                 dash_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 dash_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 dashes: sequence of floats (on/off ink in points) or (None, None)
     *                 data: (2, N) array or two 1D arrays
     *                 drawstyle or ds: &#123;'default', 'steps', 'steps-pre', 'steps-mid', 'steps-post'&#125;, default: 'default'
     *                 figure: `.Figure`
     *                 fillstyle: &#123;'full', 'left', 'right', 'bottom', 'top', 'none'&#125;
     *                 gid: str
     *                 in_layout: bool
     *                 label: object
     *                 linestyle or ls: &#123;'-', '--', '-.', ':', '', (offset, on-off-seq), ...&#125;
     *                 linewidth or lw: float
     *                 marker: marker style string, `~.path.Path` or `~.markers.MarkerStyle`
     *                 markeredgecolor or mec: color
     *                 markeredgewidth or mew: float
     *                 markerfacecolor or mfc: color
     *                 markerfacecoloralt or mfcalt: color
     *                 markersize or ms: float
     *                 markevery: None or int or (int, int) or slice or list[int] or float or (float, float) or list[bool]
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: float or callable[[Artist, Event], tuple[bool, dict]]
     *                 pickradius: float
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 solid_capstyle: `.CapStyle` or &#123;'butt', 'projecting', 'round'&#125;
     *                 solid_joinstyle: `.JoinStyle` or &#123;'miter', 'round', 'bevel'&#125;
     *                 transform: `matplotlib.transforms.Transform`
     *                 url: str
     *                 visible: bool
     *                 xdata: 1D array
     *                 ydata: 1D array
     *                 zorder: float
     * @param marker n/a<br>undocumented
     * @param markersize n/a<br>undocumented
     * 
     * @return `~matplotlib.image.AxesImage` or `.Line2D` <br>
     *                                                    The return type depends on the plotting style (see above).
     */
    public final Object spy(Object Z, Object... args) {
        write("plt.spy("+PythonGrammar.toPythonArgs(Z)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Draw a stacked area plot.
     * <p>
     * <em>Notes:</em><br>
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * every other argument can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception).
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param x (N,) array-like<br>
     *          
     * @param y (M, N) array-like<br>
     *          The data is assumed to be unstacked. Each of the following
     *          calls is legal::
     *          
     *          stackplot(x, y)           # where y has shape (M, N)
     *          stackplot(x, y1, y2, y3)  # where y1, y2, y3, y4 have length N
     *          
     * @param baseline &#123;'zero', 'sym', 'wiggle', 'weighted_wiggle'&#125;<br>
     *                 Method used to calculate the baseline:
     *                 
     *                 - ``'zero'``: Constant zero baseline, i.e. a simple stacked plot.
     *                 - ``'sym'``:  Symmetric around zero and is sometimes called
     *                 'ThemeRiver'.
     *                 - ``'wiggle'``: Minimizes the sum of the squared slopes.
     *                 - ``'weighted_wiggle'``: Does the same but weights to account for
     *                 size of each layer. It is also called 'Streamgraph'-layout. More
     *                 details can be found at http://leebyron.com/streamgraph/.
     *                 
     * @param labels Length N list of str<br>
     *               Labels to assign to each data series.
     *               
     * @param colors Length N list of color<br>
     *               A list or tuple of colors. These will be cycled through and used to
     *               colour the stacked areas.
     *               
     * @param **kwargs <br>
     *                 All other keyword arguments are passed to `.Axes.fill_between`.
     * @param *args n/a<br>undocumented
     * @param data n/a<br>undocumented
     * 
     * @return list of `.PolyCollection` <br>
     *                                   A list of `.PolyCollection` instances, one for each element in the
     *                                   stacked area plot.
     */
    public final Object stackplot(Object x, Object... args) {
        write("plt.stackplot("+PythonGrammar.toPythonArgs(x)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * A stepwise constant function as a line with bounding edges
     * or a filled plot.
     * <p>
     * <em>Notes:</em><br>
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * every other argument can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception).
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param values array-like<br>
     *               The step heights.
     *               
     * @param edges array-like<br>
     *              The edge positions, with ``len(edges) == len(vals) + 1``,
     *              between which the curve takes on vals values.
     *              
     * @param orientation &#123;'vertical', 'horizontal'&#125;, default: 'vertical'<br>
     *                    The direction of the steps. Vertical means that <b>values</b>0 are along
     *                    the y-axis, and edges are along the x-axis.
     *                    
     * @param baseline float, array-like or None, default: 0<br>
     *                 The bottom value of the bounding edges or when
     *                 ``fill=True``, position of lower edge. If <b>fill</b>0 is
     *                 True or an array is passed to<b>baseline</b>5eline*, a closed
     *                 path is drawn.
     *                 
     * @param fill bool, default: False<br>
     *             Whether the area under the step curve should be filled.
     * @param **kwargs <br>
     *                 `~matplotlib.patches.StepPatch` properties
     * @param data n/a<br>undocumented
     * 
     * @return StepPatch `matplotlib.patches.StepPatch`<br>
     */
    public final Object stairs(Object values, Object... args) {
        write("plt.stairs("+PythonGrammar.toPythonArgs(values)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Create a stem plot.
     * 
     * A stem plot draws lines perpendicular to a baseline at each location
     * <b>locs</b>0 from the baseline to<b>heads</b>5heads*, and places a marker there. For
     * vertical stem plots (the default), the <b>locs</b>0 are<b>x</b>5re *x* positions, and
     * the <b>heads</b>0 are<b>y</b>5re *y* values. For horizontal stem plot<b>locs</b>10plots, the *locs* are
     * <b>y</b>0 positions, and the<b>heads</b>5head<b>x</b>10b>5heads* are *x* values.
     * 
     * Call signature::
     * 
     * stem([locs,] heads, linefmt=None, markerfmt=None, basefmt=None)
     * 
     * The <b>locs</b>0-positions are optional. The formats may be provided either
     * as positional or as keyword-arguments.
     * <p>
     * <em>Notes:</em><br>
     * .. seealso::
     * The MATLAB function
     * `stem <https://www.mathworks.com/help/matlab/ref/stem.html>`_
     * which inspired this method.
     * 
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * every other argument can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception).
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param locs array-like, default: (0, 1, ..., len(heads) - 1)<br>
     *             For vertical stem plots, the x-positions of the stems.
     *             For horizontal stem plots, the y-positions of the stems.
     *             
     * @param heads array-like<br>
     *              For vertical stem plots, the y-values of the stem heads.
     *              For horizontal stem plots, the x-values of the stem heads.
     *              
     * @param linefmt str, optional<br>
     *                A string defining the color and/or linestyle of the vertical lines:
     *                
     *                =========  =============
     *                Character  Line Style
     *                =========  =============
     *                ``'-'``    solid line
     *                ``'--'``   dashed line
     *                ``'-.'``   dash-dot line
     *                ``':'``    dotted line
     *                =========  =============
     *                
     *                Default: 'C0-', i.e. solid line with the first color of the color
     *                cycle.
     *                
     *                Note: Markers specified through this parameter (e.g. 'x') will be
     *                silently ignored (unless using ``use_line_collection=False``).
     *                Instead, markers should be specified using <b>markerfmt</b>0.
     *                
     * @param markerfmt str, optional<br>
     *                  A string defining the color and/or shape of the markers at the stem
     *                  heads.  Default: 'C0o', i.e. filled circles with the first color of
     *                  the color cycle.
     *                  
     * @param basefmt str, default: 'C3-' ('C2-' in classic mode)<br>
     *                A format string defining the properties of the baseline.
     *                
     * @param orientation str, default: 'vertical'<br>
     *                    If 'vertical', will produce a plot with stems oriented vertically,
     *                    otherwise the stems will be oriented horizontally.
     *                    
     * @param bottom float, default: 0<br>
     *               The y/x-position of the baseline (depending on orientation).
     *               
     * @param label str, default: None<br>
     *              The label to use for the stems in legends.
     *              
     * @param use_line_collection bool, default: True<br>
     *                            If ``True``, store and plot the stem lines as a
     *                            `~.collections.LineCollection` instead of individual lines, which
     *                            significantly increases performance.  If ``False``, defaults to the
     *                            old behavior of using a list of `.Line2D` objects.  This parameter
     *                            may be deprecated in the future.
     * @param *args n/a<br>undocumented
     * @param data n/a<br>undocumented
     * 
     * @return `.StemContainer` <br>
     *                          The container may be treated like a tuple
     *                          (<b>markerline</b>0,<b>stemlines</b>5l<b>baseline</b>10ines*, *baseline*)
     */
    public final Object stem(Object... args) {
        write("plt.stem("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Make a step plot.
     * 
     * Call signatures::
     * 
     * step(x, y, [fmt], *, data=None, where='pre', **kwargs)
     * step(x, y, [fmt], x2, y2, [fmt2], ..., *, where='pre', **kwargs)
     * 
     * This is just a thin wrapper around `.plot` which changes some
     * formatting options. Most of the concepts and parameters of plot can be
     * used here as well.
     * 
     * .. note::
     * 
     * This method uses a standard plot with a step drawstyle: The <b>x</b>0
     * values are the reference positions and steps extend left/right/both
     * directions depending on <b>where</b>0.
     * 
     * For the common case where you know the values and edges of the
     * steps, use `~.Axes.stairs` instead.
     * <p>
     * <em>Notes:</em><br>
     * .. [notes section required to get data note injection right]
     * 
     * @param x array-like<br>
     *          1D sequence of x positions. It is assumed, but not checked, that
     *          it is uniformly increasing.
     *          
     * @param y array-like<br>
     *          1D sequence of y levels.
     *          
     * @param fmt str, optional<br>
     *            A format string, e.g. 'g' for a green line. See `.plot` for a more
     *            detailed description.
     *            
     *            Note: While full format strings are accepted, it is recommended to
     *            only specify the color. Line styles are currently ignored (use
     *            the keyword argument <b>linestyle</b>0 instead). Markers are accepted
     *            and plotted on the given positions, however, this is a rarely
     *            needed feature for step plots.
     *            
     * @param data indexable object, optional<br>
     *             An object with labelled data. If given, provide the label names to
     *             plot in <b>x</b>0 and<b>y</b>5nd *y*.
     *             
     * @param where &#123;'pre', 'post', 'mid'&#125;, default: 'pre'<br>
     *              Define where the steps should be placed:
     *              
     *              - 'pre': The y value is continued constantly to the left from
     *              every <b>x</b>0 position, i.e. the interval ``(x[i-1], x[i]]`` has the
     *              value ``y[i]``.
     *              - 'post': The y value is continued constantly to the right from
     *              every<b>x</b>5ry *x* position, i.e. the interval ``[x[i], x[i+1])`` has the
     *              value ``y[i]``.
     *              - 'mid': Steps occur half-way betwe<b>x</b>10y between the *x* positions.
     * @param **kwargs <br>
     *                 Additional parameters are the same as those for `.plot`.
     * @param *args n/a<br>undocumented
     * 
     * @return list of `.Line2D` <br>
     *                           Objects representing the plotted data.
     */
    public final Object step(Object x, Object y, Object... args) {
        write("plt.step("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(y)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Draw streamlines of a vector flow.
     * <p>
     * <em>Notes:</em><br>
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * the following arguments can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception):
     * <b>x</b>0,<b>y</b>50<b>u</b>10<b>v</b>15<b>start_points</b>20</b>1550<b>u</b>10y</b>50, *y*, *u*, *v*, *start_points*.
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param x 1D/2D arrays<br>
     *          Evenly spaced strictly increasing arrays to make a grid.
     * @param y 1D/2D arrays<br>
     *          Evenly spaced strictly increasing arrays to make a grid.
     * @param u 2D arrays<br>
     *          <b>x</b>0 and<b>y</b>5nd *y*-velocities. The number of rows and columns must match
     *          the len<b>y</b>10the<b>x</b>15b>y</b>10the length of *y* and *x*, respectively.
     * @param v 2D arrays<br>
     *          <b>x</b>0 and<b>y</b>5nd *y*-velocities. The number of rows and columns must match
     *          the len<b>y</b>10the<b>x</b>15b>y</b>10the length of *y* and *x*, respectively.
     * @param density float or (float, float)<br>
     *                Controls the closeness of streamlines. When ``density = 1``, the domain
     *                is divided into a 30x30 grid. <b>density</b>0 linearly scales this grid.
     *                Each cell in the grid can have, at most, one traversing streamline.
     *                For different densities in each direction, use a tuple
     *                (density_x, density_y).
     * @param linewidth float or 2D array<br>
     *                  The width of the stream lines. With a 2D array the line width can be
     *                  varied across the grid. The array must have the same shape as <b>u</b>0
     *                  and<b>v</b>5nd *v*.
     * @param color color or 2D array<br>
     *              The streamline color. If given an array, its values are converted to
     *              colors using <b>cmap</b>0 and<b>norm</b>5*norm*.  The array must have the same shape
     *          <b>u</b>10   <b>v</b>15b>u</b>10           as *u* and *v*.
     * @param cmap `~matplotlib.colors.Colormap`<br>
     *             Colormap used to plot streamlines and arrows. This is only used if
     *             <b>color</b>0 is an array.
     * @param norm `~matplotlib.colors.Normalize`<br>
     *             Normalize object used to scale luminance data to 0, 1. If ``None``,
     *             stretch (min, max) to (0, 1). This is only used if <b>color</b>0 is an array.
     * @param arrowsize float<br>
     *                  Scaling factor for the arrow size.
     * @param arrowstyle str<br>
     *                   Arrow style specification.
     *                   See `~matplotlib.patches.FancyArrowPatch`.
     * @param minlength float<br>
     *                  Minimum length of streamline in axes coordinates.
     * @param start_points Nx2 array<br>
     *                     Coordinates of starting points for the streamlines in data coordinates
     *                     (the same coordinates as the <b>x</b>0 and<b>y</b>5nd *y* arrays).
     * @param zorder int<br>
     *               The zorder of the stream lines and arrows.
     *               Artists with lower zorder values are drawn first.
     * @param maxlength float<br>
     *                  Maximum length of streamline in axes coordinates.
     * @param integration_direction &#123;'forward', 'backward', 'both'&#125;, default: 'both'<br>
     *                              Integrate the streamline in forward, backward or both directions.
     * @param transform n/a<br>undocumented
     * @param data n/a<br>undocumented
     * 
     * @return StreamplotSet <br>
     *                       Container object with attributes
     *                       
     *                       - ``lines``: `.LineCollection` of streamlines
     *                       
     *                       - ``arrows``: `.PatchCollection` containing `.FancyArrowPatch`
     *                       objects representing the arrows half-way along stream lines.
     *                       
     *                       This container will probably change in the future to allow changes
     *                       to the colormap, alpha, etc. for both lines and arrows, but these
     *                       changes should be backward compatible.
     */
    public final Object streamplot(Object x, Object y, Object u, Object v, Object... args) {
        write("plt.streamplot("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(y),PythonGrammar.toPythonArgs(u),PythonGrammar.toPythonArgs(v)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Add an Axes to the current figure or retrieve an existing Axes.
     * 
     * This is a wrapper of `.Figure.add_subplot` which provides additional
     * behavior when working with the implicit API (see the notes section).
     * 
     * Call signatures::
     * 
     * subplot(nrows, ncols, index, **kwargs)
     * subplot(pos, **kwargs)
     * subplot(**kwargs)
     * subplot(ax)
     * <p>
     * <em>Notes:</em><br>
     * Creating a new Axes will delete any pre-existing Axes that
     * overlaps with it beyond sharing a boundary::
     * 
     * import matplotlib.pyplot as plt
     * # plot a line, implicitly creating a subplot(111)
     * plt.plot([1, 2, 3])
     * # now create a subplot which represents the top plot of a grid
     * # with 2 rows and 1 column. Since this subplot will overlap the
     * # first, the plot (and its axes) previously created, will be removed
     * plt.subplot(211)
     * 
     * If you do not want this behavior, use the `.Figure.add_subplot` method
     * or the `.pyplot.axes` function instead.
     * 
     * If no <b>kwargs</b>0 are passed and there exists an Axes in the location
     * specified by <b>args</b>0 then that Axes will be returned rather than a new
     * Axes being created.
     * 
     * If <b>kwargs</b>0 are passed and there exists an Axes in the location
     * specified by <b>args</b>0, the projection type is the same, and the
     * <b>kwargs</b>0 match with the existing Axes, then the existing Axes is
     * returned.  Otherwise a new Axes is created with the specified
     * parameters.  We save a reference to the <b>kwargs</b>0 which we use
     * for this comparison.  If any of the values in <b>kwargs</b>0 are
     * mutable we will not detect the case where they are mutated.
     * In these cases we suggest using `.Figure.add_subplot` and the
     * explicit Axes API rather than the implicit pyplot API.
     * 
     * @param *args int, (int, int, <b>index</b>0), or `.SubplotSpec`, default: (1, 1, 1)<br>
     *              The position of the subplot described by one of
     *              
     *              - Three integers <b>nrows</b>5n<b>ncols</b>10<b>index</b>15ls</b>10>5nrows*, *ncols*, *index*). The subplo<b>index</b>20). The subplot will tak<b>nrows</b>25e subplo<b>ncols</b>30k<b>nrows</b>25e subplot wil<b>index</b>35k<b>nrows</b>25e subplot will take the
     *              *index* position on a gri<b>index</b>40        *index* position on a grid with<b>first</b>45       *index* posit<b>last</b>50 grid with<b>first</b>45       *<b>last</b>55osit<b>last</b>50 grid with<b>first</b>45       *index* position on a grid with *nrows* rows and *ncols* columns.
     *              *index* starts at 1 in the upper left corner and increases to the
     *              right. *index* can also be a two-tuple specifying the (*first*,
     *              *last*) indices (1-based, and including *last*) of the subplot, e.g.,
     *              ``fig.add_subplot(3, 1, (1, 2))`` makes a subplot that spans the
     *              upper 2/3 of the figure.
     *              - A 3-digit integer. The digits are interpreted as if given separately
     *              as three single-digit integers, i.e. ``fig.add_subplot(235)`` is the
     *              same as ``fig.add_subplot(2, 3, 5)``. Note that this can only be used
     *              if there are no more than 9 subplots.
     *              - A `.SubplotSpec`.
     *              
     * @param projection &#123;None, 'aitoff', 'hammer', 'lambert', 'mollweide', 'polar', 'rectilinear', str&#125;, optional<br>
     *                   The projection type of the subplot (`~.axes.Axes`). <b>str</b>0 is the name
     *                   of a custom projection, see `~matplotlib.projections`. The default
     *                   None results in a 'rectilinear' projection.
     *                   
     * @param polar bool, default: False<br>
     *              If True, equivalent to projection='polar'.
     *              
     * @param sharex `~.axes.Axes`, optional<br>
     *               Share the x or y `~matplotlib.axis` with sharex and/or sharey. The
     *               axis will have the same limits, ticks, and scale as the axis of the
     *               shared axes.
     *               
     * @param sharey `~.axes.Axes`, optional<br>
     *               Share the x or y `~matplotlib.axis` with sharex and/or sharey. The
     *               axis will have the same limits, ticks, and scale as the axis of the
     *               shared axes.
     *               
     * @param label str<br>
     *              A label for the returned axes.
     * @param **kwargs <br>
     *                 This method also takes the keyword arguments for the returned axes
     *                 base class; except for the <b>figure</b>0 argument. The keyword arguments
     *                 for the rectilinear base class `~.axes.Axes` can be found in
     *                 the following table but there might also be other keyword
     *                 arguments if another projection is used.
     *                 
     *                 Properties:
     *                 adjustable: &#123;'box', 'datalim'&#125;
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: scalar or None
     *                 anchor: 2-tuple of floats or &#123;'C', 'SW', 'S', 'SE', ...&#125;
     *                 animated: bool
     *                 aspect: &#123;'auto'&#125; or num
     *                 autoscale_on: bool
     *                 autoscalex_on: bool
     *                 autoscaley_on: bool
     *                 axes_locator: Callable[[Axes, Renderer], Bbox]
     *                 axisbelow: bool or 'line'
     *                 box_aspect: float or None
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 contains: unknown
     *                 facecolor or fc: color
     *                 figure: `.Figure`
     *                 frame_on: bool
     *                 gid: str
     *                 in_layout: bool
     *                 label: object
     *                 navigate: bool
     *                 navigate_mode: unknown
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: None or bool or float or callable
     *                 position: [left, bottom, width, height] or `~matplotlib.transforms.Bbox`
     *                 prop_cycle: unknown
     *                 rasterization_zorder: float or None
     *                 rasterized: bool
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 title: str
     *                 transform: `.Transform`
     *                 url: str
     *                 visible: bool
     *                 xbound: unknown
     *                 xlabel: str
     *                 xlim: (bottom: float, top: float)
     *                 xmargin: float greater than -0.5
     *                 xscale: &#123;"linear", "log", "symlog", "logit", ...&#125; or `.ScaleBase`
     *                 xticklabels: unknown
     *                 xticks: unknown
     *                 ybound: unknown
     *                 ylabel: str
     *                 ylim: (bottom: float, top: float)
     *                 ymargin: float greater than -0.5
     *                 yscale: &#123;"linear", "log", "symlog", "logit", ...&#125; or `.ScaleBase`
     *                 yticklabels: unknown
     *                 yticks: unknown
     *                 zorder: float
     * 
     * @return (`.axes.SubplotBase`,or another subclass of `~.axes.Axes`) (,)<br>
     *          
     *          The axes of the subplot. The returned axes base class depends on
     *          the projection used. It is `~.axes.Axes` if rectilinear projection
     *          is used and `.projections.polar.PolarAxes` if polar projection
     *          is used. The returned axes is then a subplot subclass of the
     *          base class.
     *          
     *          
     *          The axes of the subplot. The returned axes base class depends on
     *          the projection used. It is `~.axes.Axes` if rectilinear projection
     *          is used and `.projections.polar.PolarAxes` if polar projection
     *          is used. The returned axes is then a subplot subclass of the
     *          base class.
     */
    public final Object subplot(Object args, Object... args) {
        write("plt.subplot("+PythonGrammar.toPythonArgs(args)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Create a subplot at a specific location inside a regular grid.
     * <p>
     * <em>Notes:</em><br>
     * The following call ::
     * 
     * ax = subplot2grid((nrows, ncols), (row, col), rowspan, colspan)
     * 
     * is identical to ::
     * 
     * fig = gcf()
     * gs = fig.add_gridspec(nrows, ncols)
     * ax = fig.add_subplot(gs[row:row+rowspan, col:col+colspan])
     * 
     * @param shape (int, int)<br>
     *              Number of rows and of columns of the grid in which to place axis.
     * @param loc (int, int)<br>
     *            Row number and column number of the axis location within the grid.
     * @param rowspan int, default: 1<br>
     *                Number of rows for the axis to span downwards.
     * @param colspan int, default: 1<br>
     *                Number of columns for the axis to span to the right.
     * @param fig `.Figure`, optional<br>
     *            Figure to place the subplot in. Defaults to the current figure.
     * @param **kwargs <br>
     *                 Additional keyword arguments are handed to `~.Figure.add_subplot`.
     * 
     * @return (`.axes.SubplotBase`,or another subclass of `~.axes.Axes`) (,)<br>
     *          
     *          The axes of the subplot.  The returned axes base class depends on the
     *          projection used.  It is `~.axes.Axes` if rectilinear projection is used
     *          and `.projections.polar.PolarAxes` if polar projection is used.  The
     *          returned axes is then a subplot subclass of the base class.
     *          
     *          
     *          The axes of the subplot.  The returned axes base class depends on the
     *          projection used.  It is `~.axes.Axes` if rectilinear projection is used
     *          and `.projections.polar.PolarAxes` if polar projection is used.  The
     *          returned axes is then a subplot subclass of the base class.
     */
    public final Object subplot2grid(Object shape, Object loc, Object... args) {
        write("plt.subplot2grid("+PythonGrammar.toPythonArgs(shape),PythonGrammar.toPythonArgs(loc)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Launch a subplot tool window for a figure.
     * 
     * A `matplotlib.widgets.SubplotTool` instance is returned. You must maintain
     * a reference to the instance to keep the associated callbacks alive.
     * 
     * @param targetfig n/a<br>undocumented
     */
    public final Object subplot_tool(Object... args) {
        write("plt.subplot_tool("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Create a figure and a set of subplots.
     * 
     * This utility wrapper makes it convenient to create common layouts of
     * subplots, including the enclosing figure object, in a single call.
     * 
     * @param nrows int, default: 1<br>
     *              Number of rows/columns of the subplot grid.
     *              
     * @param ncols int, default: 1<br>
     *              Number of rows/columns of the subplot grid.
     *              
     * @param sharex bool or &#123;'none', 'all', 'row', 'col'&#125;, default: False<br>
     *               Controls sharing of properties among x (<b>sharex</b>0) or y <b>sharey</b>5harey*)
     *               axes:
     *               
     *               - True or 'all': x- or y-axis will be shared among all subplots.
     *               - False or 'none': each subplot x- or y-axis will be independent.
     *               - 'row': each subplot row will share an x- or y-axis.
     *               - 'col': each subplot column will share an x- or y-axis.
     *               
     *               When subplots have a shared x-axis along a column, only the x tick
     *               labels of the bottom subplot are created. Similarly, when subplots
     *               have a shared y-axis along a row, only the y tick labels of the first
     *               column subplot are created. To later turn other subplots' ticklabels
     *               on, use `~matplotlib.axes.Axes.tick_params`.
     *               
     *               When subplots have a shared axis that has units, calling
     *               `~matplotlib.axis.Axis.set_units` will update each axis with the
     *               new units.
     *               
     * @param sharey bool or &#123;'none', 'all', 'row', 'col'&#125;, default: False<br>
     *               Controls sharing of properties among x (<b>sharex</b>0) or y <b>sharey</b>5harey*)
     *               axes:
     *               
     *               - True or 'all': x- or y-axis will be shared among all subplots.
     *               - False or 'none': each subplot x- or y-axis will be independent.
     *               - 'row': each subplot row will share an x- or y-axis.
     *               - 'col': each subplot column will share an x- or y-axis.
     *               
     *               When subplots have a shared x-axis along a column, only the x tick
     *               labels of the bottom subplot are created. Similarly, when subplots
     *               have a shared y-axis along a row, only the y tick labels of the first
     *               column subplot are created. To later turn other subplots' ticklabels
     *               on, use `~matplotlib.axes.Axes.tick_params`.
     *               
     *               When subplots have a shared axis that has units, calling
     *               `~matplotlib.axis.Axis.set_units` will update each axis with the
     *               new units.
     *               
     * @param squeeze bool, default: True<br>
     *                - If True, extra dimensions are squeezed out from the returned
     *                array of `~matplotlib.axes.Axes`:
     *                
     *                - if only one subplot is constructed (nrows=ncols=1), the
     *                resulting single Axes object is returned as a scalar.
     *                - for Nx1 or 1xM subplots, the returned object is a 1D numpy
     *                object array of Axes objects.
     *                - for NxM, subplots with N&gt;1 and M&gt;1 are returned as a 2D array.
     *                
     *                - If False, no squeezing at all is done: the returned Axes object is
     *                always a 2D array containing Axes instances, even if it ends up
     *                being 1x1.
     *                
     * @param subplot_kw dict, optional<br>
     *                   Dict with keywords passed to the
     *                   `~matplotlib.figure.Figure.add_subplot` call used to create each
     *                   subplot.
     *                   
     * @param gridspec_kw dict, optional<br>
     *                    Dict with keywords passed to the `~matplotlib.gridspec.GridSpec`
     *                    constructor used to create the grid the subplots are placed on.
     *                    
     * @param **fig_kw <br>
     *                 All additional keyword arguments are passed to the
     *                 `.pyplot.figure` call.
     * 
     * @return (fig,ax) (`~.figure.Figure`,`.axes.Axes` or array of Axes)<br>
     *          
     *          
     *          <b>ax</b>0 can be either a single `~matplotlib.axes.Axes` object or an
     *          array of Axes objects if more than one subplot was created.  The
     *          dimensions of the resulting array can be controlled with the squeeze
     *          keyword, see above.
     *          
     *          Typical idioms for handling the return value are::
     *          
     *          # using the variable ax for single a Axes
     *          fig, ax = plt.subplots()
     *          
     *          # using the variable axs for multiple Axes
     *          fig, axs = plt.subplots(2, 2)
     *          
     *          # using tuple unpacking for multiple Axes
     *          fig, (ax1, ax2) = plt.subplots(1, 2)
     *          fig, ((ax1, ax2), (ax3, ax4)) = plt.subplots(2, 2)
     *          
     *          The names ``ax`` and pluralized ``axs`` are preferred over ``axes``
     *          because for the latter it's not clear if it refers to a single
     *          `~.axes.Axes` instance or a collection of these.
     */
    public final Object subplots(Object... args) {
        write("plt.subplots("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Adjust the subplot layout parameters.
     * 
     * Unset parameters are left unmodified; initial values are given by
     * :rc:`figure.subplot.[name]`.
     * 
     * @param left float, optional<br>
     *             The position of the left edge of the subplots,
     *             as a fraction of the figure width.
     * @param right float, optional<br>
     *              The position of the right edge of the subplots,
     *              as a fraction of the figure width.
     * @param bottom float, optional<br>
     *               The position of the bottom edge of the subplots,
     *               as a fraction of the figure height.
     * @param top float, optional<br>
     *            The position of the top edge of the subplots,
     *            as a fraction of the figure height.
     * @param wspace float, optional<br>
     *               The width of the padding between subplots,
     *               as a fraction of the average Axes width.
     * @param hspace float, optional<br>
     *               The height of the padding between subplots,
     *               as a fraction of the average Axes height.
     */
    public final Object subplots_adjust(Object... args) {
        write("plt.subplots_adjust("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the colormap to 'summer'.
     * 
     * This changes the default colormap as well as the colormap of the current
     * image if there is one. See ``help(colormaps)`` for more information.
     */
    public final Object summer() {
        write("plt.summer()");
        return null;
    }

    /**
     * Add a centered suptitle to the figure.
     * 
     * @param t str<br>
     *          The suptitle text.
     * @param x float, default: 0.5<br>
     *          The x location of the text in figure coordinates.
     * @param y float, default: 0.98<br>
     *          The y location of the text in figure coordinates.
     * @param horizontalalignment &#123;'center', 'left', 'right'&#125;, default: center<br>
     *                            The horizontal alignment of the text relative to (<b>x</b>0,<b>y</b>50, *y*).
     * @param ha &#123;'center', 'left', 'right'&#125;, default: center<br>
     *           The horizontal alignment of the text relative to (<b>x</b>0,<b>y</b>50, *y*).
     * @param verticalalignment &#123;'top', 'center', 'bottom', 'baseline'&#125;, default: top<br>
     *                          The vertical alignment of the text relative to (<b>x</b>0,<b>y</b>50, *y*).
     * @param va &#123;'top', 'center', 'bottom', 'baseline'&#125;, default: top<br>
     *           The vertical alignment of the text relative to (<b>x</b>0,<b>y</b>50, *y*).
     * @param fontsize default: :rc:`figure.titlesize`<br>
     *                 The font size of the text. See `.Text.set_size` for possible
     *                 values.
     * @param size default: :rc:`figure.titlesize`<br>
     *             The font size of the text. See `.Text.set_size` for possible
     *             values.
     * @param fontweight default: :rc:`figure.titleweight`<br>
     *                   The font weight of the text. See `.Text.set_weight` for possible
     *                   values.
     * @param weight default: :rc:`figure.titleweight`<br>
     *               The font weight of the text. See `.Text.set_weight` for possible
     *               values.
     * @param fontproperties None or dict, optional<br>
     *                       A dict of font properties. If <b>fontproperties</b>0 is given the
     *                       default values for font size and weight are taken from the
     *                       `.FontProperties` defaults. :rc:`figure.titlesize` and
     *                       :rc:`figure.titleweight` are ignored in this case.
     *                       
     * @param **kwargs <br>
     *                 Additional kwargs are `matplotlib.text.Text` properties.
     * 
     * @return text <br>
     *              The `.Text` instance of the suptitle.
     */
    public final Object suptitle(Object t, Object... args) {
        write("plt.suptitle("+PythonGrammar.toPythonArgs(t)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Close all open figures and set the Matplotlib backend.
     * 
     * The argument is case-insensitive.  Switching to an interactive backend is
     * possible only if no event loop for another interactive backend has started.
     * Switching to and from non-interactive backends is always possible.
     * 
     * @param newbackend str<br>
     *                   The name of the backend to use.
     */
    public final Object switch_backend(Object newbackend) {
        write("plt.switch_backend("+PythonGrammar.toPythonArgs(newbackend)+")");
        return null;
    }

    /**
     * Add a table to an `~.axes.Axes`.
     * 
     * At least one of <b>cellText</b>0 or<b>cellColours</b>5lours* must be specified. These
     * parameters must be 2D lists, in which the outer lists define the rows and
     * the inner list define the column values per row. Each row must have the
     * same number of elements.
     * 
     * The table can optionally have row and column headers, which are configured
     * using <b>rowLabels</b>0,<b>rowColours</b>5l<b>rowLoc</b>105lo<b>colLabels</b>15<b>colColours</b>20ls</b>1505lours*, *rowLoc* and *colLabels*, *colColours*,
     * <b>colLoc</b>0 respectively.
     * 
     * For finer grained control over tables, use the `.Table` class and add it to
     * the axes with `.Axes.add_table`.
     * 
     * @param cellText 2D list of str, optional<br>
     *                 The texts to place into the table cells.
     *                 
     *                 <b>Note</b>0: Line breaks in the strings are currently not accounted for and
     *                 will result in the text exceeding the cell boundaries.
     *                 
     * @param cellColours 2D list of colors, optional<br>
     *                    The background colors of the cells.
     *                    
     * @param cellLoc &#123;'left', 'center', 'right'&#125;, default: 'right'<br>
     *                The alignment of the text within the cells.
     *                
     * @param colWidths list of float, optional<br>
     *                  The column widths in units of the axes. If not given, all columns will
     *                  have a width of *1 / ncols*.
     *                  
     * @param rowLabels list of str, optional<br>
     *                  The text of the row header cells.
     *                  
     * @param rowColours list of colors, optional<br>
     *                   The colors of the row header cells.
     *                   
     * @param rowLoc &#123;'left', 'center', 'right'&#125;, default: 'left'<br>
     *               The text alignment of the row header cells.
     *               
     * @param colLabels list of str, optional<br>
     *                  The text of the column header cells.
     *                  
     * @param colColours list of colors, optional<br>
     *                   The colors of the column header cells.
     *                   
     * @param colLoc &#123;'left', 'center', 'right'&#125;, default: 'left'<br>
     *               The text alignment of the column header cells.
     *               
     * @param loc str, optional<br>
     *            The position of the cell with respect to <b>ax</b>0. This must be one of
     *            the `~.Table.codes`.
     *            
     * @param bbox `.Bbox`, optional<br>
     *             A bounding box to draw the table into. If this is not <b>None</b>0, this
     *             overrides<b>loc</b>5 *loc*.
     *             
     * @param edges substring of 'BRTL' or &#123;'open', 'closed', 'horizontal', 'vertical'&#125;<br>
     *              The cell edges to be drawn with a line. See also
     *              `~.Cell.visible_edges`.
     * @param **kwargs <br>
     *                 `.Table` properties.
     *                 
     * @param Properties <br>
     *                   agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                   alpha: scalar or None
     *                   animated: bool
     *                   clip_box: `.Bbox`
     *                   clip_on: bool
     *                   clip_path: Patch or (Path, Transform) or None
     *                   contains: unknown
     *                   figure: `.Figure`
     *                   fontsize: float
     *                   gid: str
     *                   in_layout: bool
     *                   label: object
     *                   path_effects: `.AbstractPathEffect`
     *                   picker: None or bool or float or callable
     *                   rasterized: bool
     *                   sketch_params: (scale: float, length: float, randomness: float)
     *                   snap: bool or None
     *                   transform: `.Transform`
     *                   url: str
     *                   visible: bool
     *                   zorder: float
     * 
     * @return `~matplotlib.table.Table` <br>
     *                                   The created table.
     */
    public final Object table(Object... args) {
        write("plt.table("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Add text to the Axes.
     * 
     * Add the text <b>s</b>0 to the Axes at location<b>x</b>5o<b>y</b>10x</b>5on *x*, *y* in data coordinates.
     * 
     * @param x float<br>
     *          The position to place the text. By default, this is in data
     *          coordinates. The coordinate system can be changed using the
     *          <b>transform</b>0 parameter.
     *          
     * @param y float<br>
     *          The position to place the text. By default, this is in data
     *          coordinates. The coordinate system can be changed using the
     *          <b>transform</b>0 parameter.
     *          
     * @param s str<br>
     *          The text.
     *          
     * @param fontdict dict, default: None<br>
     *                 A dictionary to override the default text properties. If fontdict
     *                 is None, the defaults are determined by `.rcParams`.
     * @param **kwargs `~matplotlib.text.Text` properties.<br>
     *                 Other miscellaneous text parameters.
     *                 
     *                 Properties:
     *                 agg_filter: a filter function, which takes a (m, n, 3) float array and a dpi value, and returns a (m, n, 3) array
     *                 alpha: scalar or None
     *                 animated: bool
     *                 backgroundcolor: color
     *                 bbox: dict with properties for `.patches.FancyBboxPatch`
     *                 clip_box: `.Bbox`
     *                 clip_on: bool
     *                 clip_path: Patch or (Path, Transform) or None
     *                 color or c: color
     *                 contains: unknown
     *                 figure: `.Figure`
     *                 fontfamily or family: &#123;FONTNAME, 'serif', 'sans-serif', 'cursive', 'fantasy', 'monospace'&#125;
     *                 fontproperties or font or font_properties: `.font_manager.FontProperties` or `str` or `pathlib.Path`
     *                 fontsize or size: float or &#123;'xx-small', 'x-small', 'small', 'medium', 'large', 'x-large', 'xx-large'&#125;
     *                 fontstretch or stretch: &#123;a numeric value in range 0-1000, 'ultra-condensed', 'extra-condensed', 'condensed', 'semi-condensed', 'normal', 'semi-expanded', 'expanded', 'extra-expanded', 'ultra-expanded'&#125;
     *                 fontstyle or style: &#123;'normal', 'italic', 'oblique'&#125;
     *                 fontvariant or variant: &#123;'normal', 'small-caps'&#125;
     *                 fontweight or weight: &#123;a numeric value in range 0-1000, 'ultralight', 'light', 'normal', 'regular', 'book', 'medium', 'roman', 'semibold', 'demibold', 'demi', 'bold', 'heavy', 'extra bold', 'black'&#125;
     *                 gid: str
     *                 horizontalalignment or ha: &#123;'center', 'right', 'left'&#125;
     *                 in_layout: bool
     *                 label: object
     *                 linespacing: float (multiple of font size)
     *                 math_fontfamily: str
     *                 multialignment or ma: &#123;'left', 'right', 'center'&#125;
     *                 path_effects: `.AbstractPathEffect`
     *                 picker: None or bool or float or callable
     *                 position: (float, float)
     *                 rasterized: bool
     *                 rotation: float or &#123;'vertical', 'horizontal'&#125;
     *                 rotation_mode: &#123;None, 'default', 'anchor'&#125;
     *                 sketch_params: (scale: float, length: float, randomness: float)
     *                 snap: bool or None
     *                 text: object
     *                 transform: `.Transform`
     *                 transform_rotates_text: bool
     *                 url: str
     *                 usetex: bool or None
     *                 verticalalignment or va: &#123;'center', 'top', 'bottom', 'baseline', 'center_baseline'&#125;
     *                 visible: bool
     *                 wrap: bool
     *                 x: float
     *                 y: float
     *                 zorder: float
     * 
     * @return `.Text` <br>
     *                 The created `.Text` instance.
     */
    public final Object text(Object x, Object y, Object s, Object... args) {
        write("plt.text("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(y),PythonGrammar.toPythonArgs(s)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Get or set the theta gridlines on the current polar plot.
     * 
     * Call signatures::
     * 
     * lines, labels = thetagrids()
     * lines, labels = thetagrids(angles, labels=None, fmt=None, **kwargs)
     * 
     * When called with no arguments, `.thetagrids` simply returns the tuple
     * (<b>lines</b>0,<b>labels</b>5abels*). When called with arguments, the labels will
     * appear at the specified angles.
     * 
     * @param angles tuple with floats, degrees<br>
     *               The angles of the theta gridlines.
     *               
     * @param labels tuple with strings or None<br>
     *               The labels to use at each radial gridline. The
     *               `.projections.polar.ThetaFormatter` will be used if None.
     *               
     * @param fmt str or None<br>
     *            Format string used in `matplotlib.ticker.FormatStrFormatter`.
     *            For example '%f'. Note that the angle in radians will be used.
     * @param **kwargs <br>
     *                 <b>kwargs</b>0 are optional `~.Text` properties for the labels.
     * 
     * @return (lines,labels) (list of `.lines.Line2D`,list of `.text.Text`)<br>
     *          The theta gridlines.
     *          
     *          
     *          The tick labels.
     */
    public final Object thetagrids(Object... args) {
        write("plt.thetagrids("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Change the appearance of ticks, tick labels, and gridlines.
     * 
     * Tick properties that are not explicitly set using the keyword
     * arguments remain unchanged unless <b>reset</b>0 is True.
     * 
     * @param axis &#123;'x', 'y', 'both'&#125;, default: 'both'<br>
     *             The axis to which the parameters are applied.
     * @param which &#123;'major', 'minor', 'both'&#125;, default: 'major'<br>
     *              The group of ticks to which the parameters are applied.
     * @param reset bool, default: False<br>
     *              Whether to reset the ticks to defaults before updating them.
     * @param direction &#123;'in', 'out', 'inout'&#125;<br>
     *                  Puts ticks inside the axes, outside the axes, or both.
     * @param length float<br>
     *               Tick length in points.
     * @param width float<br>
     *              Tick width in points.
     * @param color color<br>
     *              Tick color.
     * @param pad float<br>
     *            Distance in points between tick and label.
     * @param labelsize float or str<br>
     *                  Tick label font size in points or as a string (e.g., 'large').
     * @param labelcolor color<br>
     *                   Tick label color.
     * @param colors color<br>
     *               Tick color and label color.
     * @param zorder float<br>
     *               Tick and label zorder.
     * @param bottom bool<br>
     *               Whether to draw the respective ticks.
     * @param top bool<br>
     *            Whether to draw the respective ticks.
     * @param left bool<br>
     *             Whether to draw the respective ticks.
     * @param right bool<br>
     *              Whether to draw the respective ticks.
     * @param labelbottom bool<br>
     *                    Whether to draw the respective tick labels.
     * @param labeltop bool<br>
     *                 Whether to draw the respective tick labels.
     * @param labelleft bool<br>
     *                  Whether to draw the respective tick labels.
     * @param labelright bool<br>
     *                   Whether to draw the respective tick labels.
     * @param labelrotation float<br>
     *                      Tick label rotation
     * @param grid_color color<br>
     *                   Gridline color.
     * @param grid_alpha float<br>
     *                   Transparency of gridlines: 0 (transparent) to 1 (opaque).
     * @param grid_linewidth float<br>
     *                       Width of gridlines in points.
     * @param grid_linestyle str<br>
     *                       Any valid `.Line2D` line style spec.
     * @param **kwargs n/a<br>undocumented
     */
    public final Object tick_params(Object... args) {
        write("plt.tick_params("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Configure the `.ScalarFormatter` used by default for linear axes.
     * 
     * If a parameter is not set, the corresponding property of the formatter
     * is left unchanged.
     * 
     * @param axis &#123;'x', 'y', 'both'&#125;, default: 'both'<br>
     *             The axes to configure.  Only major ticks are affected.
     *             
     * @param style &#123;'sci', 'scientific', 'plain'&#125;<br>
     *              Whether to use scientific notation.
     *              The formatter default is to use scientific notation.
     *              
     * @param scilimits pair of ints (m, n)<br>
     *                  Scientific notation is used only for numbers outside the range
     *                  10\ :sup:`m` to 10\ :sup:`n` (and only if the formatter is
     *                  configured to use scientific notation at all).  Use (0, 0) to
     *                  include all numbers.  Use (m, m) where m != 0 to fix the order of
     *                  magnitude to 10\ :sup:`m`.
     *                  The formatter default is :rc:`axes.formatter.limits`.
     *                  
     * @param useOffset bool or float<br>
     *                  If True, the offset is calculated as needed.
     *                  If False, no offset is used.
     *                  If a numeric value, it sets the offset.
     *                  The formatter default is :rc:`axes.formatter.useoffset`.
     *                  
     * @param useLocale bool<br>
     *                  Whether to format the number using the current locale or using the
     *                  C (English) locale.  This affects e.g. the decimal separator.  The
     *                  formatter default is :rc:`axes.formatter.use_locale`.
     *                  
     * @param useMathText bool<br>
     *                    Render the offset and scientific notation in mathtext.
     *                    The formatter default is :rc:`axes.formatter.use_mathtext`.
     */
    public final Object ticklabel_format(Object... args) {
        write("plt.ticklabel_format("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Adjust the padding between and around subplots.
     * 
     * @param pad float, default: 1.08<br>
     *            Padding between the figure edge and the edges of subplots,
     *            as a fraction of the font size.
     * @param h_pad float, default: <b>pad</b>0<br>
     *              Padding (height/width) between edges of adjacent subplots,
     *              as a fraction of the font size.
     * @param w_pad float, default: <b>pad</b>0<br>
     *              Padding (height/width) between edges of adjacent subplots,
     *              as a fraction of the font size.
     * @param rect tuple (left, bottom, right, top), default: (0, 0, 1, 1)<br>
     *             A rectangle in normalized figure coordinates into which the whole
     *             subplots area (including labels) will fit.
     */
    public final Object tight_layout(Object... args) {
        write("plt.tight_layout("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set a title for the Axes.
     * 
     * Set one of the three available Axes titles. The available titles
     * are positioned above the Axes in the center, flush with the left
     * edge, and flush with the right edge.
     * 
     * @param label str<br>
     *              Text to use for the title
     *              
     * @param fontdict dict<br>
     *                 A dictionary controlling the appearance of the title text,
     *                 the default <b>fontdict</b>0 is::
     *                 
     *                 &#123;'fontsize': rcParams['axes.titlesize'],
     *                 'fontweight': rcParams['axes.titleweight'],
     *                 'color': rcParams['axes.titlecolor'],
     *                 'verticalalignment': 'baseline',
     *                 'horizontalalignment': loc&#125;
     *                 
     * @param loc &#123;'center', 'left', 'right'&#125;, default: :rc:`axes.titlelocation`<br>
     *            Which title to set.
     *            
     * @param y float, default: :rc:`axes.titley`<br>
     *          Vertical Axes loation for the title (1.0 is the top).  If
     *          None (the default), y is determined automatically to avoid
     *          decorators on the Axes.
     *          
     * @param pad float, default: :rc:`axes.titlepad`<br>
     *            The offset of the title from the top of the Axes, in points.
     * @param **kwargs `.Text` properties<br>
     *                 Other keyword arguments are text properties, see `.Text` for a list
     *                 of valid text properties.
     * 
     * @return `.Text` <br>
     *                 The matplotlib text instance representing the title
     */
    public final Object title(Object label, Object... args) {
        write("plt.title("+PythonGrammar.toPythonArgs(label)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Draw contour lines on an unstructured triangular grid.
     * 
     * The triangulation can be specified in one of two ways; either ::
     * 
     * tricontour(triangulation, ...)
     * 
     * where <b>triangulation</b>0 is a `.Triangulation` object, or ::
     * 
     * tricontour(x, y, ...)
     * tricontour(x, y, triangles, ...)
     * tricontour(x, y, triangles=triangles, ...)
     * tricontour(x, y, mask=mask, ...)
     * tricontour(x, y, triangles, mask=mask, ...)
     * 
     * in which case a `.Triangulation` object will be created.  See that class'
     * docstring for an explanation of these cases.
     * 
     * The remaining arguments may be::
     * 
     * tricontour(..., Z)
     * 
     * where <b>Z</b>0 is the array of values to contour, one per point in the
     * triangulation.  The level values are chosen automatically.
     * 
     * ::
     * 
     * tricontour(..., Z, levels)
     * 
     * contour up to *levels+1* automatically chosen contour levels (<b>levels</b>0
     * intervals).
     * 
     * ::
     * 
     * tricontour(..., Z, levels)
     * 
     * draw contour lines at the values specified in sequence <b>levels</b>0, which must
     * be in increasing order.
     * 
     * ::
     * 
     * tricontour(Z, **kwargs)
     * 
     * Use keyword arguments to control colors, linewidth, origin, cmap ... see below
     * for more details.
     * 
     * @param triangulation `.Triangulation`, optional<br>
     *                      The unstructured triangular grid.
     *                      
     *                      If specified, then <b>x</b>0,<b>y</b>50<b>triangles</b>10 *y*<b>mask</b>15/b>10 *y*, *triangles*, and *mask* are not accepted.
     *                      
     * @param x array-like, optional<br>
     *          The coordinates of the values in <b>Z</b>0.
     *          
     * @param y array-like, optional<br>
     *          The coordinates of the values in <b>Z</b>0.
     *          
     * @param triangles (ntri, 3) array-like of int, optional<br>
     *                  For each triangle, the indices of the three points that make up the
     *                  triangle, ordered in an anticlockwise manner.  If not specified, the
     *                  Delaunay triangulation is calculated.
     *                  
     * @param mask (ntri,) array-like of bool, optional<br>
     *             Which triangles are masked out.
     *             
     * @param Z 2D array-like<br>
     *          The height values over which the contour is drawn.
     *          
     * @param levels int or array-like, optional<br>
     *               Determines the number and positions of the contour lines / regions.
     *               
     *               If an int <b>n</b>0, use `~matplotlib.ticker.MaxNLocator`, which tries to
     *               automatically choose no more than *n+1* "nice" contour levels between
     *              <b>vmin</b>5*vmi<b>vmax</b>10*vmin* and *vmax*.
     *               
     *               If array-like, draw contour lines at the specified levels.  The values must
     *               be in increasing order.
     * @param colors color string or sequence of colors, optional<br>
     *               The colors of the levels, i.e., the contour lines.
     *               
     *               The sequence is cycled for the levels in ascending order. If the sequence
     *               is shorter than the number of levels, it's repeated.
     *               
     *               As a shortcut, single color strings may be used in place of one-element
     *               lists, i.e. ``'red'`` instead of ``['red']`` to color all levels with the
     *               same color. This shortcut does only work for color strings, not for other
     *               ways of specifying colors.
     *               
     *               By default (value <b>None</b>0), the colormap specified by<b>cmap</b>5*cmap* will be used.
     *               
     * @param alpha float, default: 1<br>
     *              The alpha blending value, between 0 (transparent) and 1 (opaque).
     *              
     * @param cmap str or `.Colormap`, default: :rc:`image.cmap`<br>
     *             A `.Colormap` instance or registered colormap name. The colormap maps the
     *             level values to colors.
     *             
     *             If both <b>colors</b>0 and<b>cmap</b>5*cmap* are given, an error is raised.
     *             
     * @param norm `~matplotlib.colors.Normalize`, optional<br>
     *             If a colormap is used, the `.Normalize` instance scales the level values to
     *             the canonical colormap range [0, 1] for mapping to colors. If not given,
     *             the default linear scaling is used.
     *             
     * @param origin &#123;<b>None</b>0, 'upper', 'lower', 'image'&#125;, default: None<br>
     *               Determines the orientation and exact position of<b>Z</b>5of *Z* by specifying the
     *               position of ``Z[0, 0]``.  This is only releva<b>X</b>10<b>Y</b>15va<b>X</b>10 relevant, if *X*, *Y* are not given.
     *   <b>None</b>20ven.
     *               
     *               - *None*: ``Z[0, 0]`` is at X=0, Y=0 in the lower left corner.
     *               - 'lower': ``Z[0, 0]`` is at X=0.5, Y=0.5 in the lower left corner.
     *               - 'upper': ``Z[0, 0]`` is at X=N+0.5, Y=0.5 in the upper left corner.
     *               - 'image': Use the value from :rc:`image.origin`.
     *               
     * @param extent (x0, x1, y0, y1), optional<br>
     *               If <b>origin</b>0 is not<b>None</b>5*None*<b>extent</b>10e*, then *extent* is interpreted as in `.imshow`: it
     *               gives the outer pixel boundaries. In this case, the position of Z[0, 0] is
     *               the center of the pixel<b>origin</b>15e <b>None</b>20origin</b>15e pixel, not a <b>x0</b>25<b>y0</b>30e pixel, not a <b>x0</b>25</b>15e<b>x1</b>35<b>y1</b>40 not a <b>x0</b>25</b>15e<b>x1</b>35pixel, not a <b>x0</b>25</b>15e pixel, not a corner. If *origin* is *None*, then
     <b>X</b>45 co<b>Y</b>50 If *origin* is *None*, then
     <b>X</b>45 corner. If *origin* is *None*, then
     *               (*x0*, *y0*) is the position of Z[0, 0], and (*x1*, *y1*) is the position
     *               of Z[-1, -1].
     *               
     *               This argument is ignored if *X* and *Y* are specified in the call to
     *               contour.
     *               
     * @param locator ticker.Locator subclass, optional<br>
     *                The locator is used to determine the contour levels if they are not given
     *                explicitly via <b>levels</b>0.
     *                Defaults to `~.ticker.MaxNLocator`.
     *                
     * @param extend &#123;'neither', 'both', 'min', 'max'&#125;, default: 'neither'<br>
     *               Determines the ``tricontour``-coloring of values that are outside the
     *               <b>levels</b>0 range.
     *               
     *               If 'neither', values outside the<b>levels</b>5evels* range are not colored.  If 'min',
     *               'max' or 'both', color the values below, above or below and above the
     *        <b>levels</b>10         *levels* range.
     *               
     *               Values below ``min(levels)`` and above ``max(levels)`` are mapped to the
     *               under/over values of the `.Colormap`. Note that most colormaps do not have
     *               dedicated colors for these by default, so that the over and under values
     *               are the edge values of the colormap.  You may want to set these values
     *               explicitly using `.Colormap.set_under` and `.Colormap.set_over`.
     *               
     *               .. note::
     *               
     *               An existing `.TriContourSet` does not get notified if properties of its
     *               colormap are changed. Therefore, an explicit call to
     *               `.ContourSet.changed()` is needed after modifying the colormap. The
     *               explicit call can be left out, if a colorbar is assigned to the
     *               `.TriContourSet` because it internally calls `.ContourSet.changed()`.
     *               
     * @param xunits registered units, optional<br>
     *               Override axis units by specifying an instance of a
     *               :class:`matplotlib.units.ConversionInterface`.
     *               
     * @param yunits registered units, optional<br>
     *               Override axis units by specifying an instance of a
     *               :class:`matplotlib.units.ConversionInterface`.
     *               
     * @param linewidths float or array-like, default: :rc:`contour.linewidth`<br>
     *                   The line width of the contour lines.
     *                   
     *                   If a number, all levels will be plotted with this linewidth.
     *                   
     *                   If a sequence, the levels in ascending order will be plotted with
     *                   the linewidths in the order specified.
     *                   
     *                   If None, this falls back to :rc:`lines.linewidth`.
     *                   
     * @param linestyles &#123;<b>None</b>0, 'solid', 'dashed', 'dashdot', 'dotted'&#125;, optional<br>
     *                   If<b>linestyles</b>5tyl<b>None</b>105tyles* is *None*, the default is 'solid' unless the lines are
     *                   monochrome.  In that case, negative contours will take their linestyle
     *                   from :rc:`contour.negative_linestyle` setting.
     *                   
     *<b>linestyles</b>15  *                   *linestyles* can also be an iterable of the above strings specifying a
     *                   set of linestyles to be used. If this iterable is shorter than the
     *                   number of contour levels it will be repeated as necessary.
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     * 
     * @return `~matplotlib.tri.TriContourSet` <br>
     */
    public final Object tricontour(Object... args) {
        write("plt.tricontour("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Draw contour regions on an unstructured triangular grid.
     * 
     * The triangulation can be specified in one of two ways; either ::
     * 
     * tricontourf(triangulation, ...)
     * 
     * where <b>triangulation</b>0 is a `.Triangulation` object, or ::
     * 
     * tricontourf(x, y, ...)
     * tricontourf(x, y, triangles, ...)
     * tricontourf(x, y, triangles=triangles, ...)
     * tricontourf(x, y, mask=mask, ...)
     * tricontourf(x, y, triangles, mask=mask, ...)
     * 
     * in which case a `.Triangulation` object will be created.  See that class'
     * docstring for an explanation of these cases.
     * 
     * The remaining arguments may be::
     * 
     * tricontourf(..., Z)
     * 
     * where <b>Z</b>0 is the array of values to contour, one per point in the
     * triangulation.  The level values are chosen automatically.
     * 
     * ::
     * 
     * tricontourf(..., Z, levels)
     * 
     * contour up to *levels+1* automatically chosen contour levels (<b>levels</b>0
     * intervals).
     * 
     * ::
     * 
     * tricontourf(..., Z, levels)
     * 
     * draw contour regions at the values specified in sequence <b>levels</b>0, which must
     * be in increasing order.
     * 
     * ::
     * 
     * tricontourf(Z, **kwargs)
     * 
     * Use keyword arguments to control colors, linewidth, origin, cmap ... see below
     * for more details.
     * <p>
     * <em>Notes:</em><br>
     * `.tricontourf` fills intervals that are closed at the top; that is, for
     * boundaries <b>z1</b>0 and<b>z2</b>5d *z2*, the filled region is::
     * 
     * z1 < Z <= z2
     * 
     * except for the lowest interval, which is closed on both sides (i.e. it
     * includes the lowest value).
     * 
     * @param triangulation `.Triangulation`, optional<br>
     *                      The unstructured triangular grid.
     *                      
     *                      If specified, then <b>x</b>0,<b>y</b>50<b>triangles</b>10 *y*<b>mask</b>15/b>10 *y*, *triangles*, and *mask* are not accepted.
     *                      
     * @param x array-like, optional<br>
     *          The coordinates of the values in <b>Z</b>0.
     *          
     * @param y array-like, optional<br>
     *          The coordinates of the values in <b>Z</b>0.
     *          
     * @param triangles (ntri, 3) array-like of int, optional<br>
     *                  For each triangle, the indices of the three points that make up the
     *                  triangle, ordered in an anticlockwise manner.  If not specified, the
     *                  Delaunay triangulation is calculated.
     *                  
     * @param mask (ntri,) array-like of bool, optional<br>
     *             Which triangles are masked out.
     *             
     * @param Z 2D array-like<br>
     *          The height values over which the contour is drawn.
     *          
     * @param levels int or array-like, optional<br>
     *               Determines the number and positions of the contour lines / regions.
     *               
     *               If an int <b>n</b>0, use `~matplotlib.ticker.MaxNLocator`, which tries to
     *               automatically choose no more than *n+1* "nice" contour levels between
     *              <b>vmin</b>5*vmi<b>vmax</b>10*vmin* and *vmax*.
     *               
     *               If array-like, draw contour lines at the specified levels.  The values must
     *               be in increasing order.
     * @param colors color string or sequence of colors, optional<br>
     *               The colors of the levels, i.e., the contour regions.
     *               
     *               The sequence is cycled for the levels in ascending order. If the sequence
     *               is shorter than the number of levels, it's repeated.
     *               
     *               As a shortcut, single color strings may be used in place of one-element
     *               lists, i.e. ``'red'`` instead of ``['red']`` to color all levels with the
     *               same color. This shortcut does only work for color strings, not for other
     *               ways of specifying colors.
     *               
     *               By default (value <b>None</b>0), the colormap specified by<b>cmap</b>5*cmap* will be used.
     *               
     * @param alpha float, default: 1<br>
     *              The alpha blending value, between 0 (transparent) and 1 (opaque).
     *              
     * @param cmap str or `.Colormap`, default: :rc:`image.cmap`<br>
     *             A `.Colormap` instance or registered colormap name. The colormap maps the
     *             level values to colors.
     *             
     *             If both <b>colors</b>0 and<b>cmap</b>5*cmap* are given, an error is raised.
     *             
     * @param norm `~matplotlib.colors.Normalize`, optional<br>
     *             If a colormap is used, the `.Normalize` instance scales the level values to
     *             the canonical colormap range [0, 1] for mapping to colors. If not given,
     *             the default linear scaling is used.
     *             
     * @param origin &#123;<b>None</b>0, 'upper', 'lower', 'image'&#125;, default: None<br>
     *               Determines the orientation and exact position of<b>Z</b>5of *Z* by specifying the
     *               position of ``Z[0, 0]``.  This is only releva<b>X</b>10<b>Y</b>15va<b>X</b>10 relevant, if *X*, *Y* are not given.
     *   <b>None</b>20ven.
     *               
     *               - *None*: ``Z[0, 0]`` is at X=0, Y=0 in the lower left corner.
     *               - 'lower': ``Z[0, 0]`` is at X=0.5, Y=0.5 in the lower left corner.
     *               - 'upper': ``Z[0, 0]`` is at X=N+0.5, Y=0.5 in the upper left corner.
     *               - 'image': Use the value from :rc:`image.origin`.
     *               
     * @param extent (x0, x1, y0, y1), optional<br>
     *               If <b>origin</b>0 is not<b>None</b>5*None*<b>extent</b>10e*, then *extent* is interpreted as in `.imshow`: it
     *               gives the outer pixel boundaries. In this case, the position of Z[0, 0] is
     *               the center of the pixel<b>origin</b>15e <b>None</b>20origin</b>15e pixel, not a <b>x0</b>25<b>y0</b>30e pixel, not a <b>x0</b>25</b>15e<b>x1</b>35<b>y1</b>40 not a <b>x0</b>25</b>15e<b>x1</b>35pixel, not a <b>x0</b>25</b>15e pixel, not a corner. If *origin* is *None*, then
     <b>X</b>45 co<b>Y</b>50 If *origin* is *None*, then
     <b>X</b>45 corner. If *origin* is *None*, then
     *               (*x0*, *y0*) is the position of Z[0, 0], and (*x1*, *y1*) is the position
     *               of Z[-1, -1].
     *               
     *               This argument is ignored if *X* and *Y* are specified in the call to
     *               contour.
     *               
     * @param locator ticker.Locator subclass, optional<br>
     *                The locator is used to determine the contour levels if they are not given
     *                explicitly via <b>levels</b>0.
     *                Defaults to `~.ticker.MaxNLocator`.
     *                
     * @param extend &#123;'neither', 'both', 'min', 'max'&#125;, default: 'neither'<br>
     *               Determines the ``tricontourf``-coloring of values that are outside the
     *               <b>levels</b>0 range.
     *               
     *               If 'neither', values outside the<b>levels</b>5evels* range are not colored.  If 'min',
     *               'max' or 'both', color the values below, above or below and above the
     *        <b>levels</b>10         *levels* range.
     *               
     *               Values below ``min(levels)`` and above ``max(levels)`` are mapped to the
     *               under/over values of the `.Colormap`. Note that most colormaps do not have
     *               dedicated colors for these by default, so that the over and under values
     *               are the edge values of the colormap.  You may want to set these values
     *               explicitly using `.Colormap.set_under` and `.Colormap.set_over`.
     *               
     *               .. note::
     *               
     *               An existing `.TriContourSet` does not get notified if properties of its
     *               colormap are changed. Therefore, an explicit call to
     *               `.ContourSet.changed()` is needed after modifying the colormap. The
     *               explicit call can be left out, if a colorbar is assigned to the
     *               `.TriContourSet` because it internally calls `.ContourSet.changed()`.
     *               
     * @param xunits registered units, optional<br>
     *               Override axis units by specifying an instance of a
     *               :class:`matplotlib.units.ConversionInterface`.
     *               
     * @param yunits registered units, optional<br>
     *               Override axis units by specifying an instance of a
     *               :class:`matplotlib.units.ConversionInterface`.
     *               
     * @param antialiased bool, default: True<br>
     *                    Whether to use antialiasing.
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     * 
     * @return `~matplotlib.tri.TriContourSet` <br>
     */
    public final Object tricontourf(Object... args) {
        write("plt.tricontourf("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Create a pseudocolor plot of an unstructured triangular grid.
     * 
     * The triangulation can be specified in one of two ways; either::
     * 
     * tripcolor(triangulation, ...)
     * 
     * where triangulation is a `.Triangulation` object, or
     * 
     * ::
     * 
     * tripcolor(x, y, ...)
     * tripcolor(x, y, triangles, ...)
     * tripcolor(x, y, triangles=triangles, ...)
     * tripcolor(x, y, mask=mask, ...)
     * tripcolor(x, y, triangles, mask=mask, ...)
     * 
     * in which case a Triangulation object will be created.  See `.Triangulation`
     * for a explanation of these possibilities.
     * 
     * The next argument must be <b>C</b>0, the array of color values, either
     * one per point in the triangulation if color values are defined at
     * points, or one per triangle in the triangulation if color values
     * are defined at triangles. If there are the same number of points
     * and triangles in the triangulation it is assumed that color
     * values are defined at points; to force the use of color values at
     * triangles use the kwarg ``facecolors=C`` instead of just ``C``.
     * 
     * <b>shading</b>0 may be 'flat' (the default) or 'gouraud'. If<b>shading</b>5ading*
     * is 'flat' and C values are defined at points, the color values
     * used for each triangle are from the mean C of the triangle's
     * three points. If <b>shading</b>0 is 'gouraud' then color values must be
     * defined at points.
     * 
     * The remaining kwargs are the same as for `~.Axes.pcolor`.
     * 
     * @param *args n/a<br>undocumented
     * @param alpha n/a<br>undocumented
     * @param norm n/a<br>undocumented
     * @param cmap n/a<br>undocumented
     * @param vmin n/a<br>undocumented
     * @param vmax n/a<br>undocumented
     * @param shading n/a<br>undocumented
     * @param facecolors n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     */
    public final Object tripcolor(Object... args) {
        write("plt.tripcolor("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Draw a unstructured triangular grid as lines and/or markers.
     * 
     * The triangulation to plot can be specified in one of two ways; either::
     * 
     * triplot(triangulation, ...)
     * 
     * where triangulation is a `.Triangulation` object, or
     * 
     * ::
     * 
     * triplot(x, y, ...)
     * triplot(x, y, triangles, ...)
     * triplot(x, y, triangles=triangles, ...)
     * triplot(x, y, mask=mask, ...)
     * triplot(x, y, triangles, mask=mask, ...)
     * 
     * in which case a Triangulation object will be created.  See `.Triangulation`
     * for a explanation of these possibilities.
     * 
     * The remaining args and kwargs are the same as for `~.Axes.plot`.
     * 
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     * 
     * @return (lines,markers) (`~matplotlib.lines.Line2D`,`~matplotlib.lines.Line2D`)<br>
     *          The drawn triangles edges.
     *          
     *          The drawn marker nodes.
     */
    public final Object triplot(Object... args) {
        write("plt.triplot("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Make and return a second axes that shares the <b>x</b>0-axis.  The new axes will
     * overlay <b>ax</b>0 (or the current axes if<b>ax</b>5f *<b>None</b>105f *ax* is *None*), and its ticks will be
     * on the right.
     * 
     * @param ax n/a<br>undocumented
     */
    public final Object twinx(Object... args) {
        write("plt.twinx("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Make and return a second axes that shares the <b>y</b>0-axis.  The new axes will
     * overlay <b>ax</b>0 (or the current axes if<b>ax</b>5f *<b>None</b>105f *ax* is *None*), and its ticks will be
     * on the top.
     * 
     * @param ax n/a<br>undocumented
     */
    public final Object twiny(Object... args) {
        write("plt.twiny("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Uninstall the matplotlib display hook.
     * 
     * .. warning::
     * 
     * Need IPython >= 2 for this to work.  For IPython < 2 will raise a
     * ``NotImplementedError``
     * 
     * .. warning::
     * 
     * If you are using vanilla python and have installed another
     * display hook this will reset ``sys.displayhook`` to what ever
     * function was there when matplotlib installed it's displayhook,
     * possibly discarding your changes.
     */
    public final Object uninstall_repl_displayhook() {
        write("plt.uninstall_repl_displayhook()");
        return null;
    }

    /**
     * Make a violin plot.
     * 
     * Make a violin plot for each column of <b>dataset</b>0 or each vector in
     * sequence <b>dataset</b>0.  Each filled area extends to represent the
     * entire data range, with optional lines at the mean, the median,
     * the minimum, the maximum, and user-specified quantiles.
     * <p>
     * <em>Notes:</em><br>
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * the following arguments can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception):
     * <b>dataset</b>0.
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param dataset Array or a sequence of vectors.<br>
     *                The input data.
     *                
     * @param positions array-like, default: [1, 2, ..., n]<br>
     *                  The positions of the violins. The ticks and limits are
     *                  automatically set to match the positions.
     *                  
     * @param vert bool, default: True.<br>
     *             If true, creates a vertical violin plot.
     *             Otherwise, creates a horizontal violin plot.
     *             
     * @param widths array-like, default: 0.5<br>
     *               Either a scalar or a vector that sets the maximal width of
     *               each violin. The default is 0.5, which uses about half of the
     *               available horizontal space.
     *               
     * @param showmeans bool, default: False<br>
     *                  If `True`, will toggle rendering of the means.
     *                  
     * @param showextrema bool, default: True<br>
     *                    If `True`, will toggle rendering of the extrema.
     *                    
     * @param showmedians bool, default: False<br>
     *                    If `True`, will toggle rendering of the medians.
     *                    
     * @param quantiles array-like, default: None<br>
     *                  If not None, set a list of floats in interval [0, 1] for each violin,
     *                  which stands for the quantiles that will be rendered for that
     *                  violin.
     *                  
     * @param points int, default: 100<br>
     *               Defines the number of points to evaluate each of the
     *               gaussian kernel density estimations at.
     *               
     * @param bw_method str, scalar or callable, optional<br>
     *                  The method used to calculate the estimator bandwidth.  This can be
     *                  'scott', 'silverman', a scalar constant or a callable.  If a
     *                  scalar, this will be used directly as `kde.factor`.  If a
     *                  callable, it should take a `GaussianKDE` instance as its only
     *                  parameter and return a scalar. If None (default), 'scott' is used.
     * @param data n/a<br>undocumented
     * 
     * @return dict <br>
     *              A dictionary mapping each component of the violinplot to a
     *              list of the corresponding collection instances created. The
     *              dictionary has the following keys:
     *              
     *              - ``bodies``: A list of the `~.collections.PolyCollection`
     *              instances containing the filled area of each violin.
     *              
     *              - ``cmeans``: A `~.collections.LineCollection` instance that marks
     *              the mean values of each of the violin's distribution.
     *              
     *              - ``cmins``: A `~.collections.LineCollection` instance that marks
     *              the bottom of each violin's distribution.
     *              
     *              - ``cmaxes``: A `~.collections.LineCollection` instance that marks
     *              the top of each violin's distribution.
     *              
     *              - ``cbars``: A `~.collections.LineCollection` instance that marks
     *              the centers of each violin's distribution.
     *              
     *              - ``cmedians``: A `~.collections.LineCollection` instance that
     *              marks the median values of each of the violin's distribution.
     *              
     *              - ``cquantiles``: A `~.collections.LineCollection` instance created
     *              to identify the quantile values of each of the violin's
     *              distribution.
     */
    public final Object violinplot(Object dataset, Object... args) {
        write("plt.violinplot("+PythonGrammar.toPythonArgs(dataset)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the colormap to 'viridis'.
     * 
     * This changes the default colormap as well as the colormap of the current
     * image if there is one. See ``help(colormaps)`` for more information.
     */
    public final Object viridis() {
        write("plt.viridis()");
        return null;
    }

    /**
     * Plot vertical lines at each <b>x</b>0 from<b>ymin</b>5*ym<b>ymax</b>105*ymin* to *ymax*.
     * <p>
     * <em>Notes:</em><br>
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * the following arguments can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception):
     * <b>x</b>0,<b>ymin</b>5*<b>ymax</b>10<b>colors</b>15x</b>10b>5*ymin*, *ymax*, *colors*.
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param x float or array-like<br>
     *          x-indexes where to plot the lines.
     *          
     * @param ymin float or array-like<br>
     *             Respective beginning and end of each line. If scalars are
     *             provided, all lines will have same length.
     *             
     * @param ymax float or array-like<br>
     *             Respective beginning and end of each line. If scalars are
     *             provided, all lines will have same length.
     *             
     * @param colors list of colors, default: :rc:`lines.color`<br>
     *               
     * @param linestyles &#123;'solid', 'dashed', 'dashdot', 'dotted'&#125;, optional<br>
     *                   
     * @param label str, default: ''<br>
     * @param **kwargs `~matplotlib.collections.LineCollection` properties.<br>
     * @param data n/a<br>undocumented
     * 
     * @return `~matplotlib.collections.LineCollection` <br>
     */
    public final Object vlines(Object x, Object ymin, Object ymax, Object... args) {
        write("plt.vlines("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(ymin),PythonGrammar.toPythonArgs(ymax)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Blocking call to interact with the figure.
     * 
     * Wait for user input and return True if a key was pressed, False if a
     * mouse button was pressed and None if no input was given within
     * <b>timeout</b>0 seconds.  Negative values deactivate<b>timeout</b>5meout*.
     * 
     * @param timeout n/a<br>undocumented
     */
    public final Object waitforbuttonpress(Object... args) {
        write("plt.waitforbuttonpress("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the colormap to 'winter'.
     * 
     * This changes the default colormap as well as the colormap of the current
     * image if there is one. See ``help(colormaps)`` for more information.
     */
    public final Object winter() {
        write("plt.winter()");
        return null;
    }

    /**
     * Plot the cross correlation between <b>x</b>0 and<b>y</b>5nd *y*.
     * 
     * The correlation with lag k is defined as
     * :math:`\sum_n x[n+k] \cdot y^*[n]`, where :math:`y^*` is the complex
     * conjugate of :math:`y`.
     * <p>
     * <em>Notes:</em><br>
     * The cross correlation is performed with `numpy.correlate` with
     * ``mode = "full"``.
     * 
     * .. note::
     * In addition to the above described arguments, this function can take
     * a <b>data</b>0 keyword argument. If such a<b>data</b>5*data* argument is given,
     * the following arguments can also be string ``s``, which is
     * interpreted as ``data[s]`` (unless this raises an exception):
     * <b>x</b>0,<b>y</b>50, *y*.
     * 
     * Objects passed as **data** must support item access (``data[s]``) and
     * membership test (``s in data``).
     * 
     * @param x array-like of length n<br>
     *          
     * @param y array-like of length n<br>
     *          
     * @param detrend callable, default: `.mlab.detrend_none` (no detrending)<br>
     *                A detrending function applied to <b>x</b>0 and<b>y</b>5nd *y*.  It must have the
     *                signature ::
     *                
     *                detrend(x: np.ndarray) -&gt; np.ndarray
     *                
     * @param normed bool, default: True<br>
     *               If ``True``, input vectors are normalised to unit length.
     *               
     * @param usevlines bool, default: True<br>
     *                  Determines the plot style.
     *                  
     *                  If ``True``, vertical lines are plotted from 0 to the xcorr value
     *                  using `.Axes.vlines`. Additionally, a horizontal line is plotted
     *                  at y=0 using `.Axes.axhline`.
     *                  
     *                  If ``False``, markers are plotted at the xcorr values using
     *                  `.Axes.plot`.
     *                  
     * @param maxlags int, default: 10<br>
     *                Number of lags to show. If None, will return all ``2 * len(x) - 1``
     *                lags.
     * @param linestyle `.Line2D` property, optional<br>
     *                  The linestyle for plotting the data points.
     *                  Only used if <b>usevlines</b>0 is ``False``.
     *                  
     * @param marker str, default: 'o'<br>
     *               The marker for plotting the data points.
     *               Only used if <b>usevlines</b>0 is ``False``.
     *               
     * @param **kwargs <br>
     *                 Additional parameters are passed to `.Axes.vlines` and
     *                 `.Axes.axhline` if <b>usevlines</b>0 is ``True``; otherwise they are
     *                 passed to `.Axes.plot`.
     * @param data n/a<br>undocumented
     * 
     * @return (lags,c,line,b) (array (length ``2*maxlags+1``),array  (length ``2*maxlags+1``),`.LineCollection` or `.Line2D`,`.Line2D` or None)<br>
     *          The lag vector.
     *          
     *          The auto correlation vector.
     *          
     *          `.Artist` added to the Axes of the correlation:
     *          
     *          - `.LineCollection` if <b>usevlines</b>0 is True.
     *          - `.Line2D` if<b>usevlines</b>5lines* is False.
     *          
     *          Horizontal line a<b>usevlines</b>10 0 if *usevlines* is True
  <b>usevlines</b>15e
     *          None *usevlines* is False.
     */
    public final Object xcorr(Object x, Object y, Object... args) {
        write("plt.xcorr("+PythonGrammar.toPythonArgs(x),PythonGrammar.toPythonArgs(y)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Turn on `xkcd <https://xkcd.com/>`_ sketch-style drawing mode.  This will
     * only have effect on things drawn after this function is called.
     * 
     * For best results, the "Humor Sans" font should be installed: it is
     * not included with Matplotlib.
     * <p>
     * <em>Notes:</em><br>
     * This function works by a number of rcParams, so it will probably
     * override others you have set before.
     * 
     * If you want the effects of this function to be temporary, it can
     * be used as a context manager, for example::
     * 
     * with plt.xkcd():
     * # This figure will be in XKCD-style
     * fig1 = plt.figure()
     * # ...
     * 
     * # This figure will be in regular style
     * fig2 = plt.figure()
     * 
     * @param scale float, optional<br>
     *              The amplitude of the wiggle perpendicular to the source line.
     * @param length float, optional<br>
     *               The length of the wiggle along the line.
     * @param randomness float, optional<br>
     *                   The scale factor by which the length is shrunken or expanded.
     */
    public final Object xkcd(Object... args) {
        write("plt.xkcd("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the label for the x-axis.
     * 
     * @param xlabel str<br>
     *               The label text.
     *               
     * @param labelpad float, default: :rc:`axes.labelpad`<br>
     *                 Spacing in points from the axes bounding box including ticks
     *                 and tick labels.  If None, the previous value is left as is.
     *                 
     * @param loc &#123;'left', 'center', 'right'&#125;, default: :rc:`xaxis.labellocation`<br>
     *            The label position. This is a high-level alternative for passing
     *            parameters <b>x</b>0 and<b>horizontalalignment</b>5nment*.
     * @param **kwargs `.Text` properties<br>
     *                 `.Text` properties control the appearance of the label.
     * @param fontdict n/a<br>undocumented
     */
    public final Object xlabel(Object xlabel, Object... args) {
        write("plt.xlabel("+PythonGrammar.toPythonArgs(xlabel)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Get or set the x limits of the current axes.
     * 
     * Call signatures::
     * 
     * left, right = xlim()  # return the current xlim
     * xlim((left, right))   # set the xlim to left, right
     * xlim(left, right)     # set the xlim to left, right
     * 
     * If you do not specify args, you can pass <b>left</b>0 or<b>right</b>5right* as kwargs,
     * i.e.::
     * 
     * xlim(right=3)  # adjust the right leaving left unchanged
     * xlim(left=1)  # adjust the left leaving right unchanged
     * 
     * Setting limits turns autoscaling off for the x-axis.
     * <p>
     * <em>Notes:</em><br>
     * Calling this function with no arguments (e.g. ``xlim()``) is the pyplot
     * equivalent of calling `~.Axes.get_xlim` on the current axes.
     * Calling this function with arguments is the pyplot equivalent of calling
     * `~.Axes.set_xlim` on the current axes. All arguments are passed though.
     * 
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     * 
     * @return (left,right) (,)<br>
     *          A tuple of the new x-axis limits.
     *          
     *          A tuple of the new x-axis limits.
     */
    public final Object xlim(Object... args) {
        write("plt.xlim("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the x-axis scale.
     * <p>
     * <em>Notes:</em><br>
     * By default, Matplotlib supports the above mentioned scales.
     * Additionally, custom scales may be registered using
     * `matplotlib.scale.register_scale`. These scales can then also
     * be used here.
     * 
     * @param value &#123;"linear", "log", "symlog", "logit", ...&#125; or `.ScaleBase`<br>
     *              The axis scale type to apply.
     *              
     * @param **kwargs <br>
     *                 Different keyword arguments are accepted, depending on the scale.
     *                 See the respective class keyword arguments:
     *                 
     *                 - `matplotlib.scale.LinearScale`
     *                 - `matplotlib.scale.LogScale`
     *                 - `matplotlib.scale.SymmetricalLogScale`
     *                 - `matplotlib.scale.LogitScale`
     *                 - `matplotlib.scale.FuncScale`
     */
    public final Object xscale(Object value, Object... args) {
        write("plt.xscale("+PythonGrammar.toPythonArgs(value)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Get or set the current tick locations and labels of the x-axis.
     * 
     * Pass no arguments to return the current values without modifying them.
     * <p>
     * <em>Notes:</em><br>
     * Calling this function with no arguments (e.g. ``xticks()``) is the pyplot
     * equivalent of calling `~.Axes.get_xticks` and `~.Axes.get_xticklabels` on
     * the current axes.
     * Calling this function with arguments is the pyplot equivalent of calling
     * `~.Axes.set_xticks` and `~.Axes.set_xticklabels` on the current axes.
     * 
     * @param ticks array-like, optional<br>
     *              The list of xtick locations.  Passing an empty list removes all xticks.
     * @param labels array-like, optional<br>
     *               The labels to place at the given <b>ticks</b>0 locations.  This argument can
     *               only be passed if<b>ticks</b>5ticks* is passed as well.
     * @param **kwargs <br>
     *                 `.Text` properties can be used to control the appearance of the labels.
     * 
     * @return (locs,labels) (,)<br>
     *          The list of xtick locations.
     *          
     *          The list of xlabel `.Text` objects.
     */
    public final Object xticks(Object... args) {
        write("plt.xticks("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the label for the y-axis.
     * 
     * @param ylabel str<br>
     *               The label text.
     *               
     * @param labelpad float, default: :rc:`axes.labelpad`<br>
     *                 Spacing in points from the axes bounding box including ticks
     *                 and tick labels.  If None, the previous value is left as is.
     *                 
     * @param loc &#123;'bottom', 'center', 'top'&#125;, default: :rc:`yaxis.labellocation`<br>
     *            The label position. This is a high-level alternative for passing
     *            parameters <b>y</b>0 and<b>horizontalalignment</b>5nment*.
     * @param **kwargs `.Text` properties<br>
     *                 `.Text` properties control the appearance of the label.
     * @param fontdict n/a<br>undocumented
     */
    public final Object ylabel(Object ylabel, Object... args) {
        write("plt.ylabel("+PythonGrammar.toPythonArgs(ylabel)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Get or set the y-limits of the current axes.
     * 
     * Call signatures::
     * 
     * bottom, top = ylim()  # return the current ylim
     * ylim((bottom, top))   # set the ylim to bottom, top
     * ylim(bottom, top)     # set the ylim to bottom, top
     * 
     * If you do not specify args, you can alternatively pass <b>bottom</b>0 or
     * <b>top</b>0 as kwargs, i.e.::
     * 
     * ylim(top=3)  # adjust the top leaving bottom unchanged
     * ylim(bottom=1)  # adjust the bottom leaving top unchanged
     * 
     * Setting limits turns autoscaling off for the y-axis.
     * <p>
     * <em>Notes:</em><br>
     * Calling this function with no arguments (e.g. ``ylim()``) is the pyplot
     * equivalent of calling `~.Axes.get_ylim` on the current axes.
     * Calling this function with arguments is the pyplot equivalent of calling
     * `~.Axes.set_ylim` on the current axes. All arguments are passed though.
     * 
     * @param *args n/a<br>undocumented
     * @param **kwargs n/a<br>undocumented
     * 
     * @return (bottom,top) (,)<br>
     *          A tuple of the new y-axis limits.
     *          
     *          A tuple of the new y-axis limits.
     */
    public final Object ylim(Object... args) {
        write("plt.ylim("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Set the y-axis scale.
     * <p>
     * <em>Notes:</em><br>
     * By default, Matplotlib supports the above mentioned scales.
     * Additionally, custom scales may be registered using
     * `matplotlib.scale.register_scale`. These scales can then also
     * be used here.
     * 
     * @param value &#123;"linear", "log", "symlog", "logit", ...&#125; or `.ScaleBase`<br>
     *              The axis scale type to apply.
     *              
     * @param **kwargs <br>
     *                 Different keyword arguments are accepted, depending on the scale.
     *                 See the respective class keyword arguments:
     *                 
     *                 - `matplotlib.scale.LinearScale`
     *                 - `matplotlib.scale.LogScale`
     *                 - `matplotlib.scale.SymmetricalLogScale`
     *                 - `matplotlib.scale.LogitScale`
     *                 - `matplotlib.scale.FuncScale`
     */
    public final Object yscale(Object value, Object... args) {
        write("plt.yscale("+PythonGrammar.toPythonArgs(value)+","+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

    /**
     * Get or set the current tick locations and labels of the y-axis.
     * 
     * Pass no arguments to return the current values without modifying them.
     * <p>
     * <em>Notes:</em><br>
     * Calling this function with no arguments (e.g. ``yticks()``) is the pyplot
     * equivalent of calling `~.Axes.get_yticks` and `~.Axes.get_yticklabels` on
     * the current axes.
     * Calling this function with arguments is the pyplot equivalent of calling
     * `~.Axes.set_yticks` and `~.Axes.set_yticklabels` on the current axes.
     * 
     * @param ticks array-like, optional<br>
     *              The list of ytick locations.  Passing an empty list removes all yticks.
     * @param labels array-like, optional<br>
     *               The labels to place at the given <b>ticks</b>0 locations.  This argument can
     *               only be passed if<b>ticks</b>5ticks* is passed as well.
     * @param **kwargs <br>
     *                 `.Text` properties can be used to control the appearance of the labels.
     * 
     * @return (locs,labels) (,)<br>
     *          The list of ytick locations.
     *          
     *          The list of ylabel `.Text` objects.
     */
    public final Object yticks(Object... args) {
        write("plt.yticks("+(args!=null ? PythonGrammar.toPythonArgs(args) : "")+")");
        return null;
    }

}
