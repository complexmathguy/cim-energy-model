import React, { Component } from 'react'
import UnderexcLimIEEE2Service from '../services/UnderexcLimIEEE2Service'

class ListUnderexcLimIEEE2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                underexcLimIEEE2s: []
        }
        this.addUnderexcLimIEEE2 = this.addUnderexcLimIEEE2.bind(this);
        this.editUnderexcLimIEEE2 = this.editUnderexcLimIEEE2.bind(this);
        this.deleteUnderexcLimIEEE2 = this.deleteUnderexcLimIEEE2.bind(this);
    }

    deleteUnderexcLimIEEE2(id){
        UnderexcLimIEEE2Service.deleteUnderexcLimIEEE2(id).then( res => {
            this.setState({underexcLimIEEE2s: this.state.underexcLimIEEE2s.filter(underexcLimIEEE2 => underexcLimIEEE2.underexcLimIEEE2Id !== id)});
        });
    }
    viewUnderexcLimIEEE2(id){
        this.props.history.push(`/view-underexcLimIEEE2/${id}`);
    }
    editUnderexcLimIEEE2(id){
        this.props.history.push(`/add-underexcLimIEEE2/${id}`);
    }

    componentDidMount(){
        UnderexcLimIEEE2Service.getUnderexcLimIEEE2s().then((res) => {
            this.setState({ underexcLimIEEE2s: res.data});
        });
    }

    addUnderexcLimIEEE2(){
        this.props.history.push('/add-underexcLimIEEE2/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">UnderexcLimIEEE2 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addUnderexcLimIEEE2}> Add UnderexcLimIEEE2</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> K1 </th>
                                    <th> K2 </th>
                                    <th> Kfb </th>
                                    <th> Kuf </th>
                                    <th> Kui </th>
                                    <th> Kul </th>
                                    <th> P0 </th>
                                    <th> P1 </th>
                                    <th> P10 </th>
                                    <th> P2 </th>
                                    <th> P3 </th>
                                    <th> P4 </th>
                                    <th> P5 </th>
                                    <th> P6 </th>
                                    <th> P7 </th>
                                    <th> P8 </th>
                                    <th> P9 </th>
                                    <th> Q0 </th>
                                    <th> Q1 </th>
                                    <th> Q10 </th>
                                    <th> Q2 </th>
                                    <th> Q3 </th>
                                    <th> Q4 </th>
                                    <th> Q5 </th>
                                    <th> Q6 </th>
                                    <th> Q7 </th>
                                    <th> Q8 </th>
                                    <th> Q9 </th>
                                    <th> Tu1 </th>
                                    <th> Tu2 </th>
                                    <th> Tu3 </th>
                                    <th> Tu4 </th>
                                    <th> Tul </th>
                                    <th> Tup </th>
                                    <th> Tuq </th>
                                    <th> Tuv </th>
                                    <th> Vuimax </th>
                                    <th> Vuimin </th>
                                    <th> Vulmax </th>
                                    <th> Vulmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.underexcLimIEEE2s.map(
                                        underexcLimIEEE2 => 
                                        <tr key = {underexcLimIEEE2.underexcLimIEEE2Id}>
                                             <td> { underexcLimIEEE2.k1 } </td>
                                             <td> { underexcLimIEEE2.k2 } </td>
                                             <td> { underexcLimIEEE2.kfb } </td>
                                             <td> { underexcLimIEEE2.kuf } </td>
                                             <td> { underexcLimIEEE2.kui } </td>
                                             <td> { underexcLimIEEE2.kul } </td>
                                             <td> { underexcLimIEEE2.p0 } </td>
                                             <td> { underexcLimIEEE2.p1 } </td>
                                             <td> { underexcLimIEEE2.p10 } </td>
                                             <td> { underexcLimIEEE2.p2 } </td>
                                             <td> { underexcLimIEEE2.p3 } </td>
                                             <td> { underexcLimIEEE2.p4 } </td>
                                             <td> { underexcLimIEEE2.p5 } </td>
                                             <td> { underexcLimIEEE2.p6 } </td>
                                             <td> { underexcLimIEEE2.p7 } </td>
                                             <td> { underexcLimIEEE2.p8 } </td>
                                             <td> { underexcLimIEEE2.p9 } </td>
                                             <td> { underexcLimIEEE2.q0 } </td>
                                             <td> { underexcLimIEEE2.q1 } </td>
                                             <td> { underexcLimIEEE2.q10 } </td>
                                             <td> { underexcLimIEEE2.q2 } </td>
                                             <td> { underexcLimIEEE2.q3 } </td>
                                             <td> { underexcLimIEEE2.q4 } </td>
                                             <td> { underexcLimIEEE2.q5 } </td>
                                             <td> { underexcLimIEEE2.q6 } </td>
                                             <td> { underexcLimIEEE2.q7 } </td>
                                             <td> { underexcLimIEEE2.q8 } </td>
                                             <td> { underexcLimIEEE2.q9 } </td>
                                             <td> { underexcLimIEEE2.tu1 } </td>
                                             <td> { underexcLimIEEE2.tu2 } </td>
                                             <td> { underexcLimIEEE2.tu3 } </td>
                                             <td> { underexcLimIEEE2.tu4 } </td>
                                             <td> { underexcLimIEEE2.tul } </td>
                                             <td> { underexcLimIEEE2.tup } </td>
                                             <td> { underexcLimIEEE2.tuq } </td>
                                             <td> { underexcLimIEEE2.tuv } </td>
                                             <td> { underexcLimIEEE2.vuimax } </td>
                                             <td> { underexcLimIEEE2.vuimin } </td>
                                             <td> { underexcLimIEEE2.vulmax } </td>
                                             <td> { underexcLimIEEE2.vulmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editUnderexcLimIEEE2(underexcLimIEEE2.underexcLimIEEE2Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteUnderexcLimIEEE2(underexcLimIEEE2.underexcLimIEEE2Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewUnderexcLimIEEE2(underexcLimIEEE2.underexcLimIEEE2Id)} className="btn btn-info btn-sm">View </button>
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

export default ListUnderexcLimIEEE2Component
