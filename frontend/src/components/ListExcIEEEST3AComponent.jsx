import React, { Component } from 'react'
import ExcIEEEST3AService from '../services/ExcIEEEST3AService'

class ListExcIEEEST3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEST3As: []
        }
        this.addExcIEEEST3A = this.addExcIEEEST3A.bind(this);
        this.editExcIEEEST3A = this.editExcIEEEST3A.bind(this);
        this.deleteExcIEEEST3A = this.deleteExcIEEEST3A.bind(this);
    }

    deleteExcIEEEST3A(id){
        ExcIEEEST3AService.deleteExcIEEEST3A(id).then( res => {
            this.setState({excIEEEST3As: this.state.excIEEEST3As.filter(excIEEEST3A => excIEEEST3A.excIEEEST3AId !== id)});
        });
    }
    viewExcIEEEST3A(id){
        this.props.history.push(`/view-excIEEEST3A/${id}`);
    }
    editExcIEEEST3A(id){
        this.props.history.push(`/add-excIEEEST3A/${id}`);
    }

    componentDidMount(){
        ExcIEEEST3AService.getExcIEEEST3As().then((res) => {
            this.setState({ excIEEEST3As: res.data});
        });
    }

    addExcIEEEST3A(){
        this.props.history.push('/add-excIEEEST3A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEST3A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEST3A}> Add ExcIEEEST3A</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Ka </th>
                                    <th> Kc </th>
                                    <th> Kg </th>
                                    <th> Ki </th>
                                    <th> Km </th>
                                    <th> Kp </th>
                                    <th> Ta </th>
                                    <th> Tb </th>
                                    <th> Tc </th>
                                    <th> Thetap </th>
                                    <th> Tm </th>
                                    <th> Vbmax </th>
                                    <th> Vgmax </th>
                                    <th> Vimax </th>
                                    <th> Vimin </th>
                                    <th> Vmmax </th>
                                    <th> Vmmin </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Xl </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excIEEEST3As.map(
                                        excIEEEST3A => 
                                        <tr key = {excIEEEST3A.excIEEEST3AId}>
                                             <td> { excIEEEST3A.ka } </td>
                                             <td> { excIEEEST3A.kc } </td>
                                             <td> { excIEEEST3A.kg } </td>
                                             <td> { excIEEEST3A.ki } </td>
                                             <td> { excIEEEST3A.km } </td>
                                             <td> { excIEEEST3A.kp } </td>
                                             <td> { excIEEEST3A.ta } </td>
                                             <td> { excIEEEST3A.tb } </td>
                                             <td> { excIEEEST3A.tc } </td>
                                             <td> { excIEEEST3A.thetap } </td>
                                             <td> { excIEEEST3A.tm } </td>
                                             <td> { excIEEEST3A.vbmax } </td>
                                             <td> { excIEEEST3A.vgmax } </td>
                                             <td> { excIEEEST3A.vimax } </td>
                                             <td> { excIEEEST3A.vimin } </td>
                                             <td> { excIEEEST3A.vmmax } </td>
                                             <td> { excIEEEST3A.vmmin } </td>
                                             <td> { excIEEEST3A.vrmax } </td>
                                             <td> { excIEEEST3A.vrmin } </td>
                                             <td> { excIEEEST3A.xl } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEST3A(excIEEEST3A.excIEEEST3AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEST3A(excIEEEST3A.excIEEEST3AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEST3A(excIEEEST3A.excIEEEST3AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEST3AComponent
