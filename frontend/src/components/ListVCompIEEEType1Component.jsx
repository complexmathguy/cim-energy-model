import React, { Component } from 'react'
import VCompIEEEType1Service from '../services/VCompIEEEType1Service'

class ListVCompIEEEType1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                vCompIEEEType1s: []
        }
        this.addVCompIEEEType1 = this.addVCompIEEEType1.bind(this);
        this.editVCompIEEEType1 = this.editVCompIEEEType1.bind(this);
        this.deleteVCompIEEEType1 = this.deleteVCompIEEEType1.bind(this);
    }

    deleteVCompIEEEType1(id){
        VCompIEEEType1Service.deleteVCompIEEEType1(id).then( res => {
            this.setState({vCompIEEEType1s: this.state.vCompIEEEType1s.filter(vCompIEEEType1 => vCompIEEEType1.vCompIEEEType1Id !== id)});
        });
    }
    viewVCompIEEEType1(id){
        this.props.history.push(`/view-vCompIEEEType1/${id}`);
    }
    editVCompIEEEType1(id){
        this.props.history.push(`/add-vCompIEEEType1/${id}`);
    }

    componentDidMount(){
        VCompIEEEType1Service.getVCompIEEEType1s().then((res) => {
            this.setState({ vCompIEEEType1s: res.data});
        });
    }

    addVCompIEEEType1(){
        this.props.history.push('/add-vCompIEEEType1/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">VCompIEEEType1 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addVCompIEEEType1}> Add VCompIEEEType1</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Rc </th>
                                    <th> Tr </th>
                                    <th> Xc </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.vCompIEEEType1s.map(
                                        vCompIEEEType1 => 
                                        <tr key = {vCompIEEEType1.vCompIEEEType1Id}>
                                             <td> { vCompIEEEType1.rc } </td>
                                             <td> { vCompIEEEType1.tr } </td>
                                             <td> { vCompIEEEType1.xc } </td>
                                             <td>
                                                 <button onClick={ () => this.editVCompIEEEType1(vCompIEEEType1.vCompIEEEType1Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteVCompIEEEType1(vCompIEEEType1.vCompIEEEType1Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewVCompIEEEType1(vCompIEEEType1.vCompIEEEType1Id)} className="btn btn-info btn-sm">View </button>
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

export default ListVCompIEEEType1Component
