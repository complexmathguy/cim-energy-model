import React, { Component } from 'react'
import CapacitanceService from '../services/CapacitanceService'

class ListCapacitanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                capacitances: []
        }
        this.addCapacitance = this.addCapacitance.bind(this);
        this.editCapacitance = this.editCapacitance.bind(this);
        this.deleteCapacitance = this.deleteCapacitance.bind(this);
    }

    deleteCapacitance(id){
        CapacitanceService.deleteCapacitance(id).then( res => {
            this.setState({capacitances: this.state.capacitances.filter(capacitance => capacitance.capacitanceId !== id)});
        });
    }
    viewCapacitance(id){
        this.props.history.push(`/view-capacitance/${id}`);
    }
    editCapacitance(id){
        this.props.history.push(`/add-capacitance/${id}`);
    }

    componentDidMount(){
        CapacitanceService.getCapacitances().then((res) => {
            this.setState({ capacitances: res.data});
        });
    }

    addCapacitance(){
        this.props.history.push('/add-capacitance/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Capacitance List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addCapacitance}> Add Capacitance</button>
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
                                    this.state.capacitances.map(
                                        capacitance => 
                                        <tr key = {capacitance.capacitanceId}>
                                             <td> { capacitance.multiplier } </td>
                                             <td> { capacitance.unit } </td>
                                             <td> { capacitance.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editCapacitance(capacitance.capacitanceId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteCapacitance(capacitance.capacitanceId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewCapacitance(capacitance.capacitanceId)} className="btn btn-info btn-sm">View </button>
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

export default ListCapacitanceComponent
