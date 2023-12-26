import React, { Component } from 'react'
import Pss1Service from '../services/Pss1Service'

class ListPss1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pss1s: []
        }
        this.addPss1 = this.addPss1.bind(this);
        this.editPss1 = this.editPss1.bind(this);
        this.deletePss1 = this.deletePss1.bind(this);
    }

    deletePss1(id){
        Pss1Service.deletePss1(id).then( res => {
            this.setState({pss1s: this.state.pss1s.filter(pss1 => pss1.pss1Id !== id)});
        });
    }
    viewPss1(id){
        this.props.history.push(`/view-pss1/${id}`);
    }
    editPss1(id){
        this.props.history.push(`/add-pss1/${id}`);
    }

    componentDidMount(){
        Pss1Service.getPss1s().then((res) => {
            this.setState({ pss1s: res.data});
        });
    }

    addPss1(){
        this.props.history.push('/add-pss1/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Pss1 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPss1}> Add Pss1</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Kf </th>
                                    <th> Kpe </th>
                                    <th> Ks </th>
                                    <th> Kw </th>
                                    <th> Pmin </th>
                                    <th> T10 </th>
                                    <th> T5 </th>
                                    <th> T6 </th>
                                    <th> T7 </th>
                                    <th> T8 </th>
                                    <th> T9 </th>
                                    <th> Tpe </th>
                                    <th> Vadat </th>
                                    <th> Vsmn </th>
                                    <th> Vsmx </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.pss1s.map(
                                        pss1 => 
                                        <tr key = {pss1.pss1Id}>
                                             <td> { pss1.kf } </td>
                                             <td> { pss1.kpe } </td>
                                             <td> { pss1.ks } </td>
                                             <td> { pss1.kw } </td>
                                             <td> { pss1.pmin } </td>
                                             <td> { pss1.t10 } </td>
                                             <td> { pss1.t5 } </td>
                                             <td> { pss1.t6 } </td>
                                             <td> { pss1.t7 } </td>
                                             <td> { pss1.t8 } </td>
                                             <td> { pss1.t9 } </td>
                                             <td> { pss1.tpe } </td>
                                             <td> { pss1.vadat } </td>
                                             <td> { pss1.vsmn } </td>
                                             <td> { pss1.vsmx } </td>
                                             <td>
                                                 <button onClick={ () => this.editPss1(pss1.pss1Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePss1(pss1.pss1Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPss1(pss1.pss1Id)} className="btn btn-info btn-sm">View </button>
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

export default ListPss1Component
