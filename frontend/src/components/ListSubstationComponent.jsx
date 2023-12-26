import React, { Component } from 'react'
import SubstationService from '../services/SubstationService'

class ListSubstationComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                substations: []
        }
        this.addSubstation = this.addSubstation.bind(this);
        this.editSubstation = this.editSubstation.bind(this);
        this.deleteSubstation = this.deleteSubstation.bind(this);
    }

    deleteSubstation(id){
        SubstationService.deleteSubstation(id).then( res => {
            this.setState({substations: this.state.substations.filter(substation => substation.substationId !== id)});
        });
    }
    viewSubstation(id){
        this.props.history.push(`/view-substation/${id}`);
    }
    editSubstation(id){
        this.props.history.push(`/add-substation/${id}`);
    }

    componentDidMount(){
        SubstationService.getSubstations().then((res) => {
            this.setState({ substations: res.data});
        });
    }

    addSubstation(){
        this.props.history.push('/add-substation/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Substation List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSubstation}> Add Substation</button>
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
                                    this.state.substations.map(
                                        substation => 
                                        <tr key = {substation.substationId}>
                                             <td>
                                                 <button onClick={ () => this.editSubstation(substation.substationId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSubstation(substation.substationId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSubstation(substation.substationId)} className="btn btn-info btn-sm">View </button>
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

export default ListSubstationComponent
