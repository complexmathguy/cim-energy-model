import React, { Component } from 'react'
import PssSHService from '../services/PssSHService'

class ListPssSHComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pssSHs: []
        }
        this.addPssSH = this.addPssSH.bind(this);
        this.editPssSH = this.editPssSH.bind(this);
        this.deletePssSH = this.deletePssSH.bind(this);
    }

    deletePssSH(id){
        PssSHService.deletePssSH(id).then( res => {
            this.setState({pssSHs: this.state.pssSHs.filter(pssSH => pssSH.pssSHId !== id)});
        });
    }
    viewPssSH(id){
        this.props.history.push(`/view-pssSH/${id}`);
    }
    editPssSH(id){
        this.props.history.push(`/add-pssSH/${id}`);
    }

    componentDidMount(){
        PssSHService.getPssSHs().then((res) => {
            this.setState({ pssSHs: res.data});
        });
    }

    addPssSH(){
        this.props.history.push('/add-pssSH/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PssSH List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPssSH}> Add PssSH</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> K </th>
                                    <th> K0 </th>
                                    <th> K1 </th>
                                    <th> K2 </th>
                                    <th> K3 </th>
                                    <th> K4 </th>
                                    <th> T1 </th>
                                    <th> T2 </th>
                                    <th> T3 </th>
                                    <th> T4 </th>
                                    <th> Td </th>
                                    <th> Vsmax </th>
                                    <th> Vsmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.pssSHs.map(
                                        pssSH => 
                                        <tr key = {pssSH.pssSHId}>
                                             <td> { pssSH.k } </td>
                                             <td> { pssSH.k0 } </td>
                                             <td> { pssSH.k1 } </td>
                                             <td> { pssSH.k2 } </td>
                                             <td> { pssSH.k3 } </td>
                                             <td> { pssSH.k4 } </td>
                                             <td> { pssSH.t1 } </td>
                                             <td> { pssSH.t2 } </td>
                                             <td> { pssSH.t3 } </td>
                                             <td> { pssSH.t4 } </td>
                                             <td> { pssSH.td } </td>
                                             <td> { pssSH.vsmax } </td>
                                             <td> { pssSH.vsmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editPssSH(pssSH.pssSHId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePssSH(pssSH.pssSHId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPssSH(pssSH.pssSHId)} className="btn btn-info btn-sm">View </button>
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

export default ListPssSHComponent
