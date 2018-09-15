(function ($)
{
    var fuseAside,
        asideEl,
        isAsideCollapsed,
        isAsideFolded;

    /**
     * Expand Aside
     */
    function expandAside()
    {
        toggleBodyClass('fuse-aside-collapsed', 'fuse-aside-expanded');
        isAsideCollapsed = false;

        triggerEvent('fuse::asideExpanded', []);
    }

    /**
     * Collapse Aside
     */
    function collapeAside()
    {
        toggleBodyClass('fuse-aside-expanded', 'fuse-aside-collapsed');
        isAsideCollapsed = true;

        triggerEvent('fuse::asideCollapsed', []);
    }

    /**
     * Toggle Aside
     */
    function toggleAside()
    {
        if ( isAsideCollapsed )
        {
            fuseAside.expand();
        }
        else
        {
            fuseAside.collape();
        }
    }

    /**
     * Toggle Fold
     */
    function toggleFoldAside()
    {
        if ( !isAsideFolded )
        {
            foldAside();
        }
        else
        {
            unfoldAside();
        }
    }

    /**
     * Fold Aside
     */
    function foldAside()
    {
        if ( isAsideFolded )
        {
            return;
        }
        collapeAside();
        isAsideFolded = true;
        toggleBodyClass('', 'fuse-aside-folded');
        $('body').addClass('fuse-aside-folded');
        triggerEvent('fuse::asideFolded', []);
    }

    /**
     * Unfold Aside
     */
    function unfoldAside()
    {
        if ( !isAsideFolded )
        {
            return;
        }

        expandAside();
        isAsideFolded = false;
        toggleBodyClass('fuse-aside-folded', '');

        triggerEvent('fuse::asideUnfolded', []);
    }

    /**
     * Wait document ready to initialize
     */
    $('document').ready(function ()
    {
        initialize($('#aside'));
    });

    /**
     * Initialize
     */
    function initialize(selectorEl)
    {
        asideEl = selectorEl;
        isAsideCollapsed = true;
        isAsideFolded = false;

        fuseAside = {
            collape   : collapeAside,
            expand    : expandAside,
            toggle    : toggleAside,
            toggleFold: toggleFoldAside,
        };

        window.fuseAside = fuseAside;

        // Toggle Fold Button click handler
        $('[data-fuse-aside-toggle-fold]').on('click', function ()
        {
            toggleFoldAside();
        });

        // Expand aside while Hovering the Aside
        asideEl.on('mouseenter touchstart',function ()
        {
            if ( isAsideFolded && isAsideCollapsed )
            {
                expandAside();
            }
        });

        $(document).on('mousemove touchstart',function(e)
        {
            if (!asideEl.is(e.target) && asideEl.has(e.target).length === 0)
            {
                if ( isAsideFolded && !isAsideCollapsed )
                {
                    collapeAside();
                }
            }
        });

    }

    /**
     * Toggle Body Class Helper
     */
    function toggleBodyClass(removeClass, addClass)
    {
        $('body').removeClass(removeClass).addClass(addClass);
    }

    /**
     * Unfold the aside at the mobile media step
     */
    $(window).on('fuse::matchMediaChanged', function (ev, currentStep, isOrBelow, isOrAbove)
    {
        if ( isOrBelow('md') )
        {
            unfoldAside();
        }

    });

    /**
     * Trigger Event
     */
    function triggerEvent(event, data)
    {
        setTimeout(function ()
        {
            $(window).trigger(event, data);
        }, 300)
    }

})(jQuery);
