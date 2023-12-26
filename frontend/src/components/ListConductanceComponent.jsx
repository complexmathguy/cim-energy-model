import React, { Component } from 'react'
import ConductanceService from '../services/ConductanceService'

class ListConductanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                conductances: []
        }
        this.addConductance = this.addConductance.bind(this);
        this.editConductance = this.editConductance.bind(this);
        this.deleteConductance = this.deleteConductance.bind(this);
    }

    deleteConductance(id){
        ConductanceService.deleteConductance(id).then( res => {
            this.setState({conductances: this.state.conductances.filter(conductance => conductance.conductanceId !== id)});
        });
    }
    viewConductance(id){
        this.props.history.push(`/view-conductance/${id}`);
    }
    editConductance(id){
        this.props.history.push(`/add-conductance/${id}`);
    }

    componentDidMount(){
        ConductanceService.getConductances().then((res) => {
            this.setState({ conductances: res.data});
        });
    }

    addConductance(){
        this.props.history.push('/add-conductance/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Conductance List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addConductance}> Add Conductance</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Multiplier </th>
                                    <th> Unit </th>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.conductances.map(
                                        conductance => 
                                        <tr key = {conductance.conductanceId}>
                                             <td> { conductance.multiplier } </td>
                                             <td> { conductance.unit } </td>
                                             <td> { conductance.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editConductance(conductance.conductanceId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteConductance(conductance.conductanceId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewConductance(conductance.conductanceId)} className="btn btn-info btn-sm">View </button>
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

export default ListConductanceComponent
