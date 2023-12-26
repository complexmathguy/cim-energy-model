import React, { Component } from 'react'
import StaticVarCompensatorService from '../services/StaticVarCompensatorService'

class ListStaticVarCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                staticVarCompensators: []
        }
        this.addStaticVarCompensator = this.addStaticVarCompensator.bind(this);
        this.editStaticVarCompensator = this.editStaticVarCompensator.bind(this);
        this.deleteStaticVarCompensator = this.deleteStaticVarCompensator.bind(this);
    }

    deleteStaticVarCompensator(id){
        StaticVarCompensatorService.deleteStaticVarCompensator(id).then( res => {
            this.setState({staticVarCompensators: this.state.staticVarCompensators.filter(staticVarCompensator => staticVarCompensator.staticVarCompensatorId !== id)});
        });
    }
    viewStaticVarCompensator(id){
        this.props.history.push(`/view-staticVarCompensator/${id}`);
    }
    editStaticVarCompensator(id){
        this.props.history.push(`/add-staticVarCompensator/${id}`);
    }

    componentDidMount(){
        StaticVarCompensatorService.getStaticVarCompensators().then((res) => {
            this.setState({ staticVarCompensators: res.data});
        });
    }

    addStaticVarCompensator(){
        this.props.history.push('/add-staticVarCompensator/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">StaticVarCompensator List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addStaticVarCompensator}> Add StaticVarCompensator</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> CapacitiveRating </th>
                                    <th> InductiveRating </th>
                                    <th> Slope </th>
                                    <th> SVCControlMode </th>
                                    <th> VoltageSetPoint </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.staticVarCompensators.map(
                                        staticVarCompensator => 
                                        <tr key = {staticVarCompensator.staticVarCompensatorId}>
                                             <td> { staticVarCompensator.capacitiveRating } </td>
                                             <td> { staticVarCompensator.inductiveRating } </td>
                                             <td> { staticVarCompensator.slope } </td>
                                             <td> { staticVarCompensator.sVCControlMode } </td>
                                             <td> { staticVarCompensator.voltageSetPoint } </td>
                                             <td>
                                                 <button onClick={ () => this.editStaticVarCompensator(staticVarCompensator.staticVarCompensatorId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteStaticVarCompensator(staticVarCompensator.staticVarCompensatorId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewStaticVarCompensator(staticVarCompensator.staticVarCompensatorId)} className="btn btn-info btn-sm">View </button>
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

export default ListStaticVarCompensatorComponent
