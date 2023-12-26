import React, { Component } from 'react'
import PssIEEE2BService from '../services/PssIEEE2BService'

class ListPssIEEE2BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pssIEEE2Bs: []
        }
        this.addPssIEEE2B = this.addPssIEEE2B.bind(this);
        this.editPssIEEE2B = this.editPssIEEE2B.bind(this);
        this.deletePssIEEE2B = this.deletePssIEEE2B.bind(this);
    }

    deletePssIEEE2B(id){
        PssIEEE2BService.deletePssIEEE2B(id).then( res => {
            this.setState({pssIEEE2Bs: this.state.pssIEEE2Bs.filter(pssIEEE2B => pssIEEE2B.pssIEEE2BId !== id)});
        });
    }
    viewPssIEEE2B(id){
        this.props.history.push(`/view-pssIEEE2B/${id}`);
    }
    editPssIEEE2B(id){
        this.props.history.push(`/add-pssIEEE2B/${id}`);
    }

    componentDidMount(){
        PssIEEE2BService.getPssIEEE2Bs().then((res) => {
            this.setState({ pssIEEE2Bs: res.data});
        });
    }

    addPssIEEE2B(){
        this.props.history.push('/add-pssIEEE2B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PssIEEE2B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPssIEEE2B}> Add PssIEEE2B</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> InputSignal1Type </th>
                                    <th> InputSignal2Type </th>
                                    <th> Ks1 </th>
                                    <th> Ks2 </th>
                                    <th> Ks3 </th>
                                    <th> M </th>
                                    <th> N </th>
                                    <th> T1 </th>
                                    <th> T10 </th>
                                    <th> T11 </th>
                                    <th> T2 </th>
                                    <th> T3 </th>
                                    <th> T4 </th>
                                    <th> T6 </th>
                                    <th> T7 </th>
                                    <th> T8 </th>
                                    <th> T9 </th>
                                    <th> Tw1 </th>
                                    <th> Tw2 </th>
                                    <th> Tw3 </th>
                                    <th> Tw4 </th>
                                    <th> Vsi1max </th>
                                    <th> Vsi1min </th>
                                    <th> Vsi2max </th>
                                    <th> Vsi2min </th>
                                    <th> Vstmax </th>
                                    <th> Vstmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.pssIEEE2Bs.map(
                                        pssIEEE2B => 
                                        <tr key = {pssIEEE2B.pssIEEE2BId}>
                                             <td> { pssIEEE2B.inputSignal1Type } </td>
                                             <td> { pssIEEE2B.inputSignal2Type } </td>
                                             <td> { pssIEEE2B.ks1 } </td>
                                             <td> { pssIEEE2B.ks2 } </td>
                                             <td> { pssIEEE2B.ks3 } </td>
                                             <td> { pssIEEE2B.m } </td>
                                             <td> { pssIEEE2B.n } </td>
                                             <td> { pssIEEE2B.t1 } </td>
                                             <td> { pssIEEE2B.t10 } </td>
                                             <td> { pssIEEE2B.t11 } </td>
                                             <td> { pssIEEE2B.t2 } </td>
                                             <td> { pssIEEE2B.t3 } </td>
                                             <td> { pssIEEE2B.t4 } </td>
                                             <td> { pssIEEE2B.t6 } </td>
                                             <td> { pssIEEE2B.t7 } </td>
                                             <td> { pssIEEE2B.t8 } </td>
                                             <td> { pssIEEE2B.t9 } </td>
                                             <td> { pssIEEE2B.tw1 } </td>
                                             <td> { pssIEEE2B.tw2 } </td>
                                             <td> { pssIEEE2B.tw3 } </td>
                                             <td> { pssIEEE2B.tw4 } </td>
                                             <td> { pssIEEE2B.vsi1max } </td>
                                             <td> { pssIEEE2B.vsi1min } </td>
                                             <td> { pssIEEE2B.vsi2max } </td>
                                             <td> { pssIEEE2B.vsi2min } </td>
                                             <td> { pssIEEE2B.vstmax } </td>
                                             <td> { pssIEEE2B.vstmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editPssIEEE2B(pssIEEE2B.pssIEEE2BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePssIEEE2B(pssIEEE2B.pssIEEE2BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPssIEEE2B(pssIEEE2B.pssIEEE2BId)} className="btn btn-info btn-sm">View </button>
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

export default ListPssIEEE2BComponent
