import React, { Component } from 'react'
import UnderexcLimX1Service from '../services/UnderexcLimX1Service'

class ListUnderexcLimX1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                underexcLimX1s: []
        }
        this.addUnderexcLimX1 = this.addUnderexcLimX1.bind(this);
        this.editUnderexcLimX1 = this.editUnderexcLimX1.bind(this);
        this.deleteUnderexcLimX1 = this.deleteUnderexcLimX1.bind(this);
    }

    deleteUnderexcLimX1(id){
        UnderexcLimX1Service.deleteUnderexcLimX1(id).then( res => {
            this.setState({underexcLimX1s: this.state.underexcLimX1s.filter(underexcLimX1 => underexcLimX1.underexcLimX1Id !== id)});
        });
    }
    viewUnderexcLimX1(id){
        this.props.history.push(`/view-underexcLimX1/${id}`);
    }
    editUnderexcLimX1(id){
        this.props.history.push(`/add-underexcLimX1/${id}`);
    }

    componentDidMount(){
        UnderexcLimX1Service.getUnderexcLimX1s().then((res) => {
            this.setState({ underexcLimX1s: res.data});
        });
    }

    addUnderexcLimX1(){
        this.props.history.push('/add-underexcLimX1/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">UnderexcLimX1 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addUnderexcLimX1}> Add UnderexcLimX1</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> K </th>
                                    <th> Kf2 </th>
                                    <th> Km </th>
                                    <th> Melmax </th>
                                    <th> Tf2 </th>
                                    <th> Tm </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.underexcLimX1s.map(
                                        underexcLimX1 => 
                                        <tr key = {underexcLimX1.underexcLimX1Id}>
                                             <td> { underexcLimX1.k } </td>
                                             <td> { underexcLimX1.kf2 } </td>
                                             <td> { underexcLimX1.km } </td>
                                             <td> { underexcLimX1.melmax } </td>
                                             <td> { underexcLimX1.tf2 } </td>
                                             <td> { underexcLimX1.tm } </td>
                                             <td>
                                                 <button onClick={ () => this.editUnderexcLimX1(underexcLimX1.underexcLimX1Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteUnderexcLimX1(underexcLimX1.underexcLimX1Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewUnderexcLimX1(underexcLimX1.underexcLimX1Id)} className="btn btn-info btn-sm">View </button>
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

export default ListUnderexcLimX1Component
