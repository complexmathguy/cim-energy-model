import React, { Component } from 'react'
import PFVArType1IEEEPFControllerService from '../services/PFVArType1IEEEPFControllerService'

class ListPFVArType1IEEEPFControllerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pFVArType1IEEEPFControllers: []
        }
        this.addPFVArType1IEEEPFController = this.addPFVArType1IEEEPFController.bind(this);
        this.editPFVArType1IEEEPFController = this.editPFVArType1IEEEPFController.bind(this);
        this.deletePFVArType1IEEEPFController = this.deletePFVArType1IEEEPFController.bind(this);
    }

    deletePFVArType1IEEEPFController(id){
        PFVArType1IEEEPFControllerService.deletePFVArType1IEEEPFController(id).then( res => {
            this.setState({pFVArType1IEEEPFControllers: this.state.pFVArType1IEEEPFControllers.filter(pFVArType1IEEEPFController => pFVArType1IEEEPFController.pFVArType1IEEEPFControllerId !== id)});
        });
    }
    viewPFVArType1IEEEPFController(id){
        this.props.history.push(`/view-pFVArType1IEEEPFController/${id}`);
    }
    editPFVArType1IEEEPFController(id){
        this.props.history.push(`/add-pFVArType1IEEEPFController/${id}`);
    }

    componentDidMount(){
        PFVArType1IEEEPFControllerService.getPFVArType1IEEEPFControllers().then((res) => {
            this.setState({ pFVArType1IEEEPFControllers: res.data});
        });
    }

    addPFVArType1IEEEPFController(){
        this.props.history.push('/add-pFVArType1IEEEPFController/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PFVArType1IEEEPFController List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPFVArType1IEEEPFController}> Add PFVArType1IEEEPFController</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Ovex </th>
                                    <th> Tpfc </th>
                                    <th> Vitmin </th>
                                    <th> Vpf </th>
                                    <th> Vpfcbw </th>
                                    <th> Vpfref </th>
                                    <th> Vvtmax </th>
                                    <th> Vvtmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.pFVArType1IEEEPFControllers.map(
                                        pFVArType1IEEEPFController => 
                                        <tr key = {pFVArType1IEEEPFController.pFVArType1IEEEPFControllerId}>
                                             <td> { pFVArType1IEEEPFController.ovex } </td>
                                             <td> { pFVArType1IEEEPFController.tpfc } </td>
                                             <td> { pFVArType1IEEEPFController.vitmin } </td>
                                             <td> { pFVArType1IEEEPFController.vpf } </td>
                                             <td> { pFVArType1IEEEPFController.vpfcbw } </td>
                                             <td> { pFVArType1IEEEPFController.vpfref } </td>
                                             <td> { pFVArType1IEEEPFController.vvtmax } </td>
                                             <td> { pFVArType1IEEEPFController.vvtmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editPFVArType1IEEEPFController(pFVArType1IEEEPFController.pFVArType1IEEEPFControllerId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePFVArType1IEEEPFController(pFVArType1IEEEPFController.pFVArType1IEEEPFControllerId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPFVArType1IEEEPFController(pFVArType1IEEEPFController.pFVArType1IEEEPFControllerId)} className="btn btn-info btn-sm">View </button>
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

export default ListPFVArType1IEEEPFControllerComponent
