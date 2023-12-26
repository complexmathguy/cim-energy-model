import React, { Component } from 'react'
import LoadGroupService from '../services/LoadGroupService'

class ListLoadGroupComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                loadGroups: []
        }
        this.addLoadGroup = this.addLoadGroup.bind(this);
        this.editLoadGroup = this.editLoadGroup.bind(this);
        this.deleteLoadGroup = this.deleteLoadGroup.bind(this);
    }

    deleteLoadGroup(id){
        LoadGroupService.deleteLoadGroup(id).then( res => {
            this.setState({loadGroups: this.state.loadGroups.filter(loadGroup => loadGroup.loadGroupId !== id)});
        });
    }
    viewLoadGroup(id){
        this.props.history.push(`/view-loadGroup/${id}`);
    }
    editLoadGroup(id){
        this.props.history.push(`/add-loadGroup/${id}`);
    }

    componentDidMount(){
        LoadGroupService.getLoadGroups().then((res) => {
            this.setState({ loadGroups: res.data});
        });
    }

    addLoadGroup(){
        this.props.history.push('/add-loadGroup/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">LoadGroup List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addLoadGroup}> Add LoadGroup</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.loadGroups.map(
                                        loadGroup => 
                                        <tr key = {loadGroup.loadGroupId}>
                                             <td>
                                                 <button onClick={ () => this.editLoadGroup(loadGroup.loadGroupId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteLoadGroup(loadGroup.loadGroupId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewLoadGroup(loadGroup.loadGroupId)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListLoadGroupComponent
