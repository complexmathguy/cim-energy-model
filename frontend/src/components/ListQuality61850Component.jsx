import React, { Component } from 'react'
import Quality61850Service from '../services/Quality61850Service'

class ListQuality61850Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                quality61850s: []
        }
        this.addQuality61850 = this.addQuality61850.bind(this);
        this.editQuality61850 = this.editQuality61850.bind(this);
        this.deleteQuality61850 = this.deleteQuality61850.bind(this);
    }

    deleteQuality61850(id){
        Quality61850Service.deleteQuality61850(id).then( res => {
            this.setState({quality61850s: this.state.quality61850s.filter(quality61850 => quality61850.quality61850Id !== id)});
        });
    }
    viewQuality61850(id){
        this.props.history.push(`/view-quality61850/${id}`);
    }
    editQuality61850(id){
        this.props.history.push(`/add-quality61850/${id}`);
    }

    componentDidMount(){
        Quality61850Service.getQuality61850s().then((res) => {
            this.setState({ quality61850s: res.data});
        });
    }

    addQuality61850(){
        this.props.history.push('/add-quality61850/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Quality61850 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addQuality61850}> Add Quality61850</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> BadReference </th>
                                    <th> EstimatorReplaced </th>
                                    <th> Failure </th>
                                    <th> OldData </th>
                                    <th> OperatorBlocked </th>
                                    <th> Oscillatory </th>
                                    <th> OutOfRange </th>
                                    <th> OverFlow </th>
                                    <th> Source </th>
                                    <th> Suspect </th>
                                    <th> Test </th>
                                    <th> Validity </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.quality61850s.map(
                                        quality61850 => 
                                        <tr key = {quality61850.quality61850Id}>
                                             <td> { quality61850.badReference } </td>
                                             <td> { quality61850.estimatorReplaced } </td>
                                             <td> { quality61850.failure } </td>
                                             <td> { quality61850.oldData } </td>
                                             <td> { quality61850.operatorBlocked } </td>
                                             <td> { quality61850.oscillatory } </td>
                                             <td> { quality61850.outOfRange } </td>
                                             <td> { quality61850.overFlow } </td>
                                             <td> { quality61850.source } </td>
                                             <td> { quality61850.suspect } </td>
                                             <td> { quality61850.test } </td>
                                             <td> { quality61850.validity } </td>
                                             <td>
                                                 <button onClick={ () => this.editQuality61850(quality61850.quality61850Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteQuality61850(quality61850.quality61850Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewQuality61850(quality61850.quality61850Id)} className="btn btn-info btn-sm">View </button>
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

export default ListQuality61850Component
