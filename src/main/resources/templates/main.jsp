<html>
<head>
    <title>Title</title>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <style>
        .el-header {
            background-color: #B3C0D1;
            color: #333;
            line-height: 60px;
        }

        .el-aside {
            color: #333;
        }
    </style>
    <script type="text/javascript" src="/js/vue-min.js"></script>
    <script type="text/javascript" src="/js/axios.min.js"></script>
    <!-- 引入组件库 -->
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>

</head>
<body>
<div id="app">
    <el-container style="height: 100%; border: 1px solid #23ffda">
        <el-aside width="200px" style="background-color: rgb(84, 92, 100)">
            <el-menu
                    default-active="2"
                    class="el-menu-vertical-demo"
                    @open="handleOpen"
                    @close="handleClose"
                    background-color="#545c64"
                    text-color="#fff"
                    active-text-color="#ffd04b">
                <el-submenu index="1">
                    <template slot="title">
                        <i class="el-icon-location"></i>
                        <span>导航一</span>
                    </template>
                    <el-menu-item-group>
                        <template slot="title">分组一</template>
                        <el-menu-item index="1-1">选项1</el-menu-item>
                        <el-menu-item index="1-2">选项2</el-menu-item>
                    </el-menu-item-group>
                    <el-menu-item-group title="分组2">
                        <el-menu-item index="1-3">选项3</el-menu-item>
                    </el-menu-item-group>
                    <el-submenu index="1-4">
                        <template slot="title">选项4</template>
                        <el-menu-item index="1-4-1">选项1</el-menu-item>
                    </el-submenu>
                </el-submenu>
                <el-menu-item index="2">
                    <i class="el-icon-menu"></i>
                    <span slot="title">导航二</span>
                </el-menu-item>
            </el-menu>
        </el-aside>

        <el-container>
            <el-header style="text-align: right; font-size: 12px;height: 70px">
                <div style="float: left ">
                    <el-button @click="dialogFormVisible = true" type="primary" icon="el-icon-circle-plus">新增
                    </el-button>
                    <el-button type="primary" icon="el-icon-edit">编辑</el-button>
                    <el-button type="primary" icon="el-icon-delete">删除</el-button>
                    <el-button type="primary" icon="el-icon-search">搜索</el-button>
                    <el-button type="primary">上传<i class="el-icon-upload el-icon--right"></i></el-button>
                </div>
                <el-dropdown>
                    <i class="el-icon-setting" style="margin-right: 15px"></i>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>查看</el-dropdown-item>
                        <el-dropdown-item>新增</el-dropdown-item>
                        <el-dropdown-item>删除</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
                <span>王小虎</span>
            </el-header>

            <el-main>
                <el-table
                        :data="tableData"
                        border
                        style="width: 100%;height: 100%"
                >
                    <el-table-column prop="id" label="id" width="200px">
                    </el-table-column>
                    <el-table-column prop="memberName" label="姓名" width="200px">
                    </el-table-column>
                    <el-table-column prop="memberUuid" label="uuid" width="300px">
                    </el-table-column>
                    <el-table-column prop="registerPhone" label="phone" width="300px">
                    </el-table-column>
                </el-table>
                <div style="float:right ">
                    <el-pagination
                            @current-change="handleCurrentChange"
                            background
                            layout="total,prev, pager, next"
                            :total="total">
                    </el-pagination>
                </div>
            </el-main>
        </el-container>
    </el-container>


    <el-dialog title="新增会员" :visible.sync="dialogFormVisible" width="500px">
        <el-form :model="member">
            <el-form-item label="会员姓名" :label-width="formLabelWidth">
                <el-input v-model="member.memberName" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="会员手机号" :label-width="formLabelWidth">
                <el-input v-model="member.registerPhone" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="会员性别" :label-width="formLabelWidth">
                <el-input v-model="member.gender" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="会员头像" :label-width="formLabelWidth">
                <el-input v-model="member.memberImgUrl" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="会员出生年月" :label-width="formLabelWidth">
                <el-input v-model="member.birthday" autocomplete="off"></el-input>
            </el-form-item>

        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
        </div>
    </el-dialog>

</div>
<script type="text/javascript">
    new Vue({
        el: "#app",
        data: {
            //内容
            tableData: [],
            pageNo: 1,
            pageSize: 10,
            total: 0,
            //新增表格开关
            dialogFormVisible: true,
            member: {
                memberName: '',
                registerPhone: '',
                gender: '',
                memberImgUrl: '',
                birthday: "",
            },
            formLabelWidth: "100px"

        },
        mounted() {
            // this.http(this.pageNo);
        },
        methods: {
            http(pageNo) {
                axios.post('/member/pageLists', {}, {
                    params: {
                        pageNo: pageNo,
                        pageSize: this.pageSize
                    }
                })
                    .then((res) => {
                        const {list, total} = res.data.data;
                        this.tableData = list;
                        this.total = total;
                    })
            },
            handleCurrentChange(pageNo) {
                this.http(pageNo)
            },
            handleOpen() {

            },
            handleClose() {
            }
        }
    })


</script>

</body>
</html>
