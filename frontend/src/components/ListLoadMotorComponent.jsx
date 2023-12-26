import React, { Component } from 'react'
import LoadMotorService from '../services/LoadMotorService'

class ListLoadMotorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                loadMotors: []
        }
        this.addLoadMotor = this.addLoadMotor.bind(this);
        this.editLoadMotor = this.editLoadMotor.bind(this);
        this.deleteLoadMotor = this.deleteLoadMotor.bind(this);
    }

    deleteLoadMotor(id){
        LoadMotorService.deleteLoadMotor(id).then( res => {
            this.setState({loadMotors: this.state.loadMotors.filter(loadMotor => loadMotor.loadMotorId !== id)});
        });
    }
    viewLoadMotor(id){
        this.props.history.push(`/view-loadMotor/${id}`);
    }
    editLoadMotor(id){
        this.props.history.push(`/add-loadMotor/${id}`);
    }

    componentDidMount(){
        LoadMotorService.getLoadMotors().then((res) => {
            this.setState({ loadMotors: res.data});
        });
    }

    addLoadMotor(){
        this.props.history.push('/add-loadMotor/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">LoadMotor List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addLoadMotor}> Add LoadMotor</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> D </th>
                                    <th> H </th>
                                    <th> Lfac </th>
                                    <th> Lp </th>
                                    <th> Lpp </th>
                                    <th> Ls </th>
                                    <th> Pfrac </th>
                                    <th> Ra </th>
                                    <th> Tbkr </th>
                                    <th> Tpo </th>
                                    <th> Tppo </th>
                                    <th> Tv </th>
                                    <th> Vt </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.loadMotors.map(
                                        loadMotor => 
                                        <tr key = {loadMotor.loadMotorId}>
                                             <td> { loadMotor.d } </td>
                                             <td> { loadMotor.h } </td>
                                             <td> { loadMotor.lfac } </td>
                                             <td> { loadMotor.lp } </td>
                                             <td> { loadMotor.lpp } </td>
                                             <td> { loadMotor.ls } </td>
                                             <td> { loadMotor.pfrac } </td>
                                             <td> { loadMotor.ra } </td>
                                             <td> { loadMotor.tbkr } </td>
                                             <td> { loadMotor.tpo } </td>
                                             <td> { loadMotor.tppo } </td>
                                             <td> { loadMotor.tv } </td>
                                             <td> { loadMotor.vt } </td>
                                             <td>
                                                 <button onClick={ () => this.editLoadMotor(loadMotor.loadMotorId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteLoadMotor(loadMotor.loadMotorId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewLoadMotor(loadMotor.loadMotorId)} className="btn btn-info btn-sm">View </button>
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

export default ListLoadMotorComponent
