import React, { Component } from 'react'
import InductanceService from '../services/InductanceService'

class ListInductanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                inductances: []
        }
        this.addInductance = this.addInductance.bind(this);
        this.editInductance = this.editInductance.bind(this);
        this.deleteInductance = this.deleteInductance.bind(this);
    }

    deleteInductance(id){
        InductanceService.deleteInductance(id).then( res => {
            this.setState({inductances: this.state.inductances.filter(inductance => inductance.inductanceId !== id)});
        });
    }
    viewInductance(id){
        this.props.history.push(`/view-inductance/${id}`);
    }
    editInductance(id){
        this.props.history.push(`/add-inductance/${id}`);
    }

    componentDidMount(){
        InductanceService.getInductances().then((res) => {
            this.setState({ inductances: res.data});
        });
    }

    addInductance(){
        this.props.history.push('/add-inductance/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Inductance List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addInductance}> Add Inductance</button>
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
                                    this.state.inductances.map(
                                        inductance => 
                                        <tr key = {inductance.inductanceId}>
                                             <td> { inductance.multiplier } </td>
                                             <td> { inductance.unit } </td>
                                             <td> { inductance.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editInductance(inductance.inductanceId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteInductance(inductance.inductanceId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewInductance(inductance.inductanceId)} className="btn btn-info btn-sm">View </button>
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

export default ListInductanceComponent
