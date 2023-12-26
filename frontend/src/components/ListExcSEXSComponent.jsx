import React, { Component } from 'react'
import ExcSEXSService from '../services/ExcSEXSService'

class ListExcSEXSComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excSEXSs: []
        }
        this.addExcSEXS = this.addExcSEXS.bind(this);
        this.editExcSEXS = this.editExcSEXS.bind(this);
        this.deleteExcSEXS = this.deleteExcSEXS.bind(this);
    }

    deleteExcSEXS(id){
        ExcSEXSService.deleteExcSEXS(id).then( res => {
            this.setState({excSEXSs: this.state.excSEXSs.filter(excSEXS => excSEXS.excSEXSId !== id)});
        });
    }
    viewExcSEXS(id){
        this.props.history.push(`/view-excSEXS/${id}`);
    }
    editExcSEXS(id){
        this.props.history.push(`/add-excSEXS/${id}`);
    }

    componentDidMount(){
        ExcSEXSService.getExcSEXSs().then((res) => {
            this.setState({ excSEXSs: res.data});
        });
    }

    addExcSEXS(){
        this.props.history.push('/add-excSEXS/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcSEXS List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcSEXS}> Add ExcSEXS</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Efdmax </th>
                                    <th> Efdmin </th>
                                    <th> Emax </th>
                                    <th> Emin </th>
                                    <th> K </th>
                                    <th> Kc </th>
                                    <th> Tatb </th>
                                    <th> Tb </th>
                                    <th> Tc </th>
                                    <th> Te </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excSEXSs.map(
                                        excSEXS => 
                                        <tr key = {excSEXS.excSEXSId}>
                                             <td> { excSEXS.efdmax } </td>
                                             <td> { excSEXS.efdmin } </td>
                                             <td> { excSEXS.emax } </td>
                                             <td> { excSEXS.emin } </td>
                                             <td> { excSEXS.k } </td>
                                             <td> { excSEXS.kc } </td>
                                             <td> { excSEXS.tatb } </td>
                                             <td> { excSEXS.tb } </td>
                                             <td> { excSEXS.tc } </td>
                                             <td> { excSEXS.te } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcSEXS(excSEXS.excSEXSId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcSEXS(excSEXS.excSEXSId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcSEXS(excSEXS.excSEXSId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcSEXSComponent
