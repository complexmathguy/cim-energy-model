import React, { Component } from 'react'
import ExcSCRXService from '../services/ExcSCRXService'

class ListExcSCRXComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excSCRXs: []
        }
        this.addExcSCRX = this.addExcSCRX.bind(this);
        this.editExcSCRX = this.editExcSCRX.bind(this);
        this.deleteExcSCRX = this.deleteExcSCRX.bind(this);
    }

    deleteExcSCRX(id){
        ExcSCRXService.deleteExcSCRX(id).then( res => {
            this.setState({excSCRXs: this.state.excSCRXs.filter(excSCRX => excSCRX.excSCRXId !== id)});
        });
    }
    viewExcSCRX(id){
        this.props.history.push(`/view-excSCRX/${id}`);
    }
    editExcSCRX(id){
        this.props.history.push(`/add-excSCRX/${id}`);
    }

    componentDidMount(){
        ExcSCRXService.getExcSCRXs().then((res) => {
            this.setState({ excSCRXs: res.data});
        });
    }

    addExcSCRX(){
        this.props.history.push('/add-excSCRX/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcSCRX List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcSCRX}> Add ExcSCRX</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Cswitch </th>
                                    <th> Emax </th>
                                    <th> Emin </th>
                                    <th> K </th>
                                    <th> Rcrfd </th>
                                    <th> Tatb </th>
                                    <th> Tb </th>
                                    <th> Te </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excSCRXs.map(
                                        excSCRX => 
                                        <tr key = {excSCRX.excSCRXId}>
                                             <td> { excSCRX.cswitch } </td>
                                             <td> { excSCRX.emax } </td>
                                             <td> { excSCRX.emin } </td>
                                             <td> { excSCRX.k } </td>
                                             <td> { excSCRX.rcrfd } </td>
                                             <td> { excSCRX.tatb } </td>
                                             <td> { excSCRX.tb } </td>
                                             <td> { excSCRX.te } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcSCRX(excSCRX.excSCRXId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcSCRX(excSCRX.excSCRXId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcSCRX(excSCRX.excSCRXId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcSCRXComponent
