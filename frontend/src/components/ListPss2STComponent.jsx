import React, { Component } from 'react'
import Pss2STService from '../services/Pss2STService'

class ListPss2STComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pss2STs: []
        }
        this.addPss2ST = this.addPss2ST.bind(this);
        this.editPss2ST = this.editPss2ST.bind(this);
        this.deletePss2ST = this.deletePss2ST.bind(this);
    }

    deletePss2ST(id){
        Pss2STService.deletePss2ST(id).then( res => {
            this.setState({pss2STs: this.state.pss2STs.filter(pss2ST => pss2ST.pss2STId !== id)});
        });
    }
    viewPss2ST(id){
        this.props.history.push(`/view-pss2ST/${id}`);
    }
    editPss2ST(id){
        this.props.history.push(`/add-pss2ST/${id}`);
    }

    componentDidMount(){
        Pss2STService.getPss2STs().then((res) => {
            this.setState({ pss2STs: res.data});
        });
    }

    addPss2ST(){
        this.props.history.push('/add-pss2ST/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Pss2ST List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPss2ST}> Add Pss2ST</button>
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
                                    <th> Lsmax </th>
                                    <th> Lsmin </th>
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
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.pss2STs.map(
                                        pss2ST => 
                                        <tr key = {pss2ST.pss2STId}>
                                             <td> { pss2ST.inputSignal1Type } </td>
                                             <td> { pss2ST.inputSignal2Type } </td>
                                             <td> { pss2ST.k1 } </td>
                                             <td> { pss2ST.k2 } </td>
                                             <td> { pss2ST.lsmax } </td>
                                             <td> { pss2ST.lsmin } </td>
                                             <td> { pss2ST.t1 } </td>
                                             <td> { pss2ST.t10 } </td>
                                             <td> { pss2ST.t2 } </td>
                                             <td> { pss2ST.t3 } </td>
                                             <td> { pss2ST.t4 } </td>
                                             <td> { pss2ST.t5 } </td>
                                             <td> { pss2ST.t6 } </td>
                                             <td> { pss2ST.t7 } </td>
                                             <td> { pss2ST.t8 } </td>
                                             <td> { pss2ST.t9 } </td>
                                             <td> { pss2ST.vcl } </td>
                                             <td> { pss2ST.vcu } </td>
                                             <td>
                                                 <button onClick={ () => this.editPss2ST(pss2ST.pss2STId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePss2ST(pss2ST.pss2STId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPss2ST(pss2ST.pss2STId)} className="btn btn-info btn-sm">View </button>
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

export default ListPss2STComponent
