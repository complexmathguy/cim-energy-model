import React, { Component } from 'react'
import VCompIEEEType2Service from '../services/VCompIEEEType2Service'

class ListVCompIEEEType2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                vCompIEEEType2s: []
        }
        this.addVCompIEEEType2 = this.addVCompIEEEType2.bind(this);
        this.editVCompIEEEType2 = this.editVCompIEEEType2.bind(this);
        this.deleteVCompIEEEType2 = this.deleteVCompIEEEType2.bind(this);
    }

    deleteVCompIEEEType2(id){
        VCompIEEEType2Service.deleteVCompIEEEType2(id).then( res => {
            this.setState({vCompIEEEType2s: this.state.vCompIEEEType2s.filter(vCompIEEEType2 => vCompIEEEType2.vCompIEEEType2Id !== id)});
        });
    }
    viewVCompIEEEType2(id){
        this.props.history.push(`/view-vCompIEEEType2/${id}`);
    }
    editVCompIEEEType2(id){
        this.props.history.push(`/add-vCompIEEEType2/${id}`);
    }

    componentDidMount(){
        VCompIEEEType2Service.getVCompIEEEType2s().then((res) => {
            this.setState({ vCompIEEEType2s: res.data});
        });
    }

    addVCompIEEEType2(){
        this.props.history.push('/add-vCompIEEEType2/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">VCompIEEEType2 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addVCompIEEEType2}> Add VCompIEEEType2</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Tr </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.vCompIEEEType2s.map(
                                        vCompIEEEType2 => 
                                        <tr key = {vCompIEEEType2.vCompIEEEType2Id}>
                                             <td> { vCompIEEEType2.tr } </td>
                                             <td>
                                                 <button onClick={ () => this.editVCompIEEEType2(vCompIEEEType2.vCompIEEEType2Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteVCompIEEEType2(vCompIEEEType2.vCompIEEEType2Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewVCompIEEEType2(vCompIEEEType2.vCompIEEEType2Id)} className="btn btn-info btn-sm">View </button>
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

export default ListVCompIEEEType2Component
