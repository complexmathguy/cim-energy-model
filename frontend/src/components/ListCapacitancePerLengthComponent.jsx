import React, { Component } from 'react'
import CapacitancePerLengthService from '../services/CapacitancePerLengthService'

class ListCapacitancePerLengthComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                capacitancePerLengths: []
        }
        this.addCapacitancePerLength = this.addCapacitancePerLength.bind(this);
        this.editCapacitancePerLength = this.editCapacitancePerLength.bind(this);
        this.deleteCapacitancePerLength = this.deleteCapacitancePerLength.bind(this);
    }

    deleteCapacitancePerLength(id){
        CapacitancePerLengthService.deleteCapacitancePerLength(id).then( res => {
            this.setState({capacitancePerLengths: this.state.capacitancePerLengths.filter(capacitancePerLength => capacitancePerLength.capacitancePerLengthId !== id)});
        });
    }
    viewCapacitancePerLength(id){
        this.props.history.push(`/view-capacitancePerLength/${id}`);
    }
    editCapacitancePerLength(id){
        this.props.history.push(`/add-capacitancePerLength/${id}`);
    }

    componentDidMount(){
        CapacitancePerLengthService.getCapacitancePerLengths().then((res) => {
            this.setState({ capacitancePerLengths: res.data});
        });
    }

    addCapacitancePerLength(){
        this.props.history.push('/add-capacitancePerLength/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">CapacitancePerLength List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addCapacitancePerLength}> Add CapacitancePerLength</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> DenominatorMultiplier </th>
                                    <th> DenominatorUnit </th>
                                    <th> Multiplier </th>
                                    <th> Unit </th>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.capacitancePerLengths.map(
                                        capacitancePerLength => 
                                        <tr key = {capacitancePerLength.capacitancePerLengthId}>
                                             <td> { capacitancePerLength.denominatorMultiplier } </td>
                                             <td> { capacitancePerLength.denominatorUnit } </td>
                                             <td> { capacitancePerLength.multiplier } </td>
                                             <td> { capacitancePerLength.unit } </td>
                                             <td> { capacitancePerLength.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editCapacitancePerLength(capacitancePerLength.capacitancePerLengthId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteCapacitancePerLength(capacitancePerLength.capacitancePerLengthId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewCapacitancePerLength(capacitancePerLength.capacitancePerLengthId)} className="btn btn-info btn-sm">View </button>
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

export default ListCapacitancePerLengthComponent
