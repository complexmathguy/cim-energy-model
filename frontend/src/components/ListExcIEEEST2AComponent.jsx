import React, { Component } from 'react'
import ExcIEEEST2AService from '../services/ExcIEEEST2AService'

class ListExcIEEEST2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEST2As: []
        }
        this.addExcIEEEST2A = this.addExcIEEEST2A.bind(this);
        this.editExcIEEEST2A = this.editExcIEEEST2A.bind(this);
        this.deleteExcIEEEST2A = this.deleteExcIEEEST2A.bind(this);
    }

    deleteExcIEEEST2A(id){
        ExcIEEEST2AService.deleteExcIEEEST2A(id).then( res => {
            this.setState({excIEEEST2As: this.state.excIEEEST2As.filter(excIEEEST2A => excIEEEST2A.excIEEEST2AId !== id)});
        });
    }
    viewExcIEEEST2A(id){
        this.props.history.push(`/view-excIEEEST2A/${id}`);
    }
    editExcIEEEST2A(id){
        this.props.history.push(`/add-excIEEEST2A/${id}`);
    }

    componentDidMount(){
        ExcIEEEST2AService.getExcIEEEST2As().then((res) => {
            this.setState({ excIEEEST2As: res.data});
        });
    }

    addExcIEEEST2A(){
        this.props.history.push('/add-excIEEEST2A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEST2A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEST2A}> Add ExcIEEEST2A</button>
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
                                    this.state.excIEEEST2As.map(
                                        excIEEEST2A => 
                                        <tr key = {excIEEEST2A.excIEEEST2AId}>
                                             <td> { excIEEEST2A.efdmax } </td>
                                             <td> { excIEEEST2A.ka } </td>
                                             <td> { excIEEEST2A.kc } </td>
                                             <td> { excIEEEST2A.ke } </td>
                                             <td> { excIEEEST2A.kf } </td>
                                             <td> { excIEEEST2A.ki } </td>
                                             <td> { excIEEEST2A.kp } </td>
                                             <td> { excIEEEST2A.ta } </td>
                                             <td> { excIEEEST2A.te } </td>
                                             <td> { excIEEEST2A.tf } </td>
                                             <td> { excIEEEST2A.uelin } </td>
                                             <td> { excIEEEST2A.vrmax } </td>
                                             <td> { excIEEEST2A.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEST2A(excIEEEST2A.excIEEEST2AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEST2A(excIEEEST2A.excIEEEST2AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEST2A(excIEEEST2A.excIEEEST2AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEST2AComponent
