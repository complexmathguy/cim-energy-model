import React, { Component } from 'react'
import ResistancePerLengthService from '../services/ResistancePerLengthService'

class ListResistancePerLengthComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                resistancePerLengths: []
        }
        this.addResistancePerLength = this.addResistancePerLength.bind(this);
        this.editResistancePerLength = this.editResistancePerLength.bind(this);
        this.deleteResistancePerLength = this.deleteResistancePerLength.bind(this);
    }

    deleteResistancePerLength(id){
        ResistancePerLengthService.deleteResistancePerLength(id).then( res => {
            this.setState({resistancePerLengths: this.state.resistancePerLengths.filter(resistancePerLength => resistancePerLength.resistancePerLengthId !== id)});
        });
    }
    viewResistancePerLength(id){
        this.props.history.push(`/view-resistancePerLength/${id}`);
    }
    editResistancePerLength(id){
        this.props.history.push(`/add-resistancePerLength/${id}`);
    }

    componentDidMount(){
        ResistancePerLengthService.getResistancePerLengths().then((res) => {
            this.setState({ resistancePerLengths: res.data});
        });
    }

    addResistancePerLength(){
        this.props.history.push('/add-resistancePerLength/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ResistancePerLength List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addResistancePerLength}> Add ResistancePerLength</button>
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
                                    this.state.resistancePerLengths.map(
                                        resistancePerLength => 
                                        <tr key = {resistancePerLength.resistancePerLengthId}>
                                             <td> { resistancePerLength.denominatorMultiplier } </td>
                                             <td> { resistancePerLength.denominatorUnit } </td>
                                             <td> { resistancePerLength.multiplier } </td>
                                             <td> { resistancePerLength.unit } </td>
                                             <td> { resistancePerLength.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editResistancePerLength(resistancePerLength.resistancePerLengthId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteResistancePerLength(resistancePerLength.resistancePerLengthId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewResistancePerLength(resistancePerLength.resistancePerLengthId)} className="btn btn-info btn-sm">View </button>
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

export default ListResistancePerLengthComponent
