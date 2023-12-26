import React, { Component } from 'react'
import ACDCConverterService from '../services/ACDCConverterService'

class ListACDCConverterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                aCDCConverters: []
        }
        this.addACDCConverter = this.addACDCConverter.bind(this);
        this.editACDCConverter = this.editACDCConverter.bind(this);
        this.deleteACDCConverter = this.deleteACDCConverter.bind(this);
    }

    deleteACDCConverter(id){
        ACDCConverterService.deleteACDCConverter(id).then( res => {
            this.setState({aCDCConverters: this.state.aCDCConverters.filter(aCDCConverter => aCDCConverter.aCDCConverterId !== id)});
        });
    }
    viewACDCConverter(id){
        this.props.history.push(`/view-aCDCConverter/${id}`);
    }
    editACDCConverter(id){
        this.props.history.push(`/add-aCDCConverter/${id}`);
    }

    componentDidMount(){
        ACDCConverterService.getACDCConverters().then((res) => {
            this.setState({ aCDCConverters: res.data});
        });
    }

    addACDCConverter(){
        this.props.history.push('/add-aCDCConverter/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ACDCConverter List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addACDCConverter}> Add ACDCConverter</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> BaseS </th>
                                    <th> IdleLoss </th>
                                    <th> MaxUdc </th>
                                    <th> MinUdc </th>
                                    <th> NumberOfValves </th>
                                    <th> RatedUdc </th>
                                    <th> ResistiveLoss </th>
                                    <th> SwitchingLoss </th>
                                    <th> ValveU0 </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.aCDCConverters.map(
                                        aCDCConverter => 
                                        <tr key = {aCDCConverter.aCDCConverterId}>
                                             <td> { aCDCConverter.baseS } </td>
                                             <td> { aCDCConverter.idleLoss } </td>
                                             <td> { aCDCConverter.maxUdc } </td>
                                             <td> { aCDCConverter.minUdc } </td>
                                             <td> { aCDCConverter.numberOfValves } </td>
                                             <td> { aCDCConverter.ratedUdc } </td>
                                             <td> { aCDCConverter.resistiveLoss } </td>
                                             <td> { aCDCConverter.switchingLoss } </td>
                                             <td> { aCDCConverter.valveU0 } </td>
                                             <td>
                                                 <button onClick={ () => this.editACDCConverter(aCDCConverter.aCDCConverterId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteACDCConverter(aCDCConverter.aCDCConverterId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewACDCConverter(aCDCConverter.aCDCConverterId)} className="btn btn-info btn-sm">View </button>
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

export default ListACDCConverterComponent
