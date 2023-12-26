import React, { Component } from 'react'
import PssWECCService from '../services/PssWECCService'

class ListPssWECCComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pssWECCs: []
        }
        this.addPssWECC = this.addPssWECC.bind(this);
        this.editPssWECC = this.editPssWECC.bind(this);
        this.deletePssWECC = this.deletePssWECC.bind(this);
    }

    deletePssWECC(id){
        PssWECCService.deletePssWECC(id).then( res => {
            this.setState({pssWECCs: this.state.pssWECCs.filter(pssWECC => pssWECC.pssWECCId !== id)});
        });
    }
    viewPssWECC(id){
        this.props.history.push(`/view-pssWECC/${id}`);
    }
    editPssWECC(id){
        this.props.history.push(`/add-pssWECC/${id}`);
    }

    componentDidMount(){
        PssWECCService.getPssWECCs().then((res) => {
            this.setState({ pssWECCs: res.data});
        });
    }

    addPssWECC(){
        this.props.history.push('/add-pssWECC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PssWECC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPssWECC}> Add PssWECC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> InputSignal1Type </th>
                                    <th> InputSignal2Type </th>
                                    <th> K1 </th>
                                    <th> K2 </th>
                                    <th> T1 </th>
                                    <th> T10 </th>
                                    <th> T2 </th>
                                    <th> T3 </th>
                                    <th> T4 </th>
                                    <th> T5 </th>
                                    <th> T6 </th>
                                    <th> T7 </th>
                                    <th> T8 </th>
                                    <th> T9 </th>
                                    <th> Vcl </th>
                                    <th> Vcu </th>
                                    <th> Vsmax </th>
                                    <th> Vsmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.pssWECCs.map(
                                        pssWECC => 
                                        <tr key = {pssWECC.pssWECCId}>
                                             <td> { pssWECC.inputSignal1Type } </td>
                                             <td> { pssWECC.inputSignal2Type } </td>
                                             <td> { pssWECC.k1 } </td>
                                             <td> { pssWECC.k2 } </td>
                                             <td> { pssWECC.t1 } </td>
                                             <td> { pssWECC.t10 } </td>
                                             <td> { pssWECC.t2 } </td>
                                             <td> { pssWECC.t3 } </td>
                                             <td> { pssWECC.t4 } </td>
                                             <td> { pssWECC.t5 } </td>
                                             <td> { pssWECC.t6 } </td>
                                             <td> { pssWECC.t7 } </td>
                                             <td> { pssWECC.t8 } </td>
                                             <td> { pssWECC.t9 } </td>
                                             <td> { pssWECC.vcl } </td>
                                             <td> { pssWECC.vcu } </td>
                                             <td> { pssWECC.vsmax } </td>
                                             <td> { pssWECC.vsmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editPssWECC(pssWECC.pssWECCId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePssWECC(pssWECC.pssWECCId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPssWECC(pssWECC.pssWECCId)} className="btn btn-info btn-sm">View </button>
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

export default ListPssWECCComponent
