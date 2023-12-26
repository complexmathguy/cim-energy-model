import React, { Component } from 'react'
import OverexcLimX2Service from '../services/OverexcLimX2Service'

class ListOverexcLimX2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                overexcLimX2s: []
        }
        this.addOverexcLimX2 = this.addOverexcLimX2.bind(this);
        this.editOverexcLimX2 = this.editOverexcLimX2.bind(this);
        this.deleteOverexcLimX2 = this.deleteOverexcLimX2.bind(this);
    }

    deleteOverexcLimX2(id){
        OverexcLimX2Service.deleteOverexcLimX2(id).then( res => {
            this.setState({overexcLimX2s: this.state.overexcLimX2s.filter(overexcLimX2 => overexcLimX2.overexcLimX2Id !== id)});
        });
    }
    viewOverexcLimX2(id){
        this.props.history.push(`/view-overexcLimX2/${id}`);
    }
    editOverexcLimX2(id){
        this.props.history.push(`/add-overexcLimX2/${id}`);
    }

    componentDidMount(){
        OverexcLimX2Service.getOverexcLimX2s().then((res) => {
            this.setState({ overexcLimX2s: res.data});
        });
    }

    addOverexcLimX2(){
        this.props.history.push('/add-overexcLimX2/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">OverexcLimX2 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addOverexcLimX2}> Add OverexcLimX2</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Efd1 </th>
                                    <th> Efd2 </th>
                                    <th> Efd3 </th>
                                    <th> Efddes </th>
                                    <th> Efdrated </th>
                                    <th> Kmx </th>
                                    <th> M </th>
                                    <th> T1 </th>
                                    <th> T2 </th>
                                    <th> T3 </th>
                                    <th> Vlow </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.overexcLimX2s.map(
                                        overexcLimX2 => 
                                        <tr key = {overexcLimX2.overexcLimX2Id}>
                                             <td> { overexcLimX2.efd1 } </td>
                                             <td> { overexcLimX2.efd2 } </td>
                                             <td> { overexcLimX2.efd3 } </td>
                                             <td> { overexcLimX2.efddes } </td>
                                             <td> { overexcLimX2.efdrated } </td>
                                             <td> { overexcLimX2.kmx } </td>
                                             <td> { overexcLimX2.m } </td>
                                             <td> { overexcLimX2.t1 } </td>
                                             <td> { overexcLimX2.t2 } </td>
                                             <td> { overexcLimX2.t3 } </td>
                                             <td> { overexcLimX2.vlow } </td>
                                             <td>
                                                 <button onClick={ () => this.editOverexcLimX2(overexcLimX2.overexcLimX2Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteOverexcLimX2(overexcLimX2.overexcLimX2Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewOverexcLimX2(overexcLimX2.overexcLimX2Id)} className="btn btn-info btn-sm">View </button>
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

export default ListOverexcLimX2Component
