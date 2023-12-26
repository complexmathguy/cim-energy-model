import React, { Component } from 'react'
import PFVArType2Common1Service from '../services/PFVArType2Common1Service'

class ListPFVArType2Common1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pFVArType2Common1s: []
        }
        this.addPFVArType2Common1 = this.addPFVArType2Common1.bind(this);
        this.editPFVArType2Common1 = this.editPFVArType2Common1.bind(this);
        this.deletePFVArType2Common1 = this.deletePFVArType2Common1.bind(this);
    }

    deletePFVArType2Common1(id){
        PFVArType2Common1Service.deletePFVArType2Common1(id).then( res => {
            this.setState({pFVArType2Common1s: this.state.pFVArType2Common1s.filter(pFVArType2Common1 => pFVArType2Common1.pFVArType2Common1Id !== id)});
        });
    }
    viewPFVArType2Common1(id){
        this.props.history.push(`/view-pFVArType2Common1/${id}`);
    }
    editPFVArType2Common1(id){
        this.props.history.push(`/add-pFVArType2Common1/${id}`);
    }

    componentDidMount(){
        PFVArType2Common1Service.getPFVArType2Common1s().then((res) => {
            this.setState({ pFVArType2Common1s: res.data});
        });
    }

    addPFVArType2Common1(){
        this.props.history.push('/add-pFVArType2Common1/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PFVArType2Common1 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPFVArType2Common1}> Add PFVArType2Common1</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> J </th>
                                    <th> Ki </th>
                                    <th> Kp </th>
                                    <th> Max </th>
                                    <th> Ref </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.pFVArType2Common1s.map(
                                        pFVArType2Common1 => 
                                        <tr key = {pFVArType2Common1.pFVArType2Common1Id}>
                                             <td> { pFVArType2Common1.j } </td>
                                             <td> { pFVArType2Common1.ki } </td>
                                             <td> { pFVArType2Common1.kp } </td>
                                             <td> { pFVArType2Common1.max } </td>
                                             <td> { pFVArType2Common1.ref } </td>
                                             <td>
                                                 <button onClick={ () => this.editPFVArType2Common1(pFVArType2Common1.pFVArType2Common1Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePFVArType2Common1(pFVArType2Common1.pFVArType2Common1Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPFVArType2Common1(pFVArType2Common1.pFVArType2Common1Id)} className="btn btn-info btn-sm">View </button>
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

export default ListPFVArType2Common1Component
