import React, { Component } from 'react'
import GovHydroPID2Service from '../services/GovHydroPID2Service'

class ListGovHydroPID2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydroPID2s: []
        }
        this.addGovHydroPID2 = this.addGovHydroPID2.bind(this);
        this.editGovHydroPID2 = this.editGovHydroPID2.bind(this);
        this.deleteGovHydroPID2 = this.deleteGovHydroPID2.bind(this);
    }

    deleteGovHydroPID2(id){
        GovHydroPID2Service.deleteGovHydroPID2(id).then( res => {
            this.setState({govHydroPID2s: this.state.govHydroPID2s.filter(govHydroPID2 => govHydroPID2.govHydroPID2Id !== id)});
        });
    }
    viewGovHydroPID2(id){
        this.props.history.push(`/view-govHydroPID2/${id}`);
    }
    editGovHydroPID2(id){
        this.props.history.push(`/add-govHydroPID2/${id}`);
    }

    componentDidMount(){
        GovHydroPID2Service.getGovHydroPID2s().then((res) => {
            this.setState({ govHydroPID2s: res.data});
        });
    }

    addGovHydroPID2(){
        this.props.history.push('/add-govHydroPID2/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydroPID2 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydroPID2}> Add GovHydroPID2</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Atw </th>
                                    <th> D </th>
                                    <th> FeedbackSignal </th>
                                    <th> G0 </th>
                                    <th> G1 </th>
                                    <th> G2 </th>
                                    <th> Gmax </th>
                                    <th> Gmin </th>
                                    <th> Kd </th>
                                    <th> Ki </th>
                                    <th> Kp </th>
                                    <th> Mwbase </th>
                                    <th> P1 </th>
                                    <th> P2 </th>
                                    <th> P3 </th>
                                    <th> Rperm </th>
                                    <th> Ta </th>
                                    <th> Tb </th>
                                    <th> Treg </th>
                                    <th> Tw </th>
                                    <th> Velmax </th>
                                    <th> Velmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govHydroPID2s.map(
                                        govHydroPID2 => 
                                        <tr key = {govHydroPID2.govHydroPID2Id}>
                                             <td> { govHydroPID2.atw } </td>
                                             <td> { govHydroPID2.d } </td>
                                             <td> { govHydroPID2.feedbackSignal } </td>
                                             <td> { govHydroPID2.g0 } </td>
                                             <td> { govHydroPID2.g1 } </td>
                                             <td> { govHydroPID2.g2 } </td>
                                             <td> { govHydroPID2.gmax } </td>
                                             <td> { govHydroPID2.gmin } </td>
                                             <td> { govHydroPID2.kd } </td>
                                             <td> { govHydroPID2.ki } </td>
                                             <td> { govHydroPID2.kp } </td>
                                             <td> { govHydroPID2.mwbase } </td>
                                             <td> { govHydroPID2.p1 } </td>
                                             <td> { govHydroPID2.p2 } </td>
                                             <td> { govHydroPID2.p3 } </td>
                                             <td> { govHydroPID2.rperm } </td>
                                             <td> { govHydroPID2.ta } </td>
                                             <td> { govHydroPID2.tb } </td>
                                             <td> { govHydroPID2.treg } </td>
                                             <td> { govHydroPID2.tw } </td>
                                             <td> { govHydroPID2.velmax } </td>
                                             <td> { govHydroPID2.velmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovHydroPID2(govHydroPID2.govHydroPID2Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydroPID2(govHydroPID2.govHydroPID2Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydroPID2(govHydroPID2.govHydroPID2Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydroPID2Component
