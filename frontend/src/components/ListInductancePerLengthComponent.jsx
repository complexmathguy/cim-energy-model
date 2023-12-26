import React, { Component } from 'react'
import InductancePerLengthService from '../services/InductancePerLengthService'

class ListInductancePerLengthComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                inductancePerLengths: []
        }
        this.addInductancePerLength = this.addInductancePerLength.bind(this);
        this.editInductancePerLength = this.editInductancePerLength.bind(this);
        this.deleteInductancePerLength = this.deleteInductancePerLength.bind(this);
    }

    deleteInductancePerLength(id){
        InductancePerLengthService.deleteInductancePerLength(id).then( res => {
            this.setState({inductancePerLengths: this.state.inductancePerLengths.filter(inductancePerLength => inductancePerLength.inductancePerLengthId !== id)});
        });
    }
    viewInductancePerLength(id){
        this.props.history.push(`/view-inductancePerLength/${id}`);
    }
    editInductancePerLength(id){
        this.props.history.push(`/add-inductancePerLength/${id}`);
    }

    componentDidMount(){
        InductancePerLengthService.getInductancePerLengths().then((res) => {
            this.setState({ inductancePerLengths: res.data});
        });
    }

    addInductancePerLength(){
        this.props.history.push('/add-inductancePerLength/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">InductancePerLength List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addInductancePerLength}> Add InductancePerLength</button>
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
                                    this.state.inductancePerLengths.map(
                                        inductancePerLength => 
                                        <tr key = {inductancePerLength.inductancePerLengthId}>
                                             <td> { inductancePerLength.denominatorMultiplier } </td>
                                             <td> { inductancePerLength.denominatorUnit } </td>
                                             <td> { inductancePerLength.multiplier } </td>
                                             <td> { inductancePerLength.unit } </td>
                                             <td> { inductancePerLength.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editInductancePerLength(inductancePerLength.inductancePerLengthId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteInductancePerLength(inductancePerLength.inductancePerLengthId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewInductancePerLength(inductancePerLength.inductancePerLengthId)} className="btn btn-info btn-sm">View </button>
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

export default ListInductancePerLengthComponent
