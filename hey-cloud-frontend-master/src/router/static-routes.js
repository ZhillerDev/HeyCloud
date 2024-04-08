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
        path: "file",
        component: () => import("@/views/cloud/index.vue"),
        name: "Files",
        meta: {
          title: "云盘主页",
          svgIcon: "files",
          affix: true
        }
      },
      {
        path: "document",
        component: () => import("@/views/cloud/document.vue"),
        name: "Document",
        meta: {
          title: "文档分类",
          svgIcon: "document",
          affix: true
        }
      },
      {
        path: "pic",
        component: () => import("@/views/cloud/pic.vue"),
        name: "Pic",
        meta: {
          title: "图片分类",
          svgIcon: "pic",
          affix: true
        }
      },
      {
        path: "other",
        component: () => import("@/views/cloud/other.vue"),
        name: "Other",
        meta: {
          title: "其他文件分类",
          svgIcon: "other",
          affix: true
        }
      },
      {
        path: "recovery",
        component: () => import("@/views/recovery/index.vue"),
        name: "Recovery",
        meta: {
          title: "回收站",
          svgIcon: "recovery",
          affix: true
        }
      },
      {
        path: "share",
        component: () => import("@/views/share/index.vue"),
        name: "Share",
        meta: {
          title: "文件分享",
          svgIcon: "Share",
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
