import React, { Component } from 'react'
import UnderexcLimX2Service from '../services/UnderexcLimX2Service'

class ListUnderexcLimX2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                underexcLimX2s: []
        }
        this.addUnderexcLimX2 = this.addUnderexcLimX2.bind(this);
        this.editUnderexcLimX2 = this.editUnderexcLimX2.bind(this);
        this.deleteUnderexcLimX2 = this.deleteUnderexcLimX2.bind(this);
    }

    deleteUnderexcLimX2(id){
        UnderexcLimX2Service.deleteUnderexcLimX2(id).then( res => {
            this.setState({underexcLimX2s: this.state.underexcLimX2s.filter(underexcLimX2 => underexcLimX2.underexcLimX2Id !== id)});
        });
    }
    viewUnderexcLimX2(id){
        this.props.history.push(`/view-underexcLimX2/${id}`);
    }
    editUnderexcLimX2(id){
        this.props.history.push(`/add-underexcLimX2/${id}`);
    }

    componentDidMount(){
        UnderexcLimX2Service.getUnderexcLimX2s().then((res) => {
            this.setState({ underexcLimX2s: res.data});
        });
    }

    addUnderexcLimX2(){
        this.props.history.push('/add-underexcLimX2/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">UnderexcLimX2 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addUnderexcLimX2}> Add UnderexcLimX2</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Kf2 </th>
                                    <th> Km </th>
                                    <th> Melmax </th>
                                    <th> Qo </th>
                                    <th> R </th>
                                    <th> Tf2 </th>
                                    <th> Tm </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.underexcLimX2s.map(
                                        underexcLimX2 => 
                                        <tr key = {underexcLimX2.underexcLimX2Id}>
                                             <td> { underexcLimX2.kf2 } </td>
                                             <td> { underexcLimX2.km } </td>
                                             <td> { underexcLimX2.melmax } </td>
                                             <td> { underexcLimX2.qo } </td>
                                             <td> { underexcLimX2.r } </td>
                                             <td> { underexcLimX2.tf2 } </td>
                                             <td> { underexcLimX2.tm } </td>
                                             <td>
                                                 <button onClick={ () => this.editUnderexcLimX2(underexcLimX2.underexcLimX2Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteUnderexcLimX2(underexcLimX2.underexcLimX2Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewUnderexcLimX2(underexcLimX2.underexcLimX2Id)} className="btn btn-info btn-sm">View </button>
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

export default ListUnderexcLimX2Component
