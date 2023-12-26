import React, { Component } from 'react'
import PssIEEE1AService from '../services/PssIEEE1AService'

class ListPssIEEE1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pssIEEE1As: []
        }
        this.addPssIEEE1A = this.addPssIEEE1A.bind(this);
        this.editPssIEEE1A = this.editPssIEEE1A.bind(this);
        this.deletePssIEEE1A = this.deletePssIEEE1A.bind(this);
    }

    deletePssIEEE1A(id){
        PssIEEE1AService.deletePssIEEE1A(id).then( res => {
            this.setState({pssIEEE1As: this.state.pssIEEE1As.filter(pssIEEE1A => pssIEEE1A.pssIEEE1AId !== id)});
        });
    }
    viewPssIEEE1A(id){
        this.props.history.push(`/view-pssIEEE1A/${id}`);
    }
    editPssIEEE1A(id){
        this.props.history.push(`/add-pssIEEE1A/${id}`);
    }

    componentDidMount(){
        PssIEEE1AService.getPssIEEE1As().then((res) => {
            this.setState({ pssIEEE1As: res.data});
        });
    }

    addPssIEEE1A(){
        this.props.history.push('/add-pssIEEE1A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PssIEEE1A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPssIEEE1A}> Add PssIEEE1A</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> A1 </th>
                                    <th> A2 </th>
                                    <th> InputSignalType </th>
                                    <th> Ks </th>
                                    <th> T1 </th>
                                    <th> T2 </th>
                                    <th> T3 </th>
                                    <th> T4 </th>
                                    <th> T5 </th>
                                    <th> T6 </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.pssIEEE1As.map(
                                        pssIEEE1A => 
                                        <tr key = {pssIEEE1A.pssIEEE1AId}>
                                             <td> { pssIEEE1A.a1 } </td>
                                             <td> { pssIEEE1A.a2 } </td>
                                             <td> { pssIEEE1A.inputSignalType } </td>
                                             <td> { pssIEEE1A.ks } </td>
                                             <td> { pssIEEE1A.t1 } </td>
                                             <td> { pssIEEE1A.t2 } </td>
                                             <td> { pssIEEE1A.t3 } </td>
                                             <td> { pssIEEE1A.t4 } </td>
                                             <td> { pssIEEE1A.t5 } </td>
                                             <td> { pssIEEE1A.t6 } </td>
                                             <td> { pssIEEE1A.vrmax } </td>
                                             <td> { pssIEEE1A.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editPssIEEE1A(pssIEEE1A.pssIEEE1AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePssIEEE1A(pssIEEE1A.pssIEEE1AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPssIEEE1A(pssIEEE1A.pssIEEE1AId)} className="btn btn-info btn-sm">View </button>
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

export default ListPssIEEE1AComponent
