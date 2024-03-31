// 导入主视图
const Layouts = () => import("@/layouts/index.vue")

export const staticRoutes = [
  {
    path: "/login",
    component: () => import("@/layouts/pages/login/index.vue"),
    meta: {
      hidden: true
    }
  },
  {
    path: "/register",
    component: () => import("@/layouts/pages/reg/index.vue"),
    meta: {
      hidden: true
    }
  },
  {
    path: "/",
    component: Layouts,
    redirect: "/dashboard",
    children: [
      {
        path: "dashboard",
        component: () => import("@/views/dashboard/index.vue"),
        name: "Dashboard",
        meta: {
          title: "首页",
          svgIcon: "dashboard",
          affix: true
        }
      },
      {
        path: "person",
        component: () => import("@/views/person/index.vue"),
        name: "Person",
        meta: {
          title: "个人设置",
          svgIcon: "person",
          affix: true
        }
      },
      {
        path: "files",
        component: () => import("@/views/cloud/index.vue"),
        name: "Files",
        meta: {
          title: "云盘主页",
          svgIcon: "files",
          affix: true
        }
      }
    ]
  },
  {
    path: "/403",
    component: () => import("@/layouts/pages/error/403.vue"),
    meta: {
      hidden: true
    }
  },
  {
    path: "/404",
    component: () => import("@/layouts/pages/error/403.vue"),
    meta: {
      hidden: true
    },
    alias: "/:pathMatch(.*)*"
  },
]
