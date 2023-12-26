import React, { Component } from 'react'
import TapChangerTablePointService from '../services/TapChangerTablePointService'

class ListTapChangerTablePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                tapChangerTablePoints: []
        }
        this.addTapChangerTablePoint = this.addTapChangerTablePoint.bind(this);
        this.editTapChangerTablePoint = this.editTapChangerTablePoint.bind(this);
        this.deleteTapChangerTablePoint = this.deleteTapChangerTablePoint.bind(this);
    }

    deleteTapChangerTablePoint(id){
        TapChangerTablePointService.deleteTapChangerTablePoint(id).then( res => {
            this.setState({tapChangerTablePoints: this.state.tapChangerTablePoints.filter(tapChangerTablePoint => tapChangerTablePoint.tapChangerTablePointId !== id)});
        });
    }
    viewTapChangerTablePoint(id){
        this.props.history.push(`/view-tapChangerTablePoint/${id}`);
    }
    editTapChangerTablePoint(id){
        this.props.history.push(`/add-tapChangerTablePoint/${id}`);
    }

    componentDidMount(){
        TapChangerTablePointService.getTapChangerTablePoints().then((res) => {
            this.setState({ tapChangerTablePoints: res.data});
        });
    }

    addTapChangerTablePoint(){
        this.props.history.push('/add-tapChangerTablePoint/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">TapChangerTablePoint List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addTapChangerTablePoint}> Add TapChangerTablePoint</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> B </th>
                                    <th> G </th>
                                    <th> R </th>
                                    <th> Ratio </th>
                                    <th> Step </th>
                                    <th> X </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.tapChangerTablePoints.map(
                                        tapChangerTablePoint => 
                                        <tr key = {tapChangerTablePoint.tapChangerTablePointId}>
                                             <td> { tapChangerTablePoint.b } </td>
                                             <td> { tapChangerTablePoint.g } </td>
                                             <td> { tapChangerTablePoint.r } </td>
                                             <td> { tapChangerTablePoint.ratio } </td>
                                             <td> { tapChangerTablePoint.step } </td>
                                             <td> { tapChangerTablePoint.x } </td>
                                             <td>
                                                 <button onClick={ () => this.editTapChangerTablePoint(tapChangerTablePoint.tapChangerTablePointId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteTapChangerTablePoint(tapChangerTablePoint.tapChangerTablePointId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewTapChangerTablePoint(tapChangerTablePoint.tapChangerTablePointId)} className="btn btn-info btn-sm">View </button>
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

export default ListTapChangerTablePointComponent
