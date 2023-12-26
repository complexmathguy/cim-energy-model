import React, { Component } from 'react'
import NonConformLoadGroupService from '../services/NonConformLoadGroupService'

class ListNonConformLoadGroupComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                nonConformLoadGroups: []
        }
        this.addNonConformLoadGroup = this.addNonConformLoadGroup.bind(this);
        this.editNonConformLoadGroup = this.editNonConformLoadGroup.bind(this);
        this.deleteNonConformLoadGroup = this.deleteNonConformLoadGroup.bind(this);
    }

    deleteNonConformLoadGroup(id){
        NonConformLoadGroupService.deleteNonConformLoadGroup(id).then( res => {
            this.setState({nonConformLoadGroups: this.state.nonConformLoadGroups.filter(nonConformLoadGroup => nonConformLoadGroup.nonConformLoadGroupId !== id)});
        });
    }
    viewNonConformLoadGroup(id){
        this.props.history.push(`/view-nonConformLoadGroup/${id}`);
    }
    editNonConformLoadGroup(id){
        this.props.history.push(`/add-nonConformLoadGroup/${id}`);
    }

    componentDidMount(){
        NonConformLoadGroupService.getNonConformLoadGroups().then((res) => {
            this.setState({ nonConformLoadGroups: res.data});
        });
    }

    addNonConformLoadGroup(){
        this.props.history.push('/add-nonConformLoadGroup/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">NonConformLoadGroup List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addNonConformLoadGroup}> Add NonConformLoadGroup</button>
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
                                    this.state.nonConformLoadGroups.map(
                                        nonConformLoadGroup => 
                                        <tr key = {nonConformLoadGroup.nonConformLoadGroupId}>
                                             <td>
                                                 <button onClick={ () => this.editNonConformLoadGroup(nonConformLoadGroup.nonConformLoadGroupId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteNonConformLoadGroup(nonConformLoadGroup.nonConformLoadGroupId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewNonConformLoadGroup(nonConformLoadGroup.nonConformLoadGroupId)} className="btn btn-info btn-sm">View </button>
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

export default ListNonConformLoadGroupComponent
