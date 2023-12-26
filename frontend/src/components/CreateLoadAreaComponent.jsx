import React, { Component } from 'react'
import LoadAreaService from '../services/LoadAreaService';

class CreateLoadAreaComponent extends Component {
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
            LoadAreaService.getLoadAreaById(this.state.id).then( (res) =>{
                let loadArea = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateLoadArea = (e) => {
        e.preventDefault();
        let loadArea = {
                loadAreaId: this.state.id,
            };
        console.log('loadArea => ' + JSON.stringify(loadArea));

        // step 5
        if(this.state.id === '_add'){
            loadArea.loadAreaId=''
            LoadAreaService.createLoadArea(loadArea).then(res =>{
                this.props.history.push('/loadAreas');
            });
        }else{
            LoadAreaService.updateLoadArea(loadArea).then( res => {
                this.props.history.push('/loadAreas');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/loadAreas');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add LoadArea</h3>
        }else{
            return <h3 className="text-center">Update LoadArea</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateLoadArea}>Save</button>
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

export default CreateLoadAreaComponent
