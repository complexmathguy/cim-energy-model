import React, { Component } from 'react'
import PhaseTapChangerTableService from '../services/PhaseTapChangerTableService';

class CreatePhaseTapChangerTableComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PhaseTapChangerTableService.getPhaseTapChangerTableById(this.state.id).then( (res) =>{
                let phaseTapChangerTable = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePhaseTapChangerTable = (e) => {
        e.preventDefault();
        let phaseTapChangerTable = {
                phaseTapChangerTableId: this.state.id,
            };
        console.log('phaseTapChangerTable => ' + JSON.stringify(phaseTapChangerTable));

        // step 5
        if(this.state.id === '_add'){
            phaseTapChangerTable.phaseTapChangerTableId=''
            PhaseTapChangerTableService.createPhaseTapChangerTable(phaseTapChangerTable).then(res =>{
                this.props.history.push('/phaseTapChangerTables');
            });
        }else{
            PhaseTapChangerTableService.updatePhaseTapChangerTable(phaseTapChangerTable).then( res => {
                this.props.history.push('/phaseTapChangerTables');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/phaseTapChangerTables');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PhaseTapChangerTable</h3>
        }else{
            return <h3 className="text-center">Update PhaseTapChangerTable</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePhaseTapChangerTable}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                   </div>
            </div>
        )
    }
}

export default CreatePhaseTapChangerTableComponent
