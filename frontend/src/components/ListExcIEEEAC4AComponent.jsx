import React, { Component } from 'react'
import ExcIEEEAC4AService from '../services/ExcIEEEAC4AService'

class ListExcIEEEAC4AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEAC4As: []
        }
        this.addExcIEEEAC4A = this.addExcIEEEAC4A.bind(this);
        this.editExcIEEEAC4A = this.editExcIEEEAC4A.bind(this);
        this.deleteExcIEEEAC4A = this.deleteExcIEEEAC4A.bind(this);
    }

    deleteExcIEEEAC4A(id){
        ExcIEEEAC4AService.deleteExcIEEEAC4A(id).then( res => {
            this.setState({excIEEEAC4As: this.state.excIEEEAC4As.filter(excIEEEAC4A => excIEEEAC4A.excIEEEAC4AId !== id)});
        });
    }
    viewExcIEEEAC4A(id){
        this.props.history.push(`/view-excIEEEAC4A/${id}`);
    }
    editExcIEEEAC4A(id){
        this.props.history.push(`/add-excIEEEAC4A/${id}`);
    }

    componentDidMount(){
        ExcIEEEAC4AService.getExcIEEEAC4As().then((res) => {
            this.setState({ excIEEEAC4As: res.data});
        });
    }

    addExcIEEEAC4A(){
        this.props.history.push('/add-excIEEEAC4A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEAC4A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEAC4A}> Add ExcIEEEAC4A</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Ka </th>
                                    <th> Kc </th>
                                    <th> Ta </th>
                                    <th> Tb </th>
                                    <th> Tc </th>
                                    <th> Vimax </th>
                                    <th> Vimin </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excIEEEAC4As.map(
                                        excIEEEAC4A => 
                                        <tr key = {excIEEEAC4A.excIEEEAC4AId}>
                                             <td> { excIEEEAC4A.ka } </td>
                                             <td> { excIEEEAC4A.kc } </td>
                                             <td> { excIEEEAC4A.ta } </td>
                                             <td> { excIEEEAC4A.tb } </td>
                                             <td> { excIEEEAC4A.tc } </td>
                                             <td> { excIEEEAC4A.vimax } </td>
                                             <td> { excIEEEAC4A.vimin } </td>
                                             <td> { excIEEEAC4A.vrmax } </td>
                                             <td> { excIEEEAC4A.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEAC4A(excIEEEAC4A.excIEEEAC4AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEAC4A(excIEEEAC4A.excIEEEAC4AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEAC4A(excIEEEAC4A.excIEEEAC4AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEAC4AComponent
