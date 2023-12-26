import React, { Component } from 'react'
import AsynchronousMachineTimeConstantReactanceService from '../services/AsynchronousMachineTimeConstantReactanceService'

class ListAsynchronousMachineTimeConstantReactanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                asynchronousMachineTimeConstantReactances: []
        }
        this.addAsynchronousMachineTimeConstantReactance = this.addAsynchronousMachineTimeConstantReactance.bind(this);
        this.editAsynchronousMachineTimeConstantReactance = this.editAsynchronousMachineTimeConstantReactance.bind(this);
        this.deleteAsynchronousMachineTimeConstantReactance = this.deleteAsynchronousMachineTimeConstantReactance.bind(this);
    }

    deleteAsynchronousMachineTimeConstantReactance(id){
        AsynchronousMachineTimeConstantReactanceService.deleteAsynchronousMachineTimeConstantReactance(id).then( res => {
            this.setState({asynchronousMachineTimeConstantReactances: this.state.asynchronousMachineTimeConstantReactances.filter(asynchronousMachineTimeConstantReactance => asynchronousMachineTimeConstantReactance.asynchronousMachineTimeConstantReactanceId !== id)});
        });
    }
    viewAsynchronousMachineTimeConstantReactance(id){
        this.props.history.push(`/view-asynchronousMachineTimeConstantReactance/${id}`);
    }
    editAsynchronousMachineTimeConstantReactance(id){
        this.props.history.push(`/add-asynchronousMachineTimeConstantReactance/${id}`);
    }

    componentDidMount(){
        AsynchronousMachineTimeConstantReactanceService.getAsynchronousMachineTimeConstantReactances().then((res) => {
            this.setState({ asynchronousMachineTimeConstantReactances: res.data});
        });
    }

    addAsynchronousMachineTimeConstantReactance(){
        this.props.history.push('/add-asynchronousMachineTimeConstantReactance/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">AsynchronousMachineTimeConstantReactance List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addAsynchronousMachineTimeConstantReactance}> Add AsynchronousMachineTimeConstantReactance</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Tpo </th>
                                    <th> Tppo </th>
                                    <th> Xp </th>
                                    <th> Xpp </th>
                                    <th> Xs </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.asynchronousMachineTimeConstantReactances.map(
                                        asynchronousMachineTimeConstantReactance => 
                                        <tr key = {asynchronousMachineTimeConstantReactance.asynchronousMachineTimeConstantReactanceId}>
                                             <td> { asynchronousMachineTimeConstantReactance.tpo } </td>
                                             <td> { asynchronousMachineTimeConstantReactance.tppo } </td>
                                             <td> { asynchronousMachineTimeConstantReactance.xp } </td>
                                             <td> { asynchronousMachineTimeConstantReactance.xpp } </td>
                                             <td> { asynchronousMachineTimeConstantReactance.xs } </td>
                                             <td>
                                                 <button onClick={ () => this.editAsynchronousMachineTimeConstantReactance(asynchronousMachineTimeConstantReactance.asynchronousMachineTimeConstantReactanceId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteAsynchronousMachineTimeConstantReactance(asynchronousMachineTimeConstantReactance.asynchronousMachineTimeConstantReactanceId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewAsynchronousMachineTimeConstantReactance(asynchronousMachineTimeConstantReactance.asynchronousMachineTimeConstantReactanceId)} className="btn btn-info btn-sm">View </button>
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

export default ListAsynchronousMachineTimeConstantReactanceComponent
