import React, { Component } from 'react'
import ExcST2AService from '../services/ExcST2AService'

class ListExcST2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excST2As: []
        }
        this.addExcST2A = this.addExcST2A.bind(this);
        this.editExcST2A = this.editExcST2A.bind(this);
        this.deleteExcST2A = this.deleteExcST2A.bind(this);
    }

    deleteExcST2A(id){
        ExcST2AService.deleteExcST2A(id).then( res => {
            this.setState({excST2As: this.state.excST2As.filter(excST2A => excST2A.excST2AId !== id)});
        });
    }
    viewExcST2A(id){
        this.props.history.push(`/view-excST2A/${id}`);
    }
    editExcST2A(id){
        this.props.history.push(`/add-excST2A/${id}`);
    }

    componentDidMount(){
        ExcST2AService.getExcST2As().then((res) => {
            this.setState({ excST2As: res.data});
        });
    }

    addExcST2A(){
        this.props.history.push('/add-excST2A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcST2A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcST2A}> Add ExcST2A</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Efdmax </th>
                                    <th> Ka </th>
                                    <th> Kc </th>
                                    <th> Ke </th>
                                    <th> Kf </th>
                                    <th> Ki </th>
                                    <th> Kp </th>
                                    <th> Ta </th>
                                    <th> Tb </th>
                                    <th> Tc </th>
                                    <th> Te </th>
                                    <th> Tf </th>
                                    <th> Uelin </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excST2As.map(
                                        excST2A => 
                                        <tr key = {excST2A.excST2AId}>
                                             <td> { excST2A.efdmax } </td>
                                             <td> { excST2A.ka } </td>
                                             <td> { excST2A.kc } </td>
                                             <td> { excST2A.ke } </td>
                                             <td> { excST2A.kf } </td>
                                             <td> { excST2A.ki } </td>
                                             <td> { excST2A.kp } </td>
                                             <td> { excST2A.ta } </td>
                                             <td> { excST2A.tb } </td>
                                             <td> { excST2A.tc } </td>
                                             <td> { excST2A.te } </td>
                                             <td> { excST2A.tf } </td>
                                             <td> { excST2A.uelin } </td>
                                             <td> { excST2A.vrmax } </td>
                                             <td> { excST2A.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcST2A(excST2A.excST2AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcST2A(excST2A.excST2AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcST2A(excST2A.excST2AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcST2AComponent
