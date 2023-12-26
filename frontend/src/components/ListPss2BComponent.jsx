import React, { Component } from 'react'
import Pss2BService from '../services/Pss2BService'

class ListPss2BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pss2Bs: []
        }
        this.addPss2B = this.addPss2B.bind(this);
        this.editPss2B = this.editPss2B.bind(this);
        this.deletePss2B = this.deletePss2B.bind(this);
    }

    deletePss2B(id){
        Pss2BService.deletePss2B(id).then( res => {
            this.setState({pss2Bs: this.state.pss2Bs.filter(pss2B => pss2B.pss2BId !== id)});
        });
    }
    viewPss2B(id){
        this.props.history.push(`/view-pss2B/${id}`);
    }
    editPss2B(id){
        this.props.history.push(`/add-pss2B/${id}`);
    }

    componentDidMount(){
        Pss2BService.getPss2Bs().then((res) => {
            this.setState({ pss2Bs: res.data});
        });
    }

    addPss2B(){
        this.props.history.push('/add-pss2B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Pss2B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPss2B}> Add Pss2B</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> A </th>
                                    <th> InputSignal1Type </th>
                                    <th> InputSignal2Type </th>
                                    <th> Ks1 </th>
                                    <th> Ks2 </th>
                                    <th> Ks3 </th>
                                    <th> Ks4 </th>
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
                                    <th> Ta </th>
                                    <th> Tb </th>
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
                                    this.state.pss2Bs.map(
                                        pss2B => 
                                        <tr key = {pss2B.pss2BId}>
                                             <td> { pss2B.a } </td>
                                             <td> { pss2B.inputSignal1Type } </td>
                                             <td> { pss2B.inputSignal2Type } </td>
                                             <td> { pss2B.ks1 } </td>
                                             <td> { pss2B.ks2 } </td>
                                             <td> { pss2B.ks3 } </td>
                                             <td> { pss2B.ks4 } </td>
                                             <td> { pss2B.m } </td>
                                             <td> { pss2B.n } </td>
                                             <td> { pss2B.t1 } </td>
                                             <td> { pss2B.t10 } </td>
                                             <td> { pss2B.t11 } </td>
                                             <td> { pss2B.t2 } </td>
                                             <td> { pss2B.t3 } </td>
                                             <td> { pss2B.t4 } </td>
                                             <td> { pss2B.t6 } </td>
                                             <td> { pss2B.t7 } </td>
                                             <td> { pss2B.t8 } </td>
                                             <td> { pss2B.t9 } </td>
                                             <td> { pss2B.ta } </td>
                                             <td> { pss2B.tb } </td>
                                             <td> { pss2B.tw1 } </td>
                                             <td> { pss2B.tw2 } </td>
                                             <td> { pss2B.tw3 } </td>
                                             <td> { pss2B.tw4 } </td>
                                             <td> { pss2B.vsi1max } </td>
                                             <td> { pss2B.vsi1min } </td>
                                             <td> { pss2B.vsi2max } </td>
                                             <td> { pss2B.vsi2min } </td>
                                             <td> { pss2B.vstmax } </td>
                                             <td> { pss2B.vstmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editPss2B(pss2B.pss2BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePss2B(pss2B.pss2BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPss2B(pss2B.pss2BId)} className="btn btn-info btn-sm">View </button>
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

export default ListPss2BComponent
