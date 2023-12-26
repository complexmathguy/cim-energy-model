import React, { Component } from 'react'
import MechanicalLoadUserDefinedService from '../services/MechanicalLoadUserDefinedService'

class ListMechanicalLoadUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                mechanicalLoadUserDefineds: []
        }
        this.addMechanicalLoadUserDefined = this.addMechanicalLoadUserDefined.bind(this);
        this.editMechanicalLoadUserDefined = this.editMechanicalLoadUserDefined.bind(this);
        this.deleteMechanicalLoadUserDefined = this.deleteMechanicalLoadUserDefined.bind(this);
    }

    deleteMechanicalLoadUserDefined(id){
        MechanicalLoadUserDefinedService.deleteMechanicalLoadUserDefined(id).then( res => {
            this.setState({mechanicalLoadUserDefineds: this.state.mechanicalLoadUserDefineds.filter(mechanicalLoadUserDefined => mechanicalLoadUserDefined.mechanicalLoadUserDefinedId !== id)});
        });
    }
    viewMechanicalLoadUserDefined(id){
        this.props.history.push(`/view-mechanicalLoadUserDefined/${id}`);
    }
    editMechanicalLoadUserDefined(id){
        this.props.history.push(`/add-mechanicalLoadUserDefined/${id}`);
    }

    componentDidMount(){
        MechanicalLoadUserDefinedService.getMechanicalLoadUserDefineds().then((res) => {
            this.setState({ mechanicalLoadUserDefineds: res.data});
        });
    }

    addMechanicalLoadUserDefined(){
        this.props.history.push('/add-mechanicalLoadUserDefined/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">MechanicalLoadUserDefined List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addMechanicalLoadUserDefined}> Add MechanicalLoadUserDefined</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Proprietary </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.mechanicalLoadUserDefineds.map(
                                        mechanicalLoadUserDefined => 
                                        <tr key = {mechanicalLoadUserDefined.mechanicalLoadUserDefinedId}>
                                             <td> { mechanicalLoadUserDefined.proprietary } </td>
                                             <td>
                                                 <button onClick={ () => this.editMechanicalLoadUserDefined(mechanicalLoadUserDefined.mechanicalLoadUserDefinedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteMechanicalLoadUserDefined(mechanicalLoadUserDefined.mechanicalLoadUserDefinedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewMechanicalLoadUserDefined(mechanicalLoadUserDefined.mechanicalLoadUserDefinedId)} className="btn btn-info btn-sm">View </button>
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

export default ListMechanicalLoadUserDefinedComponent
