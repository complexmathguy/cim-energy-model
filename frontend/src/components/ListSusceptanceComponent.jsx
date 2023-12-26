import React, { Component } from 'react'
import SusceptanceService from '../services/SusceptanceService'

class ListSusceptanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                susceptances: []
        }
        this.addSusceptance = this.addSusceptance.bind(this);
        this.editSusceptance = this.editSusceptance.bind(this);
        this.deleteSusceptance = this.deleteSusceptance.bind(this);
    }

    deleteSusceptance(id){
        SusceptanceService.deleteSusceptance(id).then( res => {
            this.setState({susceptances: this.state.susceptances.filter(susceptance => susceptance.susceptanceId !== id)});
        });
    }
    viewSusceptance(id){
        this.props.history.push(`/view-susceptance/${id}`);
    }
    editSusceptance(id){
        this.props.history.push(`/add-susceptance/${id}`);
    }

    componentDidMount(){
        SusceptanceService.getSusceptances().then((res) => {
            this.setState({ susceptances: res.data});
        });
    }

    addSusceptance(){
        this.props.history.push('/add-susceptance/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Susceptance List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSusceptance}> Add Susceptance</button>
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
                                    this.state.susceptances.map(
                                        susceptance => 
                                        <tr key = {susceptance.susceptanceId}>
                                             <td> { susceptance.multiplier } </td>
                                             <td> { susceptance.unit } </td>
                                             <td> { susceptance.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editSusceptance(susceptance.susceptanceId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSusceptance(susceptance.susceptanceId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSusceptance(susceptance.susceptanceId)} className="btn btn-info btn-sm">View </button>
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

export default ListSusceptanceComponent
