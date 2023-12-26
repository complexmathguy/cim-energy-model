import React, { Component } from 'react'
import PFVArType2IEEEPFControllerService from '../services/PFVArType2IEEEPFControllerService'

class ListPFVArType2IEEEPFControllerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pFVArType2IEEEPFControllers: []
        }
        this.addPFVArType2IEEEPFController = this.addPFVArType2IEEEPFController.bind(this);
        this.editPFVArType2IEEEPFController = this.editPFVArType2IEEEPFController.bind(this);
        this.deletePFVArType2IEEEPFController = this.deletePFVArType2IEEEPFController.bind(this);
    }

    deletePFVArType2IEEEPFController(id){
        PFVArType2IEEEPFControllerService.deletePFVArType2IEEEPFController(id).then( res => {
            this.setState({pFVArType2IEEEPFControllers: this.state.pFVArType2IEEEPFControllers.filter(pFVArType2IEEEPFController => pFVArType2IEEEPFController.pFVArType2IEEEPFControllerId !== id)});
        });
    }
    viewPFVArType2IEEEPFController(id){
        this.props.history.push(`/view-pFVArType2IEEEPFController/${id}`);
    }
    editPFVArType2IEEEPFController(id){
        this.props.history.push(`/add-pFVArType2IEEEPFController/${id}`);
    }

    componentDidMount(){
        PFVArType2IEEEPFControllerService.getPFVArType2IEEEPFControllers().then((res) => {
            this.setState({ pFVArType2IEEEPFControllers: res.data});
        });
    }

    addPFVArType2IEEEPFController(){
        this.props.history.push('/add-pFVArType2IEEEPFController/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PFVArType2IEEEPFController List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPFVArType2IEEEPFController}> Add PFVArType2IEEEPFController</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Exlon </th>
                                    <th> Ki </th>
                                    <th> Kp </th>
                                    <th> Pfref </th>
                                    <th> Vclmt </th>
                                    <th> Vref </th>
                                    <th> Vs </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.pFVArType2IEEEPFControllers.map(
                                        pFVArType2IEEEPFController => 
                                        <tr key = {pFVArType2IEEEPFController.pFVArType2IEEEPFControllerId}>
                                             <td> { pFVArType2IEEEPFController.exlon } </td>
                                             <td> { pFVArType2IEEEPFController.ki } </td>
                                             <td> { pFVArType2IEEEPFController.kp } </td>
                                             <td> { pFVArType2IEEEPFController.pfref } </td>
                                             <td> { pFVArType2IEEEPFController.vclmt } </td>
                                             <td> { pFVArType2IEEEPFController.vref } </td>
                                             <td> { pFVArType2IEEEPFController.vs } </td>
                                             <td>
                                                 <button onClick={ () => this.editPFVArType2IEEEPFController(pFVArType2IEEEPFController.pFVArType2IEEEPFControllerId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePFVArType2IEEEPFController(pFVArType2IEEEPFController.pFVArType2IEEEPFControllerId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPFVArType2IEEEPFController(pFVArType2IEEEPFController.pFVArType2IEEEPFControllerId)} className="btn btn-info btn-sm">View </button>
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

export default ListPFVArType2IEEEPFControllerComponent
