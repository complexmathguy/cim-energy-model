import React, { Component } from 'react'
import ResistanceService from '../services/ResistanceService'

class ListResistanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                resistances: []
        }
        this.addResistance = this.addResistance.bind(this);
        this.editResistance = this.editResistance.bind(this);
        this.deleteResistance = this.deleteResistance.bind(this);
    }

    deleteResistance(id){
        ResistanceService.deleteResistance(id).then( res => {
            this.setState({resistances: this.state.resistances.filter(resistance => resistance.resistanceId !== id)});
        });
    }
    viewResistance(id){
        this.props.history.push(`/view-resistance/${id}`);
    }
    editResistance(id){
        this.props.history.push(`/add-resistance/${id}`);
    }

    componentDidMount(){
        ResistanceService.getResistances().then((res) => {
            this.setState({ resistances: res.data});
        });
    }

    addResistance(){
        this.props.history.push('/add-resistance/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Resistance List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addResistance}> Add Resistance</button>
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
                                    this.state.resistances.map(
                                        resistance => 
                                        <tr key = {resistance.resistanceId}>
                                             <td> { resistance.multiplier } </td>
                                             <td> { resistance.unit } </td>
                                             <td> { resistance.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editResistance(resistance.resistanceId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteResistance(resistance.resistanceId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewResistance(resistance.resistanceId)} className="btn btn-info btn-sm">View </button>
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

export default ListResistanceComponent
