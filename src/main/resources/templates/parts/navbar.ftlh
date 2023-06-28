<#include "security.ftlh">
<#import "auth.ftlh" as l>

<header class="navbar navbar-expand-lg navbar-light bd-navbar sticky-top">
    <nav class="container-xxl bd-gutter flex-wrap flex-lg-nowrap">
        <a class="navbar-brand p-0 me-0 me-lg-2" href="/">
            <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-wallet2"
                 viewBox="0 0 16 16">
                <path d="M12.136.326A1.5 1.5 0 0 1 14 1.78V3h.5A1.5 1.5 0 0 1 16 4.5v9a1.5 1.5 0 0 1-1.5 1.5h-13A1.5 1.5 0 0 1 0 13.5v-9a1.5 1.5 0 0 1 1.432-1.499L12.136.326zM5.562 3H13V1.78a.5.5 0 0 0-.621-.484L5.562 3zM1.5 4a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h13a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-13z"/>
            </svg>
        </a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#bdNavbar"
                aria-controls="bdNavbar" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="bdNavbar">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link <#if springMacroRequestContext.requestUri?contains("/dashboard")>active</#if>"
                       href="/dashboard">Dashboard</a>
                </li>
                <#if isAdmin>
                    <li class="nav-item">
                        <a class="nav-link <#if springMacroRequestContext.requestUri?contains("/users")>active</#if>"
                           href="/users">User list</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <#if springMacroRequestContext.requestUri?contains("/categories")>active</#if>"
                           href="/categories">Category list</a>
                    </li>
                </#if>
            </ul>
            <ul class="navbar-nav flex-wrap ms-md-auto">
                <#if user??>
                    <li class="nav-item col-6 col-lg-auto">
                        <a href="/profile"
                           class="nav-link me-3 <#if springMacroRequestContext.requestUri?contains("/profile")>active</#if>">${name}</a>
                    </li>
                </#if>
            </ul>

            <#if user??>
                <@l.logout />
            </#if>
        </div>
    </nav>
</header>