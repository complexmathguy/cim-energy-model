import React, { Component } from 'react'
import ConformLoadGroupService from '../services/ConformLoadGroupService'

class ListConformLoadGroupComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                conformLoadGroups: []
        }
        this.addConformLoadGroup = this.addConformLoadGroup.bind(this);
        this.editConformLoadGroup = this.editConformLoadGroup.bind(this);
        this.deleteConformLoadGroup = this.deleteConformLoadGroup.bind(this);
    }

    deleteConformLoadGroup(id){
        ConformLoadGroupService.deleteConformLoadGroup(id).then( res => {
            this.setState({conformLoadGroups: this.state.conformLoadGroups.filter(conformLoadGroup => conformLoadGroup.conformLoadGroupId !== id)});
        });
    }
    viewConformLoadGroup(id){
        this.props.history.push(`/view-conformLoadGroup/${id}`);
    }
    editConformLoadGroup(id){
        this.props.history.push(`/add-conformLoadGroup/${id}`);
    }

    componentDidMount(){
        ConformLoadGroupService.getConformLoadGroups().then((res) => {
            this.setState({ conformLoadGroups: res.data});
        });
    }

    addConformLoadGroup(){
        this.props.history.push('/add-conformLoadGroup/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ConformLoadGroup List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addConformLoadGroup}> Add ConformLoadGroup</button>
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
                                    this.state.conformLoadGroups.map(
                                        conformLoadGroup => 
                                        <tr key = {conformLoadGroup.conformLoadGroupId}>
                                             <td>
                                                 <button onClick={ () => this.editConformLoadGroup(conformLoadGroup.conformLoadGroupId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteConformLoadGroup(conformLoadGroup.conformLoadGroupId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewConformLoadGroup(conformLoadGroup.conformLoadGroupId)} className="btn btn-info btn-sm">View </button>
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

export default ListConformLoadGroupComponent
